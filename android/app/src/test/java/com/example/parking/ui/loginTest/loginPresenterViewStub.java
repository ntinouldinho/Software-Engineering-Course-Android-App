package com.example.parking.ui.loginTest;
import android.os.Bundle;

import com.example.parking.ui.login.LoginView;

public class loginPresenterViewStub implements LoginView {
    String username,password,toast;

    public loginPresenterViewStub(){
        username = password = toast ="";
    }

    @Override
    public void moveOn() {

    }

    @Override
    public void createToast(String text) {
        toast = text;
    }

    public String getToast() {
        return toast;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username=username;
    }

    public void setPassword(String pass) {
        this.password=pass;
    }
    @Override
    public void signup() {

    }

}