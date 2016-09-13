package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 新闻的适配器
 */
public class NewsAdapter extends BaseAdapter {


    private Context context;
    private List<NewsBean.DataBean.DataBean1> datas;



    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsBean.DataBean.DataBean1> datas) {
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
        NewsViewHolder newsViewHolder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
            newsViewHolder = new NewsViewHolder(convertView);
            convertView.setTag(newsViewHolder);
        }else {
            newsViewHolder = (NewsViewHolder) convertView.getTag();

        }
        NewsBean.DataBean.DataBean1 dataBean1 = datas.get(position);
        if (dataBean1 != null){
            newsViewHolder.newsTitleTv.setText(dataBean1.getTitle());
            newsViewHolder.newsColumnTv.setText(dataBean1.getColumnName());
            newsViewHolder.newsAuthorTv.setText(dataBean1.getUser().getName());
            newsViewHolder.newsDateTv.setText(dataBean1.getPublishTime()+"");
            Picasso.with(context).load(dataBean1.getFeatureImg()).into(newsViewHolder.newsLogoImg);
        }

        return convertView;
    }
    public class NewsViewHolder{
        ImageView newsLogoImg;
        TextView newsTitleTv,newsAuthorTv,newsDateTv,newsColumnTv;
        public NewsViewHolder(View view){
            newsLogoImg = (ImageView) view.findViewById(R.id.item_news_image_img);
            newsTitleTv = (TextView) view.findViewById(R.id.item_news_title_tv);
            newsAuthorTv = (TextView) view.findViewById(R.id.item_news_author_tv);
            newsDateTv = (TextView) view.findViewById(R.id.item_news_date_tv);
            newsColumnTv = (TextView) view.findViewById(R.id.item_news_column_tv);
        }
    }


}
