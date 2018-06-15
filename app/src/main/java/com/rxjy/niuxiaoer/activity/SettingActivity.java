package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.utils.PrefUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_vision_name)
    TextView tvVisionName;

    public static final String TITLE = "设置";

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {
        initTitle();
        initVersionData();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initVersionData() {
        tvVisionName.setText("V " + App.getVersionName());
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

    @OnClick({R.id.iv_back, R.id.rl_upd_password, R.id.btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_upd_password:
                startActivity(new Intent(this, UpdPasswordActivity.class));
                break;
            case R.id.btn_quit:
                App.getApp().exitApp();
                PrefUtils.RemoveValue(this, Constants.IS_LOGIN);
                PrefUtils.RemoveValue(this, Constants.CARD_NO);
                PrefUtils.RemoveValue(this, Constants.TOKEN);
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
