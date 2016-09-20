package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;


/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment  {



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
        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout
                ,NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pagesize=20&columnid=all&pagingaction=up")).commit();


    }

    public void changeFragment(Fragment fragment){
        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout,fragment).commit();

    }

}
