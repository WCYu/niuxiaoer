package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.PrefUtils;
import com.rxjy.niuxiaoer.mvp.contract.UpdUserInfoContract;
import com.rxjy.niuxiaoer.mvp.presenter.UpdUserInfoPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdUserInfoActivity extends BaseActivity<UpdUserInfoPresenter> implements UpdUserInfoContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_keyword)
    TextView tvKeyword;
    @Bind(R.id.et_upd_content)
    EditText etUpdContent;

    private String title;
    private String keyValue;
    private String key;
    private String value;
    private String updContent;
    private String style;

    @Override
    public int getLayout() {
        return R.layout.activity_upd_user_info;
    }

    @Override
    public void initData() {
        initIntent();
        initTitle();
        initUpdData();
    }

    private void initIntent() {
        keyValue = getIntent().getStringExtra(Constants.ACTION_TO_UPD_USER_INFO_KEY_VALUE);
        key = getIntent().getStringExtra(Constants.ACTION_TO_UPD_USER_INFO_KEY);
        value = getIntent().getStringExtra(Constants.ACTION_TO_UPD_USER_INFO_VALUE);
        style = getIntent().getStringExtra(Constants.ACTION_TO_UPD_USER_INFO_STYLE);
    }

    private void initTitle() {
        tvTitle.setText("修改" + keyValue);
    }

    private void initUpdData() {
        tvKeyword.setText(keyValue + "：");
        etUpdContent.setHint("请输入" + keyValue);
        etUpdContent.setText(value);
        Log.e("style", value);
    }

    @Override
    protected UpdUserInfoPresenter onCreatePresenter() {
        return new UpdUserInfoPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                updContent = etUpdContent.getText().toString().trim();
                if (updContent.equals("")) {
                    showToast("请输入修改内容");
                    return;
                }
                if (updContent.equals(value)) {
                    showToast("修改内容不能与原内容相同");
                    return;
                }
                if (style.equals("email")) {
                    String text = etUpdContent.getText().toString();
                    Pattern p = Pattern.compile("[\u4e00-\u9fa5-]");
                    Matcher m = p.matcher(text);
                    if (text.length()!=text.getBytes().length) {
                        Toast.makeText(this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!text.contains("@")){
                        Toast.makeText(this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

                //修改用户信息
                mPresenter.updateUserInfo(App.token, App.cardNo, key, updContent.trim());
                break;
        }
    }

    @Override
    public void responseUpdateData() {
        showToast("修改成功");
        switch (key) {
            case "nick_name":
                App.baseInfo.setNickName(updContent);
                break;
            case "email":
                App.baseInfo.setEmail(updContent);
                break;
        }
        finish();
    }

    @Override
    public void responseUpdateDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseUpPicture() {

    }

    @Override
    public void responseUpPictureError(String msg) {

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
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
}
