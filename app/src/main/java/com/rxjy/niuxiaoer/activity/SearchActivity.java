package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.rxjy.niuxiaoer.ProjectInfoActivity;
import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.adapter.HomeAdapter;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.Constants;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.mvp.contract.GetClientMsgListContract;
import com.rxjy.niuxiaoer.mvp.presenter.GetClientMsgListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<GetClientMsgListPresenter> implements GetClientMsgListContract.View {

    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.tv_search_line)
    TextView tvSearchLine;
    @Bind(R.id.lv_search)
    ListView lvSearch;
    @Bind(R.id.tv_search_data_tip)
    TextView tvSearchDataTip;
    @Bind(R.id.rl_search_data_tip)
    RelativeLayout rlSearchDataTip;

    private List<GetNewShouyeInfo.BodyBean.DataListBean> clientList;

    private HomeAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {
        initLine();
        initSearchData();
    }

    private void initLine() {

        EditText[] etArray = new EditText[]{etSearch};
        TextView[] tvArray = new TextView[]{tvSearchLine};

        lineSelector(etArray, tvArray);
    }

    private void initSearchData() {
        clientList = new ArrayList<>();

        mAdapter = new HomeAdapter(this, clientList);

        lvSearch.setAdapter(mAdapter);

    }

    private void isShowTip() {
        if (clientList.size() != 0) {
            rlSearchDataTip.setVisibility(View.GONE);
        } else {
            rlSearchDataTip.setVisibility(View.VISIBLE);
            tvSearchDataTip.setText("没有搜索到相关内容！");
        }
    }

    @Override
    protected GetClientMsgListPresenter onCreatePresenter() {
        return new GetClientMsgListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        onclick();
    }
    private List<GetNewShouyeInfo.BodyBean> listadd;
    private void onclick() {
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                GetNewShouyeInfo.BodyBean.DataListBean info = clientList.get(position);
//                int kehubaseid = info.getKeHuBaseID();
//                String state = info.getState();


                //pos = position;
//                intent.putExtra(Constants.ACTION_TO_MSGECLIENTINFO_KEHUBASE_ID, kehubaseid);
//                intent.putExtra(Constants.ACTION_TO_MSGECLIENTINFO_STATE, state);
                if (info.getZhuangTaiID()==2) {
                    Intent intent = new Intent(SearchActivity.this, ProjectInfoActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO",info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                }else if (info.getZhuangTaiID()==4) {
                    Intent intent = new Intent(SearchActivity.this, ProjectDaHuiActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO",info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                }else if (info.getZhuangTaiID()==3) {
                    Intent intent = new Intent(SearchActivity.this, ZhijianBaogaoActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO",info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                }else if (info.getZhuangTaiID()==1) {
                    Intent intent = new Intent(SearchActivity.this, PinggujiageActivity.class);
                    intent.putExtra("GETNEWSHOUYEINFO",info);
                    startActivityForResult(intent, Constants.ACTION_TO_HOMEFRAGMENT_REQUESTCODE2);
                }



            }
        });


    }

    @OnClick({R.id.iv_back, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_search:
                String searchContent = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(searchContent)) {
                    showToast("请输入搜索内容");
                    return;
                }
                //mPresenter.GetClientMsgList(App.cardNo, "0", "2", etSearch.getText().toString());
                mPresenter.getNewShouyeData(App.cardNo,etSearch.getText().toString());
                break;
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void GetClientMsgList(List<GetClientMsgList.Body> body) {

    }
    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void GetClientMsgListerror(String msg) {
        showToast(msg);
    }

    @Override
    public void GetNewShouyeData(GetNewShouyeInfo.BodyBean info) {
        clientList.clear();
        clientList.addAll(info.getDataList());
        mAdapter.notifyDataSetChanged();
        isShowTip();
    }

    @Override
    public void GetNewShouyeDataError(String msg) {

    }

}
