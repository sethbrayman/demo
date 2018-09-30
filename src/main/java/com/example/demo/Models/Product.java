package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "lastsold")
    private String lastSold;

    @Column(name = "shelflife")
    private String shelfLife;

    @Column(name = "department")
    private String department;

    @Column(name = "price")
    private String price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "xfor")
    private String xFor;

    @Column(name = "cost")
    private String cost;

    public Product() {
    }

    public Product(int id, String description, String lastSold, String shelfLife, String department, String price, String unit, String xFor, String cost) {
        this.id = id;
        this.description = description;
        this.lastSold = lastSold;
        this.shelfLife = shelfLife;
        this.department = department;
        this.price = price;
        this.unit = unit;
        this.xFor = xFor;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastSold() {
        return lastSold;
    }

    public void setLastSold(String lastSold) {
        this.lastSold = lastSold;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getxFor() { return xFor; }

    public void setxFor(String xFor) {
        this.xFor = xFor;
    }

    public String getCost() { return cost; }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
