package com.rxjy.niuxiaoer.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.rxjy.niuxiaoer.entity.NewThreeInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewThreeContract;
import com.rxjy.niuxiaoer.mvp.presenter.NewThreePresenter;

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
public class NewThreeFragment extends BaseFragment<NewThreePresenter> implements NewThreeContract.View {

    @Bind(R.id.tv_partadd_fangwuzhuangkuang)
    TextView tvPartaddFangwuzhuangkuang;
    @Bind(R.id.rb_partadd_dingfang_yiding)
    RadioButton rbPartaddDingfangYiding;
    @Bind(R.id.rb_partadd_dingfang_weiding)
    RadioButton rbPartaddDingfangWeiding;
    @Bind(R.id.rg_partadd_dingfang)
    RadioGroup rgPartaddDingfang;
    @Bind(R.id.et_partadd_mianji)
    EditText etPartaddMianji;
    @Bind(R.id.tv_partadd_chengjiaoleixing)
    TextView tvPartaddChengjiaoleixing;
    @Bind(R.id.tv_partadd_mianzuqi)
    TextView tvPartaddMianzuqi;
    @Bind(R.id.tv_partadd_jiaofangshijian)
    TextView tvPartaddJiaofangshijian;
    @Bind(R.id.btn_baocun)
    Button btnBaocun;

    int[] fangyuanTypeId = {1, 2};
    String[] fangyuanTypeName = {"已定", "未定"};

    int[] chengjiaoleixingTypeId = {0, 1, 2, 3};
    String[] chengjiaoleixingTypeName = {"请选择", "租", "买", "自建"};

    int[] MianzuqiTypeId = {0, 1, 2, 3};
    String[] MianzuqiTypeName = {"请选择", "一个月", "1~2个月", "2个月以内"};

    int[] FangwuzhuangkuangTypeId = {0, 1, 2, 3, 5, 6};
    String[] FangwuzhuangkuangTypeName = {"请选择", "毛坯房", "清水房", "精装房", "翻新", "旧房改造"};

    private int fangwuzhuangkuangbs = 0;
    private int dingfangbs = 0;
    private int mianjibs = 0;
    private int chengjiaoleixingbs = 0;
    private int mianzuqibs = 0;
    private int jiaofangshijianbs = 0;

