package com.tobeto.pair8.services.dtos.CorporateCustomer.requests;

import lombok.Data;

@Data
public class UpdateCorporateCustomrRequest {
    private int id;
    private String companyName;
    private String taxNo;
    private int userId;
}
