package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codelabs.konspirasisnack.EventBus.RefreshToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOpenCashier;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogKasAwal extends Dialog {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.edt_modal_awal)
    EditText edtModalAwal;
    @BindView(R.id.btn_mulai)
    Button btnMulai;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public DialogKasAwal(Context context) {
        super(context);
        setContentView(R.layout.dialog_kas_kasir_awal);
        ButterKnife.bind(this);
        initView();
        setCancelable(false);
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        show();
    }

    private void initView() {
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @OnClick(R.id.btn_mulai)
    void doSumbitKasAwal() {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnMulai);
        Map<String, String> params = new HashMap<>();
        params.put("modal_awal", edtModalAwal.getText().toString());
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();

        RetrofitInterface apiService = ApiUtils.getAPIService();

        Call<GetOpenCashier> call = apiService.openCashier(auth, params);

        call.enqueue(new Callback<GetOpenCashier>() {
            @Override
            public void onResponse(Call<GetOpenCashier> call, Response<GetOpenCashier> data) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnMulai);
                if (data.isSuccessful()) {
                    GetOpenCashier response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DataManager.getInstance().setOpenCashier(response.getDATA());
                            EventBus.getDefault().post(new RefreshToolbar());
                            dismiss();

                        }else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<GetOpenCashier> call, Throwable t) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnMulai);

                t.printStackTrace();
            }
        });
    }

}
