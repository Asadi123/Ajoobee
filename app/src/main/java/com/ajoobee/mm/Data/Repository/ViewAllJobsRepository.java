package com.ajoobee.mm.Data.Repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.ajoobee.mm.Data.Network.Retrofit.ServiceApi;
import com.ajoobee.mm.Constants;
import com.ajoobee.mm.Util.Util;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ajoobee.mm.Data.Obj.VideoList;
import com.ajoobee.mm.Data.Obj.VideoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ViewAllJobsRepository {
    private final ServiceApi serviceApi;
    MutableLiveData<List<VideoModel>> lstVideoLive =  new MutableLiveData<>();
    int limit;
    String userId ;
    public static String TAG = "ViewAllJobsRepository";

    @Inject
    public ViewAllJobsRepository(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public MutableLiveData<List<VideoModel>> callJobListApi(String userId,int limit) {
        //if the livedata is null
        this.userId = userId;
        this.limit = limit;


        //if (lstVideoLive == null) {

            lstVideoLive = getlstVideoLive();
            //we will load it asynchronously from server in this method
        //}
            //finally we will return the list
        return lstVideoLive;
    }

    public MutableLiveData<List<VideoModel>> getlstVideoLive() {
        String authID = Constants.authId;
        String uToken = Constants.accessToken;
        Log.i(TAG,"api call ");

        Call<VideoList> call = serviceApi.getHomeVideos(authID, uToken,userId, String.valueOf(limit));
        call.enqueue(new Callback<VideoList>() {
            @Override
            public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                Util.Log(TAG,"api_login server_return " + new Gson().toJson(response.body()));
                List<VideoModel> lst = response.body().getData();
                lstVideoLive.setValue(lst);

            }

            @Override
            public void onFailure(Call<VideoList> call, Throwable t) {
                Util.Log(TAG,"api_login server_return " + new Gson().toJson(t.getMessage()));

            }
        });


        return lstVideoLive;
    }


}
