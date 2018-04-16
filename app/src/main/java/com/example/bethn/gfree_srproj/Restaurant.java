package com.example.bethn.gfree_srproj;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by bethn on 3/25/2018.
 */

public abstract class Restaurant implements Parcelable{
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

    // Parcelling part
    public Restaurant(Parcel in){
        String[] data = new String[8];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.name = data[0];
        this.address = data[1];
        this.phone = data[2];
        this.type = data[3];
        this.hours = data[4];
        //this.priceRange = data[5];
       // this.foodType = data[6];

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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public List<Item> getMenu() {
        return menu;
    }

    public void setMenu(List<Item> menu) {
        this.menu = menu;
    }
}
