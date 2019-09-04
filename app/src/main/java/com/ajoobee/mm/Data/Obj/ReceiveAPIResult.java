package com.ajoobee.mm.Data.Obj;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.SerializedName;

public class ReceiveAPIResult {

    @Embedded(prefix = "UserToken")
    @SerializedName("result")
    public Object result;

    @Embedded(prefix = "UserDetail")
    @SerializedName("response")
    public Response response;

    public ReceiveAPIResult(Result result, Response response) {
        this.result = result;
        this.response = response;
    }
}
