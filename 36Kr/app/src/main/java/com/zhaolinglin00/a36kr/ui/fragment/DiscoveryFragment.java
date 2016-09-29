package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.CarouselBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.activity.LunBoDetailsActivity;
import com.zhaolinglin00.a36kr.ui.activity.RecentActivity;
import com.zhaolinglin00.a36kr.ui.activity.ResearchActivity;
import com.zhaolinglin00.a36kr.ui.activity.SeekActivity;
import com.zhaolinglin00.a36kr.view.loopview.LoopView;
import com.zhaolinglin00.a36kr.view.loopview.LoopViewEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/9.
 * 发现Fragment
 */
public class DiscoveryFragment extends AbsBaseFragment implements View.OnClickListener {

    private LoopView discoveryLoopView;
    private RelativeLayout discoveryRecentRL,discoverySeekRL,discoveryDecearchRL;
    private List<LoopViewEntity> entities=new ArrayList<>();

    public static DiscoveryFragment newInstance() {

        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }


        return R.layout.fragment_discovery;
    }

    @Override
    protected void initViews() {
        discoveryLoopView = byView(R.id.discovery_loopview);
        discoveryRecentRL = byView(R.id.discovery_recent_rl);
        discoverySeekRL = byView(R.id.discovery_seek_rl);
        discoveryDecearchRL = byView(R.id.discovery_research_rl);

    }

    @Override
    protected void initDatas() {

        discoveryRecentRL.setOnClickListener(this);
        discoverySeekRL.setOnClickListener(this);
        discoveryDecearchRL.setOnClickListener(this);

        /**
         *  ScrollView的轮播图
         *  解析网络数据, 将解析的轮播图的网址放入集合中
         */
        VolleyInstance.getVolleyInatance().startRequest(Constants.CAROUSEL_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Log.d("xxxxx", resultString);
                Gson gson = new Gson();

                final CarouselBean carouselBean = gson.fromJson(resultString, CarouselBean.class);

                List<CarouselBean.DataBean.PicsBean> picsBeen=carouselBean.getData().getPics();
                Log.d("qqq", picsBeen.get(0).getImgUrl());
//                LoopViewEntity entity=new LoopViewEntity();
//                entity.setImageUrl(picsBeen.get(0).getImgUrl());
//                Log.d("qqq", entity.getImageUrl()+"1111");
//                entities.add(entity);
//                Log.d("qqq", "entities.size():" + entities.size());
//                entities.add(entity);
                for (int i = 0; i <picsBeen.size() ; i++) {
                    LoopViewEntity e=new LoopViewEntity();
                    Log.d("DiscoveryFragment", "e:" + e);
                    e.setImageUrl(picsBeen.get(i).getImgUrl());
                    Log.d("DiscoveryFragment", "e1:" + e);
                    entities.add(e);
                }
                discoveryLoopView.setLoopData(entities);

                discoveryLoopView.setOnItemClickListener(new LoopView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(context, "点击了" + position, Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        String s = carouselBean.getData().getPics().get(position).getLocation();
                        bundle.putString("url",s);
                        goTo(LunBoDetailsActivity.class,bundle);
                    }
                });
            }
            @Override
            public void failure() {
                Log.d("xxxxxx", "获取失败");
            }
        });
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.discovery_recent_rl:
                goTo(RecentActivity.class);
                break;
            case R.id.discovery_seek_rl:
                goTo(SeekActivity.class);
                break;
            case R.id.discovery_research_rl:
                goTo(ResearchActivity.class);
                break;

        }
    }
}