    int ischeck=0;
    private String jiaofangshijian;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_three;
    }

    @Override
    protected void FragmentInitData() {
        mPresenter.getxunjia(App.danhao);
        onclick();
    }

    private OptionsPickerView FangwuzhuangkuangPicker;
    private OptionsPickerView ChengjiaoleixingPicker;
    private OptionsPickerView MianzuqiPicker;

    private void onclick() {
        etPartaddMianji.addTextChangedListener(new TextWatcher() {
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
                    if (mianjibs == 1) {
                        activity.price = activity.price - App.bodyBean.get(0).getMianJi();
                        mianjibs = 0;

                        activity.price(activity.price);
                    }
                } else if (s.length() != 0) {
                    if (mianjibs == 0) {
                        activity.price = activity.price + App.bodyBean.get(0).getMianJi();
                        mianjibs = 1;

                        activity.price(activity.price);
                    }
                }
            }
        });

        tvPartaddFangwuzhuangkuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard(tvPartaddFangwuzhuangkuang);

                FangwuzhuangkuangPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (FangwuzhuangkuangTypeName[options1].equals("请选择")) {
                            if (fangwuzhuangkuangbs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getFangWu();
                                fangwuzhuangkuangbs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddFangwuzhuangkuang.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (fangwuzhuangkuangbs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getFangWu();
                                fangwuzhuangkuangbs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddFangwuzhuangkuang.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddFangwuzhuangkuang.setText(FangwuzhuangkuangTypeName[options1]);

                    }
                }).build();

                List fangwuzhuangkuanglist = new ArrayList<>();
                for (int i = 0; i < FangwuzhuangkuangTypeName.length; i++) {
                    fangwuzhuangkuanglist.add(FangwuzhuangkuangTypeName[i]);
                }
                FangwuzhuangkuangPicker.setPicker(fangwuzhuangkuanglist);
                FangwuzhuangkuangPicker.show();
            }
        });

        tvPartaddChengjiaoleixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard(tvPartaddChengjiaoleixing);

                ChengjiaoleixingPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (chengjiaoleixingTypeName[options1].equals("请选择")) {
                            if (chengjiaoleixingbs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getChengJiaoLeiXing();
                                chengjiaoleixingbs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddChengjiaoleixing.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (chengjiaoleixingbs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getChengJiaoLeiXing();
                                chengjiaoleixingbs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddChengjiaoleixing.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddChengjiaoleixing.setText(chengjiaoleixingTypeName[options1]);

                    }
                }).build();

                List chengjiaoleixinglist = new ArrayList<>();
                for (int i = 0; i < chengjiaoleixingTypeName.length; i++) {
                    chengjiaoleixinglist.add(chengjiaoleixingTypeName[i]);
                }
                ChengjiaoleixingPicker.setPicker(chengjiaoleixinglist);
                ChengjiaoleixingPicker.show();
            }
        });

        tvPartaddMianzuqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddMianzuqi);
                MianzuqiPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (MianzuqiTypeName[options1].equals("请选择")) {
                            if (mianzuqibs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getMianZuQi();
                                mianzuqibs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddMianzuqi.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (mianzuqibs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getMianZuQi();
                                mianzuqibs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddMianzuqi.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddMianzuqi.setText(MianzuqiTypeName[options1]);

                    }
                }).build();

                List mianzuqilist = new ArrayList<>();
                for (int i = 0; i < MianzuqiTypeName.length; i++) {
                    mianzuqilist.add(MianzuqiTypeName[i]);
                }
                MianzuqiPicker.setPicker(mianzuqilist);
                MianzuqiPicker.show();
            }
        });

        tvPartaddJiaofangshijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard(tvPartaddJiaofangshijian);


                DatePicker endPicker = new DatePicker(getActivity());
                endPicker.setRange(2017, 2100);//年份范围

                SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日");
                Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
                String    str    =    formatter.format(curDate);

                endPicker.setSelectedItem(Integer.parseInt(str.substring(0,4)),Integer.parseInt(str.substring(5,7)),Integer.parseInt(str.substring(8,10)));
                endPicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {

                    @Override
                    public void onDatePicked(String year, String month, String day) {

                        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日");
                        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
                        String    str    =    formatter.format(curDate);


                        PartAddActivity activity = (PartAddActivity) getActivity();
                        jiaofangshijian = year + "-" + month + "-" + day;
                        if (jiaofangshijianbs == 0) {
                            activity.price = activity.price + App.bodyBean.get(0).getJiaoFangShiJian();
                            jiaofangshijianbs = 1;

                            activity.price(activity.price);
                        }
                        tvPartaddJiaofangshijian.setTextColor(Color.parseColor("#595757"));
                        tvPartaddJiaofangshijian.setText(jiaofangshijian);
                    }


                });
                endPicker.show();

            }
        });

        rgPartaddDingfang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                switch (checkedId) {
                    case R.id.rb_partadd_dingfang_yiding:
                        FangyuanId = 1;

                        if(ischeck==0){
                            ischeck=1;
                            activity.price = activity.price + App.bodyBean.get(0).getDingFang();
                            dingfangbs = 1;

                            activity.price(activity.price);
                        }
//                        if (dingfangbs == 0) {
//                            activity.price = activity.price + App.bodyBean.get(0).getDingFang();
//                            dingfangbs = 1;
//
//                            activity.price(activity.price);
//                        }

                        break;
                    case R.id.rb_partadd_dingfang_weiding:
                        FangyuanId = 2;

                        if(ischeck==0){
                            ischeck=1;
                            activity.price = activity.price + App.bodyBean.get(0).getDingFang();
                            dingfangbs = 0;
                            activity.price(activity.price);
                        }

//                        if (dingfangbs == 1) {
//                            activity.price = activity.price - App.bodyBean.get(0).getDingFang();
//                            dingfangbs = 0;
//                            activity.price(activity.price);
//                        }

                        break;

                }
            }
        });


        btnBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int fwzksize = FangwuzhuangkuangTypeName.length;
                for (int i = 0; i < fwzksize; i++) {
                    if (FangwuzhuangkuangTypeName[i].equals(tvPartaddFangwuzhuangkuang.getText().toString())) {
                        fangwuzhuangkuangId = FangwuzhuangkuangTypeId[i];
                    }
                }

                int cjlxsize = chengjiaoleixingTypeName.length;
                for (int i = 0; i < cjlxsize; i++) {
                    if (chengjiaoleixingTypeName[i].equals(tvPartaddChengjiaoleixing.getText().toString())) {
                        chengjiaoleixingId = chengjiaoleixingTypeId[i];
                    }
                }

                int mzqsize = MianzuqiTypeName.length;
                for (int i = 0; i < mzqsize; i++) {
                    if (MianzuqiTypeName[i].equals(tvPartaddMianzuqi.getText().toString())) {
                        mianzuqiId = MianzuqiTypeId[i];
                    }
                }
                double mianji = 0;
                if (!etPartaddMianji.getText().toString().trim().isEmpty()) {
                    mianji = Double.parseDouble(etPartaddMianji.getText().toString());
                }
                PartAddActivity activity = (PartAddActivity) getActivity();



