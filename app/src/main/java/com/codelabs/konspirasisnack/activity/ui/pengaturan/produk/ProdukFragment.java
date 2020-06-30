package com.codelabs.konspirasisnack.activity.ui.pengaturan.produk;


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

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.AddProduct;
import com.codelabs.konspirasisnack.model.GetProducts;

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


public class ProdukFragment extends Fragment {


    @BindView(R.id.txt_search)
    EditText txtSearch;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    ProdukAdapter adapter;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public ProdukFragment() {
    }

    public static ProdukFragment newInstance() {
        ProdukFragment fragment = new ProdukFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_produk, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new ProdukAdapter(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        adapter.setData(new ArrayList<>());
        txtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    getProduct(txtSearch.getText().toString());
                    KeyboardUtils.hideSoftKeyboardUsingView(getActivity(), txtSearch);
                    return true;
                }
                return false;
            }
        });
        getProduct(txtSearch.getText().toString().trim());
    }

    void getProduct(String keyword) {
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(keyword))
            params.put("keyword", keyword);

        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetProducts> call = apiService.getProduct(auth, params);


        call.enqueue(new Callback<GetProducts>() {
            @Override
            public void onResponse(Call<GetProducts> call, Response<GetProducts> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetProducts response = data.body();
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
            public void onFailure(Call<GetProducts> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                Utils.showToast(getActivity(),t.getMessage());
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
    public void refreshProduct(AddProduct.DATA data){
        txtSearch.setText("");
        getProduct(txtSearch.getText().toString().trim());
    }

}
