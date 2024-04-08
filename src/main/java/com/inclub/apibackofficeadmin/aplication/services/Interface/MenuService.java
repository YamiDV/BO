package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Menu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuService {
    
    public Flux<Menu> findAllMenu();

    public Mono<Menu> findMenuById(int id);

    public Mono<Menu> saveMenu(Menu menu);
    public Mono<Void> delete(Menu menu);
    
}
