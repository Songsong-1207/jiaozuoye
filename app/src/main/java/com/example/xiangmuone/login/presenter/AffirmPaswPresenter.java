package com.example.xiangmuone.login.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.AffirmPassWordContract;
import com.example.xiangmuone.login.model.AffirmPaswMode;
import com.example.xiangmuone.net.INetCallBack;

public class AffirmPaswPresenter extends BasePresenter<AffirmPassWordContract.IAffirmPaswView> implements AffirmPassWordContract.IAffirmPaswPresenter {
    private AffirmPassWordContract.IAffirmPaswMode iAffirmPaswMode;
    public AffirmPaswPresenter() {
        iAffirmPaswMode=new AffirmPaswMode();
    }



    @Override
    public void forgetPasw(String mobile, String sms, String password) {
        iAffirmPaswMode.forgetPasw(mobile, sms, password, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.registerResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
