package com.goswagger.swagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mjfre on 15-Jan-18.
 */

public class UserPage extends AppCompatActivity{
    WebView webview;

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {


            super.onBackPressed();
        }
    }
    public void onButtonClick(View v) {
        if (v.getId() == R.id.home) {
            Intent i = new Intent(UserPage.this, MainActivity.class);
            webview.loadUrl("http://www.goswagger.com");
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);
        String athleteId = getIntent().getStringExtra("athleteId");
        webview = (WebView) findViewById(R.id.webView);


        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://www.goswagger.com/" + athleteId);
    }
}
