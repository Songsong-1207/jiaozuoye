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
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.login.contract.PassWordLoginContract;
import com.example.xiangmuone.login.presenter.PassWordLoginPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassWordLoginActivity extends BaseActivity<PassWordLoginPresenter> implements PassWordLoginContract.IPassWordLoginView {
    private EditText cell_phone_num;
    private EditText import_pass;
    private TextView forget_pass;
    private Button pass_login;
    private TextView verified_login;
    private TextView go_register;

    @Override
    protected PassWordLoginPresenter initPresenter() {
        return new PassWordLoginPresenter();
    }

    @Override
    public void initView() {
        cell_phone_num=findViewById(R.id.cell_phone_num);
        import_pass=findViewById(R.id.import_pass);
        //忘记密码
        forget_pass=findViewById(R.id.forget_pass);
        //登录按钮
        pass_login=findViewById(R.id.pass_login);
        //验证码登录
        verified_login=findViewById(R.id.verified_login);
        //跳转注册
        go_register=findViewById(R.id.go_register);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        //忘记密码
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass_str = import_pass.getText().toString();
                if (!TextUtils.isEmpty(pass_str)&& isMobileNO(pass_str)){
                    Intent intent = new Intent(PassWordLoginActivity.this, ForgetPassWordActivity.class);
                    intent.putExtra("phoneNum",pass_str);
                    startActivity(intent);
                }
            }
        });
        //登录按钮
        pass_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_str = cell_phone_num.getText().toString();
                String pass_str = import_pass.getText().toString();
                if (!TextUtils.isEmpty(phone_str) && !TextUtils.isEmpty(pass_str)){
                    //手机号是不是正确
                    if (isMobileNO(phone_str)){
                        mPresenter.passWordLogin(phone_str,pass_str);
                    }else{
                        Toast.makeText(PassWordLoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(PassWordLoginActivity.this, "手机号和密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //验证码登录
        verified_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_pass_word_login;
    }

    @Override
    public void getPWLoginResult(AffirmRegisterBean string) {
        if (string.getCode()==1){

        }else Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
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
}
