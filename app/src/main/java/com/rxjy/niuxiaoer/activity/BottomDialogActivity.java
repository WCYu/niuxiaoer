package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;

public class BottomDialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.bottom_dialog);
    }

    @Override
    public int getLayout() {
        return R.layout.bottom_dialog;
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
