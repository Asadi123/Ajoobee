package com.ajoobee.mm.Data.Network.Response;

public class CheckApiStatus {

    private String apicode;

    public CheckApiStatus(String ApiCode) {
        this.apicode = ApiCode;
    }

    public Status Check()
    {
        if(apicode.equals("OK"))
        {

            return Status.SUCCESS;

        }else {

            return Status.ERROR;
        }
    }
}
