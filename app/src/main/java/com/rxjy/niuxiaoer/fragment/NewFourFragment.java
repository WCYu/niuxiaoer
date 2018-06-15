package com.rxjy.niuxiaoer.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.PartAddActivity;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.entity.NerFourInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewFourContract;
import com.rxjy.niuxiaoer.mvp.presenter.NewFourPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFourFragment extends BaseFragment<NewFourPresenter> implements NewFourContract.View {

    @Bind(R.id.tv_partadd_xuqiu)
    TextView tvPartaddXuqiu;
    @Bind(R.id.et_partadd_yusuan)
    EditText etPartaddYusuan;
    @Bind(R.id.et_partadd_gongqi)
    EditText etPartaddGongqi;
    @Bind(R.id.rb_partadd_zhaobiao_shi)
    RadioButton rbPartaddZhaobiaoShi;
    @Bind(R.id.rb_partadd_zhaobiao_fou)
    RadioButton rbPartaddZhaobiaoFou;
    @Bind(R.id.rg_partadd_zhaobiao)
    RadioGroup rgPartaddZhaobiao;
    @Bind(R.id.tv_partadd_shijian)
    TextView tvPartaddShijian;
    @Bind(R.id.et_partadd_dizhi)
    EditText etPartaddDizhi;
    @Bind(R.id.tv_partadd_liangfangshijian)
    TextView tvPartaddLiangfangshijian;
    @Bind(R.id.btn_baocun)
    Button btnBaocun;
    private int zhuangxiuxuqiubs = 0;
    private int zhuangxiuyusuanbs = 0;
    private int gongqibs = 0;
    private int zhaobiaobs = 0;
    private int liangfangdizhibs = 0;
    private int liangfangshijianbs = 0;
    private int zhuangxiushijianbs = 0;
    int ischeck=0;//是否选择了，默认没有
    private OptionsPickerView ZhuangxiuxuqiuPicker;

    private String zhuangxiushijian;
    private String liangfangshijian;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_four;
    }

    @Override
    protected void FragmentInitData() {

        mPresenter.getxunjia(App.danhao);
        onclick();

    }


    private void onclick() {
        etPartaddYusuan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                if (s.length() == 0) {
                    if (zhuangxiuyusuanbs == 1) {
                        activity.price = activity.price - App.bodyBean.get(0).getYuSuan();
                        zhuangxiuyusuanbs = 0;

                        activity.price(activity.price);
                    }
                } else if (s.length() != 0) {
                    if (zhuangxiuyusuanbs == 0) {
                        activity.price = activity.price + App.bodyBean.get(0).getYuSuan();
                        zhuangxiuyusuanbs = 1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        etPartaddGongqi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                if (s.length() == 0) {
                    if (gongqibs == 1) {
                        activity.price = activity.price - App.bodyBean.get(0).getGongQi();
                        gongqibs = 0;

                        activity.price(activity.price);
                    }
                } else if (s.length() != 0) {
                    if (gongqibs == 0) {
                        activity.price = activity.price + App.bodyBean.get(0).getGongQi();
                        gongqibs = 1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        etPartaddDizhi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                if (s.length() == 0) {
                    if (liangfangdizhibs == 1) {
                        activity.price = activity.price - App.bodyBean.get(0).getLiangFangDiZhi();
                        liangfangdizhibs = 0;
                        activity.price(activity.price);
                    }
                } else if (s.length() != 0) {
                    if (liangfangdizhibs == 0) {
                        activity.price = activity.price + App.bodyBean.get(0).getLiangFangDiZhi();
                        liangfangdizhibs = 1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        tvPartaddXuqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard(tvPartaddXuqiu);

                ZhuangxiuxuqiuPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (XuqiuTypeName[options1].equals("请选择")) {
                            if (zhuangxiuxuqiubs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getXuQiu();
                                zhuangxiuxuqiubs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddXuqiu.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (zhuangxiuxuqiubs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getXuQiu();
                                zhuangxiuxuqiubs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddXuqiu.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddXuqiu.setText(XuqiuTypeName[options1]);

                    }
                }).build();

                List Xuqiulist = new ArrayList<>();
                for (int i = 0; i < XuqiuTypeName.length; i++) {
                    Xuqiulist.add(XuqiuTypeName[i]);
                }
                ZhuangxiuxuqiuPicker.setPicker(Xuqiulist);
                ZhuangxiuxuqiuPicker.show();
            }
        });


        tvPartaddShijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddShijian);
                DatePicker endPicker = new DatePicker(getActivity());
                endPicker.setRange(2017, 2100);//年份范围
                SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日");
                Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
                String    str    =    formatter.format(curDate);

                endPicker.setSelectedItem(Integer.parseInt(str.substring(0,4)),Integer.parseInt(str.substring(5,7)),Integer.parseInt(str.substring(8,10)));
                endPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        zhuangxiushijian = year + "-" + month + "-" + day;
                        if (zhuangxiushijianbs == 0) {
                            activity.price = activity.price + App.bodyBean.get(0).getZhuangXiuShiJian();
                            zhuangxiushijianbs = 1;

                            activity.price(activity.price);
                        }
                        tvPartaddShijian.setText(zhuangxiushijian);
                        tvPartaddShijian.setTextColor(Color.parseColor("#595757"));
                    }
                });
                endPicker.show();
            }
        });

        tvPartaddLiangfangshijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard(tvPartaddLiangfangshijian);
                DatePicker endPicker = new DatePicker(getActivity());
                endPicker.setRange(2017, 2100);//年份范围
                SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日");
                Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
                String    str    =    formatter.format(curDate);

                endPicker.setSelectedItem(Integer.parseInt(str.substring(0,4)),Integer.parseInt(str.substring(5,7)),Integer.parseInt(str.substring(8,10)));

                endPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        liangfangshijian = year + "-" + month + "-" + day;
                        if (liangfangshijianbs == 0) {
                            activity.price = activity.price + App.bodyBean.get(0).getLiangFangShiJian();
                            liangfangshijianbs = 1;

                            activity.price(activity.price);
                        }
                        tvPartaddLiangfangshijian.setText(liangfangshijian);
                        tvPartaddLiangfangshijian.setTextColor(Color.parseColor("#595757"));
                    }
                });
                endPicker.show();
            }
        });

        rgPartaddZhaobiao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                switch (checkedId) {
                    case R.id.rb_partadd_zhaobiao_shi:
                        zhaobiaoId = 1;
                        Log.e("11111111111111111111111","12222");
                        if(ischeck==0){//如果没有加过 +100
                            Log.e("钱。。。。shi",activity.price+"");
                            ischeck=1;
                            activity.price = activity.price + App.bodyBean.get(0).getZhaoBiao();
                            zhaobiaobs = 1;
                            Log.e("钱。。。。shi+",activity.price+"");
                            activity.price(activity.price);
                        }


//                        if (zhaobiaobs == 0) {
//                            activity.price = activity.price + App.bodyBean.get(0).getZhaoBiao();
//                            zhaobiaobs = 1;
//
//                            activity.price(activity.price);
//                        }

                        break;
                    case R.id.rb_partadd_zhaobiao_fou:
                        Log.e("11111111111111111111111","7777777777");
                        zhaobiaoId = 2;
                        if(ischeck==0){//如果没有加过 +100
                            ischeck=1;
                            Log.e("钱。。。。fou",activity.price+"");
                            activity.price = activity.price + App.bodyBean.get(0).getZhaoBiao();
                            zhaobiaobs = 0;
                            Log.e("钱。。。。fou+",activity.price+"");
                            activity.price(activity.price);
                        }
//                        if (zhaobiaobs == 1) {
//                            activity.price = activity.price - App.bodyBean.get(0).getZhaoBiao();
//                            zhaobiaobs = 0;
//
//                            activity.price(activity.price);
//                        }

                        break;

                }
            }
        });


        btnBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int xuqiusize = XuqiuTypeName.length;
                for (int i = 0; i < xuqiusize; i++) {
                    if (XuqiuTypeName[i].equals(tvPartaddXuqiu.getText().toString())) {
                        zhuangxiuxuqiuId = XuqiuTypeId[i];
                    }
                }

                double yusuan = 0;
                if (!etPartaddYusuan.getText().toString().trim().isEmpty()) {
                    yusuan = Double.parseDouble(etPartaddYusuan.getText().toString());
                }
                PartAddActivity activity = (PartAddActivity) getActivity();

