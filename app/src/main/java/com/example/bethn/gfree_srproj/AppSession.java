package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/12/2018.
 */

public class AppSession {

    private static AppSession single_instance = null;
    private List<Restaurant> restaurantList = null;
    private RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider();
    private String name;


    public static AppSession getInstance()
    {
        if (single_instance == null) {
            single_instance = new AppSession();
        }
        return single_instance;
    }

    private AppSession() {

        restaurantList = new ArrayList<Restaurant>();
    }

    // retrieve list from anywhere
    public List<Restaurant> getList() {
        return restaurantDataProvider.getRestaurants();
    }
    //Add element to list
    public void addToRestaurantList(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
