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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.PartAddActivity;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.commons.utils.StringUtils;
import com.rxjy.niuxiaoer.entity.NewOneInfo;
import com.rxjy.niuxiaoer.entity.NewOneXiaLaInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfoNew;
import com.rxjy.niuxiaoer.mvp.contract.NewOneContract;
import com.rxjy.niuxiaoer.mvp.presenter.NewOnePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewOneFragment extends BaseFragment<NewOnePresenter> implements NewOneContract.View {

    @Bind(R.id.et_partadd_gongsi)
    EditText etPartaddGongsi;
    @Bind(R.id.et_partadd_name)
    EditText et_partadd_name;
    @Bind(R.id.et_partadd_phone)
    EditText et_partadd_phone;
    @Bind(R.id.et_partadd_phonestandby)
    EditText et_partadd_phonestandby;
    @Bind(R.id.ll_partadd_hangyestyle)
    LinearLayout llPartaddHangyestyle;
    @Bind(R.id.et_partadd_hangyestyle)
    TextView etPartaddHangye;
    @Bind(R.id.et_partadd_bangongaddress)
    EditText etPartaddBangongaddress;
    @Bind(R.id.btn_baocun)
    Button btnBaocun;
    @Bind(R.id.iv_partadd_hangyestyle)
    ImageView ivPartaddHangyestyle;

    //private double price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_one;
    }

    PartAddActivity activity;
    int iseditphone;
    @Override
    protected void FragmentInitData() {
        et_partadd_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    phone=et_partadd_phone.getText().toString().trim();
                    if(isedit!=1&&phone!=null&&phone.length()>0){
                        iseditphone=1;
                        if(issubmit!=1){
                            mPresenter.getphone(phone);
                        }else{
                            issubmit=0;
                        }
                        Log.e("11111","11111");
                    }
                }
            }
        });

        mPresenter.getjibenXialakuang();
        activity = (PartAddActivity) getActivity();
        onClick();
    }

    int leixingyi = -1;
    private OptionsPickerView HangyePicker;

    int gongsibs= 0;
    int hangyebs=0;
    int bangongdizhibs=0;

    int issubmit;
    String phone,phonestandby;
    private void onClick() {

        etPartaddGongsi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (s.length()==0){
                    if (gongsibs==1) {
                        activity.price = activity.price - App.bodyBean.get(0).getGongSiMingCheng();
                        gongsibs=0;

                        activity.price(activity.price);
                    }
                }else if (s.length()!=0){
                   if (gongsibs==0) {
                       activity.price = activity.price + App.bodyBean.get(0).getGongSiMingCheng();
                       gongsibs=1;

                       activity.price(activity.price);
                   }
                }
            }
        });

        etPartaddBangongaddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PartAddActivity activity = (PartAddActivity) getActivity();
                if (s.length()==0){
                    if (bangongdizhibs==1) {
                        activity.price = activity.price - App.bodyBean.get(0).getBanGongDiZhi();
                        bangongdizhibs=0;

                        activity.price(activity.price);
                    }
                }else if (s.length()!=0){
                    if (bangongdizhibs==0) {
                        activity.price = activity.price + App.bodyBean.get(0).getBanGongDiZhi();
                        bangongdizhibs=1;
                        activity.price(activity.price);
                    }
                }
            }
        });


        btnBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int size = hytypeName.size();
                for (int i = 0; i < size; i++) {
                    if (hytypeName.get(i).equals(etPartaddHangye.getText().toString())) {
                        leixingyi = hytypeId.get(i);
                    }
                }
                PartAddActivity activity = (PartAddActivity) getActivity();

                phone=et_partadd_phone.getText().toString();
                phonestandby=et_partadd_phonestandby.getText().toString();

                if(!et_partadd_name.getText().toString().equals("")&&et_partadd_name.getText().toString().length()>=2&&!phone.equals("")){
                    if(phonestandby.equals("")){//请求
                        if(isedit==1){
                            mPresenter.upjiben(App.danhao,
                                    etPartaddGongsi.getText().toString(),
                                    etPartaddBangongaddress.getText().toString(),
                                    leixingyi,
                                    activity.price,
                                    et_partadd_phone.getText().toString(),
                                    et_partadd_name.getText().toString(),
                                    et_partadd_phonestandby.getText().toString()
                            );
                        }else{

                            mPresenter.getphone(phone);
                            issubmit=1;
                            Log.e("11111","22222");
                        }

                    }else{
                        if(!StringUtils.isMobileNO(phonestandby)){
                            showToast("请输入正确的备用手机号！");
                        }else{
                            if(isedit==1){
                                mPresenter.upjiben(App.danhao,
                                        etPartaddGongsi.getText().toString(),
                                        etPartaddBangongaddress.getText().toString(),
                                        leixingyi,
                                        activity.price,
                                        et_partadd_phone.getText().toString(),
                                        et_partadd_name.getText().toString(),
                                        et_partadd_phonestandby.getText().toString()
                                );
                            }else{
                                mPresenter.getphone(phone);
                                issubmit=1;
                                Log.e("11111","33333");
                            }

                        }
                    }

                }else if(et_partadd_name.getText().toString().equals("")){
                    showToast("请输入客户尊称！");
                }else if(et_partadd_name.getText().toString().length()<2){
                    showToast("客户尊称最少输入两位！");
                }else if(phone.equals("")){
                    showToast("请输入手机号！");
                }

