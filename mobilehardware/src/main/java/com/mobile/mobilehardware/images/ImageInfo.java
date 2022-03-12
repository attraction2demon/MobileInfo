package com.mobile.mobilehardware.images;

import android.provider.MediaStore;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONObject;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {

    private static final String TAG = ImageInfo.class.getSimpleName();

    static List<JSONObject> getAllImages(Context context) {
        List<JSONObject> ImagesList = new ArrayList<>();
        try {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] projection = { MediaStore.Images.Media._ID,
                                    MediaStore.Images.Media.BUCKET_ID,
                                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                                    MediaStore.Images.Media.DATA,
                                    MediaStore.Images.Media.DATE_TAKEN,
                                    MediaStore.Images.Media.DISPLAY_NAME,
                                    MediaStore.Images.Media.SIZE };

            Cursor cur = context.getApplicationContext().getContentResolver().query(uri, projection, null, null, null);
            while (cur.moveToNext()) {
                ImageBean listImagesBean = new ImageBean();
                listImagesBean.setImageDisplayName(cur.getString(5));
                listImagesBean.setImageId(cur.getString(0));
                listImagesBean.setImageSize(cur.getString(6));
                listImagesBean.setImageData(cur.getString(3));
                ImagesList.add(listImagesBean.toJSONObject());
            }

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return ImagesList;
    }

}
