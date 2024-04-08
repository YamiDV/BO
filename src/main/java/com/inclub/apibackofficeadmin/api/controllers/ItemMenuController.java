package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.ItemMenuService;
import com.inclub.apibackofficeadmin.domain.models.ItemMenu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
public class ItemMenuController {
    
    @Autowired
    private ItemMenuService itemMenuService;
    

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<ItemMenu>>> listarItems() {
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMenuService.findAllItemMenu()));

    }

    @GetMapping("/roluser/{id}")
    
    public Mono<ResponseEntity<Flux<String>>> findNamesByUserId(@PathVariable int id)    {
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMenuService.findNamesByUserId(id)));
    }



    


}
