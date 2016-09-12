package com.zhaolinglin00.a36kr.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhaolinglin00.a36kr.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 股权投资fragment
 */
public class EquityFragment extends AbsBaseFragment{

    private TabLayout equityTabLayout;
    private ViewPager equityViewPager;
    private List<Fragment> equityFragments;

    public static EquityFragment newInstance() {

        Bundle args = new Bundle();

        EquityFragment fragment = new EquityFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_equity;
    }

    @Override
    protected void initViews() {
        equityTabLayout= byView(R.id.equity_tab_layout);
        equityViewPager = byView(R.id.equity_viewpager);
        equityFragments = new ArrayList<>();
    }

    @Override
    protected void initDatas() {

        equityFragments.add(EquityRecycleUseFragment.newInstance());
        equityFragments.add(EquityRecycleUseFragment.newInstance());
        equityFragments.add(EquityRecycleUseFragment.newInstance());
        equityFragments.add(EquityRecycleUseFragment.newInstance());

        equityViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return equityFragments.get(position);
            }

            @Override
            public int getCount() {
                return equityFragments.size();
            }
        });
        equityTabLayout.setupWithViewPager(equityViewPager);
        equityTabLayout.setTabTextColors(Color.BLACK,Color.argb(255,72,118,255));
        equityTabLayout.getTabAt(0).setText("全部");
        equityTabLayout.getTabAt(1).setText("募资中");
        equityTabLayout.getTabAt(2).setText("募资完成");
        equityTabLayout.getTabAt(3).setText("融资成功");


    }
}
