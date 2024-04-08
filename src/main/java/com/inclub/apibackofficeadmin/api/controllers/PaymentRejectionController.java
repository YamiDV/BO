package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentRejectionService;

import com.inclub.apibackofficeadmin.domain.models.Reason.PaymentRejection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/paymentrejection")
public class PaymentRejectionController {

    @Autowired
    private PaymentRejectionService paymentRejectionService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<PaymentRejection>>> listarPaymentRejection() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(paymentRejectionService.findAllPaymentRejection()));
    }

    @GetMapping("/buscar/{id}")
    public Mono<ResponseEntity<PaymentRejection>> verPaymentRejection(@PathVariable Integer id) {
        return paymentRejectionService.findPaymentRejectionById(id).map(u -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Mono<ResponseEntity<PaymentRejection>> crearPaymentRejection(@PathVariable PaymentRejection paymentRejection) {
        return paymentRejectionService.savePaymentRejection(paymentRejection).map(u -> ResponseEntity
                .ok()
                .body(u)
        );
    }

    @PutMapping("/editar/{id}")
    public Mono<ResponseEntity<PaymentRejection>> editarPaymentRejection(@PathVariable PaymentRejection paymentRejection, @PathVariable Integer id) {
        return paymentRejectionService.findPaymentRejectionById(id).flatMap(p -> {
            p.setIdPayment(paymentRejection.getIdSuscription());
            p.setIdReason(paymentRejection.getIdReason());
            p.setIdQuoteType(paymentRejection.getIdQuoteType());
            p.setDetail(paymentRejection.getDetail());
            p.setDate( LocalDateTime.now());
            return paymentRejectionService.savePaymentRejection(p);
        }).map(p -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    
 

    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Void>> eliminarPaymentRejection(@PathVariable Integer id) {
        return paymentRejectionService.findPaymentRejectionById(id).flatMap(p -> {
            return paymentRejectionService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
        
}
