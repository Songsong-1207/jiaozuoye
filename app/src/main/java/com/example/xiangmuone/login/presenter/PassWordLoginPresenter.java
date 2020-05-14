package com.example.xiangmuone.login.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.login.contract.PassWordLoginContract;
import com.example.xiangmuone.login.model.PassWordLoginModel;
import com.example.xiangmuone.net.INetCallBack;

public class PassWordLoginPresenter extends BasePresenter<PassWordLoginContract.IPassWordLoginView> implements PassWordLoginContract.IPassWordLoginPresenter {
    private PassWordLoginContract.IPassWordLoginMode iPassWordLoginMode;
    public PassWordLoginPresenter() {
        iPassWordLoginMode=new PassWordLoginModel();
    }

    @Override
    public void passWordLogin(String username, String password) {
        iPassWordLoginMode.passWordLogin(username, password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {
                mview.getPWLoginResult(affirmRegisterBean);
            }

            @Override
            public void onError(Throwable throwable) {
//                这里去通知V层刷新失败得结果
            }
        });
    }
}
