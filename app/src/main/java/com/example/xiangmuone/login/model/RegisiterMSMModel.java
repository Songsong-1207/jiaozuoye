package com.example.xiangmuone.login.model;

import android.util.Log;

import com.example.xiangmuone.login.contract.RegisterMSMContract;
import com.example.xiangmuone.net.INetCallBack;
import com.example.xiangmuone.net.NetWorkFactory;
import com.example.xiangmuone.net.ParamsUtils;
import com.example.xiangmuone.net.api.URLConstants;

import java.util.HashMap;

public class RegisiterMSMModel implements RegisterMSMContract.IRegisterMSMMode {
    @Override
    public <T> void getVerified(String phonemub, String type, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phonemub);
        commonParams.put("type",type);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.SENDVERIFED,commonParams,iNetCallBack);

    }

    @Override
    public <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);
        commonParams.put("sms_code",smsCode);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.CHECKMSCODE,commonParams,iNetCallBack);

    }
}
