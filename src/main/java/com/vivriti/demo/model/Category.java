package com.vivriti.demo.model;

public class Category {

    private Long categoryId;
    private String categoryName;
    private int categoryDiscount;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryDiscount() {
        return categoryDiscount;
    }

    public void setCategoryDiscount(int categoryDiscount) {
        this.categoryDiscount = categoryDiscount;
    }
}
