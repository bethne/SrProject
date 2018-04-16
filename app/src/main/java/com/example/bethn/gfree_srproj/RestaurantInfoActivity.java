package com.example.bethn.gfree_srproj;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bethn on 4/14/2018.
 */

public class RestaurantInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant_info);

        getSupportActionBar().hide();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.restaurant_info_fragment_container, new RestaurantInfoFragment(), RestaurantInfoFragment.class.getName());
        fragmentTransaction.commit();
    }
}
