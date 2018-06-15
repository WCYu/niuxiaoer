package com.rxjy.niuxiaoer.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetKehuXingmingInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.SubmitDialogContract;
import com.rxjy.niuxiaoer.mvp.presenter.SubmitDialogPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SubmitDialogActivity extends BaseActivity<SubmitDialogPresenter> implements SubmitDialogContract.View {

    @Bind(R.id.btn_tiaoguo)
    Button btnTiaoguo;
    @Bind(R.id.btn_sure)
    Button btnSure;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_submit_dialog);
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_submit_dialog;
    }

    @Override
    public void initData() {

        final int saveorsub = getIntent().getIntExtra("saveorsub", 0);
        if (saveorsub == 2) {
            btnTiaoguo.setVisibility(View.GONE);
        } else if (saveorsub == 1) {
            btnTiaoguo.setVisibility(View.VISIBLE);
        }

        mPresenter.getName(App.danhao);

        btnTiaoguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mPresenter.UpBaoCunOrSubmit(App.danhao,
                            etPhone.getText().toString(),
                            etName.getText().toString(),
                            3);

            }
        });

        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etPhone.getText().toString().trim().equals("")){
                    showToast("客户电话不能为空");

                } else if (etPhone.getText().toString().length()!=11) {
                    showToast("请填写正确手机号");
                } else {
                    if (saveorsub == 1) {
                        mPresenter.UpBaoCunOrSubmit(App.danhao,
                                etPhone.getText().toString(),
                                etName.getText().toString(),
                                1);
                    } else if (saveorsub == 2) {
                        mPresenter.UpBaoCunOrSubmit(App.danhao,
                                etPhone.getText().toString(),
                                etName.getText().toString(),
                                2);
                    }
                }


            }
        });



    }

    @Override
    protected SubmitDialogPresenter onCreatePresenter() {
        return new SubmitDialogPresenter(this);
    }

    @Override
    public void responseGetName(GetKehuXingmingInfo info) {

        etName.setText(info.getBody().get(0).getXingMing());
        if (!info.getBody().get(0).getShouJiHaoYi().equals("0")) {
            etPhone.setText(info.getBody().get(0).getShouJiHaoYi());
        }
    }

    @Override
    public void responseGetNameError(String msg) {

    }

    @Override
    public void responseUpXinxi(UpPartAddInfo info) {

        showToast("上传成功");
        setResult(101);
        finish();

    }

    @Override
    public void responseUpXinxiError(UpPartAddInfo msg) {
        showToast(msg.getStatusMsg());
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
