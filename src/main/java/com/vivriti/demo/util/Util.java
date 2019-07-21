package com.vivriti.demo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivriti.demo.model.Items;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Util class - Handles sample data for transaction
 */

public class Util {

    public static Set<Items> getItemData() {
        Set<Items> itemsSet = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Set<Items>> typeReference = new TypeReference<Set<Items>>(){};
        try {
            InputStream inputStream =  TypeReference.class.getClassLoader().getResourceAsStream("items-sample");
            itemsSet  = mapper.readValue(inputStream,typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return itemsSet;
    }

    public static List<Items> selectItems() {
        Set<Items> itemsSet = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Set<Items>> typeReference = new TypeReference<Set<Items>>(){};
        try {
            InputStream inputStream =  TypeReference.class.getClassLoader().getResourceAsStream("items-sample");
            itemsSet  = mapper.readValue(inputStream,typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        List<Items> filterList = itemsSet.stream().filter(items -> items.getId() == 1 || items.getId() == 2).collect(Collectors.toList());
        filterList.stream().forEach(items -> {
            items.setQuantity(1);
        });
        return filterList;
    }
}
