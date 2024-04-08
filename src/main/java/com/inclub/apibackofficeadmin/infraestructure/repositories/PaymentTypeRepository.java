package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.Membresias.PaymentType;

@Repository
public interface PaymentTypeRepository extends ReactiveCrudRepository<PaymentType, Integer>{

}
