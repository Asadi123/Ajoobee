package com.ajoobee.mm.UI.Login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ajoobee.mm.R;
import com.ajoobee.mm.Data.Network.Response.ServerReturn;
import com.ajoobee.mm.UI.Register.RegisterActivity;
import com.ajoobee.mm.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity {
  @BindView(R.id.txtCompanyName)
  EditText txtUserName;

    @BindView(R.id.btnRegister)
    Button btnLogin;

//    @BindView(R.id.btnRegister)
//    Button btnRegister;

    @BindView(R.id.signUpTextView)
    TextView signUpTextView;

    @Inject
    ViewModelFactory viewModelFactory;

    private LoginViewModel loginViewModel;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        mContext = this;

    }

    @OnClick(R.id.btnRegister)
    public void callLogin(Button btn) {

        if(viewModelFactory != null) {

            loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
            loginViewModel.Api_Login(txtUserName.getText().toString()).observe(this, new Observer<ServerReturn>() {
                @Override
                public void onChanged(@Nullable ServerReturn serverReturn) {

//                    if(serverReturn.getStatus().equals("fail")){
//                        Toast.makeText(mContext, serverReturn.getDescription(), Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(mContext, serverReturn.getDescription(), Toast.LENGTH_SHORT).show();
//                    }
                }
            });
        }
    }

    @OnClick(R.id.signUpTextView)
    public void callRegister(TextView textView)
    {
        Intent intent = new Intent(mContext, RegisterActivity.class);
        mContext.startActivity(intent);
    }

    public void alert(ServerReturn serverReturn){
//        Toast.makeText(mContext,serverReturn.getName(),Toast.LENGTH_SHORT).show();
    }

//    @OnClick(R.id.btnRegister)
//    public void callRegisterActivity(Button btn){
//        Intent intent = new Intent(mContext, RegisterActivity.class);
//        mContext.startActivity(intent);
//    }


}
