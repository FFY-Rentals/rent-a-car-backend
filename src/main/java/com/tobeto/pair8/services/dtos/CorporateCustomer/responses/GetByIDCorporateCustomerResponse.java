package com.tobeto.pair8.services.dtos.CorporateCustomer.responses;

import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetByIDCorporateCustomerResponse {
    private String companyName;
    private String taxNo;
    private GetListUserResponse user;
}
