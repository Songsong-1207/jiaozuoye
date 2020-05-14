package com.example.xiangmuone.home.contract;

import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.home.bean.NewsBean;
import com.example.xiangmuone.net.INetCallBack;

public class NewsFragmentContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}