package com.inclub.apibackofficeadmin.domain.models.Reason;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("paymentrejection")
public class PaymentRejection {

    
    @Getter
    @Setter
    @Column("idpaymentrejection")
    @Id
    private int idPaymentRejection;

    
    @Getter
    @Setter
    @Column("idsuscription")
    private int idSuscription;

    @Getter
    @Setter
    @Column("idpayment")
    private int idPayment;

    @Getter
    @Setter
    @Column("idreason")
    private int idReason;

    @Getter
    @Setter
    @Column("idquotetype")
    private int idQuoteType;

    @Getter
    @Setter
    @Column("detail")
    private String detail;

    @Getter
    @Setter
    @Column("date")
    private LocalDateTime date;

    public PaymentRejection() {
    }

    public PaymentRejection( int idPayment, int idReason, int idQuoteType, String detail, LocalDateTime date) {
       
        this.idPayment = idPayment;
        this.idReason = idReason;
        this.idQuoteType = idQuoteType;
        this.detail = detail;
        this.date = date;
    }

    
}





