package com.example.bethn.gfree_srproj;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

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
    private List<Filters> filters;
    private FiltersDataProvider filtersData;
    private ListView filtersListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_restaurant_fragment, container, false);

       // Intent intent = getIntent();
        //String name = intent.getStringExtra("name");
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
                    AppSession.getInstance().getList().add(createRestaurant());

                    //go back to home screen
                    startActivity(new Intent(AddFragment.this.getActivity(), MainActivity.class));
                }

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setNumStars(Math.round(rating));
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
