package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Dtos.CustomerDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerDTOService {

    Flux<CustomerDTO> findAllCustomerDTO();

    Mono<CustomerDTO> findCustomerDTOById(int id);

    Mono<CustomerDTO> saveCustomerDTO(CustomerDTO customerDTO);

    Mono<Void> delete(CustomerDTO customerDTO);
    

}
