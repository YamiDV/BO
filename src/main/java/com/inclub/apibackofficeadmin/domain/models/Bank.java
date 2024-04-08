package com.inclub.apibackofficeadmin.domain.models;


import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class Bank {

    @Id
    private int idbank;
  
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String abbreviation;

    @Setter
    @Getter
    private int idCountry;
    
    @Setter
    @Getter
    private char trial862;

    

    public Bank() {
    }



    public Bank(String name, String abbreviation, int idCountry, char trial862) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.idCountry = idCountry;
        this.trial862 = trial862;
    }


}
