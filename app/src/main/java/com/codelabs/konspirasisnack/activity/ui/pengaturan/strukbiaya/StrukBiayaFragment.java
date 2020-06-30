package com.codelabs.konspirasisnack.activity.ui.pengaturan.strukbiaya;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetSetting;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StrukBiayaFragment extends Fragment {


    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.ll_progress)
    RelativeLayout llProgress;
    @BindView(R.id.txt_header_footer_struk)
    EditText txtHeaderFooterStruk;
    @BindView(R.id.txt_jumlah_cetak)
    EditText txtJumlahCetak;
    @BindView(R.id.txt_nomer_urut)
    EditText txtNomerUrut;
    @BindView(R.id.ck_nomer_urut)
    CheckBox ckNomerUrut;
    @BindView(R.id.txt_pajak_diskon)
    EditText txtPajakDiskon;
    @BindView(R.id.ck_pajak_diskon)
    CheckBox ckPajakDiskon;
    @BindView(R.id.txt_service_charge)
    EditText txtServiceCharge;
    @BindView(R.id.ck_service_charge)
    CheckBox ckServiceCharge;
    @BindView(R.id.txt_pembulatan_pecahan)
    EditText txtPembulatanPecahan;
    @BindView(R.id.ck_pembulatan_pecahan)
    CheckBox ckPembulatanPecahan;
    @BindView(R.id.btn_edit)
    RelativeLayout btnEdit;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.ll_subtotal)
    LinearLayout llSubtotal;
    @BindView(R.id.txt_struk_pajak)
    TextView txtStrukPajak;
    @BindView(R.id.txt_struk_service)
    TextView txtStrukService;
    @BindView(R.id.ll_pajak)
    LinearLayout llPajak;
    @BindView(R.id.ll_service_charge)
    LinearLayout llServiceCharge;
    @BindView(R.id.ll_total_harga)
    LinearLayout llTotalHarga;
    @BindView(R.id.btn_preview)
    RelativeLayout btnPreview;
    @BindView(R.id.ll_content)
    ScrollView llContent;
    @BindView(R.id.btn_kembali)
    RelativeLayout btnKembali;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.footer)
    LinearLayout footer;
    @BindView(R.id.ll_preview)
    LinearLayout llPreview;
    private GetSetting.DATA data;

    public StrukBiayaFragment() {
        // Required empty public constructor
    }

    public static StrukBiayaFragment newInstance() {
        StrukBiayaFragment fragment = new StrukBiayaFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_struk_biaya, container, false);
        ButterKnife.bind(this, v);
        getData();
        return v;
    }

    private void getData() {
        llProgress.setVisibility(View.VISIBLE);
        llMain.setVisibility(View.GONE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetSetting> call = apiService.getSetting(auth);
        call.enqueue(new Callback<GetSetting>() {

            @Override
            public void onResponse(Call<GetSetting> call, Response<GetSetting> data) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                if (data.isSuccessful()) {
                    GetSetting response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            StrukBiayaFragment.this.data = response.getDATA();
                            initView();
                            initStruk();
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<GetSetting> call, Throwable t) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                t.printStackTrace();
            }
        });

    }


    @OnClick(R.id.btn_preview)
    void onClickPreview() {
        llContent.setVisibility(View.GONE);
        llPreview.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.btn_kembali)
    void onClickKembali() {
        llContent.setVisibility(View.VISIBLE);
        llPreview.setVisibility(View.GONE);
    }

    private void initStruk() {
        llServiceCharge.setVisibility(data.getSettings().getService().getIsActive() ? View.VISIBLE : View.GONE);
        llPajak.setVisibility(data.getSettings().getTax().getIsActive() ? View.VISIBLE : View.GONE);
        txtStrukPajak.setText(getString(R.string.ppn) + " (" + data.getSettings().getTax().getPercentage() + "%)");
        txtStrukService.setText(getString(R.string.service_charge_2) + " (" + data.getSettings().getService().getPercentage() + "%)");
    }

    private void initView() {
        txtHeaderFooterStruk.setText(data.getSettings().getStruk().getHeader());
        txtJumlahCetak.setText(data.getSettings().getStruk().getMaxStruk());
        txtNomerUrut.setText(data.getSettings().getStruk().getNoUrut());

        txtPajakDiskon.setText(data.getSettings().getTax().getPercentage());
        txtServiceCharge.setText(data.getSettings().getService().getPercentage());
        txtPembulatanPecahan.setText(data.getSettings().getService().getPercentage());

        ckNomerUrut.setChecked(data.getSettings().getStruk().getNoUrutIsActive());
        ckPajakDiskon.setChecked(data.getSettings().getTax().getIsActive());
        ckServiceCharge.setChecked(data.getSettings().getService().getIsActive());
        ckPembulatanPecahan.setChecked(data.getSettings().getPembulatan().getIsActive());

        ckNomerUrut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    data.getSettings().getStruk().setNoUrutIsActive("on");
                } else {
                    data.getSettings().getStruk().setNoUrutIsActive("0");
                }
            }
        });

        ckPajakDiskon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    data.getSettings().getTax().setIsActive("on");
                } else {
                    data.getSettings().getTax().setIsActive("0");
                }
            }
        });

        ckServiceCharge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    data.getSettings().getService().setIsActive("on");
                } else {
                    data.getSettings().getService().setIsActive("0");
                }
            }
        });
        ckPembulatanPecahan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    data.getSettings().getPembulatan().setIsActive("on");
                } else {
                    data.getSettings().getPembulatan().setIsActive("0");
                }
            }
        });

        txtServiceCharge.addTextChangedListener(getTextWatcher(txtServiceCharge));
        txtPajakDiskon.addTextChangedListener(getTextWatcher(txtPajakDiskon));
    }

    private TextWatcher getTextWatcher(EditText et) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(et.getText().toString().trim())) {
                    int value = Integer.parseInt(et.getText().toString().trim());
                    if (value > 100) {
                        et.setText("100");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @OnClick(R.id.btn_edit)
    void onClickBtnEdit() {
        if (!isValidEditStruk()) {
            return;
        }
        llProgress.setVisibility(View.VISIBLE);
        llMain.setVisibility(View.GONE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Map<String, String> param = new HashMap<>();
        param.put("header", txtHeaderFooterStruk.getText().toString().trim());
        param.put("max_struk", txtJumlahCetak.getText().toString().trim());
        param.put("no_urut_is_active", data.getSettings().getStruk().getRealNoUrutIsActive());
        param.put("no_urut", txtNomerUrut.getText().toString().trim());
        param.put("tax_is_active", data.getSettings().getTax().getRealIsActive());
        param.put("tax_value", txtPajakDiskon.getText().toString().trim());
        param.put("service_charge_is_active", data.getSettings().getService().getRealIsActive());
        param.put("service_charge_value", txtServiceCharge.getText().toString().trim());
        param.put("pembulatan_is_active", data.getSettings().getPembulatan().getRealIsActive());
        param.put("pembulatan", txtPembulatanPecahan.getText().toString().trim());
        Call<DoPost> call = apiService.updateSetting(auth, param);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            getData();
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<DoPost> call, Throwable t) {
                Utils.changeVisibility(llMain);
                Utils.changeVisibility(llProgress);
                t.printStackTrace();

            }
        });

    }

    private boolean isValidEditStruk() {
        if (TextUtils.isEmpty(txtHeaderFooterStruk.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan header footer struk", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtJumlahCetak.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan jumlah cetak struk", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNomerUrut.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan nomor urut struk", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtPajakDiskon.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan pajak setelah diskon", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtServiceCharge.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan service charge", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtPembulatanPecahan.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Isikan pembulatan pecahan", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}