package com.inclub.apibackofficeadmin.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.CustomerDTOService;
import com.inclub.apibackofficeadmin.domain.models.Dtos.CustomerDTO;
import com.inclub.apibackofficeadmin.infraestructure.repositories.CustomerDTORepository;

@Service
public class KafkaConsumerCustomerService {

    @Autowired
    private CustomerDTORepository customerDTORepository;

    @Autowired
    private CustomerDTOService CustomerDTOService;

    @KafkaListener(topics = "topic-customer", groupId = "customer-group", containerFactory = "customerKafkaListenerContainerFactory")
    public void consume(CustomerDTO suscription) {

        System.out.println("Consumed message: " + suscription);
        // suscriptionRepository.findById(suscription.getIdSuscription())
        //         .flatMap(existingSuscription -> {
        //             // Si la suscripción ya existe en la base de datos, actualiza los datos
                    
        //             existingSuscription.setIdUser(suscription.getIdUser());
        //             existingSuscription.setCreationDate(suscription.getCreationDate());
        //             existingSuscription.setStatus(suscription.getStatus());
        //             existingSuscription.setModificationDate(suscription.getModificationDate());
        //             existingSuscription.setBoolmigration(suscription.getBoolmigration());
        //             existingSuscription.setPackageDetailId(suscription.getPackageDetailId());
        //             existingSuscription.setIdPackage(suscription.getIdPackage());
        //             return suscriptionRepository.save(existingSuscription);
        //         })
        //         .switchIfEmpty(suscriptionService.saveWithId(suscription)) // Si la suscripción no existe en la base de
        //                                                                 // datos, la guarda
        //         .subscribe(null, error -> {
        //             // Maneja la excepción aquí
        //             System.err.println("Error: " + error.getMessage());
        //         });
    }
}
