package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.umeng.socialize.UMShareAPI;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityDetailActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.wv_activity_detail)
    WebView wvActivityDetail;

    public static final String TITLE = "活动详情";

    private String url;

    private String name;

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initActivity();
    }

    private void initIntent() {
        url = getIntent().getStringExtra(Constants.ACTION_TO_ACTIVITY_DETAIL_URL);
        name = getIntent().getStringExtra(Constants.ACTION_TO_ACTIVITY_DETAIL_NAME);
    }

    private void initTitle() {
        tvTitle.setText(name);
    }

    private void initActivity() {

        wvActivityDetail.loadUrl(url);

        wvActivityDetail.getSettings().setJavaScriptEnabled(true);
        // 为图片添加放大缩小功能
        wvActivityDetail.getSettings().setUseWideViewPort(true);

        wvActivityDetail.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
