package mykitab.mykitabcomptepu.MAIN_SCREEN;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import mykitab.mykitabcomptepu.ADAPTERS.EmAdapter;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewDocs;
import mykitab.mykitabcomptepu.XmlParsers.Employee;
import mykitab.mykitabcomptepu.XmlParsers.XMLPullParserHandler;

/**
 * Created by Admin on 25/08/2016.
 */
public class PLOne extends AppCompatActivity {
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
        getSupportActionBar().setTitle("PL One");
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


                String pdf = mAdapter.getItem(position).getLink();
                Intent intent = new Intent(getApplicationContext(), WebViewDocs.class);
                intent.putExtra("pdf", pdf);

                startActivity(intent);


            }
        });
        List<Employee> employees;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            employees = parser.parse(getAssets().open("pl_one.xml"));
            ArrayAdapter<Employee> adapter =

                    mAdapter = new EmAdapter(this, employees);
            listView.setAdapter(mAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

