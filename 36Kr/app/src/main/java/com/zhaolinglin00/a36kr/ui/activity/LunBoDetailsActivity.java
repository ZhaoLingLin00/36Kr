package com.zhaolinglin00.a36kr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/29.
 * 轮播图Activity
 */
public class LunBoDetailsActivity extends AbsBaseActivity implements View.OnClickListener {

    private WebView webView;
    private String string,title;

    private TextView lunboTitleTv;
    private ImageView lunboBackImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_lunbo_details;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.lunbo_webview);
        lunboTitleTv = byView(R.id.lunbo_title_tv);
        lunboBackImg = byView(R.id.lunbo_back_img);

    }

    @Override
    protected void initDatas() {

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            string = bundle.getString("url");
            title = bundle.getString("title");

        }
        webView.loadUrl(string);
        lunboTitleTv.setText(title);
        lunboBackImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lunbo_back_img:
                finish();
                break;
        }
    }
}
