package com.ajoobee.mm.UI.JobsViewAll;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.ajoobee.mm.Data.Repository.ViewAllJobsRepository;

import java.util.List;

import javax.inject.Inject;

import com.ajoobee.mm.Data.Obj.VideoModel;

public class ViewAllJobsViewModel extends ViewModel {
    private MutableLiveData<List<VideoModel>> liveJobList;
    private ViewAllJobsRepository jobsRepository;
    public static String TAG = "LoginViewModel";

    //inject JobRepository
    @Inject
    public ViewAllJobsViewModel(ViewAllJobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public MutableLiveData<List<VideoModel>> Api_JobList(String userId,int limit){
        Log.i(TAG,"api call 1");
        liveJobList = jobsRepository.callJobListApi(userId,limit);
        //liveJobList.setValue(lst.getValue());
        return liveJobList;
    }
}
