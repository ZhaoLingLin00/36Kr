package com.zhaolinglin00.a36kr.model.net;

/**
 * Created by dllo on 16/9/14.
 * <p>
 * 网络请求结果接口
 */
public interface VolleyResult {

    // 请求成功
    void success(String resultString);

    // 请求失败
    void failure();
}
