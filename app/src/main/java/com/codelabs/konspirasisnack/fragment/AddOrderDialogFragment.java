package com.codelabs.konspirasisnack.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshProduct;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.AddOrderHorizontalAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderType;
import com.codelabs.konspirasisnack.model.GetProductDetail;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Response;


public class AddOrderDialogFragment extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.iv_produk)
    ImageView imgProduk;
    @BindView(R.id.tv_nama_produk)
    TextView tvNamaProduk;
    @BindView(R.id.lay1)
    LinearLayout lay1;
    @BindView(R.id.lay_2)
    LinearLayout lay2;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.lay_3)
    LinearLayout lay3;
    @BindView(R.id.rv_multi_add_order)
    RecyclerView rvOrder;
    @BindView(R.id.btn_decrease)
    Button btnDecrease;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.btn_increase)
    Button btnIncrease;
    @BindView(R.id.btn_jumlah_harga)
    Button btnJumlahHarga;
    @BindView(R.id.txt_note)
    EditText txtNote;


    private AddOrderHorizontalAdapter mAdapterAddOrder;
    private Call<GetProductDetail> callProductDetail;
    private GetProductDetail.DATAProduct responseData;
    private GetOrderType.DATA selectedOrderType;
    int itemId;
    int pricingBy;
    int customerId;
    String namaProduk;


    Unbinder unbinder;

    public AddOrderDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_order_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    }

    private void initView() {


        ViewTreeObserver vto = lay1.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    lay1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    lay1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = lay1.getMeasuredWidth();
                int height = lay1.getMeasuredHeight();

                if (CheckDevice.isTablet()) {
                    lay2.getLayoutParams().height = height;
                    lay2.requestLayout();
                    lay3.getLayoutParams().height = height;
                    lay3.requestLayout();
                }
            }
        });

        txtNote.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txtNote.requestFocus();
            }
        });

        mAdapterAddOrder = new AddOrderHorizontalAdapter(getContext());
        rvOrder.setHasFixedSize(false);
        rvOrder.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvOrder.setAdapter(mAdapterAddOrder);
    }

    private void initVar() {
        namaProduk = getArguments().getString("nama_produk");
        tvNamaProduk.setText(namaProduk);
        itemId = getArguments().getInt("id_product");
        pricingBy = DataManager.getInstance().getTypeId();
        customerId = DataManager.getInstance().getCustomerIdProduct();
        String imageProduk = getArguments().getString("img_produk");
        Picasso.get()
                .load(imageProduk)
                .placeholder(R.color.gray_darker)
                .error(R.color.gray_darker)
                .into(imgProduk, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

    }

    private void initEvent() {
        btnClose.setOnClickListener(this);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);

    }

    private void initSetup() {

    }

    private void fetchData() {
        loadProductDetail();
    }


    public void loadProductDetail() {

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        callProductDetail = apiService.getProductDetail(auth, itemId, String.valueOf(pricingBy), String.valueOf(customerId));
        callProductDetail.enqueue(new retrofit2.Callback<GetProductDetail>() {
            @Override
            public void onResponse(@NonNull Call<GetProductDetail> call, @NonNull Response<GetProductDetail> data) {
                if (data.isSuccessful()) {
                    GetProductDetail response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseData = response.getDATA();
                            mAdapterAddOrder.setData(data.body().getDATA().getVariantsData());
                            calculate(new RefreshProduct());
                        } else {

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetProductDetail> call, Throwable t) {

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
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Override
    public void onClick(View view) {

        if (view == btnClose) {
            dismiss();
        }

        if (view == btnDecrease) {
            int jml = Integer.parseInt(tvTotal.getText().toString());

            if (jml - 1 == -1) {
                return;
            }


            tvTotal.setText(String.valueOf(--jml));
            calculate(new RefreshProduct());

        }


        if (view == btnIncrease) {

            int jml = Integer.parseInt(tvTotal.getText().toString());
            int max = responseData.getActual_stock();

            if (jml == max) {
                Toast.makeText(getActivity(), "Batas pembelian maksimal", Toast.LENGTH_SHORT).show();
                return;
            }
            tvTotal.setText(String.valueOf(++jml));
            calculate(new RefreshProduct());
        }

    }

    @Subscribe
    public void calculate(RefreshProduct product) {
        int jml = Integer.parseInt(tvTotal.getText().toString());

        String str = Utils.toCurrency(responseData.getItem_harga_jual());
        int number = Integer.parseInt(str.replace(".", ""));
        int harga = number;

        int totalHarga = harga * jml;
        for (GetProductDetail.VariantsData variant : responseData.getVariantsData())
            for (GetProductDetail.DetailData detailData : variant.getDetailData())
                if (detailData.isChecked())
                    totalHarga += Integer.parseInt(detailData.getVariant_detail_harga_jual().replace(".00", "")) * jml;
        responseData.setSubtotal(String.valueOf(totalHarga));
        responseData.setQty(jml);
        btnJumlahHarga.setText("Rp " + Utils.toCurrency(String.valueOf(totalHarga)));
    }

    @Subscribe
    public void setSelectedOrderType(GetOrderType.DATA selectedOrderType) {
        this.selectedOrderType = selectedOrderType;
    }



    @OnClick(R.id.btn_jumlah_harga)
    void onClickSubmit() {
        if (Integer.parseInt(tvTotal.getText().toString()) == 0) {
            Toast.makeText(getContext(), R.string.toast_qty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (responseData != null){
            responseData.setNote(txtNote.getText().toString().trim());
            EventBus.getDefault().post(responseData);
            dismiss();
        }else {
            Toast.makeText(getContext(), "Mohon tunggu sebentar", Toast.LENGTH_SHORT).show();
        }

    }
}
