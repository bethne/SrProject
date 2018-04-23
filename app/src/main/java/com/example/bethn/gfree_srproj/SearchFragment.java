package com.example.bethn.gfree_srproj;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class SearchFragment extends Fragment {
    private EditText searchBox;
    private ListView searchResults;
    private RestaurantDataProvider restaurantDataProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        searchBox = (EditText) view.findViewById(R.id.search_box);
        searchResults = (ListView) view.findViewById(R.id.search_results);
        restaurantDataProvider = AppSession.getInstance().getRestaurantDataProvider();

        final RestaurantAdapter rAdapter = new RestaurantAdapter(getActivity(),0);
        final List<Restaurant> fullList = restaurantDataProvider.getRestaurants();//returns restaurant list from dataProvider
        rAdapter.setRestaurants(fullList);
        searchResults.setAdapter(rAdapter);

        Button mapButton = (Button) view.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SearchFragment.this.getActivity(), MapsActivity.class));

            }
        });


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

        searchResults.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//               Intent intent = new Intent(SearchFragment.this.getActivity(),RestaurantInfoActivity.class);
//               // intent.putExtra("info", clicked);
//                startActivity(intent);

            }
        });



        return view;
    }


}
