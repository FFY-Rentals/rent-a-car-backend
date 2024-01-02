package com.tobeto.pair8.rules.user;


import com.tobeto.pair8.repositories.UserRepository;
import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@AllArgsConstructor
public class UserBusinessRulesManager implements UserBusinessRulesService {
    private final UserRepository userRepository;

    public void userException(AddUserRequest addUserRequest) {
        LocalDate now = LocalDate.now();
        LocalDate eighteenYearsAgo = now.minusYears(18);

        if (addUserRequest.getBirthDate().isAfter(eighteenYearsAgo)) {
            throw new RuntimeException("18 yaşından küçük kullanıcı eklenemez.");
        }
        if (userRepository.existsByNameAndSurName(addUserRequest.getName(), addUserRequest.getSurName()) ||
                userRepository.existsByEmail(addUserRequest.getEmail()))
            throw new RuntimeException("bu kullanıcı ile kayıt oluşturamazsın.");

        if (!addUserRequest.getPassword().equals(addUserRequest.getConfirmPassword())) {
            throw new RuntimeException("Şifreler uyuşmuyor.");
        }
    }

}
