package com.codelabs.konspirasisnack.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetLogin;
import com.codelabs.konspirasisnack.model.GetRefreshToken;
import com.codelabs.konspirasisnack.model.GetTokenClient;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ed_email)
    TextInputEditText edEmail;
    @BindView(R.id.ed_password)
    TextInputEditText edPassword;
    @BindView(R.id.btn_daftar)
    TextView btnDaftar;
    @BindView(R.id.btn_masuk)
    Button btnMasuk;
    @BindView(R.id.test)
    TextView test;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());

//        test.setText(DataManager.getInstance().getU_email());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (DataManager.getInstance().isLogin()) {
                    silentLogin();
                }else {
//                    doLogin();

                }
            }
        }, 300);


        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();

    }

    private void initView() {
        Utils.setNoStatusBar(getWindow());
    }

    private void initVar() {
//
//        edEmail.setText("Admin@diko.pian");
//        edPassword.setText("123456");
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edEmail.setText(loginPreferences.getString("u_email", ""));
            edPassword.setText(loginPreferences.getString("password", ""));
        }
    }

    private void initEvent() {
        btnDaftar.setOnClickListener(this);
        btnMasuk.setOnClickListener(this);
    }

    private void initSetup() {
    }

    private void fetchData() {
//        doLogin();
    }

    private void goToHome() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void silentLogin() {
//        Map<String, String> params = new HashMap<>();
//        params.put("email", DataManager.getInstance().getU_email());
//        params.put("password", DataManager.getInstance().getPassword());
//        params.put("platform", "Android");

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetRefreshToken> call = apiService.refreshToken(auth);
        call.enqueue(new Callback<GetRefreshToken>() {
            @Override
            public void onResponse(@NonNull Call<GetRefreshToken> call, @NonNull Response<GetRefreshToken> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    GetRefreshToken response = data.body();
                    if (response != null) {
                        if (response.status == 200) {
                            DataManager.getInstance().setToken(response.data.token);

                            goToHome();

                        } else {
                            showToast(response.message);
                        }
                    } else {
//                        showToast("Empty response data");
                    }
                } else {
//                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetRefreshToken> call, @NonNull Throwable t) {
//                if (!call.isCanceled()) {
//                    hideDialogProgress();
//                    showToast("Network Failure : ( please try again later");
//                }
//                t.printStackTrace();
            }
        });
    }


    public void doLogin() {
        final String email = edEmail.getText().toString();
        final String password = edPassword.getText().toString();

        if (!RecentUtils.isEmailValid(email)) {
            showToast("Mohon masukkan alamat email valid anda");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            showToast("Mohon masukkan password anda");
            return;
        }

        showDialogProgress("Proses data login");
        doLoginPost(email, password);

    }

    public void doLoginPost(String email, final String password) {
        Map<String, String> params = new HashMap<>();
        params.put("platform", "Android");
        params.put("email", email);
        params.put("password", password);

        RetrofitInterface apiService = ApiUtils.getAPIService();

        Call<GetLogin> call = apiService.doLogin(params);
        call.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(@NonNull Call<GetLogin> call, @NonNull Response<GetLogin> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    GetLogin response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DataManager.getInstance().setLoginData(response.getDATA().getUser());
                            DataManager.getInstance().setPassword(password);
                            DataManager.getInstance().setToken(response.getDATA().getToken());


                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                            String currentDateandTime = sdf.format(new Date());
                            DataManager.getInstance().setLastLogin(currentDateandTime);

                            DataManager.getInstance().setLogoutDuration(response.getDATA().getLogout_duration());

                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Empty response data");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<GetLogin> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure : ( please try again later");
                }
                t.printStackTrace();
            }
        });
    }

    public void dataTokenRegister() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String authClient = AppConstant.ClientValue;
        String authSecret = AppConstant.SecretValue;
        Call<GetTokenClient> call = apiService.getTokenClient(authClient, authSecret, "Android");
        call.enqueue(new Callback<GetTokenClient>() {
            @Override
            public void onResponse(@NonNull Call<GetTokenClient> call, @NonNull Response<GetTokenClient> data) {
                if (data.isSuccessful()) {
                    GetTokenClient response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DataManager.getInstance().setTokenClient(response.getDataTokenClient().getToken());
                            Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            showToast(response.getMESSAGE());
                        }
                    }else {
                        showToast("Empty response data");
                    }
                }else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetTokenClient> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    showToast("Network Failure : ( please try again later");
                }
                t.printStackTrace();
            }
        });


    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_daftar:
                dataTokenRegister();
        }

        switch (view.getId()) {
            case R.id.btn_masuk:
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edEmail.getWindowToken(), 0);

                doLogin();
        }

    }
}
