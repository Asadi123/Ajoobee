package com.ajoobee.mm;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    ProgressBar progressBar;
    Button btnBack;
    TextView txtTitle;
    SharedPreferences sharedPreferences;
    String userId,userName,accessToken,authId;

    public void setup() {
        try {
            mContext = getApplicationContext();
            sharedPreferences = mContext.getSharedPreferences(Constants.PREF_USER, MODE_PRIVATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUserInfo(){
        userId = sharedPreferences.getString(Constants.userId, "");
        userName = sharedPreferences.getString(Constants.userName,"");
        accessToken = sharedPreferences.getString(Constants.accessToken, "");
        authId = sharedPreferences.getString(Constants.authId,"");
    }

   /* @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public abstract int getContentView();*/
}
