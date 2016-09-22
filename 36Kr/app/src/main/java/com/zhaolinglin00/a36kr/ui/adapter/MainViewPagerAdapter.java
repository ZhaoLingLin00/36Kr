package com.zhaolinglin00.a36kr.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mainFragments;
//    private List<String> titles;

    public void setMainFragments(List<Fragment> mainFragments) {
        this.mainFragments = mainFragments;
        notifyDataSetChanged();
    }

//    public void setTitles(List<String> titles) {
//        this.titles = titles;
//        notifyDataSetChanged();
//    }

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mainFragments == null ? null :mainFragments.get(position);
    }

    @Override
    public int getCount() {
        return mainFragments == null ? 0 :mainFragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles.get(position);
//    }
}
