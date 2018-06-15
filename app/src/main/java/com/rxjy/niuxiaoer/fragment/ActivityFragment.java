package com.rxjy.niuxiaoer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.ActivityDetailActivity;
import com.rxjy.niuxiaoer.adapter.ActivityAdapter;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.entity.ActivityListInfo;
import com.rxjy.niuxiaoer.mvp.contract.ActivityContract;
import com.rxjy.niuxiaoer.mvp.presenter.ActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/18.
 */

public class ActivityFragment extends BaseFragment<ActivityPresenter> implements ActivityContract.View, AdapterView.OnItemClickListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_activity)
    ListView lvActivity;

    public static final String TITLE = "活动";

    private List<ActivityListInfo.ActivityList> actList;

    private ActivityAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        initActivity();
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initActivity() {

        actList = new ArrayList<>();

        mAdapter = new ActivityAdapter(getActivity(), actList);

        lvActivity.setAdapter(mAdapter);

        lvActivity.setOnItemClickListener(this);

        //获取活动列表
        mPresenter.getActivityList();

    }

    @Override
    protected ActivityPresenter onCreatePresenter() {
        return new ActivityPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void responseActivityListData(List<ActivityListInfo.ActivityList> dataList) {
        actList.clear();
        actList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseActivityListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ActivityListInfo.ActivityList info = actList.get(position);
        Intent intent = new Intent(getActivity(), ActivityDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_ACTIVITY_DETAIL_URL, info.getBlankUrl());
        intent.putExtra(Constants.ACTION_TO_ACTIVITY_DETAIL_NAME, info.getTitle());
        startActivity(intent);
    }


}
