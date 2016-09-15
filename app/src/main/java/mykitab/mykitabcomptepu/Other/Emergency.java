package mykitab.mykitabcomptepu.Other;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import mykitab.mykitabcomptepu.R;

/**
 * Created by Admin on 17/08/2016.
 */
public class Emergency extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, con1, con2, con3, con4, con5, ema1, ema2, ema3, ema4, ema5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.emergency_2);
        //Toolbar With Back Action Button
        //Initialise Toolbar

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //Initialise Back Button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Emergency");

        if (myToolbar != null) {
            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
        }
        con1 = (TextView)findViewById(R.id.con1);
        con1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "coe@unipune.ac.in", null));

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        con2 = (TextView)findViewById(R.id.con2);
        con2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "certificate@unipune.ac.in", null));

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        con3 = (TextView)findViewById(R.id.con3);
        con3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "certificate@unipune.ac.in", null));

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        con4 = (TextView)findViewById(R.id.con4);
        con4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "intcent@unipune.ac.in", null));

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });


    }
}

