package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.AddCategory;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogTambahKategori extends Dialog {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.txt_nama_kategori)
    TextInputEditText txtNamaKategori;
    @BindView(R.id.txt_urutan)
    TextInputEditText txtUrutan;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    public DialogTambahKategori(Context context) {
        super(context);

        setContentView(R.layout.dialog_tambah_kategori);
        ButterKnife.bind(this);
        setCancelable(false);
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        show();
    }

    @OnClick(R.id.btn_submit)
    void saveCategory() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        RetrofitInterface apiService = ApiUtils.getAPIService();

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Map<String, String> param = new HashMap<>();
        param.put("category_name", txtNamaKategori.getText().toString().trim());
        param.put("sequence", txtUrutan.getText().toString().trim());
        Call<AddCategory> call = apiService.addCategory(auth, param);
        call.enqueue(new Callback<AddCategory>() {
            @Override
            public void onResponse(Call<AddCategory> call, Response<AddCategory> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    AddCategory response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(response.getDATA());
                            dismiss();
                        }else{
                            Utils.showToast(getContext(),data.message());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddCategory> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                t.printStackTrace();

            }
        });
    }

    private boolean valid() {
        if (TextUtils.isEmpty(txtNamaKategori.getText().toString().trim())){
            Toast.makeText(getContext(), getContext().getString(R.string.message_dialog_kategori), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtUrutan.getText().toString().trim())){
            Toast.makeText(getContext(), getContext().getString(R.string.message_dialog_urutan_kategori), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }
}
