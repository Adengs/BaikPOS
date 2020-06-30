package com.codelabs.konspirasisnack;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;


@ReportsCrashes(
        mailTo = "report.sendme@gmail.com",
//        mailTo = "bugmepos@mailinator.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text
)


public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();
    private static AppController mInstance;


    @Override
    public void onCreate(){
        super.onCreate();
        ACRA.init(this);
        mInstance = this;
    }


    public static synchronized AppController getInstance(){
        return mInstance;
    }

}
