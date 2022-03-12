package com.mobile.mobilehardware.build;

import org.json.JSONObject;

/**
 * @author gunaonian
 * @date 2018/3/28
 */

public class BuildHelperNew extends BuildInfoNew {

    /**
     * build信息
     *
     * @return
     */
    public static JSONObject mobGetBuildInfoNew() {
        return getBuildInfoNew();
    }
}
