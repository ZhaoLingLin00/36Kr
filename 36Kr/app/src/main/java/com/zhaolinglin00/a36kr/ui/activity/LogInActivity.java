package com.zhaolinglin00.a36kr.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.fragment.LoginFragment;
import com.zhaolinglin00.a36kr.ui.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * <p>
 * 登录页面Activity
 */
public class LogInActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView mainCloseImg;
    private TabLayout loginTabLayout;
    private ViewPager loginViewPager;
    private List<Fragment> loginFragments;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginTabLayout = byView(R.id.login_tablayout);
        loginViewPager = byView(R.id.login_viewpager);

        mainCloseImg = byView(R.id.main_close_img);
    }

    @Override
    protected void initDatas() {
        AddFragment();
        mainCloseImg.setOnClickListener(this);
    }

    private void AddFragment() {
        loginFragments = new ArrayList<>();

        loginFragments.add(LoginFragment.newInstance());
        loginFragments.add(RegisterFragment.newInstance());

        loginViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return loginFragments.get(position);
            }

            @Override
            public int getCount() {
                return loginFragments.size();
            }
        });
        loginTabLayout.setupWithViewPager(loginViewPager);
        loginTabLayout.getTabAt(0).setText("登录");
        loginTabLayout.getTabAt(1).setText("注册");
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_close_img:// 结束当前页面
                finish();
                break;
        }
    }
}
