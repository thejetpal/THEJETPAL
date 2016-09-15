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

import mykitab.mykitabcomptepu.ADAPTERS.EmAdapter;
import mykitab.mykitabcomptepu.ADAPTERS.ListAdapterDrawer;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;


/**
 * Created by Admin on 17/07/2016.
 */
public class PreviousQuestionPapers extends Fragment {


    private ListView listView;
    private String web[] = {
            "DAA  30M ( 2015 )", "SSDA 30M ( 2015 )", "TOC 30M ( 2015 )"
    };
    private EmAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.questionpapers, container, false);
        Toolbar myToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        myToolbar.setTitle("Previous Question Papers");
        myToolbar.setTitleTextColor(0xFFFFFFFF);
        ListAdapterDrawer adapter = new ListAdapterDrawer(getActivity(), web);

        listView = (ListView) rootView.findViewById(R.id.syllabus); //modified
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    String url = "https://drive.google.com/file/d/0B_0TIrXF4IqXa19LdmJqNkl4V3M/view?ts=5798f9c1";
                    String ques = "DAA (2015)";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 1) {
                    String url = "https://drive.google.com/file/d/0B_0TIrXF4IqXbDI4azlYWWZUbEE/view?ts=5798f9ed";
                    String ques = "SSDA (2015)";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (i == 2) {
                    String url = "https://drive.google.com/file/d/0B_0TIrXF4IqXeHlNRXgzME15dDQ/view?ts=5798f9e0";
                    String ques = "PMCD (2015)";
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
            }
        });


        return rootView; //added
    }


    /** Called when leaving the activity */

}


