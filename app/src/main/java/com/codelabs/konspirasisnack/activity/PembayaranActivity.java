package com.codelabs.konspirasisnack.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshDetailOrder;
import com.codelabs.konspirasisnack.EventBus.RefreshProduct;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.PaymentItemAdapter;
import com.codelabs.konspirasisnack.adapter.PaymentMethodAdapter;
import com.codelabs.konspirasisnack.adapter.SelectedProductInvoiceAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogVoucher;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetInvoiceNumber;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetPaymentMethod;
import com.codelabs.konspirasisnack.model.PaymentModel;
import com.codelabs.konspirasisnack.utils.CheckDevice;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PembayaranActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lay_pelanggan)
    LinearLayout layPelanggan;
    @BindView(R.id.rv_invoice)
    RecyclerView rvInvoice;
    @BindView(R.id.lay_subtotal)
    LinearLayout laySubtotal;
    @BindView(R.id.lay_total)
    LinearLayout layTotal;
    @BindView(R.id.toolbar_pembayaran)
    LinearLayout toolbarPembayaran;
    @BindView(R.id.lay_pembayaran)
    RelativeLayout layPembayaran;
    @BindView(R.id.txt_bayar)
    EditText txtBayar;

    @BindView(R.id.txt_jumlah_bayar)
    EditText txtJumlahBayar;
    @BindView(R.id.btn_uangpas)
    TextView btnUangpas;
    @BindView(R.id.btn_u100)
    TextView btnU100;
    @BindView(R.id.btn_u150)
    TextView btnU150;
    @BindView(R.id.btn_u200)
    TextView btnU200;
    @BindView(R.id.btn_u250)
    TextView btnU250;
    @BindView(R.id.text_1)
    TextView text1;
    @BindView(R.id.text_2)
    TextView text2;
    @BindView(R.id.text_3)
    TextView text3;
    @BindView(R.id.text_4)
    TextView text4;
    @BindView(R.id.text_5)
    TextView text5;
    @BindView(R.id.text_6)
    TextView text6;
    @BindView(R.id.text_7)
    TextView text7;
    @BindView(R.id.text_8)
    TextView text8;
    @BindView(R.id.text_9)
    TextView text9;
    @BindView(R.id.text_clear)
    TextView textClear;
    @BindView(R.id.text_0)
    TextView text0;
    @BindView(R.id.text_hapus)
    TextView textHapus;
    @BindView(R.id.btn_bayar)
    Button btnBayar;
    @BindView(R.id.lay_bayar)
    LinearLayout layBayar;
    @BindView(R.id.sublay_sukses_bayar)
    LinearLayout sublaySuksesBayar;
    @BindView(R.id.iv_email)
    Button ivEmail;
    @BindView(R.id.iv_print)
    Button ivPrint;
    @BindView(R.id.btn_selesai)
    Button btnSelesai;
    @BindView(R.id.lay_sukses_bayar)
    RelativeLayout laySuksesBayar;
    @BindView(R.id.txt_sukses_tagihan)
    TextView txtSuksesTagihan;
    @BindView(R.id.txt_sukses_pembayaran)
    TextView txtSuksesPembayaran;
    @BindView(R.id.txt_sukses_kembalian)
    TextView txtSuksesKembalian;
    @BindView(R.id.lay_btn)
    LinearLayout layBtn;
    @BindView(R.id.rv_payment_method)
    RecyclerView rvPaymentMethod;
    @BindView(R.id.pb_loading_payment_method)
    ProgressBar pbLoadingPaymentMethod;
    @BindView(R.id.pb_loading_kiri)
    ProgressBar pbLoadingKiri;
    @BindView(R.id.lay_kiri)
    LinearLayout layKiri;
    @BindView(R.id.txt_customer_name)
    TextView txtCustomerName;
    @BindView(R.id.txt_invoice_no)
    TextView txtInvoiceNo;
    @BindView(R.id.txt_total_item)
    TextView txtTotalItem;
    @BindView(R.id.txt_subtotal)
    TextView txtSubtotal;
    @BindView(R.id.txt_tax)
    TextView txtTax;
    @BindView(R.id.txt_total)
    TextView txtTotal;
    @BindView(R.id.pb_loading_bayar)
    ProgressBar pbLoadingBayar;
    @BindView(R.id.txt_diskon)
    TextView txtDiskon;
    @BindView(R.id.txt_jenis_pesanan)
    TextView txtJenisPesanan;
    @BindView(R.id.txt_service_charge)
    TextView txtServiceCharge;
    @BindView(R.id.txt_payment_struk)
    TextView txtPaymentStruk;
    @BindView(R.id.txt_payment_date)
    TextView txtPaymentDate;
    @BindView(R.id.txt_payment_kasir)
    TextView txtPaymentKasir;
    @BindView(R.id.txt_payment_pelanggan)
    TextView txtPaymentPelanggan;
    @BindView(R.id.txt_payment_method)
    TextView txtPaymentMethod;
    @BindView(R.id.rv_item_payment)
    RecyclerView rvItemPayment;
    @BindView(R.id.txt_payment_subtotal)
    TextView txtPaymentSubtotal;
    @BindView(R.id.ll_subtotal)
    LinearLayout llSubtotal;
    @BindView(R.id.txt_struk_pajak)
    TextView txtStrukPajak;
    @BindView(R.id.txt_payment_ppn)
    TextView txtPaymentPpn;
    @BindView(R.id.ll_pajak)
    LinearLayout llPajak;
    @BindView(R.id.txt_struk_service)
    TextView txtStrukService;
    @BindView(R.id.txt_payment_pajak_service)
    TextView txtPaymentPajakService;
    @BindView(R.id.ll_service_charge)
    LinearLayout llServiceCharge;
    @BindView(R.id.txt_payment_total_harga)
    TextView txtPaymentTotalHarga;
    @BindView(R.id.ll_total_harga)
    LinearLayout llTotalHarga;
    @BindView(R.id.txt_payment_diskon)
    TextView txtPaymentDiskon;
    @BindView(R.id.ll_payment_diskon)
    LinearLayout llPaymentDiskon;
    @BindView(R.id.txt_payment_bayar)
    TextView txtPaymentBayar;
    @BindView(R.id.ll_bayar)
    LinearLayout llBayar;
    @BindView(R.id.txt_payment_kembali)
    TextView txtPaymentKembali;
    @BindView(R.id.ll_kembali)
    LinearLayout llKembali;
    @BindView(R.id.rl_btn_bayar)
    RelativeLayout rlBtnBayar;
    @BindView(R.id.txt_nama_outlet)
    TextView txtNamaOutlet;
    @BindView(R.id.txt_tempat)
    TextView txtTempat;
    @BindView(R.id.tv_tambah_diskon)
    TextView tvTambahDiskon;
    @BindView(R.id.btn_pembayaran)
    Button btnPembayaran;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.footer)
    LinearLayout footer;
    @BindView(R.id.lay_pemesanan)
    RelativeLayout layPemesanan;
    @BindView(R.id.layout_struk)
    LinearLayout layoutStruk;

    private SelectedProductInvoiceAdapter adapter;
    private PaymentMethodAdapter adapterPayment;
    private int transaction_id;

    private int diskon;
    private int pajak;

    private String pay = "";
    private GetOrderDetail.DATA detailTransaction;
    private List<GetPaymentMethod.DATA> paymentMethod;
    GetInvoiceNumber.DATA selectedInvoiceNumber;
    private boolean isSuccessBayar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        ButterKnife.bind(this);

        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());
