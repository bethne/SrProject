package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bethn on 4/4/2018.
 */

public class RestaurantDataProvider {

    public List<Restaurant> makeStuff() {
        List<Restaurant> restaurant = new ArrayList<>();
        List<Item> menu = new ArrayList<>();
        Item fakemenu = new Item("chicken nuggets", "nuggets of chicken",
                7.95, MenuSection.ENTREE, false);
        menu.add(fakemenu);

        Restaurant chickfila = new Restaurant("Chick-Fil-A", "123 BrentWood Dr.",
                "314-123-4562", "fast food", "9a-9p", PriceRange.$, FoodType.FASTFOOD, menu);
        restaurant.add(chickfila);

        Restaurant lionschoice = new Restaurant("Lions Choice", "127 BrentWood Dr.",
                "314-123-4982", "fast food", "9a-10p", PriceRange.$, FoodType.FASTFOOD, menu);
        restaurant.add(lionschoice);

        Restaurant fitzs = new Restaurant("Fitz's", "48 Delmar Blvd",
                "314-555-4592", "change later", "10a-10p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurant.add(fitzs);

        Restaurant threekings = new Restaurant("Three Kings", "50 Delmar Blvd",
                "314-553-6322", "fast food", "9a-9p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurant.add(threekings);

        Restaurant huhot = new Restaurant("Hu Hot", "13 Creve Couer Rd.",
                "314-555-3653", "Dont think i need this in Restaurant class", "9a-9p", PriceRange.$$$, FoodType.ASIAN, menu);
        restaurant.add(huhot);

        Restaurant newday = new Restaurant("New Day GF", "14 Somewhere Ln",
                "314-555-9273", "blah... pancakes/pasteries", "7a-3p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurant.add(newday);

        Restaurant pi = new Restaurant("Pi Pizza", "58 Delmar Blvd",
                "314-555-8842", "pizza", "11a-11p", PriceRange.$$$, FoodType.PIZZA, menu);
        restaurant.add(pi);

        Restaurant pifive = new Restaurant("Pi Five", "159 Brentwood Blvd",
                "314-555-1111", "pizzas", "10a-9p", PriceRange.$$, FoodType.PIZZA, menu);
        restaurant.add(pifive);

        Restaurant fivestar = new Restaurant("Five Star Burger", "1 A Place",
                "314-555-9400", "burgers", "9a-10p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurant.add(fivestar);

        Restaurant firstwatch = new Restaurant("First Watch", "19 Some Pl",
                "314-555-2020", "brunch", "7a-7p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurant.add(firstwatch);

        return restaurant;

    }



}
