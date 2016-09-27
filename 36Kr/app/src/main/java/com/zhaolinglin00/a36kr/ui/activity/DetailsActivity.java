package com.zhaolinglin00.a36kr.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.DetailsBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dllo on 16/9/26.
 */
public class DetailsActivity extends AbsBaseActivity {

    private ScrollView detailsScrollView;

    private ImageView detailsPhotoImg;
    private TextView detailsAuthorTv, detailsIntroduceTv,detailsTitleTv,detailsTimeTv,detailsContentTv;
    private String string;

    private LinearLayout detailsLl;

    private WebView webView;


    private GestureDetector gestureDetector;

    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void initViews() {
        detailsPhotoImg = byView(R.id.details_photo_img);
        detailsAuthorTv = byView(R.id.details_author_tv);
//        detailsContentTv = byView(R.id.details_content_tv);
        detailsIntroduceTv = byView(R.id.details_introduce_tv);
        detailsTimeTv = byView(R.id.details_time_tv);
        detailsTitleTv = byView(R.id.details_title_tv);

        detailsScrollView = byView(R.id.details_sv);

        detailsLl = byView(R.id.details_ll);

        webView = byView(R.id.webview);

    }

    @Override
    protected void initDatas() {

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle=getIntent().getExtras();
            string=bundle.getString("id");
            Log.d("ffff", string+"接到了");
        }
//        intent.putExtra(string,"id");
        VolleyInstance.getVolleyInatance().startRequest(Constants.DETAILS_URL + string, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                final DetailsBean detailsBean = gson.fromJson(resultString,DetailsBean.class);
                detailsTitleTv.setText(detailsBean.getData().getTitle());
                Log.d("DetailsActivity", "detailsTitleTv:" + detailsTitleTv);
                detailsAuthorTv.setText(detailsBean.getData().getUser().getName());
                // 获取HTML文本
                String string = detailsBean.getData().getContent();
                // 将HTML转换为textview可显示的类型
                Log.d("DetailsActivity", "detailsContentTv:" + detailsContentTv);

                long time = detailsBean.getData().getPublishTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                long detailsTime = Long.valueOf(time);
                Date date = new Date(detailsTime);
                String finalDate = simpleDateFormat.format(date);
                detailsTimeTv.setText(finalDate);

                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);// 支持JavaAcript
                webSettings.setSupportZoom(true);// 支持缩放
//                webSettings.setBuiltInZoomControls(false);// 出现缩放工具
//                webSettings.setUseWideViewPort(false);// 扩大比例的缩放
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//                webSettings.setDisplayZoomControls(true);// 设置可以被显示的屏幕控制
//                webSettings.setDefaultFixedFontSize(16);// 设置默认字体大小


                webView.loadData(string,"text/html; charset=UTF-8",null);


                Picasso.with(DetailsActivity.this).load(detailsBean.getData().getUser().getAvatar()).resize(ScreenSizeUtil.getScreenWidth(DetailsActivity.this)/8,
                        ScreenSizeUtil.getScreenheight(DetailsActivity.this)/12).into(detailsPhotoImg);

            }
            @Override
            public void failure() {

            }
        });


        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override

            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                if (e2.getY() - e1.getY() < 0) {
                    detailsLl.setVisibility(View.GONE);
                }
                if (e2.getY() - e1.getY() > 0){
                    detailsLl.setVisibility(View.VISIBLE);
                }
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d("wer", "e1:" + e1);
                Log.d("wer", "e2:" + e2);
                Log.d("wer", "qqqqq");
                if (e2.getY() - e1.getY() < 0) {
                    detailsLl.setVisibility(View.GONE);
                }
                if (e2.getY() - e1.getY() > 0){
                    detailsLl.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
}
