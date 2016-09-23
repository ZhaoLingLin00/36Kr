package com.zhaolinglin00.a36kr.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;

/**
 * Created by dllo on 16/9/22.
 * 搜索Activity
 */
public class SearchActivity extends AbsBaseActivity implements View.OnClickListener {

    private TextView searchBackTv;

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        searchBackTv = byView(R.id.search_back_img);

    }

    @Override
    protected void initDatas() {

        searchBackTv.setOnClickListener(this);

    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_back_img:// 结束当前页面
                finish();
                break;
        }
    }
}
