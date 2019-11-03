package com.example.kuwait.Util;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    private final Context context;

    public ConnectionDetector(Context context) {
        this.context = context;
    }

    public boolean isConnected(){
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(manager!=null){
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }

}
