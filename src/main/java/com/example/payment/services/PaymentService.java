package com.example.payment.services;

import com.example.payment.dto.PaymentDTO;
import com.example.payment.entities.Payment;
import com.example.payment.entities.Seller;
import com.example.payment.repositories.PaymentRepository;
import com.example.payment.repositories.SellerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    private SellerRepository sellerRepository;

    public PaymentDTO getByPaymentCode(Long id) {
       var result = paymentRepository.findById(id);
       PaymentDTO dto = new PaymentDTO();
       return dto.toDTO(result.get());
    }

    public void updateStatusPayment(Long id, String status) {
        var result = paymentRepository.findById(id);

        if (result.isPresent()) {
            var updated = result.get();
            updated.setStatus(status);
            paymentRepository.save(updated);
        } else {
            throw new EntityNotFoundException();
        }
    }


    public boolean addPayment(Long id, List<Payment> payments) {
            Optional<Seller> sellerOptional = sellerRepository.findById(id);

            if (sellerOptional.isPresent()) {
                Seller seller = sellerOptional.get();
                for (Payment payment : payments) {
                    payment.setSeller(seller);
                    seller.getPaymentList().add(payment);
                }

                sellerRepository.save(seller);
                return true;
            } else {
                return false;
            }
    }
}
