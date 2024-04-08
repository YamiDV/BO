package com.inclub.apibackofficeadmin.infraestructure.repositories;

import java.time.LocalDateTime;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SuscriptionRepository extends ReactiveCrudRepository<Suscription, Integer> {

    Flux<Suscription> findNamesByStatus(int status);

    @Query("INSERT INTO suscription (id, iduser, creationdate, status, modificationdate, boolmigration, packagedetailid, idpackage) VALUES (:idSuscription, :idUser, :creationDate, :status, :modificationDate, :boolmigration, :packageDetailId, :idPackage)")
    Mono<Suscription> saveWithId(@Param("idSuscription") int idSuscription, @Param("idUser") int idUser, @Param("creationDate") LocalDateTime creationDate, @Param("status") int status, @Param("modificationDate") LocalDateTime modificationDate, @Param("boolmigration") int boolmigration, @Param("packageDetailId") int packageDetailId, @Param("idPackage") int idPackage);

}
