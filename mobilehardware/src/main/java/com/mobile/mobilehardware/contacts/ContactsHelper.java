package com.mobile.mobilehardware.contacts;

import com.mobile.mobilehardware.MobileHardWareHelper;

import org.json.JSONObject;

import java.util.List;

public class ContactsHelper extends  ContactsInfo {
    public static List<JSONObject> getMobContacts() { return getAllContacts(MobileHardWareHelper.getContext()); }
}
