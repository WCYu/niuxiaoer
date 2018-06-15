package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExplainActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    public static final String TITLE = "联盟";

    @Override
    public int getLayout() {
        return R.layout.activity_explain;
    }

    @Override
    public void initData() {
        initTitle();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
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
}
