package com.ks.poc.testmfpnative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.worklight.wlclient.api.*;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private static TextView textView = null;
    private static MainActivity _this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _this = this;
        textView = (TextView)findViewById(R.id.txtResult);
    }

    public void callMFPConn(View view) {
        Log.d("TestMFPNative", "Connecting to MFP");
        updateTextView("Connecting to MFP");
        final WLClient client = WLClient.createInstance(this);
        client.connect(new MyConnectListener());
//        Toast.makeText(getAppli
    }

    public void callMFPProc(View view) {
        URI adapterPath = null;
        try {
            adapterPath = new URI("/adapters/MFPTestAdapter/testConnection");
        } catch (URISyntaxException e) {
            Log.d("TestMFPNative", "URI Syntax failure during calling adapter: " + e.getMessage());
            updateTextView("URI Syntax failure during calling adapter: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);
            Log.d("TestMFPNative", "Calling MFP Adapter");
            updateTextView("Calling MFP Adapter");
            request.send(new MyInvokeListener());
        } catch (Exception e) {
            Log.d("TestMFPNative", "Failure calling MFP Adapter: " + e.getMessage());
            updateTextView("Failure calling MFP Adapter: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void updateTextView(final String str){
        Runnable run = new Runnable() {
            public void run() {
                textView.setText(str);
            }
        };
        _this.runOnUiThread(run);
    }
}
