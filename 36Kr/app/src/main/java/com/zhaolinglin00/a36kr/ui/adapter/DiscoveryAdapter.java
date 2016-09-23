package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.DiscoveryBean;
import com.zhaolinglin00.a36kr.model.bean.EquityAllBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 发现页面适配器
 */
public class DiscoveryAdapter extends BaseAdapter {
    private Context context;
    private List<DiscoveryBean.DataBean.Databean> datas;

    public DiscoveryAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<DiscoveryBean.DataBean.Databean> datas) {
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
        DiscoveryViewHolder discoveryViewHolder = null;
        if (convertView == null ){
            discoveryViewHolder = new DiscoveryViewHolder(convertView);
            convertView.setTag(discoveryViewHolder);
        }else {
            discoveryViewHolder = (DiscoveryViewHolder) convertView.getTag();
        }
        if (convertView != null){
            DiscoveryBean.DataBean.Databean databean = datas.get(position);
            discoveryViewHolder.discoveryCompanyNameTv.setText(datas.get(position).getCompany_name());
            discoveryViewHolder.discoveryCompanyIntroducefTv.setText(datas.get(position).getCompany_brief());
            discoveryViewHolder.discoveryFounderIntroduceTv.setText(datas.get(position).getCompany_brief());
        }




        return convertView;
    }

    public class DiscoveryViewHolder {

        ImageView discoveryLogoImg;
        TextView discoveryCompanyNameTv, discoveryCompanyIntroducefTv, discoveryFounderIntroduceTv;

        public DiscoveryViewHolder(View view) {
            discoveryLogoImg = (ImageView) view.findViewById(R.id.discovery_project_logo_img);
            discoveryCompanyNameTv = (TextView) view.findViewById(R.id.discovery_project_name_tv);
            discoveryCompanyIntroducefTv = (TextView) view.findViewById(R.id.discovery_project_introduce_img);
            discoveryFounderIntroduceTv = (TextView) view.findViewById(R.id.discovery_founder_introduce_tv);


        }
    }






}
