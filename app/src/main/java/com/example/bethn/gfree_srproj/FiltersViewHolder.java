package com.example.bethn.gfree_srproj;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by bethn on 4/9/2018.
 * holds child views for a single row
 */

public class FiltersViewHolder {
    private TextView textView;
    private CheckBox checkBox;

    public FiltersViewHolder() {
    }

    public FiltersViewHolder(TextView textView, CheckBox checkBox) {
        this.textView = textView;
        this.checkBox = checkBox;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
