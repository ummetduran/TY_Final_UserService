package com.example.UserService.service;


import com.example.UserService.models.entities.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public IUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }
}
