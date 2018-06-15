package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.ActivityListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/18.
 */

public class ActivityAdapter extends SingleBaseAdapter<ActivityListInfo.ActivityList, ActivityAdapter.ViewHolder> {

    public ActivityAdapter(Context context, List<ActivityListInfo.ActivityList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_activity;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ActivityListInfo.ActivityList data, ViewHolder holder) {
        holder.tvTime.setText(data.getCreateTime());
        holder.tvName.setText(data.getTitle());
        holder.tvContent.setText(data.getContent());
        Glide.with(context).load(data.getImgUrl()).into(holder.ivActivity);
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_activity_time)
        TextView tvTime;
        @Bind(R.id.iv_list_item_activity)
        ImageView ivActivity;
        @Bind(R.id.tv_list_item_activity_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_activity_content)
        TextView tvContent;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
