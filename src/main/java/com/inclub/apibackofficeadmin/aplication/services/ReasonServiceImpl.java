package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.ReasonService;
import com.inclub.apibackofficeadmin.domain.models.Reason.Reason;
import com.inclub.apibackofficeadmin.infraestructure.repositories.ReasonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReasonServiceImpl implements ReasonService{

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Flux<Reason> findAllReason() {
        return reasonRepository.findAll();
    }

    @Override
    public Mono<Reason> findReasonById(int id) {
       return reasonRepository.findById(id);
    }

    @Override
    public Mono<Reason> saveReason(Reason reason) {
        return reasonRepository.save(reason);
    }

    @Override
    public Mono<Void> delete(Reason reason) {
        return reasonRepository.delete(reason);
    }
}
