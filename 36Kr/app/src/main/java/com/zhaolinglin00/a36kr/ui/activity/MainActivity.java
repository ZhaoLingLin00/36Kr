package com.zhaolinglin00.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.adapter.MainViewPagerAdapter;
import com.zhaolinglin00.a36kr.ui.fragment.DiscoveryFragment;
import com.zhaolinglin00.a36kr.ui.fragment.EquityFragment;
import com.zhaolinglin00.a36kr.ui.fragment.MessageFragment;
import com.zhaolinglin00.a36kr.ui.fragment.MineFragment;
import com.zhaolinglin00.a36kr.ui.fragment.NewsFragment;
import com.zhaolinglin00.a36kr.ui.fragment.NewsRecyclerUseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
public class MainActivity extends AbsBaseActivity implements View.OnClickListener,IToDrawerLayout {

    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private List<Fragment> mainFragments;
    private List<String> titles;

    private MainViewPagerAdapter mainViewPagerAdapter;

    private NewsFragment newsFragment;

    private DrawerLayout drawerLayout;

    private LinearLayout linearLayoutDrawer;

    private TextView allTv,zaoqiTv,blunhouTv,bigCompanyTv,capitalTv,depthTv,researchTv;


    @Override
    protected int setLayout() {
        newsFragment = NewsFragment.newInstance();
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainTabLayout = byView(R.id.main_tab_layout);
        mainViewPager = byView(R.id.main_viewpager);

        drawerLayout = byView(R.id.main_drawer_layout);
        linearLayoutDrawer = byView(R.id.main_drawer_linear_layout);

        allTv = byView(R.id.main_drawer_all_tv);
        zaoqiTv = byView(R.id.main_drawer_zaoqi_tv);
        blunhouTv = byView(R.id.main_drawer_blunhou_tv);
        bigCompanyTv = byView(R.id.main_drawer_bigcompany_tv);
        capitalTv = byView(R.id.main_drawer_capital_tv);
        depthTv = byView(R.id.main_drawer_depth_tv);
        researchTv = byView(R.id.main_drawer_research_tv);

    }

    @Override
    protected void initDatas() {

        mainFragments = new ArrayList<>();

//        getSupportFragmentManager().beginTransaction().replace(R.id.news_framelayout,newsFragment).commit();

        allTv.setOnClickListener(this);
        zaoqiTv.setOnClickListener(this);
        blunhouTv.setOnClickListener(this);
        bigCompanyTv.setOnClickListener(this);
        capitalTv.setOnClickListener(this);
        depthTv.setOnClickListener(this);
        researchTv.setOnClickListener(this);


        mainFragments.add(newsFragment);
        mainFragments.add(EquityFragment.newInstance());
        mainFragments.add(DiscoveryFragment.newInstance());
        mainFragments.add(MessageFragment.newInstance());
        mainFragments.add(MineFragment.newInstance());

//        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
//        mainViewPager.setAdapter(mainViewPagerAdapter);

        mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mainFragments.get(position);
            }

            @Override
            public int getCount() {
                return mainFragments.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }
        });
        mainViewPager.setOffscreenPageLimit(2);
        mainTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mainTabLayout.setupWithViewPager(mainViewPager);
        // 设置文字选中和非选中的颜色
        mainTabLayout.setTabTextColors(Color.BLACK, Color.argb(255, 72, 118, 255));
        //设置TabLayout的标题和图片
        mainTabLayout.getTabAt(0).setText("新闻").setIcon(R.drawable.selector_news);
        mainTabLayout.getTabAt(1).setText("股权投资").setIcon(R.drawable.selector_equity);
        mainTabLayout.getTabAt(2).setText("发现").setIcon(R.drawable.selector_discovery);
        mainTabLayout.getTabAt(3).setText("消息").setIcon(R.drawable.selector_message);
        mainTabLayout.getTabAt(4).setText("我的").setIcon(R.drawable.selector_mine);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_drawer_all_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up"));
                newsFragment.changeTextViewText("新闻");
                break;
            case  R.id.main_drawer_zaoqi_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=67&pagingAction=up"));
                newsFragment.changeTextViewText("早期项目");
                break;
            case R.id.main_drawer_blunhou_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=68&pagingAction=up"));
                newsFragment.changeTextViewText("B轮后");
                break;
            case R.id.main_drawer_bigcompany_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=23&pagingAction=up"));
                newsFragment.changeTextViewText("大公司");
                break;
            case R.id.main_drawer_capital_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=69&pagingAction=up"));
                newsFragment.changeTextViewText("资本");
                break;
            case R.id.main_drawer_depth_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=70&pagingAction=up"));
                newsFragment.changeTextViewText("深度");
                break;
            case R.id.main_drawer_research_tv:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance("https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=71&pagingAction=up"));
                newsFragment.changeTextViewText("研究");
                break;
        }
    }

    /**
     * 实现接口
     * @param position
     */
    @Override
    public void onToDrawerLayout(int position) {
        if (position == 0){
            drawerLayout.openDrawer(linearLayoutDrawer);
        }
    }



}
