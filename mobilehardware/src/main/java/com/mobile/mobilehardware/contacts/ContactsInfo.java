package com.mobile.mobilehardware.contacts;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContactsInfo {

    private static final String TAG = ContactsInfo.class.getSimpleName();

    static List<JSONObject> getAllContacts(Context context) {
        List<JSONObject> ContactsList = new ArrayList<>();
        try {
            Cursor cur = context.getApplicationContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
            while (cur.moveToNext()) {
                ContactsBean contactsBean = new ContactsBean();
                contactsBean.setContactName(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                contactsBean.setContactId(id);
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0){
                    Cursor p = context.getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                    while(p.moveToNext()){
                        contactsBean.setContactNumber(p.getString(p.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    }
                }

                ContactsList.add(contactsBean.toJSONObject());
            }

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return ContactsList;
    }


}
