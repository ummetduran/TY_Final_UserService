package com.example.UserService.amqp;

import com.example.UserService.models.dto.UserInfoListDTO;
import com.example.UserService.models.entities.User;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserInfoPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Value("${sr.rabbit.routing.name}")
    private String userInfoRoutingKey;

    @Value("${sr.rabbit.exchange.name}")
    private String userInfoExchange;

    public void publishUserInfoMesssage(UserInfoListDTO message){


        rabbitTemplate.convertAndSend(userInfoExchange, userInfoRoutingKey, message );
        System.out.println(message);

    }
}
