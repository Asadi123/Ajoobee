package com.ajoobee.mm.Data.Network.Retrofit;

import android.arch.lifecycle.LiveData;

import com.ajoobee.mm.Data.Network.Response.ServerReturn;
import com.ajoobee.mm.Constants;

import com.ajoobee.mm.Data.Obj.ReceiveAPIResult;
import com.ajoobee.mm.Data.Obj.SendLogin;
import com.ajoobee.mm.Data.Obj.VideoList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApi {

    @FormUrlEncoded
    @POST(Constants.end_point + "user_login")
    Call<ServerReturn> loginAPI(
            @Field("authId") String auth_id,
            @Field("token") String token,
            @Field("country_code") String country_code,
            @Field("phone") String phone,
            @Field("user_id") String user_id,
            @Field("login_type") String login_type,
            @Field("sms_flag") String smsDefaultFormat
    );


    @FormUrlEncoded
    @POST(Constants.end_point + "home")
    Call<VideoList> getHomeVideos(
            @Field("authId") String auth_id,
            @Field("token") String token,
            @Field("user_id") String user_id,
            @Field("limit") String limit
    );

    @FormUrlEncoded
    @POST(Constants.url + "api/login  ")
    LiveData<ReceiveAPIResult> getLoginInfo(
            @Body SendLogin sendLogin
    );
}
