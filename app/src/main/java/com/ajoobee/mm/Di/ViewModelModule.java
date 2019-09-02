package com.ajoobee.mm.Di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.ajoobee.mm.UI.Jobs.JobsViewModel;
import com.ajoobee.mm.UI.JobsViewAll.ViewAllJobsViewModel;
import com.ajoobee.mm.UI.Login.LoginViewModel;
import com.ajoobee.mm.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the (LoginViewModel.class) as key,
     * and a Provider that will build a LoginViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    protected abstract ViewModel loginViewModel(LoginViewModel loginViewModel);

  /*  @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    //private RegisterViewModel
    protected abstract ViewModel registerViewModel(RegisterViewModel registerViewModel);*/

    @Binds
    @IntoMap
    @ViewModelKey(JobsViewModel.class)
    protected abstract ViewModel jobsViewModel(JobsViewModel jobsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ViewAllJobsViewModel.class)
    protected abstract ViewModel viewAllJobsViewModel(ViewAllJobsViewModel viewAllJobsViewModel);
}
