package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/10/2018.
 */

public class FiltersDataProvider {
    public List<Filters> filterStuff() {
        List<Filters> filtersList = new ArrayList<>();
        //use list containing checkbox value and name to test filter view
        filtersList.add(new Filters("Sandwiches",false));
        filtersList.add(new Filters("Breakfast",true));
        filtersList.add(new Filters("Pasteries",true));
        filtersList.add(new Filters("American",false));
        filtersList.add(new Filters("Chinese",false));
        filtersList.add(new Filters("Mexican",false));
        filtersList.add(new Filters("Lunch",false));
        filtersList.add(new Filters("Fast Food",true));
        return  filtersList;
    }
}
