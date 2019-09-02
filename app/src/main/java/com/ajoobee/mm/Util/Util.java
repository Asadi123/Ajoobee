package com.ajoobee.mm.Util;

import android.util.Log;

import com.ajoobee.mm.Constants;

public class Util {
    public static void Log(String tag,String msg){
        if(Constants.debug) {
            try {
                Log.i(tag,msg);
            }catch(SecurityException ex){
                ex.printStackTrace();
            }

        }
    }
}
