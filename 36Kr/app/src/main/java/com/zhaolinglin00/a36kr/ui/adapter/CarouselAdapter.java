package com.zhaolinglin00.a36kr.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhaolinglin00.a36kr.model.bean.CarouselBean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 */
public class CarouselAdapter extends BaseAdapter {

    private List<CarouselBean> datas;

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
        return null;
    }
}
