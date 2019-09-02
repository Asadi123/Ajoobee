package com.ajoobee.mm.Di;

import com.ajoobee.mm.UI.JobsViewAll.ViewAllJobsActivity;
import com.ajoobee.mm.UI.Login.LoginActivity;
import com.ajoobee.mm.UI.Register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    //Allow LoginActivity to inject LoginViewModel
    @ContributesAndroidInjector()
    abstract LoginActivity injectToLoginActivity();

    //Allow RegisterActivity to inject RegisterViewModel
    @ContributesAndroidInjector()
    abstract RegisterActivity injectToRegisterActivity();

    //Allow ViewAllJobsActivity to use ViewAllJobsViewModel
    @ContributesAndroidInjector()
    abstract ViewAllJobsActivity injectViewAllJobsActivity();

}
