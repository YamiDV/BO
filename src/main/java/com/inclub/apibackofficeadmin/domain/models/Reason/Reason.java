package com.inclub.apibackofficeadmin.domain.models.Reason;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("reason")
public class Reason {

    
    @Getter
    @Setter
    @Column("idreason")
    @Id
    private int idReason;

    @Getter
    @Setter
    @Column("reasonrejection")
    private String  reasonRejection;

    @Getter
    @Setter
    @Column("detail")
    private String  detail;

    @Getter
    @Setter
    @Column("typereason")
    private int typeReason;


    public Reason() {
    }

    public Reason(int idReason, String reasonRejection, String detail, int typeReason) {
        this.idReason = idReason;
        this.reasonRejection = reasonRejection;
        this.detail = detail;
        this.typeReason = typeReason;
    }

    public Reason(String reasonRejection, String detail, int typeReason) {
        
        this.reasonRejection = reasonRejection;
        this.detail = detail;
        this.typeReason = typeReason;
    }
    

}
