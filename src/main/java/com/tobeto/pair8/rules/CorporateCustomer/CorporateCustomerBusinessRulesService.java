package com.tobeto.pair8.rules.CorporateCustomer;

import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;

public interface CorporateCustomerBusinessRulesService {
 void exceptionSameTaxNo(AddCorporateCustomerRequest addCorporateCustomerRequest);


}
