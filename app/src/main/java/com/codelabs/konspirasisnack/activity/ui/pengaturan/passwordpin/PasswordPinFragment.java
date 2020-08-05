package com.codelabs.konspirasisnack.activity.ui.pengaturan.passwordpin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetLogin;
import com.codelabs.konspirasisnack.model.GetProfil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordPinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordPinFragment extends Fragment {


    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_nohp)
    TextView txtNohp;
    @BindView(R.id.txt_posisi)
    TextView txtPosisi;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.txt_outlet)
    TextView txtOutlet;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.btn_ubah_password)
    Button btnUbahPassword;
    @BindView(R.id.ed_pin)
    EditText edPin;
    @BindView(R.id.btn_ubah_pin)
    Button btnUbahPin;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.ll_progress)
    RelativeLayout llProgress;

    public PasswordPinFragment() {
        // Required empty public constructor
    }

    public static PasswordPinFragment newInstance() {
        PasswordPinFragment fragment = new PasswordPinFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_password_pin, container, false);
        ButterKnife.bind(this, v);
        getData();
        return v;
    }

    private void getData() {
        llMain.setVisibility(View.GONE);
        llProgress.setVisibility(View.VISIBLE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();

        Call<GetProfil> call = apiService.getProfil(auth);
        call.enqueue(new Callback<GetProfil>() {
            @Override
            public void onResponse(Call<GetProfil> call, Response<GetProfil> data) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                if (data.isSuccessful()) {
                    GetProfil response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initView(response.getDATA());
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetProfil> call, Throwable t) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                t.printStackTrace();
            }
        });

    }

    private void initView(GetLogin.UserData data) {
        txtNama.setText(data.getFullName());
        txtNohp.setText(data.getU_phone_no());
        txtPosisi.setText(data.getU_position());
        txtOutlet.setText(data.getOutlet().getOt_name());
        txtEmail.setText(data.getU_email());
    }

    @OnClick(R.id.btn_ubah_pin)
    void onClickUbahPin() {
        if (edPin.getText().toString().trim().length() != 6) {
            Toast.makeText(getActivity(), "PIN Harus 6 digit", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> param = new HashMap<>();
        param.put("pin", edPin.getText().toString().trim());
        updateProfile(param);
    }

    @OnClick(R.id.btn_ubah_password)
    void onClickUbahPassword() {
        if (edPassword.getText().toString().trim().length() < 6) {
            Toast.makeText(getActivity(), "Password minimal 6 huruf", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> param = new HashMap<>();
        param.put("password", edPassword.getText().toString().trim());
        updateProfile(param);
    }

    private void updateProfile(Map<String, String> param) {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        llMain.setVisibility(View.GONE);
        llProgress.setVisibility(View.VISIBLE);

        Call<GetProfil> call = apiService.updateProfile(auth, param);
        call.enqueue(new Callback<GetProfil>() {
            @Override
            public void onResponse(Call<GetProfil> call, Response<GetProfil> data) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                if (data.isSuccessful()) {
                    GetProfil response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            edPin.setText(null);
                            edPassword.setText(null);
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }else{
                            Utils.showToast(getContext(),data.message());
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetProfil> call, Throwable t) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                t.printStackTrace();

            }
        });

    }
}