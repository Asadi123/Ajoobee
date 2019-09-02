package com.ajoobee.mm.Data.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.ajoobee.mm.Data.Network.Retrofit.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ajoobee.mm.Data.Obj.Job;

@Singleton
public class JobsRepository {
    private final ServiceApi serviceApi;
    MutableLiveData<List<Job>> liveJobList = null;

    public static String TAG = "LoginRepository";

    @Inject
    public JobsRepository(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public MutableLiveData<List<Job>> callJobListApi() {
        //if the livedata is null
        if (liveJobList == null) {
            liveJobList = new MutableLiveData<>();
            liveJobList = getLiveJobList();
            //we will load it asynchronously from server in this method
        }
            //finally we will return the list
        return liveJobList;
    }

    public MutableLiveData<List<Job>> getLiveJobList() {
        List<Job> lstJob = new ArrayList<>();
        Job j1 = new Job();
        Job j2 = new Job();
        Job j3 = new Job();
        Job j4 = new Job();
        Job j5 = new Job();

        j1.setJobTitle("Sales & Marketing Manager");
        j1.setCompanyName("Apex Hospitiality Group Co.,Ltd");
        j1.setLocation("Yangon");
        j1.setCountry("Myanmar");
        j1.setDate("10 July 2019");
        lstJob.add(j1);

        j2.setJobTitle("Sales & Marketing Manager");
        j2.setCompanyName("KBZ Co.,Ltd");
        j2.setLocation("Yangon");
        j2.setCountry("Myanmar");
        j2.setDate("10 July 2019");
        lstJob.add(j2);

        j3.setJobTitle("Sales & Marketing Manager");
        j3.setCompanyName("AYA Co.,Ltd");
        j3.setLocation("Yangon");
        j3.setCountry("Myanmar");
        j3.setDate("12 July 2019");
        lstJob.add(j3);

        j4.setJobTitle("Sales & Marketing Manager");
        j4.setCompanyName("KK Tech Co.,Ltd");
        j4.setLocation("Yangon");
        j4.setCountry("Myanmar");
        j4.setDate("13 July 2019");
        //lstJob.add(j4);

        j5.setJobTitle("Sales & Marketing Manager");
        j5.setCompanyName("Apex Hospitiality Group Co.,Ltd");
        j5.setLocation("Yangon");
        j5.setCountry("Myanmar");
        j5.setDate("10 July 2019");
        //lstJob.add(j5);

        liveJobList.setValue(lstJob);


        return liveJobList;
    }

    //cal rest service
    /*public void Api_Login(){
        String authID = Constants.authId;
        String uToken = Constants.accessToken;
        Call<ServerReturn> call = serviceApi.loginAPI(authID, uToken);
        call.enqueue(new Callback<ServerReturn>() {
            @Override
            public void onResponse(Call<ServerReturn> call, Response<ServerReturn> response) {
                Util.Log(TAG,"api_login server_return " + new Gson().toJson(response.body()));

            }

            @Override
            public void onFailure(Call<ServerReturn> call, Throwable t) {
                Util.Log(TAG,"api_login server_return " + new Gson().toJson(t.getMessage()));

            }
        });


    }*/

}
