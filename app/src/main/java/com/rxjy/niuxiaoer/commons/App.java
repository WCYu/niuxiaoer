package com.rxjy.niuxiaoer.commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.GetNewZDPrice;
import com.rxjy.niuxiaoer.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public class App extends Application {
    public static int backbs=0;
    private static App app;
    public static int daojishi=0;
    public static int codelogindaojishi=0;
    private List<Activity> activities;
    public static Context context;
    public static List<GetNewZDPrice.BodyBean> bodyBean;
    public static String danhao;
    public static String token;
    public static String cardNo;
    public static String phone;
    //GetClientMsgOne数据存储
    public static GetClientMsgList.Body body;
    public static int danhaobs=-1;

    public static UserInfo.User.BaseInfo baseInfo;
    public static UserInfo.User.PersonnelInfo personnelInfo;


    public static String city;
    public static String district;
    public static String street;

    public static double latitude;
    public static double longitude;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化异常处理
        app = this;
        activities = new ArrayList<>();
        //初始化屏幕适配
    }

    public static Application getApplication() {
        return app;
    }

    public static App getApp() {
        return app;
    }

    public static Context getContext() {
        return getApp().getApplicationContext();
    }

    //获取版本号
    public static String getVersionCode() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            return String.valueOf(info.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //获取版本名称
    public static String getVersionName() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public App addActivity(Activity activity) {
        activities.add(activity);
        return app;
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    private void killActivity(Activity ac) {
        if (ac != null) {
            ac.finish();
        }
    }

    public void exitApp() {
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            killActivity(activities.get(i));
        }
    }
}
