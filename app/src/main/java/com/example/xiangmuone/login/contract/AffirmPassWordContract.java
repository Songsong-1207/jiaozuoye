package com.example.xiangmuone.login.contract;

import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.net.INetCallBack;

public class AffirmPassWordContract {


    public interface IAffirmPaswView extends BaseView {
        void registerResult(VerfiedBean bean);
    }
    public interface IAffirmPaswMode{
        <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack);
    }
    public interface IAffirmPaswPresenter{
        void forgetPasw(String mobile, String sms_code, String password);

    }
}
