package com.rxjy.niuxiaoer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.entity.ProjectInfo;
import com.rxjy.niuxiaoer.mvp.contract.ProjectInfoContract;
import com.rxjy.niuxiaoer.mvp.presenter.ProjectInfoPresenter;

import java.util.List;

import butterknife.Bind;

public class ProjectInfoActivity extends BaseActivity<ProjectInfoPresenter> implements ProjectInfoContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_xmxx_price)
    TextView tvXmxxPrice;
    @Bind(R.id.tv_xmxx_name)
    TextView tvXmxxName;
    @Bind(R.id.tv_xmxx_phoneone)
    TextView tvXmxxPhoneone;
    @Bind(R.id.tv_xmxx_phonetwo)
    TextView tvXmxxPhonetwo;
    @Bind(R.id.tv_xmxx_diqu)
    TextView tvXmxxDiqu;
    @Bind(R.id.tv_xmxx_type)
    TextView tvXmxxType;
    @Bind(R.id.tv_xmxx_mianji)
    TextView tvXmxxMianji;
    @Bind(R.id.ll_xmxx_one)
    LinearLayout llXmxxOne;
    @Bind(R.id.ll_xmxx_two)
    LinearLayout llXmxxTwo;
    @Bind(R.id.ll_xmxx_three)
    LinearLayout llXmxxThree;
    @Bind(R.id.ll_xmxx_four)
    LinearLayout llXmxxFour;
    @Bind(R.id.tv_xmxx_one)
    TextView tvXmxxOne;
    @Bind(R.id.tv_xmxx_two)
    TextView tvXmxxTwo;
    @Bind(R.id.tv_xmxx_three)
    TextView tvXmxxThree;
    @Bind(R.id.tv_xmxx_four)
    TextView tvXmxxFour;
    @Bind(R.id.iv_xmxx_one)
    ImageView ivXmxxOne;
    @Bind(R.id.iv_xmxx_two)
    ImageView ivXmxxTwo;
    @Bind(R.id.iv_xmxx_three)
    ImageView ivXmxxThree;
    @Bind(R.id.iv_xmxx_four)
    ImageView ivXmxxFour;

    private int llonebs = 0;
    private int lltwobs = 0;
    private int llthreebs = 0;
    private int llfourbs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_project_info);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_project_info;
    }

    @Override
    public void initData() {

        GetNewShouyeInfo.BodyBean.DataListBean bodyBean = (GetNewShouyeInfo.BodyBean.DataListBean) getIntent().getSerializableExtra("GETNEWSHOUYEINFO");
        mPresenter.getProjectInfo(bodyBean.getDanHao());
        tvTitle.setText("项目信息");

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llXmxxOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llonebs == 0) {
                    tvXmxxOne.setVisibility(View.VISIBLE);
                    ivXmxxOne.setImageResource(R.mipmap.shouqi);
                    llonebs = 1;
                } else if (llonebs == 1) {
                    tvXmxxOne.setVisibility(View.GONE);
                    ivXmxxOne.setImageResource(R.mipmap.xiala);
                    llonebs = 0;
                }

            }
        });

        llXmxxTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lltwobs == 0) {
                    tvXmxxTwo.setVisibility(View.VISIBLE);
                    ivXmxxTwo.setImageResource(R.mipmap.shouqi);
                    lltwobs = 1;
                } else if (lltwobs == 1) {
                    tvXmxxTwo.setVisibility(View.GONE);
                    ivXmxxTwo.setImageResource(R.mipmap.xiala);
                    lltwobs = 0;
                }
            }
        });

        llXmxxThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llthreebs == 0) {
                    tvXmxxThree.setVisibility(View.VISIBLE);
                    ivXmxxThree.setImageResource(R.mipmap.shouqi);
                    llthreebs = 1;
                } else if (llthreebs == 1) {
                    tvXmxxThree.setVisibility(View.GONE);
                    ivXmxxThree.setImageResource(R.mipmap.xiala);
                    llthreebs = 0;
                }

            }
        });

        llXmxxFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llfourbs == 0) {
                    tvXmxxFour.setVisibility(View.VISIBLE);
                    ivXmxxFour.setImageResource(R.mipmap.shouqi);
                    llfourbs = 1;
                } else if (llfourbs == 1) {
                    tvXmxxFour.setVisibility(View.GONE);
                    ivXmxxFour.setImageResource(R.mipmap.xiala);
                    llfourbs = 0;
                }
            }
        });

    }

    @Override
    protected ProjectInfoPresenter onCreatePresenter() {
        return new ProjectInfoPresenter(this);
    }

    @Override
    public void responseGetData(List<ProjectInfo.BodyBean> info) {

        tvXmxxPrice.setText(info.get(0).getPingGuPrice()+"");
        tvXmxxName.setText(info.get(0).getXingMing());
        if (!info.get(0).getShouJiHaoYi().equals("0")) {
            tvXmxxPhoneone.setText(info.get(0).getShouJiHaoYi());
        }
        if (!info.get(0).getShouJiHaoEr().equals("0")) {
            tvXmxxPhonetwo.setText(info.get(0).getShouJiHaoEr());
        }
        tvXmxxDiqu.setText(info.get(0).getAreaName());
        tvXmxxType.setText(info.get(0).getLeiXing());
        tvXmxxMianji.setText(info.get(0).getMianJi() + "");


    }

    @Override
    public void responseGetDataError(String msg) {

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
