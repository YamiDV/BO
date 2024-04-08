package com.inclub.apibackofficeadmin.api.controllers;


import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;
import com.inclub.apibackofficeadmin.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/listar","/"})
    public Mono<ResponseEntity<Flux<UserResponse>>> listarUsers() {
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findAllUsers()));
    }

    @PostMapping("/crear")
    public Mono<ResponseEntity<User>> crearUser(@RequestBody User user) {

        if (user.getCreateDate() == null) {
            user.setCreateDate(LocalDateTime.now());
        }

        if (user.getUpdateDate() == null) {
            user.setUpdateDate(LocalDateTime.now());
        }

        return userService.saveUser(user).map(u -> ResponseEntity
                
                .ok()
                .body(u)
                
        );
    }


    @GetMapping("/buscar/{id}")
    public Mono<ResponseEntity<User>> verUser(@PathVariable Integer id) {
        return userService.findUserById(id).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/username/{username}")
    public Mono<ResponseEntity<User>> verUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("editar/{id}") 
    public Mono<ResponseEntity<User>> editarUser(@RequestBody User user, @PathVariable Integer id) {
        return userService.findUserById(id).flatMap(u -> {
            u.setName(user.getName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            u.setIdRol(user.getIdRol());
            u.setNroTelf(user.getNroTelf());
            u.setProfilePicture(user.getProfilePicture());
            u.setUpdateDate(LocalDateTime.now());
            return userService.saveUser(u);
        }).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Void>> eliminarUser(@PathVariable Integer id) {
        return userService.findUserById(id).flatMap(u -> {
            return userService.delete(u).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
                    
    }


    @GetMapping("/recoverId")
    public Mono<ResponseEntity<Integer>> recoverId() {
        return userService.recoverId().map(id -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(id))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    
}



