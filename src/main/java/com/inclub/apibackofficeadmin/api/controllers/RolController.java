package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inclub.apibackofficeadmin.aplication.services.Interface.RolService;
import com.inclub.apibackofficeadmin.domain.models.Rol;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/rols")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Rol>>> listarRols() {
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rolService.findAllRol()));
    }

    @PostMapping("/crear")
    public Mono<ResponseEntity<Rol>> crearRol(@RequestBody Rol rol) {
        return rolService.saveRol(rol).map(r -> ResponseEntity
                .ok()
                .body(r)
        );
    }

    @PutMapping("/editar/{id}")
    public Mono<ResponseEntity<Rol>> editarRol(@RequestBody Rol rol, @PathVariable Integer id) {
        return rolService.findRolById(id).flatMap(r -> {
            r.setName(rol.getName());
            r.setDescription(rol.getDescription());
            
            return rolService.saveRol(r);
        }).map(r -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(r))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Void>> eliminarRol(@PathVariable Integer id) {
        return rolService.findRolById(id).flatMap(r -> {
            return rolService.delete(r).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
    
    
}
