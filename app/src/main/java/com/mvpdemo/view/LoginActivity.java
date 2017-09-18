package com.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvpdemo.R;
import com.mvpdemo.presenter.ILoginPresenter;
import com.mvpdemo.presenter.LoginPresenterCompl;


public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText        etName;
    private EditText        etPassword;
    private Button          btnLogin;
    private Button          btnClear;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }
    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-04-06 21:12:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnClear = (Button) findViewById(R.id.btn_clear);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        loginPresenter = new LoginPresenterCompl(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-04-06 21:12:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        int id=v.getId();
        String name=etName.getText().toString();
        String password=etPassword.getText().toString();
        /*if ( v == btnLogin ) {
            loginPresenter.doLogin(name,password);
        } else if ( v == btnClear ) {
            loginPresenter.clear();
        }*/
        switch (id){
            case R.id.btn_login:
                loginPresenter.doLogin(name, password);
                break;
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
        }
    }



    @Override
    public void onClearText() {
        etName.setText("");
        etPassword.setText("");
        Toast.makeText(this,"clear",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if(result){
            Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
        }
    }
}
