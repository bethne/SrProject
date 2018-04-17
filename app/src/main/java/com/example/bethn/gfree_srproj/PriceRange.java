package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 3/30/2018.
 */

public enum PriceRange {
    $("$"),
    $$("$$"),
    $$$("$$$"),
    $$$$("$$$$");

    private String priceRange;

    PriceRange(String type) {
        this.priceRange = type;
    }

    public String getPriceRange() {
        return priceRange;
    }
}
