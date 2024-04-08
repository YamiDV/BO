package com.inclub.apibackofficeadmin.aplication.Mapper;

import com.inclub.apibackofficeadmin.aplication.Mapper.Interface.UserMapper;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;
import com.inclub.apibackofficeadmin.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse convertToResponse(User user) {
         UserResponse response = new UserResponse();
         response.setIdUser(user.getId());
         response.setName(user.getName());
         response.setUserName(user.getUserName());
         response.setEmail(user.getEmail());
         response.setNroTelf(user.getNroTelf());
         response.setLastName(user.getLastName());

         return response;
    }
}
