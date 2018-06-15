package com.rxjy.niuxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.commons.App;
import com.rxjy.niuxiaoer.commons.base.BaseActivity;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;

import butterknife.Bind;

public class PinggujiageActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_zjbg_price)
    TextView tvZjbgPrice;
    @Bind(R.id.iv_xmxx_one)
    ImageView ivXmxxOne;
    @Bind(R.id.ll_xmxx_one)
    LinearLayout llXmxxOne;
    @Bind(R.id.tv_xmxx_one)
    TextView tvXmxxOne;
    @Bind(R.id.iv_xmxx_two)
    ImageView ivXmxxTwo;
    @Bind(R.id.ll_xmxx_two)
    LinearLayout llXmxxTwo;
    @Bind(R.id.tv_xmxx_two)
    TextView tvXmxxTwo;
    @Bind(R.id.iv_xmxx_three)
    ImageView ivXmxxThree;
    @Bind(R.id.ll_xmxx_three)
    LinearLayout llXmxxThree;
    @Bind(R.id.tv_xmxx_three)
    TextView tvXmxxThree;
    @Bind(R.id.iv_xmxx_four)
    ImageView ivXmxxFour;
    @Bind(R.id.ll_xmxx_four)
    LinearLayout llXmxxFour;
    @Bind(R.id.tv_xmxx_four)
    TextView tvXmxxFour;
    @Bind(R.id.tv_area)
    TextView tvArea;
    @Bind(R.id.ll_chongxinxunjia)
    LinearLayout llChongxinxunjia;

    private int llonebs = 0;
    private int lltwobs = 0;
    private int llthreebs = 0;
    private int llfourbs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pinggujiage);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_pinggujiage;
    }

    @Override
    public void initData() {

        final GetNewShouyeInfo.BodyBean.DataListBean bodyBean = (GetNewShouyeInfo.BodyBean.DataListBean) getIntent().getSerializableExtra("GETNEWSHOUYEINFO");

        tvZjbgPrice.setText(bodyBean.getPingGuPrice()+"");
        tvArea.setText(App.personnelInfo.getArea());
        llChongxinxunjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PinggujiageActivity.this,PartAddActivity.class);
                intent.putExtra("DANHAO",bodyBean.getDanHao());
                App.danhaobs=1;
                startActivity(intent);
                finish();
            }
        });

        tvTitle.setText("评估价格");

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llXmxxOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llonebs == 0) {
                    tvXmxxOne.setVisibility(View.VISIBLE);
                    ivXmxxOne.setImageResource(R.mipmap.shouqi);
                    llonebs = 1;
                } else if (llonebs == 1) {
                    tvXmxxOne.setVisibility(View.GONE);
                    ivXmxxOne.setImageResource(R.mipmap.xiala);
                    llonebs = 0;
                }

            }
        });

        llXmxxTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lltwobs == 0) {
                    tvXmxxTwo.setVisibility(View.VISIBLE);
                    ivXmxxTwo.setImageResource(R.mipmap.shouqi);
                    lltwobs = 1;
                } else if (lltwobs == 1) {
                    tvXmxxTwo.setVisibility(View.GONE);
                    ivXmxxTwo.setImageResource(R.mipmap.xiala);
                    lltwobs = 0;
                }
            }
        });

        llXmxxThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llthreebs == 0) {
                    tvXmxxThree.setVisibility(View.VISIBLE);
                    ivXmxxThree.setImageResource(R.mipmap.shouqi);
                    llthreebs = 1;
                } else if (llthreebs == 1) {
                    tvXmxxThree.setVisibility(View.GONE);
                    ivXmxxThree.setImageResource(R.mipmap.xiala);
                    llthreebs = 0;
                }

            }
        });

        llXmxxFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llfourbs == 0) {
                    tvXmxxFour.setVisibility(View.VISIBLE);
                    ivXmxxFour.setImageResource(R.mipmap.shouqi);
                    llfourbs = 1;
                } else if (llfourbs == 1) {
                    tvXmxxFour.setVisibility(View.GONE);
                    ivXmxxFour.setImageResource(R.mipmap.xiala);
                    llfourbs = 0;
                }
            }
        });


    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
