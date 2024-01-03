package com.tobeto.pair8.services.dtos.user.requests;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateUserRequest {
@NotNull(message = "Id boş olamaz")
    private int id;
    @NotBlank(message = "İsim boş olamaz")
    private String name;

    @NotBlank(message = "Soyisim boş olamaz")
    private String surName;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;

    @NotNull(message = "Doğum tarihi boş olamaz")
    private LocalDate birthDate;


    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Şifre güçlü olmalıdır: en az bir rakam, bir büyük harf, bir küçük harf, bir özel karakter içermeli ve boşluk içermemelidir."
    )
    private String password;

    @Transient
    private String confirmPassword;
}
