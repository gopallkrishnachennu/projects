package com.example.srmap.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.srmap.R;

import static android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK;

public class Primewebview extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primewebview);
        webview=findViewById(R.id.primewebviewcontainer);


        String s=getIntent().getStringExtra("prime");


        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(s);



        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // improve loding fast

        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);


       webview.setDownloadListener(new DownloadListener() {
           @Override
           public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
               DownloadManager.Request request=new DownloadManager.Request(Uri.parse(s));
               request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
               DownloadManager downloadManager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
               downloadManager.enqueue(request);

           }
       });


    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
            Toast.makeText(Primewebview.this,"Press again to go back",Toast.LENGTH_LONG).show();
        }else {
            startActivity(new Intent(Primewebview.this,Srm.class));
            finish();
        }
    }
}