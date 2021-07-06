package com.codelabs.konspirasisnack.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.DaftarPelangganAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogTambahPelanggan;
import com.codelabs.konspirasisnack.dialog.DialogTanpaPelanggan;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.AddCustomer;
import com.codelabs.konspirasisnack.model.GetCustomer;
import com.codelabs.konspirasisnack.utils.CheckDevice;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DaftarPelangganActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_tambah_pelanggan)
    TextView btnTambahPelanggan;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.rv_list_pelanggan)
    RecyclerView rvListPelanggan;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.tv_tanpa_pelanggan)
    TextView tvTanpaPelanggan;
    DaftarPelangganAdapter adapter;
    private String search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckDevice.setScreenOrientation(this,CheckDevice.isTablet());
        setContentView(R.layout.activity_daftar_pelanggan);
        ButterKnife.bind(this);

        initView();
        getData();
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void refreshCustomer(AddCustomer.DATA data){
        getData();
    }

    private void getData() {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvListPelanggan);
        RetrofitInterface apiService = ApiUtils.getAPIService();

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("keyword", search);
        Call<GetCustomer> call = apiService.getCustomer(auth, param);


        call.enqueue(new Callback<GetCustomer>() {
            @Override
            public void onResponse(Call<GetCustomer> call, Response<GetCustomer> data) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvListPelanggan);
                if (data.isSuccessful()) {
                    GetCustomer response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.setData(data.body().getDATA());
//                            responseData = response.getDATA();

                        } else {
//                            containerError.setVisibility(View.VISIBLE);
//                            tvError.setText(response.getMESSAGE());
                        }
                    } else {
//                        containerError.setVisibility(View.VISIBLE);
//                        tvError.setText(getString(R.string.no_response));

                    }
                } else {
//                    containerError.setVisibility(View.VISIBLE);
//                    RecentUtils.handleRetrofitError(data.code(), tvError);
                }

            }

            @Override
            public void onFailure(Call<GetCustomer> call, Throwable t) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvListPelanggan);
                t.printStackTrace();
            }
        });

    }

    private void initView() {
        rvListPelanggan.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DaftarPelangganAdapter(this);
        rvListPelanggan.setAdapter(adapter);

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search = edtSearch.getText().toString();
                    getData();
                    KeyboardUtils.hideSoftKeyboardUsingView(DaftarPelangganActivity.this, edtSearch);
                    return true;
                }
                return false;
            }
        });
    }


    @OnClick(R.id.iv_back)
    void closeactivity() {
        finish();
    }


    @OnClick(R.id.tv_tambah_pelanggan)
    public void onClickTambahPelanggan() {
        new DialogTambahPelanggan(this);
    }

    @OnClick(R.id.tv_tanpa_pelanggan)
    public void onClickTanpaPelanggan() {
        new DialogTanpaPelanggan(this);
    }

    @Override
    public void onClick(View view) {

    }
}
