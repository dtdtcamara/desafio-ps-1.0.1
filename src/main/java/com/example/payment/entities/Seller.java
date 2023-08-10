package com.example.payment.entities;

import com.example.payment.dto.SellerDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "tb_seller")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("seller")
    private List<Payment> paymentList;

    public Seller(SellerDTO dto) {
        this.name = dto.getName();
    }
}
