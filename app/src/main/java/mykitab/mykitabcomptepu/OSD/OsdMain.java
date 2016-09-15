package mykitab.mykitabcomptepu.OSD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import mykitab.mykitabcomptepu.ADAPTERS.ListAdapterUnitSelection;
import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 25/07/2016.
 */
public class OsdMain extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universal_listview_mainsub);
        //Toolbar With Back Action Button
        //Initialise Toolbar

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //Initialise Back Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("OSD");
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
                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitOne.class);
                    startActivity(intent);
                }
                if (i == 1) {

                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitTwo.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitThree.class);
                    startActivity(intent);
                }
                if (i == 3) {

                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitFour.class);
                    startActivity(intent);
                }
                if (i == 4) {

                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitFive.class);
                    startActivity(intent);
                }
                if (i == 5) {

                    Intent intent = new Intent(OsdMain.this, mykitab.mykitabcomptepu.OSD.OSDUnitSix.class);
                    startActivity(intent);
                }
            }
        });

    }


}


