package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.pair8.entities.concretes.CorporateCustomer;
import com.tobeto.pair8.repositories.CorporateCustomerRepository;
import com.tobeto.pair8.services.abstracts.CorporateCustomerService;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.DeleteCorporateCustpmerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.UpdateCorporateCustomrRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetAllCorporateCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddCorporateCustomerRequest addCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(addCorporateCustomerRequest, CorporateCustomer.class);
        corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void update(UpdateCorporateCustomrRequest updateCorporateCustomrRequest) {
        CorporateCustomer corporateCustomerUpdate = corporateCustomerRepository.findById(updateCorporateCustomrRequest.getId()).orElseThrow();
this.modelMapperService.forRequest().map(updateCorporateCustomrRequest, corporateCustomerUpdate);
corporateCustomerRepository.saveAndFlush(corporateCustomerUpdate);

    }

    @Override
    public void delete(DeleteCorporateCustpmerRequest deleteCorporateCustpmerRequest) {
        CorporateCustomer corporateCustomerDelete = corporateCustomerRepository.findById(deleteCorporateCustpmerRequest.getId()).orElseThrow();
        corporateCustomerRepository.delete(corporateCustomerDelete);
    }

    @Override
    public List<GetAllCorporateCustomer> getAll() {
        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
        List<GetAllCorporateCustomer> getAllCorporateCustomers = corporateCustomers.stream()
                .map(corporateCustomer -> this.modelMapperService
                        .forResponse().map(corporateCustomer, GetAllCorporateCustomer.class))
                .collect(Collectors.toList());
        return getAllCorporateCustomers;

    }
}
