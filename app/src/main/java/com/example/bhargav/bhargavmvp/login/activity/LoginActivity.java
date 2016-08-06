package com.example.bhargav.bhargavmvp.login.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.bhargav.bhargavmvp.R;
import com.example.bhargav.bhargavmvp.login.presenter.LoginPresenterImpl;
import com.example.bhargav.bhargavmvp.login.view.ILoginView;

public class LoginActivity extends Activity implements ILoginView, View
        .OnClickListener {

    EditText edtUsername;
    EditText edtPassword;

    ProgressBar progressBar;
    Button btnSignIn;


    LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mapUiComponents();

        btnSignIn.setOnClickListener(this);
    }

    private void mapUiComponents() {
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsernameError() {
        edtUsername.setError("Username cannot be empty");
    }

    @Override
    public void showPasswordError() {
        edtPassword.setError("Password cannot be empty");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSignIn:

                loginPresenter = new LoginPresenterImpl(this);
                loginPresenter.validateCredentials(edtUsername.getText()
                        .toString().trim(), edtPassword.getText().toString()
                        .trim());

                break;
        }
    }
}
