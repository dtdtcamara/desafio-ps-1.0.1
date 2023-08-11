package com.example.payment.services;

import com.example.payment.dto.SellerDTO;
import com.example.payment.entities.Seller;
import com.example.payment.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerDTO createSeller(SellerDTO data) {
        Seller sellerToEntity = new Seller(data);
        sellerRepository.save(sellerToEntity);
        return findByName(data.getName());
    }

    public SellerDTO findByName(String name) {
       var seller = sellerRepository.findByName(name);
       SellerDTO sellerdto = new SellerDTO();
       return sellerdto.toDTO(seller);
    }




}
