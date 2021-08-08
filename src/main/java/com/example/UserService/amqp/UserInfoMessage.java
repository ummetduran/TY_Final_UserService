package com.example.UserService.amqp;

import lombok.Data;

@Data
public class UserInfoMessage {
    private Long id;
    private String fullName;
    private String email;
}
