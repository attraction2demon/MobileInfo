package com.mobile.mobilehardware.images;

import com.mobile.mobilehardware.MobileHardWareHelper;

import org.json.JSONObject;

import java.util.List;

public class ImageHelper extends ImageInfo {
    public static List<JSONObject> getMobImages() {
        return getAllImages(MobileHardWareHelper.getContext());
    }
}