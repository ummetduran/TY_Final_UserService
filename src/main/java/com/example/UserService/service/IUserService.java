package com.example.UserService.service;

import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.models.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface IUserService {
    User addUser(User user);
    List<User> getUserById(UserIdListDTO userIdList);

    Optional<User> userInfoTarget(Long id);
}
