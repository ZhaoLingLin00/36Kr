package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.ResearchBean;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 36kr研究院适配器
 */
public class ResearchAdapter extends BaseAdapter {

    private Context context;

    private List<ResearchBean.DataBean.Databean> datas;

    public ResearchAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ResearchBean.DataBean.Databean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0: datas.size();
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
        ResearchViewHolder researchViewHolder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_research_listview,parent,false);
            researchViewHolder = new ResearchViewHolder(convertView);
            convertView.setTag(researchViewHolder);
        }else {
            researchViewHolder = (ResearchViewHolder) convertView.getTag();
        }
        ResearchBean.DataBean.Databean databean = datas.get(position);
        if (convertView!= null){
            researchViewHolder.researchTitleTv.setText(databean.getTitle());
            researchViewHolder.researchAuthorTv.setText(databean.getUser().getName());

            // 转换时间格式
            long stringT = databean.getPublishTime();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
            long time = Long.valueOf(stringT);
            Date date = new Date(time);
            String finalDate = sdf.format(date);
            // 将转换格式完成的时间set
            researchViewHolder.researchDateTv.setText(finalDate);

            Picasso.with(context).load(databean.getFeatureImg()).resize(ScreenSizeUtil.getScreenWidth(context)/4,ScreenSizeUtil.getScreenheight(context)/8).into(researchViewHolder.researchLogoImg);
        }


        return convertView;
    }

    public class ResearchViewHolder{

        ImageView researchLogoImg;
        TextView researchTitleTv,researchAuthorTv,researchDateTv;
        public ResearchViewHolder(View view){
            researchLogoImg = (ImageView) view.findViewById(R.id.item_research_image_img);
            researchTitleTv = (TextView) view.findViewById(R.id.item_research_title_tv);
            researchAuthorTv = (TextView) view.findViewById(R.id.item_research_author_tv);
            researchDateTv = (TextView) view.findViewById(R.id.item_research_date_tv);
        }
    }
}
