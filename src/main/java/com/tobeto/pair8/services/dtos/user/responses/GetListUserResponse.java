package com.tobeto.pair8.services.dtos.user.responses;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListUserResponse {
    @NotNull(message = "Lütfen geçerli bir İD giriniz!!!!")
    private int id;
    @NotBlank(message = "isim alanı boş olamaz!!!!")
    private String name;
    @NotBlank(message = "soyad alanı boş olamaz!!!!")
    private String surName;
    @Email(message = "Lütfen geçerli bir e-mail adresi giriniz!!!!")
    private String eMail;


}
