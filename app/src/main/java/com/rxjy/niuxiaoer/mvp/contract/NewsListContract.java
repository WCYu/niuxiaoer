package com.rxjy.niuxiaoer.mvp.contract;


import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.NewsListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Lei on 2017/6/12.
 */
public interface NewsListContract {

    interface View extends BaseView {

        void responseNewsListData(List<NewsListInfo.NewsList.NewsInfo> dataList);

        void responseNewsListDataError(String msg);

        void responseNewsListLoadMoreData(List<NewsListInfo.NewsList.NewsInfo> dataList);

        void responseNewsListLoadMoreDataError(String msg);

        void responseBannerData(List<NewsListInfo.NewsList.BannerInfo> dataList);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getNewsList(
                String cardNo,
                int pageIndex,
                int pageSize
        );

        Observable<String> getNewsListLoadMore(
                String cardNo,
                int pageIndex,
                int pageSize
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsList(
                String cardNo,
                int pageIndex,
                int pageSize
        );

        public abstract void getNewsListLoadMore(
                String cardNo,
                int pageIndex,
                int pageSize
        );

    }

}
