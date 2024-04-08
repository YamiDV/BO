package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SuscriptionService {

    public Flux<Suscription> findAllSuscription();
    public Mono<Suscription> findSuscriptionById(int id);
    public Mono<Suscription> saveSuscription(Suscription suscription);

    public Mono<Suscription> saveWithId(Suscription suscription);

    public Mono<Void> delete(Suscription suscription);

    public Flux<Suscription> findNamesByStatus(int status);



}
