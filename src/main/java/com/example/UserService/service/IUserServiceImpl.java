package com.example.UserService.service;


import com.example.UserService.amqp.UserInfoPublisher;
import com.example.UserService.models.entities.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserInfoPublisher publisher;

    public IUserServiceImpl(UserRepository userRepository, UserInfoPublisher producer) {
        this.userRepository = userRepository;
        this.publisher = producer;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Optional<User> userInfoTarget(Long id) {
        User sendUser = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            sendUser = user.get();
        }
        publisher.publishUserInfoMesssage(sendUser);
        return userRepository.findById(id);
    }
}
