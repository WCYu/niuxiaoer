package com.rxjy.niuxiaoer.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.rxjy.niuxiaoer.ProjectInfoActivity;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.activity.AddActivity;
import com.rxjy.niuxiaoer.activity.PinggujiageActivity;
import com.rxjy.niuxiaoer.activity.ProjectDaHuiActivity;
import com.rxjy.niuxiaoer.activity.SearchActivity;
import com.rxjy.niuxiaoer.activity.ZhijianBaogaoActivity;
import com.rxjy.niuxiaoer.adapter.HomeAdapter;
import com.rxjy.niuxiaoer.adapter.MyBannerAdapter;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseFragment;
import com.rxjy.niuxiaoer.commons.utils.AutoUtils;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.mvp.contract.GetClientMsgListContract;
import com.rxjy.niuxiaoer.mvp.presenter.GetClientMsgListPresenter;
import com.taobao.library.VerticalBannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AAA on 2017/7/26.
 */

public class HomeFragment extends BaseFragment<GetClientMsgListPresenter> implements GetClientMsgListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_search)
    ImageView iv_search;
    @Bind(R.id.lv_home)
    SwipeMenuListView lvHome;
    @Bind(R.id.tv_title_count)
    TextView tv;
    @Bind(R.id.srl_home)
    SwipeRefreshLayout srlHome;
    @Bind(R.id.btn_home_add)
    Button btn_add;
    @Bind(R.id.ll_home_add)
    LinearLayout ll_add;
    @Bind(R.id.banner)
    VerticalBannerView banner;

    private List<GetNewShouyeInfo.BodyBean.DataTotalBean> listBanner;

    private MyBannerAdapter mBannerAdapter;

    public static final String TAG = "HomeFragment";

    public static final String TITLE = "客户";

    private int pos;

    private List<GetNewShouyeInfo.BodyBean.DataListBean> listadd;

    private HomeAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void FragmentInitData() {
        initTitle();
        initClientList();
        initRefresh();
    }

    private void initTitle() {
        ivAdd.setVisibility(View.VISIBLE);
        tvTitle.setText(TITLE);
    }

