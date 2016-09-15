package mykitab.mykitabcomptepu.C_Programming;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import mykitab.mykitabcomptepu.ADAPTERS.CodeXMLAdapter;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;
import mykitab.mykitabcomptepu.XmlParsers.CodeXML;
import mykitab.mykitabcomptepu.XmlParsers.XMLPullParser;

public class C extends Fragment {
    private ListView listView;
    private CodeXMLAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.c_tutorial, container, false);
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
            code = parser.parse(getActivity().getAssets().open("c_one.xml"));
            ArrayAdapter<CodeXML> adapter =

                    mAdapter = new CodeXMLAdapter(getActivity(), code);
            listView.setAdapter(mAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mLinearLayout;
    }
}

