package com.example.bhargav.bhargavmvp.login.model;

import com.example.bhargav.bhargavmvp.login.listeners.OnLoginFinishedListener;

/**
 * Created by bhargav on 8/5/16.
 */
public interface ILoginInteractor {

    void authenticate(String username, String password,
                      OnLoginFinishedListener onLoginFinishedListener);
}
