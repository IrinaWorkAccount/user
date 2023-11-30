package com.example.user.service;

import com.example.user.model.UserEntity;
import com.example.user.repository.UserRepository;

import main.java.de.mnet.dispatcher.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());

        return userRepository.save(userEntity);
    }



    public List<UserEntity> getAllUsers() {

        List<UserEntity>savedList= userRepository.findAll();
        System.out.println(savedList);
        return savedList;
    }

    public User convertToDto(UserEntity userEntity) {
        User userDto = new User();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        return userDto;
    }

    public UserEntity convertToEntity(User userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        return userEntity;
    }
}
