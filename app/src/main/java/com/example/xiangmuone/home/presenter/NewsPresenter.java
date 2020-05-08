package com.example.xiangmuone.home.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.home.bean.NewsBean;
import com.example.xiangmuone.home.contract.NewsFragmentContract;
import com.example.xiangmuone.home.contract.RecommendContract;
import com.example.xiangmuone.home.model.NewsModel;
import com.example.xiangmuone.net.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
    private NewsFragmentContract.INewsMode iNewsMode;

    @Override
    public void getColumList() {

    }

    public NewsPresenter() {

        iNewsMode = new NewsModel();

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mview.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


    }
}
