package com.codelabs.konspirasisnack.activity.ui.home;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.codelabs.konspirasisnack.EventBus.BarcodeScanner;
import com.codelabs.konspirasisnack.EventBus.OnClickDetailPesanan;
import com.codelabs.konspirasisnack.EventBus.ProductBus;
import com.codelabs.konspirasisnack.EventBus.RefreshJenisPesanan;
import com.codelabs.konspirasisnack.EventBus.RefreshMeja;
import com.codelabs.konspirasisnack.EventBus.RefreshOrderByMeja;
import com.codelabs.konspirasisnack.EventBus.RefreshProduct;
import com.codelabs.konspirasisnack.EventBus.SetSearch;
import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.EventBus.ShowMeja;
import com.codelabs.konspirasisnack.EventBus.ShowProductOrderType;
import com.codelabs.konspirasisnack.EventBus.ShowTambahAlamat;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.activity.DaftarPelangganActivity;
import com.codelabs.konspirasisnack.activity.DaftarPesananActivity;
import com.codelabs.konspirasisnack.activity.PembayaranActivity;
import com.codelabs.konspirasisnack.adapter.MejaAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogSelectMeja;
import com.codelabs.konspirasisnack.fragment.AddOrderDialogFragment;
import com.codelabs.konspirasisnack.fragment.PesananFragment;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetCreateOrder;
import com.codelabs.konspirasisnack.model.GetCreateReservation;
import com.codelabs.konspirasisnack.model.GetCustomer;
import com.codelabs.konspirasisnack.model.GetInvoiceNumber;
import com.codelabs.konspirasisnack.model.GetOrderByReservation;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetOrderType;
import com.codelabs.konspirasisnack.model.GetProductCategory;
import com.codelabs.konspirasisnack.model.GetProductDetail;
import com.codelabs.konspirasisnack.model.GetProducts;
import com.codelabs.konspirasisnack.model.GetTable;
import com.codelabs.konspirasisnack.model.GetTambahAlamatDelivery;
import com.codelabs.konspirasisnack.model.ParamCreateOrder;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.zxing.Result;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private static final int MY_PERMISSIONS_REQUESTS = 101;
    private static final int GET_PELANGGAN = 102;
    private static final int PEMBAYARAN = 103;
    private static final int ORDER_DETAIL = 104;
    private static final int ORDER_BYMEJA = 105;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;


    Unbinder unbinder;
    @BindView(R.id.rv_produk)
    RecyclerView rvProduk;
    @BindView(R.id.btn_bayar)
    Button btnBayar;
    ProdukAdapter produkAdapter;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.tabs)
    TabLayout tabs;

    ZXingScannerView barcodeScanner;
    @BindView(R.id.lay_data)
    RelativeLayout layData;
    @BindView(R.id.lay_barcode_scanner)
    FrameLayout layBarcodeScanner;
    @BindView(R.id.lay_product)
    RelativeLayout layProduct;
    @BindView(R.id.rv_meja)
    RecyclerView rvMeja;
    @BindView(R.id.pb_loading_meja)
    ProgressBar pbLoadingMeja;
    @BindView(R.id.lay_data_meja)
    RelativeLayout layDataMeja;
    @BindView(R.id.spin_lantai)
    Spinner spinLantai;
    @BindView(R.id.lay_bottom)
    LinearLayout layBottom;
    @BindView(R.id.lay_meja)
    RelativeLayout layMeja;
    @BindView(R.id.jumlah_meja)
    TextView txtJumlahMeja;
    MejaAdapter adapterMeja;
    @BindView(R.id.pb_bayar)
    ProgressBar pbBayar;
    @BindView(R.id.btn_save_selected_produk)
    ImageView btnSaveSelectedProduk;
    @BindView(R.id.btn_delete_selected_produk)
    ImageView btnDeleteSelectedProduk;
    @BindView(R.id.btn_bukakasir)
    Button btnBukaKasir;
    @BindView(R.id.btn_cart)
    FloatingActionButton btnCart;
    @BindView(R.id.ll_main)
    RelativeLayout llMain;
    @BindView(R.id.btn_shop)
    FloatingActionButton btnShop;
    @BindView(R.id.ll_pesanan)
    RelativeLayout llPesanan;

    private int cashierOpen;
    private HomeViewModel homeViewModel;
    private PesananFragment pesananFragment;
    private int[] tabIcons = {
            R.drawable.ic_list_order,
            R.drawable.ic_pelanggan

    };
    private List<GetProductCategory.DATA> category;
    private GetCustomer.DATA selectedCustomer;
    private GetCreateReservation.DATA dataTable;
    private GetTambahAlamatDelivery.DATAShipping dataShipping;
    private List<GetProductDetail.DATAProduct> selectedProduct;
    private List<GetOrderDetail.DATA.TransactionItems> selectedItemOrder = new ArrayList<>();
    private List<GetOrderDetail.DATA.TransactionItems> selectedItemOrderByMeja = new ArrayList<>();
    private Call<GetProducts> callProduct;
    private GetOrderType.DATA selectedOrderType;
    private GetOrderDetail.DATA selectedOrderDetail;
    private GetOrderDetail.DATA selectedOrderByMeja;
    private GetInvoiceNumber.DATA selectedInvoiceNumber;
    private GetOrderDetail.DATA detailTransaction;
    private List<GetTable.DATA> responseDataTable;

    private int diskon;
    private int diskonValue;
    private int pajak;
    private int totalDiskon;
    private int totalPajak;
    private int totalDuit;
    private int pajakValue1;
    private int pajakValue2;
    private int pajakValue3;
    private long mLastClickTime = 0;
    private int promoMinValue;
    private int transaction_id;
    private ViewGroup container;
    private Boolean mLocationPermissionsGranted = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.container = container;

        EventBus.getDefault().post(new ShowHideToolbar(ShowHideToolbar.POSITION_KASIR));

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        initEvent();

        return view;
    }






    private void initStackbar(GetInvoiceNumber.DATA.Marketplace data) {
        Snackbar snackbar = Snackbar.make(container,
                data.getText(), Snackbar.LENGTH_SHORT)
                .setAction(R.string.lihat, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickDetailpesanan(new OnClickDetailPesanan());
                    }
                });
        snackbar.setActionTextColor(Color.BLACK);
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.txt_reservasi));
        if (data.getTotal() > 0)
            snackbar.show();

    }


    private void initEvent() {
        btnBayar.setOnClickListener(this);
        btnSaveSelectedProduk.setOnClickListener(this);

    }

    @OnClick(R.id.btn_cart)
    void onClickFloatingCart() {
        llMain.setVisibility(View.GONE);
        llPesanan.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_shop)
    void onClickFloatingPesanan() {
        llMain.setVisibility(View.VISIBLE);
        llPesanan.setVisibility(View.GONE);
    }


    private void initScanner() {
        barcodeScanner = new ZXingScannerView(getActivity());
        barcodeScanner.setAutoFocus(true);
        barcodeScanner.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result rawResult) {
                Log.v("Scanner Preview", rawResult.getText()); // Prints scan results
                Log.v("Scanner Preview", rawResult.getBarcodeFormat().toString());
                Utils.changeVisibility(layBarcodeScanner);
                Utils.changeVisibility(layData);
                barcodeScanner.stopCamera();
                EventBus.getDefault().post(new SetSearch(rawResult.getText()));

            }
        });
        layBarcodeScanner.addView(barcodeScanner);

    }

    @Subscribe
    public void startScanner(BarcodeScanner scanner) {
        initScanner();
        if (scanner.isStart() && layBarcodeScanner.getVisibility() == View.GONE) {
            Utils.changeVisibility(layBarcodeScanner);
            Utils.changeVisibility(layData);
            if (checkPermissionCamera())
                barcodeScanner.startCamera();
        }
    }

    boolean checkPermissionCamera() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getActivity(), Manifest.permission.CAMERA)) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
                alertBuilder.setCancelable(false);
                alertBuilder.setTitle("Permission necessary");
                alertBuilder.setMessage("CAMERA is necessary");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions((Activity) getActivity(),
                                new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionsGranted = false;
        if (requestCode == MY_PERMISSIONS_REQUESTS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            barcodeScanner.startCamera();
        }



    }

    private void initView() {
        selectedProduct = new ArrayList<>();

        setHasOptionsMenu(true);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 1) {
                    Intent i = new Intent(getActivity(), DaftarPelangganActivity.class);
                    startActivityForResult(i, GET_PELANGGAN);
                    tabLayout.getTabAt(0).select();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //tadinya this
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        produkAdapter = new ProdukAdapter(getActivity());
        rvProduk.setLayoutManager(new GridLayoutManager(getActivity(), CheckDevice.isTablet() ? 4 : 3));
        rvProduk.setAdapter(produkAdapter);

//        getCategory();
        EventBus.getDefault().post(new RefreshJenisPesanan());

        if (!CheckDevice.isTablet()) {
            viewPager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        viewPager.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    llMain.setVisibility(View.VISIBLE);
                    llPesanan.setVisibility(View.GONE);

                }
            });
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_PELANGGAN && resultCode == Activity.RESULT_OK) {
            selectedCustomer = (GetCustomer.DATA) data.getSerializableExtra(AppConstant.DATA_CUSTOMER);
//            DataManager.getInstance().setCustomerId(Integer.parseInt(String.valueOf(data.getSerializableExtra(AppConstant.ID_CUSTOMER))));
            Log.e("CEK", "onActivityResult: " + AppConstant.DATA_CUSTOMER );
            Log.e("CEK ID", "onActivityResult: " + data.getSerializableExtra(AppConstant.ID_CUSTOMER));
            Log.e("CEK NAME", "onActivityResult: " + data.getSerializableExtra(AppConstant.NAME_CUSTOMER));
            Log.e("CEK SPH", "onActivityResult: " + DataManager.getInstance().getCustomerId());

//            selectedCustomer.setCustId(Integer.parseInt(String.valueOf(data.getSerializableExtra(AppConstant.ID_CUSTOMER))));

//            ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
//            pesananFragment = PesananFragment.newInstance();
//            Intent i = new Intent();
//
//            adapter.addFragment(new Fragment(), "" +data.getStringExtra(AppConstant.NAME_CUSTOMER)+"");
//            viewPager.setAdapter(adapter);


            getCategory();
            if (!CheckDevice.isTablet()) {
                llMain.setVisibility(View.VISIBLE);
                llPesanan.setVisibility(View.GONE);
            }


        } else if (requestCode == PEMBAYARAN && resultCode == Activity.RESULT_OK) {
            selectedProduct = new ArrayList<>();
            selectedItemOrder = new ArrayList<>();
            selectedItemOrderByMeja = new ArrayList<>();


            viewPager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    EventBus.getDefault().post(selectedProduct);
//                    EventBus.getDefault().post(new ShowTambahAlamat(true));
//                    pesananFragment.setDataAlamat(new SetDataAlamat("" + "-" ,"" + "-","" + "-", "" + "-"));
//                    pesananFragment.setDataAlamat(new SetDataAlamat(alamat,alamat,alamat,alamat));
                }
            });

            selectedCustomer = null;
            dataTable = null;
            calculateTotal();


            if (selectedOrderType != null) {
                if (selectedOrderType.getTypeId() == 1)
                    showMeja(new ShowMeja(true));


                showProductOrderType(new ShowProductOrderType(true));

            }

            if (!CheckDevice.isTablet()) {
                llMain.setVisibility(View.VISIBLE);
                llPesanan.setVisibility(View.GONE);
            }


        } else if (requestCode == ORDER_DETAIL && resultCode == Activity.RESULT_OK) {
            selectedItemOrderByMeja = new ArrayList<>();

            selectedOrderDetail = new Gson().fromJson(data.getStringExtra(AppConstant.ORDER_DETAIL), GetOrderDetail.DATA.class);
            selectedItemOrder = selectedOrderDetail.getTransactionItems();

            selectedOrderType = null;

            if (selectedOrderDetail.getCustomer().getCustId() != 0) {
                DataManager.getInstance().setCustomerId(selectedOrderDetail.getCustomer().getCustId());
//                Log.e("SPH", "onActivityResult: " + selectedOrderDetail.getCustomer().getCustId() );
            }

            if (selectedOrderDetail != null) {
                if (selectedOrderDetail.getTransOrderType() == 1)
                    showMeja(new ShowMeja(false));

                if (selectedOrderDetail.getTransOrderType() == 2)
                    showMeja(new ShowMeja(false));

                if (selectedOrderDetail.getTransOrderType() == 3)
                    showMeja(new ShowMeja(false));

                if (selectedOrderDetail.getTransOrderType() == 4)
                    showMeja(new ShowMeja(false));

                if (selectedOrderDetail.getTransOrderType() == 5)
                    showMeja(new ShowMeja(false));
                getCategory();

                pesananFragment.setDataOrder(selectedItemOrder);
                pesananFragment.setDataAlamatSave(selectedOrderDetail.getDataTransactionShipping());

            }




            selectedProduct = new ArrayList<>();
            totalDuit = 0;
            for (GetOrderDetail.DATA.TransactionItems p : selectedItemOrder)
                totalDuit += p.getSubtotal();
            btnBayar.setText("Rp " + Utils.toCurrency(String.valueOf(totalDuit)));

            viewPager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    EventBus.getDefault().post(selectedProduct);
                    pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);

                }
            });

        }
    }

    @Subscribe
    public void onClickDetailpesanan(OnClickDetailPesanan onclick) {
        startActivityForResult(new Intent(getActivity(), DaftarPesananActivity.class), ORDER_DETAIL);

    }


    @Subscribe
    public void onClickProduct(GetProducts.DATABean produk) {
        if (selectedOrderType != null) {
            AddOrderDialogFragment addOrderDialogFragment = new AddOrderDialogFragment();
            addOrderDialogFragment.show(getChildFragmentManager(), addOrderDialogFragment.getTag());
            Bundle data = new Bundle();
            data.putString("nama_produk", produk.getItemName());
            data.putString("img_produk", produk.getItemImage());
            data.putInt("id_product", produk.getItemId());
            addOrderDialogFragment.setArguments(data);
        } else if (selectedOrderDetail != null) {
            AddOrderDialogFragment addOrderDialogFragment = new AddOrderDialogFragment();
            addOrderDialogFragment.show(getChildFragmentManager(), addOrderDialogFragment.getTag());
            Bundle data = new Bundle();
            data.putString("nama_produk", produk.getItemName());
            data.putString("img_produk", produk.getItemImage());
            data.putInt("id_product", produk.getItemId());
            addOrderDialogFragment.setArguments(data);
        } else {
            Toast.makeText(getActivity(), "Pilih jenis pesanan", Toast.LENGTH_SHORT).show();
        }

    }

    private void getCategory() {
        pbLoading.setVisibility(View.VISIBLE);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetProductCategory> call = apiService.getProductCategory(auth, "");
        call.enqueue(new Callback<GetProductCategory>() {
            @Override
            public void onResponse(Call<GetProductCategory> call, Response<GetProductCategory> data) {
                pbLoading.setVisibility(View.GONE);
                if (data.isSuccessful()) {
                    GetProductCategory response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            category = response.getDATA();
                            initTabsCategory();
                        } else {
                        }
                    } else {
                    }
                } else {
                }


            }

            @Override
            public void onFailure(Call<GetProductCategory> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });
    }


    private void initMeja() {
        Utils.changeVisibility(pbLoadingMeja);
        Utils.changeVisibility(rvMeja);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetTable> call = apiService.getTable(auth);
        call.enqueue(new Callback<GetTable>() {
            @Override
            public void onResponse(Call<GetTable> call, Response<GetTable> data) {
                Utils.changeVisibility(pbLoadingMeja);
                Utils.changeVisibility(rvMeja);
                if (data.isSuccessful()) {
                    GetTable response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseDataTable = response.getDATA();
                            if (responseDataTable != null) {
                                initFloor(data.body().getDATA());
                            }

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
            public void onFailure(Call<GetTable> call, Throwable t) {
                Utils.changeVisibility(pbLoadingMeja);
                Utils.changeVisibility(rvMeja);
                t.printStackTrace();
            }
        });

    }

    private void initOrderMeja() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetOrderByReservation> call = apiService.getOrderByReservation(auth, transaction_id);
        call.enqueue(new Callback<GetOrderByReservation>() {
            @Override
            public void onResponse(Call<GetOrderByReservation> call, Response<GetOrderByReservation> data) {
                if (data.isSuccessful()) {
                    GetOrderByReservation response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderByReservation> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void initFloor(List<GetTable.DATA> data) {
        if (getActivity() != null) {

            List<String> sData = new ArrayList<>();
            for (GetTable.DATA selectedData : data)
                sData.add(selectedData.getFloorName());
            ArrayAdapter<String> adapterLantai = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sData) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View v = super.getView(position, convertView, parent);

                    v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                    return v;
                }
            };
            spinLantai.setAdapter(adapterLantai);
            spinLantai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    if (getActivity() != null) {
                        txtJumlahMeja.setText(data.get(i).getJumlahMeja() + " " + getString(R.string.meja));
                        rvMeja.setLayoutManager(new GridLayoutManager(getActivity(), CheckDevice.isTablet() ? 4 : 3));
                        adapterMeja = new MejaAdapter(getActivity());
                        adapterMeja.setData(data.get(i).getMeja());
                        rvMeja.setAdapter(adapterMeja);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    private void initTabsCategory() {
        tabs.removeAllTabs();
        TabLayout.Tab ftab = tabs.newTab();
        ftab.setText("Semua");
        ftab.setContentDescription("");
        tabs.addTab(ftab);

        for (GetProductCategory.DATA cat : category) {

            TabLayout.Tab tab = tabs.newTab();
            tab.setText(cat.getItemCatName());
            tab.setContentDescription(cat.getItemCatId() + "");
            tabs.addTab(tab);
        }

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getProduct((String) tab.getContentDescription(), "", "Tab Selected");
                EventBus.getDefault().post(new SetSearch(""));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getProduct("Semua", "", "Init Tabs");

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);


//
//        LinearLayout tabLinearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
//        TextView tabContent = (TextView) tabLinearLayout.findViewById(R.id.tabContent);
//        tabContent.setText("  " + tabLayout.getTabAt(1).getText());
//        tabContent.setCompoundDrawablesWithIntrinsicBounds(tabIcons[1], 0, 0, 0);
//        tabLayout.getTabAt(1).setCustomView(tabContent);


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        pesananFragment = PesananFragment.newInstance();
//        Intent i = new Intent();
//        String title = "PELANGGAN";
//        if (selectedOrderDetail.getCustomer().getCustId() != 0) {
//            title = selectedOrderDetail.getCustomer().getCustFullname();
//        }

//        selectedCustomer = (GetCustomer.DATA) data.getSerializableExtra(AppConstant.DATA_CUSTOMER);

//        adapter.addFragment(pesananFragment, "" +selectedCustomer.getCustFullname()+"");
        adapter.addFragment(pesananFragment, "PESANAN");
        adapter.addFragment(new Fragment(), "PELANGGAN");
        viewPager.setAdapter(adapter);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    void getProduct(String category_id, String keyword, String source) {
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(category_id) && !category_id.equals("Semua"))
            params.put("category_id", category_id);
        if (!TextUtils.isEmpty(keyword))
            params.put("keyword", keyword);

        if (selectedOrderDetail != null) {
            params.put("pricing_by", String.valueOf(selectedOrderDetail.getTransOrderType()));
        }

        if (selectedOrderType != null) {
            params.put("pricing_by", String.valueOf(selectedOrderType.getTypeId()));
        }

        if (selectedCustomer != null)
            params.put("customer_id", String.valueOf(selectedCustomer.getCustId()));


//        if (selectedOrderType != null){
//            params.put("pricing_by", String.valueOf(selectedOrderType.getTypeId()));
//
//        }


        produkAdapter.setData(new ArrayList<>());
//        Utils.changeVisibility(pbLoading);
        pbLoading.setVisibility(View.VISIBLE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        callProduct = apiService.getProduct(auth, params);
        callProduct.enqueue(new Callback<GetProducts>() {
            @Override
            public void onResponse(Call<GetProducts> call, Response<GetProducts> data) {
                pbLoading.setVisibility(View.GONE);
                if (data.isSuccessful()) {
                    GetProducts response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            Log.e("Get Product Source", source);
                            produkAdapter.setData(data.body().getDATA());

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
            public void onFailure(Call<GetProducts> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                if (!call.isCanceled())
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
    public void onSearchSubmit(String s) {
        getProduct((String) tabs.getTabAt(tabs.getSelectedTabPosition()).getContentDescription(), s, "Search Product");
    }

    @Subscribe
    public void showMeja(ShowMeja meja) {
        if (meja.isShowing()) {
            layProduct.setVisibility(View.GONE);
            layMeja.setVisibility(View.VISIBLE);
            initMeja();
//            initOrderMeja();
        } else {
            layMeja.setVisibility(View.GONE);
            layProduct.setVisibility(View.VISIBLE);
        }
    }

    @Subscribe
    public void showProductOrderType(ShowProductOrderType productOrderType) {
        if (productOrderType.productOrderType()) {
            getCategory();
            produkAdapter.setData(new ArrayList<>());
            selectedItemOrder = new ArrayList<>();
//            pesananFragment.setDataOrder(selectedItemOrder);
            selectedItemOrderByMeja = new ArrayList<>();
//            pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);
            selectedProduct = new ArrayList<>();
            EventBus.getDefault().post(selectedProduct);
            calculateTotal();
        } else {

        }
    }

    @Subscribe
    public void showSelectedMeja(GetTable.DATA.Meja meja) {
        new DialogSelectMeja(getActivity(), adapterMeja.getData(), meja, selectedCustomer);
    }


    @Subscribe
    public void setMejaShow(RefreshMeja refreshMeja) {
        showMeja(new ShowMeja(false));


    }

    @Subscribe
    public void setOrderMeja(RefreshOrderByMeja refreshOrderByMeja) {
        showMeja(new ShowMeja(false));
        transaction_id = DataManager.getInstance().getTransId();
        getDetailOrder();
    }

    private void getDetailOrder() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetOrderDetail> call = apiService.getOrderDetail(auth, transaction_id);
        call.enqueue(new Callback<GetOrderDetail>() {
            @Override
            public void onResponse(Call<GetOrderDetail> call, Response<GetOrderDetail> data) {
                if (data.isSuccessful()) {
                    GetOrderDetail response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            detailTransaction = response.getDATA();
                            selectedItemOrderByMeja = detailTransaction.getTransactionItems();
                            pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);
                            calculateTotal();
                            Toast.makeText(getContext(), "Trans id" + " " + detailTransaction.getTransId(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetail> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }


    @Subscribe
    public void addSelectedProduct(GetProductDetail.DATAProduct produk) {
        selectedProduct.add(produk);
        EventBus.getDefault().post(selectedProduct);
        calculateTotal();
    }


    void calculateTotal() {
        totalDuit = 0;
        for (GetProductDetail.DATAProduct p : selectedProduct)
            totalDuit += Integer.parseInt(p.getSubtotal());
        for (GetOrderDetail.DATA.TransactionItems p : selectedItemOrder)
            totalDuit += p.getSubtotal();
        for (GetOrderDetail.DATA.TransactionItems p : selectedItemOrderByMeja)
            totalDuit += p.getSubtotal();
        btnBayar.setText("Rp " + Utils.toCurrency(String.valueOf(totalDuit)));


        if (selectedItemOrder.size() > 0) {
            btnDeleteSelectedProduk.setVisibility(View.VISIBLE);
            btnSaveSelectedProduk.setVisibility(View.VISIBLE);
        } else if (selectedProduct.size() > 0) {
            btnSaveSelectedProduk.setVisibility(View.VISIBLE);
            btnDeleteSelectedProduk.setVisibility(View.VISIBLE);
        } else {
            btnDeleteSelectedProduk.setVisibility(View.GONE);
            btnSaveSelectedProduk.setVisibility(View.GONE);
        }

    }


    @Subscribe
    public void setSelectedOrderType(GetOrderType.DATA selectedOrderType) {
        this.selectedOrderType = selectedOrderType;
    }


    private void loadInvoiceNumber() {

//        Utils.changeVisibility(pbBayar);
//        Utils.changeVisibility(btnBayar);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetInvoiceNumber> callGetInvoiceNumber = apiService.getInvoiceNumber(auth);
        callGetInvoiceNumber.enqueue(new Callback<GetInvoiceNumber>() {
            @Override
            public void onResponse(@NonNull Call<GetInvoiceNumber> call, @NonNull Response<GetInvoiceNumber> data) {
                if (data.isSuccessful()) {
                    GetInvoiceNumber response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            selectedInvoiceNumber = response.getDATA();
                            if (selectedInvoiceNumber != null) {
                                createOrder(response.getDATA());
                                initStackbar(response.getDATA().getMarketplace());
                            }


//                            DataManager.getInstance().setInvoiceNumber(response.getDATA());
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetInvoiceNumber> call, @NonNull Throwable t) {
//                Utils.changeVisibility(pbBayar);
//                Utils.changeVisibility(btnBayar);
                t.printStackTrace();
            }
        });
    }


    private void createOrder(GetInvoiceNumber.DATA invoiceCreate) {

        if (invoiceCreate.getPromoList().getBasic().getPromoMinValue() != null) {
            promoMinValue = (Integer.parseInt(selectedInvoiceNumber.getPromoList().getBasic().getPromoMinValue().replace(".00", "")));
        } else {
            promoMinValue = 0;
        }

        if (invoiceCreate.getPromoList().getBasic().getPromoValue() != null) {
            diskon = (Integer.parseInt(selectedInvoiceNumber.getPromoList().getBasic().getPromoValue().replace(".00", "")));
        } else {
            diskon = 0;
        }

        if (totalDuit < promoMinValue) {
            diskonValue = 0;
        } else {
            diskonValue = diskon;
        }


        pajak = (Integer.parseInt(selectedInvoiceNumber.getSettings().getTax().getPercentage()));
        totalDiskon = (diskonValue * totalDuit) / 100;
        totalPajak = (pajak * totalDuit) / 100;
        pajakValue1 = totalPajak;


        ParamCreateOrder param = new ParamCreateOrder();
        if (selectedOrderDetail != null) {
            param.setInvoice_no(selectedOrderDetail.getTransCode());
        } else if (detailTransaction != null) {
            param.setInvoice_no(detailTransaction.getTransCode());
        } else {
            param.setInvoice_no(invoiceCreate.getInvoiceNo());
        }

        ParamCreateOrder.ShippingData shipping = new ParamCreateOrder.ShippingData();

        if (selectedOrderType != null) {
            if (selectedOrderType.getTypeId() == 3) {
                if (selectedCustomer != null) {
                    shipping.setName(selectedCustomer.getCustFullname());
                }else {
                    Toast.makeText(getActivity(), "Pilih data pelanggan", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedOrderDetail == null && DataManager.getInstance().getAddressTambah().equals("")){
                    Toast.makeText(getActivity(), "Pilih alamat delivery", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    shipping.setAddress(DataManager.getInstance().getAddressTambah());
                    shipping.setLatitude(DataManager.getInstance().getLatitudeTambah());
                    shipping.setLongitude(DataManager.getInstance().getLongitudeTambah());
                    shipping.setDatetime(DataManager.getInstance().getDateTimeTambah());
                }
            }
        }


        if (selectedOrderDetail != null){
            shipping.setName(selectedOrderDetail.getDataTransactionShipping().getTs_to_name());
            shipping.setAddress(selectedOrderDetail.getDataTransactionShipping().getTs_to_address());
            shipping.setLatitude(selectedOrderDetail.getDataTransactionShipping().getTs_to_lat());
            shipping.setLongitude(selectedOrderDetail.getDataTransactionShipping().getTs_to_long());
            shipping.setDatetime(selectedOrderDetail.getDataTransactionShipping().getTs_request_date());
        }

        param.setServed_by(DataManager.getInstance().getU_id_cashier());
        param.setMergeTablesRes(DataManager.getInstance().getMergeTables());
        param.setNumberOfPeopleRes(DataManager.getInstance().getNumberOfPeople());
        param.setStatusRes(DataManager.getInstance().getStatusRes());
        param.setIsReservationRes(DataManager.getInstance().getIsReservation());
        param.setNoteRes(DataManager.getInstance().getNote());
        param.setArrivalDateRes(DataManager.getInstance().getArrivalDate());
        param.setArrivalTimeRes(DataManager.getInstance().getArrivalTime());
        param.setTables(DataManager.getInstance().getTableData());


        int totalPaid = 0;
        List<ParamCreateOrder.ItemsOrder> itemOrder = new ArrayList<>();

        for (GetProductDetail.DATAProduct produk : selectedProduct) {
            ParamCreateOrder.ItemsOrder thisproduct = new ParamCreateOrder.ItemsOrder(produk.getItem_id());

            thisproduct.setQty(produk.getQty());
            thisproduct.setActual_price(produk.getItem_harga_jual());
            thisproduct.setHarga_modal(produk.getItem_harga_modal());
            thisproduct.setNote(produk.getNote());
            thisproduct.setService_charge(produk.getItem_service_charge());
            thisproduct.setTotal_price(String.valueOf(Integer.parseInt(produk.getItem_harga_jual().replace(".00", "")) * produk.getQty()));
            thisproduct.setDiscount(produk.getPromo_actual_value());


            thisproduct.setName(produk.getItem_name());
            thisproduct.setUnit(produk.getUnit().getUnit_id());
            thisproduct.setImage(produk.getItem_image());
            thisproduct.setCategory_id(produk.getItem_category_id());
            thisproduct.setCategory_name(produk.getCategory_name_txt());

            List<ParamCreateOrder.ItemsOrder.ItemsVariants> selectedVariant = new ArrayList<>();
            for (GetProductDetail.VariantsData variant : produk.getVariantsData())
                for (GetProductDetail.DetailData detailVariant : variant.getDetailData()) {
                    if (detailVariant.isChecked()) {
                        ParamCreateOrder.ItemsOrder.ItemsVariants tvariant = new ParamCreateOrder.ItemsOrder.ItemsVariants();

                        tvariant.setName(variant.getVariant_name());
                        tvariant.setItem_name(detailVariant.getVariant_detail_name());
                        tvariant.setUnit(0);
                        tvariant.setImage("");


                        tvariant.setId(detailVariant.getVariant_detail_id());
                        tvariant.setActual_price(detailVariant.getVariant_detail_harga_jual());
                        tvariant.setHarga_modal(detailVariant.getVariant_detail_harga_modal());
                        tvariant.setIs_inventory(detailVariant.getVariant_detail_is_inventory());
                        tvariant.setTotal_price(String.valueOf(Integer.parseInt(detailVariant.getVariant_detail_harga_jual().replace(".00", "")) * produk.getQty()));
                        selectedVariant.add(tvariant);
                    }
                }
            thisproduct.setItemsVariants(selectedVariant);
            itemOrder.add(thisproduct);
            totalPaid += Integer.parseInt(produk.getSubtotal());
        }

        for (GetOrderDetail.DATA.TransactionItems orderDetail : selectedItemOrder) {

            ParamCreateOrder.ItemsOrder thisOrder = new ParamCreateOrder.ItemsOrder(orderDetail.getTrItemId());
            thisOrder.setQty(Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")));
            thisOrder.setName(orderDetail.getTr_item_name());
            thisOrder.setImage(orderDetail.getTrItemImage());
            thisOrder.setCategory_id(orderDetail.getTr_item_category_id());
            thisOrder.setCategory_name(orderDetail.getTr_item_category_name());
            thisOrder.setActual_price(orderDetail.getTrItemActualPrice());
            thisOrder.setHarga_modal(orderDetail.getTrItemHargaModal());
            thisOrder.setNote(orderDetail.getTrItemInfo());
            thisOrder.setService_charge(orderDetail.getTr_item_service_charge());
            thisOrder.setTotal_price(String.valueOf(Integer.parseInt(orderDetail.getTrItemTotalPrice().replace(".00", ""))));

            List<ParamCreateOrder.ItemsOrder.ItemsVariants> selectedVariantOrder = new ArrayList<>();
            for (GetOrderDetail.DATA.TransactionItems.Variants variantOrder : orderDetail.getVariants()) {
                ParamCreateOrder.ItemsOrder.ItemsVariants variantDetail = new ParamCreateOrder.ItemsOrder.ItemsVariants();
                variantDetail.setName(variantOrder.getTr_variant_name());
                variantDetail.setItem_name(variantOrder.getTr_variant_item_name());
                variantDetail.setUnit(0);
                variantDetail.setImage("");
                variantDetail.setId(variantOrder.getTrVariantVariantId());
                variantDetail.setActual_price(variantOrder.getTrVariantActualPrice());
                variantDetail.setHarga_modal(variantOrder.getTrVariantHargaModal());
                variantDetail.setIs_inventory(variantOrder.getTr_variant_is_inventory());
                variantDetail.setTotal_price(String.valueOf(Integer.parseInt(variantOrder.getTrVariantActualPrice().replace(".00", "")) * (Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")))));
                selectedVariantOrder.add(variantDetail);
            }
            thisOrder.setItemsVariants(selectedVariantOrder);
            itemOrder.add(thisOrder);
            totalPaid += orderDetail.getSubtotal();

        }

        for (GetOrderDetail.DATA.TransactionItems orderDetail : selectedItemOrderByMeja) {

            ParamCreateOrder.ItemsOrder thisOrder = new ParamCreateOrder.ItemsOrder(orderDetail.getTrItemId());
            thisOrder.setQty(Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")));
            thisOrder.setName(orderDetail.getTr_item_name());
            thisOrder.setImage(orderDetail.getTrItemImage());
            thisOrder.setCategory_id(orderDetail.getTr_item_category_id());
            thisOrder.setCategory_name(orderDetail.getTr_item_category_name());

            thisOrder.setActual_price(orderDetail.getTrItemActualPrice());
            thisOrder.setHarga_modal(orderDetail.getTrItemHargaModal());
            thisOrder.setNote(orderDetail.getTrItemInfo());
            thisOrder.setService_charge(orderDetail.getTr_item_service_charge());
            thisOrder.setTotal_price(String.valueOf(Integer.parseInt(orderDetail.getTrItemTotalPrice().replace(".00", ""))));
            List<ParamCreateOrder.ItemsOrder.ItemsVariants> selectedVariantOrder = new ArrayList<>();
            for (GetOrderDetail.DATA.TransactionItems.Variants variantOrder : orderDetail.getVariants()) {
                ParamCreateOrder.ItemsOrder.ItemsVariants variantDetail = new ParamCreateOrder.ItemsOrder.ItemsVariants();
                variantDetail.setName(variantOrder.getTr_variant_item_name());
                variantDetail.setItem_name(variantOrder.getTr_variant_item_name());
                variantDetail.setUnit(0);
                variantDetail.setImage("");
                variantDetail.setId(variantOrder.getTrVariantVariantId());
                variantDetail.setActual_price(variantOrder.getTrVariantActualPrice());
                variantDetail.setHarga_modal(variantOrder.getTrVariantHargaModal());
                variantDetail.setIs_inventory(variantOrder.getTr_variant_is_inventory());
                variantDetail.setTotal_price(String.valueOf(Integer.parseInt(variantOrder.getTrVariantActualPrice().replace(".00", "")) * (Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")))));
                selectedVariantOrder.add(variantDetail);
            }
            thisOrder.setItemsVariants(selectedVariantOrder);
            itemOrder.add(thisOrder);
            totalPaid += orderDetail.getSubtotal();

        }

        param.setItemsOrders(itemOrder);
        param.setShipping(shipping);

        pajakValue2 = totalPaid - totalDiskon;
        pajakValue3 = (pajak * pajakValue2) / 100;

        param.setTotal_paid(String.valueOf(totalPaid));
        param.setTotal_discount(String.valueOf(totalDiskon));
        param.setTrans_status(1 + "");

        if (selectedInvoiceNumber != null) {
            if (selectedInvoiceNumber.getSettings().getTax().getTaxType().equals("1")) {
                param.setTotal_tax(String.valueOf(pajakValue1));
            } else if (selectedInvoiceNumber.getSettings().getTax().getTaxType().equals("2")) {
                param.setTotal_tax(String.valueOf(pajakValue3));
            }
        }

        if (selectedOrderDetail != null) {
            param.setOrder_type(String.valueOf(selectedOrderDetail.getTransOrderType()));
        }

        if (selectedOrderType != null) {
            param.setOrder_type(String.valueOf(selectedOrderType.getTypeId()));
        }

//        if (selectedCustomer != null) {
//            param.setCustomer_id(selectedCustomer.getCustId());
//            param.setCustomerName(selectedCustomer.getCustFullname());
//        }

        Log.e("TAG", "createOrder: " + DataManager.getInstance().getCustomerIdProduct() );
        Log.e("TAG", "createOrder: " + DataManager.getInstance().getCustomerName() );

        if (DataManager.getInstance().getCustomerIdProduct() != 0) {
            param.setCustomer_id(DataManager.getInstance().getCustomerIdProduct());
            param.setCustomerName(DataManager.getInstance().getCustomerName());
        }
        param.setCashierName(DataManager.getInstance().getU_firstname_cashier());



        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetCreateOrder> call = apiService.createOrder(auth, param);
        call.enqueue(new Callback<GetCreateOrder>() {
            @Override
            public void onResponse(Call<GetCreateOrder> call, Response<GetCreateOrder> data) {
//                Utils.changeVisibility(pbBayar);
//                Utils.changeVisibility(btnBayar);
                if (data.isSuccessful()) {
                    GetCreateOrder response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            DataManager.getInstance().clearCustomerId();
                            EventBus.getDefault().post(new ShowTambahAlamat(response.getDATA().getTrans_order_type() == 3));
                            DataManager.getInstance().clearTambahAlamat();

//
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), PembayaranActivity.class);
                            intent.putExtra(AppConstant.TRANSACTION_ID, response.getDATA().getTrans_id());
                            startActivityForResult(intent, PEMBAYARAN);

                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<GetCreateOrder> call, Throwable t) {
                Utils.changeVisibility(pbBayar);
                Utils.changeVisibility(btnBayar);
                t.printStackTrace();

            }
        });

    }

    private void loadInvoiceNumberSave() {

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetInvoiceNumber> callGetInvoiceNumberSave = apiService.getInvoiceNumber(auth);
        callGetInvoiceNumberSave.enqueue(new Callback<GetInvoiceNumber>() {
            @Override
            public void onResponse(@NonNull Call<GetInvoiceNumber> call, @NonNull Response<GetInvoiceNumber> data) {
                if (data.isSuccessful()) {
                    GetInvoiceNumber response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            selectedInvoiceNumber = response.getDATA();
                            if (selectedInvoiceNumber != null) {
                                createOrderSave(response.getDATA());
                                initStackbar(response.getDATA().getMarketplace());
                            }


                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetInvoiceNumber> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void createOrderSave(GetInvoiceNumber.DATA invoiceSave) {
        if (invoiceSave.getPromoList().getBasic().getPromoMinValue() != null) {
            promoMinValue = (Integer.parseInt(selectedInvoiceNumber.getPromoList().getBasic().getPromoMinValue().replace(".00", "")));
        } else {
            promoMinValue = 0;
        }
        if (invoiceSave.getPromoList().getBasic().getPromoValue() != null) {
            diskon = (Integer.parseInt(selectedInvoiceNumber.getPromoList().getBasic().getPromoValue().replace(".00", "")));
        } else {
            diskon = 0;
        }
        if (totalDuit < promoMinValue) {
            diskonValue = 0;
        } else {
            diskonValue = diskon;
        }

        pajak = (Integer.parseInt(selectedInvoiceNumber.getSettings().getTax().getPercentage()));
        totalDiskon = (diskonValue * totalDuit) / 100;
        totalPajak = (pajak * totalDuit) / 100;
        pajakValue1 = totalPajak;


        ParamCreateOrder param = new ParamCreateOrder();

        if (selectedOrderDetail != null) {
            param.setInvoice_no(selectedOrderDetail.getTransCode());
        } else {
            param.setInvoice_no(invoiceSave.getInvoiceNo());
        }

        ParamCreateOrder.ShippingData shipping = new ParamCreateOrder.ShippingData();
        if (selectedOrderType != null) {
            if (selectedOrderType.getTypeId() == 3) {
                if (selectedCustomer != null) {
                    shipping.setName(selectedCustomer.getCustFullname());
                    Log.e("TAG", "Cek name 1 " + selectedCustomer.getCustFullname() );
                }else {
                    Toast.makeText(getActivity(), "Pilih data pelanggan", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (selectedOrderDetail == null && DataManager.getInstance().getAddressTambah().equals("")){
                    Toast.makeText(getActivity(), "Pilih alamat delivery", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    shipping.setAddress(DataManager.getInstance().getAddressTambah());
                    shipping.setLatitude(DataManager.getInstance().getLatitudeTambah());
                    shipping.setLongitude(DataManager.getInstance().getLongitudeTambah());
                    shipping.setDatetime(DataManager.getInstance().getDateTimeTambah());
                }
            }
        }

        if (selectedOrderDetail != null){
            shipping.setName(selectedOrderDetail.getDataTransactionShipping().getTs_to_name());
            Log.e("TAG", "cek name 2 " + selectedOrderDetail.getDataTransactionShipping().getTs_to_name() );
            shipping.setAddress(selectedOrderDetail.getDataTransactionShipping().getTs_to_address());
            shipping.setLatitude(selectedOrderDetail.getDataTransactionShipping().getTs_to_lat());
            shipping.setLongitude(selectedOrderDetail.getDataTransactionShipping().getTs_to_long());
            shipping.setDatetime(selectedOrderDetail.getDataTransactionShipping().getTs_request_date());
        }


        param.setServed_by(DataManager.getInstance().getCashierId());
        param.setMergeTablesRes(DataManager.getInstance().getMergeTables());
        param.setNumberOfPeopleRes(DataManager.getInstance().getNumberOfPeople());
        param.setStatusRes(DataManager.getInstance().getStatusRes());
        param.setIsReservationRes(DataManager.getInstance().getIsReservation());
        param.setNoteRes(DataManager.getInstance().getNote());
        param.setArrivalDateRes(DataManager.getInstance().getArrivalDate());
        param.setArrivalTimeRes(DataManager.getInstance().getArrivalTime());
        param.setTables(DataManager.getInstance().getTableData());

        int totalPaid = 0;
        List<ParamCreateOrder.ItemsOrder> itemOrder = new ArrayList<>();
        for (GetProductDetail.DATAProduct produk : selectedProduct) {
            ParamCreateOrder.ItemsOrder thisproduct = new ParamCreateOrder.ItemsOrder(produk.getItem_id());

            thisproduct.setName(produk.getItem_name());
            thisproduct.setUnit(produk.getUnit().getUnit_id());
            thisproduct.setImage(produk.getItem_image());
            thisproduct.setCategory_id(produk.getItem_category_id());
            thisproduct.setCategory_name(produk.getCategory_name_txt());


            thisproduct.setQty(produk.getQty());
            thisproduct.setActual_price(produk.getItem_harga_jual());
            thisproduct.setHarga_modal(produk.getItem_harga_modal());
            thisproduct.setNote(produk.getNote());
            thisproduct.setService_charge(produk.getItem_service_charge());
            thisproduct.setTotal_price(String.valueOf(Integer.parseInt(produk.getItem_harga_jual().replace(".00", "")) * produk.getQty()));
            thisproduct.setDiscount(produk.getPromo_actual_value());
            List<ParamCreateOrder.ItemsOrder.ItemsVariants> selectedVariant = new ArrayList<>();
            for (GetProductDetail.VariantsData variant : produk.getVariantsData())
                for (GetProductDetail.DetailData detailVariant : variant.getDetailData()) {
                    if (detailVariant.isChecked()) {
                        ParamCreateOrder.ItemsOrder.ItemsVariants tvariant = new ParamCreateOrder.ItemsOrder.ItemsVariants();

                        tvariant.setName(variant.getVariant_name());
                        tvariant.setItem_name(detailVariant.getVariant_detail_name());
                        tvariant.setUnit(0);
                        tvariant.setImage("");

                        tvariant.setId(detailVariant.getVariant_detail_id());
                        tvariant.setActual_price(detailVariant.getVariant_detail_harga_jual());
                        tvariant.setHarga_modal(detailVariant.getVariant_detail_harga_modal());
                        tvariant.setIs_inventory(detailVariant.getVariant_detail_is_inventory());
                        tvariant.setTotal_price(String.valueOf(Integer.parseInt(detailVariant.getVariant_detail_harga_jual().replace(".00", "")) * produk.getQty()));
                        selectedVariant.add(tvariant);
                    }
                }
            thisproduct.setItemsVariants(selectedVariant);
            itemOrder.add(thisproduct);
            totalPaid += Integer.parseInt(produk.getSubtotal());
        }

        for (GetOrderDetail.DATA.TransactionItems orderDetail : selectedItemOrder) {
            ParamCreateOrder.ItemsOrder thisOrder = new ParamCreateOrder.ItemsOrder(orderDetail.getTrItemId());
            thisOrder.setQty(Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")));
            thisOrder.setName(orderDetail.getTr_item_name());
            thisOrder.setImage(orderDetail.getTrItemImage());
            thisOrder.setCategory_id(orderDetail.getTr_item_category_id());
            thisOrder.setCategory_name(orderDetail.getTr_item_category_name());
            thisOrder.setActual_price(orderDetail.getTrItemActualPrice());
            thisOrder.setHarga_modal(orderDetail.getTrItemHargaModal());
            thisOrder.setNote(orderDetail.getTrItemInfo());
            thisOrder.setService_charge(orderDetail.getTr_item_service_charge());
            thisOrder.setTotal_price(String.valueOf(Integer.parseInt(orderDetail.getTrItemTotalPrice().replace(".00", ""))));
            List<ParamCreateOrder.ItemsOrder.ItemsVariants> selectedVariantOrder = new ArrayList<>();
            for (GetOrderDetail.DATA.TransactionItems.Variants variantOrder : orderDetail.getVariants()) {
                ParamCreateOrder.ItemsOrder.ItemsVariants variantDetail = new ParamCreateOrder.ItemsOrder.ItemsVariants();
                variantDetail.setName(variantOrder.getTr_variant_name());
                variantDetail.setItem_name(variantOrder.getTr_variant_item_name());
                variantDetail.setUnit(0);
                variantDetail.setImage("");
                variantDetail.setId(variantOrder.getTrVariantVariantId());
                variantDetail.setActual_price(variantOrder.getTrVariantActualPrice());
                variantDetail.setHarga_modal(variantOrder.getTrVariantHargaModal());
                variantDetail.setIs_inventory(variantOrder.getTr_variant_is_inventory());
                variantDetail.setTotal_price(String.valueOf(Integer.parseInt(variantOrder.getTrVariantActualPrice().replace(".00", "")) * (Integer.parseInt(orderDetail.getTrItemQty().replace(".00", "")))));
                selectedVariantOrder.add(variantDetail);
            }
            thisOrder.setItemsVariants(selectedVariantOrder);
            itemOrder.add(thisOrder);
            totalPaid += orderDetail.getSubtotal();

        }


        param.setItemsOrders(itemOrder);
        param.setShipping(shipping);
        pajakValue2 = totalPaid - totalDiskon;
        pajakValue3 = (pajak * pajakValue2) / 100;

        param.setTotal_paid(String.valueOf(totalPaid));
        param.setTotal_discount(String.valueOf(totalDiskon));
        param.setTrans_status(1 + "");


        if (selectedInvoiceNumber != null) {
            if (selectedInvoiceNumber.getSettings().getTax().getTaxType().equals("1")) {
                param.setTotal_tax(String.valueOf(pajakValue1));
            } else if (selectedInvoiceNumber.getSettings().getTax().getTaxType().equals("2")) {
                param.setTotal_tax(String.valueOf(pajakValue3));
            }
        }

        if (selectedOrderType != null) {
            param.setOrder_type(String.valueOf(selectedOrderType.getTypeId()));
        } else if (selectedOrderDetail != null) {
            param.setOrder_type(String.valueOf(selectedOrderDetail.getTransOrderType()));
        }

//        if (selectedCustomer != null)
//            param.setCustomer_id(selectedCustomer.getCustId());
//
        Log.e("TAG", "createOrderSave: " + DataManager.getInstance().getCustomerIdProduct() );
        Log.e("TAG", "createOrderSave: " + DataManager.getInstance().getCustomerName() );

        if (DataManager.getInstance().getCustomerIdProduct() != 0) {
            param.setCustomer_id(DataManager.getInstance().getCustomerIdProduct());
            param.setCustomerName(DataManager.getInstance().getCustomerName());
        }
        param.setCashierName(DataManager.getInstance().getU_firstname_cashier());

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetCreateOrder> call = apiService.createOrder(auth, param);
        call.enqueue(new Callback<GetCreateOrder>() {
            @Override
            public void onResponse(Call<GetCreateOrder> call, Response<GetCreateOrder> data) {
                if (data.isSuccessful()) {
                    GetCreateOrder response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {

                            DataManager.getInstance().clearCustomerId();

                            selectedProduct = new ArrayList<>();
                            selectedItemOrder = new ArrayList<>();
                            selectedItemOrderByMeja = new ArrayList<>();
//                            pesananFragment.setDataOrder(selectedItemOrder);
//                            pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);
                            EventBus.getDefault().post(selectedProduct);
                            EventBus.getDefault().post(new RefreshProduct());
                            EventBus.getDefault().post(new ShowTambahAlamat(response.getDATA().getTrans_order_type() == 3));
                            DataManager.getInstance().clearTambahAlamat();

                            if (selectedOrderType != null) {
                                if (selectedOrderType.getTypeId() == 1) {
//                                    showMeja(new ShowMeja(true));
                                    EventBus.getDefault().post(new RefreshMeja());

                                }
                            }

                            calculateTotal();
                            getCategory();

                            Toast.makeText(getActivity(), "Pesanan berhasil disimpan", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<GetCreateOrder> call, Throwable t) {
                Utils.changeVisibility(pbBayar);
                Utils.changeVisibility(btnBayar);
                t.printStackTrace();

            }
        });

    }



    private void saveOrder() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        dialog.setTitle("Simpan Pesanan");
        dialog.setMessage("Apakah anda ingin menyimpan Pesanan ini? ");
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadInvoiceNumberSave();
            }
        });
        dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Subscribe
    public void removeSelectedProduct(ProductBus product) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        dialog.setTitle(getString(R.string.title_dialog_hapus_produk));
        dialog.setMessage(getString(R.string.title_dialog_hapus_produk) + " " + product.getProduk().getItem_name() + "?");
        dialog.setPositiveButton(getString(R.string.ya), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedProduct.remove(product.getProduk());
                EventBus.getDefault().post(selectedProduct);

                calculateTotal();
            }
        });
        dialog.setNegativeButton(getString(R.string.tidak), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();

    }

    @Subscribe
    public void removeSelectedProductPesanan(GetOrderDetail.DATA.TransactionItems product) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        dialog.setTitle(getString(R.string.title_dialog_hapus_produk));
//        dialog.setMessage(getString(R.string.title_dialog_hapus_produk) + " " + product.getDetailItem().getItemName() + "?");
        dialog.setMessage(getString(R.string.title_dialog_hapus_produk) + " " + product.getTr_item_name() + "?");

        dialog.setPositiveButton(getString(R.string.ya), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedItemOrder.remove(product);
                pesananFragment.setDataOrder(selectedItemOrder);
                selectedItemOrderByMeja.remove(product);
                pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);

                calculateTotal();
            }
        });
        dialog.setNegativeButton(getString(R.string.tidak), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();

    }

    @OnClick(R.id.btn_delete_selected_produk)
    void deleteAllProduct() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        dialog.setTitle(getString(R.string.title_dialog_hapus_produk));
        dialog.setMessage(getString(R.string.message_dialog_hapus_produk));
        dialog.setPositiveButton(getString(R.string.ya), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                selectedItemOrder = new ArrayList<>();
                pesananFragment.setDataOrder(selectedItemOrder);

                selectedItemOrderByMeja = new ArrayList<>();
                pesananFragment.setDataOrderMeja(selectedItemOrderByMeja);

                selectedProduct = new ArrayList<>();
                EventBus.getDefault().post(selectedProduct);
                calculateTotal();
            }
        });
        dialog.setNegativeButton(getString(R.string.tidak), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.show();

    }




    @Override
    public void onClick(View view) {
//        btnBayar.setClickable(true);
        if (view == btnBayar) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();

            Log.e("Pilih pelanggan", "onClick: " + DataManager.getInstance().getCustomerId());
            if (DataManager.getInstance().getCustomerIdProduct() == 0) {
                Toast.makeText(requireContext(), "Pilih pelanggan terlebuh dahulu", Toast.LENGTH_SHORT).show();
                return;
            }
//            loadInvoiceNumber();
//            btnBayar.setClickable(false);

        }

        if (view == btnSaveSelectedProduk) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            saveOrder();
        }
    }
}
