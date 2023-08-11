package com.example.payment.dto;

import com.example.payment.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class PaymentDTO {

    private Long payment_code;
    private String doc_payer;
    private String status;
    private Long seller_code;


    public PaymentDTO toDTO(Payment entity) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.payment_code = entity.getId();
        paymentDTO.doc_payer = entity.getDoc_payer();
        paymentDTO.status = entity.getStatus();
        paymentDTO.seller_code = entity.getSeller().getId();

        return paymentDTO;
    }

}
