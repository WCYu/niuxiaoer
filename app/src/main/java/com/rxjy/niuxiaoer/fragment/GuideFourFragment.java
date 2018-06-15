package com.rxjy.niuxiaoer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.LoginActivity;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFourFragment extends BaseFragment
{
    @Bind(R.id.guide_insert)
    FrameLayout fl;

    public GuideFourFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_four_guide;
    }

    @Override
    protected void FragmentInitData() {
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
                getActivity().finish();
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick(R.id.tv_yindaoye_insert)
    public void onViewClicked()
    {
        startActivity(new Intent(getActivity(),LoginActivity.class));
        getActivity().finish();
    }
}
