package com.inclub.apibackofficeadmin.domain.Responses.Login;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private int idUser;

    private String name;

    private String lastName;

    private String email;

    private String userName;

    private String nroTelf;


}
