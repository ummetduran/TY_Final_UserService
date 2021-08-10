package com.example.UserService.models.dto;

import com.example.UserService.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoListDTO implements Serializable {
    List<User> userInfoList;
}
