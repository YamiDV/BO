package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inclub.apibackofficeadmin.aplication.services.Interface.CustomerDTOService;
import com.inclub.apibackofficeadmin.domain.models.Dtos.CustomerDTO;
import com.inclub.apibackofficeadmin.infraestructure.repositories.CustomerDTORepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerDTOServiceImpl implements CustomerDTOService{

    @Autowired
    private CustomerDTORepository customerDTORepository;

    @Override
    public Flux<CustomerDTO> findAllCustomerDTO() {
        return customerDTORepository.findAll();
    }

    @Override
    public Mono<CustomerDTO> findCustomerDTOById(int id) {
       return customerDTORepository.findById(id);
    }

    @Override
    public Mono<CustomerDTO> saveCustomerDTO(CustomerDTO customerDTO) {
        return customerDTORepository.save(customerDTO);
    } 

    @Override
    public Mono<Void> delete(CustomerDTO customerDTO) {
        return customerDTORepository.delete(customerDTO);
    }

}
