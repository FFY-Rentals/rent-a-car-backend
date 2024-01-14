package com.tobeto.pair8.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private int userId;
}
