package com.example.demo.Model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccountInfo implements Serializable {

    private Integer id;
    private Integer AccountId;
    private BigDecimal Blance;
    private String payPassword;

    public BankAccountInfo(Integer id, Integer accountId, BigDecimal blance, String payPassword) {
        this.id = id;
        AccountId = accountId;
        Blance = blance;
        this.payPassword = payPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return AccountId;
    }

    public void setAccountId(Integer accountId) {
        AccountId = accountId;
    }

    public BigDecimal getBlance() {
        return Blance;
    }

    public void setBlance(BigDecimal blance) {
        Blance = blance;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
