package com.ajoobee.mm.UI.Login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.ajoobee.mm.Data.Repository.LoginRepository;
import com.ajoobee.mm.UI.Listener.LoginListener;
import com.ajoobee.mm.Data.Network.Response.ServerReturn;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    private LiveData<ServerReturn> serverReturnLiveData;
    private LoginRepository loginRepository;
    public static String TAG = "LoginViewModel";

    LoginListener loginListener;
    public String email;
    public String password;

    //inject LoginRepository
    @Inject
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LiveData<ServerReturn> Api_Login(String name){
        //callApiLoing should return success or fail
        //if success with data
        //if fail error message
        if(name.isEmpty()){
            loginListener.fail();
        }
//        serverReturnLiveData = loginRepository.callApiLogin(name);
        return serverReturnLiveData;
    }

    public void setLoginActivity(LoginListener act){
        loginListener = act;
    }

    public void btnLoginOnClick(View view){

    }


}
