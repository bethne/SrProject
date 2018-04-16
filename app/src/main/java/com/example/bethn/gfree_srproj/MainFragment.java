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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by bethn on 3/30/2018.
 */

public class MainFragment extends Fragment {
    private RadioButton currLocSearch;
    private RadioButton zipSearch;
    private RadioButton currLocAdd;
    private RadioButton byNameAdd;
    private EditText zipSearchLoc;
    private EditText nameAddLoc;
    private RadioGroup searchRg;
    private RadioGroup addRg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);

        //final View addView = inflater.inflate(R.layout.add_restaurant_fragment, container, false);

        currLocSearch = (RadioButton) view.findViewById(R.id.searchCurrLocRadioButton);
        zipSearch = (RadioButton) view.findViewById(R.id.searchZipRadioButton);
        currLocAdd = (RadioButton) view.findViewById(R.id.addCurrLocRadioButton);
        byNameAdd = (RadioButton) view.findViewById(R.id.addByNameRadioButton);
        zipSearchLoc = (EditText) view.findViewById(R.id.zipSearchEditText);
        nameAddLoc = (EditText) view.findViewById(R.id.nameAddLocEditText);

        TextView ifSearch = (TextView) view.findViewById(R.id.searchLabel);
        TextView ifAdd = (TextView) view.findViewById(R.id.addLabel);
        final LinearLayout addll = (LinearLayout) view.findViewById(R.id.add_linear_layout);
        final LinearLayout searchll = (LinearLayout) view.findViewById(R.id.search_linear_layout);
        searchll.setVisibility(View.GONE);
        addll.setVisibility(View.GONE);
        ifSearch.isClickable();
        ifSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchll.getVisibility() == View.GONE) {
                    searchll.setVisibility(View.VISIBLE);
                    addll.setVisibility(View.GONE);
                }
                else {
                    searchll.setVisibility(View.GONE);
                }

            }
        });

        ifAdd.isClickable();
        ifAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addll.getVisibility() == View.GONE) {
                    addll.setVisibility(View.VISIBLE);
                    searchll.setVisibility(View.GONE);
                }
                else{
                    addll.setVisibility(View.GONE);
                }
            }
        });

        final Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setEnabled(false);
        final Button searchButton = (Button) view.findViewById(R.id.searchButton);
        searchButton.setEnabled(false);
        nameAddLoc.setEnabled(false);
        zipSearchLoc.setEnabled(false);

        addRg =(RadioGroup) view.findViewById(R.id.add_radio_group);
        searchRg = (RadioGroup) view.findViewById(R.id.search_radio_group);

        addRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(byNameAdd.isChecked()){
                    nameAddLoc.setEnabled(false);
                    nameAddLoc.setHint("Restaurant Name");
                    nameAddLoc.setEnabled(true);
                   //onTextChange to enable addbutton
                }
                else{
                    nameAddLoc.setEnabled(false);
                    nameAddLoc.setHint("");
                    addButton.setEnabled(true);
                }
               // if(nameAddLoc.getText().length() != 0){
                 //   EditText restaurantName = (EditText) addView.findViewById(R.id.restaurantNameEditText);
                 //   restaurantName.setText("this works");
               // }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent transferName = new Intent(MainFragment.this.getActivity(), AddActivity.class);
                //transferName.putExtra("name", nameAddLoc.getText().toString());
                //startActivity(transferName);
                startActivity(new Intent(MainFragment.this.getActivity(), AddActivity.class));
            }
        });

        searchRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(zipSearch.isChecked()){
                    zipSearchLoc.setHint("zip code");
                    zipSearchLoc.setEnabled(true);
                    searchButton.setEnabled(false);
                }
                else{
                    zipSearchLoc.setEnabled(false);
                    zipSearchLoc.setHint("");
                    searchButton.setEnabled(true);
                }

            }
        });

        zipSearchLoc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchButton.setEnabled(s != null && s.length() == 5);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nameAddLoc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(s != null && nameAddLoc.getText().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameAddLoc.getText().toString();
                AppSession appSession = AppSession.getInstance();
                appSession.setName(name);
                startActivity(new Intent(MainFragment.this.getActivity(), SearchActivity.class));
            }
        });

        return view;
    }

}
