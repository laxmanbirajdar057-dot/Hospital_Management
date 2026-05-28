package com.hospital.service;

import com.hospital.exception.ResourceNotFoundException;
import com.hospital.model.Appointment;
import com.hospital.model.Bill;
import com.hospital.model.Patient;
import com.hospital.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
    }

    public Bill createBill(Long patientId, Long appointmentId, Bill bill) {
        Patient patient = patientService.getPatientById(patientId);
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        bill.setPatient(patient);
        bill.setAppointment(appointment);
        bill.recalculateTotal();
        return billRepository.save(bill);
    }

    public Bill markAsPaid(Long id) {
        Bill bill = getBillById(id);
        bill.setPaymentStatus(Bill.PaymentStatus.PAID);
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByPatient(Long patientId) {
        return billRepository.findByPatientId(patientId);
    }

    public List<Bill> getByPaymentStatus(Bill.PaymentStatus status) {
        return billRepository.findByPaymentStatus(status);
    }

    public void deleteBill(Long id) {
        getBillById(id);
        billRepository.deleteById(id);
    }
}
