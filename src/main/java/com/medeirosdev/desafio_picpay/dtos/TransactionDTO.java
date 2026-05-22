package com.medeirosdev.desafio_picpay.dtos;

import java.math.BigDecimal;

public class TransactionDTO {

    private BigDecimal value;
    private String payer;
    private String payee;

    public TransactionDTO(BigDecimal value, String payer, String payee) {
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