//    private void initClientData(List<GetClientMsgList.Body> data) {
//        if (data.size() == 0) {
//            ll_add.setVisibility(View.VISIBLE);
//        } else {
//            ll_add.setVisibility(View.GONE);
//        }
//        listadd.clear();
//        listadd.addAll(data);
//        tv.setText("(" + mAdapter.getCount() + ")");
//        mAdapter.notifyDataSetChanged();
//    }

    private void initClientList() {

        listBanner = new ArrayList<>();



        listadd = new ArrayList<>();

        mAdapter = new HomeAdapter(getActivity(), listadd);

        lvHome.setAdapter(mAdapter);

        final SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {

                switch (menu.getViewType()) {
                    case 0:
                        SwipeMenuItem item = new SwipeMenuItem(getActivity());

                        item.setBackground(R.color.colorRed);

                        item.setWidth(AutoUtils.getDisplayWidthValue(160));

                        item.setIcon(R.mipmap.del_icon);

                        item.setTitleColor(R.color.colorOrange);

                        menu.addMenuItem(item);
                        break;
                    case 1:
                        break;
                }

            }

        };

        lvHome.setMenuCreator(creator);

        lvHome.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        GetNewShouyeInfo.BodyBean.DataListBean info = listadd.get(position);
                        mPresenter.delClientInfo(info.getDanHao());
                        listadd.remove(position);
                        mAdapter.notifyDataSetChanged();
                        tv.setText("(" + mAdapter.getCount() + ")");
                        break;
                    case 1:
                        break;
                }
                return false;
            }
        });

    }

    private void initRefresh() {
        srlHome.setColorSchemeResources(R.color.colorPrimary);    //设置箭头颜色
        srlHome.setSize(SwipeRefreshLayout.DEFAULT);       //设置整个下拉圆环的大小
        srlHome.setProgressBackgroundColor(R.color.colorWhite);    //设置圆环背景颜色
        srlHome.setProgressViewEndTarget(true, 200);   //设置下拉悬浮窗口的高度
        //设置刷新监听
        srlHome.setOnRefreshListener(this);

        lvHome.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //记录手指按下的位置
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //记录手指当前位置
                        float moveX = event.getX();
                        float moveY = event.getY();
                        float distanceX = Math.abs(moveX - startX);
                        float distanceY = Math.abs(moveY - startY);
                        //如果Y大于X，事件自己处理
                        if (distanceX > distanceY) {
                            srlHome.setEnabled(false);
                        } else {
                            srlHome.setEnabled(true);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        srlHome.setEnabled(true);
                        break;
                }
                return false;
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        //获取客户列表
        //mPresenter.GetClientMsgList(App.cardNo, "0", "2", "");
        mPresenter.getNewShouyeData(App.cardNo, "");
    }


    @Override
    protected GetClientMsgListPresenter onCreatePresenter() {
        return new GetClientMsgListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        onclick();
        return rootView;
    }

    public void onclick() {
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                GetNewShouyeInfo.BodyBean.DataListBean info = listadd.get(position);
//                int kehubaseid = info.getKeHuBaseID();
//                String state = info.getState();


                pos = position;
//                intent.putExtra(Constants.ACTION_TO_MSGECLIENTINFO_KEHUBASE_ID, kehubaseid);
//                intent.putExtra(Constants.ACTION_TO_MSGECLIENTINFO_STATE, state);
                if (info.getZhuangTaiID() == 2) {
                    Intent intent = new Intent(getActivity(), ProjectInfoActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO", info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                } else if (info.getZhuangTaiID() == 4) {
                    Intent intent = new Intent(getActivity(), ProjectDaHuiActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO", info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                } else if (info.getZhuangTaiID() == 3) {
                    Intent intent = new Intent(getActivity(), ZhijianBaogaoActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO", info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                } else if (info.getZhuangTaiID() == 1) {
                    Intent intent = new Intent(getActivity(), PinggujiageActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO", info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                }


            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE);
            }
        });

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE && resultCode == Constants.ACTION_TO_HOMEFRAGMENT_RESULTCODE) {
//            GetClientMsgList.Body info = (GetClientMsgList.Body) data.getSerializableExtra(Constants.ACTION_TO_HOMEFRAGMENT_BODYINFO);
//            listadd.add(0, info);
//            mAdapter.notifyDataSetChanged();
//            tv.setText("(" + mAdapter.getCount() + ")");
//        } else if (requestCode == Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2 && resultCode == Constants.ACTION_TO_HOMEFRAGMENT_RESULTCODE2) {
//            String clientname = data.getStringExtra(Constants.clientname);
//            String clientstate = data.getStringExtra(Constants.clientstatus);
//            listadd.get(pos).setXingMing(clientname);
//
//
//            if (clientstate.equals("0")) {
//                listadd.get(pos).setState("0");
//                listadd.get(pos).setStateName("在跟踪");
//            }
//            if (clientstate.equals("17")) {
//                listadd.get(pos).setState("1");
//                listadd.get(pos).setStateName("待交易");
//            }
//            mAdapter.notifyDataSetChanged();
//        }
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_add, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
//                if (App.baseInfo.getBankCard() == null) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                    builder.setTitle("提示");
//                    builder.setMessage("您还未添加银行卡，请添加银行卡");
//                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Intent intent = new Intent(getActivity(), AddBankCardActivity.class);
//                            startActivity(intent);
//                        }
//                    });
//                    builder.setNegativeButton("取消", null);
//                    builder.show();
//                } else {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE);
//                }
                break;
            case R.id.iv_search:
                break;
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void GetClientMsgList(List<GetClientMsgList.Body> data) {
//        initClientData(data);
//        //停止刷新
//        srlHome.setRefreshing(false);
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void GetClientMsgListerror(String msg) {
//        showToast(msg);
//        //停止刷新
//        srlHome.setRefreshing(false);
    }

    @Override
    public void onPause() {
        super.onPause();
      banner.stop();
    }

    @Override
    public void GetNewShouyeData(GetNewShouyeInfo.BodyBean data) {

        if (data.getDataList().size() == 0) {
            ll_add.setVisibility(View.VISIBLE);
        } else {
            ll_add.setVisibility(View.GONE);
        }
        listadd.clear();
        listadd.addAll(data.getDataList());
        tv.setText("(" + mAdapter.getCount() + ")");
        mAdapter.notifyDataSetChanged();

        listBanner.clear();
        listBanner.addAll(data.getDataTotal());
        if (mBannerAdapter==null) {
            mBannerAdapter = new MyBannerAdapter(listBanner);
            banner.setAdapter(mBannerAdapter);
        }
        banner.start();


        //停止刷新
        srlHome.setRefreshing(false);


    }

    @Override
    public void GetNewShouyeDataError(String msg) {
        showToast(msg);
        //停止刷新
        srlHome.setRefreshing(false);
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
    public void onRefresh() {
        //获取客户列表
        //mPresenter.GetClientMsgList(App.cardNo, "0", "2", "");
        mPresenter.getNewShouyeData(App.cardNo, "");
    }
}
