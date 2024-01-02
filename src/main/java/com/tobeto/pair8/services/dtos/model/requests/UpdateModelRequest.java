package com.tobeto.pair8.services.dtos.model.requests;

import com.tobeto.pair8.services.dtos.brand.responses.GetAllListBrandResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateModelRequest {
   @NotNull(message = "model id boş olamaz")
    private int id;
   @NotBlank(message = "isim boş olamaz")
    private String name;

    // private GetAllListBrandResponse brandResponse;
    //GetAllListBrandResponse'un burada ne için olduğunu anlamadığım için yoruma aldım
}
