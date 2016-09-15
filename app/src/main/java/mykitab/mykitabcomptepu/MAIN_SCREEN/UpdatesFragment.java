package mykitab.mykitabcomptepu.MAIN_SCREEN;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import mykitab.mykitabcomptepu.ADAPTERS.ListAdapter;
import mykitab.mykitabcomptepu.R;

/**
 * Created by Admin on 08/08/2016.
 */


public class UpdatesFragment extends Fragment {
    private ListView listView;
    private String web[] = {
            "Programming Language - I",
            "Programming Language - II",

    };
    private Integer imageid[] = {
            R.drawable.pl1,
            R.drawable.pl2,
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        // View Inflater to make findviewbyid work
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.primary_layout, container, false);
        //ListView Adapter
        ListAdapter customList = new ListAdapter(getActivity(), web, imageid);
        // Initialise ListView
        listView = (ListView) mLinearLayout.findViewById(R.id.listView);
        //Set Adapter for listview
        listView.setAdapter(customList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    // String url = "https://drive.google.com/file/d/0B9KvN9r87zbBaXRJT2pVd1lyNXM/view?usp=sharing";
                    Intent intent = new Intent(getActivity(), PLOne.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(getActivity(), PLTwo.class);
                    startActivity(intent);
                }


            }
        });
        return mLinearLayout;

        //return inflated layout
    }
}




