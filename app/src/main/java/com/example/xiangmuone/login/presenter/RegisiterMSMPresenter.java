package com.example.xiangmuone.login.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.RegisterMSMContract;
import com.example.xiangmuone.login.model.RegisiterMSMModel;
import com.example.xiangmuone.net.INetCallBack;

public class RegisiterMSMPresenter extends BasePresenter<RegisterMSMContract.IRegisterMSMView> implements RegisterMSMContract.IRegisterMSMPresenter {
    private RegisterMSMContract.IRegisterMSMMode iRegisterMSMMode;

    public RegisiterMSMPresenter() {
        iRegisterMSMMode = new RegisiterMSMModel();
    }


    @Override
    public void getVerifend(String string, String type) {
        iRegisterMSMMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.getVeridied(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        iRegisterMSMMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
