package com.tobeto.pair8.services.dtos.CorporateCustomer.requests;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DeleteCorporateCustomerRequest {
    @Positive(message = "Lütfen geçerli bir id giriniz!!!")
    private int id;
}
