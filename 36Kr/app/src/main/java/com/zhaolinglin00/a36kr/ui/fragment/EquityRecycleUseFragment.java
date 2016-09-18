package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.EquityAllBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.EquityAllAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 股权投资的TabLayout的  复用Fragment
 */
public class EquityRecycleUseFragment extends AbsBaseFragment {

    private EquityAllAdapter equityAllAdapter;
    private ListView equityAllListView;

    public  String url = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&";

    public static EquityRecycleUseFragment newInstance(String url1) {

        Bundle args = new Bundle();
        args.putString("url",url1);
        EquityRecycleUseFragment fragment = new EquityRecycleUseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_equity_recycle_use;
    }

    @Override
    protected void initViews() {
        equityAllListView = byView(R.id.equity_recycle_listview);
    }

    @Override
    protected void initDatas() {
        equityAll();
    }

    /**
     * 股权投资tabLayout的全部界面
     */
    private void equityAll() {
        equityAllAdapter = new EquityAllAdapter(context);
        equityAllListView.setAdapter(equityAllAdapter);

        Bundle bundle = getArguments();
        String string = bundle.getString("url");

        VolleyInstance.getVolleyInatance().startRequest(url + string, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                EquityAllBean equityAllBean = gson.fromJson(resultString, EquityAllBean.class);
                List<EquityAllBean.DataBean.DataBean1> datas = equityAllBean.getData().getData();
                equityAllAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }
}
