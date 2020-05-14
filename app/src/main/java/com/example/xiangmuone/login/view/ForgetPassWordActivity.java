package com.example.xiangmuone.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiangmuone.R;
import com.example.xiangmuone.base.BaseActivity;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.ForgetPWContract;
import com.example.xiangmuone.login.presenter.ForgetPWPresenter;

public class ForgetPassWordActivity extends BaseActivity<ForgetPWPresenter> implements ForgetPWContract.IForgetPWView {

    private String phoneNum;
    private EditText cell_phone_num;
    private EditText import_verified;//输入验证码
    private TextView verified_get;//获取验证码
    private Button next_but;
    private String verified_str;

    @Override
    protected ForgetPWPresenter initPresenter() {
        return new ForgetPWPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");
        //手机号
        cell_phone_num=findViewById(R.id.cell_phone_num);
        import_verified=findViewById(R.id.import_verified);
        verified_get=findViewById(R.id.verified_get);
        next_but=findViewById(R.id.next_but);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        next_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verified_str = import_verified.getText().toString();
                if (!TextUtils.isEmpty(verified_str)&& !TextUtils.isEmpty(verified_str)){
mPresenter.checkSmsCode(phoneNum, verified_str,"2");
                }else{
                    Toast.makeText(ForgetPassWordActivity.this, "手机号验证码不正确", Toast.LENGTH_SHORT).show();

                }
            }
        });
        //发送验证码
        verified_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getVerified(phoneNum,"2");
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_forgetpassword;
    }

    @Override
    public void getVerified(VerfiedBean s) {
        if (s.getCode()==1){
            Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {
        if (verfiedBean.getCode()==1){
//            成功跳转页面
            Intent intent = new Intent(ForgetPassWordActivity.this, AffirmPassWordActivity.class);
            intent.putExtra("phoneNum",phoneNum);
            intent.putExtra("verified_str",verified_str);
            startActivity(intent);
        }
    }
}
