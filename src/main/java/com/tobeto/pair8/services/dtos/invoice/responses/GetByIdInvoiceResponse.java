package com.tobeto.pair8.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdInvoiceResponse {
    private int id;
    private String invoiceNo;
    

}
