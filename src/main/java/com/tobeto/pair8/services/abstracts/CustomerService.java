package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.responses.GetAllCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(DeleteCustomerRequest deleteCustomerRequest);

    List<GetAllCustomerResponse> getAll();
}
