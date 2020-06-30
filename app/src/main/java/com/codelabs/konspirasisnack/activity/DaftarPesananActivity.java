package com.codelabs.konspirasisnack.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.DetailPesanan;
import com.codelabs.konspirasisnack.EventBus.OnRefreshDaftarPesanan;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.DaftarPesananAdapter;
import com.codelabs.konspirasisnack.adapter.PesananAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetOrderListData;
import com.codelabs.konspirasisnack.model.GetOrderListDate;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPesananActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.tv_tambah_pesanan)
    TextView tvTambahPesanan;
    @BindView(R.id.rv_detail)
    RecyclerView rvDetail;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.forward)
    ImageView forward;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    PesananAdapter pesananAdapter;
    DaftarPesananAdapter adapter;
    String dateNow;
    Date date;
    @BindView(R.id.txt_date)
    TextView txtDate;
    @BindView(R.id.pb_loading_data)
    ProgressBar pbLoadingData;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.btn_pesanan)
    FloatingActionButton btnPesanan;
    @BindView(R.id.ll_pesanan)
    LinearLayout llPesanan;
    private String search = "";
    private GetOrderListData.DATA responseDataOrder;
    private String transDate = "";
    private int transaction_id;
    private GetOrderDetail.DATA detailTransaction;
    private List<GetOrderListData.DATA> responseDataList = new ArrayList<>();
    GetOrderListData.DATA dataOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pesanan);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());
        initView();


    }

    private void initView() {
        date = new Date();
        initDate();

        rvData.setLayoutManager(new LinearLayoutManager(this));
        pesananAdapter = new PesananAdapter(this);
        pesananAdapter.setData(new ArrayList<>());
        rvData.setAdapter(pesananAdapter);

        rvDetail.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DaftarPesananAdapter(this);
        adapter.setData(new ArrayList<>());
        rvDetail.setAdapter(adapter);

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search = edtSearch.getText().toString();
                    if (!TextUtils.isEmpty(transDate))
                        getOrderListData(transDate);
                    KeyboardUtils.hideSoftKeyboardUsingView(DaftarPesananActivity.this, edtSearch);
                    return true;
                }
                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        pesananAdapter.setData(new ArrayList<>());
        adapter.setData(new ArrayList<>());
        getOrderListDate(false);

    }

    private void initDate() {
        dateNow = DateUtils.convertDateToString(date, DateUtils.WEB_MONTH_FORMAT);
        txtDate.setText(DateUtils.changeDateFormat(dateNow, DateUtils.WEB_MONTH_FORMAT, DateUtils.MONTH_YEAR));
    }

    @OnClick(R.id.forward)
    void forwardDate() {
        date = DateUtils.addMonthToDate(date, 1);
        initDate();
        getOrderListDate(true);
    }

    @OnClick(R.id.back)
    void backwardDate() {
        date = DateUtils.addMonthToDate(date, -1);
        initDate();
        getOrderListDate(true);
    }

    private void showPemesananLayout() {
        if (!CheckDevice.isTablet()) {
            llDate.setVisibility(View.GONE);
            llPesanan.setVisibility(View.VISIBLE);
        }
    }


    private void getOrderListDate(boolean fromNavigation) {
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("is_group", "1");
        param.put("month", DateUtils.changeDateFormat(dateNow, DateUtils.WEB_MONTH_FORMAT, DateUtils.month));
        param.put("year", DateUtils.changeDateFormat(dateNow, DateUtils.WEB_MONTH_FORMAT, DateUtils.year));
        Call<GetOrderListDate> call = apiService.getOrderListDate(auth, param);
        call.enqueue(new Callback<GetOrderListDate>() {
            @Override
            public void onResponse(Call<GetOrderListDate> call, Response<GetOrderListDate> data) {

                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetOrderListDate response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            pesananAdapter.setData(response.getDATA());

                            if (response.getDATA().size() > 0) {
                                if (!fromNavigation && !CheckDevice.isTablet())
                                    onClickItem(new DetailPesanan(response.getDATA().get(0), 0));
                                else if (fromNavigation && CheckDevice.isTablet())
                                    onClickItem(new DetailPesanan(response.getDATA().get(0), 0));
                            }
                            int pos = -1;
                            for (GetOrderListDate.DATA orderDate : response.getDATA()) {
                                pos += 1;
                                if (orderDate.getTransactionDate().equals(DateUtils.getTodayDate(DateUtils.WEB_DATE_FORMAT))) {
                                    onClickItem(new DetailPesanan(orderDate, pos));
                                }
                            }

                        } else {
                            Toast.makeText(DaftarPesananActivity.this, response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderListDate> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(rvData);
                t.printStackTrace();

            }
        });
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
    public void onClickItem(DetailPesanan detailPesanan) {
        edtSearch.setText("");
        search = "";
        pesananAdapter.setSelectedPosition(detailPesanan.getPosition());
        transDate = detailPesanan.getDate().getTransactionDate();
        getOrderListData(detailPesanan.getDate().getTransactionDate());
        showPemesananLayout();
    }

    @Subscribe
    public void refreshlist(OnRefreshDaftarPesanan refresh) {
        if (!TextUtils.isEmpty(transDate))
            getOrderListData(transDate);
    }

    void getOrderListData(String date) {
        Utils.changeVisibility(pbLoadingData);
        Utils.changeVisibility(rvDetail);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("keyword", search);
        param.put("start_date", date);
        param.put("end_date", date);
        Call<GetOrderListData> call = apiService.getOrderListData(auth, param);
        call.enqueue(new Callback<GetOrderListData>() {
            @Override
            public void onResponse(Call<GetOrderListData> call, Response<GetOrderListData> data) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvDetail);
                if (data.isSuccessful()) {
                    GetOrderListData response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.setData(response.getDATA());
                            responseDataList = response.getDATA();


                        } else {
                            Toast.makeText(DaftarPesananActivity.this, response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderListData> call, Throwable t) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvDetail);
                t.printStackTrace();
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_tambah_pesanan})
    void back() {
        finish();
    }

    @OnClick(R.id.btn_pesanan)
    void onClickFloatingPemesanan() {
        llDate.setVisibility(View.VISIBLE);
        llPesanan.setVisibility(View.GONE);
    }

//    revisi refresh
//    @OnClick({R.id.iv_back, R.id.tv_tambah_pesanan})
//    public void onSelesaiClick() {
//        Intent i = new Intent();
//        setResult(Activity.RESULT_OK,i);
//        finish();
//    }

}
