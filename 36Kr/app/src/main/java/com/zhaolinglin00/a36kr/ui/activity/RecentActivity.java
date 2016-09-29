package com.zhaolinglin00.a36kr.ui.activity;

import android.app.Dialog;
import android.media.SoundPool;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.RecentBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;
import com.zhaolinglin00.a36kr.ui.adapter.RecentAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 近期活动Activity
 */
public class RecentActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView recentBackImg;
    private RecentAdapter recentAdapter;
    private ListView recentListView;

    private RelativeLayout recentTypeRL, recentTimeRL, recentRL;
    private LinearLayout recentLL;

    private ImageView recentTypeImg, recentTimeImg;
    private Dialog dialog;

    private Boolean i = false;
    private Boolean t = false;
    private PopupWindow typePw;
    private PopupWindow timePw;

    private RadioButton type,time;


    @Override
    protected int setLayout() {
        return R.layout.activity_recent;
    }

    @Override
    protected void initViews() {
        recentBackImg = byView(R.id.recent_back_img);
        recentListView = byView(R.id.recent_listview);

        recentTypeRL = byView(R.id.recent_type_rl);
        recentTimeRL = byView(R.id.recent_time_rl);
        recentRL = byView(R.id.recent_rl);
        recentLL = byView(R.id.recent_linearlayout);

        recentTypeImg = byView(R.id.recent_type_down_img);
        recentTimeImg = byView(R.id.recent_time_down_img);

//        type = byView(R.id.recent_type);
//        time =byView(R.id.recent_time);
    }

    @Override
    protected void initDatas() {
        recentBackImg.setOnClickListener(this);
        recentTimeRL.setOnClickListener(this);
        recentTypeRL.setOnClickListener(this);

//        type.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (i == false) {
////                    if (t == false) {
////                        timePw.dismiss();
////                    }
//                    typePw = new PopupWindow();
//                    typePw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//                    typePw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//                    View view = getLayoutInflater().inflate(R.layout.recent_type_dialog, null);
//                    typePw.setContentView(view);
//                    typePw.setOutsideTouchable(true);
//                    typePw.showAsDropDown(recentLL);
////                    recentTypeImg.setImageResource(R.mipmap.icon_up);
//
//                    i = true;
////                AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialog);
////                View view = getLayoutInflater().inflate(R.layout.recent_type_dialog,null);
////                builder.setView(view);
////                dialog = builder.create();
////                dialog.show();
//                } else {
//                    typePw.dismiss();
////                    recentTypeImg.setImageResource(R.mipmap.icon_down);
//                    i = false;
//                }
//
//            }
//        });
//        time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (t == false) {
////                    if (i == true) {
////                        typePw.dismiss();
////                    }
//                    timePw = new PopupWindow();
//                    timePw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//                    timePw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//                    View view = getLayoutInflater().inflate(R.layout.recent_time_popup_window, null);
//                    timePw.setContentView(view);
//                    timePw.setOutsideTouchable(true);
//                    timePw.showAsDropDown(recentLL);
////                    recentTimeImg.setImageResource(R.mipmap.icon_up);
//                    t = true;
//                } else {
//                    timePw.dismiss();
////                    recentTimeImg.setImageResource(R.mipmap.icon_down);
//                    t = false;
//                }
//
//            }
//        });

        recentAdapter = new RecentAdapter(this);
        recentListView.setAdapter(recentAdapter);

        VolleyInstance.getVolleyInatance().startRequest(Constants.RECENT_URL, new VolleyResult() {
            @Override
            public void success(String resultString) {
                Gson gson = new Gson();
                RecentBean recentBean = gson.fromJson(resultString, RecentBean.class);
                List<RecentBean.DataBean.Databean> datas = recentBean.getData().getData();
                recentAdapter.setDatas(datas);
            }

            @Override
            public void failure() {
            }
        });
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recent_back_img:// 结束当前页面
                finish();
                break;
            case R.id.recent_type_rl:
//                timePw.dismiss();
                Log.d("RecentActivity", "点击了");
                if (i == false) {
                    typePw = new PopupWindow();
                    typePw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                    typePw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                    View view = getLayoutInflater().inflate(R.layout.recent_type_dialog, null);
                    typePw.setContentView(view);
                    typePw.setOutsideTouchable(false);
                    typePw.showAsDropDown(recentLL);
                    recentTypeImg.setImageResource(R.mipmap.icon_up);

                    i = true;
//                AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialog);
//                View view = getLayoutInflater().inflate(R.layout.recent_type_dialog,null);
//                builder.setView(view);
//                dialog = builder.create();
//                dialog.show();
                } else {
                    typePw.dismiss();
                    recentTypeImg.setImageResource(R.mipmap.icon_down);
                    i = false;
                }
                if (timePw != null && timePw.isShowing()) {
                    timePw.dismiss();
                    t = false;
                }
                Log.d("RecentActivity", "显示");
                break;
            case R.id.recent_time_rl:
//                typePw.dismiss();
                if (t == false) {
//                    if (i == true) {
//                        typePw.dismiss();
//                    }
                    timePw = new PopupWindow();
                    timePw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                    timePw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                    View view = getLayoutInflater().inflate(R.layout.recent_time_popup_window, null);
                    timePw.setContentView(view);
                    timePw.setOutsideTouchable(false);
                    timePw.showAsDropDown(recentLL);
                    recentTimeImg.setImageResource(R.mipmap.icon_up);
                    t = true;
                } else {
                    timePw.dismiss();
                    recentTimeImg.setImageResource(R.mipmap.icon_down);
                    t = false;
                }
                if (typePw != null && typePw.isShowing()){
                    typePw.dismiss();
                    i=false;
                }

                break;
        }
    }
}
