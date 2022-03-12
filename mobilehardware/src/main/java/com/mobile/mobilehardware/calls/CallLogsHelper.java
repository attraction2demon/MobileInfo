package com.mobile.mobilehardware.calls;

import com.mobile.mobilehardware.MobileHardWareHelper;

import org.json.JSONObject;

import java.util.List;

public class CallLogsHelper  extends CallLogsInfo {
    public static List<JSONObject> getMobCallLogs() {
        return getAllCallLogs(MobileHardWareHelper.getContext());
    }
}
