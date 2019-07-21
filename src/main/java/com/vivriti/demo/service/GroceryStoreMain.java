package com.vivriti.demo.service;

import com.vivriti.demo.model.GroceryStore;
import com.vivriti.demo.model.Transaction;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Grocery Main method - Init Grocery transaction
 */

public class GroceryStoreMain {

    public void groceryStoreMain(ValueOperations valueOperations) {

        // init services
        System.out.println("Init Grocery Transaction...Begin");
        GroceryService groceryService = new GroceryService();
        CheckoutService checkoutService = new CheckoutService();
        GroceryStore groceryStore = new GroceryStore();
        Transaction transaction = new Transaction();

        // init sample items in grocery store
        groceryService.initGroceryItems(groceryStore,valueOperations);

        // select random items and create transaction
        groceryService.initTransactionItems(transaction);

        // init checkout process
        checkoutService.checkout(groceryStore,transaction,valueOperations);

        System.out.println("Init Grocery Transaction...End");
    }









}
