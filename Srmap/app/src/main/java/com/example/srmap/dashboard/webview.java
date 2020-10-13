package com.example.srmap.dashboard;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.srmap.R;

import static android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK;

public class webview extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);



        webView=findViewById(R.id.webviewcontainer);

        webviewvr();




    }

    private void webviewvr() {

        String s=getIntent().getStringExtra("map");


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(s);


        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.clearCache(true);



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
            Toast.makeText(webview.this,"Press again to go back",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent =new Intent(webview.this,Vr.class);
            startActivity(intent);
            finish();
        }
    }
}