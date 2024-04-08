package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentSubTypeService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentSubType;
import com.inclub.apibackofficeadmin.infraestructure.repositories.PaymentSubTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentSubTypeServiceImpl implements PaymentSubTypeService {

    @Autowired
    private PaymentSubTypeRepository paymentSubTypeRepository;

    @Override
    public Flux<PaymentSubType> findAllPaymentSubType() {
        return  paymentSubTypeRepository.findAll();
    }

    @Override
    public Mono<PaymentSubType> findPaymentSubTypeById(int id) {
        return paymentSubTypeRepository.findById(id);

    }

    @Override
    public Mono<PaymentSubType> savePaymentSubType(PaymentSubType paymentSubType) {
        return paymentSubTypeRepository.save(paymentSubType);
    }

    @Override
    public Mono<Void> delete(PaymentSubType paymentSubType) {
        return paymentSubTypeRepository.delete(paymentSubType);
    }

}
