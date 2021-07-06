package com.codelabs.konspirasisnack.activity.ui.penjualan;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.SetDate;
import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.activity.MainActivity;
import com.codelabs.konspirasisnack.adapter.PenjualanAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderListData;

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

public class PenjualanFragment extends Fragment {
    @BindView(R.id.txt_search)
    EditText txtSearch;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoadingData;
    @BindView(R.id.texttest)
    TextView tvTest;
    private String date = DateUtils.getTodayDate(DateUtils.WEB_DATE_FORMAT);
    PenjualanAdapter adapter;
    private int outlet = 0;

    public static PenjualanFragment newInstance() {
        PenjualanFragment fragment = new PenjualanFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EventBus.getDefault().post(new ShowHideToolbar(ShowHideToolbar.POSITION_PENJUALAN));
        View v = inflater.inflate(R.layout.fragment_penjualan, container, false);
        ButterKnife.bind(this, v);
        initView();
        outlet = ((MainActivity) getActivity()).getSelectedOutletId();

//        tvTest.setText(String.valueOf(DataManager.getInstance().getTableData().getTableId()));



//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        DialogFragment newFragment = new MpinDialogFragment();
//        newFragment.show(fm, "title");
        return v;
    }

    private void initView() {
        txtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    getData();
                    KeyboardUtils.hideSoftKeyboardUsingView(getActivity(), txtSearch);
                    return true;
                }
                return false;
            }
        });

        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PenjualanAdapter(getActivity());
        adapter.setData(new ArrayList<>());
        rvData.setAdapter(adapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getData();
            }
        }, 3000);

    }

    void getData() {
        if (outlet ==0)
            return;
        Utils.changeVisibility(pbLoadingData);
        Utils.changeVisibility(rvData);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("keyword", txtSearch.getText().toString());
        param.put("start_date", date);
        param.put("end_date", date);
        param.put("outlet_id", outlet+"");
        Call<GetOrderListData> call = apiService.getOrderListData(auth, param);
        call.enqueue(new Callback<GetOrderListData>() {
            @Override
            public void onResponse(Call<GetOrderListData> call, Response<GetOrderListData> data) {
                Utils.changeVisibility(pbLoadingData);
                Utils.changeVisibility(rvData);
                if (data.isSuccessful()) {
                    GetOrderListData response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.setData(response.getDATA());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderListData> call, Throwable t) {
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
        this.outlet = date.getOutlet();
        txtSearch.setText("");
        getData();
    }
}
