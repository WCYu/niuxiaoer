package com.rxjy.niuxiaoer.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.PartAddActivity;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.entity.NewTwoInfo;
import com.rxjy.niuxiaoer.entity.NewTwoXiaLaInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewTwoContract;
import com.rxjy.niuxiaoer.mvp.presenter.NewTwoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTwoFragment extends BaseFragment<NewTwoPresenter> implements NewTwoContract.View {


    @Bind(R.id.tv_partadd_shenfen)
    TextView tvPartaddShenfen;
    @Bind(R.id.tv_partadd_nianling)
    TextView tvPartaddNianling;
//    @Bind(R.id.et_partadd_chengwei)
//    EditText etPartaddChengwei;
    @Bind(R.id.et_partadd_weixin)
    EditText etPartaddWeixin;
    @Bind(R.id.tv_partadd_zhuzhong)
    TextView tvPartaddzhuzhong;
    @Bind(R.id.btn_baocun)
    Button btnBaocun;

    private int shenfenbs = 0;
    private int nianlingbs = 0;
    private int zhuzhongbs = 0;

    private int chengweibs = 0;
    private int weixinbs = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_two;
    }

    @Override
    protected void FragmentInitData() {

        mPresenter.getxunjiaXialakuang();
        onClick();

    }

    private OptionsPickerView NianlingPicker;
    private OptionsPickerView ShenfenPicker;
    private OptionsPickerView ZhuzhongPicker;

    private void onClick() {

//        etPartaddChengwei.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                PartAddActivity activity = (PartAddActivity) getActivity();
//                if (s.length() == 0) {
//                    if (chengweibs == 1) {
//                        activity.price = activity.price - App.bodyBean.get(0).getXingMing();
//                        chengweibs = 0;
//
//                        activity.price(activity.price);
//                    }
//                } else if (s.length() != 0) {
//                    if (chengweibs == 0) {
//                        activity.price = activity.price + App.bodyBean.get(0).getXingMing();
//                        chengweibs = 1;
//                        activity.price(activity.price);
//                    }
//                }
//            }
//        });

        etPartaddWeixin.addTextChangedListener(new TextWatcher() {
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
                    if (weixinbs == 1) {
                        activity.price = activity.price - App.bodyBean.get(0).getWeiXin();
                        weixinbs = 0;

                        activity.price(activity.price);
                    }
                } else if (s.length() != 0) {
                    if (weixinbs == 0) {
                        activity.price = activity.price + App.bodyBean.get(0).getWeiXin();
                        weixinbs = 1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        tvPartaddNianling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddNianling);
                NianlingPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (nltypeName.get(options1).equals("请选择")) {
                            if (nianlingbs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getNianLing();
                                nianlingbs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddNianling.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (nianlingbs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getNianLing();
                                nianlingbs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddNianling.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddNianling.setText(nltypeName.get(options1));

                    }
                }).build();
                NianlingPicker.setPicker(nltypeName);
                NianlingPicker.show();
            }
        });

        tvPartaddShenfen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddShenfen);
                ShenfenPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (sftypeName.get(options1).equals("请选择")) {
                            if (shenfenbs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getShenFen();
                                shenfenbs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddShenfen.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (shenfenbs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getShenFen();
                                shenfenbs = 1;
                                activity.price(activity.price);
                            }
                            tvPartaddShenfen.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddShenfen.setText(sftypeName.get(options1));

                    }
                }).build();
                ShenfenPicker.setPicker(sftypeName);
                ShenfenPicker.show();
            }
        });

        tvPartaddzhuzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddzhuzhong);
                ZhuzhongPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (zztypeName.get(options1).equals("请选择")) {
                            if (zhuzhongbs == 1) {
                                activity.price = activity.price - App.bodyBean.get(0).getZhuZhong();
                                zhuzhongbs = 0;

                                activity.price(activity.price);
                            }
                            tvPartaddzhuzhong.setTextColor(Color.parseColor("#c9caca"));
                        } else {
                            if (zhuzhongbs == 0) {
                                activity.price = activity.price + App.bodyBean.get(0).getShenFen();
                                zhuzhongbs = 1;

                                activity.price(activity.price);
                            }
                            tvPartaddzhuzhong.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddzhuzhong.setText(zztypeName.get(options1));

                    }
                }).build();
                ZhuzhongPicker.setPicker(zztypeName);
                ZhuzhongPicker.show();
            }
        });

        btnBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nlsize = nltypeName.size();
                for (int i = 0; i < nlsize; i++) {
                    if (nltypeName.get(i).equals(tvPartaddNianling.getText().toString())) {
                        NianlingId = nltypeId.get(i);
                    }
                }

                int sfsize = sftypeName.size();
                for (int i = 0; i < sfsize; i++) {
                    if (sftypeName.get(i).equals(tvPartaddShenfen.getText().toString())) {
                        ShenfenId = sftypeId.get(i);
                    }
                }

                int zzsize = zztypeName.size();
                for (int i = 0; i < sfsize; i++) {
                    if (zztypeName.get(i).equals(tvPartaddzhuzhong.getText().toString())) {
                        ZhuzhongId = zztypeId.get(i);
                    }
                }
                PartAddActivity activity = (PartAddActivity) getActivity();

