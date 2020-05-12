package com.example.xiangmuone.login.model;

import android.util.Log;

import com.example.xiangmuone.login.contract.AffirmContart;
import com.example.xiangmuone.net.INetCallBack;
import com.example.xiangmuone.net.NetWorkFactory;
import com.example.xiangmuone.net.ParamsUtils;
import com.example.xiangmuone.net.api.URLConstants;

import java.util.HashMap;

public class AffirmRegisterModel implements AffirmContart.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("password",password);
        commonParams.put("affirm_password",affirm_password);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.USERREGISTER,commonParams,iNetCallBack);

    }
}
