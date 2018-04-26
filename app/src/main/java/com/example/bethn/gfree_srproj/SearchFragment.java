package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

import static com.example.bethn.gfree_srproj.MapsActivity.MAP_ZIP;

/**
 * Created by bethn on 3/30/2018.
 */

public class SearchFragment extends Fragment implements RestaurantAdapter.RestaurantAdapterItemSelected {
    private EditText searchBox;
    private ListView searchResults;
    private RestaurantDataProvider restaurantDataProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        searchBox = (EditText) view.findViewById(R.id.search_box);
        searchResults = (ListView) view.findViewById(R.id.search_results);
        restaurantDataProvider = AppSession.getInstance().getRestaurantDataProvider();

        final RestaurantAdapter rAdapter = new RestaurantAdapter(getActivity(),0, this);
        final List<Restaurant> fullList = restaurantDataProvider.getRestaurants();//returns restaurant list from dataProvider
        rAdapter.setRestaurants(fullList);
        searchResults.setAdapter(rAdapter);


        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Restaurant> filteredRestaurants = new ArrayList<>();

                for(Restaurant restaurant : restaurantDataProvider.getRestaurants()){

                    if(restaurant.getName().toLowerCase().contains(s.toString().toLowerCase())){
                        filteredRestaurants.add(restaurant);
                    }
                }
                rAdapter.setRestaurants(filteredRestaurants);
                rAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return view;
    }


    @Override
    public void restaurantSelected(Restaurant restaurant) {
        Intent intent = new Intent(getActivity(), RestaurantInfoActivity.class);
        intent.putExtra(RestaurantInfoActivity.RESTAURANT_SELECTED, restaurant);
        startActivity(intent);
    }
}
