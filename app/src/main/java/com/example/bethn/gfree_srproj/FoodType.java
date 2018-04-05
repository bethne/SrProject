package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 3/30/2018.
 */

public enum FoodType {
    ITALIAN("Italian"),
    ASIAN("Asian"),
    SANDWICHES("Sandwiches"),
    BBQ("BBQ"),
    GREEK("Greek"),
    MEXICAN("Mexican"),
    FASTFOOD("Fast Food"),
    PIZZA("Pizza");

    private String type;

    FoodType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

