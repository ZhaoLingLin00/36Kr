package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;

import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView newsMenuImg, newsDrawerBackImg;
    private DrawerLayout newsDrawerLayout;
    private LinearLayout newsDrawerLL;

    private ListView newsListView;
    private NewsAdapter newsAdapter;

    private Constants constants;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsDrawerLayout = byView(R.id.news_drawer_layout);
        newsDrawerBackImg = byView(R.id.news_drawer_back_img);
        newsDrawerLL = byView(R.id.news_drawer_linear_layout);
        newsMenuImg = byView(R.id.news_menu);
        newsListView = byView(R.id.news_listview);
    }

    @Override
    protected void initDatas() {
        newsMenuImg.setOnClickListener(this);
        newsDrawerBackImg.setOnClickListener(this);
        // 加载头布局  (轮播图)
        View handView = LayoutInflater.from(context).inflate(R.layout.news_listview_handview, null);
        newsListView.addHeaderView(handView);

        newsAdapter = new NewsAdapter(context);
        newsListView.setAdapter(newsAdapter);

        VolleyInstance.getVolleyInatance().startRequest(constants.NEWS_ALL_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(resultString, NewsBean.class);
                Log.d("NewsFragment", "newsBean.getData().getData().size():" + newsBean.getData().getData().size());
                List<NewsBean.DataBean.DataBean1> datas = newsBean.getData().getData();
                Log.d("xxx", "datas:" + datas);
                newsAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }

    // 点击出抽屉效果
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.news_menu:
                newsDrawerLayout.openDrawer(newsDrawerLL);
                break;
            case R.id.news_drawer_back_img:
                break;
        }
    }
}
