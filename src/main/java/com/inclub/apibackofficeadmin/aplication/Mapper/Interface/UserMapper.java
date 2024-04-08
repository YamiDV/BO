package com.inclub.apibackofficeadmin.aplication.Mapper.Interface;

import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;
import com.inclub.apibackofficeadmin.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    UserResponse convertToResponse(User user);

}
