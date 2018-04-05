package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 3/30/2018.
 */

public class SearchFragment extends Fragment {
    private EditText searchBox;
    private ListView searchResults;
    private RestaurantDataProvider data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        searchBox = (EditText) view.findViewById(R.id.search_box);
        searchResults = (ListView) view.findViewById(R.id.search_results);

        data = new RestaurantDataProvider();

        final RestaurantAdapter rAdapter = new RestaurantAdapter(getActivity(),0);
        rAdapter.setRestaurants(data.makeStuff());
        searchResults.setAdapter(rAdapter);

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Restaurant> filteredRestaurants = new ArrayList<>();

                for(Restaurant restaurant : data.makeStuff()){

                    if(restaurant.getName().contains(s)){
                        filteredRestaurants.add(restaurant);
                    }
                }
                rAdapter.setRestaurants(filteredRestaurants);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }


}
