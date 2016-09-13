package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;

import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment  {

    private Context context;
    private ImageView newsMenuImg;
    private DrawerLayout newsDrawerLayout;
    private LinearLayout newsDrawerll;

    private ListView newsListView;
    private String url = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up";
    private NewsAdapter newsAdapter;

    // 定义请求队列
    private RequestQueue requestQueue;

    public static NewsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
//        newsDrawerLayout = byView(R.id.news_drawerlayout);
//        newsDrawerll = byView(R.id.news_drawerll);
        newsMenuImg = byView(R.id.news_menu);
        newsListView = byView(R.id.news_listview);
    }

    @Override
    protected void initDatas() {
//        newsMenuImg.setOnClickListener(this);



        newsAdapter = new NewsAdapter(context);
        newsListView.setAdapter(newsAdapter);
        // 初始化请求队列
        requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(response,NewsBean.class);
                List<NewsBean.DataBean.DataBean1> datas = newsBean.getData().getData();
                Log.d("xxx", "datas:" + datas);
                newsAdapter.setDatas(datas);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

//    @Override
//    public void onClick(View v) {
//        newsDrawerLayout.openDrawer(newsDrawerll);
//    }
}
