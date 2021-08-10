package com.example.UserService.amqp;

import com.example.UserService.models.dto.UserInfoListDTO;
import com.example.UserService.models.entities.User;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserInfoPublisher {
    private final RabbitTemplate rabbitTemplate;

    private final DirectExchange userInfoExchange;

    public UserInfoPublisher(RabbitTemplate rabbitTemplate, DirectExchange userInfoExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.userInfoExchange = userInfoExchange;
    }

    @Value("${sr.rabbit.routing.name}")
    private String userInfoRoutingKey;

    public void publishUserInfoMesssage(UserInfoListDTO message){


        rabbitTemplate.convertAndSend(userInfoExchange.getName(), userInfoRoutingKey, message );
        System.out.println(message);

    }
}
