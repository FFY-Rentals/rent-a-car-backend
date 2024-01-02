package com.tobeto.pair8.services.dtos.CorporateCustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddCorporateCustomerRequest {
    private String companyName;
    private String taxNo;
    private int userId;
}