//                if (tvPartaddShenfen.getText().equals("请选择") && tvPartaddNianling.getText().toString().equals("请选择")
//                        && etPartaddChengwei.getText().toString().equals("") && etPartaddWeixin.getText().toString().equals("")
//                        && tvPartaddzhuzhong.getText().toString().equals("请选择")) {
//                    showToast("请最少选择一项！");
//                } else {

                    mPresenter.upxunjia(App.danhao,
                            ShenfenId,
                            NianlingId,
                            name,
                            etPartaddWeixin.getText().toString(),
                            ZhuzhongId,
                            activity.price
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
    protected NewTwoPresenter onCreatePresenter() {
        return new NewTwoPresenter(this);
    }
    //private double price;

    private int NianlingId;
    private int ShenfenId;
    private int ZhuzhongId;
    String name;

    @Override
    public void responseGetData(NewTwoInfo info) {
        NewTwoInfo.BodyBean bodyBean = info.getBody().get(0);
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.price = bodyBean.getPingGuPrice();

//        if (!bodyBean.getXingMing().trim().isEmpty()) {
//            chengweibs = 1;
////            etPartaddChengwei.setText(bodyBean.getXingMing());
//        }
        Log.e("称谓=====",bodyBean.getXingMing());
        name=bodyBean.getXingMing();

        if (!bodyBean.getWeiXin().trim().isEmpty()) {
            weixinbs = 1;
            etPartaddWeixin.setText(bodyBean.getWeiXin());
        }

        NianlingId = bodyBean.getNianLingID();
        ShenfenId = bodyBean.getShenFenID();
        ZhuzhongId = bodyBean.getZhuZhongDianID();

        //年龄
        int size = nltypeId.size();
        for (int i = 0; i < size; i++) {
            if (bodyBean.getNianLingID() == nltypeId.get(i)) {
                if (nltypeName.get(i).equals("请选择")) {
                    tvPartaddNianling.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    nianlingbs = 1;
                    tvPartaddNianling.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddNianling.setText(nltypeName.get(i));

            }
        }

        //身份
        int sfsize = sftypeId.size();
        for (int i = 0; i < sfsize; i++) {
            if (bodyBean.getShenFenID() == sftypeId.get(i)) {
                if (sftypeName.get(i).equals("请选择")) {
                    tvPartaddShenfen.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    shenfenbs = 1;
                    tvPartaddShenfen.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddShenfen.setText(sftypeName.get(i));

            }
        }

        //注重
        int zzsize = zztypeId.size();
        for (int i = 0; i < zzsize; i++) {
            if (bodyBean.getZhuZhongDianID() == zztypeId.get(i)) {
                if (zztypeName.get(i).equals("请选择")) {
                    tvPartaddzhuzhong.setTextColor(Color.parseColor("#c9caca"));
                } else {
                    zhuzhongbs = 1;
                    tvPartaddzhuzhong.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddzhuzhong.setText(zztypeName.get(i));

            }
        }
        activity.price(bodyBean.getPingGuPrice());

    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void responseUpData(UpPartAddInfo info) {
        //showToast("上传成功");
        PartAddActivity activity = (PartAddActivity) getActivity();

        activity.jump(2);

    }

    @Override
    public void responseUpDataError(String msg) {

    }

    List<String> nltypeName;
    List<Integer> nltypeId;

    @Override
    public void responseGetXiaLakuangData(NewTwoXiaLaInfo info) {

        nltypeName = new ArrayList<>();
        nltypeId = new ArrayList<>();

        int size = info.getBody().size();
        for (int i = 0; i < size; i++) {
            nltypeName.add(info.getBody().get(i).getMingCheng());
            nltypeId.add(info.getBody().get(i).getID());
        }

        //mPresenter.getxunjia(App.danhao);
        mPresenter.getxunjiaShenfenXialakuang();
    }

    @Override
    public void responseGetXiaLakuangDataError(String msg) {

    }

    List<String> sftypeName;
    List<Integer> sftypeId;

    @Override
    public void responseGetShenfenXiaLakuangData(NewTwoXiaLaInfo info) {
        sftypeName = new ArrayList<>();
        sftypeId = new ArrayList<>();

        int size = info.getBody().size();
        for (int i = 0; i < size; i++) {
            sftypeName.add(info.getBody().get(i).getMingCheng());
            sftypeId.add(info.getBody().get(i).getID());
        }
        mPresenter.getxunjiaZhuzhongXialakuang();
    }

    @Override
    public void responseGetShenfenXiaLakuangDataError(String msg) {

    }

    List<String> zztypeName;
    List<Integer> zztypeId;

    @Override
    public void responseGetZhuzhongXiaLakuangData(NewTwoXiaLaInfo info) {
        zztypeName = new ArrayList<>();
        zztypeId = new ArrayList<>();

        int size = info.getBody().size();
        for (int i = 0; i < size; i++) {
            zztypeName.add(info.getBody().get(i).getMingCheng());
            zztypeId.add(info.getBody().get(i).getID());
        }
        mPresenter.getxunjia(App.danhao);
    }

    @Override
    public void responseGetZhuzhongXiaLakuangDataError(String msg) {

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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
