package com.example.xiangmuone.login.presenter;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.login.contract.AffirmContart;
import com.example.xiangmuone.login.model.AffirmRegisterModel;
import com.example.xiangmuone.net.INetCallBack;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContart.IAffirmView> implements AffirmContart.IAffirmPresenter{
    private AffirmContart.IAffirmMode iAffirmMode;

    public AffirmRegisterPresenter() {
        iAffirmMode = new AffirmRegisterModel();
    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {
        iAffirmMode.register(phoneNum, password, affirm_password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {
                mview.registerResult(affirmRegisterBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
