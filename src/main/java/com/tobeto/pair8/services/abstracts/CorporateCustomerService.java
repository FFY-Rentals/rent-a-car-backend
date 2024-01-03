package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetAllCorporateCustomer;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetByIdCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {
    void add(AddCorporateCustomerRequest addCorporateCustomerRequest);
    void update(UpdateCorporateCustomerRequest updateCorporateCustomrRequest);
    void delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);
     List<GetAllCorporateCustomer> getAll();

    GetByIdCorporateCustomerResponse getById(int id);
}
