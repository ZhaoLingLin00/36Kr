package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/13.
 */
public class RegisterFragment extends AbsBaseFragment {

    public static RegisterFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
