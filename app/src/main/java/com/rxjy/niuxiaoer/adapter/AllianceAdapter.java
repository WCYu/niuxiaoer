package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.AllianceListInfo;
import com.rxjy.niuxiaoer.widget.CircleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/8/17.
 */

public class AllianceAdapter extends SingleBaseAdapter<AllianceListInfo.AllianceInfo.Alliance, AllianceAdapter.ViewHolder> {


    public AllianceAdapter(Context context, List<AllianceListInfo.AllianceInfo.Alliance> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_alliance;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, AllianceListInfo.AllianceInfo.Alliance data, ViewHolder holder) {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.head_portrait_icon);
        options.error(R.mipmap.head_portrait_icon);
        Glide.with(context).load(data.getImage()).apply(options).into(holder.civHeader);
        holder.tvName.setText(data.getXingMing());
        holder.tvTime.setText("已加入联盟" + data.getDayCount() + "天");
        holder.tvCount.setText(data.getLiangCount() + "");
        holder.tvPrice.setText("¥ " + data.getYongjIN());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.civ_list_item_alliance_header)
        CircleImageView civHeader;
        @Bind(R.id.tv_list_item_alliance_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_alliance_time)
        TextView tvTime;
        @Bind(R.id.tv_list_item_alliance_count)
        TextView tvCount;
        @Bind(R.id.tv_list_item_alliance_price)
        TextView tvPrice;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
