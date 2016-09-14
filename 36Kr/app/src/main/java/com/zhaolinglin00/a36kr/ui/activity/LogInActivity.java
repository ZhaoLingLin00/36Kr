package com.zhaolinglin00.a36kr.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.ui.fragment.LoginFragment;
import com.zhaolinglin00.a36kr.ui.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/12.
 *
 * 登录页面Activity
 */
public class LogInActivity extends AbsBaseActivity {

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
    }

    @Override
    protected void initDatas() {
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
}
