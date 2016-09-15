package mykitab.mykitabcomptepu.CODE_TRAINING;

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

import mykitab.mykitabcomptepu.ADAPTERS.CodeAdapter;
import mykitab.mykitabcomptepu.C_Programming.C_Tabs;
import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 20/08/2016.
 */
public class CodeTraining extends Fragment {

    private ListView listView;
    private String web[] = {
            "C",
            "C++ (Soon)",
            "Java (Soon)",
          /*  "Data Structures",
            "Ruby",
            "JSP" */
    };
    private Integer imageid[] = {
            R.drawable.tutorial_c_icon,
            R.drawable.tutorial_cplusplus_icon,
            R.drawable.tutorial_java_icon,
           /* R.drawable.tutorial_data_structures_icon,
            R.drawable.tutorial_ruby_icon,
            R.drawable.tutorial_jsp_icon*/
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.primary_layout, container, false);

        CodeAdapter customList = new CodeAdapter(getActivity(), web, imageid);

        listView = (ListView) mLinearLayout.findViewById(R.id.listView);
        listView.setAdapter(customList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getActivity(), C_Tabs.class);
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
        return mLinearLayout;
    }

}
