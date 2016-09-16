package mykitab.mykitabcomptepu.DCWSN;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.io.IOException;
import java.util.List;

import mykitab.mykitabcomptepu.ADAPTERS.EmAdapter;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;
import mykitab.mykitabcomptepu.XmlParsers.Employee;
import mykitab.mykitabcomptepu.XmlParsers.XMLPullParserHandler;

/**
 * Created by Admin on 29/06/2016.
 */
public class DCWSNUnitFive extends AppCompatActivity {
    private ListView listView;
    private EmAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universal_listview_units);

        //Initialise Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(second);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("DCWSN Unit Five");
        //Initialise Back Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (myToolbar != null) {
            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        listView = (ListView) findViewById(R.id.daa_unit_one);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String ques = mAdapter.getItem(position).getAbout();
                String url = mAdapter.getItem(position).getLink();
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("ques", ques);
                startActivity(intent);


            }
        });
        List<Employee> employees;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            employees = parser.parse(getAssets().open("dcwsn_unit_five.xml"));
            ArrayAdapter<Employee> adapter =

                    mAdapter = new EmAdapter(this, employees);
            listView.setAdapter(mAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /** Called when leaving the activity */

}