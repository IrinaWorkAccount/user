package com.example.user.api.user;

import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import main.java.de.mnet.dispatcher.user.dto.User;
import main.java.de.mnet.dispatcher.user.rest.UsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UserApiImpl implements UsersApi {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<List<User>> usersGet() {
        List<User> list = userService.getAllUsers().stream()
                .map(userEntity -> userService.convertToDto(userEntity))
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> usersPost(User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
