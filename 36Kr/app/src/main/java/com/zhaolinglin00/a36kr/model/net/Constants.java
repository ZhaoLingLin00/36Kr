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
     * 新闻首页  早期项目  网址
     */
    public static final String NEWS_ZAOQIXIANGMU_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=67&pagingAction=up";
    /**
     * 新闻首页  B轮后 网址
     */
    public static final String NEWS_BLUNHOU_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=68&pagingAction=up";
    /**
     * 新闻首页  大公司 网址
     */
    public static final String NEWS_BIG_COMPANY_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=23&pagingAction=up";
    /**
     * 新闻首页  资本 网址
     */
    public static final String NEWS_CAPITAL_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=69&pagingAction=up";
    /**
     * 新闻首页  深度 网址
     */
    public static final String NEWS_DEPTH_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=70&pagingAction=up";
    /**
     * 新闻首页  研究  网址
     */
    public static final String NEWS_RESEARCH_URL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=71&pagingAction=up";
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
    /**
     * 发现界面  近期活动 网址
     */
    public static  final String RECENT_URL = "https://rong.36kr.com/api/mobi/activity/list?page=1";
    /**
     * 发现界面  寻找投资人 网址
     */
    public static final String SEEK_URL = "https://rong.36kr.com/api/mobi/investor?page=1&pagesize=20";
    /**
     * 新闻详情界面拼接前半段
     */
    public static final String DETAILS_URL="https://rong.36kr.com/api/mobi/news/";
}
