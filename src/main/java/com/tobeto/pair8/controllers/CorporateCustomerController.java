package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.CorporateCustomerService;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/corporateCustomers")
@AllArgsConstructor
public class CorporateCustomerController {
    private final CorporateCustomerService corporateCustomerService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCorporateCustomerRequest addCorporateCustomerRequest){
        corporateCustomerService.add(addCorporateCustomerRequest);
    }
}