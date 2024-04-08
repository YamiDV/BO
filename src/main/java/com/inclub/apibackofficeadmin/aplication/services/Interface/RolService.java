package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.Rol;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolService {

    public Flux<Rol> findAllRol();
	
	public Mono<Rol> findRolById(int id);
	
	public Mono<Rol> saveRol(Rol rol);

	public Mono<Void> delete(Rol rol);
    
}
