package com.vivriti.demo.service;

import com.vivriti.demo.constants.GroceryConstants;
import com.vivriti.demo.model.Items;
import java.util.Set;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Inventory service - Handles printing inventory after each transaction
 */

public class InventoryService {

    public void printInventory(ValueOperations valueOperations) {
        System.out.println("Printing Inventory... Begin \n");
        Set<Items> itemsSet = (Set<Items>) valueOperations.get(GroceryConstants.INV);
        itemsSet.forEach(items -> {
            System.out.println(items.toString());
        });
        System.out.println("Printing Inventory... End \n");
    }

}
