package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.content.Intent;
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
    private TextView name;
    private TextView location;
    private TextView phone;
    private TextView hours;
    private TextView categoriesLabel;
    private List<Filters> categories;
    private TextView menuLabel;
    private TextView reviewsLabel;
    private Button addReviewButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.restaurant_info_fragment, container, false);

        name = (TextView) view.findViewById(R.id.restaurant_info_name);
        location = (TextView) view.findViewById(R.id.restaurant_info_locations);
        phone = (TextView) view.findViewById(R.id.restaurant_info_phone);
        hours = (TextView) view.findViewById(R.id.restaurant_info_hours);
        categoriesLabel = (TextView) view.findViewById(R.id.restaurant_info_categories);
        menuLabel = (TextView) view.findViewById(R.id.restaurant_info_menu);
        reviewsLabel = (TextView) view.findViewById(R.id.restaurant_info_reviews);
        addReviewButton = (Button) view.findViewById(R.id.add_review_button);

        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestaurantInfoFragment.this.getActivity(), AddActivity.class));
            }
        });




        return view;

    }
}
