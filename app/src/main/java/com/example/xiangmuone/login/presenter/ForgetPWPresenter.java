package com.example.xiangmuone.login.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.ForgetPWContract;
import com.example.xiangmuone.login.model.ForgetPWModel;
import com.example.xiangmuone.net.INetCallBack;

public class ForgetPWPresenter extends BasePresenter<ForgetPWContract.IForgetPWView> implements ForgetPWContract.IForgetPWPresenter {

    private ForgetPWContract.IForgetPWMode iForgetPWMode;

    public ForgetPWPresenter() {
        iForgetPWMode = new ForgetPWModel();
    }

    @Override
    public void  getVerified(String string, String type) {

        iForgetPWMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.getVerified(verfiedBean);
            }
            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

        iForgetPWMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {

                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {
//当前方法没有使用，需要刷新V层
            }
        });

    }
}
