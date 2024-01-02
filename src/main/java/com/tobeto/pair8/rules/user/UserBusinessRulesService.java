package com.tobeto.pair8.rules.user;

import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;

public interface UserBusinessRulesService {
    void userException(AddUserRequest addUserRequest);
}
