package com.rxjy.niuxiaoer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.SingleBaseAdapter;
import com.rxjy.niuxiaoer.commons.base.SingleViewHolder;
import com.rxjy.niuxiaoer.entity.NewsListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/12.
 */
public class NewsListAdapter extends SingleBaseAdapter<NewsListInfo.NewsList.NewsInfo, NewsListAdapter.ViewHolder> {

    public NewsListAdapter(Context context, List<NewsListInfo.NewsList.NewsInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_news_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, NewsListInfo.NewsList.NewsInfo data, ViewHolder holder) {

        holder.tvNewsListTitle.setText(data.getName());
        holder.tvNewsListDepartment.setText(data.getSpare1());
        holder.tvNewsListRead.setText("" + data.getView());
        holder.tvNewsListGreat.setText("" + data.getPraise());

        Glide.with(context).load(data.getCover()).into(holder.ivNewsList);
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_news_list)
        ImageView ivNewsList;
        @Bind(R.id.tv_news_list_title)
        TextView tvNewsListTitle;
        @Bind(R.id.tv_news_list_department)
        TextView tvNewsListDepartment;
        @Bind(R.id.tv_news_list_great)
        TextView tvNewsListGreat;
        @Bind(R.id.tv_news_list_read)
        TextView tvNewsListRead;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
