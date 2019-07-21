package com.vivriti.demo.service;

import com.vivriti.demo.constants.GroceryConstants;
import com.vivriti.demo.model.Customer;
import com.vivriti.demo.model.Items;
import com.vivriti.demo.model.Transaction;
import java.util.List;

/**
 * Discount Service - Handles item level discount calculation
 * and customer based calculation
 */

public class DiscountService implements DiscountServiceInterface{

    @Override
    public void applyDiscount(Transaction transaction) {

        transaction.getItems().stream().forEach(items -> {
                    if (items.getDiscount() != 0) {
                        int discount = items.getDiscount();
                        items.setPrice(((100 - discount) * items.getPrice()) / 100);
                    }
        });
    }

    @Override
    public int applyDiscount(List<Items> items, Customer customer) {
        if(GroceryConstants.EMPLOYEE.equalsIgnoreCase(customer.getCustomerType()))  {
            return 10;
        } else if(GroceryConstants.SENIOR_CITIZEN.equalsIgnoreCase(customer.getCustomerType())) {
            return 15;
        }
        return 0;
    }


}
