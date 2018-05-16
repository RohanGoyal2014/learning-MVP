package com.example.rohangoyal2014.mvp_login.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rohangoyal2014.mvp_login.R;
import com.example.rohangoyal2014.mvp_login.model.LoginModel;
import com.example.rohangoyal2014.mvp_login.presenter.LoginPresenter;
import com.example.rohangoyal2014.mvp_login.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText email,pass;
    Button login;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginPresenter=new LoginModel(this);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String password=pass.getText().toString().trim();
                mLoginPresenter.performLogin(mail,password);
            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Not Validated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }
}
