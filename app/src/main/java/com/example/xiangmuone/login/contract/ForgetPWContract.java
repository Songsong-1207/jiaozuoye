package com.example.xiangmuone.login.contract;

import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.net.INetCallBack;

public class ForgetPWContract {

        public interface IForgetPWView extends BaseView {
            void getVerified(VerfiedBean s);
            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface IForgetPWMode{
           <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

            <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
        }
        public interface IForgetPWPresenter{
            void getVerified(String string, String type);
            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
