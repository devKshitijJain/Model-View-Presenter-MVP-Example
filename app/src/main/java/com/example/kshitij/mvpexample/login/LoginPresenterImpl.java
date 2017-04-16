package com.example.kshitij.mvpexample.login;

/**
 * Created by kshitij on 16/04/17.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor=new LoginInteractorImpl();
    }

    @Override
    public void validateCred(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginInteractor.login(username,password,this);
        }

    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView=null;
        }
    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.navigatetoMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
