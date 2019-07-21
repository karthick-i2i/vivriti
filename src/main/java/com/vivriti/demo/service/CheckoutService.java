package com.vivriti.demo.service;

import com.vivriti.demo.model.GroceryStore;
import com.vivriti.demo.model.Transaction;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Checkout Service - Handles Billing and sales operations
 */

public class CheckoutService {


    public void checkout(GroceryStore groceryStore, Transaction transaction, ValueOperations valueOperations) {
        // init all services
        InventoryService inventoryService = new InventoryService();
        SalesService salesService = new SalesService();
        BillService billService = new BillService();

        // generate bill
        billService.generateBill(transaction,valueOperations);

        // print inventory details
        inventoryService.printInventory(valueOperations);

        // print sales for the day.
        salesService.printSales(valueOperations);
    }




}
