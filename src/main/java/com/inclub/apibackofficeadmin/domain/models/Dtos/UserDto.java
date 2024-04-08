package com.inclub.apibackofficeadmin.domain.models.Dtos;

import lombok.Getter;
import lombok.Setter;

public class UserDto  {
    
    @Getter
    @Setter
    private String username;


    @Getter
    @Setter
    private String password;

    public UserDto() {
    }
    
}
