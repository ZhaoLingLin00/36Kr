package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.activity.LogInActivity;

/**
 * Created by dllo on 16/9/9.
 * 我的 Fragment
 */
public class MineFragment extends AbsBaseFragment {

    private TextView mineLoginTv;

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        mineLoginTv = byView(R.id.mine_login_tv);
    }

    @Override
    protected void initDatas() {

        mineLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击跳转
                goTo(LogInActivity.class);
            }
        });
    }
}
