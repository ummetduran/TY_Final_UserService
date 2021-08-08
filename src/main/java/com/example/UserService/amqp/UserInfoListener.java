package com.example.UserService.amqp;

import com.example.UserService.service.IUserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class UserInfoListener {
    private final IUserService userService;


    public UserInfoListener(IUserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${sr.rabbit.queue.name}")
    public void userTargetListener(Long id) {
        userService.userInfoTarget(id);
    }
}
