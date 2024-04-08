package com.inclub.apibackofficeadmin.domain.Responses.Login;

import java.util.Date;
import java.util.List;

import com.inclub.apibackofficeadmin.domain.models.ItemMenu;
import com.inclub.apibackofficeadmin.domain.models.Dtos.ItemMenuDto;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {
    
    @Getter
    private String token;

    @Getter
    private  Date expiration;

    @Setter
    @Getter
    private List<ItemMenuDto> authorities; 


    public LoginResponse() {
    }

    public LoginResponse(String token, Date expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    public LoginResponse(String token, Date expiration, List<ItemMenuDto> authorities) {
        this.token = token;
        this.expiration = expiration;
        this.authorities = authorities;
    }

    
}
