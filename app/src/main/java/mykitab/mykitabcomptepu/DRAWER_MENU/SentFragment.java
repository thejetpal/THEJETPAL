package mykitab.mykitabcomptepu.DRAWER_MENU;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import mykitab.mykitabcomptepu.ADAPTERS.EmAdapter;
import mykitab.mykitabcomptepu.ADAPTERS.ListAdapterDrawer;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;

/**
 * Created by Ratan on 7/29/2015.
 */
public class SentFragment extends Fragment {
    private ListView listView;
    private String web[] = {
            "TOC",
            "OSD",
            "DC & WSN",
            "DMSA",
            "CFCA",
            "PL - 1",
            "PL - 2"
    };
    private EmAdapter mAdapter;
    private AdView mAdView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }


        View rootView = inflater.inflate(R.layout.sent_layout, container, false); //modified

        Toolbar myToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        myToolbar.setTitle("Syllabus");
        myToolbar.setTitleTextColor(0xFFFFFFFF);

        MobileAds.initialize(getActivity(), "ca-app-pub-3703525445460778~4792780040");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) rootView.findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()

                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
        ListAdapterDrawer adapter = new ListAdapterDrawer(getActivity(), web);

        listView = (ListView) rootView.findViewById(R.id.syllabus); //modified
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/TOC.html";
                    String ques = "TOC";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 1) {

                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/OSD.html";
                    String ques = "OSD";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 2) {
                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/DCWSN.html";
                    String ques = "DC & WSN";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 3) {

                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/DMSA.html";
                    String ques = "DMSA";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 4) {

                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/CFCA.html";
                    String ques = "CFCA";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 5) {

                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/CP1.html";
                    String ques = "PL - 1";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 6) {

                    String url = "https://mykitab-te.firebaseapp.com/Syllabus/CP2.html";
                    String ques = "PL - 2";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }

            }
        });


        return rootView; //added
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

