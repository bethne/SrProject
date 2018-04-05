package com.example.bethn.gfree_srproj.examples;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.bethn.gfree_srproj.R;

/**
 * Created by bethn on 3/26/2018.
 */

public class ExampleActivity extends Activity {
    private final static String fragmentTag = "This doesnt matter, you just need this string when" +
            "you want to retrieve your fragment, as its how you find it";
    private ExampleFragment exampleFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        if (savedInstanceState == null) {
        exampleFragment = new ExampleFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.example_frame_layout, exampleFragment, fragmentTag);
        transaction.commit();
        }

    }
}
