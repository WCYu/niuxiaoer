package com.rxjy.niuxiaoer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rxjy.niuxiaoer.R;
import com.rxjy.niuxiaoer.fragment.GuideFourFragment;
import com.rxjy.niuxiaoer.fragment.GuideOneFragment;
import com.rxjy.niuxiaoer.fragment.GuideThreeFragment;
import com.rxjy.niuxiaoer.fragment.GuideTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuidePageActivity extends AppCompatActivity
{

    @Bind(R.id.vp_guide_page)
    ViewPager vpGuidePage;
    List<Fragment> fragmentlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        ButterKnife.bind(this);
        fragmentlist.add(new GuideOneFragment());
        fragmentlist.add(new GuideTwoFragment());
        fragmentlist.add(new GuideThreeFragment());
        fragmentlist.add(new GuideFourFragment());
        FragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpGuidePage.setAdapter(adapter);
        vpGuidePage.setCurrentItem(0);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm){
             super(fm);
        }
        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position)
        {
            return fragmentlist.get(position);
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount()
        {
            return fragmentlist.size();
        }
    }


}
