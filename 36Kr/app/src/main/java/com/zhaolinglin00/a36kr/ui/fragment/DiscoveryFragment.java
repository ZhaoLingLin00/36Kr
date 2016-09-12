package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/9.
 * 发现Fragment
 */
public class DiscoveryFragment extends AbsBaseFragment{

    public static DiscoveryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
