package com.codelabs.konspirasisnack.activity.ui.laporan.kas_kasir;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshKasKasir;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetReportKasKasir;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KasKasirFragment extends Fragment {

    @BindView(R.id.tv_total_kas_kasir)
    TextView tvTotalKas;
    @BindView(R.id.tv_total_uang_masuk)
    TextView tvTotalUangMasuk;
    @BindView(R.id.tv_total_uang_keluar)
    TextView tvTotalUangKeluar;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoadingData;

    KasKasirAdapter adapterKas;
    private GetReportKasKasir.DATAReportKas responseData;
    private int cashierId;


    public KasKasirFragment() {
        // Required empty public constructor
    }

    public static KasKasirFragment newInstance() {
        KasKasirFragment fragment = new KasKasirFragment();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kas_kasir, container, false);
        ButterKnife.bind(this, v);

        cashierId = DataManager.getInstance().getCashierId();
        initView();
        setKas(new RefreshKasKasir());
        return v;
    }


    private void initView() {
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterKas = new KasKasirAdapter(getActivity());
        adapterKas.setData(new ArrayList<>());
        rvData.setAdapter(adapterKas);
    }

    public void getData() {
        Utils.changeVisibility(pbLoadingData);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("cashier_id", String.valueOf(cashierId));

        Call<GetReportKasKasir> call = apiService.getReportKasKasir(auth, param);
        call.enqueue(new Callback<GetReportKasKasir>() {
            @Override
            public void onResponse(Call<GetReportKasKasir> call, Response<GetReportKasKasir> data) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetReportKasKasir response = data.body();
                    if (response != null) {
                        if (response != null) {
                            if (response.getSTATUS() == 200) {
                                adapterKas.setData(response.getDATA().getDataKasir());
                                responseData = response.getDATA();
                                getTotalUang();
                            }else {
                                Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetReportKasKasir> call, Throwable t) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                t.printStackTrace();
            }
        });

    }

    private void getTotalUang() {
        tvTotalKas.setText("Rp " + Utils.toCurrency(responseData.getTotal()));
        tvTotalUangMasuk.setText("Rp " + Utils.toCurrency(responseData.getTotal_in()));
        tvTotalUangKeluar.setText("Rp " + Utils.toCurrency(responseData.getTotal_out()));
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void setKas(RefreshKasKasir refreshKasKasir){
        getData();
    }
}
