package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.EventBus.DialogLoginOwnerBus;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetRefreshToken;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogLoginOwner extends Dialog {

    @BindView(R.id.ed_email)
    TextInputEditText edEmail;
    @BindView(R.id.ed_password)
    TextInputEditText edPassword;
    protected DialogProgress dialogProgress;

    public DialogLoginOwner(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_login_owner);
        ButterKnife.bind(this);
        setCancelable(false);

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

        doLoginPost(email, password);

    }

    @OnClick(R.id.btn_masuk)
    void onClickMasuk(){
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edEmail.getWindowToken(), 0);

        doLogin();

    }

    @OnClick(R.id.btn_close)
    void onClickClose(){
        EventBus.getDefault().post(new DialogLoginOwnerBus());
        dismiss();

    }


    public void showDialogProgress(String message) {
        if (message != null) {
            dialogProgress = new DialogProgress(getContext(), message, true);
            dialogProgress.setCancelable(false);
            dialogProgress.show();
        } else {
            dialogProgress = new DialogProgress(getContext(), "Loading ...", false);
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

    public void doLoginPost(String email, final String password) {
        showDialogProgress("Loading...");
        Map<String, String> params = new HashMap<>();
        params.put("platform", "Android");
        params.put("email", email);
        params.put("password", password);
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();

        RetrofitInterface apiService = ApiUtils.getAPIService();

        Call<GetRefreshToken> call = apiService.doLoginSetting(auth,params);
        call.enqueue(new Callback<GetRefreshToken>() {
            @Override
            public void onResponse(@NonNull Call<GetRefreshToken> call, @NonNull Response<GetRefreshToken> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    GetRefreshToken response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DataManager.setTempJson("TOKEN_SETTING",response.getDATA().getToken());
                            EventBus.getDefault().post(response);
                            dismiss();
                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Empty response data");
                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetRefreshToken> call, @NonNull Throwable t) {
                hideDialogProgress();
                showToast("Network Failure : ( please try again later");
                t.printStackTrace();
            }
        });
    }

    public void showToast(String val) {
        Toast.makeText(getContext(), val, Toast.LENGTH_SHORT).show();
    }

}
