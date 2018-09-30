package com.example.demo.Controllers;

import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    private ProductService productService;//service will have most of the logic, keeping controller thin and making testing easier

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")//like requestmapping, but without need to specify get
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());//starting off with all products for visual reference

        return "products"; //products string corresponds with the products.html filename in templates
    }

    @PostMapping("/")//using same path for simplicity when posting from search button
    public String search(HttpServletRequest httpServletRequest, Model model) {
        String criteria = httpServletRequest.getParameter("search");//corresponds with input type name in products.html
        model.addAttribute("products", productService.findBySearchCriteria(criteria));

        return "products";
    }
}
