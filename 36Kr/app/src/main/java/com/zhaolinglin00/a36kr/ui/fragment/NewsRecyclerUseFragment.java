package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.CarouselBean;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.activity.DetailsActivity;
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;
import com.zhaolinglin00.a36kr.view.loopview.LoopView;
import com.zhaolinglin00.a36kr.view.loopview.LoopViewEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * News复用的Fragment
 */
public class NewsRecyclerUseFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {

    private NewsAdapter newsAdapter;
    private ListView newsListView;

    private NewsBean newsBean;
    private LoopView newsLoopView;
    private List<LoopViewEntity> entities = new ArrayList<>();
    private boolean ifHaveHead;// 判断是否加载轮播图

    private SwipeRefreshLayout swipeRefreshLayout;



    public static NewsRecyclerUseFragment newInstance(String url, boolean ifHaveHead) {

        Bundle args = new Bundle();
        args.putString("url", url);
        args.putBoolean("if", ifHaveHead);
        NewsRecyclerUseFragment fragment = new NewsRecyclerUseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_recycler_use;
    }

    @Override
    protected void initViews() {

        swipeRefreshLayout = byView(R.id.news_srl);
        newsListView = byView(R.id.news_recycle_use_listview);
        newsAdapter = new NewsAdapter(context);
    }

    @Override
    protected void initDatas() {

        usrSwipeRefreshLayout();

        /**
         * Fragment单例中传网址,判断是否有轮播图
         */
        Bundle bundle = getArguments();
        String string = bundle.getString("url");
        ifHaveHead = bundle.getBoolean("if");

        newsListView.setOnItemClickListener(this);

        /**
         * 加载头布局(轮播图)
         */
        View handerView = LayoutInflater.from(context).inflate(R.layout.news_listview_handview, null);
        newsLoopView = (LoopView) handerView.findViewById(R.id.news_loopview);
        if (ifHaveHead == true) {
            newsListView.addHeaderView(handerView);
        }
        Log.d("zzz", "---执行--");

        /**
         * 解析轮播图网络数据
         */
        VolleyInstance.getVolleyInatance().startRequest(Constants.CAROUSEL_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Log.d("xxxxx", resultString);
                Gson gson = new Gson();
                CarouselBean carouselBean = gson.fromJson(resultString, CarouselBean.class);
                List<CarouselBean.DataBean.PicsBean> picsBeen = carouselBean.getData().getPics();
                Log.d("NewsRecyclerUseFragment", picsBeen.get(0).getImgUrl());
                LoopViewEntity entity = new LoopViewEntity();
//                entity.setImageUrl(picsBeen.get(0).getImgUrl());
                Log.d("xxx", entity.getImageUrl() + "1111");
//                entities.add(entity);
                Log.d("xxxxxx", "entities.size():" + entities.size());
//                entities.add(entity);
                for (int i = 0; i < picsBeen.size(); i++) {
                    LoopViewEntity e = new LoopViewEntity();
                    e.setImageUrl(picsBeen.get(i).getImgUrl());
                    entities.add(e);
                }
                newsLoopView.setLoopData(entities);

                newsLoopView.setOnItemClickListener(new LoopView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(context, "点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void failure() {
                Log.d("xxxxxx", "获取失败");
            }
        });


        /**
         * 解析ListView网络数据
         */
        VolleyInstance.getVolleyInatance().startRequest(string, new VolleyResult() {

            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                newsBean = gson.fromJson(resultString, NewsBean.class);
                Log.d("NewsFragment", "newsBean.getData().getData().size():" + newsBean.getData().getData().size());
                List<NewsBean.DataBean.DataBean1> datas = newsBean.getData().getData();
                Log.d("xxx", "datas:" + datas);

                newsAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
        newsListView.setAdapter(newsAdapter);
    }

//    private Handler handler = new Handler(){
//        public  void handleMessage(Message msg){
//            switch (msg.what){
//                case REFRESH_COMPLETE:
//
//            }
//        }
//    };

    private void usrSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.GREEN);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
                Toast.makeText(context, "刷新完成", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(context,DetailsActivity.class);
//        startActivity(intent);
        List<NewsBean.DataBean.DataBean1> datas = newsBean.getData().getData();
        Log.d("ffff", "position:" + position);
        Bundle bd = new Bundle();
        String str = datas.get(position-1).getFeedId();
        Log.d("ffff", str);
        bd.putString("id",str);
        goTo(DetailsActivity.class,bd);
    }
}

