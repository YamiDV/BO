package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.PaymentTypeService;
import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentSubType;
import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentType;
import com.inclub.apibackofficeadmin.infraestructure.repositories.PaymentSubTypeRepository;
import com.inclub.apibackofficeadmin.infraestructure.repositories.PaymentTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentTypeServiceImpl  implements PaymentTypeService{

  @Autowired
  private PaymentTypeRepository paymentTypeRepository;

  @Autowired
  private PaymentSubTypeRepository paymentSubTypeRepository;
    
    @Override
    public Flux<PaymentType> findAllPaymentType() {
        return paymentTypeRepository.findAll()
        .flatMap(paymentType -> {
            return paymentSubTypeRepository.GetPaymentSubTypes(paymentType.getIdPaymentType())
                .collectList()
                .flatMap(paymentSubTypes -> {
                    paymentType.setPaymentSubTypeList(paymentSubTypes);
                    return Mono.just(paymentType);
                });
        });
    }

    @Override
    public Mono<PaymentType> findPaymentTypeById(int id) {
        return paymentTypeRepository.findById(id);
    }

    @Override
    public Mono<PaymentType> savePaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public Mono<Void> delete(PaymentType paymentType) {
        return paymentTypeRepository.delete(paymentType);
    }

}
