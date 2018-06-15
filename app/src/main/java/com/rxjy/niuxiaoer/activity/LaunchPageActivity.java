package com.rxjy.niuxiaoer.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.NetUtil;
import com.rxjy.niuxiaoer.commons.utils.PrefUtils;
import com.rxjy.niuxiaoer.entity.UserInfo;
import com.rxjy.niuxiaoer.mvp.contract.LogoContract;
import com.rxjy.niuxiaoer.mvp.presenter.LogoPresenter;

public class LaunchPageActivity extends BaseActivity<LogoPresenter> implements LogoContract.View
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_launch_page);
        if (!NetUtil.isConnected(this)) {
            showDialogTip(1);
        }
        if (PrefUtils.getIntValue(LaunchPageActivity.this, Constants.YINDAOYE)==1){

        }else{
            PrefUtils.putIntValue(this, Constants.YINDAOYE,0);
        }
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (PrefUtils.getIntValue(LaunchPageActivity.this,Constants.YINDAOYE)==0){
                    PrefUtils.putIntValue(LaunchPageActivity.this, Constants.YINDAOYE,1);
                    startActivity(new Intent(LaunchPageActivity.this,GuidePageActivity.class));
                    finish();

                }else if (PrefUtils.getIntValue(LaunchPageActivity.this,Constants.YINDAOYE)==1){
                    if (PrefUtils.getBooleanValue(LaunchPageActivity.this, Constants.IS_LOGIN)){

                        String cardNo = PrefUtils.getValue(LaunchPageActivity.this, Constants.CARD_NO);
                        String token = PrefUtils.getValue(LaunchPageActivity.this, Constants.TOKEN);

                        App.cardNo = cardNo;
                        App.token = token;

                        mPresenter.getLoginUserInfo(cardNo, token);


                    }else{
                        startActivity(new Intent(LaunchPageActivity.this,LoginActivity.class));
                        finish();
                    }



                }
            }
        },2000);
    }



    @Override
    public int getLayout() {
        return R.layout.activity_launch_page;
    }

    @Override
    public void initData() {

    }

    @Override
    protected LogoPresenter onCreatePresenter() {
        return new LogoPresenter(this);
    }

    @Override
    public void responseLogin(UserInfo.User data) {
        App.cardNo = PrefUtils.getValue(this, Constants.CARD_NO);
        App.token = PrefUtils.getValue(this, Constants.TOKEN);

        App.baseInfo = data.getBaseinfo();
        App.personnelInfo = data.getPersonnelInfo();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void responseLoginError(String msg) {
        showToast(msg);
        showDialogTip(2);
    }
    private void showDialogTip(int type) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (type) {
            case 1:
                builder.setTitle("提示");
                builder.setMessage("没有网络，请链接网络");
                builder.setCancelable(false);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(wifiSettingsIntent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
            case 2:
                builder.setTitle("提示");
                builder.setMessage("网络超时，请检查网络");
                builder.setCancelable(false);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(wifiSettingsIntent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
        }
    }
    @Override
    public void reLogin(String msg) {
        showToast(msg);
        PrefUtils.RemoveValue(this, Constants.IS_LOGIN);
        PrefUtils.RemoveValue(this, Constants.CARD_NO);
        PrefUtils.RemoveValue(this, Constants.TOKEN);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
