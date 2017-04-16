package com.example.kshitij.mvpexample.login;

/**
 * Created by kshitij on 16/04/17.
 */

public interface LoginInteractor {

    interface onLoginFinishedListener{

        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);

    }

    void login(String username,String password,onLoginFinishedListener listener);

}
