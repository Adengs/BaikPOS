package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshDetailOrder;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.VoucherAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.CheckVoucher;
import com.codelabs.konspirasisnack.model.GetVoucher;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogVoucher extends Dialog {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.txt_detail)
    TextView txtDetail;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    VoucherAdapter adapter;
    String voucher_code = "";

    String invoice_no = "";

    public DialogVoucher(@NonNull Context context, String invoiceno) {
        super(context);
        setContentView(R.layout.dialog_promo);

        this.invoice_no = invoiceno;
        ButterKnife.bind(this);
        initView();
        setCancelable(false);
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        show();
    }

    private void initView() {


//        String detail = "<ul>\n" +
//                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
//                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
//                "   <li>Vestibulum auctor dapibus neque.</li>\n" +
//                "</ul>";
//        txtDetail.setText(Html.fromHtml(detail));

        adapter = new VoucherAdapter(getContext(), new VoucherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GetVoucher.DATA item) {
                tvDetail.setVisibility(View.VISIBLE);
                txtDetail.setText(Html.fromHtml(item.getVoucherDescription()));
                voucher_code = item.getVoucherCodes().getVcCode();
            }
        });
        rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvData.setAdapter(adapter);

        getVoucherData();

    }

    void getVoucherData() {
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<GetVoucher> call = apiService.getVoucher(auth);
        call.enqueue(new Callback<GetVoucher>() {
            @Override
            public void onResponse(Call<GetVoucher> call, Response<GetVoucher> data) {
                if (data.isSuccessful()) {
                    GetVoucher response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            adapter.setDatas(response.getDATA());
                        } else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetVoucher> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    @OnClick(R.id.btn_submit)
    public void onClickGunakan() {
        if (TextUtils.isEmpty(voucher_code)) {
            Toast.makeText(getContext(), "Pilih voucher", Toast.LENGTH_SHORT).show();
            return;
        }
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Map<String, String> param = new HashMap<>();
        param.put("invoice_no", invoice_no);
        param.put("voucher_code", voucher_code);
        Call<CheckVoucher> call = apiService.voucherCheck(auth, param);
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        call.enqueue(new Callback<CheckVoucher>() {
            @Override
            public void onResponse(Call<CheckVoucher> call, Response<CheckVoucher> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    CheckVoucher response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(new RefreshDetailOrder());
                            dismiss();
                        }else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckVoucher> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

}
