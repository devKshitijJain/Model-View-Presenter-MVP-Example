package com.example.kshitij.mvpexample.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kshitij.mvpexample.MainActivity;
import com.example.kshitij.mvpexample.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText edUserName,edPassword;
    private Button btnDone;
    private ProgressBar pbLoad;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenter=new LoginPresenterImpl(this);

        edUserName= (EditText) findViewById(R.id.ed_user_name);
        edPassword= (EditText) findViewById(R.id.ed_password);
        btnDone= (Button) findViewById(R.id.btn_done);
        pbLoad= (ProgressBar) findViewById(R.id.pb_load);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validateCred(edUserName.getText().toString().trim(),edPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
            pbLoad.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        edUserName.setError("UserName Empty");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password Empty");
    }

    @Override
    public void navigatetoMain() {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
