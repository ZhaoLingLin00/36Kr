package com.zhaolinglin00.a36kr.ui.fragment;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView newsMenuImg;
    private DrawerLayout newsDrawerLayout;
    private LinearLayout newsDrawerll;
    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsDrawerLayout = byView(R.id.news_drawerlayout);
        newsDrawerll = byView(R.id.news_drawerll);
        newsMenuImg = byView(R.id.news_menu);

    }

    @Override
    protected void initDatas() {
        newsMenuImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        newsDrawerLayout.openDrawer(newsDrawerll);
    }
}
