package mykitab.mykitabcomptepu.ADAPTERS;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 26/06/2016.
 */
public class ListAdapterUnitSelection extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;

        public ListAdapterUnitSelection (Activity context,
                           String[] web, Integer[] imageId) {
            super(context, R.layout.list_layout_unitselection, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;

        }


        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list_layout_unitselection, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            return rowView;
        }
}