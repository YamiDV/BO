package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.ReasonService;
import com.inclub.apibackofficeadmin.domain.models.Reason.Reason;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reason")
public class ReasonController {

    @Autowired
    private ReasonService reasonService;

    

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Reason>>> listarReason() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(reasonService.findAllReason()));
    }

    @GetMapping("/buscar/{id}")
    public Mono<ResponseEntity<Reason>> verReason(@PathVariable Integer id) {
        return reasonService.findReasonById(id).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
