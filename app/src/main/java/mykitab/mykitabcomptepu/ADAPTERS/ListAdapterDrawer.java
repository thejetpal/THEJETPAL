package mykitab.mykitabcomptepu.ADAPTERS;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 24/06/2016.
 */
public class ListAdapterDrawer extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;

    public ListAdapterDrawer(Activity context,
                             String[] web) {
        super(context, R.layout.list_layout_drawer, web);
        this.context = context;
        this.web = web;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_layout_drawer, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(web[position]);


        return rowView;
    }
}
