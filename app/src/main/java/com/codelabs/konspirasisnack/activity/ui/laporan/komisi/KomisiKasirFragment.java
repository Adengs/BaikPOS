package com.codelabs.konspirasisnack.activity.ui.laporan.komisi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codelabs.konspirasisnack.EventBus.SetDate;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetReportKomisi;

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


public class KomisiKasirFragment extends Fragment {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoadingData;
//    @BindView(R.id.periode_komisi)
//    EditText periodeKomisi;
//    @BindView(R.id.spin_outlet_penjualan)
//    Spinner spinOutletPenjualan;

    KomisiKasirAdapter adapterKomisi;
    private String date = DateUtils.getTodayDate(DateUtils.WEB_DATE_FORMAT);
    private int outlet;


    public KomisiKasirFragment() {
        // Required empty public constructor
    }

    public static KomisiKasirFragment newInstance() {
        KomisiKasirFragment fragment = new KomisiKasirFragment();
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
        View v = inflater.inflate(R.layout.fragment_komisi_kasir, container, false);
        ButterKnife.bind(this, v);
        outlet = DataManager.getInstance().getOutlet().getOt_id();
        initView();
        return v;
    }


    private void initView() {
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterKomisi = new KomisiKasirAdapter(getActivity());
        adapterKomisi.setData(new ArrayList<>());
        rvData.setAdapter(adapterKomisi);
        getData();

    }

    void getData() {
//        if (outlet == 0)
//            return;

        Utils.changeVisibility(pbLoadingData);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Map<String, String> param = new HashMap<>();
        param.put("start_date", date);
        param.put("end_date",date);
        param.put("outlet_id", String.valueOf(outlet));

        Call<GetReportKomisi> call = apiService.getReportKomisi(auth, param);
        call.enqueue(new Callback<GetReportKomisi>() {
            @Override
            public void onResponse(Call<GetReportKomisi> call, Response<GetReportKomisi> data) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetReportKomisi response = data.body();
                    if (response != null){
                        if (response.getSTATUS() == 200) {
                            adapterKomisi.setData(response.getDATA());

                        }else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetReportKomisi> call, Throwable t) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                t.printStackTrace();
            }
        });
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
