package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/12.
 * 我的页面TabLayout登录的Fragment
 */
public class LoginFragment extends AbsBaseFragment {

    private ImageView loginSettingImg;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initDatas() {
    }
}
