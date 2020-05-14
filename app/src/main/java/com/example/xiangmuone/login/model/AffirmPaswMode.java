package com.example.xiangmuone.login.model;

import android.util.Log;

import com.example.xiangmuone.login.contract.AffirmPassWordContract;
import com.example.xiangmuone.net.INetCallBack;
import com.example.xiangmuone.net.NetWorkFactory;
import com.example.xiangmuone.net.ParamsUtils;
import com.example.xiangmuone.net.api.URLConstants;

import java.util.HashMap;

public class AffirmPaswMode implements AffirmPassWordContract.IAffirmPaswMode {
    @Override
    public <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",mobile);
        commonParams.put("sms_code",sms_code);
        commonParams.put("password",password);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.FORGET_PW,commonParams,iNetCallBack);

    }
}
