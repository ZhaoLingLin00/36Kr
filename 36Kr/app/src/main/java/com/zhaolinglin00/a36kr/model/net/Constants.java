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
     * 股权投资  全部  网址
     */
    public static  final String EQUITY_ALL_URL = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&type=all&pageSize=20";

}
