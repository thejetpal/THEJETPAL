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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

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
    private AdView mAdView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        // View Inflater to make findviewbyid work
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.primary_layout, container, false);
        MobileAds.initialize(getActivity(), "ca-app-pub-3703525445460778~4792780040");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) mLinearLayout.findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()

                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
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
    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}




