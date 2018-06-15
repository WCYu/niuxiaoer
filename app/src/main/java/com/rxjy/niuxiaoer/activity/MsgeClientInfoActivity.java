package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.StringUtils;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientDetailInfo;
import com.rxjy.niuxiaoer.entity.MsgeClientTypeInfo;
import com.rxjy.niuxiaoer.entity.TcInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgeClientInfoContract;
import com.rxjy.niuxiaoer.mvp.presenter.MsgeClientInfoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MsgeClientInfoActivity extends BaseActivity<MsgeClientInfoPresenter> implements MsgeClientInfoContract.View {

    public static final String TITLE = "客户详情";

    @Bind(R.id.iv_back)
    ImageView ivHeaderBack;
    @Bind(R.id.tv_title)
    TextView tvHeaderTitle;
    @Bind(R.id.et_client_info_name)
    EditText etClientInfoName;
    @Bind(R.id.et_client_info_phone_num)
    EditText etClientInfoPhoneNum;
    @Bind(R.id.et_client_info_company_name)
    EditText etClientInfoCompanyName;
    @Bind(R.id.et_client_info_acreage)
    EditText etClientInfoAcreage;

    @Bind(R.id.et_client_info_measure_address)
    EditText etClientInfoMeasureAddress;
    @Bind(R.id.et_client_info_type)
    EditText ettype;
    @Bind(R.id.rg_home_status_xq)
    RadioGroup rg_home;
    @Bind(R.id.rb_home_status_yd_xq)
    RadioButton rb_home_yd;
    @Bind(R.id.rb_home_status_wd_xq)
    RadioButton rb_home_wd;
    @Bind(R.id.et_remark_xq)
    EditText et_remark;
    @Bind(R.id.tv_taocancheck_xq)
    TextView tv_taocancheck_xq;
    @Bind(R.id.rg_combo_check_xq)
    RadioGroup rg_combo;
    @Bind(R.id.rb_combo_check_tc1_xq)
    RadioButton rb_tc1;
    @Bind(R.id.rb_combo_check_tc2_xq)
    RadioButton rb_tc2;
    @Bind(R.id.rb_combo_check_tc3_xq)
    RadioButton rb_tc3;
    @Bind(R.id.btn_savasubmit_xq)
    Button btn_sub;
    @Bind(R.id.btn_sava_xq)
    Button btn_save;
    @Bind(R.id.et_reason)
    EditText etReason;
    @Bind(R.id.rl_reason)
    RelativeLayout rlReason;
    @Bind(R.id.et_fengongsi)
    EditText et_fengongsi;

    private List<String> mListname;
    private List<Integer> mListid;
    String type1 = "";
    String type2 = "";
    String taocan;

    //条件选择器
    private OptionsPickerView optionsPickerView;
    private List<String> groupList;
    private String status;
    private List<List<String>> childList;

    private List<TcInfo.BodyBean.TC> tcList;

    private String fengongsiname;

    private int kehubaseid;
    private String state;
    private String clientName;
    private String phoneNum;
    private String companyName;
    private double acreage;
    private String measureAddress;
    private String fangyuan;
    private String fengongsiid;
    private int intfengongsiid;
    private OptionsPickerView cityPicker;
    int pos;


    @Override
    public int getLayout() {
        return R.layout.activity_msge_client_info;
    }

    @Override
    public void initData() {
        mListid = new ArrayList<>();
        mListname = new ArrayList<>();
        initIntent();
        initTitle();
        initTc();
        initClientInfoData();
        cityPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                intfengongsiid = mListid.get(options1);
                Log.e("fengongsiid", intfengongsiid + "");
                et_fengongsi.setText(mListname.get(options1));

            }
        }).build();
        cityPicker.setPicker(mListname);

    }

    private void initIntent() {
        etClientInfoPhoneNum.setFocusable(false);

        kehubaseid = getIntent().getIntExtra(Constants.ACTION_TO_MSGECLIENTINFO_KEHUBASE_ID, 10);
        state = getIntent().getStringExtra(Constants.ACTION_TO_MSGECLIENTINFO_STATE);
        pos = getIntent().getIntExtra(Constants.ACTION_TO_HOMEFRAGMENT_POS, 0);
        if (state.equals("2") || state.equals("1")) {

            etClientInfoName.setFocusable(false);
            etClientInfoPhoneNum.setFocusable(false);
            etClientInfoCompanyName.setFocusable(false);


            etClientInfoAcreage.setFocusable(false);
            etClientInfoMeasureAddress.setFocusable(false);
            ettype.setFocusable(false);
            et_remark.setFocusable(false);
            et_fengongsi.setFocusable(false);
            disableRadioGroup(rg_home);
            disableRadioGroup(rg_combo);
            btn_save.setVisibility(View.GONE);
            btn_sub.setVisibility(View.GONE);
        }

    }


    //设置RadioGroup下按钮不可点击
    private void disableMoreRadioGroup(RadioGroup testRadioGroup) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            LinearLayout lin = (LinearLayout) testRadioGroup.getChildAt(i);
            for (int j = 0; j < lin.getChildCount(); j++)
                lin.getChildAt(j).setEnabled(false);
        }
    }

    //设置RadioGroup下按钮不可点击
    private void disableRadioGroup(RadioGroup testRadioGroup) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            testRadioGroup.getChildAt(i).setEnabled(false);
        }
    }

    private void initTitle() {
        ivHeaderBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(TITLE);
    }


    private void initClientInfoData() {
        mPresenter.getOrdersDetail(kehubaseid);
    }

    @Override
    protected MsgeClientInfoPresenter onCreatePresenter() {
        return new MsgeClientInfoPresenter(this);
    }

    @Override
    public void responseTc(List<TcInfo.BodyBean.TC> dataList) {
        tcList.clear();
        tcList.addAll(dataList);
    }

    private void initTc() {

        groupList = new ArrayList<>();

        childList = new ArrayList<>();

        tcList = new ArrayList<>();

        mPresenter.getTc();

        rg_combo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_combo_check_tc1_xq:
                        Log.e("MSGE", "JIN1");
                        showTcType(tcList.get(0));
                        break;
                    case R.id.rb_combo_check_tc2_xq:
                        Log.e("MSGE", "JIN2");
                        showTcType(tcList.get(1));
                        break;
                    case R.id.rb_combo_check_tc3_xq:
                        Log.e("MSGE", "JIN3");
                        showTcType(tcList.get(2));
                        break;
                }
            }
        });
    }

    private void showTcType(GetClientDetailInfo.BodyBean tcInfo) {
        if (tcInfo.getCommission() == 0) {
            tv_taocancheck_xq.setText(tcInfo.getMeasureMoney() + "元信息费，无提成");
            //taocan = String.valueOf(tcList.get(0).getID());
        } else if (tcInfo.getMeasureMoney() == 0) {
            tv_taocancheck_xq.setText(tcInfo.getCommission() + "%提成，无信息费");
            //taocan = String.valueOf(tcList.get(0).getID());
        } else {
            tv_taocancheck_xq.setText(tcInfo.getMeasureMoney() + "元信息费+" + tcInfo.getCommission() + "%提成");
            //taocan = String.valueOf(tcList.get(0).getID());
        }
    }


    private void showTcType(TcInfo.BodyBean.TC tcInfo) {
        if (tcInfo.getCommission() == 0) {
            tv_taocancheck_xq.setText(tcInfo.getMeasureMoney() + "元信息费，无提成");
            taocan = String.valueOf(tcInfo.getID());
        } else if (tcInfo.getMeasureMoney() == 0) {
            tv_taocancheck_xq.setText(tcInfo.getCommission() + "%提成，无信息费");
            taocan = String.valueOf(tcInfo.getID());
        } else {
            tv_taocancheck_xq.setText(tcInfo.getMeasureMoney() + "元信息费+" + tcInfo.getCommission() + "%提成");
            taocan = String.valueOf(tcInfo.getID());
        }
        Log.e("MSGEtaocan", taocan);
    }


    @Override
    public void responseClientType(final List<TcInfo.BodyBean.ClientType> dataList) {
        for (TcInfo.BodyBean.ClientType typeInfo : dataList) {
            groupList.add(typeInfo.getMingCheng());
            List<String> child = new ArrayList<>();
            for (TcInfo.BodyBean.ClientType.ClientChildType childType : typeInfo.getZiji()) {
                child.add(childType.getMingCheng());
            }
            ;
            childList.add(child);
        }
        optionsPickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                ettype.setText(dataList.get(options1).getMingCheng() + " —  " + dataList.get(options1).getZiji().get(options2).getMingCheng());
                type1 = dataList.get(options1).getID() + "";
                type2 = dataList.get(options1).getZiji().get(options2).getID() + "";
            }
        }).build();
        optionsPickerView.setPicker(groupList, childList);
    }

    @Override
    public void responseTcError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseOrdersDetailData(GetClientDetailInfo.BodyBean data) {
        fengongsiid = data.getDiQu();
        clientName = data.getXingMing();
        phoneNum = data.getShouJiHaoYi();
        companyName = data.getGongSiMingCheng();
        acreage = data.getMianJi();
        measureAddress = data.getLiangFangDiZhi();

        etClientInfoName.setText(clientName);
        etClientInfoPhoneNum.setText(phoneNum);
        etClientInfoCompanyName.setText(companyName);
        etClientInfoAcreage.setText(acreage + "");
        etClientInfoMeasureAddress.setText(measureAddress);
        taocan = data.getPackage_type() + "";
        fangyuan = data.getFangYuan() + "";
        type1 = data.getLeiXingYi() + "";
        type2 = data.getLeiXingEr() + "";
        ettype.setText(data.getLeiXingYiName() + " —  " + data.getLeiXingErName());
        et_remark.setText(data.getBeiZhu());
        if (data.getPackage_type() == 28) {
            rb_tc1.setChecked(true);
        } else if (data.getPackage_type() == 29) {
            rb_tc2.setChecked(true);
        } else if (data.getPackage_type() == 30) {
            rb_tc3.setChecked(true);
        }
        showTcType(data);
        //yd 1 wd 2
        if (data.getFangYuan() == 1) {
            rb_home_yd.setChecked(true);
        } else if (data.getFangYuan() == 2) {
            rb_home_wd.setChecked(true);
        }

//        如果订单状态是打回状态显示打回原因
        if (Integer.parseInt(state) == 3) {
            rlReason.setVisibility(View.VISIBLE);
            etReason.setText(data.getDaHuiYuanYin());
        }
        mPresenter.getFenGongSi();

    }

    @Override
    public void responseOrdersDetailDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseClientTypeData(final MsgeClientTypeInfo.ClientType data) {
    }

    @Override
    public void responseClientTypeDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSubClientInfoData() {
        finish();
    }

    @Override
    public void responseSubClientInfoDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseSaveClientInfoData() {
        Intent intent = new Intent();
        intent.putExtra(Constants.clientname, etClientInfoName.getText().toString());
        intent.putExtra(Constants.clientstatus, status);
        setResult(Constants.ACTION_TO_HOMEFRAGMENT_RESULTCODE2, intent);
    }

    @Override
    public void responseSaveClientInfoDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseFenGongSi(List<FenGongSiInfo.BodyBean> bodyBean) {
        int fenid = Integer.parseInt(fengongsiid);
        Log.e("fengongsiname", "return");
        int size = bodyBean.size();
        for (int i = 0; i < size; i++) {
            mListname.add(bodyBean.get(i).getGongSiMingCheng());
            mListid.add(bodyBean.get(i).getFenGongSiID());
            Log.e("mlistid",bodyBean.get(i).getFenGongSiID()+"");
        }
        int listsize = mListid.size();
        for (int i = 0; i < listsize; i++) {
            if (mListid.get(i) == fenid) {
                fengongsiname = mListname.get(i);
                et_fengongsi.setText(fengongsiname);
                return;
            }
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

    @Override
    public void hideDialog2() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        dismissLoading();
                    }
                });
            }
        }, 5000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

        onclick();

    }

    private void onclick() {
        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home_status_wd_xq:
                        fangyuan = "2";
                        break;
                    case R.id.rb_home_status_yd_xq:
                        fangyuan = "1";
                        break;
                }
                Log.e("MSGEfangyuan", fangyuan);
            }
        });


        ettype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state.equals("2") || state.equals("1")) {

                } else {
                    optionsPickerView.show();
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!StringUtils.isMobileNO(etClientInfoPhoneNum.getText().toString())) {
                    showToast("请输入正确的手机号码");
                    return;
                }

                mPresenter.saveOrdersDetail(
                        kehubaseid,
                        etClientInfoName.getText().toString(),
                        etClientInfoPhoneNum.getText().toString(),
                        etClientInfoAcreage.getText().toString(),
                        type1,
                        type2,
                        etClientInfoCompanyName.getText().toString(),
                        etClientInfoMeasureAddress.getText().toString(),
                        App.cardNo,
                        fangyuan,
                        et_remark.getText().toString(),
                        taocan,
                        "17",
                        intfengongsiid);
                status = "17";
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!StringUtils.isMobileNO(etClientInfoPhoneNum.getText().toString())) {
                    showToast("请输入正确的手机号码");
                    return;
                }

                mPresenter.saveOrdersDetail(
                        kehubaseid,
                        etClientInfoName.getText().toString(),
                        etClientInfoPhoneNum.getText().toString(),
                        etClientInfoAcreage.getText().toString(),
                        type1,
                        type2,
                        etClientInfoCompanyName.getText().toString(),
                        etClientInfoMeasureAddress.getText().toString(),
                        App.cardNo,
                        fangyuan,
                        et_remark.getText().toString(),
                        taocan,
                        "0",
                        intfengongsiid);
                status = "0";
            }
        });
        et_fengongsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (state.equals("2") || state.equals("1")) {
//
//                } else {
//                    cityPicker.show();
//                }
            }
        });


    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }


}
