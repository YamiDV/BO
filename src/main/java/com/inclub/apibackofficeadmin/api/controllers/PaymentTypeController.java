package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentTypeService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/paymenttype")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<PaymentType>>> listarPaymentType() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(paymentTypeService.findAllPaymentType()));
    }


}
