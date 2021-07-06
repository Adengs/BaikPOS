package com.codelabs.konspirasisnack.activity.ui.laporan.detail_penjualan;


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

import com.codelabs.konspirasisnack.EventBus.SetDate;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetDetailPenjualan;

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

public class DetailPenjualanFragment extends Fragment {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoadingData;
    @BindView(R.id.tv_total_pendapatan)
    TextView tvTotalPendapatan;
    @BindView(R.id.tv_laba_kotor)
    TextView tvLabaKotor;
    @BindView(R.id.tv_total_transaksi)
    TextView tvTotalTransaksi;
    @BindView(R.id.tv_terima_pembayaran)
    TextView tvTerimaPembayaran;


    DetailPenjualanAdapter adapterDetail;
    private GetDetailPenjualan.DATAPenjualan responseData;
    private String date = DateUtils.getTodayDate(DateUtils.WEB_DATE_FORMAT);

    public DetailPenjualanFragment() {
        // Required empty public constructor
    }


    public static DetailPenjualanFragment newInstance() {
        DetailPenjualanFragment fragment = new DetailPenjualanFragment();
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

        View view = inflater.inflate(R.layout.fragment_detail_penjualan, container, false);
        ButterKnife.bind(this, view);
        initView();

        return view;
    }

    private void initView() {
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterDetail = new DetailPenjualanAdapter(getActivity());
        adapterDetail.setData(new ArrayList<>());
        rvData.setAdapter(adapterDetail);
        getData();
    }

    void getData() {
        Utils.changeVisibility(pbLoadingData);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("start_date", date);
        param.put("end_date", date);

        Call<GetDetailPenjualan> call = apiService.getDetailPenjualan(auth, param);
        call.enqueue(new Callback<GetDetailPenjualan>() {
            @Override
            public void onResponse(Call<GetDetailPenjualan> call, Response<GetDetailPenjualan> data) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetDetailPenjualan response = data.body();
                    if (response !=null){
                        if (response.getSTATUS() == 200) {
                            responseData = response.getDATA();
                            adapterDetail.setData(response.getDATA().getDataTransaction());
                            getDetailPenjualan();
                        }else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetDetailPenjualan> call, Throwable t) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                t.printStackTrace();

            }
        });
    }

    private void getDetailPenjualan() {
        tvTotalPendapatan.setText("Rp " + Utils.toCurrency(responseData.getSummary().getTrx_omset()));
        tvLabaKotor.setText("Rp " + Utils.toCurrency(responseData.getSummary().getTrx_gross()));
        tvTerimaPembayaran.setText("Rp " + Utils.toCurrency(responseData.getSummary().getTotal_payment()));
        tvTotalTransaksi.setText(String.valueOf(responseData.getSummary().getTotal_trx()));
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
    public void setDate(SetDate date) {
        if (date.getDate() != null)
            this.date = date.getDate();
//        this.outlet = date.getOutlet();
        getData();
    }
}
