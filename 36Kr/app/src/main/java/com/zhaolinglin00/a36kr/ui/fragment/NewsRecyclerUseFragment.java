package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * News复用的Fragment
 */
public class NewsRecyclerUseFragment extends AbsBaseFragment {


    private NewsAdapter newsAdapter;


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
        newsAdapter = new NewsAdapter(context);
    }

    @Override
    protected void initDatas() {

//        Bundle bundle  = new Bundle();
//        String string = bundle.putString("url");

        VolleyInstance.getVolleyInatance().startRequest(Constants.NEWS_ALL_URL, new VolleyResult() {
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
}
