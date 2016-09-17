package mykitab.mykitabcomptepu.DBMS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import mykitab.mykitabcomptepu.ADAPTERS.ListAdapterUnitSelection;
import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 25/07/2016.
 */
public class DbmsMain extends AppCompatActivity {

    private ListView listView;
    private String web[] = {
            "Unit-1",
            "Unit-2",
            "Unit-3",
            "Unit-4",
            "Unit-5",
            "Unit-6"
    };
    private Integer imageid[] = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.che
    };
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universal_listview_mainsub);
        //Toolbar With Back Action Button
// Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-3703525445460778~4792780040");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()

                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
        //Initialise Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //Initialise Back Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("DBMS");
        ListAdapterUnitSelection customList = new ListAdapterUnitSelection(this, web, imageid);

        listView = (ListView) findViewById(R.id.sub_daa_all);
        listView.setAdapter(customList);

        if (myToolbar != null) {
            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitOne.class);
                    startActivity(intent);
                }
                if (i == 1) {

                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitTwo.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitThree.class);
                    startActivity(intent);
                }
                if (i == 3) {

                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitFour.class);
                    startActivity(intent);
                }
                if (i == 4) {

                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitFive.class);
                    startActivity(intent);
                }
                if (i == 5) {

                    Intent intent = new Intent(DbmsMain.this, mykitab.mykitabcomptepu.DBMS.DBMSUnitSix.class);
                    startActivity(intent);
                }
            }
        });

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


