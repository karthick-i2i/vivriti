package com.vivriti.demo.model;

import java.util.Date;
import java.util.List;

public class Transaction {

    private Long transactionId;
    private List<Items> items;
    private Date date;
    private Customer customer;
    private Register register;
    private Long billAmount;

    public Transaction() {
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Long billAmount) {
        this.billAmount = billAmount;
    }
}