//                if (etPartaddHangye.getText().toString().equals("请选择")&&etPartaddBangongaddress.getText().toString().equals("")&&etPartaddGongsi.getText().toString().equals("")){
//                    showToast("请最少选择一项！");
//                }else{

//                }
            }
        });


        llPartaddHangyestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(llPartaddHangyestyle);

                HangyePicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (hytypeName.get(options1).equals("请选择")){
                            if (hangyebs==1){
                                activity.price=activity.price-App.bodyBean.get(0).getHangYe();
                                hangyebs=0;

                                activity.price(activity.price);
                            }
                            etPartaddHangye.setTextColor(Color.parseColor("#c9caca"));
                        }else{
                            if (hangyebs==0){
                                activity.price=activity.price+App.bodyBean.get(0).getHangYe();
                                hangyebs=1;
                                activity.price(activity.price);
                            }
                            etPartaddHangye.setTextColor(Color.parseColor("#595757"));
                        }

                        etPartaddHangye.setText(hytypeName.get(options1));

                    }
                }).build();
                HangyePicker.setPicker(hytypeName);
                HangyePicker.show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected NewOnePresenter onCreatePresenter() {
        return new NewOnePresenter(this);
    }


    /**
     * 弹出软键盘
     */
    public void openKeyboard(View view) {
        // 获取焦点
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        // 弹出软键盘
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    /**
     * 关闭软键盘
     */
    public void closeKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    int isedit;
    @Override
    public void responseGetData(NewOneInfo info) {
        NewOneInfo.BodyBean bodyBean = info.getBody().get(0);
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.price = bodyBean.getPingGuPrice();
        if(activity.price>0){
        }else{
            activity.price=activity.price+1000;
            activity.price(activity.price);
        }

        if (!bodyBean.getXingMing().trim().isEmpty()) {
//            gongsibs=1;
            et_partadd_name.setText(bodyBean.getXingMing());
        }
        if (!bodyBean.getPhone().trim().isEmpty()) {
//            gongsibs=1;
            isedit=1;
            et_partadd_phone.setText(bodyBean.getPhone());
            et_partadd_phone.setEnabled(false);
        }
        if (!bodyBean.getSparePhone().trim().isEmpty()) {
//            gongsibs=1;
            et_partadd_phonestandby.setText(bodyBean.getSparePhone());
            if(bodyBean.getSparePhone().length()>0){
                et_partadd_phonestandby.setEnabled(false);
            }else{
                et_partadd_phonestandby.setEnabled(true);
            }
        }

        if (!bodyBean.getGongSiMingCheng().trim().isEmpty()) {
            gongsibs=1;
            etPartaddGongsi.setText(bodyBean.getGongSiMingCheng());
        }


        if (!bodyBean.getBanGongDiDian().trim().isEmpty()) {
            bangongdizhibs=1;
            etPartaddBangongaddress.setText(bodyBean.getBanGongDiDian());
        }

        leixingyi = bodyBean.getLeiXingYi();

        int size = hytypeId.size();

        for (int i = 0; i < size; i++) {
            if (bodyBean.getLeiXingYi() == hytypeId.get(i)) {
                if (hytypeName.get(i).equals("请选择")){
                    etPartaddHangye.setTextColor(Color.parseColor("#c9caca"));
                }else{
                    hangyebs=1;
                    etPartaddHangye.setTextColor(Color.parseColor("#595757"));
                }
                etPartaddHangye.setText(hytypeName.get(i));

            }
        }


        activity.price(activity.price);


    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void responseUpData(UpPartAddInfoNew info) {
        PartAddActivity activity = (PartAddActivity) getActivity();

        activity.jump(1);
    }

//    @Override
//    public void responseUpData(UpPartAddInfo info) {
//        //showToast("上传成功");
//        PartAddActivity activity = (PartAddActivity) getActivity();
//
//            activity.jump(1);
//
//    }

    @Override
    public void responseUpDataError(String msg) {
        showToast(msg);
    }

    List<String> hytypeName;
    List<Integer> hytypeId;

    @Override
    public void responseGetXiaLakuangData(NewOneXiaLaInfo info) {

        hytypeName = new ArrayList<>();
        hytypeId = new ArrayList<>();

        int size = info.getBody().size();
        for (int i = 0; i < size; i++) {
            hytypeName.add(info.getBody().get(i).getMingCheng());
            hytypeId.add(info.getBody().get(i).getID());
        }

        mPresenter.getjiben(App.danhao);

    }

    @Override
    public void responseGetXiaLakuangDataError(String msg) {

    }

    @Override
    public void responsephone(String msg) {
        if(iseditphone==1){
            iseditphone=0;
        }else{
            mPresenter.upjiben(App.danhao,
                    etPartaddGongsi.getText().toString(),
                    etPartaddBangongaddress.getText().toString(),
                    leixingyi,
                    activity.price,
                    et_partadd_phone.getText().toString(),
                    et_partadd_name.getText().toString(),
                    et_partadd_phonestandby.getText().toString()
            );
        }

    }

    @Override
    public void responsephoneError(String msg) {
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
