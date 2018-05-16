package com.example.rohangoyal2014.mvp_login.model;

import android.text.TextUtils;

import com.example.rohangoyal2014.mvp_login.presenter.LoginPresenter;
import com.example.rohangoyal2014.mvp_login.view.LoginView;

public class LoginModel implements LoginPresenter{

    LoginView mLoginView;

    @Override
    public void performLogin(String mail, String pass) {
        if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
            mLoginView.loginValidation();
        } else if (mail.equals("admin") && pass.equals("admin")){
            mLoginView.loginSuccess();
        } else {
            mLoginView.loginError();
        }
    }

    public LoginModel(LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }
}
