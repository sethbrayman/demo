package com.example.demo.Controllers.API;

import com.example.demo.Models.Product;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//for controllers that are not goign to serve up views
public class ProductAPIController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api")
    public List<Product> index() {
        return productService.findAll();
    }

    @GetMapping(value = "/api/getProductsByCriteria", params = {"criteria"})
    public List<Product> search(@RequestParam(value = "criteria") String criteria) {
        return productService.findBySearchCriteria(criteria);
    }
}
