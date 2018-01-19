package com.goswagger.swagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {


            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=(WebView)   findViewById(R.id.webView);

                WebSettings webSettings = webview.getSettings();

                webSettings.setJavaScriptEnabled(true);

                webview.setWebViewClient(new WebViewClient());

                webview.loadUrl("http://www.goswagger.com");
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.UsrPg){
            EditText a = (EditText)findViewById(R.id.TFathleteid);
            String str = a.getText().toString();

            Intent i = new Intent(MainActivity.this, UserPage.class);
            i.putExtra("athleteId", str);
            startActivity(i);
        }

    }
}
