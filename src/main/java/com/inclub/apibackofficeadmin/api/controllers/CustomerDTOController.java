package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.CustomerDTOService;
import com.inclub.apibackofficeadmin.domain.models.Dtos.CustomerDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/customer")
public class CustomerDTOController {

    @Autowired
    private CustomerDTOService customerDTOService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<CustomerDTO>>> listarCustomerDTO() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customerDTOService.findAllCustomerDTO()));
    }
}
