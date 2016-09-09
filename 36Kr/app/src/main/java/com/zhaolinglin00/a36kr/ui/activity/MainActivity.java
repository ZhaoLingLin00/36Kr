package com.zhaolinglin00.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.adapter.NewsAdapter;
import com.zhaolinglin00.a36kr.ui.fragment.DiscoveryFragment;
import com.zhaolinglin00.a36kr.ui.fragment.EquityFragment;
import com.zhaolinglin00.a36kr.ui.fragment.MessageFragment;
import com.zhaolinglin00.a36kr.ui.fragment.MineFragment;
import com.zhaolinglin00.a36kr.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsBaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;



    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.main_tab_layout);
        viewPager = byView(R.id.main_viewpager);

    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();

        fragments.add(new NewsFragment());
        fragments.add(new EquityFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setTabTextColors();
        tabLayout.getTabAt(0).setText("新闻").setIcon(R.drawable.selector_news);
        tabLayout.getTabAt(1).setText("股权投资").setIcon(R.drawable.selector_equity);
        tabLayout.getTabAt(2).setText("发现").setIcon(R.drawable.selector_discovery);
        tabLayout.getTabAt(3).setText("消息").setIcon(R.drawable.selector_message);
        tabLayout.getTabAt(4).setText("我的").setIcon(R.drawable.selector_mine);


    }
}
