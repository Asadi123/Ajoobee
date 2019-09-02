package com.ajoobee.mm;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.ajoobee.mm.UI.Register.RegisterActivity;

public class SplashActivity extends BaseActivity {
    SplashActivity splashActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashActivity = this;
        setup();
        landing();
    }

    private void landing(){
        int SPLASH_TIME = getResources().getInteger(R.integer.splash_time);
       /* Glide.with(mContext).load(R.drawable.splash_animation)
                        .into(new GlideDrawableImageViewTarget(image_view));*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, RegisterActivity.class);
                mContext.startActivity(intent);
                splashActivity.finish();
            }
        }, SPLASH_TIME);

    }
}
