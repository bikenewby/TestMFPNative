package com.ks.poc.testmfpnative;

/**
 * Created by Krit on 6/4/2016.
 */
import com.worklight.wlclient.api.*;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Krit on 6/4/2016.
 */
public class MyConnectListener implements WLResponseListener {
    @Override
    public void onSuccess(WLResponse wlResponse) {
        Log.i("TestMFPNative","MFP connection successfully. Response: " + wlResponse.getResponseJSON());
        MainActivity.updateTextView("MFP connection successfully. Response: " + wlResponse.getResponseJSON());
    }
    @Override
    public void onFailure(WLFailResponse wlFailResponse) {
        Log.i("TestMFPNative", "MFP connection failure. Response: " + wlFailResponse.getErrorMsg());
        MainActivity.updateTextView("MFP connection failure. Response: " + wlFailResponse.getErrorMsg());
    }
}

