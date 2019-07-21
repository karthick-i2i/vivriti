package com.vivriti.demo.model;

import java.util.Set;

public class GroceryStore {

    private Customer customer;
    private Set<Items> items;
    private Register register;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
