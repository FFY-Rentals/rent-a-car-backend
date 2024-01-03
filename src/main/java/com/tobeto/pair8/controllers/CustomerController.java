package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.CustomerService;
import com.tobeto.pair8.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.pair8.services.dtos.customer.responses.GetByIdCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCustomerRequest addCustomerRequest) {
        customerService.add(addCustomerRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody @Valid DeleteCustomerRequest deleteCustomerRequest) {
        customerService.delete(deleteCustomerRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetAllCustomerResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdCustomerResponse getById(@RequestParam @Valid int id) {
        return customerService.getById(id);
    }
}
