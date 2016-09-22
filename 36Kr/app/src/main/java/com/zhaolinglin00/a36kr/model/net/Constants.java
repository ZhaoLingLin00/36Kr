package com.zhaolinglin00.a36kr.model.net;

/**
 * Created by dllo on 16/9/18.
 * 网址常量类
 * 工具: 存储一些不可改变的量
 */
public final class Constants {
    private Constants(){}

    /**
     * 新闻首页  全部  网址
     */
    public static  final  String NEWS_ALL_URL = "https://rong.36kr.com/api/mobi/news?pagesize=20&columnid=all&pagingaction=up";

    /**
     * 轮播图接口 网址  Carousel轮播
     */
    public static  final String CAROUSEL_URL = "https://rong.36kr.com/api/mobi/roundpics/v4";
    /**
     * 股权投资  网址拼接前半段
     */
    public static final String EQUITY_URL = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&";

    /**
     * 股权投资  全部  网址后半段
     */
    public static  final String EQUITY_ALL_URL = "type=all&pageSize=20";
    /**
     * 股权投资  募资中  网址后半段
     */
    public static final String EQUITY_UNDERWAY_URL = "type=underway&pagesize=20";
    /**
     * 股权投资  募资完成  网址后半段
     */
    public static  final  String EQUITY_RAISE_URL = "type=raise&pagesize=20";
    /**
     * 股权投资  募资成功  网址后半段
     */
    public static  final String EQUITY_FINISH_URL = "type=finish&pagesize=20";
}
