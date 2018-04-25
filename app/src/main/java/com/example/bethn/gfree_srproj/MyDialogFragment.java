package com.example.bethn.gfree_srproj;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by bethn on 4/24/2018.
 */

public class MyDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ListView listView = (ListView) inflater.inflate(R.layout.dialog_list, container, false);
        FiltersDataProvider filtersDataProvider = AppSession.getInstance().getFiltersDataProvider();
        FiltersAdapter filtersAdapter = new FiltersAdapter(getActivity(),filtersDataProvider.getFilters());
        listView.setAdapter(filtersAdapter);



        return listView;
    }
}
