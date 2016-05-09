package com.example.testmidea;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Test_wifiActivity extends Activity { 
  
    private static final String TAG = "Test_wifiActivity";

	@Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.wifi); 
        WifiAdmin wifiAdmin = new WifiAdmin(this);
        wifiAdmin.openWifi();
        Log.d(TAG, "openWifi();");
        wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo("TP-LINK_2016", "ceshi123456789", 3)); 
        wifiAdmin.getBSSID();
        Log.d("Test_wifiActivity", wifiAdmin.getBSSID());
    } 
}	