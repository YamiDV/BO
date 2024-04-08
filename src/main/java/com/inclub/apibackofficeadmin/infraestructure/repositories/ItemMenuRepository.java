package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.ItemMenu;
import com.inclub.apibackofficeadmin.domain.models.Dtos.ItemMenuDto;

import reactor.core.publisher.Flux;

@Repository
public interface ItemMenuRepository extends ReactiveCrudRepository<ItemMenu, Integer>{

    @Query("SELECT itm.name FROM itemmenu  itm INNER JOIN userpermissionsitemmenu permiso ON permiso.iditemmenu = itm.id INNER JOIN users u ON u.id = permiso.iduser WHERE u.id = :userId")
    public Flux<String> findNamesByUserId(@Param("userId") int userId);

    @Query("SELECT itm.id , itm.name, itm.url FROM itemmenu  itm INNER JOIN userpermissionsitemmenu permiso ON permiso.iditemmenu = itm.id INNER JOIN users u ON u.id = permiso.iduser WHERE u.id = :userId")
    public Flux<ItemMenuDto> findItemsByUserId(@Param("userId") int userId);
}
