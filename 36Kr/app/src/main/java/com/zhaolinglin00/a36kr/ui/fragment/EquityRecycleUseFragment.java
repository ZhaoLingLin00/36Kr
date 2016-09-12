package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/10.
 * 股权投资的TabLayout的 全部 的Fragment
 */
public class EquityRecycleUseFragment extends AbsBaseFragment {

    public static EquityRecycleUseFragment newInstance() {

        Bundle args = new Bundle();

        EquityRecycleUseFragment fragment = new EquityRecycleUseFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_equity_recycle_use;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
