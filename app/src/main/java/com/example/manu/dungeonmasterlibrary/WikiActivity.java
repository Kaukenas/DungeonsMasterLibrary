package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WikiActivity extends AppCompatActivity {

    WebView mWebView;
    static Activity wiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_wiki);

        mWebView = findViewById(R.id.mWebView);

        String url = "https://www.d20pfsrd.com/";
        if(savedInstanceState != null){
            url = savedInstanceState.getString("URL");
        }

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setFocusable(true);
        mWebView.setFocusableInTouchMode(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            //webSettings.setBlockNetworkLoads(false);
            webSettings.setDomStorageEnabled(true);
        }
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //Cargar la URL
        mWebView.loadUrl(url);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("URL",mWebView.getUrl());
    }

    @Override
    public void onBackPressed() {

        if (mWebView.canGoBack()){
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public static void setActivity(Activity activity){
        WikiActivity.wiki=activity;
    }
}
