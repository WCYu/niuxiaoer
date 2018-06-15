package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.MsgListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/18.
 */

public class MsgListAdapter extends SingleBaseAdapter<MsgListInfo.MsgList, MsgListAdapter.ViewHolder> {

    public MsgListAdapter(Context context, List<MsgListInfo.MsgList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_msg_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MsgListInfo.MsgList data, ViewHolder holder) {
        if (data.getStatus() == 0) {
            holder.ivIsRead.setImageResource(R.mipmap.email_read);
        } else {
            holder.ivIsRead.setImageResource(R.mipmap.email_un_read);
        }
        holder.tvTitle.setText(data.getName());
        holder.tvTime.setText(data.getCreateTime());
        holder.tvContent.setText(data.getContent());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_msg_list_is_read)
        ImageView ivIsRead;
        @Bind(R.id.tv_list_item_msg_list_title)
        TextView tvTitle;
        @Bind(R.id.tv_list_item_msg_list_content)
        TextView tvContent;
        @Bind(R.id.tv_list_item_msg_list_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
