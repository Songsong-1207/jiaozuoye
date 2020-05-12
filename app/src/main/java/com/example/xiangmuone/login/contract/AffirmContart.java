package com.example.xiangmuone.login.contract;


import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.net.INetCallBack;

public class AffirmContart {
    //    V层接口
    public interface IAffirmView extends BaseView {
        void registerResult(AffirmRegisterBean affirmRegisterBean);
    }

    //    model层接口
    public interface IAffirmMode {
        <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack);
    }

    //    p层接口
    public interface IAffirmPresenter {
        void register(String phoneNum, String password, String affirm_password);
    }
}
