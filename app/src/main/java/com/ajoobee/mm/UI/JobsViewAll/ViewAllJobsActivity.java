package com.ajoobee.mm.UI.JobsViewAll;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ajoobee.mm.R;
import com.ajoobee.mm.Util.Diff;
import com.ajoobee.mm.Util.Util;
import com.ajoobee.mm.ViewModelFactory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ajoobee.mm.Data.Obj.VideoModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class ViewAllJobsActivity extends AppCompatActivity {

    public static String TAG = "ViewAllJobsActivity";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    ViewAllJobsAdapter jobsAdapter;
    Context mContext;

    LinearLayoutManager layoutManager;

    List<VideoModel> lstVideo = new ArrayList<>();

    int limit = 10;
    String userId="13";
    boolean loading = false;
    int previousItemCount;

    /* inject */
    @Inject
    ViewModelFactory viewModelFactory;

    ViewAllJobsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_jobs);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        mContext = this;

        setUpRecyclerView();

        loadMovieList();
    }

    public void setUpRecyclerView(){
        jobsAdapter = new ViewAllJobsAdapter(mContext,lstVideo);
        layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(jobsAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    int itemCount = layoutManager.getItemCount();
                    if (!loading && layoutManager.findLastCompletelyVisibleItemPosition() >= itemCount - 1) {
                        previousItemCount = itemCount;
                        loading = true;
                        limit += limit;


                        Toast.makeText(mContext,"onLoadMore2",Toast.LENGTH_SHORT).show();
                        loadMovieList();
                    }
                }
            }
        });
    }

    public void loadMovieList(){

        jobsAdapter.addProgressView();
        if(viewModelFactory != null) {
            viewModel = ViewModelProviders.of(this,viewModelFactory).get(ViewAllJobsViewModel.class);
            progressBar.setVisibility(View.VISIBLE);
            Util.Log(TAG,"para --> " + String.valueOf(limit));
            viewModel.Api_JobList(userId,limit).observe(this, new Observer<List<VideoModel>>() {
                @Override
                public void onChanged(@Nullable final List<VideoModel> videoModels) {
                    Log.i(TAG,"list of video --> " + new Gson().toJson(videoModels));
                    DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new Diff(lstVideo, videoModels));


                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            jobsAdapter.removeProgressView();
                            lstVideo.clear();
                            lstVideo.addAll(videoModels);
                            jobsAdapter.notifyDataSetChanged();
                            loading = false;
                        }
                    },1000);

                    //diffResult.dispatchUpdatesTo(jobsAdapter);
                }
            });
        }
    }

}
