package com.mobile.mobilehardware.sms;

import com.mobile.mobilehardware.MobileHardWareHelper;

import org.json.JSONObject;

import java.util.List;

public class SMSHelper extends SMSInfo {

	public static List<JSONObject> getMobSMS() {
        return getAllSms(MobileHardWareHelper.getContext());
    }
}
