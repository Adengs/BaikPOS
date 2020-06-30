package com.codelabs.konspirasisnack.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogProgress;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.utils.LogOutTimerUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BaseActivity extends AppCompatActivity implements LogOutTimerUtil.LogOutListener {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 9999;
    protected Context context;
    protected boolean isActive = true;

    protected DialogProgress dialogProgress;

    private Toast mToast = null;
    private String selectedPhone;
    private String TAG = getClass().getSimpleName();

    private AlertDialog dialogLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (getClass().getSimpleName().equals("SignInActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterVerifikasiActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterInformasiUsahaActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterMasukanProdukActivity"))
            return;

        checkLoginTime();
    }


    @Override
    protected void onResume() {
        super.onResume();
        isActive = true;

        if (getClass().getSimpleName().equals("SignInActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterVerifikasiActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterInformasiUsahaActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterMasukanProdukActivity"))
            return;

        if (!DataManager.getInstance().isLogin()){
            processAutoLogout();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (getClass().getSimpleName().equals("SignInActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterVerifikasiActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterInformasiUsahaActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterMasukanProdukActivity"))
            return;

       LogOutTimerUtil.stopLogoutTimer();
    }


    @Override
    public void onConfigurationChanged (Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        if (getClass().getSimpleName().equals("SignInActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterVerifikasiActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterInformasiUsahaActivity"))
            return;

        if (getClass().getSimpleName().equals("RegisterMasukanProdukActivity"))
            return;

        if (DataManager.getInstance().isLogin())
            LogOutTimerUtil.startLogoutTimer(this, this);
    }



    @Override
    public void doLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You will logout in a few minutes");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                LogOutTimerUtil.startLogoutTimer(BaseActivity.this, BaseActivity.this);
            }
        });
        dialogLogout = builder.show();

    }



    @Override
    public void doLogout() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<DoPost> call = apiService.doLogout(auth);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                DataManager.getInstance().doLogout();
                processAutoLogout();
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call,@NonNull Throwable t) {
                DataManager.getInstance().doLogout();
                processAutoLogout();
            }
        });
    }

    public void showDialogProgress(String message) {
        if (message != null) {
            dialogProgress = new DialogProgress(context, message, true);
            dialogProgress.setCancelable(false);
            dialogProgress.show();
        } else {
            dialogProgress = new DialogProgress(context, "Loading ...", false);
            dialogProgress.setCancelable(false);
            dialogProgress.show();
        }
    }

    public void hideDialogProgress(){
        if (dialogProgress != null) {
            if (dialogProgress.isShowing()) {
                dialogProgress.dismiss();
            }
        }
    }

    public void showToast(String val) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, val, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }

    public void openCall(String phone) {
        selectedPhone = phone;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
            return;
        }

        doCall();
    }


    public void doCall() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + selectedPhone));
            startActivity(intent);
        }
    }


    public void processAutoLogout(){
        dialogLogoutDismiss();
        Intent intent = new Intent(this, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    doCall();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }



    @Override
    public void doLogoutBackground() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<DoPost> call = apiService.doLogout(auth);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call,@NonNull Response<DoPost> data) {
                DataManager.getInstance().doLogout();
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                DataManager.getInstance().doLogout();
            }
        });
    }

    private void dialogLogoutDismiss() {
        if (dialogLogout != null) {
            if (dialogLogout.isShowing()){
                dialogLogout.dismiss();
            }
        }
    }

    private void checkLoginTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        try{
            Date dateLast = sdf.parse(DataManager.getInstance().getLastLogin());
            Date dateNow = new Date();

            long diffMs = dateNow.getTime() - dateLast.getTime();


            long durationInMs = AppConstant.TIMER_AUTO_LOGOUT;

            if (!TextUtils.isEmpty(DataManager.getInstance().getLogoutDuration())){
                durationInMs = Long.parseLong(DataManager.getInstance().getLogoutDuration()) * 60000;
            }

            if (diffMs >= durationInMs){
                doLogout();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        LogOutTimerUtil.startLogoutTimer(this, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
    }
}
