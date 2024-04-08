package com.inclub.apibackofficeadmin.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("rol")
public class Rol {
    
    @Getter
    @Setter
    @Id
    private int id;

    @Getter
    @Setter
    @Column("name")
    private String name;

    @Getter
    @Setter
    @Column("description")
    private String description;

    public Rol() {
    }

    public Rol(String name) {

        this.name = name;
        
    }

    public Rol( String name, String description) {
        
        this.name = name;
        this.description = description;
    }


}
