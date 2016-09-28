package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.SeekBean;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.util.List;


/**
 * Created by dllo on 16/9/26.
 * 寻找投资人适配器
 */
public class SeekAdapter extends BaseAdapter {

    private List<SeekBean.DataBean.Databean> datas;
    private Context context;

    private List<String> string,str;

    public SeekAdapter(Context context) {
        this.context = context;
    }



    public void setDatas(List<SeekBean.DataBean.Databean> datas) {
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
        SeekViewHolder seekViewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_seek_listview,parent,false);
            seekViewHolder = new SeekViewHolder(convertView);
            convertView.setTag(seekViewHolder);
        }else {
            seekViewHolder = (SeekViewHolder) convertView.getTag();
        }
        if (convertView!= null){
            SeekBean.DataBean.Databean dataBean = datas.get(position);
            seekViewHolder.seekNameTv.setText(dataBean.getUser().getName());
            if (dataBean.getFocusIndustry()!=null){
                for (int i = 0; i <dataBean.getFocusIndustry().size(); i++) {
                    Log.d("SeekAdapter", "dataBean.getFocusIndustry().size():" + dataBean.getFocusIndustry().size());
                    string = dataBean.getFocusIndustry();
                    String s = string + " ";
                    Log.d("qqqqqqqqq", "qqqq"+s);
                    Log.d("qqqqqqqqq", "string:" + string);
                }
                    seekViewHolder.seekDomainTv.setText(string+"");

            }
            if (dataBean.getFocusIndustry()!=null){
                for (int i = 0; i <dataBean.getInvestPhases().size(); i++) {
                    str = dataBean.getInvestPhases();
                    Log.d("qqqqqqqqq", "str:" + str);

                }
                seekViewHolder.seekStageTv.setText(str+"");

            }


//            seekViewHolder.seekStageTv.setText( dataBean.getInvestPhases());
            if (dataBean.getUser().getAvatar() != null){
                Picasso.with(context).load(dataBean.getUser().getAvatar()).resize(ScreenSizeUtil.getScreenWidth(context) / 10, ScreenSizeUtil.getScreenheight(context) / 14).into(seekViewHolder.seekLogoImg);

//                Bitmap b = BitmapFactory.decodeResource(Resources.getSystem(),R.mipmap.logo);
//                b.setWidth(ScreenSizeUtil.getScreenWidth(context)/10);
//                b.setHeight(ScreenSizeUtil.getScreenheight(context)/14);
//                seekViewHolder.seekLogoImg.setImageResource(b);
            }

        }
        return convertView;
    }

    public class SeekViewHolder{

        ImageView seekLogoImg;
        TextView seekNameTv,seekDomainTv,seekStageTv;

        public  SeekViewHolder(View view){
            seekLogoImg = (ImageView) view.findViewById(R.id.item_seek_photo_img);
            seekNameTv = (TextView) view.findViewById(R.id.item_seek_name_tv);
            seekDomainTv = (TextView) view.findViewById(R.id.item_seek_domain_tv);
            seekStageTv = (TextView) view.findViewById(R.id.item_seek_stage_tv);
        }
    }

}
