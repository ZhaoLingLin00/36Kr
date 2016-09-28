package com.zhaolinglin00.a36kr.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.RecentBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.RecentAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 近期活动Activity
 */
public class RecentActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView recentBackImg;
    private RecentAdapter recentAdapter;
    private ListView recentListView;

    @Override
    protected int setLayout() {
        return R.layout.activity_recent;
    }

    @Override
    protected void initViews() {
        recentBackImg = byView(R.id.recent_back_img);
        recentListView = byView(R.id.recent_listview);
    }

    @Override
    protected void initDatas() {
        recentBackImg.setOnClickListener(this);
        recentAdapter = new RecentAdapter(this);
        recentListView.setAdapter(recentAdapter);

        VolleyInstance.getVolleyInatance().startRequest(Constants.RECENT_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                RecentBean recentBean = gson.fromJson(resultString, RecentBean.class);
                List<RecentBean.DataBean.Databean> datas = recentBean.getData().getData();
                recentAdapter.setDatas(datas);
            }

            @Override
            public void failure() {
            }
        });
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recent_back_img:// 结束当前页面
                finish();
                break;
        }
    }
}
