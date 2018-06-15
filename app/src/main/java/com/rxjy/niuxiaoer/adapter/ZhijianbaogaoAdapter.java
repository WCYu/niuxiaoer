package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.ZhijianYesorNoInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ZhijianbaogaoAdapter extends SingleBaseAdapter<ZhijianYesorNoInfo.BodyBean, ZhijianbaogaoAdapter.ViewHolder> {




    public ZhijianbaogaoAdapter(Context context, List<ZhijianYesorNoInfo.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_zhijianyesorno;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ZhijianYesorNoInfo.BodyBean data, ViewHolder holder) {

        holder.tvZhijianbaogaoItemName.setText(data.getName());
        holder.tvZhijianbaogaoItemYuanyin.setText(data.getXinXiJieGuo());

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_zhijianbaogao_item_name)
        TextView tvZhijianbaogaoItemName;
        @Bind(R.id.tv_zhijianbaogao_item_yuanyin)
        TextView tvZhijianbaogaoItemYuanyin;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}
