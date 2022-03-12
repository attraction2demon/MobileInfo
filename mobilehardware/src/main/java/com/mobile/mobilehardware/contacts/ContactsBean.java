package com.mobile.mobilehardware.contacts;

import android.util.Log;

import com.mobile.mobilehardware.base.BaseBean;
import com.mobile.mobilehardware.base.BaseData;

import org.json.JSONObject;


public class ContactsBean extends BaseBean {

    private static final String TAG = ContactsBean.class.getSimpleName();

    private String contactName;
    private String contactId;
    private String contactNumber;

    public String getContactName() { return  contactName; }
    public String getContactId() { return  contactId; }
    public String getContactNumber() { return  contactNumber; }

    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setContactId(String contactId) { this.contactId = contactId; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }



    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Contact.NAME, isEmpty(contactName));
            jsonObject.put(BaseData.Contact.ID, isEmpty(contactId));
            jsonObject.put(BaseData.Contact.NUMBER, isEmpty(contactNumber));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }
}
