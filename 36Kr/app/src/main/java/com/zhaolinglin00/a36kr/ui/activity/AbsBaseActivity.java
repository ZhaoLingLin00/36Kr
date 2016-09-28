package com.zhaolinglin00.a36kr.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by dllo on 16/9/8.
 * Activity的基类
 */
public abstract class AbsBaseActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        // 定制流程
        // 设置布局
        setContentView(setLayout());
        // 初始化组件
        initViews();
        // 初始化数据
        initDatas();



    }

    /**
     * 设置布局文件
     *
     * @return R.layout.XXX
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 简化findViewById
     */
    protected <T extends View> T byView(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 跳转不传值
     */
    protected void goTo(Context from, Class to) {
        startActivity(new Intent(from, to));
    }

    /**
     * 跳转传值
     */
    protected void goTo(Context from, Class to, Bundle extras) {
        Intent intent = new Intent(from, to);
        intent.putExtras(extras);
        startActivity(intent);
    }

    /**
     * Activity进入和退出动画
     */
    @Override
    public void finish() {
        super.finish();
        // 第一个参数: 进入动画
        // 第二个参数: 退出动画
//        overridePendingTransition(R.amin.XX, R.amin.XX);
    }
}
