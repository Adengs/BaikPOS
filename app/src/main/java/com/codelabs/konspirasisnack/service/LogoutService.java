package com.codelabs.konspirasisnack.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;

public class LogoutService extends Service {

    public static final String TAG = LogoutService.class.getSimpleName();

    static CountDownTimer longTimer;
    static boolean dialogStat = false;

    public final IBinder mBinder = new LocalBinder();
    public class LocalBinder extends Binder {
        public LogoutService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LogoutService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int starId) {
        if (Log.isLoggable(TAG, Log.ERROR)) {
            Log.e(TAG, "Startring service");
        }
        startTimer();
        return Service.START_NOT_STICKY;
    }

    private void doBroadcastLogout() {

        Intent localIntent = new Intent("AUTO_LOGOUT");
        localIntent.putExtra("param","logout");
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }

    private void doBroadcastDialog() {

        if (!dialogStat) {
            Intent localIntent = new Intent("AUTO_LOGOUT");
            localIntent.putExtra("param", "dialog");
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
            dialogStat = true;
        }
    }

    public void startTimer() {
        if (!DataManager.getInstance().isLogin())
            return;

        Log.e(TAG, "startTimer: timer updated" );
        if (longTimer != null) {
            longTimer.cancel();
            longTimer = null;
            dialogStat = false;
        }

        longTimer = new CountDownTimer(AppConstant.TIMER_AUTO_LOGOUT,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e(TAG, "onTick: "+millisUntilFinished );
                if (millisUntilFinished < (AppConstant.TIMER_AUTO_LOGOUT-5000)){
                    doBroadcastDialog();
                }
            }

            @Override
            public void onFinish() {

                doBroadcastLogout();

            }
        };

        longTimer.start();
    }

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        if (longTimer != null) {
            longTimer.cancel();
            longTimer = null;
            dialogStat = false;
        }

        Log.e(TAG, "onDestroy: logout service ");
    }
}
