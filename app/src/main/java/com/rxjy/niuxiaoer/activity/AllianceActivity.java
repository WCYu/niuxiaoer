package com.rxjy.niuxiaoer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.adapter.AllianceAdapter;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.AutoUtils;
import com.rxjy.niuxiaoer.entity.AllianceListInfo;
import com.rxjy.niuxiaoer.mvp.contract.AllianceContract;
import com.rxjy.niuxiaoer.mvp.presenter.AlliancePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllianceActivity extends BaseActivity<AlliancePresenter> implements AllianceContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_input_alliance)
    Button btnInputAlliance;
    @Bind(R.id.tv_alliance_count)
    TextView tvAllianceCount;
    @Bind(R.id.lv_alliance)
    ListView lvAlliance;

    private EditText et;

    private Button btn;

    public static final String TITLE = "联盟";

    private List<AllianceListInfo.AllianceInfo.Alliance> allList;

    private AllianceAdapter mAdapter;

    private AlertDialog.Builder builder;

    private AlertDialog dialog;

    private int dialogState = 0;

    @Override
    public int getLayout() {
        return R.layout.activity_alliance;
    }

    @Override
    public void initData() {
        initTitle();
        initAllianceData();
        initDialog();
    }

    private void initTitle() {
        tvTitle.setText(TITLE);
    }

    private void initAllianceData() {

        allList = new ArrayList<>();

        mAdapter = new AllianceAdapter(this, allList);

        lvAlliance.setAdapter(mAdapter);

        mPresenter.getAllianceList(App.cardNo);

    }

    private void initDialog() {
        final View dialogView = View.inflate(this, R.layout.dialog_custom, null);
        AutoUtils.auto(dialogView);
        builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        dialog = builder.create();

        et = (EditText) dialogView.findViewById(R.id.et_dialog);
        btn = (Button) dialogView.findViewById(R.id.btn_dialog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogState == 0) {
                    // 得到剪贴板管理器
                    ClipboardManager cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    cmb.setText(App.cardNo);
                    showToast("复制成功");
                    if (dialog != null)
                        dialog.dismiss();
                } else {
                    //加入联盟接口
                    if (et.getText().toString().trim().equals(""))
                        showToast("请输入推荐码");
                    else
                        mPresenter.joinUnion(App.cardNo, et.getText().toString().trim());
                    if (dialog != null)
                        dialog.dismiss();
                }
            }
        });
    }

    @Override
    protected AlliancePresenter onCreatePresenter() {
        return new AlliancePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_submit, R.id.btn_input_alliance, R.id.btn_develop_alliance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                startActivity(new Intent(this, ExplainActivity.class));
                break;
            case R.id.btn_input_alliance:
                btn.setText("加入");
                dialogState = 1;
                et.setText("");
                et.setFocusable(true);
                et.setFocusableInTouchMode(true);
                et.requestFocus();
                et.findFocus();
                dialog.show();
                break;
            case R.id.btn_develop_alliance:
                btn.setText("复制");
                dialogState = 0;
                et.setText(App.cardNo);
                et.setFocusable(false);
                dialog.show();
                break;
        }
    }

    @Override
    public void responseAllianceData(AllianceListInfo.AllianceInfo data) {
        tvAllianceCount.setText(data.getCount() + "");
        tvTitle.setText(TITLE + "(" + data.getCount() + ")");
    }

    @Override
    public void responseAllianceListData(List<AllianceListInfo.AllianceInfo.Alliance> dataList) {
        allList.clear();
        allList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void responseAllianceListDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseJoinUnion() {
        showToast("加入联盟成功");
    }

    @Override
    public void responseJoinUnionError(String msg) {
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
}
