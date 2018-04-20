package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/10/2018.
 */

public class FiltersDataProvider {
    public List<String> filterStuff() {
        List<String> filtersList = new ArrayList<>();
        //use list containing checkbox value and name to test filter view
        filtersList.add("Sandwiches");
        filtersList.add("Breakfast");
        filtersList.add("Pasteries");
        filtersList.add("American");
        filtersList.add("Chinese");
        filtersList.add("Mexican");
        filtersList.add("Lunch");
        filtersList.add("Fast Food");
        return  filtersList;
    }
}
