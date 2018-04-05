package com.example.bethn.gfree_srproj;

import java.util.List;

/**
 * Created by bethn on 3/25/2018.
 */

public class Restaurant {
    private String name;
    private String address;
    private String phone;
    private String type;
    private String hours;
    private PriceRange priceRange;
    private FoodType foodType;
    private List<Item> menu;

    public Restaurant() {
    }

    public Restaurant(String name, String address, String phone, String type, String hours, PriceRange priceRange, FoodType foodType, List<Item> menu) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.hours = hours;
        this.priceRange = priceRange;
        this.foodType = foodType;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
