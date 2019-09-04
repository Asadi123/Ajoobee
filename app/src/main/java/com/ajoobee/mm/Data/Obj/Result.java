package com.ajoobee.mm.Data.Obj;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("token")
    public String token;

    public Result(String token) {
        this.token = token;
    }
}
