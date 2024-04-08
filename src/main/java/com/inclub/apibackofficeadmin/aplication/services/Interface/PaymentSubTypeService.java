package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentSubType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentSubTypeService {

    public Flux<PaymentSubType> findAllPaymentSubType();

    public Mono<PaymentSubType> findPaymentSubTypeById(int id);

    public Mono<PaymentSubType> savePaymentSubType(PaymentSubType paymentSubType);

    public Mono<Void> delete(PaymentSubType paymentSubType);

}
