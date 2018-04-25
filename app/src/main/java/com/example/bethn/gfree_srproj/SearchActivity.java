package com.example.bethn.gfree_srproj;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by bethn on 3/30/2018.
 */

public class SearchActivity extends BaseActivity {

    private Button toolbarButton;
    private Button homeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Intent homeintent = new Intent(this, MainActivity.class);

        homeButton = (Button) findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeintent);
            }
        });

        final Intent intent = new Intent(this, MapsActivity.class);

        toolbarButton = (Button) findViewById(R.id.toolbar_button);
        toolbarButton.setText("Map");
        toolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.search_fragment_container, new SearchFragment(), SearchFragment.class.getName());
        fragmentTransaction.commit();

    }


}
