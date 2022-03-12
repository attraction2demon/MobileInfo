package com.mobile.mobilehardware.calls;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CallLogsInfo {
	
    private static final String TAG = CallLogsInfo.class.getSimpleName();

    static List<JSONObject> getAllCallLogs(Context context) {
        List<JSONObject> callLogsList = new ArrayList<>();
        try {
            String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
            Uri callUri = Uri.parse("content://call_log/calls");

            String[] projection = { CallLog.Calls.NUMBER,
                                    CallLog.Calls.CACHED_NAME,
                                    CallLog.Calls.DATE,
                                    CallLog.Calls.DURATION,
                                    CallLog.Calls.TYPE,
                                  };

            Cursor cur = context.getApplicationContext().getContentResolver().query(callUri, projection, null, null, strOrder);

            while (cur.moveToNext()) {
                CallLogsBean listCallLogsBean = new CallLogsBean();
                listCallLogsBean.setCallNumber(cur.getString(0));
                listCallLogsBean.setCallName(cur.getString(1));
                //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
                //listCallLogsBean.setCallDate(formatter.format(new Date(Long.parseLong(cur.getString(2)))));
                listCallLogsBean.setCallDate(String.valueOf(Long.parseLong(cur.getString(2))));
                listCallLogsBean.setCallDuration(cur.getString(3));
                listCallLogsBean.setCallType(cur.getString(4));
                callLogsList.add(listCallLogsBean.toJSONObject());
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return callLogsList;
    }
}
