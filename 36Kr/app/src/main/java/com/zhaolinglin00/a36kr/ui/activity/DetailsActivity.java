package com.zhaolinglin00.a36kr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.DetailsBean;
import com.zhaolinglin00.a36kr.model.bean.DiscoveryBean;
import com.zhaolinglin00.a36kr.model.net.Constants;
import com.zhaolinglin00.a36kr.model.net.VolleyInstance;
import com.zhaolinglin00.a36kr.model.net.VolleyResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dllo on 16/9/26.
 */
public class DetailsActivity extends AbsBaseActivity {

    private ImageView detailsPhotoImg;
    private TextView detailsAuthorTv, detailsIntroduceTv,detailsTitleTv,detailsTimeTv,detailsContentTv;
    private String string;
    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void initViews() {
        detailsPhotoImg = byView(R.id.details_photo_img);
        detailsAuthorTv = byView(R.id.details_author_tv);
        detailsContentTv = byView(R.id.details_content_tv);
        detailsIntroduceTv = byView(R.id.details_introduce_tv);
        detailsTimeTv = byView(R.id.details_time_tv);
        detailsTitleTv = byView(R.id.details_title_tv);

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
                DetailsBean detailsBean = gson.fromJson(resultString,DetailsBean.class);
                detailsTitleTv.setText(detailsBean.getData().getTitle());
                Log.d("DetailsActivity", "detailsTitleTv:" + detailsTitleTv);
                detailsAuthorTv.setText(detailsBean.getData().getUser().getName());
                detailsContentTv.setText(detailsBean.getData().getContent());
                Log.d("DetailsActivity", "detailsContentTv:" + detailsContentTv);

            }

            @Override
            public void failure() {

            }
        });



    }
}
