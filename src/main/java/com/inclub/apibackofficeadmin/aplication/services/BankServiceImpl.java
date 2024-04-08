package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.services.Interface.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.domain.models.Bank;
import com.inclub.apibackofficeadmin.infraestructure.repositories.BankRepository;


import reactor.core.publisher.Flux;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private  BankRepository bankRepository;

    @Override

    public Flux<Bank> findAllBanks() {
        return bankRepository.findAll();
    }
}