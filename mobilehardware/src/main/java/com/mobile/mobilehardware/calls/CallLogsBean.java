package com.mobile.mobilehardware.calls;

import android.util.Log;

import com.mobile.mobilehardware.base.BaseBean;
import com.mobile.mobilehardware.base.BaseData;

import org.json.JSONObject;

public class CallLogsBean extends BaseBean {

    private static final String TAG = CallLogsBean.class.getSimpleName();

    private String callNumber;
    private String callName;
    private String callDate;
    private String callType;
    private String callDuration;

    public String getCallNumber() { return  callNumber; }
    public String getCallName() { return  callName; }
    public String getCallDate() { return  callDate; }
    public String getCallType() { return  callType; }
    public String getCallDuration() { return  callDuration; }

    public void setCallNumber(String callNumber) { this.callNumber = callNumber; }
    public void setCallName(String callName) { this.callName = callName; }
    public void setCallDate(String callDate) { this.callDate = callDate; }
    public void setCallType(String callType) { this.callType = callType; }
    public void setCallDuration(String callDuration) { this.callDuration = callDuration; }


    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Call.NUMBER, isEmpty(callNumber));
            jsonObject.put(BaseData.Call.NAME, isEmpty(callName));
            jsonObject.put(BaseData.Call.DATE, isEmpty(callDate));
            jsonObject.put(BaseData.Call.TYPE, isEmpty(callType));
            jsonObject.put(BaseData.Call.DURATION, isEmpty(callDuration));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }

}

