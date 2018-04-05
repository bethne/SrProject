package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 3/30/2018.
 */

public class Location {
    private int storeID;
    private int phone;
    private String hours;

    public Location() {
    }

    public Location(int storeID, int phone, String hours) {
        this.storeID = storeID;
        this.phone = phone;
        this.hours = hours;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
