package com.codelabs.konspirasisnack.activity.ui.pengaturan.pembayarannontunai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshPaymentMethod;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetPaymentMethod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PembayaranNonTunaiFragment extends Fragment {


    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    private AdapterPembayaranNonTunai adapter;

    public PembayaranNonTunaiFragment() {
        // Required empty public constructor
    }

    public static PembayaranNonTunaiFragment newInstance() {
        PembayaranNonTunaiFragment fragment = new PembayaranNonTunaiFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pembayaran_non_tunai, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }


    private void initView() {
        adapter = new AdapterPembayaranNonTunai(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        getData(new RefreshPaymentMethod());
    }

    @Subscribe
    public void getData(RefreshPaymentMethod refreshPaymentMethod) {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();


        Call<GetPaymentMethod> call = apiService.getPengaturanPaymentMethod(auth, "0");
        call.enqueue(new Callback<GetPaymentMethod>() {
            @Override
            public void onResponse(Call<GetPaymentMethod> call, Response<GetPaymentMethod> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetPaymentMethod response = data.body();
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
            public void onFailure(Call<GetPaymentMethod> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
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

}