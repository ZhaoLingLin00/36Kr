package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.DiscoveryBean;
import com.zhaolinglin00.a36kr.model.bean.RecentBean;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 近期活动适配器
 */
public class RecentAdapter extends BaseAdapter {

    private Context context;

    private List<RecentBean.DataBean.Databean> datas;

    public RecentAdapter(Context context) {
        this.context = context;

    }

    public void setDatas(List<RecentBean.DataBean.Databean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecentViewHolder recentViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recent_listview,parent,false);
            recentViewHolder = new RecentViewHolder(convertView);
            convertView.setTag(recentViewHolder);
        }else {
            recentViewHolder = (RecentViewHolder) convertView.getTag();
        }
        RecentBean.DataBean.Databean databean = datas.get(position);
        if (convertView != null){
            Log.d("RecentAdapter", databean.getActivityTime()+"1111");
            recentViewHolder.recentTimeTv.setText(databean.getActivityTime());
            recentViewHolder.recentTitleTv.setText(databean.getActivityName());
            recentViewHolder.recentIntroduceTv.setText(databean.getActivityDesc());
            recentViewHolder.recentEnrollTv.setText(databean.getActivityStatus());
            recentViewHolder.recentLocationTv.setText(databean.getActivityCity());

            Picasso.with(context).load(databean.getActivityImg()).into(recentViewHolder.recentLogoImg);
        }
        return convertView;
    }

    public class RecentViewHolder {
        ImageView recentLogoImg;
        TextView recentTitleTv,recentIntroduceTv,recentEnrollTv,recentLocationTv,recentTimeTv;

        public RecentViewHolder(View view) {
            recentLogoImg = (ImageView) view.findViewById(R.id.item_recent_logo_img);
            recentTitleTv = (TextView) view.findViewById(R.id.item_recent_title_tv);
            recentIntroduceTv = (TextView) view.findViewById(R.id.item_recent_introduce_tv);
            recentEnrollTv = (TextView) view.findViewById(R.id.item_recent_enroll_tv);
            recentLocationTv = (TextView) view.findViewById(R.id.item_recent_location_tv);
            recentTimeTv = (TextView) view.findViewById(R.id.item_recent_time_tv);
        }
    }
}
