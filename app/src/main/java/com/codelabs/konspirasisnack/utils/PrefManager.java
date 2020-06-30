package com.codelabs.konspirasisnack.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;


    //shared pref mode
    int PRIVATE_MODE = 0;

    //shared preferences file name
    private static final String PREF_NAME = "poscodelabs";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";


    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setIsFirstTimeLaunch(boolean isFirstTimeLaunch) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }





}
