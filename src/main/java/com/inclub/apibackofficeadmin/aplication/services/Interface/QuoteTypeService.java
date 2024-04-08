package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Reason.QuoteType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuoteTypeService {

    public Flux<QuoteType> findAllQuoteType();

    public Mono<QuoteType> findQuoteTypeById(int id);

    public Mono<QuoteType> saveQuoteType(QuoteType quoteType);

    public Mono<Void> delete(QuoteType quoteType);

}
