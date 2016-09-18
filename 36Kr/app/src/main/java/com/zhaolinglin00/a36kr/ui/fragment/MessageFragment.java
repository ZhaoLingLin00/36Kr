package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/9.
 * 消息Fragment
 */
public class MessageFragment extends AbsBaseFragment {

    public static MessageFragment newInstance() {

        Bundle args = new Bundle();

        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
