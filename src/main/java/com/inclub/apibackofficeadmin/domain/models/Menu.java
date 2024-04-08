package com.inclub.apibackofficeadmin.domain.models;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class Menu {

    @Getter
    @Setter
    @Id
    private int id;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String url;
    
    public Menu() {
    }

    public Menu(String name, String url) {

        this.name = name;
        this.url = url;
        

    }
}
