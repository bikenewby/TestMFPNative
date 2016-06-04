package com.ks.poc.testmfpnative;

import com.worklight.wlclient.api.*;
import android.util.Log;

/**
 * Created by Krit on 6/4/2016.
 */
public class MyInvokeListener implements WLResponseListener {
    @Override
    public void onSuccess(WLResponse wlResponse) {
        Log.i("TestMFPNative","Adapter invocation successfully. Response: " + wlResponse.getResponseJSON());
        MainActivity.updateTextView("Adapter invocation successfully. Response: " + wlResponse.getResponseJSON());
    }
    @Override
    public void onFailure(WLFailResponse wlFailResponse) {
        Log.i("TestMFPNative", "Adapter invocation failure. Response: " + wlFailResponse.getErrorMsg());
        MainActivity.updateTextView("Adapter invocation failure. Response: " + wlFailResponse.getErrorMsg());
    }
}
