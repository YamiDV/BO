package com.inclub.apibackofficeadmin.domain.models.Dtos;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("customer")
public class CustomerDTO {

    @Getter
    @Setter
    @Column("id")
    private int id;

    @Getter
    @Setter
    @Column("statename")
    private String stateName;

    @Getter
    @Setter
    @Column("namesponsor")
    private String nameSponsor;

    @Getter
    @Setter
    @Column("lastnamesponsor")
    private String lastnameSponsor;

    @Getter
    @Setter
    @Column("statetext")
    private String stateText;

    @Getter
    @Setter
    @Column("idrange")
    private int idRange;

    @Getter
    @Setter
    @Column("createdate")
    private LocalDateTime createDate;

    @Getter
    @Setter
    @Column("idstate")
    private int idState;

    @Getter
    @Setter
    @Column("name")
    private String name;

    @Getter
    @Setter
    @Column("lastname")
    private String lastname;

    @Getter
    @Setter
    @Column("birthdate")
    private LocalDateTime birthdate;

    @Getter
    @Setter
    @Column("gender")
    private String gender;

    @Getter
    @Setter
    @Column("idnationality")
    private int idNationality;

    @Getter
    @Setter
    @Column("iddocument")
    private int idDocument;

    @Getter
    @Setter
    @Column("nrodocument")
    private String nroDocument;

    @Getter
    @Setter
    @Column("civilstate")
    private String civilState;

    @Getter
    @Setter
    @Column("email")
    private String email;

    @Getter
    @Setter
    @Column("idresidencecountry")
    private int idResidenceCountry;

    @Getter
    @Setter
    @Column("districtaddress")
    private String districtAddress;

    @Getter
    @Setter
    @Column("address")
    private String address;

    @Getter
    @Setter
    @Column("username")
    private String username;

    @Getter
    @Setter
    @Column("nrotelf")
    private String nroTelf;

    @Getter
    @Setter
    @Column("booldelete")
    private int boolDelete;

    @Getter
    @Setter
    @Column("code")
    private String code;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String stateName, String nameSponsor, String lastnameSponsor, String stateText, int idRange, 
    LocalDateTime createDate, int idState, String name, String lastname, LocalDateTime birthdate, String gender, int idNationality,
     int idDocument, String nroDocument, String civilState, String email, int idResidenceCountry, String districtAddress, String address, 
     String username, String nroTelf, int boolDelete, String code) {
        this.id = id;
        this.stateName = stateName;
        this.nameSponsor = nameSponsor;
        this.lastnameSponsor = lastnameSponsor;
        this.stateText = stateText;
        this.idRange = idRange;
        this.createDate = createDate;
        this.idState = idState;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.idNationality = idNationality;
        this.idDocument = idDocument;
        this.nroDocument = nroDocument;
        this.civilState = civilState;
        this.email = email;
        this.idResidenceCountry = idResidenceCountry;
        this.districtAddress = districtAddress;
        this.address = address;
        this.username = username;
        this.nroTelf = nroTelf;
        this.boolDelete = boolDelete;
        this.code = code;
    }
    
}
