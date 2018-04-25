package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/12/2018.
 */

public class AppSession {

    private static AppSession single_instance = null;
    private RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider();
    private FiltersDataProvider filtersDataProvider = new FiltersDataProvider();
    private String name;
    private String zipSearch;


    public static AppSession getInstance()
    {
        if (single_instance == null) {
            single_instance = new AppSession();
        }
        return single_instance;
    }

    private AppSession() {
    }

    public void setZipSearch(String zipSearch){ this.zipSearch = zipSearch; }
    public String getZipSearch(){return zipSearch; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantDataProvider getRestaurantDataProvider() {
        return restaurantDataProvider;
    }

    public FiltersDataProvider getFiltersDataProvider(){ return filtersDataProvider; }
}
