package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.DeleteCorporateCustpmerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.UpdateCorporateCustomrRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetAllCorporateCustomer;

import java.util.List;

public interface CorporateCustomerService {
    void add(AddCorporateCustomerRequest addCorporateCustomerRequest);
    void update(UpdateCorporateCustomrRequest updateCorporateCustomrRequest);
    void delete(DeleteCorporateCustpmerRequest deleteCorporateCustpmerRequest);
     List<GetAllCorporateCustomer> getAll();
}
