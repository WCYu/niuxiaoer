package com.rxjy.niuxiaoer.activity.my;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetNameActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_name)
    EditText tvName;
    @Bind(R.id.rl_name)
    LinearLayout rlName;
    @Bind(R.id.btn_commit)
    Button btnCommit;

    @Override
    public int getLayout() {
        return R.layout.activity_set_name;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_commit:
                if(!TextUtils.isEmpty(tvName.getText().toString())){
                    setResult(1001,getIntent().putExtra("name",tvName.getText().toString()));
                    finish();
                }else {
                    ToastUtil.getInstance().toastCentent("请输入姓名",this);
                }
                break;
        }
    }
}
