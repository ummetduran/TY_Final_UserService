package com.example.UserService.models.dto;

import com.example.UserService.models.entities.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfoStockDTO implements Serializable {
    List<User> userList;
    private Long productId;
    private String messageType;

}
