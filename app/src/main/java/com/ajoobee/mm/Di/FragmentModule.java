package com.ajoobee.mm.Di;

import com.ajoobee.mm.UI.Jobs.JobsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    //Allow JobsFragment to use injection
    @ContributesAndroidInjector()
    abstract JobsFragment injectToJobsFragment();
}
