package com.rxjy.niuxiaoer.activity;



import butterknife.Bind;

import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.mvp.presenter.YuLanPresenter;


public class YulanWebActivity extends BaseActivity{
	    @Bind(R.id.tv_title)
	    TextView tvTitle;
	    @Bind(R.id.iv_back)
	    ImageView ivback;
	    @Bind(R.id.wb)
		WebView web_webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tvTitle.setText("注册协议");
		ivback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});


		web_webview.getSettings().setJavaScriptEnabled(true);
		//允许window.open()创建窗口
		web_webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		web_webview.getSettings().setLoadWithOverviewMode(true);//
		web_webview.getSettings().setUseWideViewPort(true);
		web_webview.getSettings().setSupportMultipleWindows(true);
		web_webview.getSettings().setSupportZoom(true);
		web_webview.getSettings().setAppCacheEnabled(true);
		web_webview.getSettings().setDomStorageEnabled(true);
		web_webview.setScrollBarStyle(web_webview.SCROLLBARS_OUTSIDE_OVERLAY);  
		web_webview.setHorizontalScrollBarEnabled(false);  
		web_webview.getSettings().setSupportZoom(true);  
		//设置web_view可触摸放大缩小
		web_webview.getSettings().setBuiltInZoomControls(false);
		web_webview.setInitialScale(50);
		web_webview.setHorizontalScrollbarOverlay(true); 
		//String url=getIntent().getExtras().getString("url");
		String url="file:///android_asset/zhuce.html";
		web_webview.loadUrl(url);
	}

	@Override
	public int getLayout() {
		return R.layout.activity_yulan_web;
	}

	@Override
	public void initData() {

	}

	@Override
	protected YuLanPresenter onCreatePresenter() {
		return null;
	}

}
