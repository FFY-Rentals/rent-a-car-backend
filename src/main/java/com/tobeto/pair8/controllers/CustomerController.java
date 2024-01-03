package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.CustomerService;
import com.tobeto.pair8.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.pair8.services.dtos.customer.responses.GetAllCustomerResponse;
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
    public void update(@RequestBody @Valid AddCustomerRequest addCustomerRequest) {
        customerService.add(addCustomerRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody @Valid AddCustomerRequest addCustomerRequest) {
        customerService.add(addCustomerRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetAllCustomerResponse> getAll() {
        return customerService.getAll();
    }



}
