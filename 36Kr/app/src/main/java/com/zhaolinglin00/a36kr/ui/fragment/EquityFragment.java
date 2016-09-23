package com.zhaolinglin00.a36kr.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.ui.activity.SearchActivity;
import com.zhaolinglin00.a36kr.ui.adapter.EquityAllAdapter;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 股权投资fragment
 */
public class EquityFragment extends AbsBaseFragment implements View.OnClickListener {

    private TabLayout equityTabLayout;
    private ViewPager equityViewPager;
    private List<Fragment> equityFragments;

    private ImageView showPopupImg;

    private AlertDialog alertDialog;

    private ImageView equitySearchImg;


    public static EquityFragment newInstance() {

        Bundle args = new Bundle();

        EquityFragment fragment = new EquityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_equity;
    }

    @Override
    protected void initViews() {
        equityTabLayout = byView(R.id.equity_tab_layout);
        equityViewPager = byView(R.id.equity_viewpager);
        equityFragments = new ArrayList<>();

        equitySearchImg = byView(R.id.equity_title_search);

        showPopupImg = byView(R.id.equity_title_investment);

//        equityLayout = byView(R.id.equity_linear_layout);
    }

    @Override
    protected void initDatas() {

        showPopupImg.setOnClickListener(this);
        equitySearchImg.setOnClickListener(this);

        equityFragments.add(EquityRecycleUseFragment.newInstance(Constants.EQUITY_ALL_URL));
        equityFragments.add(EquityRecycleUseFragment.newInstance(Constants.EQUITY_UNDERWAY_URL));
        equityFragments.add(EquityRecycleUseFragment.newInstance(Constants.EQUITY_RAISE_URL));
        equityFragments.add(EquityRecycleUseFragment.newInstance(Constants.EQUITY_FINISH_URL));

        equityViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return equityFragments.get(position);
            }

            @Override
            public int getCount() {
                return equityFragments.size();
            }
        });

        equityTabLayout.setupWithViewPager(equityViewPager);
        equityTabLayout.setTabTextColors(Color.BLACK, Color.argb(255, 72, 118, 255));
        /**
         * 添加TabLayout标题
         */
        equityTabLayout.getTabAt(0).setText("全部");
        equityTabLayout.getTabAt(1).setText("募资中");
        equityTabLayout.getTabAt(2).setText("募资完成");
        equityTabLayout.getTabAt(3).setText("融资成功");
    }

    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.equity_title_investment:// 点击出Dialog
                //        carateWindow();
                Log.d("EquityFragment", "点击了");
                showDialog();
                Log.d("EquityFragment", "点击了图片");
                break;
            case R.id.equity_title_search:// 点击跳转搜索界面
                goTo(SearchActivity.class);
                break;
        }
    }

    /**
     * 点击显示Dialog
     */
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
        View v = LayoutInflater.from(context).inflate(R.layout.equity_popupwindow, null);
        builder.setView(v);
        alertDialog = builder.create();
        alertDialog.show();

        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.height = ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.HEIGHT) / 3 * 2;
        params.width = ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.WIDTH) / 5 * 4;
        window.setAttributes(params);


    }
}
