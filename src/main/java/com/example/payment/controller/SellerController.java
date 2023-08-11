package com.example.payment.controller;

import com.example.payment.dto.SellerDTO;
import com.example.payment.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/seller")
    public SellerDTO createSeller(@RequestBody SellerDTO data) {
        return sellerService.createSeller(data);
    }
}
