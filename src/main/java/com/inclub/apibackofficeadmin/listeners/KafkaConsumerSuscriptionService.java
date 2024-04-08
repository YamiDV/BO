package com.inclub.apibackofficeadmin.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.SuscriptionService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;
import com.inclub.apibackofficeadmin.infraestructure.repositories.SuscriptionRepository;


@Service
public class KafkaConsumerSuscriptionService {

    @Autowired
    private SuscriptionRepository suscriptionRepository;

    @Autowired
    private SuscriptionService suscriptionService;

    @KafkaListener(topics = "topic-suscription", groupId = "suscription-group", containerFactory = "suscriptionKafkaListenerContainerFactory")
    public void consume(Suscription suscription) {
        suscriptionRepository.findById(suscription.getIdSuscription())
                .flatMap(existingSuscription -> {
                    // Si la suscripción ya existe en la base de datos, actualiza los datos
                    
                    existingSuscription.setIdUser(suscription.getIdUser());
                    existingSuscription.setCreationDate(suscription.getCreationDate());
                    existingSuscription.setStatus(suscription.getStatus());
                    existingSuscription.setModificationDate(suscription.getModificationDate());
                    existingSuscription.setBoolmigration(suscription.getBoolmigration());
                    existingSuscription.setPackageDetailId(suscription.getPackageDetailId());
                    existingSuscription.setIdPackage(suscription.getIdPackage());
                    return suscriptionRepository.save(existingSuscription);
                })
                .switchIfEmpty(suscriptionService.saveWithId(suscription)) // Si la suscripción no existe en la base de
                                                                        // datos, la guarda
                .subscribe(null, error -> {
                    // Maneja la excepción aquí
                    System.err.println("Error: " + error.getMessage());
                });
    }
}
