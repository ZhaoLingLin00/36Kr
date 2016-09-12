package com.zhaolinglin00.a36kr.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/8.
 * 当前应用
 *   需要在清单文件中注册
 *   只给网络和数据库用
 */
public class MyApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public  static  Context getContext(){
        return context;
    }
}
