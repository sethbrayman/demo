package com.example.demo.Services;

import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        try {
            return productRepository.findAll();//find all gets brought in from the JpaRepository
        } catch (Exception e) {
            return new ArrayList<Product>();//return empty list if error
        }
    }

    public List<Product> findBySearchCriteria(String criteria) {
        List<Product> productList = productRepository.findAll();//really large data sets would want a different approach
        List<Product> results = new ArrayList<>();

        //this part could be condensed into a something more efficient
        //but, this data set is tiny so I'll opt for more easily readable
        //filter for a partial match of the criteria, case independent on appropriate fields(I'm just guessing case should not matter here)
        results.addAll(productList.stream().filter(x -> x.getDescription().toLowerCase().contains(criteria.toLowerCase())).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getDepartment().toLowerCase().contains(criteria.toLowerCase())).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getCost().contains(criteria)).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getLastSold().contains(criteria)).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getPrice().contains(criteria)).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getShelfLife().toLowerCase().contains(criteria.toLowerCase())).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getUnit().toLowerCase().contains(criteria.toLowerCase())).collect(Collectors.toList()));
        results.addAll(productList.stream().filter(x -> x.getxFor().contains(criteria)).collect(Collectors.toList()));

        //I think ID's should probably be an exact match, if thats not the case you could parseint the getid, then check if it contains the criteria
        try {
            results.addAll(productList.stream().filter(x -> x.getId() == Integer.parseInt(criteria)).collect(Collectors.toList()));
        } catch (NumberFormatException nfe) {
            //ignore, not a number
        }

        return results.stream().distinct().collect(Collectors.toList());//return only the unique values
    }
}
