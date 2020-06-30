package com.codelabs.konspirasisnack.activity.ui.pengaturan.promo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetPengaturanPromo;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromoFragment extends Fragment {


    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    private AdapterPromo adapter;

    public PromoFragment() {
        // Required empty public constructor
    }

    public static PromoFragment newInstance() {
        PromoFragment fragment = new PromoFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_promo, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new AdapterPromo(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        getData();
    }

    private void getData() {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();

        Call<GetPengaturanPromo> call = apiService.getPengaturanPromo(auth);
        call.enqueue(new Callback<GetPengaturanPromo>() {
            @Override
            public void onResponse(Call<GetPengaturanPromo> call, Response<GetPengaturanPromo> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetPengaturanPromo response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.setData(data.body().getDATA());

                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<GetPengaturanPromo> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                t.printStackTrace();

            }
        });
    }

}