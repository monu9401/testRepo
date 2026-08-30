package com.TestApp.Main.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class MyController {
  
    private final List<Product> products = new ArrayList<>();
  
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        Product p1 = new Product(101,"Phone",50000);
        Product p2 = new Product(102,"Laptop",100000);
        Product p3 = new Product(103,"Data Cable",500);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
class Product{
  int id;
  String name;
  int price;

  public Product(int id,String name,int price){
    this.id=id;
    this.name=name;
    this.price=price;
  }
}
