package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentTypeService {

    public Flux<PaymentType> findAllPaymentType();

    public Mono<PaymentType> findPaymentTypeById(int id);

    public Mono<PaymentType> savePaymentType(PaymentType paymentType);

    public Mono<Void> delete(PaymentType paymentType);

}
