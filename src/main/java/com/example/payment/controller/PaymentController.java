package com.example.payment.controller;

import com.example.payment.dto.PaymentDTO;
import com.example.payment.entities.Payment;
import com.example.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("payment/{payment_code}")
    public PaymentDTO getByPaymentCode(@PathVariable Long payment_code)  {
        return paymentService.getByPaymentCode(payment_code);
    }

    @PostMapping("/payment/{id}")
    public ResponseEntity<String> addPayment(@PathVariable Long id, @RequestBody List<Payment> payments) {
        boolean added = paymentService.addPayment(id, payments);

        if (added) {
            return ResponseEntity.ok("Sucess!");
        } else {
            return ResponseEntity.badRequest().body("Fail!!");
        }
    }

    @PutMapping("payment/{payment_code}/status")
    public void updateStatusPayment(Long payment_code, String status) {
        paymentService.updateStatusPayment(payment_code, status);
    }



}
