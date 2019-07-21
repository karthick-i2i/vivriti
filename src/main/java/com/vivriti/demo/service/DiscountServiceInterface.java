package com.vivriti.demo.service;

import com.vivriti.demo.model.Customer;
import com.vivriti.demo.model.Items;
import com.vivriti.demo.model.Transaction;
import java.util.List;

/**
 * Discount Service Interface - Handles item level discount calculation
 * and customer based calculation
 */

public interface DiscountServiceInterface {

    void applyDiscount(Transaction transaction);
    int applyDiscount(List<Items> items, Customer customer);
}
