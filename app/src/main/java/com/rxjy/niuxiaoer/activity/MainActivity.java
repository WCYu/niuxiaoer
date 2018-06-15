package com.rxjy.niuxiaoer.activity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetDanHaoInfo;
import com.rxjy.niuxiaoer.entity.GetNewZDPrice;
import com.rxjy.niuxiaoer.entity.IconInfo;
import com.rxjy.niuxiaoer.entity.IsReadStateInfo;
import com.rxjy.niuxiaoer.fragment.ActivityFragment;
import com.rxjy.niuxiaoer.fragment.HomeFragment;
import com.rxjy.niuxiaoer.fragment.MineFragment;
import com.rxjy.niuxiaoer.fragment.WalletFragment;
import com.rxjy.niuxiaoer.mvp.contract.MainContract;
import com.rxjy.niuxiaoer.mvp.presenter.MainPresenter;
import com.rxjy.niuxiaoer.service.CoreService;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Bind(R.id.iv_tab_home)
    ImageView ivTabHome;
    @Bind(R.id.tv_tab_home)
    TextView tvTabHome;
    @Bind(R.id.iv_tab_wallet)
    ImageView ivTabWallet;
    @Bind(R.id.tv_tab_wallet)
    TextView tvTabWallet;
    @Bind(R.id.iv_tab_find)
    ImageView ivTabFind;
    @Bind(R.id.tv_tab_find)
    TextView tvTabFind;
    @Bind(R.id.iv_tab_mine)
    ImageView ivTabMine;
    @Bind(R.id.tv_tab_mine)
    TextView tvTabMine;
    @Bind(R.id.tv_tab_home_state)
    TextView tvTabHomeState;
    @Bind(R.id.tv_tab_wallet_state)
    TextView tvTabWalletState;
    @Bind(R.id.tv_tab_find_state)
    TextView tvTabFindState;
    @Bind(R.id.tv_tab_mine_state)
    TextView tvTabMineState;
    @Bind(R.id.iv_new_shouye_add)
    ImageView iv_add;

    boolean isExit = false;

    Handler mExitHandler;

    private Fragment currentFragment;

    private int[] iconNormal = new int[]{
            R.mipmap.client_normal,
            R.mipmap.activity_normal,
            R.mipmap.ic_wallet,
            R.mipmap.ic_person
    };

    private int[] iconPressed = new int[]{
            R.mipmap.client_pressed,
            R.mipmap.activity_pressed,
            R.mipmap.ic_walletorange,
            R.mipmap.ic_personorange
    };

    //指定Fragment的坐标
    private final int HOME_FRAGMENT = 0;
    private final int FIND_FRAGMENT = 1;
    private final int WALLET_FRAGMENT = 2;
    private final int MINE_FRAGMENT = 3;

    //Tab图标的集合
    private List<IconInfo> iconList;

    //碎片的集合
    private List<Fragment> fragmentList;

    private HomeFragment homeFragment;
    private ActivityFragment findFragment;
    private WalletFragment walletFragment;
    private MineFragment mineFragment;

    //广播
    public MineFragment.PushStateReceiver pushReceiver;

    //检测权限列表
    private String[] requestPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE
    };

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

        initIcon();
        initFragment();
        //注册广播
        registerPushReceiver();
        //加载默认显示碎片
        showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
        initStartService();

        mPresenter.getNewZiDuanPrice();
    }



    private void initStartService() {
        //启动数据获取服务
        Intent serviceIntent = new Intent(this, CoreService.class);
        startService(serviceIntent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //权限检测
//        CheckPermissionsUitl.checkPermissions(this, requestPermissions);
        //获取TAB状态信息
        mPresenter.getTabState(App.cardNo);
        mPresenter.getMineState(App.cardNo);
        //退出
        mExitHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                isExit = false;
            }
        };

    }

    private void registerPushReceiver() {
        pushReceiver = new MineFragment.PushStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_INFORMATION_MINE);
        registerReceiver(pushReceiver, filter);
    }

    private void initFragment() {
        //初始化碎片
        if (homeFragment == null)
            homeFragment = new HomeFragment();
        if (walletFragment == null)
            walletFragment = new WalletFragment();
        if (findFragment == null)
            findFragment = new ActivityFragment();
        if (mineFragment == null)
            mineFragment = new MineFragment();
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(homeFragment);
        fragmentList.add(findFragment);
        fragmentList.add(walletFragment);
        fragmentList.add(mineFragment);
    }

    private void initIcon() {
        //初始化iconList数据集合
        iconList = new ArrayList<>();
        //将图标添加到集合中
        iconList.add(new IconInfo(ivTabHome, tvTabHome));
        iconList.add(new IconInfo(ivTabFind, tvTabFind));
        iconList.add(new IconInfo(ivTabWallet, tvTabWallet));
        iconList.add(new IconInfo(ivTabMine, tvTabMine));
    }

    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);
        setIcon(position);
    }

    /**
     * 加载指定Fragment的方法
     *
     * @param fragment
     */
    private void JumpFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction action = manager.beginTransaction();
        if (!fragment.isAdded()) {
            action.add(R.id.fl_main, fragment);
        }
        if (currentFragment != null) {
            action.hide(currentFragment);
        }
        action.show(fragment);
        action.commit();
        currentFragment = fragment;
    }

    /**
     * 设置图标点击效果
     *
     * @param position
     */
    private void setIcon(int position) {
        for (int i = 0; i < iconList.size(); i++) {
            iconList.get(i).getImageView().setImageResource(iconNormal[i]);
            iconList.get(i).getTextView().setTextColor(this.getResources().getColor(R.color.colorGrayDark));
        }
        iconList.get(position).getImageView().setImageResource(iconPressed[position]);
        iconList.get(position).getTextView().setTextColor(this.getResources().getColor(R.color.colorPrimary));
    }


    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册广播
        unregisterReceiver(pushReceiver);
    }

    @OnClick({R.id.rl_tab_home, R.id.rl_tab_wallet, R.id.rl_tab_find, R.id.rl_tab_mine,R.id.iv_new_shouye_add})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.rl_tab_home:
                showFragment(fragmentList.get(HOME_FRAGMENT), HOME_FRAGMENT);
                break;
            case R.id.rl_tab_wallet:
                showFragment(fragmentList.get(WALLET_FRAGMENT), WALLET_FRAGMENT);
                break;
            case R.id.rl_tab_find:
                showFragment(fragmentList.get(FIND_FRAGMENT), FIND_FRAGMENT);
                break;
            case R.id.rl_tab_mine:
                showFragment(fragmentList.get(MINE_FRAGMENT), MINE_FRAGMENT);
                break;
            case R.id.iv_new_shouye_add:

                mPresenter.getNewDanHao(App.cardNo);
                Intent intent=new Intent(MainActivity.this,PartAddActivity.class);
                startActivity(intent);

                break;
        }
    }


    public void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    @Override
    public void responseStateData(IsReadStateInfo.IsReadState data) {
        if (data.getStatus() == 1) {
            tvTabHomeState.setVisibility(View.VISIBLE);
        } else {
            tvTabHomeState.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void responseMineStateData(IsReadStateInfo.IsReadState data) {
        //发送广播
        Intent intent = new Intent(Constants.ACTION_INFORMATION_MINE);
        intent.putExtra(Constants.KEY_STATE, data.getStatus());
        sendBroadcast(intent);
        if (data.getStatus() == 1) {
            tvTabMineState.setVisibility(View.VISIBLE);
        } else {
            tvTabMineState.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void responseGetZiDuanPrice(GetNewZDPrice info) {
            App.bodyBean=info.getBody();
    }

    @Override
    public void responseGetZiDuanPriceError(String msg) {

    }
    @Override
    public void GetNewDanHao(GetDanHaoInfo info) {
        App.danhaobs=0;
            App.danhao = info.getBody().getDanHao();
    }

    @Override
    public void GetNewDanHaoError(String msg) {

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
