package com.zhaolinglin00.a36kr.view.loopview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhaolinglin00.a36kr.R;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 轮播图的适配器
 */
public class LoopViewAdapter extends PagerAdapter {
    private List<LoopViewEntity> list;
    private Context context;
    private OnItemClickListener listener;

    public LoopViewAdapter(Context context, List<LoopViewEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.loopview_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.loop_image);
        Glide.with(context).load(list.get(position).getImageUrl())
                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

