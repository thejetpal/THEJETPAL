package mykitab.mykitabcomptepu.CODE_TRAINING;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import mykitab.mykitabcomptepu.ADAPTERS.CodeAdapter;
import mykitab.mykitabcomptepu.C_Programming.C;
import mykitab.mykitabcomptepu.C_Programming.C_Tabs;
import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 20/08/2016.
 */
public class CodeTraining extends AppCompatActivity {

    private ListView listView;
    private String web[] = {
            "C",
            "C++",
            "Java",
            "Data Structures",
            "Ruby",
            "JSP"
    };
    private Integer imageid[] = {
            R.drawable.tutorial_c_icon,
            R.drawable.tutorial_cplusplus_icon,
            R.drawable.tutorial_java_icon,
            R.drawable.tutorial_data_structures_icon,
            R.drawable.tutorial_ruby_icon,
            R.drawable.tutorial_jsp_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universal_listview_code);

        //Initialise Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(second);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Let's Code!");
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
        CodeAdapter customList = new CodeAdapter(this, web, imageid);

        listView = (ListView) findViewById(R.id.sub_daa_all);
        listView.setAdapter(customList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(CodeTraining.this, C_Tabs.class);
                    startActivity(intent);
                }
            /*    if (i == 1) {

                    Intent intent = new Intent(CodeTraining.this, mykitab.mykitabcomptepu.CODE_TRAINING.CPlusPlus.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(CodeTraining.this, mykitab.mykitabcomptepu.CODE_TRAINING.Java.class);
                    startActivity(intent);
                }
                if (i == 3) {

                    Intent intent = new Intent(CodeTraining.this, mykitab.mykitabcomptepu.CODE_TRAINING.DataStructures.class);
                    startActivity(intent);
                }
                if (i == 4) {

                    Intent intent = new Intent(CodeTraining.this, mykitab.mykitabcomptepu.CODE_TRAINING.Ruby.class);
                    startActivity(intent);
                }
                if (i == 5) {

                    Intent intent = new Intent(CodeTraining.this, mykitab.mykitabcomptepu.CODE_TRAINING.JSP.class);
                    startActivity(intent);
                }*/
            }
        });
    }

}
