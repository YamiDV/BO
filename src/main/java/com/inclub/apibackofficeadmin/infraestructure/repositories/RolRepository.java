package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.Rol;

@Repository
public interface RolRepository extends ReactiveCrudRepository<Rol, Integer>{
    
}
