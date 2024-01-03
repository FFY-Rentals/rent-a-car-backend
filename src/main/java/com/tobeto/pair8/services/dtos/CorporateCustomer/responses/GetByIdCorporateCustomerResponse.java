package com.tobeto.pair8.services.dtos.CorporateCustomer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetByIdCorporateCustomerResponse {
    private String companyName;
    private String taxNo;
    private int userId;
}
