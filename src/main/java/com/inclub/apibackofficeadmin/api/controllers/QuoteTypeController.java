package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.QuoteTypeService;
import com.inclub.apibackofficeadmin.domain.models.Reason.QuoteType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quoteType")
public class QuoteTypeController {

    @Autowired
    private QuoteTypeService quoteTypeService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<QuoteType>>> listarQuoteType() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(quoteTypeService.findAllQuoteType()));
    }

    @GetMapping("/buscar/{id}")
    public Mono<ResponseEntity<QuoteType>> verQuoteType(@PathVariable Integer id) {
        return quoteTypeService.findQuoteTypeById(id).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Void>> eliminarQuoteType(@PathVariable Integer id) {
        return quoteTypeService.findQuoteTypeById(id).flatMap(p -> {
            return quoteTypeService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

}






