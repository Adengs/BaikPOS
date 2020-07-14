package com.codelabs.konspirasisnack.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetRegisterStep1;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ed_email)
    TextInputEditText edEmail;
    @BindView(R.id.ed_password)
    TextInputEditText edPassword;
    @BindView(R.id.ed_password_repeat)
    TextInputEditText edPasswordRepeat;
    @BindView(R.id.chck_privacy_policy)
    CheckBox checkAgree;
    @BindView(R.id.btn_masuk)
    TextView btnMasuk;
    @BindView(R.id.btn_daftar)
    Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());

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

    }

    private void initEvent() {
        btnDaftar.setOnClickListener(this);
        btnMasuk.setOnClickListener(this);

    }

    private void initSetup() {

    }

    private void fetchData() {

    }

    private void doSignUp() {
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        String passwordConf = edPasswordRepeat.getText().toString();

        if (!RecentUtils.isEmailValid(email)) {
            showToast("Mohon masukkan alamat email valid anda");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            showToast("Mohon masukkan password anda");
            return;
        }

        if (TextUtils.isEmpty(passwordConf)) {
            showToast("Mohon masukkan konfirmasi password anda");
            return;
        }

        if (!passwordConf.equals(password)) {
            showToast("Password tidak sesuai");
            return;
        }

        if (checkAgree.isChecked()){

        }else {
            showToast("Mohon setujui syarat dan ketentuan");
            return;
        }

        showDialogProgress("Proses data register");


        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        params.put("password_confirmation", passwordConf);
        params.put("platform", "Android");

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenClient();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<GetRegisterStep1> call = apiService.doRegister(auth, params);
        call.enqueue(new Callback<GetRegisterStep1>() {
            @Override
            public void onResponse(@NonNull Call<GetRegisterStep1> call, @NonNull Response<GetRegisterStep1> data) {
              hideDialogProgress();
              if (data.isSuccessful()) {
                  GetRegisterStep1 response = data.body();
                  if (response != null) {
                      if (response.getSTATUS() == 200) {
                          DataManager.getInstance().setRegisterData(response.getDATA());
                          showToast(response.getMESSAGE());
                          Intent intent = new Intent(RegisterActivity.this,RegisterVerifikasiActivity.class);
                          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                          startActivity(intent);
//                          showDialogSuccess(response.getMESSAGE());
                      }else {
                          showToast(response.getMESSAGE());
                      }
                  }else {
                      showToast("Response data kosong");
                  }
              }else {
                  RecentUtils.handleRetrofitError(data.code());
              }
            }

            @Override
            public void onFailure(@NonNull Call<GetRegisterStep1> call,@NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
            }
        });
    }


    private void showDialogSuccess(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Register Message");
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                Intent intent = new Intent(RegisterActivity.this,RegisterVerifikasiActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        builder.show();
    }


    @Override
    public void onClick(View view) {

        if (view == btnMasuk) {
            Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        if (view == btnDaftar) {
            doSignUp();
        }
    }
}
