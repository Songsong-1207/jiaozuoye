package com.example.xiangmuone.login.contract;

import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.net.INetCallBack;

//契约类
public class RegisterMSMContract {
    //    V层接口
    public interface IRegisterMSMView extends BaseView {
        void getVeridied(VerfiedBean s);
        void getLoginResylt(String string);
        void checkSmsCodeResult(VerfiedBean verfiedBean);
    }

    //    model层接口
    public interface IRegisterMSMMode {
        <T> void getVerified(String phonemub, String type, INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
    }

    //    p层接口
    public interface IRegisterMSMPresenter {
        void getVerifend(String string, String type);
        void checkSmsCode(String phoneNum, String smsCode, String type);
    }
}
