package com.example.xiangmuone.home.model;

import android.util.Log;
import com.example.xiangmuone.home.contract.RecommendContract;
import com.example.xiangmuone.net.INetCallBack;
import com.example.xiangmuone.net.NetWorkFactory;
import com.example.xiangmuone.net.ParamsUtils;
import com.example.xiangmuone.net.api.URLConstants;
import java.util.HashMap;

public class RecommendModel implements RecommendContract.IRecommendMode {

    @Override
    public <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack) {
    }

    @Override
    public <T> void getColumList(INetCallBack<T> iNetCallBack) {

        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
//        commonParams.put("token","");

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().get(URLConstants.COLUM_LIST,commonParams,iNetCallBack);


    }
}