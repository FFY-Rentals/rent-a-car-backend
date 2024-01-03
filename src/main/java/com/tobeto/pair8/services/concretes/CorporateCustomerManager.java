package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.pair8.entities.concretes.CorporateCustomer;
import com.tobeto.pair8.repositories.CorporateCustomerRepository;
import com.tobeto.pair8.services.abstracts.CorporateCustomerService;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetAllCorporateCustomer;
import com.tobeto.pair8.services.dtos.CorporateCustomer.responses.GetByIdCorporateCustomerResponse;
import lombok.AllArgsConstructor;
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
    public void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        CorporateCustomer corporateCustomerToUpdate = corporateCustomerRepository.findById(updateCorporateCustomerRequest.getId()).orElseThrow();

        this.modelMapperService.forRequest().map(updateCorporateCustomerRequest, corporateCustomerToUpdate);
        corporateCustomerRepository.saveAndFlush(corporateCustomerToUpdate);
    }


    @Override
    public void delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
        CorporateCustomer corporateCustomerDelete = corporateCustomerRepository.findById(deleteCorporateCustomerRequest.getId()).orElseThrow();
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

    @Override
    public GetByIdCorporateCustomerResponse getById(int id) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id).orElseThrow();

        GetByIdCorporateCustomerResponse corporateCustomerResponse= this.modelMapperService.forResponse().map(corporateCustomer, GetByIdCorporateCustomerResponse.class);
        return corporateCustomerResponse;
    }
}
