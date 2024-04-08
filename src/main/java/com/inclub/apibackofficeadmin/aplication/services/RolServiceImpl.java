package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.services.Interface.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.domain.models.Rol;
import com.inclub.apibackofficeadmin.infraestructure.repositories.RolRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Flux<Rol> findAllRol() {
        return rolRepository.findAll();
    }

    @Override
    public Mono<Rol> findRolById(int id) {
        return rolRepository.findById(id);
    }

    @Override
    public Mono<Rol> saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Mono<Void> delete(Rol rol) {
        return rolRepository.delete(rol);
    }
    
}
