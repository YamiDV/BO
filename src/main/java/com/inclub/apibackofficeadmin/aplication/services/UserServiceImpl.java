package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.Mapper.Interface.UserMapper;
import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.Responses.Login.LoginResponse;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.domain.models.User;
import com.inclub.apibackofficeadmin.domain.models.UserLogin;
import com.inclub.apibackofficeadmin.infraestructure.repositories.ItemMenuRepository;
import com.inclub.apibackofficeadmin.infraestructure.repositories.UserRepository;
import com.inclub.apibackofficeadmin.security.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMenuRepository itemMenuRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public Flux<UserResponse> findAllUsers() {
        return userRepository.findAll().map(userMapper::convertToResponse);
    }

    @Override
    public Mono<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Mono<LoginResponse> validateLogin(String username, String password) {
        return userRepository.findByUserName(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .flatMap(user -> {
                    String token = jwtUtil.generateToken(user);
                    Date expiration = jwtUtil.getExpirationDateFromToken(token);
                    return itemMenuRepository.findItemsByUserId(user.getId())
                            .collectList()
                            .map(authorities -> new LoginResponse(token, expiration, authorities));
                })
                .switchIfEmpty(Mono.empty());
    }

    // Recupera el id del usuario logueado
    @Override
    public Mono<Integer> recoverId() {

        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
                .getContext().getAuthentication();
        UserLogin userLogin = (UserLogin) authentication.getPrincipal();
        String usernameString = userLogin.getUsername();
        Integer userId = Integer.parseInt(usernameString);

        return userRepository.findById(userId)
                .map(User::getId);

    }

}
