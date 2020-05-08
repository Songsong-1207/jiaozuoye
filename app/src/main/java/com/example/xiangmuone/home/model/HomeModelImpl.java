package com.example.xiangmuone.home.model;

import com.example.xiangmuone.base.BaseModel;
import com.example.xiangmuone.home.contract.HomeContract;
import com.example.xiangmuone.net.INetCallBack;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeMode {

    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public <T> void getHomeBannview(INetCallBack<T> netCallBack) {
    }

    @Override
    public <T> void getHomeTabList(INetCallBack<T> iNetCallBack) {
    }
}