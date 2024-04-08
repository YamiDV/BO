package com.inclub.apibackofficeadmin.domain.models.Membresias;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("suscription")
public class Suscription {

    
    @Getter
    @Setter
    @Column("id")
    @Id
    private int idSuscription;

    @Getter
    @Setter
    @Column("iduser")
    private int idUser;

    @Getter
    @Setter
    @Column("creationdate")    
    private LocalDateTime creationDate;

    @Getter
    @Setter
    @Column("status")
    private int status;

    @Getter
    @Setter
    @Column("modificationdate")
    private LocalDateTime modificationDate;

    @Getter
    @Setter
    @Column("boolmigration")
    private int boolmigration;

    @Getter
    @Setter
    @Column("packagedetailid")
    private int packageDetailId;

    @Getter
    @Setter
    @Column("idpackage")
    private int idPackage;

    public Suscription() {
    }

   

    public Suscription(int idUser, LocalDateTime creationDate, int status, LocalDateTime modificationDate, int boolmigration, int packageDetailId, int idPackage) {
        
        this.idUser = idUser;
        this.creationDate = creationDate;
        this.status = status;
        this.modificationDate = modificationDate;
        this.boolmigration = boolmigration;
        this.packageDetailId = packageDetailId;
        this.idPackage = idPackage;
    }

    
     
}
