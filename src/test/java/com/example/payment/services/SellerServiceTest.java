package com.example.payment.services;

import com.example.payment.dto.SellerDTO;
import com.example.payment.entities.Seller;
import com.example.payment.repositories.SellerRepository;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SellerServiceTest {

        @InjectMocks
        private SellerService sellerService;

        @Mock
        private SellerRepository sellerRepository;

        @Test
        void testFindByName() {
            Seller mockSeller = new Seller();
            mockSeller.setId(1l);
            mockSeller.setName("Ana");

            Mockito.when(sellerRepository.findByName("Ana"))
                    .thenReturn(mockSeller);

            var result = sellerService.findByName("Ana");

            Assertions.assertEquals(result.getName(), "Ana");
    }

}
