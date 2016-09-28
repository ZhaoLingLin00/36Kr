package com.zhaolinglin00.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.net.Constants;
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
public class MainActivity extends AbsBaseActivity implements View.OnClickListener, IToDrawerLayout {

    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private List<Fragment> mainFragments;
    private NewsFragment newsFragment;
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayoutDrawer;
    private ImageView mainDrawerBackImg;
    private LinearLayout allLL, zaoqiLL, blunhouLL, bigCompanyLL, capitalLL, depthLL, researchLL;

    @Override
    protected int setLayout() {

        return R.layout.activity_main;
    }

    /**
     * 初始化
     */
    @Override
    protected void initViews() {

        newsFragment = NewsFragment.newInstance();
        mainTabLayout = byView(R.id.main_tab_layout);
        mainViewPager = byView(R.id.main_viewpager);
        drawerLayout = byView(R.id.main_drawer_layout);
        linearLayoutDrawer = byView(R.id.main_drawer_linear_layout);
        allLL = byView(R.id.main_drawer_all);
        zaoqiLL = byView(R.id.main_drawer_zaoqi);
        blunhouLL = byView(R.id.main_drawer_blunhou);
        bigCompanyLL = byView(R.id.main_drawer_bigcompany);
        capitalLL = byView(R.id.main_drawer_capital);
        depthLL = byView(R.id.main_drawer_depth);
        researchLL = byView(R.id.main_drawer_research);
        mainDrawerBackImg = byView(R.id.main_drawer_back_img);

    }

    @Override
    protected void initDatas() {

        mainDrawerBackImg.setOnClickListener(this);
        mainFragments = new ArrayList<>();
//        getSupportFragmentManager().beginTransaction().replace(R.id.news_framelayout,newsFragment).commit();
        allLL.setOnClickListener(this);
        zaoqiLL.setOnClickListener(this);
        blunhouLL.setOnClickListener(this);
        bigCompanyLL.setOnClickListener(this);
        capitalLL.setOnClickListener(this);
        depthLL.setOnClickListener(this);
        researchLL.setOnClickListener(this);

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
        mainViewPager.setOffscreenPageLimit(5);
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

        /**
         * 设置TabLayout监听
         * 当TabLayout在第一页时,可以打开抽屉
         * 不在第一页的所有界面,禁止抽屉的打开
         */
        mainTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                } else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
                mainViewPager.setCurrentItem(mainTabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
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
            case R.id.main_drawer_all:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_ALL_URL, true));
                newsFragment.changeTextViewText("新闻");
                break;
            case R.id.main_drawer_zaoqi:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_ZAOQIXIANGMU_URL, false));
                newsFragment.changeTextViewText("早期项目");
                break;
            case R.id.main_drawer_blunhou:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_BLUNHOU_URL, false));
                newsFragment.changeTextViewText("B轮后");
                break;
            case R.id.main_drawer_bigcompany:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_BIG_COMPANY_URL, false));
                newsFragment.changeTextViewText("大公司");
                break;
            case R.id.main_drawer_capital:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_CAPITAL_URL, false));
                newsFragment.changeTextViewText("资本");
                break;
            case R.id.main_drawer_depth:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_DEPTH_URL, false));
                newsFragment.changeTextViewText("深度");
                break;
            case R.id.main_drawer_research:
                newsFragment.changeFragment(NewsRecyclerUseFragment.newInstance(Constants.NEWS_RESEARCH_URL, false));
                newsFragment.changeTextViewText("研究");
                break;
            case R.id.main_drawer_back_img:
                drawerLayout.closeDrawer(linearLayoutDrawer); // 关闭抽屉
                break;
        }
    }

    /**
     * 实现接口
     *
     * @param position
     */
    @Override
    public void onToDrawerLayout(int position) {
        if (position == 0) {
            drawerLayout.openDrawer(linearLayoutDrawer);// 打开抽屉
        }
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Toast.makeText(this, "退出程序", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }
}
