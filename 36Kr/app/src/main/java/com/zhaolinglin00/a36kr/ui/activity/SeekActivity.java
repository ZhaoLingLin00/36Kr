package com.zhaolinglin00.a36kr.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.SeekBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.SeekAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/26.
 * 发现界面寻找投资人的Activity
 */
public class SeekActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView seekBackImg;
    private SeekAdapter seekAdapter;
    private ListView seekListView;


    @Override
    protected int setLayout() {
        return R.layout.activity_seek;
    }

    @Override
    protected void initViews() {
        seekBackImg = byView(R.id.seek_back_img);
        seekListView = byView(R.id.seek_listview);
    }

    @Override
    protected void initDatas() {
        seekBackImg.setOnClickListener(this);
        seekAdapter = new SeekAdapter(this);
        seekListView.setAdapter(seekAdapter);

        VolleyInstance.getVolleyInatance().startRequest(Constants.SEEK_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                SeekBean seekBean = gson.fromJson(resultString,SeekBean.class);
                List<SeekBean.DataBean.Databean> databeen = seekBean.getData().getData();
                seekAdapter.setDatas(databeen);
            }

            @Override
            public void failure() {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seek_back_img:
                finish();
                break;
        }
    }
}
