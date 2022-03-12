package com.mobile.mobilehardware.gps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

public class GPSInfo {
    private static final String TAG = GPSInfo.class.getSimpleName();

    @SuppressLint("MissingPermission")
    public static JSONObject getGPS(Context context) {
        GPSBean listGPSBean = new GPSBean();
        try {
            LocationManager locManager = (LocationManager)context.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,400,1, locationListener);
            Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            listGPSBean.setGpsLatitude(String.valueOf(location.getLatitude()));
            listGPSBean.setGpsLongitude(String.valueOf(location.getLongitude()));

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return listGPSBean.toJSONObject();
    }

    private static void updateWithNewLocation(Location location) {
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
        }
    }

    private static final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            updateWithNewLocation(location);
        }
        public void onProviderDisabled(String provider) {
            updateWithNewLocation(null);
        }
        public void onProviderEnabled(String provider) {
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };
}
