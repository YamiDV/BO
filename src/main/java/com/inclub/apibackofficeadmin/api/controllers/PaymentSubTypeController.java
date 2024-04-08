package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentSubTypeService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentSubType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/paymentsubtype")
public class PaymentSubTypeController {

    @Autowired
    private PaymentSubTypeService paymentSubTypeService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<PaymentSubType>>> listarPaymentSubType() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(paymentSubTypeService.findAllPaymentSubType()));
    }

}
