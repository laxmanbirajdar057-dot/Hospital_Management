package com.hospital.controller;

import com.hospital.model.Bill;
import com.hospital.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillingController {

    @Autowired
    private BillingService billingService;

    
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billingService.getAllBills());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return ResponseEntity.ok(billingService.getBillById(id));
    }

    
    @PostMapping
    public ResponseEntity<Bill> createBill(
            @RequestParam Long patientId,
            @RequestParam Long appointmentId,
            @RequestBody Bill bill) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(billingService.createBill(patientId, appointmentId, bill));
    }

    
    @PutMapping("/{id}/pay")
    public ResponseEntity<Bill> markAsPaid(@PathVariable Long id) {
        return ResponseEntity.ok(billingService.markAsPaid(id));
    }

  
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getBillsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(billingService.getBillsByPatient(patientId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Bill>> getByStatus(@PathVariable Bill.PaymentStatus status) {
        return ResponseEntity.ok(billingService.getByPaymentStatus(status));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billingService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully");
    }
}
