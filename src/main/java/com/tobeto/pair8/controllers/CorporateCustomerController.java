package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.CorporateCustomerService;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetAllCorporateCustomer;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetByIDCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporateCustomers")
@AllArgsConstructor
public class CorporateCustomerController {
    private final CorporateCustomerService corporateCustomerService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCorporateCustomerRequest addCorporateCustomerRequest) {
        corporateCustomerService.add(addCorporateCustomerRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetAllCorporateCustomer> getAll() {
        return corporateCustomerService.getAll();
    }

    @GetMapping("/getById")
    public GetByIDCorporateCustomerResponse getById(@RequestParam @Valid int id){
        return corporateCustomerService.getById(id);
    }


    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        corporateCustomerService.update(updateCorporateCustomerRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody @Valid DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
        corporateCustomerService.delete(deleteCorporateCustomerRequest);
    }
}
