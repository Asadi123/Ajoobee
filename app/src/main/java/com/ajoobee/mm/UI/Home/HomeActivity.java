package com.ajoobee.mm.UI.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajoobee.mm.BaseActivity;
import com.ajoobee.mm.UI.Jobs.JobsFragment;
import com.ajoobee.mm.UI.Login.LoginActivity;
import com.ajoobee.mm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener, JobsFragment.OnFragmentInteractionListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.txtJobs)
    TextView txtJobs;

    @BindView(R.id.txtActivity)
    TextView txtActivity;

    @BindView(R.id.txtProfile)
    TextView txtProfile;

    @BindView(R.id.imgLogin)
    ImageView imgLogin;


    /*@BindView(R.id.viewPager)
    ViewPager viewPager;*/

    FragmentManager fragmentManager;
    int numberOfTabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        setup();

        //user toolbar as actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //navigation drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //ViewPager
       /* fragmentManager = getSupportFragmentManager();
        HomeActivityViewPagerAdapter homeActivityViewPagerAdapter = new HomeActivityViewPagerAdapter(fragmentManager,numberOfTabs);
        viewPager.setAdapter(homeActivityViewPagerAdapter);*/

        fragmentManager = getSupportFragmentManager();

        txtJobs.setOnClickListener(this);
        txtActivity.setOnClickListener(this);
        txtProfile.setOnClickListener(this);
        imgLogin.setOnClickListener(this);

        String param1 = "saa";
        String param2 = "22 years";
        JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
        fragmentManager.beginTransaction()
                .replace(R.id.container, jobsFragment,JobsFragment.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.txtJobs):{
                //viewPager.setCurrentItem(0);
                String param1 = "saa";
                String param2 = "22 years";
                JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                fragmentManager.beginTransaction()
                        .replace(R.id.container, jobsFragment,JobsFragment.TAG)
                        .commit();
                break;
            }

            case (R.id.txtActivity):{
                String param1 = "saa";
                String param2 = "25 years";
                Toast.makeText(mContext,"Activity",Toast.LENGTH_SHORT).show();
                /*JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                fragmentManager.beginTransaction()
                        .replace(R.id.container, jobsFragment,JobsFragment.TAG)
                        .commit();*/
                break;
            }

            case (R.id.txtProfile):{
                String param1 = "saa";
                String param2 = "30 years";
                Toast.makeText(mContext,"Profile",Toast.LENGTH_SHORT).show();
                /*JobsFragment jobsFragment = JobsFragment.newInstance(param1,param2);
                fragmentManager.beginTransaction()
                        .replace(R.id.container, jobsFragment,JobsFragment.TAG)
                        .commit();*/

                Intent intent = new Intent(mContext, LoginActivity.class);
                mContext.startActivity(intent);
                break;
            }

            case (R.id.imgLogin):{
                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                break;
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