//                if (tvPartaddFangwuzhuangkuang.getText().toString().equals("请选择") && !rbPartaddDingfangYiding.isChecked()&& !rbPartaddDingfangWeiding.isChecked()
//                        && etPartaddMianji.getText().toString().equals("") && tvPartaddChengjiaoleixing.getText().toString().equals("请选择")
//                        && tvPartaddMianzuqi.getText().toString().equals("请选择") && tvPartaddJiaofangshijian.getText().toString().equals("请选择")) {
//                    showToast("请最少选择一项！");
//                } else {

                    mPresenter.upxunjia(App.danhao,
                            mianji,
                            chengjiaoleixingId,
                            mianzuqiId,
                            tvPartaddJiaofangshijian.getText().toString(),
                            fangwuzhuangkuangId,
                            activity.price,
                            FangyuanId

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
    protected NewThreePresenter onCreatePresenter() {
        return new NewThreePresenter(this);
    }
//    private double price;

    private int FangyuanId;
    private int chengjiaoleixingId;
    private int mianzuqiId;
    private int fangwuzhuangkuangId;

    @Override
    public void responseGetData(NewThreeInfo info) {
        NewThreeInfo.BodyBean bodyBean = info.getBody().get(0);
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.price = bodyBean.getPingGuPrice();

        if (bodyBean.getMianJi() != 0.00) {
            mianjibs = 1;
            etPartaddMianji.setText(bodyBean.getMianJi()+"");
        }
        if (!bodyBean.getJiaoFangShiJian().trim().isEmpty()) {
            jiaofangshijianbs = 1;
            tvPartaddJiaofangshijian.setTextColor(Color.parseColor("#595757"));
            tvPartaddJiaofangshijian.setText(bodyBean.getJiaoFangShiJian() + "");
        }

        if (bodyBean.getFangYuan() == 1) {
            rbPartaddDingfangYiding.setChecked(true);
            dingfangbs = 1;
        } else if (bodyBean.getFangYuan() == 2) {
            rbPartaddDingfangWeiding.setChecked(true);
        }

        fangwuzhuangkuangId = bodyBean.getYuJiZhuangXiu();
        FangyuanId = bodyBean.getFangYuan();
        chengjiaoleixingId = bodyBean.getChengJiaoLeiXing();
        mianzuqiId = bodyBean.getMianZuQi();

        //房屋状况
        int fangwuzhuangkuangsize = FangwuzhuangkuangTypeId.length;
        for (int i = 0; i < fangwuzhuangkuangsize; i++) {
            if (bodyBean.getYuJiZhuangXiu() == FangwuzhuangkuangTypeId[i]) {
                if (FangwuzhuangkuangTypeName[i].equals("请选择")) {
                    tvPartaddFangwuzhuangkuang.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    fangwuzhuangkuangbs = 1;
                    tvPartaddFangwuzhuangkuang.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddFangwuzhuangkuang.setText(FangwuzhuangkuangTypeName[i]);

            }
        }


        //成交类型
        int chengjiaoleixingsize = chengjiaoleixingTypeId.length;
        for (int i = 0; i < chengjiaoleixingsize; i++) {
            if (bodyBean.getChengJiaoLeiXing() == chengjiaoleixingTypeId[i]) {
                if (chengjiaoleixingTypeName[i].equals("请选择")) {
                    tvPartaddChengjiaoleixing.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    chengjiaoleixingbs = 1;
                    tvPartaddChengjiaoleixing.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddChengjiaoleixing.setText(chengjiaoleixingTypeName[i]);

            }
        }


        //免租期
        int mianzuqisize = MianzuqiTypeId.length;
        for (int i = 0; i < mianzuqisize; i++) {
            if (bodyBean.getMianZuQi() == MianzuqiTypeId[i]) {
                if (MianzuqiTypeName[i].equals("请选择")) {
                    tvPartaddMianzuqi.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    mianzuqibs = 1;
                    tvPartaddMianzuqi.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddMianzuqi.setText(MianzuqiTypeName[i]);

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

        activity.jump(3);

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
