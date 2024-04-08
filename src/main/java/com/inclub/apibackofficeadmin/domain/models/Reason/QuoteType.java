package com.inclub.apibackofficeadmin.domain.models.Reason;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("quotetype")
public class QuoteType {

    @Getter
    @Setter
    @Column("idquotetype")
    @Id
    private int idQuoteType;

    @Getter
    @Setter
    @Column("name")
    private String name;

    public QuoteType() {
    }

    public QuoteType(int idQuoteType, String name) {
        this.idQuoteType = idQuoteType;
        this.name = name;
    }

    public QuoteType(String name) {
        
        this.name = name;
    }

}
