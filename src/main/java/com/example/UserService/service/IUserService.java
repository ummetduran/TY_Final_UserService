package com.example.UserService.service;

import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.models.dto.UserIdForStockDTO;
import com.example.UserService.models.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User addUser(User user);
    void getUserById(UserIdListDTO userIdList);


    void getUsersForQuantityNotification(UserIdForStockDTO dto);
}
