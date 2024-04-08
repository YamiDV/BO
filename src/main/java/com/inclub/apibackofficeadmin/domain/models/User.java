package com.inclub.apibackofficeadmin.domain.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Table("users")
public class User {
    
    @Setter
    @Getter
    @Id
    private int id;
    
    @Setter
    @Getter
    @Column("name")
    private String name;

    @Setter
    @Getter
    @Column("lastname")
    private String lastName;

    @Setter
    @Getter
    @Column("email")
    private String email;

    @Setter
    @Getter
    @Column("username")
    private String userName;
    
    @Setter
    @Getter
    @Column("password")
    private String password;
    
    @Setter
    @Getter
    @Column("idrol")
    private int idRol;
    
    @Setter
    @Getter
    @Column("nrotelf")
    private String nroTelf;

    @Setter
    @Getter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(value = "createdate")
    private LocalDateTime createDate;

    @Setter
    @Getter
    @Column("profilepicture")
    private String profilePicture;

    @Setter
    @Getter
    @Column("updatedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateDate;

    public User() {
    }

    
    public User(int id, String name, String lastName, String email, String userName, String password, int idRol,
            String nroTelf) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.idRol = idRol;
        this.nroTelf = nroTelf;
    }


    public User(String name, String lastName, String email, String userName, String password, int idRol,
            String nroTelf) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.idRol = idRol;
        this.nroTelf = nroTelf;
    }

}