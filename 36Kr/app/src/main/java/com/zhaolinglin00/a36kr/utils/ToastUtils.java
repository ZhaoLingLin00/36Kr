package com.zhaolinglin00.a36kr.utils;

import android.widget.Toast;

import com.zhaolinglin00.a36kr.ui.app.MyApp;

/**
 * Created by dllo on 16/9/8.
 * toast工具类
 */
public final class ToastUtils {
    // final修饰   不能被继承
    // 私有构造方法: 不能创建对象
    private ToastUtils() {}

    private static boolean isDebug = true;

    /**
     * 短时间toast
     * @param msg
     */
    public static void shortMsg(String msg) {
        if (isDebug) {
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间toast
     * @param msg
     */
    public static void longMsg(String msg) {
        if (isDebug) {
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
