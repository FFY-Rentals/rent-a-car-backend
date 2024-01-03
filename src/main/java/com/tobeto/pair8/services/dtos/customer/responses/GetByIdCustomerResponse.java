package com.tobeto.pair8.services.dtos.customer.responses;

import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetByIdCustomerResponse {
    private String firstName;
    private String lastName;
    private GetListUserResponse user;
}
