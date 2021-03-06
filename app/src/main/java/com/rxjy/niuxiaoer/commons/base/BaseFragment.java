package com.rxjy.niuxiaoer.commons.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.utils.AutoUtils;

import butterknife.ButterKnife;


/**
 * Created by Mr on 16-8-3.
 * 所有普通的Fragment 继承 此基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    private View view;
    protected P mPresenter;

    public Toast toast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(container.getContext()).inflate(getFragmentLayout(), container, false);
        //初始化屏幕适配
        AutoUtils.auto(view);
        ButterKnife.bind(this, view);
        toast = new Toast(getActivity());
        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
        FragmentInitData();
        return view;
    }

    /**
     * 返回布局文件
     *
     * @return
     */
    protected abstract int getFragmentLayout();

    protected abstract void FragmentInitData();

    public void showToast(String msg) {
        if (toast != null) {
            toast.cancel();
        }
        toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    private ProgressDialog dialog;

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(getActivity());
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(getClass().getSimpleName(), getClass().getSimpleName() + ":onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(getClass().getSimpleName(), ":onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), ":onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), ":onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(getClass().getSimpleName(), ":onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), ":onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getClass().getSimpleName(), ":onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
        Log.d(getClass().getSimpleName(), ":onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getClass().getSimpleName(), ":onDetach");
    }

    protected abstract P onCreatePresenter();

}
