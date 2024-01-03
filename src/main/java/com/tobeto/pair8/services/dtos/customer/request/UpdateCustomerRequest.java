package com.tobeto.pair8.services.dtos.customer.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String firstName;
    private String lastName;
    private int userId;
}
