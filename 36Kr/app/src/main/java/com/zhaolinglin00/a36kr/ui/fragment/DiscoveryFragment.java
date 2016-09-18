package com.zhaolinglin00.a36kr.ui.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.DiscoveryBean;
import com.zhaolinglin00.a36kr.model.bean.EquityAllBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.DiscoveryAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 发现Fragment
 */
public class DiscoveryFragment extends AbsBaseFragment{

    private DiscoveryAdapter discoveryAdapter;

    public static DiscoveryFragment newInstance() {

        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

        discoveryAdapter = new DiscoveryAdapter(context);

        VolleyInstance.getVolleyInatance().startRequest(Constants.EQUITY_ALL_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson  = new Gson();
                DiscoveryBean databean = gson.fromJson(resultString,DiscoveryBean.class);
                List<DiscoveryBean.DataBean.Databean> databeen = databean.getData().getData();
                discoveryAdapter.setDatas(databeen);

            }

            @Override
            public void failure() {

            }
        });

    }
}
