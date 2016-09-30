package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhaolinglin00.a36kr.model.bean.AuthorBean;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 */
public class AuthorAdapter extends BaseAdapter {

    private Context context;
    private List<AuthorBean.DataBean> datas ;

    public AuthorAdapter(Context context, List<AuthorBean.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setDatas(List<AuthorBean.DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas== null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }
    public class AuthorViewHolder{




        public  AuthorViewHolder(View view){

        }
    }
}
