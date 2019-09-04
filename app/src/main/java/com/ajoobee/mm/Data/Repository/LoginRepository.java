package com.ajoobee.mm.Data.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ajoobee.mm.Data.Database.UserDao;
import com.ajoobee.mm.Data.Network.Response.ServerReturn;
import com.ajoobee.mm.Data.Network.Retrofit.ServiceApi;
import com.ajoobee.mm.Constants;
import com.ajoobee.mm.Data.Obj.Result;
import com.ajoobee.mm.UI.Login.LoginViewModel;
import com.ajoobee.mm.Util.Util;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class LoginRepository {
    private final ServiceApi serviceApi;
    String countryCode = "+95";
    String uid = "13";
    String loginType = "0";
    String smsFormat = "old_format";
    String name;
    MutableLiveData<ServerReturn> serverReturnLiveData;
    LoginViewModel loginViewModel;

    public static String TAG = "LoginRepository";

    @Inject
    public LoginRepository(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public void setListener(LoginViewModel repo){
        loginViewModel = repo;
    }

//    public LiveData<ServerReturn> callApiLogin(String name) {
//        this.name = name;
//        //if the livedata is null
//        /*if (serverReturnLiveData == null) {
//            serverReturnLiveData = new MutableLiveData<ServerReturn>();
//            //we will load it asynchronously from server in this method
//            Api_Login();
//        }*/
//
//        serverReturnLiveData = new MutableLiveData<ServerReturn>();
//        Api_Login();
//            //finally we will return the list
//        return serverReturnLiveData;
//    }
//
//    //cal rest service
//    public void Api_Login(){
//        String authID = Constants.authId;
//        String uToken = Constants.accessToken;
//        Call<ServerReturn> call = serviceApi.loginAPI(authID, uToken,countryCode,name,uid,loginType,smsFormat);
//        call.enqueue(new Callback<ServerReturn>() {
//            @Override
//            public void onResponse(Call<ServerReturn> call, Response<ServerReturn> response) {
//                Util.Log(TAG,"api_login server_return " + new Gson().toJson(response.body()));
//                serverReturnLiveData.setValue(response.body());
//
//            }
//
//            @Override
//            public void onFailure(Call<ServerReturn> call, Throwable t) {
//                Util.Log(TAG,"api_login server_return " + new Gson().toJson(t.getMessage()));
//                ServerReturn serverReturn = new ServerReturn(data);
//                serverReturn.setStatus("fail");
//                serverReturn.setDescription("Internet connection fail");
//                serverReturnLiveData.setValue(serverReturn);
//            }
//        });
//
//
//    }

//    public LiveData<Result> getLoginInfo(String userName, String password)
//    {
//
//    }

    interface apiLoginStatus{
        void loginFailListener(boolean status);
        void loginSuccessListener(boolean status);
    }

}
