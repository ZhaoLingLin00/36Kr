package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zhaolinglin00.a36kr.R;


/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment  {

    private ImageView newsMenuImg, newsDrawerBackImg;
    private DrawerLayout newsDrawerLayout;
    private LinearLayout newsDrawerLL;

    private ListView newsListView;

    private NewsFragment newsFragment;

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

    }

    @Override
    protected void initDatas() {
//        // 加载头布局  (轮播图)
//        View handView = LayoutInflater.from(context).inflate(R.layout.news_listview_handview, null);
//        newsListView.addHeaderView(handView);


        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout,NewsRecyclerUseFragment.newInstance("url")).commit();


    }

//    // 点击出抽屉效果
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.news_menu:
//                newsDrawerLayout.openDrawer(newsDrawerLL);
//                break;
//
//        }
//    }
    public void changeFragment(Fragment fragment){
        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout,fragment).commit();

    }
}
