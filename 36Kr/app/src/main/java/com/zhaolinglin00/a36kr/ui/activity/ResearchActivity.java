package com.zhaolinglin00.a36kr.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.ResearchBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.ResearchAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 36kr研究院
 */

public class ResearchActivity extends AbsBaseActivity implements View.OnClickListener {

    private ResearchAdapter researchAdapter;
    private ListView resrarchListView;

    private ImageView resrarchBackImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_research;
    }

    @Override
    protected void initViews() {
        resrarchListView = byView(R.id.research_listview);
        resrarchBackImg = byView(R.id.research_back_img);

    }

    @Override
    protected void initDatas() {

        resrarchBackImg.setOnClickListener(this);

        researchAdapter = new ResearchAdapter(this);
        resrarchListView.setAdapter(researchAdapter);

        VolleyInstance.getVolleyInatance().startRequest(Constants.NEWS_RESEARCH_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                ResearchBean researchBean = gson.fromJson(resultString,ResearchBean.class);
                List<ResearchBean.DataBean.Databean> databeen = researchBean.getData().getData();
                researchAdapter.setDatas(databeen);
            }

            @Override
            public void failure() {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.research_back_img:
                finish();
                break;
        }
    }
}
