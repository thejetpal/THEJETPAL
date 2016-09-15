package mykitab.mykitabcomptepu.DRAWER_MENU;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mykitab.mykitabcomptepu.R;


/**
 * Created by Admin on 30/06/2016.
 */
public class ContactUsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.contact_us_fragment, container, false);
        Toolbar myToolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
        myToolbar.setTitle("Contact Us");
        myToolbar.setTitleTextColor(0xFFFFFFFF);
        Button mail = (Button) rootView.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","jaitpal97@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, \n\n I'm here to give feedback");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

        TextView feeback = (TextView)rootView.findViewById(R.id.support);

        return rootView;
    }

}
