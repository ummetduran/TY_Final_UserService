package com.example.UserService.amqp;

import com.example.UserService.models.dto.UserInfoStockDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StockNotifyProducer {
    @Value("${sr.rabbit.exchange.name.stock-notify}")
    private String exchangeName;

    @Value("${sr.rabbit.routing.name.stock-notify}")
    private String routingName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(UserInfoStockDTO userInfoStockDTO){
        System.out.println("Sended : "+ userInfoStockDTO);
        rabbitTemplate.convertAndSend(exchangeName, routingName, userInfoStockDTO);

    }
}
