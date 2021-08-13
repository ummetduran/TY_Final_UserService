package com.example.UserService.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserIdForStockDTO implements Serializable {
    List<Long> userIdList;
    private Long productId;
    private String messageType;

}
