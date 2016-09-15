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
import mykitab.mykitabcomptepu.CODE_TRAINING.CodeTraining;
import mykitab.mykitabcomptepu.CODE_TRAINING.Code_TABS;
import mykitab.mykitabcomptepu.Other.Emergency;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewLocal;


/**
 * Created by Admin on 08/08/2016.
 */


public class SocialFragment extends Fragment {
    private ListView listView;
    private String web[] = {
            "Programming Training",
            "Emergency Nos.",
            "Pune Local Time - Table "

    };
    private Integer imageid[] = {
            R.drawable.code,
            R.drawable.unicall,
            R.drawable.train
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
                    Intent intent = new Intent(getActivity(), Code_TABS.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(getActivity(), Emergency.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    String url = "file:///android_asset/local.html";
                    Intent intent = new Intent(getActivity(), WebViewLocal.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }

            }
        });
        //return inflated layout
        return mLinearLayout;
    }

    /**
     * Called when leaving the activity
     */

}


