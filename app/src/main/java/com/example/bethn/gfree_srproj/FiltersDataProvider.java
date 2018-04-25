package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/10/2018.
 */

public class FiltersDataProvider {
    private List<Filters> filters;

    public FiltersDataProvider() {
        filters = filterStuff();
    }

    private List<Filters> filterStuff() {
        List<Filters> filtersList = new ArrayList<>();
        //use list containing checkbox value and name to test filter view
        filtersList.add(new Filters("Sandwiches", false));
        filtersList.add(new Filters("Breakfast", false));
        filtersList.add(new Filters("Pasteries", false));
        filtersList.add(new Filters("American", false));
        filtersList.add(new Filters("Chinese", false));
        filtersList.add(new Filters("Mexican", false));
        filtersList.add(new Filters("Lunch", false));
        filtersList.add(new Filters("Fast Food", false));
        return  filtersList;
    }

    public void reset() {
        for (Filters filter : filters) {
            filter.setChecked(false);
        }
    }

    public List<Filters> getFilters() {
        return filters;
    }
}
