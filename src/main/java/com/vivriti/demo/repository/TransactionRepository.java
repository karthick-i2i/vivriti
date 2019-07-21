package com.vivriti.demo.repository;

import com.vivriti.demo.model.Items;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Items, String> {

}

