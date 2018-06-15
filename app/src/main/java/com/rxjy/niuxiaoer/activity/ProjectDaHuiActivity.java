package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.entity.ProjectDahuiInfo;
import com.rxjy.niuxiaoer.mvp.contract.ProjectDahuiContract;
import com.rxjy.niuxiaoer.mvp.presenter.ProjectDahuiPresenter;

import java.util.List;

import butterknife.Bind;

public class ProjectDaHuiActivity extends BaseActivity<ProjectDahuiPresenter> implements ProjectDahuiContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_xmdh_price)
    TextView tvXmdhPrice;
    @Bind(R.id.tv_xmdh_dahuiyuanyin)
    TextView tvXmdhDahuiyuanyin;
    @Bind(R.id.ll_chongxinxunjia)
    LinearLayout llChongxinxunjia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_project_da_hui);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_project_da_hui;
    }

    @Override
    public void initData() {
        final GetNewShouyeInfo.BodyBean.DataListBean bodyBean = (GetNewShouyeInfo.BodyBean.DataListBean) getIntent().getSerializableExtra("GETNEWSHOUYEINFO");
        mPresenter.getProjectDahui(bodyBean.getDanHao());
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle.setText("项目打回");

        llChongxinxunjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProjectDaHuiActivity.this,PartAddActivity.class);
                intent.putExtra("DANHAO",bodyBean.getDanHao());
                App.danhaobs=1;
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected ProjectDahuiPresenter onCreatePresenter() {
        return new ProjectDahuiPresenter(this);
    }

    @Override
    public void responseGetData(List<ProjectDahuiInfo.BodyBean> info) {
        tvXmdhPrice.setText(info.get(0).getPingGuPrice()+"");
        tvXmdhDahuiyuanyin.setText(info.get(0).getDaHuiYuanYin());

    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
