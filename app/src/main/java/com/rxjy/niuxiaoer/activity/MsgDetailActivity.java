package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.MsgDetailInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgDetailContract;
import com.rxjy.niuxiaoer.mvp.presenter.MsgDetailPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MsgDetailActivity extends BaseActivity<MsgDetailPresenter> implements MsgDetailContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_msg_detail_time)
    TextView tvTime;
    @Bind(R.id.tv_msg_detail_title)
    TextView tvDetailTitle;
    @Bind(R.id.tv_msg_detail_content)
    TextView tvContent;

    public static final String TITLE = "消息详情";

    private int xinID;

    @Override
    public int getLayout() {
        return R.layout.activity_msg_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initMsgDetail();
    }

    private void initIntent() {
        xinID = getIntent().getIntExtra(Constants.ACTION_TO_MSG_DETAIL_ID, 0);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initMsgDetail() {
        mPresenter.getMsgDetail(xinID);
    }

    @Override
    protected MsgDetailPresenter onCreatePresenter() {
        return new MsgDetailPresenter(this);
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
    public void responseMsgDetailData(MsgDetailInfo.MsgDetail data) {
        tvTime.setText(data.getCreateTime());
        tvDetailTitle.setText(data.getName());
        tvContent.setText(data.getContent());
//        switch (data.getLeiXing()) {
//            case 1:
//                tvDetailTitle.setText("“" + data.getName() + "”审核通过");
//                tvContent.setText(Html.fromHtml("<font>您提交的项目“" + data.getName() + "<Br/>经过平台什么，已经“<font  color='#fe853c'>成功受理</font>”稍后工作人员将与您核实信息费的发放。请确认已经绑定银行卡。并注意接收电话。</font>"));
//                break;
//            case 2:
//                tvDetailTitle.setText("“" + data.getName() + "”审核不通过");
//                tvContent.setText("您提交的项目“" + data.getName() + "”\n未通过平台审核，请完善信息，或提交其他房源信息，感谢您的参与");
//                break;
//            case 3:
//                tvDetailTitle.setText("您有一条新的收入信息");
//                tvContent.setText(Html.fromHtml("<font>您提交的项目“" + data.getName() + "<Br/>经过平台什么，已经“<font  color='#fe853c'>成功受理</font>”奖金已经发放至您的银行卡，请注意查收。</font>"));
//                break;
//        }
    }

    @Override
    public void responseMsgDetailDataError(String msg) {
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
}
