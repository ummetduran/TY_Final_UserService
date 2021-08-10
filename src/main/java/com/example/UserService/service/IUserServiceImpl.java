package com.example.UserService.service;


import com.example.UserService.amqp.UserInfoPublisher;
import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.models.entities.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

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
    public List<User> getUserById(UserIdListDTO idList) {
        List<User> userInfoList = new ArrayList<User>();
        for(Long id : idList.getUserIdList()){
            userInfoList.add(userRepository.getById(id));
        }

        return userInfoList;
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
