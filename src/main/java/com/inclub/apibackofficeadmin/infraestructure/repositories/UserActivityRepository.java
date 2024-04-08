package com.inclub.apibackofficeadmin.infraestructure.repositories;

import com.inclub.apibackofficeadmin.domain.models.UserActivity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository  extends ReactiveCrudRepository<UserActivity, Integer>{

}
