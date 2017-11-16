package com.unionpay.payment.carpay.activity;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.constant.Constant;

public class CommonWebActivity extends PaymentBaseActivity {

    private WebView mContentWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_web);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        mContentWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mContentWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setDomStorageEnabled(true);
        mContentWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }

    @Override
    protected void initData() {
        String title = getIntent().getStringExtra(Constant.KEY.TITLE);
        if (!TextUtils.isEmpty(title)) {
            setCustomTitle(title);
        }

        String url = getIntent().getStringExtra(Constant.KEY.URL);
        if (!TextUtils.isEmpty(url)) {
            mContentWebView.loadUrl(url);
        }
    }

}
