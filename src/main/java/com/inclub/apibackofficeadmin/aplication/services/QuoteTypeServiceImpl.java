package com.inclub.apibackofficeadmin.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.aplication.services.Interface.QuoteTypeService;
import com.inclub.apibackofficeadmin.domain.models.Reason.QuoteType;
import com.inclub.apibackofficeadmin.infraestructure.repositories.QuoteTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuoteTypeServiceImpl implements QuoteTypeService{

    @Autowired
    private QuoteTypeRepository quoteTypeRepository;
    
    @Override
    public Flux<QuoteType> findAllQuoteType() {
        return quoteTypeRepository.findAll();
    }

    @Override
    public Mono<QuoteType> findQuoteTypeById(int id) {
       return quoteTypeRepository.findById(id);
    }

    @Override
    public Mono<QuoteType> saveQuoteType(QuoteType quoteType) {
        return quoteTypeRepository.save(quoteType);
    }

    @Override
    public Mono<Void> delete(QuoteType quoteType) {
        return quoteTypeRepository.delete(quoteType);
    }

}
