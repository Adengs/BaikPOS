package com.codelabs.konspirasisnack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.EditTextUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterVerifikasiActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.code_1)
    EditText code1;
    @BindView(R.id.code_2)
    EditText code2;
    @BindView(R.id.code_3)
    EditText code3;
    @BindView(R.id.code_4)
    EditText code4;
    @BindView(R.id.btn_lanjutkan)
    Button btnLanjutkan;
    @BindView(R.id.btn_kirim_ulang)
    TextView btnKirimUlang;

    private int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_verifikasi);
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

        code1.addTextChangedListener(EditTextUtils.getTextWatcher(code1, code2, false));
        code2.addTextChangedListener(EditTextUtils.getTextWatcher(code2, code3, false));
        code3.addTextChangedListener(EditTextUtils.getTextWatcher(code3, code4, false));
        code4.addTextChangedListener(EditTextUtils.getTextWatcher(code4, null, true));

        code1.setOnKeyListener(EditTextUtils.onClickDelete(null, code1, true));
        code2.setOnKeyListener(EditTextUtils.onClickDelete(code1, code2, false));
        code3.setOnKeyListener(EditTextUtils.onClickDelete(code2, code3, false));
        code4.setOnKeyListener(EditTextUtils.onClickDelete(code3, code4, false));
    }

    private void initVar() {
        selectedId = DataManager.getInstance().getU_id_reg();

    }

    private void initEvent() {
        btnKirimUlang.setOnClickListener(this);
        btnLanjutkan.setOnClickListener(this);

    }

    private void initSetup() {

    }

    private void fetchData() {

    }

    private void doSendOtp() {
        if (!valid())
            return;

        showDialogProgress("Proses data OTP");

        Map<String, String> params = new HashMap<>();
        params.put("user_id", selectedId + "");
        String pin = code1.getText().toString() + code2.getText().toString() + code3.getText().toString() + code4.getText().toString();
        params.put("otp_code", pin);

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenClient();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<DoPost> call = apiService.doRegisterOtp(auth, params);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            showToast(response.getMESSAGE());
                            Intent intent = new Intent(RegisterVerifikasiActivity.this, RegisterInformasiUsahaActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }

    private boolean valid() {
        if (TextUtils.isEmpty(code1.getText().toString().trim()) ||
                TextUtils.isEmpty(code2.getText().toString().trim()) ||
                TextUtils.isEmpty(code3.getText().toString().trim()) ||
                TextUtils.isEmpty(code4.getText().toString().trim())) {
            Toast.makeText(context, getString(R.string.message_dialog_otp), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {

        if (view == btnLanjutkan) {
            doSendOtp();
        }

        if (view == btnKirimUlang) {
            showToast("Coming soon");
        }

    }
}
