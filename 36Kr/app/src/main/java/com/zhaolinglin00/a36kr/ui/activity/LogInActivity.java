package com.zhaolinglin00.a36kr.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/12.
 */
public class LogInActivity extends AbsBaseActivity {

    private TabLayout loginTabLayout;
    private ViewPager loginViewPager;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginTabLayout = byView(R.id.main_tab_layout);
        loginViewPager = byView(R.id.main_viewpager);
    }

    @Override
    protected void initDatas() {

    }
}
