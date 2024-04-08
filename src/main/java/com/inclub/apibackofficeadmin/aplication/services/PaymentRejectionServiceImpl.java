package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentRejectionService;
import com.inclub.apibackofficeadmin.domain.models.Reason.PaymentRejection;
import com.inclub.apibackofficeadmin.infraestructure.repositories.PaymentRejectionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentRejectionServiceImpl implements PaymentRejectionService{

    @Autowired
    private PaymentRejectionRepository paymentRejectionRepository;

    @Override
    public Flux<PaymentRejection> findAllPaymentRejection() {
       return  paymentRejectionRepository.findAll();
    }

    @Override
    public Mono<PaymentRejection> findPaymentRejectionById(int id) {
        return paymentRejectionRepository.findById(id);
    }

    @Override
    public Mono<PaymentRejection> savePaymentRejection(PaymentRejection paymentRejection) {
        return paymentRejectionRepository.save(paymentRejection);
    }

    @Override
    public Mono<Void> delete(PaymentRejection paymentRejection) {
        return paymentRejectionRepository.delete(paymentRejection);
    }

}
