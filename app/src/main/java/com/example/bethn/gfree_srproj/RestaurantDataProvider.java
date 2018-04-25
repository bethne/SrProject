package com.example.bethn.gfree_srproj;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/4/2018.
 */

public class RestaurantDataProvider {
    private final static String RESTAURANTS_REF = "restaurants";
    private List<Restaurant> restaurants;
    private DatabaseReference dbRef;

    String newCond;

    public RestaurantDataProvider() {
        dbRef = (DatabaseReference) FirebaseDatabase.getInstance().getReference(RESTAURANTS_REF);
        restaurants = getRestaurantsFromDatabase();
    }

    public String getNewCond()
    {
        return newCond;
    }

    public void setNewCond(String cond)
    {
        newCond = cond;
    }

    private List<Restaurant> getRestaurantsFromDatabase() {
        final List<Restaurant> restaurantList = new ArrayList<>();

        //issue because only called on data change

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                 //to emulate a datachange
//                String cond = dataSnapshot.child("condition").getValue().toString();
//                setNewCondition(cond);
//                textbox.setText(fobject.getNewCondition());

                for (DataSnapshot restaurantSnap : dataSnapshot.getChildren()) {
                    restaurantList.add(restaurantSnap.getValue(Restaurant.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return restaurantList;
    }

    public void addRestaurantToDatabase(Restaurant restaurant){

        dbRef.child(dbRef.push().getKey()).setValue(restaurant);



    }




        /*
        List<Restaurant> restaurantList = new ArrayList<>();
        List<Item> menu = new ArrayList<>();
        Item fakemenu = new Item("chicken nuggets", "nuggets of chicken",
                7.95, MenuSection.ENTREE, false);
        menu.add(fakemenu);

        Restaurant chickfila = new Restaurant("Chick-Fil-A", "123 BrentWood Dr.",
                "314-123-4562", "fast food", "9a-9p", PriceRange.$, FoodType.FASTFOOD, menu);
        restaurantList.add(chickfila);

        Restaurant lionschoice = new Restaurant("Lions Choice", "127 BrentWood Dr.",
                "314-123-4982", "fast food", "9a-10p", PriceRange.$, FoodType.FASTFOOD, menu);
        restaurantList.add(lionschoice);

        Restaurant fitzs = new Restaurant("Fitz's", "48 Delmar Blvd",
                "314-555-4592", "change later", "10a-10p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurantList.add(fitzs);

        Restaurant threekings = new Restaurant("Three Kings", "50 Delmar Blvd",
                "314-553-6322", "fast food", "9a-9p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurantList.add(threekings);

        Restaurant huhot = new Restaurant("Hu Hot", "13 Creve Couer Rd.",
                "314-555-3653", "Dont think i need this in Restaurant class", "9a-9p", PriceRange.$$$, FoodType.ASIAN, menu);
        restaurantList.add(huhot);

        Restaurant newday = new Restaurant("New Day GF", "14 Somewhere Ln",
                "314-555-9273", "blah... pancakes/pasteries", "7a-3p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurantList.add(newday);

        Restaurant pi = new Restaurant("Pi Pizza", "58 Delmar Blvd",
                "314-555-8842", "pizza", "11a-11p", PriceRange.$$$, FoodType.PIZZA, menu);
        restaurantList.add(pi);

        Restaurant pifive = new Restaurant("Pi Five", "159 Brentwood Blvd",
                "314-555-1111", "pizzas", "10a-9p", PriceRange.$$, FoodType.PIZZA, menu);
        restaurantList.add(pifive);

        Restaurant fivestar = new Restaurant("Five Star Burger", "1 A Place",
                "314-555-9400", "burgers", "9a-10p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurantList.add(fivestar);

        Restaurant firstwatch = new Restaurant("First Watch", "19 Some Pl",
                "314-555-2020", "brunch", "7a-7p", PriceRange.$$$, FoodType.SANDWICHES, menu);
        restaurantList.add(firstwatch);

        return restaurantList;

        */

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
