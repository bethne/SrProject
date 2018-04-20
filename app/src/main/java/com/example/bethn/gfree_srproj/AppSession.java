package com.example.bethn.gfree_srproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bethn on 4/12/2018.
 */

public class AppSession {

    private static AppSession single_instance = null;
    private String name;


    public static AppSession getInstance()
    {
        if (single_instance == null) {
            single_instance = new AppSession();
        }
        return single_instance;
    }

    private AppSession() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
