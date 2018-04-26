package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bethn on 4/14/2018.
 */

public class RestaurantInfoFragment extends Fragment {
    public static final String RESTAURANT_SELECTED_INFO = "RESTAURANT_SELECTED_INFO";

    private TextView name;
    private TextView location;
    private RatingBar rating;
    private TextView phone;
    private TextView hours;
    private TextView categoriesLabel;
    private ListView filtersListView;
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
        rating = (RatingBar) view.findViewById(R.id.num_of_stars);
        phone = (TextView) view.findViewById(R.id.restaurant_info_phone);
        hours = (TextView) view.findViewById(R.id.restaurant_info_hours);
        categoriesLabel = (TextView) view.findViewById(R.id.categories_label);
        filtersListView = (ListView) view.findViewById(R.id.filters_listview);
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
            restaurant = getArguments().getParcelable(RESTAURANT_SELECTED_INFO);
        }

        name.setText(restaurant.getName().toString());
        location.setText(restaurant.getAddress().toString());
        rating.setNumStars(Integer.parseInt(restaurant.getRating()));
        phone.setText("Phone: " + restaurant.getPhone().toString());
        hours.setText(restaurant.getHours().toString());

        List<String> filters = restaurant.getFilters();
        ArrayAdapter<String> fAdapter = new ArrayAdapter<String>(RestaurantInfoFragment.this.getActivity(),
                R.layout.checked_textview, filters);
        filtersListView.setAdapter(fAdapter);

        return view;

    }
}
