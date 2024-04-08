package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.Responses.Login.LoginResponse;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;
import com.inclub.apibackofficeadmin.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    public Flux<UserResponse> findAllUsers();

    public Mono<User> findUserById(int id);
    
    public Mono<User> saveUser(User user);
    
   
    public Mono<Void> delete(User user);
    
    public Mono<User> findByUsername(String username);

   

    public Mono<LoginResponse> validateLogin(String username, String password);

    public Mono<Integer> recoverId( );
    
    

    
    
}
