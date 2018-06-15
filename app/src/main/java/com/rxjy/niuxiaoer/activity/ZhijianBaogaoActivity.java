package com.rxjy.niuxiaoer.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.adapter.ZhijianbaogaoAdapter;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.entity.ZhijianYesorNoInfo;
import com.rxjy.niuxiaoer.entity.ZhijianbaogaoInfo;
import com.rxjy.niuxiaoer.mvp.contract.ZhijianbaogaoContract;
import com.rxjy.niuxiaoer.mvp.presenter.ZhijianbaogaoPresenter;
import com.rxjy.niuxiaoer.widget.Mylistview;

import java.util.List;

import butterknife.Bind;

public class ZhijianBaogaoActivity extends BaseActivity<ZhijianbaogaoPresenter> implements ZhijianbaogaoContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_zjbg_price)
    TextView tvZjbgPrice;

    @Bind(R.id.lv_zjbg_buhege)
    Mylistview lvZjbgBuhege;

    @Bind(R.id.lv_zjbg_hege)
    Mylistview lvZjbgHege;
    @Bind(R.id.iv_zjbg_buhege)
    ImageView ivZjbgBuhege;
    @Bind(R.id.iv_zjbg_hege)
    ImageView ivZjbgHege;
    @Bind(R.id.tv_xmbg_buhegecount)
    TextView tvXmbgBuhegecount;
    @Bind(R.id.tv_xmbg_hegecount)
    TextView tvXmbgHegecount;
    @Bind(R.id.ll_xmbg_buhegecount)
    LinearLayout llXmbgBuhegecount;
    @Bind(R.id.ll_xmbg_hegecount)
    LinearLayout llXmbgHegecount;

    int yesornobs = -1;

    int yesbs = 0;
    int nobs = 0;
    @Bind(R.id.tv_bottom_zuizhongjine)
    TextView tvBottomZuizhongjine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_zhijian_baogao);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_zhijian_baogao;
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
        tvTitle.setText("质检报告");

        llXmbgHegecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesbs == 0) {
                    yesornobs = 1;
                    lvZjbgHege.setVisibility(View.VISIBLE);
                    mPresenter.getZhijianhegeInfo(bodyBean.getDanHao(), 1);
                    yesbs = 1;
                } else if (yesbs == 1) {
                    lvZjbgHege.setVisibility(View.GONE);
                    yesbs = 0;
                }
            }
        });

        llXmbgBuhegecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nobs == 0) {
                    yesornobs = 0;
                    lvZjbgBuhege.setVisibility(View.VISIBLE);
                    mPresenter.getZhijianhegeInfo(bodyBean.getDanHao(), 0);
                    nobs = 1;
                } else if (nobs == 1) {
                    lvZjbgBuhege.setVisibility(View.GONE);
                    nobs = 0;
                }
            }
        });


        tvBottomZuizhongjine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });


    }

    @Override
    protected ZhijianbaogaoPresenter onCreatePresenter() {
        return new ZhijianbaogaoPresenter(this);
    }

    private List<ZhijianbaogaoInfo.BodyBean> info;
    @Override
    public void responseGetData(List<ZhijianbaogaoInfo.BodyBean> info) {
        this.info=info;
        tvZjbgPrice.setText(info.get(0).getPingGuPrice() + "");
        tvBottomZuizhongjine.setText("最终金额￥"+info.get(0).getSureMoney()+"");

        tvXmbgHegecount.setText(info.get(0).getYesXmCount() + "项");
        tvXmbgBuhegecount.setText(info.get(0).getNoXmCount() + "项");

    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void responsezhijianYesorNo(List<ZhijianYesorNoInfo.BodyBean> info) {
        if (yesornobs == 1) {
            ZhijianbaogaoAdapter adapter = new ZhijianbaogaoAdapter(this, info);
            lvZjbgHege.setAdapter(adapter);
        } else if (yesornobs == 0) {
            ZhijianbaogaoAdapter adapter = new ZhijianbaogaoAdapter(this, info);
            lvZjbgBuhege.setAdapter(adapter);
        }


    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {

        dismissLoading();
    }

    private View inflate;
    private Dialog dialog;

    public void show() {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null);
        TextView tv_yujimoney= (TextView) inflate.findViewById(R.id.tv_yujijine);
        TextView tv_shijimoney= (TextView) inflate.findViewById(R.id.tv_shijijine);
        tv_yujimoney.setText("￥"+info.get(0).getPingGuPrice());
        tv_shijimoney.setText("￥"+info.get(0).getSureMoney());

        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //lp.y = 20;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);


        dialog.show();
    }

}
