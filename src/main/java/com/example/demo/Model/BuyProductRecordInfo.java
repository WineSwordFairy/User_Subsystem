package com.example.demo.Model;

public class BuyProductRecordInfo {

    private int recordId;
    private int accountId;
    private int productId;
    private int count;

    public BuyProductRecordInfo(int accountId, int productId, int count) {
        this.accountId = accountId;
        this.productId = productId;
        this.count = count;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
