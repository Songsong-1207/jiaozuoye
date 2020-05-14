package com.example.xiangmuone.login.model;

import android.util.Log;

import com.example.xiangmuone.login.contract.PassWordLoginContract;
import com.example.xiangmuone.net.INetCallBack;
import com.example.xiangmuone.net.NetWorkFactory;
import com.example.xiangmuone.net.ParamsUtils;
import com.example.xiangmuone.net.api.URLConstants;

import java.util.HashMap;

public class PassWordLoginModel implements PassWordLoginContract.IPassWordLoginMode {
    @Override
    public <T> void passWordLogin(String username, String password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("username",username);
        commonParams.put("password",password);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.PHONEPAWORD_LOGIN,commonParams,iNetCallBack);

    }
}
