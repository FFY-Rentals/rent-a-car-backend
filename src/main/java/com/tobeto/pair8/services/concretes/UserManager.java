package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.pair8.entities.concretes.User;
import com.tobeto.pair8.repositories.UserRepository;
import com.tobeto.pair8.rules.user.UserBusinessRulesService;
import com.tobeto.pair8.services.abstracts.UserService;
import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair8.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair8.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    private final UserBusinessRulesService userBusinessRulesService;

    @Override
    public void add(AddUserRequest addUserRequest) {
        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User userUpdate = userRepository.findById(updateUserRequest.getId()).orElseThrow();

        this.modelMapperService.forRequest().map(updateUserRequest, userUpdate);
        userRepository.saveAndFlush(userUpdate);
    }

    @Override
    public void delete(DeleteUserRequest deleteUserRequest) {
        User userDelete = userRepository.findById(deleteUserRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        userRepository.delete(userDelete);

    }


    @Override
    public List<GetListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetListUserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetListUserResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

}
