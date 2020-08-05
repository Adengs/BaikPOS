package com.codelabs.konspirasisnack.activity.ui.pengaturan.karyawan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshKaryawan;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetKaryawan;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KaryawanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KaryawanFragment extends Fragment {


    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    private KaryawanAdapter adapter;

    public KaryawanFragment() {
        // Required empty public constructor
    }

    public static KaryawanFragment newInstance() {
        KaryawanFragment fragment = new KaryawanFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_karyawan, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new KaryawanAdapter(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        getData(new RefreshKaryawan());
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
    public void getData(RefreshKaryawan refresh) {

        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();

        Call<GetKaryawan> call = apiService.getKaryawan(auth);
        call.enqueue(new Callback<GetKaryawan>() {
            @Override
            public void onResponse(Call<GetKaryawan> call, Response<GetKaryawan> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetKaryawan response = data.body();
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
            public void onFailure(Call<GetKaryawan> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                t.printStackTrace();

            }
        });
    }
}