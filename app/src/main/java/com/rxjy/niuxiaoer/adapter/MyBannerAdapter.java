package com.rxjy.niuxiaoer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.taobao.library.BaseBannerAdapter;
import com.taobao.library.VerticalBannerView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */

public class MyBannerAdapter extends BaseBannerAdapter<GetNewShouyeInfo.BodyBean.DataTotalBean> {

        //private List<GetNewShouyeInfo.BodyBean.DataTotalBean> mDatas;

        public MyBannerAdapter(List<GetNewShouyeInfo.BodyBean.DataTotalBean> datas) {
            super(datas);
        }

        @Override
        public View getView(VerticalBannerView parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gundong,null);
        }

        @Override
        public void setItem(final View view, final GetNewShouyeInfo.BodyBean.DataTotalBean data) {
            TextView tv_name = (TextView) view.findViewById(R.id.tv_gundong_name);
            TextView tv_phone = (TextView) view.findViewById(R.id.tv_gundong_phone);
            TextView tv_state = (TextView) view.findViewById(R.id.tv_gundong_state);
            TextView tv_money = (TextView) view.findViewById(R.id.tv_gundong_money);

            tv_name.setText(data.getFenGongSiMingCheng());
            tv_phone.setText(data.getShouJi());
            tv_state.setText(data.getMemRank());
            tv_money.setText("+"+data.getMoney());

            //textView.setText(data.title);
            // 你可以增加点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO handle click event
                }
            });
        }
    }



