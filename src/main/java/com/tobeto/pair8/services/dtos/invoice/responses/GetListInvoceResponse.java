package com.tobeto.pair8.services.dtos.invoice.responses;

import com.tobeto.pair8.services.dtos.rental.responses.GetByIdRentalResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListInvoceResponse {
    private String invoiceNo;
    private Float totalPrice;
    private Float discountRate;
    private Float taxRate;

    private GetByIdRentalResponse rentalId;
}
