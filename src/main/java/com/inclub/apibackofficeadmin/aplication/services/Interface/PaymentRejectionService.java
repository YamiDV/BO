package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Reason.PaymentRejection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentRejectionService {

    public Flux<PaymentRejection> findAllPaymentRejection();

    public Mono<PaymentRejection> findPaymentRejectionById(int id);

    public Mono<PaymentRejection> savePaymentRejection(PaymentRejection paymentRejection);

    public Mono<Void> delete(PaymentRejection paymentRejection);
    

}
