package com.example.crudproducttask.controllers;

import com.example.crudproducttask.entity.Product;
import com.example.crudproducttask.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService service = new ProductService();
    Product product = new Product();

    @GetMapping ("")
    public void findAll () {
        service.findAll();
    }

    @GetMapping ("/{id}")
    public void findById (@PathVariable("id") Long id) {
        service.findById(id);
    }

    @PostMapping("/new")
    public void save (@RequestBody Product product) {
        service.save(product);
    }

/*    @PostMapping ("/new")
    public void save (@RequestBody ProductRequest productRequest) {

        service.save(productRequest);
    }*/

    @PostMapping("/update/{id}")
    public void update (@PathVariable("id") Long id, @RequestBody Product updateProduct) {
        service.update(id,updateProduct);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
