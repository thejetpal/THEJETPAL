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
import mykitab.mykitabcomptepu.CFCA.CfcaMain;
import mykitab.mykitabcomptepu.DBMS.DbmsMain;
import mykitab.mykitabcomptepu.DCWSN.DcwsnMain;
import mykitab.mykitabcomptepu.OSD.OsdMain;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.TOC.TocMain;


public class PrimaryFragment extends Fragment {
    private ListView listView;
    private String web[] = {
            "Theory Of Computation",
            "Operating System Design ",
            "Data Communication & WSN",
            "Database Management",
            "Cyber Forensics",

    };
    private Integer imageid[] = {
            R.drawable.toc,
            R.drawable.osd,
            R.drawable.dcwsn,
            R.drawable.dmsa,
            R.drawable.cfca
    };
    //  private AdView adView;

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
        //Set on item click for listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getActivity(), TocMain.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(getActivity(), OsdMain.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(getActivity(), DcwsnMain.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(getActivity(), DbmsMain.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(getActivity(), CfcaMain.class);
                    startActivity(intent);
                }

            }
        });

        //return inflated layout
        return mLinearLayout;
    }
    /** Called when leaving the activity */


}
