package com.ajoobee.mm.Data.Obj;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("code")
    public String code;

    @SerializedName("message")
    public String message;

    @SerializedName("target")
    public String target;

    @SerializedName("details")
    public String details;

    public Response(String code, String message, String target, String details) {
        this.code = code;
        this.message = message;
        this.target = target;
        this.details = details;
    }
}
