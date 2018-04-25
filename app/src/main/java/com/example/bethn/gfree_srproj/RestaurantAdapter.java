package com.example.bethn.gfree_srproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import junit.framework.Test;

import java.util.List;

/**
 * Created by bethn on 3/30/2018.
 */

public class RestaurantAdapter extends ArrayAdapter {
    private List<Restaurant> restaurants;
    private RestaurantAdapterItemSelected restaurantAdapterItemSelected;

    public RestaurantAdapter(@NonNull Context context, int resource, RestaurantAdapterItemSelected restaurantAdapterItemSelected) {
        super(context, resource);
        this.restaurantAdapterItemSelected = restaurantAdapterItemSelected;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.restaurant_list_item, parent, false);
        }
        else {
            view = convertView;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restaurantAdapterItemSelected != null) {
                    restaurantAdapterItemSelected.restaurantSelected(restaurants.get(position));
                }
            }
        });

        TextView restaurantName = (TextView) view.findViewById(R.id.restaurant_name);
        restaurantName.setText(restaurants.get(position).getName());

        return view;
    }

    public interface RestaurantAdapterItemSelected {
        public void restaurantSelected(Restaurant restaurant);
    }
}
