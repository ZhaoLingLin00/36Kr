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

    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private List<Fragment> mainFragments;



    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainTabLayout = byView(R.id.main_tab_layout);
        mainViewPager = byView(R.id.main_viewpager);
        mainFragments = new ArrayList<>();
    }

    @Override
    protected void initDatas() {

        mainFragments.add(NewsFragment.newInstance());
        mainFragments.add(EquityFragment.newInstance());
        mainFragments.add(DiscoveryFragment.newInstance());
        mainFragments.add(MessageFragment.newInstance());
        mainFragments.add(MineFragment.newInstance());

        mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mainFragments.get(position);
            }

            @Override
            public int getCount() {
                return mainFragments.size();
            }
        });
        mainTabLayout.setupWithViewPager(mainViewPager);
        // 设置文字选中和非选中的颜色
        mainTabLayout.setTabTextColors(Color.BLACK,Color.argb(255,72,118,255));
        // 设置TabLayout的标题和图片
        mainTabLayout.getTabAt(0).setText("新闻").setIcon(R.drawable.selector_news);
        mainTabLayout.getTabAt(1).setText("股权投资").setIcon(R.drawable.selector_equity);
        mainTabLayout.getTabAt(2).setText("发现").setIcon(R.drawable.selector_discovery);
        mainTabLayout.getTabAt(3).setText("消息").setIcon(R.drawable.selector_message);
        mainTabLayout.getTabAt(4).setText("我的").setIcon(R.drawable.selector_mine);
    }
}
