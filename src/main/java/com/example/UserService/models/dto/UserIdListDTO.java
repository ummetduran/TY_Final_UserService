package com.example.UserService.models.dto;

import lombok.Data;

import java.util.List;
@Data
public class UserIdListDTO {
    List<Long> userIdList;

    @Override
    public String toString() {
        return "UserIdListDTO{" +
                "userIdList=" + userIdList +
                '}';
    }
}
