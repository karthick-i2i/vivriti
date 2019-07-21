package com.vivriti.demo.model;

import java.io.Serializable;

public class Items implements Serializable {

    private Long id;
    private String itemCode;
    private String itemName;
    private Long price;
    private int quantity;
    private int discount;
    private String category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  "\n"+
                "Item id : "        + id + "\n" +
                "Item code : "      + itemCode + "\n" +
                "Item Name : "      + itemName + "\n" +
                "Item category : "  + category + "\n" +
                "Quantity: "        + quantity + "\n" +
                "Price: "           + price + "\n" +
                "Discount:"         + discount + "\n" ;
    }
}
