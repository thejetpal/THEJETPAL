package mykitab.mykitabcomptepu.C_Programming;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import mykitab.mykitabcomptepu.R;

/**
 * Created by Admin on 04/09/2016.
 */
@SuppressLint({"SetJavaScriptEnabled"})
public class QuestionOfDay extends Fragment {
    private WebView mWebView;
    JavascriptInterface JSInterface;
    JavascriptInterface prettify;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        // Inflate the layout for this fragment
        RelativeLayout mLinearLayout = (RelativeLayout) inflater.inflate(R.layout.question_of_day, container, false);
        mWebView = (WebView) mLinearLayout.findViewById(R.id.activity_main_webview);
        mWebView.loadUrl("https://www.mykitab-te-firebaseapp.com/qftd/question.html ");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebView.getSettings().setSaveFormData(true);
        mWebView.getSettings().setEnableSmoothTransition(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        return mLinearLayout;
    }

}

