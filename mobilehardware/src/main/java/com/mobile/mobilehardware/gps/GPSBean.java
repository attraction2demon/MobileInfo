package com.mobile.mobilehardware.gps;

import android.util.Log;

import com.mobile.mobilehardware.base.BaseBean;
import com.mobile.mobilehardware.base.BaseData;

import org.json.JSONObject;

public class GPSBean extends BaseBean {

    private static final String TAG = GPSBean.class.getSimpleName();

    private String gpsLatitude;
    private String gpsLongitude;

    public String getGpsLatitude() { return  gpsLatitude; }
    public String getGpsLongitude() { return  gpsLongitude; }

    public void setGpsLatitude(String gpsLatitude) { this.gpsLatitude = gpsLatitude; }
    public void setGpsLongitude(String gpsLongitude) { this.gpsLongitude = gpsLongitude; }



    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Gps.LATITUDE, isEmpty(gpsLatitude));
            jsonObject.put(BaseData.Gps.LONGITUDE, isEmpty(gpsLongitude));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }
}
