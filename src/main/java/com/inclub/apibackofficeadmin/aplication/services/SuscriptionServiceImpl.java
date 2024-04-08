package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.SuscriptionService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;
import com.inclub.apibackofficeadmin.infraestructure.repositories.SuscriptionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuscriptionServiceImpl  implements SuscriptionService{

    @Autowired
    private SuscriptionRepository suscriptionRepository;

    @Override
    public Flux<Suscription> findAllSuscription() {
       return  suscriptionRepository.findAll();
    }

    @Override
    public Mono<Suscription> findSuscriptionById(int id) {
       return suscriptionRepository.findById(id);
    }

    @Override
    public Mono<Suscription> saveSuscription(Suscription suscription) {
       return suscriptionRepository.save(suscription);
    }

    @Override
    public Mono<Void> delete(Suscription suscription) {
        return suscriptionRepository.delete(suscription);
    }

    @Override
    public Flux<Suscription> findNamesByStatus(int status) {
        return suscriptionRepository.findNamesByStatus(status);
    }

    @Override
    public Mono<Suscription> saveWithId(Suscription suscription) {
        return suscriptionRepository.saveWithId(suscription.getIdSuscription(), suscription.getIdUser(), suscription.getCreationDate(), suscription.getStatus(),
         suscription.getModificationDate(), suscription.getBoolmigration(), suscription.getPackageDetailId(), suscription.getIdPackage());
    }

}
