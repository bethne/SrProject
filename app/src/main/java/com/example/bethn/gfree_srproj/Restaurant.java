package com.example.bethn.gfree_srproj;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 3/25/2018.
 */

public class Restaurant implements Parcelable{
    private String name;
    private String address;
    private String phone;
    private String type;
    private String hours;
    private String rating;
    private PriceRange priceRange;
    private List<String> filters;
    private FoodType foodType;
    private List<Item> menu;

    public Restaurant() {
    }

    public Restaurant(String name, String address, String phone, String type, String hours, String rating, PriceRange priceRange, FoodType foodType, List<Item> menu) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.hours = hours;
        this.rating = rating;
        this.priceRange = priceRange;
        this.foodType = foodType;
        this.menu = menu;
    }



    @Override
    public int describeContents() {
        return 0;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
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

    protected Restaurant(Parcel in) {
        name = in.readString();
        address = in.readString();
        phone = in.readString();
        type = in.readString();
        hours = in.readString();
        rating = in.readString();
        priceRange = (PriceRange) in.readValue(PriceRange.class.getClassLoader());
        if (in.readByte() == 0x01) {
            filters = new ArrayList<String>();
            in.readList(filters, String.class.getClassLoader());
        } else {
            filters = null;
        }
        foodType = (FoodType) in.readValue(FoodType.class.getClassLoader());
        if (in.readByte() == 0x01) {
            menu = new ArrayList<Item>();
            in.readList(menu, Item.class.getClassLoader());
        } else {
            menu = null;
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(type);
        dest.writeString(hours);
        dest.writeString(rating);
        dest.writeValue(priceRange);
        if (filters == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(filters);
        }
        dest.writeValue(foodType);
        if (menu == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(menu);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
