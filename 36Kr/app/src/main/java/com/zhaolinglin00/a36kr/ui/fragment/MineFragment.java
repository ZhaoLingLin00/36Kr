package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.activity.LogInActivity;
import com.zhaolinglin00.a36kr.ui.activity.SettingActivity;

/**
 * Created by dllo on 16/9/9.
 * 我的 Fragment
 */
public class MineFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView mineSettingImg;
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

        mineSettingImg =byView(R.id.mine_setting_img);
    }

    @Override
    protected void initDatas() {

        mineLoginTv.setOnClickListener(this);
        mineSettingImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_login_tv:
                goTo(LogInActivity.class);// 跳转登录页面
                break;
            case R.id.mine_setting_img:
                goTo(SettingActivity.class);// 跳转设置页面
                break;
        }

    }
}
