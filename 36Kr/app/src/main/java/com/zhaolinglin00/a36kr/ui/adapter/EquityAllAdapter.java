package com.zhaolinglin00.a36kr.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaolinglin00.a36kr.R;
import com.zhaolinglin00.a36kr.model.bean.EquityAllBean;
import com.zhaolinglin00.a36kr.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 股权投资复用Fragment的适配器
 */
public class EquityAllAdapter extends BaseAdapter {

    private Context context;
    private List<EquityAllBean.DataBean.DataBean1> datas;

    private Boolean concern = false;

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
            String muzi = dataBean1.getFundStatus().getDesc();
            equityAllViewHolder.equityMuziTv.setText(muzi);
            if (muzi.equals("募资中")) {
                equityAllViewHolder.equitySubscribeTv.setText("认购");
            } else {
                equityAllViewHolder.equitySubscribeTv.setTextColor(Color.WHITE);
                equityAllViewHolder.equitySubscribeTv.setText("去看看");
            }

            final EquityAllViewHolder finalEquityAllViewHolder = equityAllViewHolder;
            equityAllViewHolder.equityConcernTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (concern == false) {
                        finalEquityAllViewHolder.equityConcernTv.setText("已关注");
                        concern = true;
                    } else {
                        finalEquityAllViewHolder.equityConcernTv.setText("关注");
                        concern = false;
                    }
                }
            });

            // 转换投资进度百分比
            double num = dataBean1.getRate();
            int number = (int) (num * 100);
            String text = number + "%";
            equityAllViewHolder.equityRateTv.setText("已募资" + text);
            if (number >= 100) {
                equityAllViewHolder.equityRateTv.setTextColor(Color.RED);
            }
            equityAllViewHolder.equitySeekBar.setProgress(number);
//            equityAllViewHolder.equitySeekBar.setEnabled(false);
//            equityAllViewHolder.equityProgressBar.setProgress(number);
            Picasso.with(context).load(dataBean1.getCompany_logo()).resize(ScreenSizeUtil.getScreenWidth(context) / 8, ScreenSizeUtil.getScreenheight(context) / 10).into(equityAllViewHolder.equityLogoImg);
            Picasso.with(context).load(dataBean1.getFile_list_img()).resize(ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.WIDTH), ScreenSizeUtil.getScreenSize(context, ScreenSizeUtil.ScreenState.HEIGHT) / 4).into(equityAllViewHolder.equityBigImg);
        }
        return convertView;
    }

    public class EquityAllViewHolder {

        ImageView equityLogoImg, equityBigImg;
        TextView equityCompanyNameTv;
        TextView equityCompanyBirefTv;
        TextView equityLeadNameTv;
        TextView equityFounderIntroduceTv;
        TextView equityFounderTv;
        TextView equityHatcherTv;
        TextView equityHatcherNameTv;
        TextView equityMuziTv;
        TextView equitySubscribeTv;
        TextView equityRateTv;
        TextView equityConcernTv;
        SeekBar equitySeekBar;

        public EquityAllViewHolder(View view) {
            equityLogoImg = (ImageView) view.findViewById(R.id.item_equity_logo_img);// logo图片
            equityBigImg = (ImageView) view.findViewById(R.id.item_equity_big_img);// 大图片
            equityCompanyNameTv = (TextView) view.findViewById(R.id.item_equity_company_name_tv);// 公司名称
            equityCompanyBirefTv = (TextView) view.findViewById(R.id.item_equity_company_brief_tv);// 公司简介
            equityLeadNameTv = (TextView) view.findViewById(R.id.item_equity_lead_name_tv);// 领头方名字
            equityFounderIntroduceTv = (TextView) view.findViewById(R.id.item_equity_founder_introduce_tv);// 创始人介绍
            equityFounderTv = (TextView) view.findViewById(R.id.item_equity_founder_tv);// 创始人
            equityHatcherTv = (TextView) view.findViewById(R.id.item_equity_hatcher_tv);// 孵化器介绍
            equityHatcherNameTv = (TextView) view.findViewById(R.id.item_equity_hatcher_name_tv);// 孵化器名字
            equityMuziTv = (TextView) view.findViewById(R.id.item_equity_muzi_tv);// 募资状态
            equitySubscribeTv = (TextView) view.findViewById(R.id.equity_subscribe_tv);// 认购or去看看
            equityRateTv = (TextView) view.findViewById(R.id.equity_rate_tv);// 募资完成百分比
            equityConcernTv = (TextView) view.findViewById(R.id.item_equity_concern_tv);
            equitySeekBar = (SeekBar) view.findViewById(R.id.equity_seekbar);


        }
    }
}
