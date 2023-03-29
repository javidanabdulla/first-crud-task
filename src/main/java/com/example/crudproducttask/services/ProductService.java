package com.example.crudproducttask.services;

import com.example.crudproducttask.entity.Product;
import com.example.crudproducttask.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    @Transactional
    public List<Product> findAll(){
        return (List<Product>) repo.findAll();
    }

    @Transactional
    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public Product save (Product product) {
        return repo.save(product);
    }

/*    @Transactional
    public Product save (ProductRequest productRequest) {

        Product product = new Product();

        product.setQuantity(productRequest.getQuantity());
        product.setName(productRequest.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());

        return repo.save(product);
    }*/

    @Transactional
    public Product update (Long id, Product updateProduct) {
        Optional<Product> optionalProduct = repo.findById(id);
        Product product = optionalProduct.get();
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setQuantity(updateProduct.getQuantity());
        product.setPrice(updateProduct.getPrice());
        return repo.save(updateProduct);
    }

    @Transactional
    public void delete (Long id) {
        repo.deleteById(id);
    }
}
