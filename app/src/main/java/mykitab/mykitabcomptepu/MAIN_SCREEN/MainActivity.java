package mykitab.mykitabcomptepu.MAIN_SCREEN;

/**
 * Created by Admin on 08/08/2016.
 */

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.MenuItem;

import mykitab.mykitabcomptepu.DRAWER_MENU.AboutUs;
import mykitab.mykitabcomptepu.DRAWER_MENU.ContactUsFragment;
import mykitab.mykitabcomptepu.DRAWER_MENU.FeaturesFragment;
import mykitab.mykitabcomptepu.DRAWER_MENU.SentFragment;
import mykitab.mykitabcomptepu.R;
import mykitab.mykitabcomptepu.WEBVIEW.WebViewActivity;


public class MainActivity extends FragmentActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private long mBackPressed;
    private static final String TAG = "Splash";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

        // Navigation View
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_item_sent) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SentFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.nav_item_inbox) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.contactus) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new ContactUsFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.help) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FeaturesFragment()).commit();
                }
               /* if (menuItem.getItemId() == R.id.nav_item_draft) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new PreviousQuestionPapers()).commit();
                }*/
                if (menuItem.getItemId() == R.id.aboutus) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new AboutUs()).commit();
                }
                if (menuItem.getItemId() == R.id.references) {
                    String url = "https://mykitab-a31b3.firebaseapp.com/Syllabus/references.html";
                    String ques = "References";
                    Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("ques", ques);
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.share) {
                    Intent sendIntent = new Intent("android.intent.action.SEND");
                    sendIntent.setAction("android.intent.action.SEND");
                    sendIntent.putExtra("android.intent.extra.TEXT", "MyKitab consists of notes made from various reference books, thus saving youheaps of effort and time which allows you to utilise that time to learn new and useful things beyond the traditional college syllabus!\n https://play.google.com/store/apps/details?id=mykitab.mykitabcomptepu");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);

                }


                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        arg0.cancel();


                    }
                })
                .setNeutralButton("Rate", new DialogInterface.OnClickListener() {


                    public Context context;

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        try {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getApplicationContext().getPackageName())));
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                        }
                    }
                })
                .show();

    }


}
