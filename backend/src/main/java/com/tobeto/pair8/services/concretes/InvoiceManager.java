package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.pair8.entities.concretes.Invoice;
import com.tobeto.pair8.repositories.InvoiceRepository;
import com.tobeto.pair8.services.abstracts.InvoiceService;
import com.tobeto.pair8.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair8.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair8.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair8.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import com.tobeto.pair8.services.dtos.invoice.responses.GetListInvoceResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void add(AddInvoiceRequest addInvoiceRequest){
        Invoice invoice = this.modelMapperService.forRequest().map(addInvoiceRequest, Invoice.class);
        invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice invoiceToUpdate = invoiceRepository.findById(updateInvoiceRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Fatura Id'si bulunamadı : ID" + updateInvoiceRequest));

        this.modelMapperService.forRequest().map(updateInvoiceRequest, invoiceToUpdate);

        invoiceRepository.saveAndFlush(invoiceToUpdate);
    }

    @Override
    public void delete(DeleteInvoiceRequest deleteInvoiceRequest){
        Invoice invoiceToDelete = invoiceRepository.findById(deleteInvoiceRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Fatura bulunamadı, ID" + deleteInvoiceRequest.getId()));

        invoiceRepository.delete(invoiceToDelete);


    }

    @Override
    public List<GetListInvoceResponse> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetListInvoceResponse> invoceResponses = invoices.stream()
                .map(invoice -> this.modelMapperService
                        .forResponse().map(invoice, GetListInvoceResponse.class))
                .collect(Collectors.toList());
        return invoceResponses;
    }

    @Override
    public GetByIdInvoiceResponse getById(int id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        GetByIdInvoiceResponse invoiceResponses = this.modelMapperService.forResponse().map(invoice, GetByIdInvoiceResponse.class);

        return invoiceResponses;

    }
}
