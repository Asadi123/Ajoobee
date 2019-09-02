package com.ajoobee.mm.UI.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ajoobee.mm.UI.Jobs.JobsFragment;

public class HomeActivityViewPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    public HomeActivityViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 : {
                String param1 = "saa";
                String param2 = "22 years";
                JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                return jobsFragment;
            }
            case 1 : {
                String param1 = "saa";
                String param2 = "25 years";
                JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                return jobsFragment;
            }
            case 2 : {
                String param1 = "saa";
                String param2 = "30 years";
                JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                return jobsFragment;
            }
            /*case 3 : {
                return new LastNewsFragment();
            }
            case 4 : {
                return new MostPopularFragment();
            }
            case 5 : {
                return new WatchFragment();
            }*/
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
