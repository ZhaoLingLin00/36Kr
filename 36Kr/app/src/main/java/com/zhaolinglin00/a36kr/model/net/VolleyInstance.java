package com.zhaolinglin00.a36kr.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zhaolinglin00.a36kr.ui.app.MyApp;

/**
 * Created by dllo on 16/9/14.
 * <p>
 * 网络的单例
 */
public class VolleyInstance {

    /**
     * 双重校验法写单例
     */

    private static VolleyInstance volleyInatance;

    private RequestQueue queue;

    /**
     * 私有化构造方法,外部不能随意的创建对象
     */
    private VolleyInstance() {
        queue = Volley.newRequestQueue(MyApp.getContext());
    }

    /**
     * 对外提供获取对象的静态方法
     *
     * @return
     */
    public static VolleyInstance getVolleyInatance() {
        if (volleyInatance == null) {
            synchronized (VolleyInstance.class) {
                if (volleyInatance == null) {
                    volleyInatance = new VolleyInstance();
                }
            }
        }
        return volleyInatance;
    }

    /**
     * 对外提供请求方法
     *
     * @param url
     * @param result
     */
    public void startRequest(String url, final VolleyResult result) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        queue.add(stringRequest);
    }
}
