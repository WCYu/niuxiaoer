package com.rxjy.niuxiaoer.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.utils.StringUtils;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.TcInfo;
import com.rxjy.niuxiaoer.mvp.contract.AddContract;
import com.rxjy.niuxiaoer.mvp.presenter.AddPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddActivity extends BaseActivity<AddPresenter> implements AddContract.View {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_client_name)
    TextView tvClientName;
    @Bind(R.id.et_client_name)
    EditText etClientName;
    @Bind(R.id.tv_client_name_line)
    TextView tvClientNameLine;
    @Bind(R.id.tv_phone_hm)
    TextView tvPhoneHm;
    @Bind(R.id.et_phone_hm)
    EditText etPhoneHm;
    @Bind(R.id.tv_phone_hm_line)
    TextView tvPhoneHmLine;
    @Bind(R.id.tv_company_name)
    TextView tvCompanyName;
    @Bind(R.id.et_company_name)
    EditText etCompanyName;
    @Bind(R.id.tv_company_name_line)
    TextView tvCompanyNameLine;
    @Bind(R.id.tv_area_mj)
    TextView tvAreaMj;
    @Bind(R.id.et_area_mj)
    EditText etAreaMj;
    @Bind(R.id.tv_area_mj_line)
    TextView tvAreaMjLine;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.tv_address_line)
    TextView tvAddressLine;
    @Bind(R.id.tv_client_type)
    TextView tvClientType;
    @Bind(R.id.et_client_type)
    EditText tvClientType2;
    @Bind(R.id.tv_client_type_line)
    TextView tvClientTypeLine;
    @Bind(R.id.tv_home_status)
    TextView tvHomeStatus;
    @Bind(R.id.tv_combo_check)
    TextView tvComboCheck;
    @Bind(R.id.tv_remark)
    TextView tvRemark;
    @Bind(R.id.et_remark)
    EditText etRemark;
    @Bind(R.id.tv_remark_line)
    TextView tvRemarkLine;
    @Bind(R.id.tv_fengongsi_line)
    TextView tvFengongsiLine;
    @Bind(R.id.btn_savasubmit)
    Button btnLogin;
    @Bind(R.id.rb_home_status_yd)
    RadioButton rbHomeStatusYd;
    @Bind(R.id.rb_home_status_wd)
    RadioButton rbHomeStatusWd;
    @Bind(R.id.rg_home_status)
    RadioGroup rgHomeStatus;
    @Bind(R.id.tv_home_status_line)
    TextView tvHomeStatusLine;
    @Bind(R.id.rb_combo_check_tc1)
    RadioButton rbComboCheckTc1;
    @Bind(R.id.rb_combo_check_tc2)
    RadioButton rbComboCheckTc2;
    @Bind(R.id.rb_combo_check_tc3)
    RadioButton rbComboCheckTc3;
    @Bind(R.id.rg_combo_check)
    RadioGroup rgComboCheck;
    @Bind(R.id.tv_combo_check_line)
    TextView tvComboCheckLine;
    @Bind(R.id.tv_taocancheck)
    TextView tvtaocancheck;
    @Bind(R.id.btn_sava)
    Button btnsave;

    @Bind(R.id.et_fengongsi)
    EditText et_fengongsi;

    private List<String> mListname;
    private List<Integer> mListid;
    String fangyuan;
    String type1;
    String type2;
    String taocan;
    private int fengongsiid;
    //条件选择器
    private OptionsPickerView optionsPickerView;

    private List<String> groupList;

    private List<List<String>> childList;

    private List<TcInfo.BodyBean.TC> tcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        tvTitle.setText("新增");
        onclick();
    }

    public void onclick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etClientName.getText().toString().isEmpty()) {
                    showToast("请输入客户姓名");
                    return;
                }
                if (etPhoneHm.getText().toString().isEmpty()) {
                    showToast("请输入手机号码");
                    return;
                }
                if (et_fengongsi.getText().toString().equals("请选择")) {
                    showToast("请选择分公司");
                    return;
                }

                if (tvtaocancheck.getText().toString().isEmpty()) {
                    showToast("请选择套餐");
                    return;
                }
                if (!StringUtils.isMobileNO(etPhoneHm.getText().toString())) {
                    showToast("请输入正确的手机号码");
                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                builder.setTitle("提示");
                builder.setMessage("分公司一经确认不可修改");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("ADDTYPE", type1 + "***" + type2);
                        mPresenter.addandsubmit(etClientName.getText().toString(),
                                etPhoneHm.getText().toString(),
                                etAreaMj.getText().toString(),
                                //类型1
                                type1,
                                //类型2
                                type2,
                                etCompanyName.getText().toString(),
                                etAddress.getText().toString(),
                                App.cardNo,
                                fangyuan,
                                etRemark.getText().toString(),
                                taocan,
                                "17",
                                fengongsiid

                        );
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();





            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etClientName.getText().toString().isEmpty()) {
                    showToast("请输入客户姓名");
                    return;
                }
                if (etPhoneHm.getText().toString().isEmpty()) {
                    showToast("请输入手机号码");
                    return;
                }
                if(etPhoneHm.getText().toString().length()!=11){
                    showToast("请输入正确的手机号码");
                    return;
                }
                if (et_fengongsi.getText().toString().equals("请选择")) {
                    showToast("请选择分公司");
                    return;
                }
                if (tvtaocancheck.getText().toString().isEmpty()) {
                    showToast("请选择套餐");
                    return;
                }
                if (!StringUtils.isMobileNO(etPhoneHm.getText().toString())) {
                    showToast("请输入正确的手机号码");
                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                builder.setTitle("提示");
                builder.setMessage("分公司一经确认不可修改");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.addandsubmit(etClientName.getText().toString(),
                                etPhoneHm.getText().toString(),
                                etAreaMj.getText().toString(),
                                //类型1
                                type1,
                                //类型2
                                type2,
                                etCompanyName.getText().toString(),
                                etAddress.getText().toString(),
                                App.cardNo,
                                fangyuan,
                                etRemark.getText().toString(),
                                taocan,
                                "0",
                                fengongsiid
                        );
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();




            }
        });


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(AddActivity.this,MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        rgHomeStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home_status_wd:
                        fangyuan = "2";
                    case R.id.rb_home_status_yd:
                        fangyuan = "1";
                }
            }
        });
        tvClientType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsPickerView.show();
            }
        });

        et_fengongsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPicker.show();
            }
        });


    }

    @Override
    public void responseTc(List<TcInfo.BodyBean.TC> dataList) {
        tcList.clear();
        tcList.addAll(dataList);
        showTcType(tcList.get(0));
        rbComboCheckTc1.setChecked(true);
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
                tvClientType2.setText(dataList.get(options1).getMingCheng() + " —  " + dataList.get(options1).getZiji().get(options2).getMingCheng());
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
    public void responseClientData() {

    }

    @Override
    public void responseClientDataError(String msg) {
        showToast(msg);
    }

    @Override
    public void responseFenGongSi(List<FenGongSiInfo.BodyBean> bodyBean) {
        int size = bodyBean.size();
        for (int i = 0; i < size; i++) {
            mListname.add(bodyBean.get(i).getGongSiMingCheng());
            mListid.add(bodyBean.get(i).getFenGongSiID());
        }
    }


    private void initTc() {

        groupList = new ArrayList<>();

        childList = new ArrayList<>();

        tcList = new ArrayList<>();

        mPresenter.getTc();

        rgComboCheck.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_combo_check_tc1:
                        showTcType(tcList.get(0));
                        break;
                    case R.id.rb_combo_check_tc2:
                        showTcType(tcList.get(1));
                        break;
                    case R.id.rb_combo_check_tc3:
                        showTcType(tcList.get(2));
                        break;
                }
            }
        });
    }

    private void showTcType(TcInfo.BodyBean.TC tcInfo) {
        if (tcInfo.getCommission() == 0) {
            tvtaocancheck.setText(tcInfo.getMeasureMoney() + "元信息费，无提成");
            taocan = String.valueOf(tcInfo.getID());
        } else if (tcInfo.getMeasureMoney() == 0) {
            tvtaocancheck.setText(tcInfo.getCommission() + "%提成，无信息费");
            taocan = String.valueOf(tcInfo.getID());
        } else {
            tvtaocancheck.setText(tcInfo.getMeasureMoney() + "元信息费+" + tcInfo.getCommission() + "%提成");
            taocan = String.valueOf(tcInfo.getID());
        }
    }


    @Override
    public int getLayout() {
        return R.layout.activity_add;
    }

    @Override
    public void initData() {
        //etPhoneHm.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mListname = new ArrayList<>();
        mListid = new ArrayList<>();
        initLine();
        initTc();
        initFengongsi();

    }

    private OptionsPickerView cityPicker;

    private void initFengongsi() {
        mPresenter.getFenGongSi();

        cityPicker = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                fengongsiid = mListid.get(options1);
                Log.e("fengongsiid", fengongsiid + "");
                et_fengongsi.setText(mListname.get(options1));

            }
        }).build();
        cityPicker.setPicker(mListname);


    }

    @Override
    protected AddPresenter onCreatePresenter() {
        return new AddPresenter(this);
    }

    private void initLine() {

        EditText[] etArray = {etClientName, etPhoneHm, etCompanyName, etAreaMj, etAddress, etRemark, et_fengongsi};
        TextView[] tvArray = {tvClientNameLine, tvPhoneHmLine, tvCompanyNameLine, tvAreaMjLine, tvAddressLine, tvRemarkLine, tvFengongsiLine};

        lineSelector(etArray, tvArray);
    }

    private ProgressDialog dialog;

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
//    @OnClick(R.id.btn_savasubmit)
//    public void BtnAddAndSubmit(View view){
//        Log.e("AddPresenter","jinlaileme");
//        mPresenter.addandsubmit("孙豪",
//                "15588665456",
//                23,
//                1,
//                1,
//                "瑞祥",
//
//               "永定路",
//                "01010932",
//                1,
//                "备注",
//                1,
//                 17
//               );
//    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void showtoast() {
        showToast("手机号重复");
    }

    @Override
    public void getClientMsgOne(GetClientMsgList.Body body) {
        //Log.e("GetClientMsgListPresent", body.getGongSiMingCheng());
        Intent intent = new Intent();
        intent.putExtra(Constants.ACTION_TO_HOMEFRAGMENT_BODYINFO, body);
        setResult(Constants.ACTION_TO_HOMEFRAGMENT_RESULTCODE, intent);
        finish();
    }
}
