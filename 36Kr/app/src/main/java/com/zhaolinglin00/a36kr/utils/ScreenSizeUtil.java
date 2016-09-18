package com.zhaolinglin00.a36kr.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dllo on 16/9/13.
 * <p>
 * 获取屏幕宽高的工具类
 */
public class ScreenSizeUtil {

    // context建议使用App的Context
    public static int getScreenWidth(Context context) {
        // 获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将窗口(屏幕)的尺寸设置给  显示尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);
        // 返回屏幕宽度
        return metrics.widthPixels;
    }

    public static int getScreenheight(Context context) {
        // 获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将窗口(屏幕)的尺寸设置给  显示尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);
        // 返回屏幕高度
        return metrics.heightPixels;
    }

    // 简单整合获取屏幕宽高

    /**
     * @param state 状态
     * @return 传 1 返回宽
     * 传 2 返回高
     * 默认 返回高
     */
    public static int getScreenSize(Context context, int state) {
        // 获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将窗口(屏幕)的尺寸设置给  显示尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);

        switch (state) {
            case 1:
                return metrics.widthPixels;
            case 2:
                return metrics.heightPixels;
            default:
                return metrics.heightPixels;
        }
    }

    // 枚举: 整型常量
    // 一般用枚举来规定一些特殊状态
    // 如: 横屏竖屏,窗口化,全屏
    // 如: 播放,暂停,停止
    // 如: 宽 高
    // 关键字: enum  也就是一种数据类型, 就是一个类
    public enum ScreenState {
        WIDTH, HEIGHT
    }

    public static int getScreenSize(Context context, ScreenState state) {
        // 获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将窗口(屏幕)的尺寸设置给  显示尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);

        if (state.equals(ScreenState.WIDTH)) {
            return metrics.widthPixels;
        } else if (state.equals(ScreenState.HEIGHT)) {
            return metrics.heightPixels;
        }
        return metrics.heightPixels;
    }

}
