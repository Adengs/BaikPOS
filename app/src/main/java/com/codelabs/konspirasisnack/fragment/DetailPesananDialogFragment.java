package com.codelabs.konspirasisnack.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.OnRefreshDaftarPesanan;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.DetailPesananAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogProgress;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetOrderDetail;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPesananDialogFragment extends DialogFragment {

    @BindView(R.id.txt_nama_pemesan)
    TextView txtNamaPemesan;
    @BindView(R.id.txt_no_pesanan)
    TextView txtNoPesanan;
    @BindView(R.id.txt_waktu)
    TextView txtWaktu;
    @BindView(R.id.txt_tipe)
    TextView txtTipe;
    @BindView(R.id.txt_pembayaran)
    TextView txtPembayaran;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_accept)
    Button btnAccept;
    @BindView(R.id.btn_ready_pickup)
    Button btnReadyPickup;
    @BindView(R.id.btn_collected)
    Button btnCollected;
    @BindView(R.id.rv_pesanan)
    RecyclerView rvPesanan;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.layout_main)
    NestedScrollView layoutMain;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.txt_total)
    TextView txtTotal;
    private DetailPesananAdapter adapter;
    private int transaction_id;
    private GetOrderDetail.DATA data;
    private DialogProgress dialogProgress;


    public static DetailPesananDialogFragment newInstance(int transaction_id) {

        DetailPesananDialogFragment fragment = new DetailPesananDialogFragment();
        fragment.transaction_id = transaction_id;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.dialog_detail_pesanan, null);
        ButterKnife.bind(this, v);
        setCancelable(false);
        initView();
        getDetailOrder();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    private void initView() {
        adapter = new DetailPesananAdapter(getActivity());
        rvPesanan.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPesanan.setAdapter(adapter);
    }


    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

    private void getDetailOrder() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        layoutMain.setVisibility(View.GONE);
        pbLoading.setVisibility(View.VISIBLE);
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetOrderDetail> call = apiService.getOrderDetail(auth, transaction_id);
        call.enqueue(new Callback<GetOrderDetail>() {
            @Override
            public void onResponse(Call<GetOrderDetail> call, Response<GetOrderDetail> data) {
                pbLoading.setVisibility(View.GONE);
                layoutMain.setVisibility(View.VISIBLE);
                if (data.isSuccessful()) {
                    GetOrderDetail response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DetailPesananDialogFragment.this.data = response.getDATA();
                            initData();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetail> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                layoutMain.setVisibility(View.VISIBLE);
                Utils.showToast(getActivity(), t.getMessage());
                t.printStackTrace();
            }
        });

    }

    private void initData() {
        txtNamaPemesan.setText(data.getTrans_customer_name());
        txtNoPesanan.setText(data.getTransCode());
        txtWaktu.setText(DateUtils.changeDateFormat(data.getTransDate(), DateUtils.WEB_DATE_TIME_FORMAT, DateUtils.DATE_FORMAT_MONTH_TIME_STANDARD2));
        txtTotal.setText(Utils.toCurrency(data.getTransTotal().replace(".00", "")));
        txtTipe.setText(data.getTrans_order_type_name());
        txtPembayaran.setText(data.getPayment_method_name());

        adapter.setData(data.getTransactionItems());

        if (data.getTransStatus() == 4) {
            setRejected();
        } else {
            if (data.getTransShippingStatus() == 2) {
                setGreenBtn(btnAccept);

                setEnabledBtn(btnReadyPickup);

                setDisabledBtn(btnReject);
                setDisabledBtn(btnCollected);
            } else if (data.getTransShippingStatus() == 3) {
                setGreenBtn(btnReadyPickup);
                setDisabledBtn(btnReject);
                setDisabledBtn(btnAccept);
                setEnabledBtn(btnCollected);
            } else if (data.getTransShippingStatus() == 5) {
                setGreenBtn(btnCollected);
                setDisabledBtn(btnReject);
                setDisabledBtn(btnAccept);
                setDisabledBtn(btnReadyPickup);
            }

        }
    }

    private void setGreenBtn(Button btn) {
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundColor(getResources().getColor(R.color.green_dark));
        btn.setEnabled(false);
    }

    private void setDisabledBtn(Button btn) {
        btn.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
        btn.setBackground(getResources().getDrawable(R.drawable.bg_edittext_rounded_gray));
        btn.setEnabled(false);
    }

    private void setEnabledBtn(Button btn) {
        btn.setTextColor(Color.BLACK);
        btn.setBackground(getResources().getDrawable(R.drawable.bg_edittext_rounded_gray));
        btn.setEnabled(true);
    }

    private void setRejected() {
        setGreenBtn(btnReject);
        setDisabledBtn(btnAccept);
        setDisabledBtn(btnReadyPickup);
        setDisabledBtn(btnCollected);
    }

    @OnClick(R.id.btn_accept)
    void OnClickAccept(){
        updateStatus(0,2);
    }
    @OnClick(R.id.btn_ready_pickup)
    void OnClickReadyPickup(){
        updateStatus(0,3);
    }
    @OnClick(R.id.btn_collected)
    void OnClickCollected(){
        updateStatus(0,5);
    }
    @OnClick(R.id.btn_reject)
    void OnClickReject(){
        updateStatus(4,5);
    }

    private void updateStatus(int paymentStatus, int shippingStatus) {
        showDialogProgress("Loading...");
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("invoice_no", data.getTransCode());
        if (shippingStatus != 0)
            param.put("shipping_status", shippingStatus + "");
        if (paymentStatus != 0)
            param.put("payment_status", paymentStatus + "");
        Call<DoPost> call = apiService.updateOrderStatus(auth, param);

        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new OnRefreshDaftarPesanan());
                            dismiss();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<DoPost> call, Throwable t) {
                hideDialogProgress();
                Utils.showToast(getActivity(), t.getMessage());
                t.printStackTrace();
            }
        });

    }



    public void showDialogProgress(String message) {
        if (message != null) {
            dialogProgress = new DialogProgress(getContext(), message, true);
            dialogProgress.setCancelable(false);
            dialogProgress.show();
        } else {
            dialogProgress = new DialogProgress(getContext(), "Loading ...", false);
            dialogProgress.setCancelable(false);
            dialogProgress.show();
        }
    }

    public void hideDialogProgress(){
        if (dialogProgress != null) {
            if (dialogProgress.isShowing()) {
                dialogProgress.dismiss();
            }
        }
    }

}
