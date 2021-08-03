package com.example.UserService.service;

import com.example.UserService.models.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User addUser(User user);
    User getUserById(Long id);
}
