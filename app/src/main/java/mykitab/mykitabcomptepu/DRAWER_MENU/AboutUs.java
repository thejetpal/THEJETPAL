package mykitab.mykitabcomptepu.DRAWER_MENU;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 16/07/2016.
 */
public class AboutUs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.about_us, container, false);
        Toolbar myToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        myToolbar.setTitle("About Us");
        myToolbar.setTitleTextColor(0xFFFFFFFF);
        return rootView;
    }
}