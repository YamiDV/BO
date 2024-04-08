package com.inclub.apibackofficeadmin.api.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inclub.apibackofficeadmin.aplication.services.Interface.SuscriptionService;

import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/suscriptionSync")
public class SuscriptionKafkaController {

    @Autowired
    private SuscriptionService suscriptionService;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaTemplateSuscriptionRequest;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplateSuscription;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Suscription>>> listarSuscriptions() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(suscriptionService.findAllSuscription()));
    }

    @GetMapping("/status/{status}")
    public Mono<ResponseEntity<Flux<Suscription>>> listarSuscriptionsByStatus(@PathVariable int status) {
        // Crea un mensaje de solicitud con un comando para solicitar los datos
        // actualizados al proveedor
        Message<Integer> requestMessage = MessageBuilder.withPayload(status)
                .setHeader(KafkaHeaders.TOPIC, "topic-request-suscription")
                .build();

        // Envía el mensaje de solicitud al proveedor
        kafkaTemplateSuscriptionRequest.send(requestMessage);

        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(suscriptionService.findNamesByStatus(status)));
    }

    @PostMapping("/guardar")
    public Mono<ResponseEntity<Suscription>> guardarSuscription(@RequestBody Suscription suscription) {
        return suscriptionService.saveSuscription(suscription).map(s -> ResponseEntity

                .ok()
                .body(s)

        );
    }

    @PutMapping("/actualizar/{id}")
    public Mono<ResponseEntity<Suscription>> actualizarSuscription(@RequestBody Suscription suscription, @PathVariable int id) {
        return suscriptionService.findSuscriptionById(id).flatMap(s -> {
            
            s.setIdUser(suscription.getIdUser());
            s.setCreationDate(suscription.getCreationDate());
            s.setStatus(suscription.getStatus());
            s.setModificationDate(LocalDateTime.now());
            s.setBoolmigration(suscription.getBoolmigration());
            s.setPackageDetailId(suscription.getPackageDetailId());
            s.setIdPackage(suscription.getIdPackage());
            return suscriptionService.saveSuscription(s);
        }).doOnSuccess(s -> {
            if (s != null) {
                kafkaTemplateSuscription.send("topic-suscription", s);
            }
        }).map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(s))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

     

    @PostMapping("/guardarconID")
    public Mono<ResponseEntity<Suscription>> guardarSuscriptionID(@RequestBody Suscription suscription) {
        return suscriptionService.saveWithId(suscription).map(s -> ResponseEntity
                .ok()
                .body(s)

        );
    }

}
