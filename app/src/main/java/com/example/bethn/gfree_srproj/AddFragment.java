package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;

/**
 * Created by bethn on 4/7/2018.
 */

public class AddFragment extends Fragment {
    private EditText restaurantName;
    private EditText restaurantAddress;
    private RatingBar ratingBar;
    private Spinner priceSelector;
    private CheckBox seperateMenu;
    private EditText itemName;
    private FiltersDataProvider filtersData;
    private ListView filtersListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_restaurant_fragment, container, false);

        restaurantName = (EditText) view.findViewById(R.id.restaurantNameEditText);
        restaurantAddress = (EditText) view.findViewById(R.id.addAddressEditText);
        ratingBar = (RatingBar) view.findViewById(R.id.restaurantRatingBar);
        priceSelector = (Spinner) view.findViewById(R.id.priceSelector);
        seperateMenu = (CheckBox) view.findViewById(R.id.seperateMenuCheckBox);
        itemName = (EditText) view.findViewById(R.id.itemNameText);

        filtersListView = (ListView) view.findViewById(R.id.filters_list_view);
        filtersData = new FiltersDataProvider();

        final FiltersAdapter fAdapter = new FiltersAdapter(getActivity(), filtersData.filterStuff());

        filtersListView.setAdapter(fAdapter);

        return view;
    }

    public Restaurant createRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurant.getName());

        return restaurant;
    }
}
