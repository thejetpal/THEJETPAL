package mykitab.mykitabcomptepu.C_Programming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.List;

import mykitab.mykitabcomptepu.ADAPTERS.CodeXMLAdapter;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;
import mykitab.mykitabcomptepu.XmlParsers.CodeXML;
import mykitab.mykitabcomptepu.XmlParsers.XMLPullParser;

/**
 * Created by Admin on 04/09/2016.
 */
public class C_Programs extends Fragment {
    private ListView listView;
    private CodeXMLAdapter mAdapter;
    private AdView mAdView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        // Inflate the layout for this fragment
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.c_programs, container, false);
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
        listView = (ListView) mLinearLayout.findViewById(R.id.daa_unit_one);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String ques = mAdapter.getItem(position).getAbout();
                String url = mAdapter.getItem(position).getLink();
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("ques", ques);
                startActivity(intent);


            }
        });
        List<CodeXML> code;
        try {
            XMLPullParser parser = new XMLPullParser();
            code = parser.parse(getActivity().getAssets().open("c_program.xml"));
            ArrayAdapter<CodeXML> adapter =

                    mAdapter = new CodeXMLAdapter(getActivity(), code);
            listView.setAdapter(mAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mLinearLayout;
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


