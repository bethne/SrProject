package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 3/30/2018.
 */

public enum MenuSection {
    DRINKS("Drinks"),
    APPETIZER("Apps"),
    ENTREE("Entrees"),
    SANDWICHES("Sandwiches");

    private String name;

    MenuSection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
