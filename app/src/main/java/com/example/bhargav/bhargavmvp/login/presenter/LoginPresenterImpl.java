package com.example.bhargav.bhargavmvp.login.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.bhargav.bhargavmvp.login.listeners.OnLoginFinishedListener;
import com.example.bhargav.bhargavmvp.login.model.ILoginInteractor;
import com.example.bhargav.bhargavmvp.login.model.LoginInteractorImpl;
import com.example.bhargav.bhargavmvp.login.view.ILoginView;

/**
 * Created by bhargav on 8/5/16.
 */
public class LoginPresenterImpl implements ILoginPresenter, OnLoginFinishedListener {

    ILoginInteractor loginInteractor;
    ILoginView loginView;

    Context context;

    public LoginPresenterImpl(ILoginView loginView) {
        loginInteractor = new LoginInteractorImpl();
        this.loginView = loginView;
        this.context = (Context) loginView;
    }

    @Override
    public void validateCredentials(String username, String password) {

        if (null != loginView) {
            loginView.showProgress();
        }

        loginInteractor.authenticate(username, password, this);
    }

    @Override
    public void success() {
        Toast.makeText(context, "Successful Login", Toast.LENGTH_SHORT).show();
        loginView.hideProgress();
    }

    @Override
    public void failure() {
        loginView.hideProgress();
    }
}
