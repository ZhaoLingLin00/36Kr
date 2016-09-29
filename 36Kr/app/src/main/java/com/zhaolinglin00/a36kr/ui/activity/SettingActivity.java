package com.zhaolinglin00.a36kr.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/23.
 * 设置页面
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView settingBackImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        settingBackImg = byView(R.id.setting_back_img);

    }

    @Override
    protected void initDatas() {
        settingBackImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_back_img:
                finish();
                break;
        }
    }
}
