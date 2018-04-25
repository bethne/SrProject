package com.example.bethn.gfree_srproj;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bethn on 4/14/2018.
 */

public class RestaurantInfoActivity extends BaseActivity {
    private Button homeButton;
    public static final String RESTAURANT_SELECTED = "RESTAURANT_SELECTED";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant_info);


        RestaurantInfoFragment restaurantInfoFragment = new RestaurantInfoFragment();
        if (getIntent().getExtras() != null) {
            Restaurant restaurant = getIntent().getExtras().getParcelable(RESTAURANT_SELECTED);
            Bundle args = new Bundle();
            args.putParcelable(RestaurantInfoFragment.RESTAURANT_SELECTED_INFO, restaurant);
            restaurantInfoFragment.setArguments(args);
        }


        final Intent intent = new Intent(this, MainActivity.class);

        homeButton = (Button) findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.restaurant_info_fragment_container, restaurantInfoFragment, RestaurantInfoFragment.class.getName());
        fragmentTransaction.commit();
    }
}
