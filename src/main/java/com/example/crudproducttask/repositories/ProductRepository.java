package com.example.crudproducttask.repositories;

import com.example.crudproducttask.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
