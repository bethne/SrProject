package com.example.bethn.gfree_srproj.examples;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bethn.gfree_srproj.R;

/**
 * Created by bethn on 3/26/2018.
 */

public class ExampleFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_example, container);
        textView = view.findViewById(R.id.example_text_view);
        textView.setText("New text");

        return view;

    }
}
