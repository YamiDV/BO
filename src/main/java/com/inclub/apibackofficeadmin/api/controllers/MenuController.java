package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.MenuService;
import com.inclub.apibackofficeadmin.domain.models.Menu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/menu")
public class MenuController {
    
    @Autowired
    private MenuService menuService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Menu>>> listarMenu() {
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(menuService.findAllMenu()));
    }
}
