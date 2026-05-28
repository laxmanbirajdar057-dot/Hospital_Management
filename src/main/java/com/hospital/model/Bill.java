package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private double consultationFee;

    private double medicineCost;

    private double testCharges;

    private double totalAmount;

    private LocalDate billDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public enum PaymentStatus {
        PENDING, PAID, CANCELLED
    }

    //Constructors
    public Bill() {}

    public Bill(Patient patient, Appointment appointment, double consultationFee,
                double medicineCost, double testCharges, LocalDate billDate) {
        this.patient = patient;
        this.appointment = appointment;
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
        this.testCharges = testCharges;
        this.totalAmount = consultationFee + medicineCost + testCharges;
        this.billDate = billDate;
    }

    //G&S
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Appointment getAppointment() { return appointment; }
    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public double getMedicineCost() { return medicineCost; }
    public void setMedicineCost(double medicineCost) { this.medicineCost = medicineCost; }

    public double getTestCharges() { return testCharges; }
    public void setTestCharges(double testCharges) { this.testCharges = testCharges; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public LocalDate getBillDate() { return billDate; }
    public void setBillDate(LocalDate billDate) { this.billDate = billDate; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    // Recalculate total
    public void recalculateTotal() {
        this.totalAmount = this.consultationFee + this.medicineCost + this.testCharges;
    }
}