//        tvToolbarTitle.setText(DataManager.getInstance().getInvoiceNo());

        initView();
    }

    private void initView() {

        text0.setOnClickListener(listenerButton(text0.getText().toString()));
        text1.setOnClickListener(listenerButton(text1.getText().toString()));
        text2.setOnClickListener(listenerButton(text2.getText().toString()));
        text3.setOnClickListener(listenerButton(text3.getText().toString()));
        text4.setOnClickListener(listenerButton(text4.getText().toString()));
        text5.setOnClickListener(listenerButton(text5.getText().toString()));
        text6.setOnClickListener(listenerButton(text6.getText().toString()));
        text7.setOnClickListener(listenerButton(text7.getText().toString()));
        text8.setOnClickListener(listenerButton(text8.getText().toString()));
        text9.setOnClickListener(listenerButton(text9.getText().toString()));
        btnU100.setOnClickListener(listenerButton2(btnU100.getText().toString().replace(".", "")));
        btnU150.setOnClickListener(listenerButton2(btnU150.getText().toString().replace(".", "")));
        btnU200.setOnClickListener(listenerButton2(btnU200.getText().toString().replace(".", "")));
        btnU250.setOnClickListener(listenerButton2(btnU250.getText().toString().replace(".", "")));
        textClear.setOnClickListener(listenerButton2(""));
        textHapus.setOnClickListener(listenerButton3());

        transaction_id = getIntent().getIntExtra(AppConstant.TRANSACTION_ID, 0);


//        tvToolbarTitle.setText(selectedInvoiceNumber.getInvoiceNo());


        rvInvoice.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectedProductInvoiceAdapter(this);
        adapter.setData(new ArrayList<>());
        rvInvoice.setAdapter(adapter);

        rvPaymentMethod.setLayoutManager(new LinearLayoutManager(this));
        adapterPayment = new PaymentMethodAdapter(this);
        adapterPayment.setData(new ArrayList<>());
        rvPaymentMethod.setAdapter(adapterPayment);

        getDetailOrder(new RefreshDetailOrder());
        getPaymentMethod();
        ViewTreeObserver vto = layPembayaran.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    layPembayaran.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    layPembayaran.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = layPembayaran.getMeasuredWidth();
                int height = layPembayaran.getMeasuredHeight();

                if (CheckDevice.isTablet()) {
                    toolbarPembayaran.getLayoutParams().width = width;
                    toolbarPembayaran.requestLayout();
                }

                sublaySuksesBayar.getLayoutParams().width = width / 2;
                sublaySuksesBayar.requestLayout();
            }
        });

    }


    @OnClick(R.id.btn_pembayaran)
    void onClickBtnPembayaran() {
        layPembayaran.setVisibility(View.VISIBLE);
        layPemesanan.setVisibility(View.GONE);
    }

    private void getPaymentMethod() {
        Utils.changeVisibility(pbLoadingPaymentMethod);
        Utils.changeVisibility(rvPaymentMethod);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetPaymentMethod> call = apiService.getPaymentMethod(auth);
        call.enqueue(new Callback<GetPaymentMethod>() {
            @Override
            public void onResponse(Call<GetPaymentMethod> call, Response<GetPaymentMethod> data) {
                Utils.changeVisibility(pbLoadingPaymentMethod);
                Utils.changeVisibility(rvPaymentMethod);
                if (data.isSuccessful()) {
                    GetPaymentMethod response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            paymentMethod = response.getDATA();
                            adapterPayment.setData(response.getDATA());
                            if (response.getDATA().size() > 0)
                                adapterPayment.setPosition(0);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPaymentMethod> call, Throwable t) {
                Utils.changeVisibility(pbLoadingPaymentMethod);
                Utils.changeVisibility(rvPaymentMethod);
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
    public void getDetailOrder(RefreshDetailOrder order) {
        Utils.changeVisibility(pbLoadingKiri);
        Utils.changeVisibility(layKiri);
        if (!CheckDevice.isTablet())
            btnPembayaran.setVisibility(View.GONE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetOrderDetail> call = apiService.getOrderDetail(auth, transaction_id);
        call.enqueue(new Callback<GetOrderDetail>() {
            @Override
            public void onResponse(Call<GetOrderDetail> call, Response<GetOrderDetail> data) {
                Utils.changeVisibility(pbLoadingKiri);
                Utils.changeVisibility(layKiri);

                if (!CheckDevice.isTablet())
                    btnPembayaran.setVisibility(View.VISIBLE);
                if (data.isSuccessful()) {
                    GetOrderDetail response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            detailTransaction = response.getDATA();
//                            DataManager.getInstance().doClearInvoiceNumber();
                            initData(response.getDATA());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetail> call, Throwable t) {
                Utils.changeVisibility(pbLoadingKiri);
                Utils.changeVisibility(layKiri);
                if (!CheckDevice.isTablet())
                    btnPembayaran.setVisibility(View.VISIBLE);
                t.printStackTrace();
            }
        });

    }

    private void initData(GetOrderDetail.DATA data) {
        txtCustomerName.setText(data.getCustomer().getCustId() == 0 ? "" : data.getCustomer().getCustFullname());
        txtInvoiceNo.setText(data.getTransCode());

        txtSubtotal.setText("Rp " + Utils.toCurrency(data.getTransSubtotal().replace(".00", "")));
        txtTax.setText("Rp " + Utils.toCurrency(data.getTransTaxValue().replace(".00", "")));
        txtTotal.setText("Rp " + Utils.toCurrency(data.getTransTotal().replace(".00", "")));
        txtBayar.setText("Rp " + Utils.toCurrency(data.getTransTotal().replace(".00", "")));
        txtDiskon.setText("Rp " + Utils.toCurrency(data.getTransDiscountValue().replace(".00", "")));
        txtServiceCharge.setText("Rp " + Utils.toCurrency(data.getService_charge_value().replace(".00", "")));
        btnUangpas.setOnClickListener(listenerButton2(detailTransaction.getTransTotal().replace(".00", "")));
        adapter.setData(data.getTransactionItems());
        int countTotalItem = 0;
        for (GetOrderDetail.DATA.TransactionItems trItem : data.getTransactionItems())
            countTotalItem += Integer.parseInt(trItem.getTrItemQty().replace(".00", ""));
        txtTotalItem.setText(String.valueOf(countTotalItem));
        txtJenisPesanan.setText(data.getOrderTypeName());
    }

    @OnClick(R.id.btn_bayar)
    public void odBayarClicked() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoadingBayar);
        Utils.changeVisibility(btnBayar);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("invoice_no", detailTransaction.getTransCode());
        param.put("total_paid", detailTransaction.getTransTotal().replace(".00", ""));
        param.put("payment_amount", pay);
        param.put("payment_method_id", paymentMethod.get(adapterPayment.getPosition()).getPmId() + "");
        param.put("payment_method_name", paymentMethod.get(adapterPayment.getPosition()).getPmName() + "");
        param.put("payment_method_code", paymentMethod.get(adapterPayment.getPosition()).getPmCode() + "");
        param.put("payment_method_image", paymentMethod.get(adapterPayment.getPosition()).getPmImage() + "");
        param.put("payment_method_charge", paymentMethod.get(adapterPayment.getPosition()).getPmServiceCharge() + "");

        Call<PaymentModel> call = apiService.paymentPay(auth, param);
        call.enqueue(new Callback<PaymentModel>() {
            @Override
            public void onResponse(Call<PaymentModel> call, Response<PaymentModel> data) {
                Utils.changeVisibility(pbLoadingBayar);
                Utils.changeVisibility(btnBayar);
                if (data.isSuccessful()) {
                    PaymentModel response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {

                            Toast.makeText(PembayaranActivity.this, "bayar" + "" + response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            isSuccessBayar = true;
                            hideDiskon();
                            DataManager.getInstance().doClearParamReservation();
                            DataManager.getInstance().clearOrderDetail();
                            EventBus.getDefault().post(new RefreshProduct());
                            initSuccessPayment(response.getDATA());


                        } else {
                            Toast.makeText(PembayaranActivity.this, response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<PaymentModel> call, Throwable t) {
                Utils.changeVisibility(pbLoadingBayar);
                Utils.changeVisibility(btnBayar);
                Utils.showToast(PembayaranActivity.this,t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void hideDiskon() {
        tvTambahDiskon.setVisibility(View.GONE);
    }

    private void initSuccessPayment(PaymentModel.DATA data) {
//        txtSuksesTagihan.setText(Utils.toCurrency(detailTransaction.getTransTotal().replace(".00", "")));
//        txtSuksesPembayaran.setText(Utils.toCurrency(pay));


        txtNamaOutlet.setText(data.getOutlet().getOtName());
        txtTempat.setText(data.getOutlet().getOtAddress());

        txtPaymentStruk.setText(data.getTransCode());
        txtPaymentDate.setText(DateUtils.changeDateFormat(data.getTransPaidDate(), DateUtils.WEB_DATE_TIME_FORMAT, DateUtils.DATE_FORMAT_MONTH_NAME_FULL + " " + DateUtils.TIME_FORMAT_STANDARD_2));
        txtPaymentKasir.setText(data.getCashierName());
        txtPaymentPelanggan.setText(data.getCustomerName());
        txtPaymentMethod.setText(data.getPaymentMethodName());

        txtPaymentSubtotal.setText(Utils.toCurrency(data.getTransSubtotal().replace(".00", "")));


        txtStrukPajak.setText(getString(R.string.ppn) + " (" + data.getTransTaxPercentage().replace(".00", "") + "%)");
        txtPaymentPpn.setText(Utils.toCurrency(data.getTransTaxValue().replace(".00", "")));

        txtStrukService.setText(getString(R.string.service_charge_2) + " (" + data.getTransServicePercentage().replace(".00", "") + "%)");
        txtPaymentPajakService.setText(Utils.toCurrency(data.getTransServiceCharge().replace(".00", "")));


        txtPaymentDiskon.setText("-" + Utils.toCurrency(data.getTransDiscountValue().replace(".00", "")));

        txtPaymentTotalHarga.setText(Utils.toCurrency(data.getTransTotal().replace(".00", "")));
        txtPaymentBayar.setText(Utils.toCurrency(pay));

        int total = Integer.parseInt(detailTransaction.getTransTotal().replace(".00", ""));
        int bayar = Integer.parseInt(pay);
        int kembalian = bayar - total;

//        txtSuksesKembalian.setText(Utils.toCurrency(String.valueOf(kembalian)));
        txtPaymentKembali.setText(Utils.toCurrency(String.valueOf(kembalian)));

        rvItemPayment.setLayoutManager(new LinearLayoutManager(this));
        PaymentItemAdapter adapterPaymentItem = new PaymentItemAdapter(this);
        adapterPaymentItem.setData(data.getTransactionItems());
        rvItemPayment.setAdapter(adapterPaymentItem);
        Utils.changeVisibility(layBayar);
        Utils.changeVisibility(laySuksesBayar);
    }

    private boolean valid() {
//        if (Integer.parseInt(detailTransaction.getTransTotal().replace(".00", "")) > Integer.parseInt(Utils.toCurrency(pay.replace(".00","")))) {
        if (Integer.parseInt(detailTransaction.getTransTotal().replace(".00", "")) > Integer.parseInt((pay.equals("") ? "0" : pay))) {
            Toast.makeText(this, getString(R.string.toast_invalid_payment_amount), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        onBackClicked();
    }

    @OnClick(R.id.iv_back)
    void onBackClicked() {
        if (!CheckDevice.isTablet()) {
            if (layPembayaran.getVisibility() == View.VISIBLE && !isSuccessBayar) {
                layPembayaran.setVisibility(View.GONE);
                layPemesanan.setVisibility(View.VISIBLE);

            } else {
                Intent i = new Intent();
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        } else {
            Intent i = new Intent();
            setResult(Activity.RESULT_OK, i);
            finish();
        }
    }

    @OnClick(R.id.btn_selesai)
    public void onSelesaiClick() {
        Intent i = new Intent();
        setResult(Activity.RESULT_OK, i);
        finish();
    }


    private View.OnClickListener listenerButton(String text) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay += text;
                txtJumlahBayar.setText(Utils.toCurrency(pay));
            }
        };
    }

    private View.OnClickListener listenerButton2(String text) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay = text;
                txtJumlahBayar.setText(Utils.toCurrency(pay));
            }
        };
    }


    private View.OnClickListener listenerButton3() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pay.length() != 0) {
                    pay = pay.substring(0, pay.length() - 1);
                    txtJumlahBayar.setText(Utils.toCurrency(pay));
                }
            }
        };
    }

    @OnClick(R.id.tv_tambah_diskon)
    public void onTambahDiskon() {
        if (detailTransaction != null)
            new DialogVoucher(this, detailTransaction.getTransCode());
    }


    @OnClick(R.id.iv_email)
    public void onClickSend() {
        Bitmap bitmap = getBitmapFromView(layoutStruk);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                bitmap, txtPaymentStruk.getText().toString(), null);

        Uri uri = Uri.parse(path);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.putExtra(Intent.EXTRA_SUBJECT, "Struk pembayaran "+txtNamaOutlet.getText().toString());
        share.putExtra(Intent.EXTRA_TEXT, "");
        if (detailTransaction.getCustomer().getCustId() != 0)
            share.putExtra(Intent.EXTRA_EMAIL, new String[]{detailTransaction.getCustomer().getCustEmail()});
        startActivity(Intent.createChooser(share, "Kirim struk"));

    }

    //create bitmap from view and returns it
    private Bitmap getBitmapFromView(LinearLayout v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.RGB_565);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        c.drawColor(Color.WHITE);
        v.draw(c);
        return b;
    }


}
