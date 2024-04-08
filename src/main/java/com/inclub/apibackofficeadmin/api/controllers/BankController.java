package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.BankService;
import com.inclub.apibackofficeadmin.domain.models.Bank;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private  BankService bankService;

    
    @GetMapping
    public Flux<Bank> getAllBanks() {
        return bankService.findAllBanks();
    }
}
