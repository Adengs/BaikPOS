package com.codelabs.konspirasisnack.activity.ui.pengaturan.kategori;


import android.os.Bundle;
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

import com.codelabs.konspirasisnack.EventBus.DialogTambahKategoriBus;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogTambahKategori;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.AddCategory;
import com.codelabs.konspirasisnack.model.GetProductCategory;
import com.codelabs.konspirasisnack.model.GetRefreshToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategoriFragment extends Fragment {


    @BindView(R.id.txt_search)
    EditText txtSearch;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    KategoriAdapter adapter;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    private GetRefreshToken data;

    public KategoriFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(GetRefreshToken data) {

        Fragment fragment = new KategoriFragment();
        ((KategoriFragment) fragment).data = data;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kategori, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new KategoriAdapter(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        adapter.setData(new ArrayList<>());
        getCategory(txtSearch.getText().toString().trim());

        txtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    getCategory(txtSearch.getText().toString().trim());
                    KeyboardUtils.hideSoftKeyboardUsingView(getActivity(), txtSearch);
                    return true;
                }
                return false;
            }
        });

    }

    private void getCategory(String category) {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Call<GetProductCategory> call = apiService.getProductCategory(auth,category);
        call.enqueue(new Callback<GetProductCategory>() {
            @Override
            public void onResponse(Call<GetProductCategory> call, Response<GetProductCategory> data) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);    if (data.isSuccessful()) {
                    GetProductCategory response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.user = KategoriFragment.this.data;
                            adapter.setData(response.getDATA());
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }


            }

            @Override
            public void onFailure(Call<GetProductCategory> call, Throwable t) {

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

    @Subscribe
    public void showDialogKategori(DialogTambahKategoriBus blabla){
        if (data.data.user.uOutletId == 1) {
            new DialogTambahKategori(getContext());
        }else{
            Toast.makeText(getActivity(), "Hanya user pusat yang dapat menambahkan kategori", Toast.LENGTH_SHORT).show();
        }

    }

    @Subscribe
    public void refreshCategory(AddCategory.DATA data){
        txtSearch.setText("");
        getCategory(txtSearch.getText().toString().trim());
    }
}
