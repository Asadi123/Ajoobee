package com.ajoobee.mm.UI.Register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ajoobee.mm.R;
import com.ajoobee.mm.Util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.txtEmail)
    EditText txtEmail;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    @BindView(R.id.txtConfirmPassword)
    EditText txtConfirmPassword;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    String[] arrLocation,arrDesiredJob;

    Context mContext;

    public static String TAG = "RegisterActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        mContext = this;

        //init
        init();
    }

    public void init(){
        arrLocation = getResources().getStringArray(R.array.array_location);
        arrDesiredJob = getResources().getStringArray(R.array.array_desired_job);

        //populate location spinner
        ArrayAdapter<CharSequence> spnLocationadapter = ArrayAdapter.createFromResource(this,
                R.array.array_location, android.R.layout.simple_spinner_item);

        spnLocationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        spnLocation.setAdapter(spnLocationadapter);
//        spnLocation.setOnItemSelectedListener(this);

        //populate desired location spinner
        ArrayAdapter<CharSequence> spnDesiredJobadapter = ArrayAdapter.createFromResource(this,
                R.array.array_desired_job, android.R.layout.simple_spinner_item);

        spnDesiredJobadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        spnDesiredJob.setAdapter(spnDesiredJobadapter);
//        spnDesiredJob.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (parent.getId()){
//            case (R.id.spnLocation):{
//                Toast.makeText(mContext,arrLocation[position],Toast.LENGTH_SHORT).show();
//                break;
//            }
//            case (R.id.spnDesiredJob):{
//                Toast.makeText(mContext,arrDesiredJob[position],Toast.LENGTH_SHORT).show();
//                break;
//            }
//        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.btnRegister)
    public void callRegister(Button btn){
        Util.Log(TAG, "email " + txtEmail.getText().toString()+
                " pwd " + txtPassword.getText().toString() +
                " c_pwd " + txtConfirmPassword.getText().toString() +
                " fullname " + txtEmail.getText().toString());
    }
}
