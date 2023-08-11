package com.example.payment.dto;

import com.example.payment.entities.Payment;
import com.example.payment.entities.Seller;
import lombok.*;

import java.util.List;


@Getter
@Setter

public class SellerDTO {

    private Long seller_code;
    private String name;


    public SellerDTO toDTO (Seller entity) {
        SellerDTO dto = new SellerDTO();
        dto.seller_code = entity.getId();
        dto.name = entity.getName();
        return dto;
    }
}
