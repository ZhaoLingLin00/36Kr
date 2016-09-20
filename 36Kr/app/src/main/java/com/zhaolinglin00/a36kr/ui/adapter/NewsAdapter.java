package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.NewsBean;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        NewsViewHolder newsViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_recycler_use_listview, parent, false);
//            // 获取行布局的高度并重新设置
//            int height = ScreenSizeUtil.getScreenheight(context);
//            ViewGroup.LayoutParams params = convertView.getLayoutParams();
//            params.height = height / 8;
//            convertView.setLayoutParams(params);

            newsViewHolder = new NewsViewHolder(convertView);
            convertView.setTag(newsViewHolder);
        } else {
            newsViewHolder = (NewsViewHolder) convertView.getTag();
        }
        NewsBean.DataBean.DataBean1 dataBean1 = datas.get(position);
        if (dataBean1 != null) {
            newsViewHolder.newsTitleTv.setText(dataBean1.getTitle());
            String columnId = dataBean1.getColumnId();
            // 纯数字组成的字符串-转成int
            int columnIdInt = Integer.parseInt(columnId);
            Log.d("NewsAdapter", "columnIdInt:" + columnIdInt);

            String columnName = dataBean1.getColumnName();
            Log.d("NewsAdapter", columnName+"");
//            newsViewHolder.newsColumnTv.setText(dataBean1.getColumnName());
            newsViewHolder.newsAuthorTv.setText(dataBean1.getUser().getName());

            newsViewHolder.newsColumnTv.setText(columnName);

            // 根据columnId设置字体颜色
//            if (columnIdInt == 107){
//
//            }

            // 根据columnName设置字体颜色
            if (columnName.equals("早期项目")){
                newsViewHolder.newsColumnTv.setTextColor(Color.GREEN);
            }
            else  if (columnName.equals("大公司")){
                newsViewHolder.newsColumnTv.setTextColor(Color.BLUE);
            }
            else if (columnName.equals("深度")){
                newsViewHolder.newsColumnTv.setTextColor(Color.RED);
            }
            else if (columnName.equals("氪友")){
                newsViewHolder.newsColumnTv.setTextColor(Color.BLUE);
            }
            else if (columnName.equals("8点1氪")){
                newsViewHolder.newsColumnTv.setTextColor(Color.BLUE);
            }
            else if (columnName.equals("酷公司")){
                newsViewHolder.newsColumnTv.setTextColor(Color.BLUE);
            }else {
                newsViewHolder.newsColumnTv.setTextColor(Color.BLUE);
            }






            // 转换时间格式
            long stringT = dataBean1.getPublishTime();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String newsDateTv = null;
            long time = Long.valueOf(stringT);
            Date date = new Date(time);
            String finalDate = sdf.format(date);
            newsViewHolder.newsDateTv.setText(finalDate);

            Picasso.with(context).load(dataBean1.getFeatureImg()).resize(ScreenSizeUtil.getScreenWidth(context)/4,ScreenSizeUtil.getScreenheight(context)/8).into(newsViewHolder.newsLogoImg);

        }

        return convertView;
    }

    public class NewsViewHolder {
        ImageView newsLogoImg;
        TextView newsTitleTv, newsAuthorTv, newsDateTv, newsColumnTv;

        public NewsViewHolder(View view) {
            newsLogoImg = (ImageView) view.findViewById(R.id.item_news_image_img);
            newsTitleTv = (TextView) view.findViewById(R.id.item_news_title_tv);
            newsAuthorTv = (TextView) view.findViewById(R.id.item_news_author_tv);
            newsDateTv = (TextView) view.findViewById(R.id.item_news_date_tv);
            newsColumnTv = (TextView) view.findViewById(R.id.item_news_column_tv);
        }
    }
}
