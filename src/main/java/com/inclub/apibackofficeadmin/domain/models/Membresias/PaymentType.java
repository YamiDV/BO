package com.inclub.apibackofficeadmin.domain.models.Membresias;

import org.springframework.data.annotation.Transient;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Flux;

@Table("paymenttype")
public class PaymentType {

    @Getter
    @Setter
    @Id
    @Column("idpaymenttype")
    private int idPaymentType;

    @Getter
    @Setter
    @Column("description")
    private String description;

    @Getter
    @Setter
    @Column("idresidencecountry")
    private int idResidenceCountry;

    @Getter
    @Setter
    @Transient
    private List<PaymentSubType> paymentSubTypeList;

    public PaymentType() {
    }

    public PaymentType(int idPaymentType, String description, int idResidenceCountry) {
        this.idPaymentType = idPaymentType;
        this.description = description;
        this.idResidenceCountry = idResidenceCountry;
    }

    public PaymentType(String description, int idResidenceCountry) {
        this.description = description;
        this.idResidenceCountry = idResidenceCountry;
    }

    public PaymentType(int idPaymentType, String description, int idResidenceCountry,
            List<PaymentSubType> paymentSubTypeList) {
        this.idPaymentType = idPaymentType;
        this.description = description;
        this.idResidenceCountry = idResidenceCountry;
        this.paymentSubTypeList = paymentSubTypeList;
    }

}
