package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.pair8.entities.concretes.Customer;
import com.tobeto.pair8.repositories.CustomerRepository;
import com.tobeto.pair8.services.abstracts.CustomerService;
import com.tobeto.pair8.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.pair8.services.dtos.customer.responses.GetByIdCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customerToUpdate = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        this.modelMapperService.forRequest().map(updateCustomerRequest, customerToUpdate);
        customerRepository.saveAndFlush(customerToUpdate);

    }

    @Override
    public void delete(DeleteCustomerRequest deleteCustomerRequest) {
        Customer customerToDelete = customerRepository.findById(deleteCustomerRequest.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);

    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService
                        .forResponse().map(customer, GetAllCustomerResponse.class))
                .collect(Collectors.toList());
        return getAllCustomerResponses;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        GetByIdCustomerResponse getByIdCustomerResponse = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return getByIdCustomerResponse;
    }
}

