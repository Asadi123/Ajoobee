package com.ajoobee.mm.UI.Jobs;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.ajoobee.mm.Data.Repository.JobsRepository;

import java.util.List;

import javax.inject.Inject;

import com.ajoobee.mm.Data.Obj.Job;

public class JobsViewModel extends ViewModel {
    private MutableLiveData<List<Job>> liveJobList;
    private JobsRepository jobsRepository;
    public static String TAG = "LoginViewModel";

    //inject JobRepository
    @Inject
    public JobsViewModel(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public MutableLiveData<List<Job>> Api_JobList(){
        liveJobList = jobsRepository.callJobListApi();
        return liveJobList;
    }
}
