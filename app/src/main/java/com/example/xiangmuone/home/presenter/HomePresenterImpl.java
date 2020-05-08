package com.example.xiangmuone.home.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.home.bean.User;
import com.example.xiangmuone.home.contract.HomeContract;
import com.example.xiangmuone.home.model.HomeModelImpl;
import com.example.xiangmuone.home.view.HomeActivity;
import com.example.xiangmuone.net.INetCallBack;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeMode  iHomeMode;
//    private HomeContract.IHomeView iHomeView;

    public HomePresenterImpl() {
        iHomeMode = new HomeModelImpl(this);
    }
    @Override
    public void callHomeBannview(String string) {
//        P层中拿到数据
        mview.setBannView(string);
    }
    @Override
    public void getBannerView() {
        iHomeMode.getHomeBannview(new INetCallBack<User>() {
            @Override
            public void onSuccess(User user) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getHomeTabList() {

    }
}
