package com.rxjy.niuxiaoer.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.rxjy.niuxiaoer.activity.SubmitDialogActivity;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.entity.NewFiveInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewFiveContract;
import com.rxjy.niuxiaoer.mvp.presenter.NewFivePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFiveFragment extends BaseFragment<NewFivePresenter> implements NewFiveContract.View {

    @Bind(R.id.tv_partadd_guimo)
    TextView tvPartaddGuimo;
    @Bind(R.id.et_partadd_loupan)
    EditText etPartaddLoupan;
    @Bind(R.id.et_partadd_qizuo)
    EditText etPartaddQizuo;
    @Bind(R.id.btn_baocun)
    Button btnBaocun;
    @Bind(R.id.btn_tijiao)
    Button btnTijiao;

    private OptionsPickerView GuimoPicker;

    private int saveorsub=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_new_five;
    }

    @Override
    protected void FragmentInitData() {
        mPresenter.getxunjia(App.danhao);
        onclick();
    }

    private void onclick() {
        etPartaddLoupan.addTextChangedListener(new TextWatcher() {
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
                    if (loupanmingchengbs==1) {
                        activity.price = activity.price - App.bodyBean.get(0).getLouPan();
                        loupanmingchengbs=0;
                        activity.price(activity.price);
                    }
                }else if (s.length()!=0){
                    if (loupanmingchengbs==0) {
                        activity.price = activity.price + App.bodyBean.get(0).getLouPan();
                        loupanmingchengbs=1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        etPartaddQizuo.addTextChangedListener(new TextWatcher() {
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
                    if (qizuomingchengbs==1) {
                        activity.price = activity.price - App.bodyBean.get(0).getQiZuo();
                        qizuomingchengbs=0;

                        activity.price(activity.price);
                    }
                }else if (s.length()!=0){
                    if (qizuomingchengbs==0) {
                        activity.price = activity.price + App.bodyBean.get(0).getQiZuo();
                        qizuomingchengbs=1;
                        activity.price(activity.price);
                    }
                }
            }
        });

        tvPartaddGuimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeKeyboard(tvPartaddGuimo);
                GuimoPicker = new OptionsPickerView.Builder(getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        PartAddActivity activity = (PartAddActivity) getActivity();
                        if (QiyeguimoTypeName[options1].equals("请选择")){
                            if (qiyeguimobs==1){
                                activity.price=activity.price-App.bodyBean.get(0).getGuiMo();
                                qiyeguimobs=0;

                                activity.price(activity.price);
                            }
                            tvPartaddGuimo.setTextColor(Color.parseColor("#c9caca"));
                        }else{
                            if (qiyeguimobs==0){
                                activity.price=activity.price+App.bodyBean.get(0).getGuiMo();
                                qiyeguimobs=1;
                                activity.price(activity.price);
                            }
                            tvPartaddGuimo.setTextColor(Color.parseColor("#595757"));
                        }

                        tvPartaddGuimo.setText(QiyeguimoTypeName[options1]);

                    }
                }).build();

                List Xuqiulist=new ArrayList<>();
                for (int i=0;i<QiyeguimoTypeName.length;i++){
                    Xuqiulist.add(QiyeguimoTypeName[i]);
                }
                GuimoPicker.setPicker(Xuqiulist);
                GuimoPicker.show();
            }
        });


        btnBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guimosize= QiyeguimoTypeName.length;
                for (int i = 0; i < guimosize; i++) {
                    if (QiyeguimoTypeName[i].equals(tvPartaddGuimo.getText().toString())) {
                        qiyeguimoId = QiyeguimoTypeId[i];
                    }
                }


                PartAddActivity activity = (PartAddActivity) getActivity();
                saveorsub=1;
//                if (tvPartaddGuimo.getText().toString().equals("请选择")&&etPartaddLoupan.getText().toString().equals("")
//                        &&etPartaddQizuo.getText().toString().equals("")){
//                    showToast("请最少选择一项！");
//                }else {
                    mPresenter.upxunjia(App.danhao,
                            qiyeguimoId,
                            etPartaddLoupan.getText().toString(),
                            etPartaddQizuo.getText().toString(),
                            activity.price,
                            1
                    );
           //     }
            }
        });

        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guimosize= QiyeguimoTypeName.length;
                for (int i = 0; i < guimosize; i++) {
                    if (QiyeguimoTypeName[i].equals(tvPartaddGuimo.getText().toString())) {
                        qiyeguimoId = QiyeguimoTypeId[i];
                    }
                }


                PartAddActivity activity = (PartAddActivity) getActivity();
                saveorsub=2;

                    mPresenter.upxunjia(App.danhao,
                            qiyeguimoId,
                            etPartaddLoupan.getText().toString(),
                            etPartaddQizuo.getText().toString(),
                            activity.price,
                            2
                    );

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
    protected NewFivePresenter onCreatePresenter() {
        return new NewFivePresenter(this);
    }

    private int qiyeguimobs = 0;
    private int loupanmingchengbs = 0;
    private int qizuomingchengbs = 0;

    private int qiyeguimoId = -1;

    int[] QiyeguimoTypeId={0,115,116,117,118};
    String[] QiyeguimoTypeName={"请选择","30人以下","30~50人","50-100人","100人以上"};

    private int MemberOrder;
    @Override
    public void responseGetData(NewFiveInfo info) {

        NewFiveInfo.BodyBean bodyBean = info.getBody().get(0);
        PartAddActivity activity = (PartAddActivity) getActivity();
        activity.price = bodyBean.getPingGuPrice();

        if (!bodyBean.getBuildName().trim().isEmpty()) {
            loupanmingchengbs = 1;
            etPartaddLoupan.setText(bodyBean.getBuildName() + "");
        }

        if (!bodyBean.getLouPanQiZuo().trim().isEmpty()) {
            qizuomingchengbs = 1;
            etPartaddQizuo.setText(bodyBean.getLouPanQiZuo() + "");
        }
        //企业规模
        int xuqiusize = QiyeguimoTypeName.length;
        for (int i = 0; i < xuqiusize; i++) {
            if (bodyBean.getQiYeGuiMoID() == QiyeguimoTypeId[i]) {
                if (QiyeguimoTypeName[i].equals("请选择")){
                    tvPartaddGuimo.setTextColor(Color.parseColor("#c9caca"));
                }else{
                    qiyeguimobs=1;
                    tvPartaddGuimo.setTextColor(Color.parseColor("#595757"));
                }
                tvPartaddGuimo.setText(QiyeguimoTypeName[i]);

            }
        }

        activity.price(bodyBean.getPingGuPrice());

        MemberOrder=bodyBean.getMemberOrder();

    }

    @Override
    public void responseGetDataError(String msg) {

    }

    @Override
    public void responseUpData(UpPartAddInfo info) {
        if (info.getStatusCode()==0) {
            getActivity().finish();
//                Intent intent = new Intent(getActivity(), SubmitDialogActivity.class);
//                intent.putExtra("saveorsub", saveorsub);
//                startActivityForResult(intent,101);

        }
    }

    @Override
    public void responseUpDataError(String msg) {
          showToast(msg);
    }

    @Override
    public void responseUpXinxi(UpPartAddInfo info) {

        showToast("上传成功");


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101&&resultCode==101) {
            getActivity().finish();
        }

    }

    @Override
    public void responseUpXinxiError(String msg) {
        showToast("上传失败");
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
