package com.codelabs.konspirasisnack.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;

import com.codelabs.konspirasisnack.AppController;

public class CheckDevice {

    public static Boolean isTablet() {
        boolean isTablet = AppController.getInstance().getResources().getConfiguration().smallestScreenWidthDp >= 600;
        isTablet = true;

        return isTablet;
    }

    public static void setScreenOrientation(Activity activity ,boolean isTablet){
        if (isTablet)
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        else
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}
