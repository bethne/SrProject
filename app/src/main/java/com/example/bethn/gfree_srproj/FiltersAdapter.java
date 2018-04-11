package com.example.bethn.gfree_srproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bethn on 4/9/2018.
 */

public class FiltersAdapter extends ArrayAdapter<Filters> {

    private LayoutInflater layoutInflater;

    public FiltersAdapter(Context context, List<Filters> filtersList) {
        super(context, R.layout.checkbox_row, R.id.rowTextView, filtersList);
        layoutInflater = LayoutInflater.from(context);//should this be .from(getContext()) or (getActivity())??
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        CheckBox checkBox;
        TextView textView;
        FiltersViewHolder filtersViewHolder;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.checkbox_row, parent, false);

            textView = (TextView) view.findViewById(R.id.rowTextView);
            checkBox = (CheckBox) view.findViewById(R.id.CheckBox1);

            filtersViewHolder = new FiltersViewHolder(textView,checkBox);
            view.setTag(filtersViewHolder);

            //if  CheckBox is toggled, update what filters are tagged
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox checkB = (CheckBox) v;
                    Filters filter = (Filters) checkB.getTag();
                    filter.setChecked(checkB.isChecked());
                }
            });
        }
        //reuse existing row view
        else {
            view = convertView;
            filtersViewHolder = (FiltersViewHolder) view.getTag();
            checkBox = filtersViewHolder.getCheckBox();
            textView = filtersViewHolder.getTextView();
        }
        Filters filters = (Filters)this.getItem(position);
        checkBox.setTag(filters);
        checkBox.setChecked(filters.isChecked());
        textView.setText(filters.getName());

        return view;
    }
}
