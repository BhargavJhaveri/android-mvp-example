package com.example.bhargav.bhargavmvp.login.model;

import android.os.Handler;

import com.example.bhargav.bhargavmvp.login.listeners.OnLoginFinishedListener;

/**
 * Created by bhargav on 8/5/16.
 */
public class LoginInteractorImpl implements ILoginInteractor {

    @Override
    public void authenticate(final String username, final String password,
                             final OnLoginFinishedListener onLoginFinishedListener) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(username.equals("bhargav_jhaveri") && password.equals
                        ("bhargav@123")) {
                    onLoginFinishedListener.success();
                } else {
                    onLoginFinishedListener.failure();
                }


            }
        }, 2000);
    }
}
