package com.vivriti.demo.service;

import com.vivriti.demo.model.Items;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Sales service - Handles printing out sales for the day
 */

public class SalesService {

    public void printSales(ValueOperations valueOperations) {
        System.out.println("Print Sales... Begin \n");
        List<Items> itemsSet = (List<Items>) valueOperations.get("TRAN");
        Map<Long, List<Items>> itemNames = itemsSet.stream().collect(Collectors.groupingBy(Items::getId));
        System.out.println(itemNames);
        System.out.println("Print Sales... End \n");

    }
}
