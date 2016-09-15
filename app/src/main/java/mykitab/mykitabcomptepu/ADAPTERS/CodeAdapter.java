package mykitab.mykitabcomptepu.ADAPTERS;

/**
 * Created by Admin on 21/08/2016.
 */

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mykitab.mykitabcomptepu.R;


public class CodeAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public CodeAdapter(Activity context,
                       String[] web, Integer[] imageId) {
        super(context, R.layout.list_layout_code, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_layout_code, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }

    private AssetManager getAssets() {
        return getAssets();
    }


}