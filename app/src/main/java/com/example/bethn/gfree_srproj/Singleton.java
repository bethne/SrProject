package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/12/2018.
 */

public class Singleton {

    private static Singleton single_instance = null;
    private List<Restaurant> restaurantList = null;
    private RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider();

    public static Singleton getInstance()
    {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    private Singleton() {

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
}
