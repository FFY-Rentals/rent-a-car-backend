package com.tobeto.pair8.services.dtos.customer.request;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private int userId;
}
