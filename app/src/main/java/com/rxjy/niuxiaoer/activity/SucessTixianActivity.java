package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SucessTixianActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivback;
   @Bind(R.id.btn_tixian_fanhui)
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sucess_tixian);
        ButterKnife.bind(this);
        App.backbs=1;
        tvTitle.setText("提现");
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                //WithdrawDepositActivity.this.finish();
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_sucess_tixian;
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
