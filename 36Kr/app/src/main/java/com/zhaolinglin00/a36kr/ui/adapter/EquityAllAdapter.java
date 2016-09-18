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
import com.zhaolinglin00.a36kr.model.bean.EquityAllBean;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 */
public class EquityAllAdapter extends BaseAdapter {


    private Context context;
    private List<EquityAllBean.DataBean.DataBean1> datas;

    public EquityAllAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<EquityAllBean.DataBean.DataBean1> datas) {
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
        EquityAllViewHolder equityAllViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_equity_listview, parent, false);

            // 获取行布局的高度并重新设置
//            int height = ScreenSizeUtil.getScreenheight(context);
//            ViewGroup.LayoutParams params = convertView.getLayoutParams();
//            params.height = height / 3;
//            convertView.setLayoutParams(params);

            equityAllViewHolder = new EquityAllViewHolder(convertView);
            convertView.setTag(equityAllViewHolder);
        } else {
            equityAllViewHolder = (EquityAllViewHolder) convertView.getTag();

        }
        if (convertView != null) {
            EquityAllBean.DataBean.DataBean1 dataBean1 = datas.get(position);
            equityAllViewHolder.equityCompanyNameTv.setText(dataBean1.getCompany_name());
            equityAllViewHolder.equityCompanyBirefTv.setText(dataBean1.getCompany_brief());
            equityAllViewHolder.equityLeadNameTv.setText(dataBean1.getLead_name());
            equityAllViewHolder.equityFounderIntroduceTv.setText(dataBean1.getCf_advantage().get(0).getAdcontent());
            equityAllViewHolder.equityFounderTv.setText(dataBean1.getCf_advantage().get(0).getAdname());
            equityAllViewHolder.equityHatcherTv.setText(dataBean1.getCf_advantage().get(1).getAdname());
            equityAllViewHolder.equityHatcherNameTv.setText(dataBean1.getCf_advantage().get(1).getAdcontent());
            Picasso.with(context).load(dataBean1.getCompany_logo()).resize(ScreenSizeUtil.getScreenWidth(context)/8,ScreenSizeUtil.getScreenheight(context)/10).into(equityAllViewHolder.equityLogoImg);
            Picasso.with(context).load(dataBean1.getFile_list_img()).resize(ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.WIDTH),ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.HEIGHT)/4).into(equityAllViewHolder.equityBigImg);

        }
        return convertView;
    }

    public class EquityAllViewHolder {

        ImageView equityLogoImg, equityBigImg;
        TextView equityCompanyNameTv, equityCompanyBirefTv, equityLeadNameTv, equityFounderIntroduceTv,
        equityFounderTv,equityHatcherTv,equityHatcherNameTv;

        public EquityAllViewHolder(View view) {
            equityLogoImg = (ImageView) view.findViewById(R.id.item_equity_logo_img);
            equityBigImg = (ImageView) view.findViewById(R.id.item_equity_big_img);
            equityCompanyNameTv = (TextView) view.findViewById(R.id.item_equity_company_name_tv);
            equityCompanyBirefTv = (TextView) view.findViewById(R.id.item_equity_company_brief_tv);
            equityLeadNameTv = (TextView) view.findViewById(R.id.item_equity_lead_name_tv);
            equityFounderIntroduceTv = (TextView) view.findViewById(R.id.item_equity_founder_introduce_tv);
            equityFounderTv = (TextView) view.findViewById(R.id.item_equity_founder_tv);
            equityHatcherTv = (TextView) view.findViewById(R.id.item_equity_hatcher_tv);
            equityHatcherNameTv = (TextView) view.findViewById(R.id.item_equity_hatcher_name_tv);


        }
    }
}
