package com.mobile.mobilehardware.gps;

import com.mobile.mobilehardware.MobileHardWareHelper;

import org.json.JSONObject;

public class GPSHelper extends  GPSInfo {
    public static JSONObject getMobGPS() {
        return getGPS(MobileHardWareHelper.getContext());
    }
}
