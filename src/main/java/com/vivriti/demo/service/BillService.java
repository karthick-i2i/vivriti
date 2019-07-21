package com.vivriti.demo.service;

import com.vivriti.demo.constants.GroceryConstants;
import com.vivriti.demo.model.Items;
import com.vivriti.demo.model.Transaction;
import java.util.List;
import java.util.Set;
import org.springframework.data.redis.core.ValueOperations;


/**
 * Billing Service - Apply discount and
 * Prints Inventory after each transaction
 */

public class BillService {

    public void generateBill(Transaction transaction, ValueOperations valueOperations) {
        DiscountService discountService = new DiscountService();

        // Apply discount based on items in transaction
        discountService.applyDiscount(transaction);

        // Apply any discount based on customer
        int discount = discountService.applyDiscount(transaction.getItems(),transaction.getCustomer());
        if(discount != 0) {
            transaction.setBillAmount(((100 - discount) * transaction.getBillAmount()) / 100);
        }

        updateInvertory(transaction,valueOperations);
    }

    private void updateInvertory(Transaction transaction, ValueOperations inventoryItems) {
        System.out.println("Updating Invetory... Begin");

        Set<Items> itemsSet = (Set<Items>) inventoryItems.get("INV");
        itemsSet.stream().forEach(items -> {
            transaction.getItems().stream().forEach(items1 -> {
                if(items.getId().equals(items1.getId())) {
                    items.setQuantity(items.getQuantity() - items1.getQuantity());
                }
            });
        });

        // update inventory with current transaction
        inventoryItems.set(GroceryConstants.INV, itemsSet);

        // update old transactions with existing transaction
        List<Items> oldTransaction = (List<Items>) inventoryItems.get(GroceryConstants.TRAN);
        if(null != oldTransaction && oldTransaction.size() > 0) {
            oldTransaction.addAll(transaction.getItems());
            inventoryItems.set(GroceryConstants.TRAN,oldTransaction);
        } else {
            inventoryItems.set(GroceryConstants.TRAN,transaction.getItems());
        }
        System.out.println("Updating Invetory... End");

    }


}