//                if (tvPartaddXuqiu.getText().toString().equals("请选择") && etPartaddYusuan.getText().toString().equals("")
//                        && etPartaddGongqi.getText().toString().equals("") && !rbPartaddZhaobiaoShi.isChecked() && !rbPartaddZhaobiaoFou.isChecked()
//                        && tvPartaddShijian.getText().toString().equals("请选择") && etPartaddDizhi.getText().toString().equals("") && tvPartaddLiangfangshijian.getText().toString().equals("请选择")) {
//                    showToast("请最少选择一项！");
//                } else {
                    mPresenter.upxunjia(App.danhao,
                            etPartaddDizhi.getText().toString(),
                            zhuangxiuxuqiuId,
                            tvPartaddLiangfangshijian.getText().toString(),
                            etPartaddGongqi.getText().toString(),
                            yusuan,
                            activity.price,
                            zhaobiaoId,
                            tvPartaddShijian.getText().toString()

                    );
//                }
            }
        });


    }

    /**
     * 关闭软键盘
     */
    public void closeKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected NewFourPresenter onCreatePresenter() {
        return new NewFourPresenter(this);
    }


    private int zhuangxiuxuqiuId;
    private int zhaobiaoId;

    int[] XuqiuTypeId = {0, 1, 2, 3, 4, 5};
    String[] XuqiuTypeName = {"请选择", "基础装修", "二次改造", "精装修", "局部改造", "无法确定"};


    @Override
    public void responseGetData(NerFourInfo info) {

        NerFourInfo.BodyBean bodyBean = info.getBody().get(0);
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.price = bodyBean.getPingGuPrice();

        if (bodyBean.getZhuangXiuYuSuan() != 0.00) {
            zhuangxiuyusuanbs = 1;
            etPartaddYusuan.setText(bodyBean.getZhuangXiuYuSuan() + "");
        }
        if (!bodyBean.getGongQi().trim().isEmpty()) {
            gongqibs = 1;
            etPartaddGongqi.setText(bodyBean.getGongQi() + "");
        }
        if (!bodyBean.getLiangFangDiZhi().trim().isEmpty()) {
            liangfangdizhibs = 1;
            etPartaddDizhi.setText(bodyBean.getLiangFangDiZhi() + "");
        }
        if (!bodyBean.getYuJiZhuangXiuShiJian().trim().isEmpty()) {
            zhuangxiushijianbs = 1;
            tvPartaddShijian.setTextColor(Color.parseColor("#595757"));
            tvPartaddShijian.setText(bodyBean.getYuJiZhuangXiuShiJian() + "");
        }
        if (!bodyBean.getYuJiLiangFang().trim().isEmpty()) {
            liangfangshijianbs = 1;
            tvPartaddLiangfangshijian.setTextColor(Color.parseColor("#595757"));
            tvPartaddLiangfangshijian.setText(bodyBean.getYuJiLiangFang() + "");
        }


        if (bodyBean.getZhaoBiao() == 1) {
            rbPartaddZhaobiaoShi.setChecked(true);
            zhaobiaobs = 1;
        } else if (bodyBean.getZhaoBiao() == 2) {
            rbPartaddZhaobiaoFou.setChecked(true);
        }

        zhuangxiuxuqiuId = bodyBean.getZhuangXiuXuQiu();
        zhaobiaoId = bodyBean.getZhaoBiao();


        //需求
        int xuqiusize = XuqiuTypeName.length;
        for (int i = 0; i < xuqiusize; i++) {
            if (bodyBean.getZhuangXiuXuQiu() == XuqiuTypeId[i]) {
                if (XuqiuTypeName[i].equals("请选择")) {
                    tvPartaddXuqiu.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    zhuangxiuxuqiubs = 1;
                    tvPartaddXuqiu.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddXuqiu.setText(XuqiuTypeName[i]);

            }
        }

        activity.price(bodyBean.getPingGuPrice());
    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void responseUpData(UpPartAddInfo info) {
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.jump(4);

    }

    @Override
    public void responseUpDataError(String msg) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
