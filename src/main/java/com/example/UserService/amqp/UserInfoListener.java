package com.example.UserService.amqp;

import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.service.IUserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class UserInfoListener {
    private final IUserService userService;


    public UserInfoListener(IUserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${user.rabbit.queues.user-info}")
    public void userTargetListener(UserIdListDTO userList) {
        System.out.println(userList);
        userService.getUserById(userList);
    }
}
