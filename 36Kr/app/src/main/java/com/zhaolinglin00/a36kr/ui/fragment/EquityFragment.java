package com.zhaolinglin00.a36kr.ui.fragment;

import android.graphics.Color;
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

    private TabLayout equityTablayout;
    private ViewPager equityViewPager;
    private List<Fragment> equityFragments;
    @Override
    protected int setLayout() {
        return R.layout.fragment_equity;
    }

    @Override
    protected void initViews() {
        equityTablayout= byView(R.id.equity_tab_layout);
        equityViewPager = byView(R.id.equity_viewpager);
        equityFragments = new ArrayList<>();
    }

    @Override
    protected void initDatas() {

        equityFragments.add(new EquityAllFragment());
        equityFragments.add(new EquityFundraisingFragment());
        equityFragments.add(new EquityCompleteFragment());
        equityFragments.add(new EquitySuccessFragment());

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
        equityTablayout.setupWithViewPager(equityViewPager);
        equityTablayout.setTabTextColors(Color.BLACK,Color.argb(255,72,118,255));
        equityTablayout.getTabAt(0).setText("全部");
        equityTablayout.getTabAt(1).setText("募资中");
        equityTablayout.getTabAt(2).setText("募资完成");
        equityTablayout.getTabAt(3).setText("融资成功");


    }
}
