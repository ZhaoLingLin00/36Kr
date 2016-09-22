package com.zhaolinglin00.a36kr.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.ui.activity.IToDrawerLayout;


/**
 * Created by dllo on 16/9/9.
 * 新闻 Fragment
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView titleNameTv;
    private ImageView titleMenuImg;

    private IToDrawerLayout iToDrawerLayout;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * context也是Activity--Activity实现了接口
     * 他们就是一个内存空间,可以相互转型使用
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iToDrawerLayout = (IToDrawerLayout) context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        titleNameTv = byView(R.id.news_title_name);
        titleMenuImg = byView(R.id.news_menu);
    }

    @Override
    protected void initDatas() {
        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout
                ,NewsRecyclerUseFragment.newInstance(Constants.NEWS_ALL_URL)).commit();


        titleMenuImg.setOnClickListener(this);
    }

    /**
     * 提供替换Fragment的方法
     * @param fragment
     */
    public void changeFragment(Fragment fragment){
        getChildFragmentManager().beginTransaction().replace(R.id.news_framelayout,fragment).commit();

    }

    /**
     * 提供替换标题文字的方法
     * @param text
     */
    public void changeTextViewText(String text){
        titleNameTv.setText(text);
    }


    /**
     * 接口
     * @param v
     */
    @Override
    public void onClick(View v) {
        iToDrawerLayout.onToDrawerLayout(0);
    }
}
