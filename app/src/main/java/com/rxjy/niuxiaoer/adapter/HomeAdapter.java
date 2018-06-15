package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/26.
 */

public class HomeAdapter extends SingleBaseAdapter<GetNewShouyeInfo.BodyBean.DataListBean, HomeAdapter.ViewHolder> {


    private List<GetNewShouyeInfo.BodyBean.DataListBean> datas;

    public HomeAdapter(Context context, List<GetNewShouyeInfo.BodyBean.DataListBean> datas) {
        super(context, datas);
        this.datas = datas;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_home;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final GetNewShouyeInfo.BodyBean.DataListBean data, ViewHolder holder) {

        holder.tvHomeJiben.setText(data.getJiBen());
        holder.tvHomeKehu.setText(data.getKeHu());
        holder.tvHomeFangyuan.setText(data.getFangYuan());
        holder.tvHomeXuqiu.setText(data.getXuQiu());
        holder.tvHomeStatus.setText(data.getZhuangTai());
        holder.tvHomeDate.setText(data.getShiJian());
        holder.tvHomeMoney.setText("￥"+data.getPingGuPrice()+"");
//        holder.tv_danhao.setText(data.getDanHao());


        if (data.getZhuangTaiID()==1){
            //未提交
            holder.tvHomeStatus.setTextColor(Color.parseColor("#fe853c"));
            holder.ivHomeStatus.setImageResource(R.mipmap.chongxinxunjia);
        }else if (data.getZhuangTaiID()==2){
            //待受理
            holder.tvHomeStatus.setTextColor(Color.parseColor("#00a0ea"));
            holder.ivHomeStatus.setImageResource(R.mipmap.xiangmuxinxi);
        }else if (data.getZhuangTaiID()==3){
            //已完成
            holder.tvHomeStatus.setTextColor(Color.parseColor("#22ac38"));
            holder.ivHomeStatus.setImageResource(R.mipmap.zhijianbaogao);
        }else if (data.getZhuangTaiID()==4){
            //未通过
            holder.tvHomeStatus.setTextColor(Color.parseColor("#e60012"));
            holder.ivHomeStatus.setImageResource(R.mipmap.chongxinxunjia);
        }


//        holder.tvName.setText(data.getXingMing());
//        holder.tvTime.setText(data.getTianJiaShiJian().substring(0, 10));
//        holder.tvOrderNo.setText(data.getDanHao());
//        holder.tv_status.setText(data.getStateName());
//        //判断是否显示未读状态
//        if (data.getStatus() == 1) {
//            holder.tvRedPoint.setVisibility(View.VISIBLE);
//        } else {
//            holder.tvRedPoint.setVisibility(View.INVISIBLE);
//        }
//        holder.iv_phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + data.getShouJiHaoYi()));
//                context.startActivity(intent);
//            }
//        });


    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public int getItemViewType(int position) {
        GetNewShouyeInfo.BodyBean.DataListBean info = datas.get(position);
        int state = info.getZhuangTaiID();
        //在跟踪  打回可以删除
        if (state == 1 || state == 4) {
            return 0;
        } else {
            return 1;
        }
    }

    class ViewHolder implements SingleViewHolder {
//        @Bind(R.id.tv_list_item_home_name)
//        TextView tvName;
//        @Bind(R.id.tv_list_item_home_time)
//        TextView tvTime;
//        @Bind(R.id.tv_list_item_home_order_no)
//        TextView tvOrderNo;
//        @Bind(R.id.tv_list_item_home_status)
//        TextView tv_status;
//        @Bind(R.id.iv_phone_icon)
//        ImageView iv_phone;
//        @Bind(R.id.tv_list_item_point_status)
//        TextView tvRedPoint;

        @Bind(R.id.tv_home_jiben)
        TextView tvHomeJiben;
        @Bind(R.id.tv_home_status)
        TextView tvHomeStatus;
        @Bind(R.id.tv_home_kehu)
        TextView tvHomeKehu;
        @Bind(R.id.tv_home_fangyuan)
        TextView tvHomeFangyuan;
        @Bind(R.id.tv_home_xuqiu)
        TextView tvHomeXuqiu;
        @Bind(R.id.tv_home_date)
        TextView tvHomeDate;
        @Bind(R.id.tv_home_money)
        TextView tvHomeMoney;
        @Bind(R.id.iv_home_status)
        ImageView ivHomeStatus;
        @Bind(R.id.tv_danhao)
        TextView tv_danhao;



        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
