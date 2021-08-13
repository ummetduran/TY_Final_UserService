package com.example.UserService.service;


import com.example.UserService.amqp.StockNotifyProducer;
import com.example.UserService.amqp.UserInfoPublisher;
import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.models.dto.UserIdForStockDTO;
import com.example.UserService.models.dto.UserInfoListDTO;
import com.example.UserService.models.dto.UserInfoStockDTO;
import com.example.UserService.models.entities.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Service
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserInfoPublisher publisher;
    private final StockNotifyProducer stockNotifyProducer;

    public IUserServiceImpl(UserRepository userRepository, UserInfoPublisher producer, StockNotifyProducer stockNotifyProducer) {
        this.userRepository = userRepository;
        this.publisher = producer;
        this.stockNotifyProducer = stockNotifyProducer;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void getUserById(UserIdListDTO idList) {
        UserInfoListDTO userInfoList = new UserInfoListDTO();
        List<User> userList = new ArrayList();
        for(Long id : idList.getUserIdList()){
            System.out.println(id);
            Optional<User>userRecord = userRepository.findById(id);
            if(userRecord.isPresent()){
                User userInfo = userRecord.get();
                userList.add(userInfo);
            }
        }
        userInfoList.setUserInfoList(userList);
        publisher.publishUserInfoMesssage(userInfoList);


    }

    @Override
    public void getUsersForQuantityNotification(UserIdForStockDTO dto) {
        UserInfoStockDTO userInfoStockDTO = new UserInfoStockDTO();
        List<User> userList = new ArrayList<>();
        for(Long id :dto.getUserIdList()){
            Optional<User> userOptional =userRepository.findById(id);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                userList.add(user);
            }
        }
        userInfoStockDTO.setUserList(userList);
        userInfoStockDTO.setMessageType(dto.getMessageType());
        userInfoStockDTO.setProductId(dto.getProductId());
        stockNotifyProducer.sendToQueue(userInfoStockDTO);

    }


}
