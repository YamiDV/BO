package com.inclub.apibackofficeadmin.domain.models.Membresias;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("paymentsubtype")
public class PaymentSubType {

    @Getter
    @Setter
    @Column("idsubpaymenttype")
    @Id
    private int idPaymentSubType;

    @Getter
    @Setter
    @Column("idpaymenttype")
    private int idPaymentType;

    @Getter
    @Setter
    @Column("description")
    private String description;

    @Getter
    @Setter
    @Column("commissionsoles")
    private double commissionSoles;

    @Getter
    @Setter
    @Column("commissiondollars")
    private double commissionDollars;

    @Getter
    @Setter
    @Column("ratepercentage")
    private double ratePercentage;

    @Getter
    @Setter
    @Column("statussoles")
    private boolean statusSoles;

    @Getter
    @Setter
    @Column("statusdollar")
    private boolean statusDollar;

    public PaymentSubType() {
    }

    public PaymentSubType(int idPaymentSubType, int idPaymentType, String description, double commissionSoles,
            double commissionDollars, double ratePercentage, boolean statusSoles, boolean statusDollar) {
        this.idPaymentSubType = idPaymentSubType;
        this.idPaymentType = idPaymentType;
        this.description = description;
        this.commissionSoles = commissionSoles;
        this.commissionDollars = commissionDollars;
        this.ratePercentage = ratePercentage;
        this.statusSoles = statusSoles;
        this.statusDollar = statusDollar;
    }

    public PaymentSubType(int idPaymentType, String description, double commissionSoles, double commissionDollars,
            double ratePercentage, boolean statusSoles, boolean statusDollar) {
        this.idPaymentType = idPaymentType;
        this.description = description;
        this.commissionSoles = commissionSoles;
        this.commissionDollars = commissionDollars;
        this.ratePercentage = ratePercentage;
        this.statusSoles = statusSoles;
        this.statusDollar = statusDollar;
    }

}
