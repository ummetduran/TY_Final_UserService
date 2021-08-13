package com.example.UserService.amqp;

import com.example.UserService.models.dto.UserIdForStockDTO;
import com.example.UserService.service.IUserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserInfoForStockListener {
    private final IUserService userService;

    public UserInfoForStockListener(IUserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues="${user.rabbit.queues.user-info-for-stock}")
    public void listenStockInfo(UserIdForStockDTO dto){
        System.out.println(dto);
        userService.getUsersForQuantityNotification(dto);
    }
}
