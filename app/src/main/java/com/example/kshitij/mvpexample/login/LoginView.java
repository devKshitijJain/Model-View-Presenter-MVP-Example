package com.example.kshitij.mvpexample.login;

/**
 * Created by kshitij on 16/04/17.
 */

public interface LoginView {

    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigatetoMain();
    void showAlert(String message);

}
