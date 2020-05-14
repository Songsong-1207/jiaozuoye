package com.example.xiangmuone.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiangmuone.R;
import com.example.xiangmuone.base.BaseActivity;
import com.example.xiangmuone.home.view.HomeActivity;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.LoginContract;
import com.example.xiangmuone.login.presenter.LoginPresenter;
import com.tencent.mmkv.MMKV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {

    private EditText phone_num;
    private EditText vdeified;
    private TextView send_vdeified;
    private Button login_but;
    private TextView pass_login;
    private TextView login_to_reg;


    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
        phone_num = findViewById(R.id.cell_phone_number);
        vdeified = findViewById(R.id.import_verification);
        send_vdeified = findViewById(R.id.verification);
        login_but = findViewById(R.id.verification_login);
        pass_login = findViewById(R.id.pass_login);
        login_to_reg = findViewById(R.id.login_to_reg);

    }

    @Override
    public void initData() {

    }

    private String edit_phone_num;
    private String edit_sms_code;

    @Override
    public void initLinstener() {
        pass_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login_to_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterMSMCodeActivity.class);
                startActivity(intent);
            }
        });
        //发送验证码
        send_vdeified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //手机号是否为空//判断手机号是否正确
                String phone = phone_num.getText().toString();
                if (!TextUtils.isEmpty(phone) && isMobileNO(phone)) {
                    //发送验证码  type 4表示登录发送验证码
                    mPresenter.getVerifend(phone, "4");
                } else {
                    Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //登录
        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_phone_num = phone_num.getText().toString();
                edit_sms_code = vdeified.getText().toString();
//                String  =vdeified.getText().toString();
                if (!TextUtils.isEmpty(edit_phone_num) && isMobileNO(edit_phone_num)) {
                    if (!TextUtils.isEmpty(edit_sms_code)) {
                        //是否为6位,并且是数字
                        Pattern pattern = Pattern.compile("\\d{6}");
                        boolean matches = pattern.matcher(edit_sms_code).matches();
                        if (matches) {
                            Log.i("TAG", "onClick: 验证码值" + edit_sms_code);
                            //提交到服务器
                            mPresenter.checkSmsCode(edit_phone_num, edit_sms_code, "4");
                        } else
                            Toast.makeText(LoginActivity.this, "验证码只能是6位", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(LoginActivity.this, "输入验证码", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    //手机验证码工具类
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        } catch (Exception e) {
//            LOG.error("验证手机号码错误", e);
            Log.e("TAG", "手机号错误" + e.getMessage());
            flag = false;
        }
        return flag;
    }

    @Override
    public void getVeridied(VerfiedBean s) {
        if (s.getCode() == 1) {
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void getLoginResylt(AffirmRegisterBean affirmRegisterBean) {
        if (null != affirmRegisterBean.getData().getToken().getValue() && affirmRegisterBean.getData().getToken().getValue() != "") {
            MMKV mmkv = MMKV.defaultMMKV();
            mmkv.encode("token", affirmRegisterBean.getData().getToken().getValue());
            mmkv.encode("expire_time", affirmRegisterBean.getData().getToken().getExpire_time());
            mmkv.encode("head_url", affirmRegisterBean.getData().getUser_info().getHead_url());
            mmkv.encode("nickname", affirmRegisterBean.getData().getUser_info().getNickname());
            mmkv.encode("mobile", affirmRegisterBean.getData().getUser_info().getMobile());
            Toast.makeText(this, "登陆成功跳转HomeActivity", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
    }

    //验证码时候
    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {
        if (verfiedBean.getCode() == 1) {
            mPresenter.login(edit_phone_num, edit_sms_code);
        } else Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
    }

//    public void startRegis(View view) {
//        Intent intent = new Intent(LoginActivity.this, RegisterMSMCodeActivity.class);
//        startActivity(intent);
//    }
}
