package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.Reason.Reason;

@Repository
public interface ReasonRepository extends ReactiveCrudRepository <Reason, Integer>{

}
