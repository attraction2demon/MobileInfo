package com.mobile.mobilehardware.images;

import android.util.Log;

import com.mobile.mobilehardware.base.BaseBean;
import com.mobile.mobilehardware.base.BaseDataNew;

import org.json.JSONObject;

public class ImageBean extends BaseBean {
    private static final String TAG = ImageBean.class.getSimpleName();

    private String imageId;
    private String imageDisplayName;
    private String imageSize;
    private String imageData;

    public String getImageId() { return imageId; }
    public String getImageDisplayName() { return imageDisplayName; }
    public String getImageSize() { return imageSize; }
    public String getImageData() { return imageData; }

    public void setImageId(String imageId) { this.imageId = imageId; }
    public void setImageDisplayName(String imageDisplayName) { this.imageDisplayName = imageDisplayName; }
    public void setImageSize(String imageSize) { this.imageSize = imageSize; }
    public void setImageData(String imageData) { this.imageData = imageData; }



    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Image.ID, isEmpty(imageId));
            jsonObject.put(BaseData.Image.DISPLAY_NAME, isEmpty(imageDisplayName));
            jsonObject.put(BaseData.Image.SIZE, isEmpty(imageSize));
            jsonObject.put(BaseData.Image.DATA, isEmpty(imageData));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }
}
