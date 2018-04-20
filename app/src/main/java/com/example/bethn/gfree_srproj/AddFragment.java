package com.example.bethn.gfree_srproj;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/7/2018.
 */

public class AddFragment extends Fragment {
    private EditText restaurantName;
    private EditText restaurantAddress;
    private Spinner ratingBar;
    private Spinner priceSelector;
    private CheckBox seperateMenu;
    private EditText itemName;
    private List<Filters> filters;
    private FiltersDataProvider filtersData;
    private Spinner filtersListSpinner;
    private RestaurantDataProvider restaurantDataProvider;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_restaurant_fragment, container, false);

        restaurantDataProvider = new RestaurantDataProvider(getActivity());

        restaurantName = (EditText) view.findViewById(R.id.restaurantNameEditText);
        restaurantAddress = (EditText) view.findViewById(R.id.addAddressEditText);
        ratingBar = (Spinner) view.findViewById(R.id.ratingBar);
        priceSelector = (Spinner) view.findViewById(R.id.priceSelector);
        seperateMenu = (CheckBox) view.findViewById(R.id.seperateMenuCheckBox);
        itemName = (EditText) view.findViewById(R.id.itemNameText);
        filtersListSpinner = (Spinner) view.findViewById(R.id.filters_spinner);

        //NEEDS TO BE ABLE TO SELECT MULTIPLE FILTERS
        //use alert box to display checkbox listview
        filtersData = new FiltersDataProvider();
        final  List<String> filtersList = new ArrayList<>();
        for(String filter : filtersData.filterStuff()){
            filtersList.add(filter);
        }
        ArrayAdapter fAdapter = new ArrayAdapter<String>(getActivity(),R.layout.checked_textview, filtersList);
        filtersListSpinner.setAdapter(fAdapter);

        List<String> pRL = new ArrayList<String>();
        for (PriceRange range : PriceRange.values()) {
            pRL.add(range.getPriceRange());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.checked_textview, pRL);
        priceSelector.setAdapter(adapter);

        String[] stars = new String[]{"1","2","3","4","5"};
        ArrayAdapter<String> starAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.star_checked_textview, stars);
        ratingBar.setAdapter(starAdapter);


        restaurantName.setText(AppSession.getInstance().getName());

        Button finishedAdding = (Button) view.findViewById(R.id.doneAddInfoButton);

        finishedAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(restaurantName.getText().length() == 0 || restaurantAddress.getText().length() == 0){
                    showAlertDialogButtonClicked(v);
                }
                else {
                    //add restaurant info from createRestaurant to restaurantList
                    restaurantDataProvider.addRestaurantToDatabase(createRestaurant());

                    //go back to home screen
                    startActivity(new Intent(AddFragment.this.getActivity(), MainActivity.class));
                }

            }
        });


        return view;
    }

    public Restaurant createRestaurant() {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(restaurantName.getText().toString());
        newRestaurant.setAddress(restaurantAddress.getText().toString());
        newRestaurant.setPhone("123-234-4521");
        newRestaurant.setFoodType(FoodType.FASTFOOD);
        newRestaurant.setType("type");
        newRestaurant.setPriceRange(PriceRange.$);
        List<Item> menu = new ArrayList<>();
        Item fakemenu = new Item("chicken nuggets", "nuggets of chicken",
                7.95, MenuSection.ENTREE, false);
        menu.add(fakemenu);
        newRestaurant.setMenu(menu);


        return newRestaurant;
    }


    public void showAlertDialogButtonClicked(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Invalid Input");
        builder.setMessage("Name and Location are required fields");

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
