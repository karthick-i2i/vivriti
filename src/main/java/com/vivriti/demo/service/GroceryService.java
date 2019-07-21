package com.vivriti.demo.service;

import com.vivriti.demo.constants.GroceryConstants;
import com.vivriti.demo.model.Customer;
import com.vivriti.demo.model.GroceryStore;
import com.vivriti.demo.model.Items;
import com.vivriti.demo.model.Register;
import com.vivriti.demo.model.Transaction;
import com.vivriti.demo.util.Util;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Grocery Service - Init Grocery items for each transaction
 */

public class GroceryService {


    public void initGroceryItems(GroceryStore groceryStore, ValueOperations valueOperations) {
        // Getting items from the redis if present else get from sample-data
        InventoryService inventoryService = new InventoryService();
        Set<Items> savedItems = (Set<Items>) valueOperations.get(GroceryConstants.INV);

        // Get from store if redis cache cleared
        if(null != savedItems && savedItems.size() > 0) {
            groceryStore.setItems(savedItems);
        } else {
            groceryStore.setItems(Util.getItemData());
        }

        // Update inventory cache
        valueOperations.set(GroceryConstants.INV, groceryStore.getItems());

        // Print initial inventory count before checkout process begin
        inventoryService.printInventory(valueOperations);

    }

    public void initTransactionItems(Transaction transaction) {
        List<Items> selectedItems = Util.selectItems();
        transaction.setItems(selectedItems);
        transaction.setCustomer(new Customer("user"));
        transaction.setDate(new Date());
        transaction.setRegister(new Register("1"));
        transaction.setBillAmount(selectedItems.stream().mapToLong(value -> value.getPrice()).sum());
    }

}
