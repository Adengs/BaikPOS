package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DummyUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.AddCustomer;
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

public class DialogTambahPelanggan extends Dialog {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.txt_point)
    EditText txtPoint;
    @BindView(R.id.txt_nama)
    TextInputEditText txtNama;
    @BindView(R.id.spin_jk)
    Spinner spinJk;
    @BindView(R.id.txt_nohp)
    TextInputEditText txtNohp;
    @BindView(R.id.txt_alamat)
    TextInputEditText txtAlamat;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;


    public DialogTambahPelanggan(Context context) {
        super(context);

        setContentView(R.layout.dialog_tambah_pelanggan);
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

        ArrayAdapter<String> adapterSpinJK = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, DummyUtils.getJenisKelamin()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinJk.setAdapter(adapterSpinJK);
    }

    @OnClick(R.id.btn_submit)
    void addCustomer() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        RetrofitInterface apiService = ApiUtils.getAPIService();

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("cust_fullname", txtNama.getText().toString().trim());
        param.put("cust_address", txtAlamat.getText().toString().trim());
        param.put("cust_gender", spinJk.getSelectedItemPosition() == 1 ? "male" : "female");
        param.put("cust_total_point", TextUtils.isEmpty(txtPoint.getText().toString().trim()) ? "0" : txtPoint.getText().toString().trim());
        param.put("cust_phone", txtNohp.getText().toString().trim());
        Call<AddCustomer> call = apiService.addCustomer(auth, param);

        call.enqueue(new Callback<AddCustomer>() {
            @Override
            public void onResponse(Call<AddCustomer> call, Response<AddCustomer> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    AddCustomer response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(response.getDATA());
                            dismiss();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddCustomer> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                t.printStackTrace();
            }
        });
    }

    private boolean valid() {
        if (TextUtils.isEmpty(txtNama.getText().toString().trim())){
            Toast.makeText(getContext(), "Isikan Nama", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (spinJk.getSelectedItemPosition() == 0){
            Toast.makeText(getContext(), "Pilih jenis kelamin", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNohp.getText().toString().trim())){
            Toast.makeText(getContext(), "Isikan No Hp", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtAlamat.getText().toString().trim())){
            Toast.makeText(getContext(), "Isikan Alamat", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }
}
