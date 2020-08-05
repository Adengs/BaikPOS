package com.codelabs.konspirasisnack.activity.ui.pengaturan.stok;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshStock;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetStock;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StokFragment extends Fragment {

    @BindView(R.id.txt_search)
    EditText txtSearch;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    private StokAdapter adapter;

    public StokFragment() {
        // Required empty public constructor
    }

    public static StokFragment newInstance() {
        StokFragment fragment = new StokFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stok, container, false);
        ButterKnife.bind(this,v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new StokAdapter(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);

        txtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    getData(txtSearch.getText().toString());
                    KeyboardUtils.hideSoftKeyboardUsingView(getActivity(), txtSearch);
                    return true;
                }
                return false;
            }
        });

        getData(txtSearch.getText().toString().trim());
    }

    public void getData(String keyword) {
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(keyword))
            params.put("keyword", keyword);

        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Call<GetStock> call = apiService.getStock(auth, params);
        call.enqueue(new Callback<GetStock>() {
            @Override
            public void onResponse(Call<GetStock> call, Response<GetStock> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetStock response = data.body();
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
            public void onFailure(Call<GetStock> call, Throwable t) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                Utils.showToast(getActivity(),t.getMessage());
                t.printStackTrace();
            }
        });

    }

    @Subscribe
    public void refreshProduct(RefreshStock data){
        txtSearch.setText("");
        getData(txtSearch.getText().toString().trim());
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