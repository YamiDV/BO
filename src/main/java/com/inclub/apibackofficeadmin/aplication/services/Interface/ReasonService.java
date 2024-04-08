package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Reason.Reason;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReasonService {

    public Flux<Reason> findAllReason();

    public Mono<Reason> findReasonById(int id);

    public Mono<Reason> saveReason(Reason reason);

    public Mono<Void> delete(Reason reason);

}
