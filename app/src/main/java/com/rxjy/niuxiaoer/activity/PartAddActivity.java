package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.fragment.NewFiveFragment;
import com.rxjy.niuxiaoer.fragment.NewFourFragment;
import com.rxjy.niuxiaoer.fragment.NewOneFragment;
import com.rxjy.niuxiaoer.fragment.NewThreeFragment;
import com.rxjy.niuxiaoer.fragment.NewTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PartAddActivity extends BaseActivity {

    public double price;

    //指定Fragment的坐标
    private final int ONE_FRAGMENT = 0;
    private final int TWO_FRAGMENT = 1;
    private final int THREE_FRAGMENT = 2;
    private final int FOUR_FRAGMENT = 3;
    private final int FIVE_FRAGMENT = 4;

    private String[] TITLE={"基本信息","客户信息","房源信息","装修需求","楼盘"};

    NewOneFragment newOneFragment;
    NewTwoFragment newTwoFragment;
    NewThreeFragment newThreeFragment;
    NewFourFragment newFourFragment;
    NewFiveFragment newFiveFragment;
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_jindutiao_yi)
    TextView tvJindutiaoYi;
    @Bind(R.id.tv_jindutiao_er)
    TextView tvJindutiaoEr;
    @Bind(R.id.tv_jindutiao_san)
    TextView tvJindutiaoSan;
    @Bind(R.id.tv_jindutiao_si)
    TextView tvJindutiaoSi;
    @Bind(R.id.tv_jindutiao_wu)
    TextView tvJindutiaoWu;
    @Bind(R.id.tv_partadd_price)
    TextView tvPartaddPrice;
    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.iv_back)
    ImageView iv_back;

    private Fragment currentFragment;

    //碎片的集合
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_part_add);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posi==1){
                    tvBack.setVisibility(View.GONE);
                    iv_back.setVisibility(View.VISIBLE);
                    showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
                    tvJindutiaoYi.setVisibility(View.VISIBLE);
                    tvJindutiaoYi.setText("20%  ");
                    tvJindutiaoEr.setVisibility(View.INVISIBLE);
                    tvJindutiaoSan.setVisibility(View.INVISIBLE);
                    tvJindutiaoSi.setVisibility(View.INVISIBLE);
                    tvJindutiaoWu.setVisibility(View.INVISIBLE);
                }else if (posi==2){
                    tvBack.setVisibility(View.VISIBLE);
                    iv_back.setVisibility(View.GONE);
                    showFragment(fragmentList.get(TWO_FRAGMENT), TWO_FRAGMENT);
                    tvJindutiaoYi.setVisibility(View.VISIBLE);
                    tvJindutiaoYi.setText("");
                    tvJindutiaoEr.setText("40%  ");
                    tvJindutiaoEr.setVisibility(View.VISIBLE);
                    tvJindutiaoSan.setVisibility(View.INVISIBLE);
                    tvJindutiaoSi.setVisibility(View.INVISIBLE);
                    tvJindutiaoWu.setVisibility(View.INVISIBLE);
                    posi=1;
                }else if (posi==3){
                    tvBack.setVisibility(View.VISIBLE);
                    iv_back.setVisibility(View.GONE);
                    showFragment(fragmentList.get(THREE_FRAGMENT), THREE_FRAGMENT);
                    tvJindutiaoYi.setVisibility(View.VISIBLE);
                    tvJindutiaoYi.setText("");
                    tvJindutiaoEr.setVisibility(View.VISIBLE);
                    tvJindutiaoEr.setText("");
                    tvJindutiaoSan.setText("60%  ");
                    tvJindutiaoSan.setVisibility(View.VISIBLE);
                    tvJindutiaoSi.setVisibility(View.INVISIBLE);
                    tvJindutiaoWu.setVisibility(View.INVISIBLE);
                    posi=2;
                }else if (posi==4){
                    tvBack.setVisibility(View.VISIBLE);
                    iv_back.setVisibility(View.GONE);
                    showFragment(fragmentList.get(FOUR_FRAGMENT), FOUR_FRAGMENT);
                    tvJindutiaoYi.setVisibility(View.VISIBLE);
                    tvJindutiaoYi.setText("");
                    tvJindutiaoEr.setVisibility(View.VISIBLE);
                    tvJindutiaoEr.setText("");
                    tvJindutiaoSan.setVisibility(View.VISIBLE);
                    tvJindutiaoSan.setText("");
                    tvJindutiaoSi.setText("80%  ");
                    tvJindutiaoSi.setVisibility(View.VISIBLE);
                    tvJindutiaoWu.setVisibility(View.INVISIBLE);
                    posi=3;
                }
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
         private int posi=-1;
    //子fragment数据交互
    public void jump(int pos) {
        posi=pos;

        if (pos==1){
            tvBack.setVisibility(View.VISIBLE);
            iv_back.setVisibility(View.GONE);
            showFragment(fragmentList.get(TWO_FRAGMENT), TWO_FRAGMENT);
            tvJindutiaoYi.setVisibility(View.VISIBLE);
            tvJindutiaoYi.setText("");
            tvJindutiaoEr.setText("40%  ");
            tvJindutiaoEr.setVisibility(View.VISIBLE);
            tvJindutiaoSan.setVisibility(View.INVISIBLE);
            tvJindutiaoSi.setVisibility(View.INVISIBLE);
            tvJindutiaoWu.setVisibility(View.INVISIBLE);
        }else if (pos==2){
            tvBack.setVisibility(View.VISIBLE);
            iv_back.setVisibility(View.GONE);
            showFragment(fragmentList.get(THREE_FRAGMENT), THREE_FRAGMENT);
            tvJindutiaoYi.setVisibility(View.VISIBLE);
            tvJindutiaoYi.setText("");
            tvJindutiaoEr.setVisibility(View.VISIBLE);
            tvJindutiaoEr.setText("");
            tvJindutiaoSan.setText("60%  ");
            tvJindutiaoSan.setVisibility(View.VISIBLE);
            tvJindutiaoSi.setVisibility(View.INVISIBLE);
            tvJindutiaoWu.setVisibility(View.INVISIBLE);
        }else if (pos==3){
            tvBack.setVisibility(View.VISIBLE);
            iv_back.setVisibility(View.GONE);
            showFragment(fragmentList.get(FOUR_FRAGMENT), FOUR_FRAGMENT);
            tvJindutiaoYi.setVisibility(View.VISIBLE);
            tvJindutiaoYi.setText("");
            tvJindutiaoEr.setVisibility(View.VISIBLE);
            tvJindutiaoEr.setText("");
            tvJindutiaoSan.setVisibility(View.VISIBLE);
            tvJindutiaoSan.setText("");
            tvJindutiaoSi.setText("80%  ");
            tvJindutiaoSi.setVisibility(View.VISIBLE);
            tvJindutiaoWu.setVisibility(View.INVISIBLE);
        }else if (pos==4){
            tvBack.setVisibility(View.VISIBLE);
            iv_back.setVisibility(View.GONE);
            showFragment(fragmentList.get(FIVE_FRAGMENT), FIVE_FRAGMENT);
            tvJindutiaoYi.setVisibility(View.VISIBLE);
            tvJindutiaoYi.setText("");
            tvJindutiaoEr.setVisibility(View.VISIBLE);
            tvJindutiaoEr.setText("");
            tvJindutiaoSan.setVisibility(View.VISIBLE);
            tvJindutiaoSan.setText("");
            tvJindutiaoSi.setVisibility(View.VISIBLE);
            tvJindutiaoSi.setText("");
            tvJindutiaoWu.setText("100%  ");
            tvJindutiaoWu.setVisibility(View.VISIBLE);
        }
    }

    public void price(double price) {
     tvPartaddPrice.setText(price+"");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_part_add;
    }


    @Override
    public void initData() {
        if (App.danhaobs==1) {
            App.danhao = getIntent().getStringExtra("DANHAO");
        }
        initFragment();


        //加载默认显示碎片
        showFragment(fragmentList.get(ONE_FRAGMENT), ONE_FRAGMENT);
        tvBack.setVisibility(View.GONE);
        iv_back.setVisibility(View.VISIBLE);

    }

    private void initFragment() {
        //初始化碎片
        if (newOneFragment == null)
            newOneFragment = new NewOneFragment();
        if (newTwoFragment == null)
            newTwoFragment = new NewTwoFragment();
        if (newThreeFragment == null)
            newThreeFragment = new NewThreeFragment();
        if (newFourFragment == null)
            newFourFragment = new NewFourFragment();
        if (newFiveFragment == null)
            newFiveFragment = new NewFiveFragment();
        //初始化fragmentList数据集合
        fragmentList = new ArrayList<>();
        //将碎片添加到集合中
        fragmentList.add(newOneFragment);
        fragmentList.add(newTwoFragment);
        fragmentList.add(newThreeFragment);
        fragmentList.add(newFourFragment);
        fragmentList.add(newFiveFragment);
    }


    /**
     * 显示指定Fragment界面的方法
     *
     * @param fragment
     * @param position
     */
    private void showFragment(Fragment fragment, int position) {
        JumpFragment(fragment);

        tvTitle.setText(TITLE[position]);

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


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
