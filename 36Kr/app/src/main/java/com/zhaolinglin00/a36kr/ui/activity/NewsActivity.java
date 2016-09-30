package com.zhaolinglin00.a36kr.ui.activity;

import android.webkit.WebView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.net.Constants;

/**
 * Created by dllo on 16/9/30.
 * 发现界面行业新闻
 */
public class NewsActivity extends AbsBaseActivity {

    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.news_webview);
    }

    @Override
    protected void initDatas() {
        webView.loadUrl(Constants.DISCOVERY_NEWS_URL);
    }
}
