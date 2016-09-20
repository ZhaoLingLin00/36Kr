package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * News复用的Fragment
 */
public class NewsRecyclerUseFragment extends AbsBaseFragment implements XBanner.XBannerAdapter {


    private NewsAdapter newsAdapter;

    private ListView newsListView;

    private TextView titleNameTv;

    private XBanner xBanner;

    private List<String> imgesUrl ;

    private String urlss = "https://rong.36kr.com/api/mobi/roundpics/v4";

    private ArrayAdapter<String> adapter ;


    public static NewsRecyclerUseFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
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

        titleNameTv = byView(R.id.news_title_name);
       newsListView = byView(R.id.news_recycle_use_listview);
        xBanner = byView(R.id.news_hander_banner);
    }

    @Override
    protected void initDatas() {

        View handerView = View.inflate(context,R.layout.news_listview_handview,null);
        newsListView.addHeaderView(handerView);
        newsAdapter = new NewsAdapter(context);
        newsListView.setAdapter(newsAdapter);


        xBanner = (XBanner) handerView.findViewById(R.id.news_hander_banner);
        imgesUrl = new ArrayList<>();
        imgesUrl.add("https://krplus-pic.b0.upaiyun.com/201609/13/a029f98f1fa43456cab1f3a0a000fd92.jpg");
        imgesUrl.add("https://krplus-pic.b0.upaiyun.com/201609/17/336f8144c30d41ef812e2beced792af5.jpg");
        imgesUrl.add("https://krplus-pic.b0.upaiyun.com/201609/08/bcb0814c9f4a23d375cafee0b13dc704.jpg");
        imgesUrl.add("https://krplus-pic.b0.upaiyun.com/201608/29/5d84e589843826199c2f9c9863f9de09.jpg");
        imgesUrl.add("https://krplus-pic.b0.upaiyun.com/201609/13/d8c6b08c3cdf847cbb59e97dbbbc429f.jpg");
        xBanner.setData(imgesUrl);


        xBanner.setmAdapter(this);

        Bundle bundle  = getArguments();
        String string = bundle.getString("url");

        VolleyInstance.getVolleyInatance().startRequest(string, new VolleyResult() {
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
    public void loadBanner(XBanner banner,View view,int position ){
        Glide.with(context).load(imgesUrl.get(position)).into((ImageView) view);
    }
    public  void changeTextViewText(String text){
        titleNameTv.setText(text);
    }
}
