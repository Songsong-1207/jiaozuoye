package com.example.xiangmuone.login.contract;

import com.example.xiangmuone.base.BaseView;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.net.INetCallBack;

public class PassWordLoginContract {

        public interface IPassWordLoginView extends BaseView {
            void  getPWLoginResult(AffirmRegisterBean string);
        }
        public interface IPassWordLoginMode{
            <T> void passWordLogin(String username, String password, INetCallBack<T> iNetCallBack);
        }
        public interface IPassWordLoginPresenter{
            void passWordLogin(String username, String password);
        }
}
