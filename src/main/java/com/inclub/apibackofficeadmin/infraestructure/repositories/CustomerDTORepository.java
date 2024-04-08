package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.Dtos.CustomerDTO;

@Repository
public interface CustomerDTORepository extends ReactiveCrudRepository<CustomerDTO, Integer>{

}
