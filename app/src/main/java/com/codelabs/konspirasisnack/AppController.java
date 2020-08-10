package com.codelabs.konspirasisnack;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;


public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();
    private static AppController mInstance;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    public void onCreate(){
        super.onCreate();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mInstance = this;
    }


    public static synchronized AppController getInstance(){
        return mInstance;
    }

}
