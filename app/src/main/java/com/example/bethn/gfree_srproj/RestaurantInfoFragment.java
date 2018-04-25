package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bethn on 4/14/2018.
 */

public class RestaurantInfoFragment extends Fragment {
    public static final String RESTAURANT_SELECTED_INFO = "RESTAURANT_SELECTED_INFO";

    private TextView name;
    private TextView location;
    private TextView phone;
    private TextView hours;
    private TextView categoriesLabel;
    private List<Filters> categories;
    private TextView menuLabel;
    private TextView reviewsLabel;
    private Button addReviewButton;

    private Restaurant restaurant;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.restaurant_info_fragment, container, false);

        this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        name = (TextView) view.findViewById(R.id.restaurant_name);
        location = (TextView) view.findViewById(R.id.restaurant_info_locations);
        phone = (TextView) view.findViewById(R.id.restaurant_info_phone);
        hours = (TextView) view.findViewById(R.id.restaurant_info_hours);
        categoriesLabel = (TextView) view.findViewById(R.id.categories_label);
        menuLabel = (TextView) view.findViewById(R.id.menu_label);
        reviewsLabel = (TextView) view.findViewById(R.id.restaurant_info_reviews);
        addReviewButton = (Button) view.findViewById(R.id.add_review_button);

        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestaurantInfoFragment.this.getActivity(), AddActivity.class));
            }
        });

        Restaurant restaurant = null;
        if (getArguments() != null) {
            getArguments().getParcelable(RESTAURANT_SELECTED_INFO);
        }




        return view;

    }
}
