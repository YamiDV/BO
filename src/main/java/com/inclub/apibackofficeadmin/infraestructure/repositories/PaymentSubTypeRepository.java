package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentSubType;

import reactor.core.publisher.Flux;


public interface PaymentSubTypeRepository  extends ReactiveCrudRepository<PaymentSubType, Integer>{

    @Query("SELECT * FROM paymentsubtype WHERE idpaymenttype = :idpaymenttype")
    public Flux<PaymentSubType>GetPaymentSubTypes(@Param("idpaymenttype") int idpaymenttype);

}
