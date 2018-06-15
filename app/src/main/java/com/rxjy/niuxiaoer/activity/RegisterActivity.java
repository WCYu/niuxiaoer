package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.PrefUtils;
import com.rxjy.niuxiaoer.commons.utils.StringUtils;
import com.rxjy.niuxiaoer.entity.TokenInfo;
import com.rxjy.niuxiaoer.entity.UserInfo;
import com.rxjy.niuxiaoer.entity.YaoQingMaInfo;
import com.rxjy.niuxiaoer.mvp.contract.RegisterContract;
import com.rxjy.niuxiaoer.mvp.presenter.RegisterPresenter;
import com.rxjy.niuxiaoer.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_phone_num)
    EditText etPhoneNum;
    @Bind(R.id.tv_old_password_line)
    TextView tvPhoneLine;
    @Bind(R.id.et_verification_code)
    EditText etVerificationCode;
    @Bind(R.id.tv_verification_code_line)
    TextView tvVerificationCodeLine;
    @Bind(R.id.et_new_password)
    EditText etNewPassword;
    @Bind(R.id.tv_new_password_line)
    TextView tvNewPasswordLine;
    @Bind(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @Bind(R.id.tv_confirm_password_line)
    TextView tvConfirmPasswordLine;
    @Bind(R.id.et_referral_code)
    EditText etReferralCode;
    @Bind(R.id.tv_referral_code_line)
    TextView tvReferralCodeLine;
    @Bind(R.id.cb_agreement)
    CheckBox cbAgreement;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.btn_verification_code)
    Button btnVerificationCode;

    public static final String TITLE = "注册";

    private String phoneNum;
    private String confirmPassword;

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {
//        String phone=PrefUtils.getValue(this,Constants.REGISTERPHONE);
//        etPhoneNum.setText(phone);

        App.daojishi=PrefUtils.getIntValue(RegisterActivity.this,Constants.DAOJISHI);
        Log.e("daojishi",PrefUtils.getIntValue(RegisterActivity.this,Constants.DAOJISHI)+"");
        if (App.daojishi!=0){
            startTimer2();
        }
        initTitle();
        initLine();
        initButton();
        //设置倒计时为60秒
        //btnVerificationCode.setDuration(60000);
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initLine() {
        etPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvPhoneLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvPhoneLine.setEnabled(false);
                }
            }
        });
        etVerificationCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvVerificationCodeLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvVerificationCodeLine.setEnabled(false);
                }
            }
        });
        etNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvNewPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvNewPasswordLine.setEnabled(false);
                }
            }
        });
        etConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvConfirmPasswordLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvConfirmPasswordLine.setEnabled(false);
                }
            }
        });
        etReferralCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //此处为得到焦点时
                    tvReferralCodeLine.setEnabled(true);
                } else {
                    //此处为失去焦点时
                    tvReferralCodeLine.setEnabled(false);
                }
            }
        });
    }

    private void initButton() {

        cbAgreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnRegister.setEnabled(true);
                } else {
                    btnRegister.setEnabled(false);
                }
            }
        });

    }

    @Override
    protected RegisterPresenter onCreatePresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_agreement, R.id.btn_verification_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_agreement:
                startActivity(new Intent(this, YulanWebActivity.class));
                break;
            case R.id.btn_verification_code:
                String phone = etPhoneNum.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {

                    showToast("请输入手机号");
                    return;
                }
//                if (!StringUtils.isMobileNO(phone)) {
//
//                    showToast("请输入正确的手机号");
//                    return;
//                }
                mPresenter.getVerificationCode(phone);
                break;
            case R.id.btn_register:
                phoneNum = etPhoneNum.getText().toString().trim();
                confirmPassword = etConfirmPassword.getText().toString().trim();
                String verificationCode = etVerificationCode.getText().toString().trim();
                String newPassword = etNewPassword.getText().toString().trim();
                String referralCode = etReferralCode.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    showToast("请输入手机号");
                    return;
                }
