package com.rxjy.niuxiaoer.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.AllianceActivity;
import com.rxjy.niuxiaoer.activity.MsgListActivity;
import com.rxjy.niuxiaoer.activity.SettingActivity;
import com.rxjy.niuxiaoer.activity.UserInfoActivity;
import com.rxjy.niuxiaoer.activity.my.NewUserInfoActivity;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.widget.RoundAngleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/7/26.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_mine_name)
    TextView tvMineName;
    @Bind(R.id.tv_mine_card)
    TextView tvMineCard;
    @Bind(R.id.riv_mine)
    RoundAngleImageView rivMine;
    @Bind(R.id.tv_msg_state)
    TextView tvState;

    public static final String TITLE = "我";

    private static int state;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        initUserData();
    }

    @Override
    public void onResume() {
        super.onResume();
        initUserData();
        initReadState();
    }

    private void initTitle() {
        ivBack.setVisibility(View.INVISIBLE);
        tvTitle.setText(TITLE);
    }

    private void initUserData() {
        tvMineName.setText(App.baseInfo.getNickName() == null ? "昵称" : App.baseInfo.getNickName());
        tvMineCard.setText("账号：" + App.cardNo);
        if (App.baseInfo.getImage() != null)
            Glide.with(getActivity()).load(App.baseInfo.getImage()).into(rivMine);
    }

    private void initReadState() {
        if (state == 1) {
            tvState.setVisibility(View.VISIBLE);
        } else {
            tvState.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_user_info, R.id.rl_alliance, R.id.rl_settings, R.id.rl_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:
//                startActivity(new Intent(getActivity(), UserInfoActivity.class));
                startActivity(new Intent(getActivity(), NewUserInfoActivity.class));
                break;
            case R.id.rl_alliance:
                startActivity(new Intent(getActivity(), AllianceActivity.class));
                break;
            case R.id.rl_settings:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.rl_msg:
                startActivity(new Intent(getActivity(), MsgListActivity.class));
                break;
        }
    }

    public static class PushStateReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == Constants.ACTION_INFORMATION_MINE) {
                state = intent.getIntExtra(Constants.KEY_STATE, 0);
            }
        }
    }

}
