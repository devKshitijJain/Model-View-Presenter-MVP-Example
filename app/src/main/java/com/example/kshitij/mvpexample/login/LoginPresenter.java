package com.example.kshitij.mvpexample.login;

/**
 * Created by kshitij on 16/04/17.
 */

public interface LoginPresenter {

    void validateCred(String username,String password);
    void onDestroy();
}
