package com.ajoobee.mm.UI.Jobs;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ajoobee.mm.UI.JobsViewAll.ViewAllJobsActivity;
import com.ajoobee.mm.R;
import com.ajoobee.mm.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ajoobee.mm.Data.Obj.Job;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JobsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Inject
    ViewModelFactory viewModelFactory;

    JobsViewModel jobsViewModel;

    private OnFragmentInteractionListener mListener;

    Context mContext;
    List<Job> lstJob = new ArrayList<>();

    @BindView(R.id.recyclerViewTopJobs)
    RecyclerView topJobsRecyclerView;

    @BindView(R.id.recyclerViewTodayJobs)
    RecyclerView todayJobsRecyclerView;

    @BindView(R.id.txtViewAll)
            TextView txtViewAll;

    JobsAdapter jobsAdapter;
    LinearLayoutManager layoutManager;


    static JobsFragment fragment;

    public static String TAG = "JobsFragment";

    public JobsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobsFragment newInstance(String param1, String param2) {
        if(fragment == null) {
            fragment = new JobsFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
        ButterKnife.bind(this,view);

        mContext = view.getContext();

        setUpTopJobRecyclerView();
        setUpTodayJobRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(viewModelFactory != null) {
            jobsViewModel = ViewModelProviders.of(this, viewModelFactory).get(JobsViewModel.class);
            jobsViewModel.Api_JobList().observe(this, new Observer<List<Job>>() {
                @Override
                public void onChanged(@Nullable List<Job> jobList) {
                    Toast.makeText(mContext, "size of job list " + jobList.size() , Toast.LENGTH_SHORT).show();
                    lstJob.clear();
                    lstJob.addAll(jobList);
                    jobsAdapter.notifyDataSetChanged();
                }
            });
        }else{
            Toast.makeText(mContext, "null " , Toast.LENGTH_SHORT).show();

        }
    }

    public void setUpTopJobRecyclerView(){
        jobsAdapter = new JobsAdapter(getContext(),lstJob);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        topJobsRecyclerView.setLayoutManager(layoutManager);
        topJobsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        topJobsRecyclerView.setHasFixedSize(true);
        topJobsRecyclerView.setAdapter(jobsAdapter);
    }

    public void setUpTodayJobRecyclerView(){
        jobsAdapter = new JobsAdapter(getContext(),lstJob);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        todayJobsRecyclerView.setLayoutManager(layoutManager);
        todayJobsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        todayJobsRecyclerView.setHasFixedSize(true);
        todayJobsRecyclerView.setAdapter(jobsAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @OnClick(R.id.txtViewAll)
    public void txtViewAllOnClick(){
        Intent i =new Intent(mContext, ViewAllJobsActivity.class);
        mContext.startActivity(i);
    }
}
