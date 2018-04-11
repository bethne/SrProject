package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 4/9/2018.
 */

public class Filters {
    private String name = "";
    private boolean checked = false;

    public Filters() {
    }

    public Filters(String name) {
        this.name = name;
    }

    public Filters(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void toggleChecked() {
        checked = !checked;
    }
}
