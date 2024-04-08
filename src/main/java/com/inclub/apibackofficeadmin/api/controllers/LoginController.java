package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.Responses.Login.LoginResponse;
import com.inclub.apibackofficeadmin.domain.models.Dtos.UserDto;



import reactor.core.publisher.Mono;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    

    
    @PostMapping("/login")
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody UserDto user) {
        return userService.validateLogin(user.getUsername(), user.getPassword())
            .map(login -> ResponseEntity.ok().body(login))
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

   
}