//                if (!StringUtils.isMobileNO(phoneNum)) {
//                    showToast("请输入正确的手机号");
//                    return;
//                }
                if (TextUtils.isEmpty(verificationCode)) {
                    showToast("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    showToast("请输入新密码");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    showToast("请输入确认密码");
                    return;
                }
                //密码最少6位
                if (newPassword.length() < 6) {
                    showToast("密码最少6位");
                    return;
                }
                if (!newPassword.equals(confirmPassword)) {
                    showToast("两次密码输入不一致");
                    return;
                }
                if (TextUtils.isEmpty(referralCode)) {
                    showToast("请输入推荐码");
                    return;
                }
                if (code!=0){
                    showToast("邀请码无效");
                    return;
                }

                //密码数相同
                if (StringUtils.isSameChars(newPassword)) {
                    showToast("密码过于简单");
                    return;
                }

                //密码为连续数
                if (newPassword.equals("123456") || newPassword.equals("234567") || newPassword.equals("345678") || newPassword.equals("456789")) {
                    showToast("密码过于简单");
                    return;
                }

                //注册
                mPresenter.getRegister(verificationCode, phoneNum, newPassword, referralCode);
                break;
        }
    }

    @Override
    public void responseRegisterData() {
        showToast("注册成功");
        mPresenter.getToken(phoneNum, confirmPassword);
    }

    @Override
    public void responseRegisterError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseVCcode() {
        PrefUtils.putValue(this,Constants.REGISTERPHONE,etPhoneNum.getText().toString());
        startTimer();
    }


    private Timer mTimer; //调度器
    private TimerTask mTask;
    private long duration = 60000; //倒计时时长，默认为10秒
    private long temp_duration;
    private String clickBefore = "验证码"; //点击前
    private String clickAfter = "秒"; //点击后


    //计时开始
    private void startTimer() {
        temp_duration = duration;
        //设置按钮不可点击
        btnVerificationCode.setEnabled(false);
        mTimer = new Timer();
        mTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0x01);
            }
        };
        mTimer.schedule(mTask, 0, 1000);  //调度分配，延时0秒，时间间隔1秒
    }

    private void startTimer2() {
        temp_duration = App.daojishi*1000;
        //设置按钮不可点击
        btnVerificationCode.setEnabled(false);
        mTimer = new Timer();
        mTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0x01);
            }
        };
        mTimer.schedule(mTask, 0, 1000);  //调度分配，延时0秒，时间间隔1秒
    }

    //计时结束
    private void stopTimer() {
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            PrefUtils.putIntValue(RegisterActivity.this,Constants.DAOJISHI, (int) (temp_duration / 1000));

            Log.e("daojishi",PrefUtils.getIntValue(RegisterActivity.this,Constants.DAOJISHI)+"");
            if (btnVerificationCode!=null) {
                btnVerificationCode.setText(temp_duration / 1000 + clickAfter);
            }
            temp_duration -= 1000;

            //倒计时结束
            if (temp_duration < 0) {
                //设置可以点击

                if (btnVerificationCode!=null) {
                    btnVerificationCode.setEnabled(true);
                    btnVerificationCode.setText(clickBefore);
                }
                stopTimer();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void responseVerificationCodeDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseToken(TokenInfo.Token data) {

        PrefUtils.putValue(this, Constants.CARD_NO, data.getCardNo());
        PrefUtils.putValue(this, Constants.TOKEN, data.getToken());
        //存储已经登录的状态
        PrefUtils.putBooleanValue(this, Constants.IS_LOGIN, true);

        mPresenter.getLoginUserInfo(data.getCardNo(), data.getToken());
    }

    @Override
    public void responseTokenError(String msg) {
        showToast(msg);
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
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }
    private int code;
    @Override
    public void responseYaoQingMa(YaoQingMaInfo info) {
        code=info.getStatusCode();
    }



}
