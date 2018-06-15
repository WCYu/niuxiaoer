package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.adapter.MsgListAdapter;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.MsgListInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgListContract;
import com.rxjy.niuxiaoer.mvp.presenter.MsgListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MsgListActivity extends BaseActivity<MsgListPresenter> implements MsgListContract.View, AdapterView.OnItemClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_msg_list)
    ListView lvMsgList;

    public static final String TITLE = "消息";

    private List<MsgListInfo.MsgList> msgList;

    private MsgListAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_msg_list;
    }

    @Override
    public void initData() {
        initTitle();
        initMsgList();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMsgList() {

        msgList = new ArrayList<>();

        mAdapter = new MsgListAdapter(this, msgList);

        lvMsgList.setAdapter(mAdapter);

        lvMsgList.setOnItemClickListener(this);

    }

    @Override
    protected MsgListPresenter onCreatePresenter() {
        return new MsgListPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //获取详细列表
        mPresenter.getMsgList(App.cardNo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void responseMsgListData(List<MsgListInfo.MsgList> dataList) {
        msgList.clear();
        msgList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseMsgListDataError(String msg) {
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
        MsgListInfo.MsgList info = this.msgList.get(position);
        Intent intent = new Intent(this, MsgDetailActivity.class);
        intent.putExtra(Constants.ACTION_TO_MSG_DETAIL_ID, info.getXinID());
        startActivity(intent);
    }
}
