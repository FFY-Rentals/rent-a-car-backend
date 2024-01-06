package com.tobeto.pair8.rules.CorporateCustomer;

import com.tobeto.pair8.repositories.CorporateCustomerRepository;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CorparateCustomerBusinessRulesMenager implements CorporateCustomerBusinessRulesService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    @Override
    public void exceptionSameTaxNo(AddCorporateCustomerRequest addCorporateCustomerRequest) {
        if (corporateCustomerRepository.existsByTaxNo(addCorporateCustomerRequest.getTaxNo())){
            throw new RuntimeException("Yazmış olduğunuş vergi numarasına ait bir firma bulunmaktadır.");


        }
    }
}
