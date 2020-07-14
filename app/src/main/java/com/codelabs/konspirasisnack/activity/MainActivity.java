package com.codelabs.konspirasisnack.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.codelabs.konspirasisnack.EventBus.BarcodeScanner;
import com.codelabs.konspirasisnack.EventBus.DialogLoginOwnerBus;
import com.codelabs.konspirasisnack.EventBus.OnClickDetailPesanan;
import com.codelabs.konspirasisnack.EventBus.PermissionCameraBus;
import com.codelabs.konspirasisnack.EventBus.RefreshJenisPesanan;
import com.codelabs.konspirasisnack.EventBus.RefreshOutlet;
import com.codelabs.konspirasisnack.EventBus.RefreshToolbar;
import com.codelabs.konspirasisnack.EventBus.SetDate;
import com.codelabs.konspirasisnack.EventBus.SetSearch;
import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.EventBus.ShowMeja;
import com.codelabs.konspirasisnack.EventBus.ShowProductOrderType;
import com.codelabs.konspirasisnack.EventBus.ShowSearchKasir;
import com.codelabs.konspirasisnack.EventBus.ShowTambahAlamat;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.KasKasirAwalAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerAdapterOrderType;
import com.codelabs.konspirasisnack.adapter.SpinnerOutlet;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogTambahKategori;
import com.codelabs.konspirasisnack.fragment.MpinDialogFragment;
import com.codelabs.konspirasisnack.fragment.TambahKaryawanDialogFragment;
import com.codelabs.konspirasisnack.fragment.TambahKasFragment;
import com.codelabs.konspirasisnack.fragment.TambahPembayaranDialogFragment;
import com.codelabs.konspirasisnack.fragment.TambahProdukFragment;
import com.codelabs.konspirasisnack.fragment.TambahStockDialogFragment;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.KeyboardUtils;
import com.codelabs.konspirasisnack.model.CashierClose;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetOrderType;
import com.codelabs.konspirasisnack.model.GetOutlet;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.navigation.NavigationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_restoran)
    TextView tvNamaRestoran;
    @BindView(R.id.tv_name_kasir)
    TextView tvNameKasir;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.img_barcode)
    ImageView imgBarcode;
    @BindView(R.id.img_list_order)
    ImageView imgListOrder;
    @BindView(R.id.tv_order_red)
    TextView tvOrderRed;
    @BindView(R.id.toolbar_kasir)
    LinearLayout toolbarKasir;
    @BindView(R.id.tv_penjualan)
    TextView tvPenjualan;
    @BindView(R.id.spin_outlet_penjualan)
    Spinner spinOutletPenjualan;
    @BindView(R.id.periode_penjualan)
    EditText periodePenjualan;
    @BindView(R.id.toolbar_penjualan)
    LinearLayout toolbarPenjualan;
    @BindView(R.id.tv_laporan)
    TextView tvLaporan;
    @BindView(R.id.tv_subtitle)
    TextView tvSubtitle;
    @BindView(R.id.spin_outlet_laporan)
    Spinner spinOutletLaporan;
    @BindView(R.id.periode_laporan)
    EditText periodeLaporan;
    @BindView(R.id.toolbar_laporan)
    RelativeLayout toolbarLaporan;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.logout)
    TextView logout;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.rl_content_laporan)
    RelativeLayout rlContentLaporan;
    @BindView(R.id.tv_daftar_absensi)
    TextView tvDaftarAbsensi;
    @BindView(R.id.toolbar_absensi)
    RelativeLayout toolbarAbsensi;
    @BindView(R.id.tv_absensi)
    TextView tvAbsensi;
    @BindView(R.id.tv_pengaturan)
    TextView tvPengaturan;
    @BindView(R.id.tv_subtitle_pengaturan)
    TextView tvSubtitlePengaturan;
    @BindView(R.id.rl_content_pengaturan)
    RelativeLayout rlContentPengaturan;
    @BindView(R.id.toolbar_pengaturan_produk)
    RelativeLayout toolbarPengaturanProduk;
    @BindView(R.id.spin_jenis_pesanan)
    Spinner spinJenisPesanan;
    @BindView(R.id.linerlogout)
    LinearLayout linerLogout;
    TextView navUserName;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_subtitle_pengaturan_kategori)
    TextView tvSubtitlePengaturanKategori;
    @BindView(R.id.rl_content_pengaturan_kategori)
    RelativeLayout rlContentPengaturanKategori;
    @BindView(R.id.toolbar_pengaturan_kategori)
    RelativeLayout toolbarPengaturanKategori;
    @BindView(R.id.btn_tambah_produk)
    TextView btnTambahProduk;
    @BindView(R.id.btn_tambah_kategori)
    TextView btnTambahKategori;
    @BindView(R.id.tv_subtitle_pengaturan_karyawan)
    TextView tvSubtitlePengaturanKaryawan;
    @BindView(R.id.btn_tambah_karyawan)
    TextView btnTambahKaryawan;
    @BindView(R.id.rl_content_pengaturan_karyawan)
    RelativeLayout rlContentPengaturanKaryawan;
    @BindView(R.id.tv_karyawan)
    TextView tvKaryawan;
    @BindView(R.id.toolbar_pengaturan_karyawan)
    RelativeLayout toolbarPengaturanKaryawan;
    @BindView(R.id.toolbar_pengaturan_promo)
    RelativeLayout toolbarPengaturanPromo;
    @BindView(R.id.rl_content_pengaturan_promo)
    RelativeLayout rlContentPengaturanPromo;
    @BindView(R.id.btn_tambah_pembayaran_nontunai)
    TextView btnTambahPembayaranNontunai;
    @BindView(R.id.rl_content_pengaturan_pembayaran_nontunai)
    RelativeLayout rlContentPengaturanPembayaranNontunai;
    @BindView(R.id.toolbar_pengaturan_pembayaran_nontunai)
    RelativeLayout toolbarPengaturanPembayaranNontunai;
    @BindView(R.id.rl_content_pengaturan_password_pin)
    RelativeLayout rlContentPengaturanPasswordPin;
    @BindView(R.id.toolbar_pengaturan_password_pin)
    RelativeLayout toolbarPengaturanPasswordPin;
    @BindView(R.id.rl_content_pengaturan_outlet)
    RelativeLayout rlContentPengaturanOutlet;
    @BindView(R.id.toolbar_pengaturan_outlet)
    RelativeLayout toolbarPengaturanOutlet;
    @BindView(R.id.btn_tambah_perangkat)
    TextView btnTambahPerangkat;
    @BindView(R.id.rl_content_pengaturan_perangkat)
    RelativeLayout rlContentPengaturanPerangkat;
    @BindView(R.id.toolbar_pengaturan_perangkat)
    RelativeLayout toolbarPengaturanPerangkat;
    @BindView(R.id.rl_content_pengaturan_struk_biaya)
    RelativeLayout rlContentPengaturanStrukBiaya;
    @BindView(R.id.toolbar_pengaturan_struk_biaya)
    RelativeLayout toolbarPengaturanStrukBiaya;

    @BindView(R.id.rl_content_laporan_komisi)
    RelativeLayout rlContentLaporanKomisi;
    @BindView(R.id.tv_subtitle_laporan_komisi)
    TextView tvSubtitleLaporanKomisi;
    @BindView(R.id.toolbar_laporan_komisi)
    RelativeLayout toolbarLaporanKomisi;
    @BindView(R.id.spin_laporan_komisi)
    Spinner spinLaporanKomisi;
    @BindView(R.id.periode_laporan_komisi)
    EditText periodeKomisi;
    @BindView(R.id.tv_komisi)
    TextView tvKomisi;

    @BindView(R.id.rl_content_laporan_tutup_kasir)
    RelativeLayout rlContentLaporanTutupKasir;
    @BindView(R.id.tv_subtitle_laporan_tutup_kasir)
    TextView tvSubtitleLaporanTutupKasir;
    @BindView(R.id.toolbar_laporan_tutup_kasir)
    RelativeLayout toolbarLaporanTutupKasir;
    @BindView(R.id.spin_tutup_kasir)
    Spinner spinTutupKasir;


    @BindView(R.id.toolbar_laporan_kas)
    RelativeLayout toolbarLaporanKas;
    @BindView(R.id.rl_content_laporan_kas)
    RelativeLayout rlContentLaporanKas;
    @BindView(R.id.tv_kas)
    TextView tvKas;
    @BindView(R.id.tv_subtitle_laporan_kas)
    TextView tvSubtitleLaporanKas;
    @BindView(R.id.btn_tambah_kas)
    TextView btnTambahKas;
    @BindView(R.id.btn_tambah_stok)
    TextView btnTambahStok;
    @BindView(R.id.rl_content_pengaturan_stok)
    RelativeLayout rlContentPengaturanStok;
    @BindView(R.id.toolbar_pengaturan_stok)
    RelativeLayout toolbarPengaturanStok;

    @BindView(R.id.rl_content_laporan_penjualan)
    RelativeLayout rlContentLaporanPenjualan;
    @BindView(R.id.tv_subtitle_laporan_penjualan)
    TextView tvSubtitleLaporanPenjualan;
    @BindView(R.id.toolbar_laporan_penjualan)
    RelativeLayout toolbarLaporanPenjualn;
    @BindView(R.id.spin_laporan_penjualan)
    Spinner spinLaporanPenjualan;
    @BindView(R.id.periode_laporan_penjualan)
    EditText periodeLaporPenjualan;
    @BindView(R.id.tv_lapor_penjualan)
    TextView tvLaporPenjualan;


    private NavigationView navigationView;
    private NavController navController;


    private AppBarConfiguration mAppBarConfiguration;
    KasKasirAwalAdapter adapter;
    private int selectedId;
    TextView tvNavbarNama;
    private Date selectedPenjualanDate;
    private int selectedOutletId = 0;
    private List<GetOutlet.DATA> dataOutlet;
    private static long backPressed;
    private Date selectedLaporan;
    private Date selectedLaporanKomisi;
    private Date selectedLaporanPenjualan;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private Boolean mLocationPermissionsGranted = false;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private final int REQUEST_LOCATION_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);
        setupToolbar();

        initView();
        initEvent();
        initSetup();
        fetchData();


        linerLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "test logout", Toast.LENGTH_SHORT).show();
                dialogLogout();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        navUserName = (TextView) headerView.findViewById(R.id.tv_nama_kasir_nav);
        Button btnCloseCashier = (Button) headerView.findViewById(R.id.btn_tutup_kasir);
        btnCloseCashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCashierClose();
            }
        });


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_kasir, R.id.nav_penjualan, R.id.nav_laporan,
                R.id.nav_absensi, R.id.nav_pengaturan)
                .setDrawerLayout(drawer)
                .build();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        initVar(new RefreshToolbar());
    }

    @Subscribe
    public void toKasir(DialogLoginOwnerBus bus) {

        navigationView.getMenu().findItem(R.id.nav_kasir).setChecked(true);
        navController.navigate(R.id.nav_kasir);
    }

    private void initView() {

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
//        if (prev != null) {
//            ft.remove(prev);
//        }
//        ft.addToBackStack(null);

        FragmentManager fm = getSupportFragmentManager();
        DialogFragment mpinFrag = new MpinDialogFragment();
        if (mpinFrag.isAdded()) {
            return;
        }
        mpinFrag.show(fm, "title");

    }

    @Subscribe
    public void initVar(RefreshToolbar toolbar) {
        tvNameKasir.setText(DataManager.getInstance().getU_firstname_cashier());
        tvNamaRestoran.setText(DataManager.getInstance().getOutlet().getOt_name());
        navUserName.setText(DataManager.getInstance().getU_firstname_cashier());

    }

    private void initEvent() {
        selectedId = DataManager.getInstance().getCashierId();

    }

    private void initSetup() {

    }

    private void fetchData() {
//        getLocationPermission();
        requestLocationPermission();

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

    private void getLocationPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
    }



    @Subscribe
    public void showHideToolbar(ShowHideToolbar data) {
        hideToolbar();
        if (data.getPosition() == ShowHideToolbar.POSITION_KASIR)
            toolbarKasir.setVisibility(View.VISIBLE);
        if (data.getPosition() == ShowHideToolbar.POSITION_PENJUALAN) {

            Calendar cal = Calendar.getInstance();
            selectedPenjualanDate = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
            periodePenjualan.setText(DateUtils.getTodayDate(DateUtils.DATE_FORMAT_MONTH_NAME));
            toolbarPenjualan.setVisibility(View.VISIBLE);
            spinOutletPenjualan.setSelection(dataOutlet.size() > 0 ? 0 : -1);
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_LAPORAN) {
            Calendar cal = Calendar.getInstance();
            selectedLaporan = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
            periodeLaporan.setText(DateUtils.getTodayDate(DateUtils.DATE_FORMAT_MONTH_NAME));
            toolbarLaporan.setVisibility(View.VISIBLE);
            rlContentLaporan.getLayoutParams().width = data.getContentWidth();
            rlContentLaporan.requestLayout();
            spinOutletLaporan.setSelection(dataOutlet.size() > 0 ? 0 : -1);

        }
        if (data.getPosition() == ShowHideToolbar.POSITION_ABSENSI)
            toolbarAbsensi.setVisibility(View.VISIBLE);

        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_PRODUK) {
            toolbarPengaturanProduk.setVisibility(View.VISIBLE);
            rlContentPengaturan.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturan.requestLayout();

        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_KATEGORI) {
            toolbarPengaturanKategori.setVisibility(View.VISIBLE);
            rlContentPengaturanKategori.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanKategori.requestLayout();
        }

        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_KARYAWAN) {

            toolbarPengaturanKaryawan.setVisibility(View.VISIBLE);
            rlContentPengaturanKaryawan.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanKaryawan.requestLayout();
        }

        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_PROMO) {
            toolbarPengaturanPromo.setVisibility(View.VISIBLE);
            rlContentPengaturanPromo.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanPromo.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_PEMBAYARAN_NON_TUNAI) {
            toolbarPengaturanPembayaranNontunai.setVisibility(View.VISIBLE);
            rlContentPengaturanPembayaranNontunai.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanPembayaranNontunai.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_STOK) {
            toolbarPengaturanStok.setVisibility(View.VISIBLE);
            rlContentPengaturanStok.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanStok.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_PASSWORD_PIN) {
            toolbarPengaturanPasswordPin.setVisibility(View.VISIBLE);
            rlContentPengaturanPasswordPin.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanPasswordPin.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_OUTLET) {
            toolbarPengaturanOutlet.setVisibility(View.VISIBLE);
            rlContentPengaturanOutlet.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanOutlet.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_PERANGKAT) {
            toolbarPengaturanPerangkat.setVisibility(View.VISIBLE);
            rlContentPengaturanPerangkat.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanPerangkat.requestLayout();
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_PENGATURAN_STRUK_BIAYA) {
            toolbarPengaturanStrukBiaya.setVisibility(View.VISIBLE);
            rlContentPengaturanStrukBiaya.getLayoutParams().width = data.getContentWidth();
            rlContentPengaturanStrukBiaya.requestLayout();
        }

        if (data.getPosition() == ShowHideToolbar.POSITION_LAPORAN_KOMISI) {
            Calendar cal = Calendar.getInstance();
            selectedLaporanKomisi = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
            periodeKomisi.setText(DateUtils.getTodayDate(DateUtils.DATE_FORMAT_MONTH_NAME));
            toolbarLaporanKomisi.setVisibility(View.VISIBLE);
            rlContentLaporanKomisi.getLayoutParams().width = data.getContentWidth();
            rlContentLaporanKomisi.requestLayout();
            spinLaporanKomisi.setSelection(dataOutlet.size() > 0 ? 0 : -1);
        }

        if (data.getPosition() == ShowHideToolbar.POSITION_LAPORAN_TUTUP_KASIR) {
            toolbarLaporanTutupKasir.setVisibility(View.VISIBLE);
            rlContentLaporanTutupKasir.getLayoutParams().width = data.getContentWidth();
            rlContentLaporanTutupKasir.requestLayout();
            spinTutupKasir.setSelection(dataOutlet.size() > 0 ? 0 : -1);
        }
        if (data.getPosition() == ShowHideToolbar.POSITION_LAPORAN_KAS_KASIR) {
            toolbarLaporanKas.setVisibility(View.VISIBLE);
            rlContentLaporanKas.getLayoutParams().width = data.getContentWidth();
            rlContentLaporanKas.requestLayout();
        }

        if (data.getPosition() == ShowHideToolbar.POSITION_DETAIL) {
            Calendar cal = Calendar.getInstance();
            selectedLaporanPenjualan = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
            periodeLaporPenjualan.setText(DateUtils.getTodayDate(DateUtils.DATE_FORMAT_MONTH_NAME));
            toolbarLaporanPenjualn.setVisibility(View.VISIBLE);
            rlContentLaporanPenjualan.getLayoutParams().width = data.getContentWidth();
            rlContentLaporanPenjualan.requestLayout();
            spinLaporanPenjualan.setSelection(dataOutlet.size() > 0 ? 0 : -1);
        }


    }

    private void setupToolbar() {
        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    EventBus.getDefault().post(new String(edtSearch.getText().toString().trim()));
                    KeyboardUtils.hideSoftKeyboardUsingView(MainActivity.this, edtSearch);
                    return true;
                }
                return false;
            }
        });


        imgBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new BarcodeScanner(true));
            }
        });


        initJenisPesanan(new RefreshJenisPesanan());
//        initOutlet();
        imgListOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new OnClickDetailPesanan());
            }
        });

        btnTambahKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DialogTambahKategori(MainActivity.this);
            }
        });

        btnTambahProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                TambahProdukFragment newFragment = new TambahProdukFragment();
                newFragment.show(fm, "title");


            }
        });

        btnTambahKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                TambahKasFragment newFragment = new TambahKasFragment();
                newFragment.show(fm, "title");
            }
        });

        btnTambahKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                TambahKaryawanDialogFragment newFragment = new TambahKaryawanDialogFragment();
                newFragment.show(fm, "title");

            }
        });

        btnTambahPembayaranNontunai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                TambahPembayaranDialogFragment newFragment = new TambahPembayaranDialogFragment();
                newFragment.show(fm, "title");

            }
        });

        btnTambahStok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                TambahStockDialogFragment newFragment = new TambahStockDialogFragment();
                newFragment.show(fm, "title");

            }
        });

    }

    @Subscribe
    public void initOutlet(RefreshOutlet outlet) {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<GetOutlet> call = apiService.getOutlet(auth);
        call.enqueue(new Callback<GetOutlet>() {
            @Override
            public void onResponse(Call<GetOutlet> call, Response<GetOutlet> data) {
                if (data.isSuccessful()) {
                    GetOutlet response = data.body();
                    dataOutlet = response.getDATA();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {

                            SpinnerOutlet adapterSpin = new SpinnerOutlet(MainActivity.this, new ArrayList<>());
                            spinOutletPenjualan.setAdapter(adapterSpin);
                            adapterSpin.clear();
                            adapterSpin.addAll(dataOutlet);
                            adapterSpin.notifyDataSetChanged();

                            spinOutletPenjualan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    selectedOutletId = adapterSpin.getItem(i).getOtId();
                                    EventBus.getDefault().post(new SetDate(null, selectedOutletId));
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

                            SpinnerOutlet adapterSpin2 = new SpinnerOutlet(MainActivity.this, new ArrayList<>());
                            spinLaporanKomisi.setAdapter(adapterSpin2);
                            adapterSpin2.clear();
                            adapterSpin2.addAll(dataOutlet);
                            adapterSpin2.notifyDataSetChanged();

                            spinLaporanKomisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    selectedOutletId = adapterSpin2.getItem(i).getOtId();
                                    EventBus.getDefault().post(new SetDate(null, selectedOutletId));
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            SpinnerOutlet adapterSpin3 = new SpinnerOutlet(MainActivity.this, new ArrayList<>());
                            spinTutupKasir.setAdapter(adapterSpin3);
                            adapterSpin3.clear();
                            adapterSpin3.addAll(dataOutlet);
                            adapterSpin3.notifyDataSetChanged();

                            spinTutupKasir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    selectedOutletId = adapterSpin3.getItem(i).getOtId();
                                    EventBus.getDefault().post(new SetDate(null, selectedOutletId));
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            SpinnerOutlet adapterSpin4 = new SpinnerOutlet(MainActivity.this, new ArrayList<>());
                            spinOutletLaporan.setAdapter(adapterSpin4);
                            adapterSpin4.clear();
                            adapterSpin4.addAll(dataOutlet);
                            adapterSpin4.notifyDataSetChanged();

                            spinOutletLaporan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    selectedOutletId = adapterSpin4.getItem(i).getOtId();
                                    EventBus.getDefault().post(new SetDate(null, selectedOutletId));
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            SpinnerOutlet adapterSpin5 = new SpinnerOutlet(MainActivity.this, new ArrayList<>());
                            spinLaporanPenjualan.setAdapter(adapterSpin5);
                            adapterSpin5.clear();
                            adapterSpin5.addAll(dataOutlet);
                            adapterSpin.notifyDataSetChanged();

                            spinLaporanPenjualan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                                    selectedOutletId = adapterSpin5.getItem(i).getOtId();
                                    EventBus.getDefault().post(new SetDate(null, selectedOutletId));
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        } else {
                            Toast.makeText(getApplicationContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOutlet> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public int getSelectedOutletId() {
        return selectedOutletId;
    }

    @OnClick(R.id.periode_penjualan)
    void onClickPeriodepenjualan() {
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(year, month, day));
                selectedPenjualanDate = cal.getTime();
                month += 1;
                periodePenjualan.setText(DateUtils.changeDateFormat(year + "-" + month + "-" + day, DateUtils.WEB_DATE_FORMAT, DateUtils.DATE_FORMAT_MONTH_NAME));
                EventBus.getDefault().post(new SetDate(year + "-" + month + "-" + day, selectedOutletId));
            }
        }, selectedPenjualanDate.getYear(), selectedPenjualanDate.getMonth(), selectedPenjualanDate.getDate());
        dialog.show();

    }

    @OnClick(R.id.periode_laporan_komisi)
    void onClickPeriodeLaporanKomisi() {
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(year, month, day));
                selectedLaporanKomisi = cal.getTime();
                month += 1;
                periodeKomisi.setText(DateUtils.changeDateFormat(year + "-" + month + "-" + day, DateUtils.WEB_DATE_FORMAT, DateUtils.DATE_FORMAT_MONTH_NAME));
                EventBus.getDefault().post(new SetDate(year + "-" + month + "-" + day, selectedOutletId));
            }
        }, selectedLaporanKomisi.getYear(), selectedLaporanKomisi.getMonth(), selectedLaporanKomisi.getDate());
        dialog.show();
    }

    @OnClick(R.id.periode_laporan_penjualan)
    void onClickPeriodeLaporanPenjualan() {
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(year, month, day));
                selectedLaporanPenjualan = cal.getTime();
                month += 1;
                periodeLaporPenjualan.setText(DateUtils.changeDateFormat(year + "-" + month + "-" + day, DateUtils.WEB_DATE_FORMAT, DateUtils.DATE_FORMAT_MONTH_NAME));
                EventBus.getDefault().post(new SetDate(year + "-" + month + "-" + day, selectedOutletId));
            }
        }, selectedLaporanPenjualan.getYear(), selectedLaporanPenjualan.getMonth(), selectedLaporanPenjualan.getDate());
        dialog.show();
    }

    @OnClick(R.id.periode_laporan)
    void onClickPeriodeLaporan() {
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(year, month, day));
                selectedLaporan = cal.getTime();
                month += 1;
                periodeLaporan.setText(DateUtils.changeDateFormat(year + "-" + month + "-" + day, DateUtils.WEB_DATE_FORMAT, DateUtils.DATE_FORMAT_MONTH_NAME));
                EventBus.getDefault().post(new SetDate(year + "-" + month + "-" + day, selectedOutletId));
            }
        }, selectedLaporan.getYear(), selectedLaporan.getMonth(), selectedLaporan.getDate());
        dialog.show();

    }

    private void dialogLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage("Logout kasir?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doLogout();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    private void doLogout() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Call<DoPost> call = apiService.doLogout(auth);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            Toast.makeText(getApplicationContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {

                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }

                processLogout();
                DataManager.getInstance().doLogoutCashier();
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void processLogout() {

        initView();
//        FragmentManager fm = getSupportFragmentManager();
//        DialogFragment newFragment = new MpinDialogFragment();
//        newFragment.show(fm, "title");
//        EventBus.getDefault().post(new RefreshToolbar());
    }

    @Subscribe
    public void initJenisPesanan(RefreshJenisPesanan refreshJenisPesanan) {

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetOrderType> call = apiService.getOrderType(auth);
        call.enqueue(new Callback<GetOrderType>() {
            @Override
            public void onResponse(Call<GetOrderType> call, Response<GetOrderType> data) {
                if (data.isSuccessful()) {
                    GetOrderType response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            SpinnerAdapterOrderType adapterSpin = new SpinnerAdapterOrderType(MainActivity.this, new ArrayList<>());
                            spinJenisPesanan.setAdapter(adapterSpin);
                            adapterSpin.clear();
                            adapterSpin.addAll(response.getDATA());
                            adapterSpin.notifyDataSetChanged();

                            spinJenisPesanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    DataManager.getInstance().setType_id(response.getDATA().get(i).getTypeId());
                                    EventBus.getDefault().post(response.getDATA().get(i));
                                    EventBus.getDefault().post(new ShowMeja(response.getDATA().get(i).getTypeId() == 1));
                                    EventBus.getDefault().post(new ShowProductOrderType(true));
//                                    EventBus.getDefault().post(new ShowTambahAlamat(response.getDATA().get(i).getTypeId() == 3));
                                    DataManager.getInstance().clearTambahAlamat();
                                    if (response.getDATA().get(i).getTypeId() == 3){
                                        requestLocationPermission();
                                    }

                                }


                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderType> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Subscribe
    public void setShowingSearchKasir(ShowSearchKasir showingSearchKasir){
        edtSearch.setVisibility(showingSearchKasir.isShowing()? View.VISIBLE:View.GONE);
    }

    public void doCloseCashier() {
        Map<String, String> params = new HashMap<>();
        params.put("cashier_id", selectedId + "");
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();

        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<CashierClose> call = apiService.closeCashier(auth, params);
        call.enqueue(new Callback<CashierClose>() {
            @Override
            public void onResponse(Call<CashierClose> call, Response<CashierClose> data) {
                if (data.isSuccessful()) {
                    CashierClose response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            Toast.makeText(getApplicationContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            DataManager.getInstance().clearOpenCashier();
                            DataManager.getInstance().doLogoutCashier();
//                            FragmentManager fm = getSupportFragmentManager();
//                            DialogFragment newFragment = new MpinDialogFragment();
//                            newFragment.show(fm, "title");
                            initView();
                            EventBus.getDefault().post(new RefreshToolbar());

                        } else {
                            Toast.makeText(getApplicationContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CashierClose> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }


    private void dialogCashierClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage("Tutup kasir?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                doCloseCashier();

            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    @Subscribe
    public void setSearch(SetSearch setSearch) {
        edtSearch.setText(setSearch.getSearch());
        if (!TextUtils.isEmpty(setSearch.getSearch()))
            edtSearch.onEditorAction(EditorInfo.IME_ACTION_SEARCH);

    }

    void hideToolbar() {
        toolbarKasir.setVisibility(View.GONE);
        toolbarLaporan.setVisibility(View.GONE);
        toolbarPenjualan.setVisibility(View.GONE);
        toolbarAbsensi.setVisibility(View.GONE);
        toolbarPengaturanProduk.setVisibility(View.GONE);
        toolbarPengaturanKategori.setVisibility(View.GONE);
        toolbarPengaturanKaryawan.setVisibility(View.GONE);
        toolbarPengaturanPromo.setVisibility(View.GONE);
        toolbarPengaturanPembayaranNontunai.setVisibility(View.GONE);
        toolbarPengaturanPasswordPin.setVisibility(View.GONE);
        toolbarPengaturanOutlet.setVisibility(View.GONE);
        toolbarPengaturanPerangkat.setVisibility(View.GONE);
        toolbarPengaturanStrukBiaya.setVisibility(View.GONE);
        toolbarPengaturanStok.setVisibility(View.GONE);
        toolbarLaporanKomisi.setVisibility(View.GONE);
        toolbarLaporanTutupKasir.setVisibility(View.GONE);
        toolbarLaporanKas.setVisibility(View.GONE);
        toolbarLaporan.setVisibility(View.GONE);
        toolbarLaporanPenjualn.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.e("permission activity", "Request Code: " + requestCode);
        if (requestCode == 102 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            EventBus.getDefault().post(new PermissionCameraBus());
            // camera init
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);

//        switch (requestCode) {
//            case REQUEST_CODE_ASK_PERMISSIONS:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                } else {
//                    Toast.makeText(this,"Anda tidak bisa mengakses alamat", Toast.LENGTH_SHORT).show();
//                }
//                break;
//                default:
//                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }

    }

    @AfterPermissionGranted(REQUEST_CODE_ASK_PERMISSIONS)
    public void requestLocationPermission() {
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
            EventBus.getDefault().post(new ShowTambahAlamat(true));
        }
        else {
            EasyPermissions.requestPermissions(this, "Please grant the location permission", REQUEST_CODE_ASK_PERMISSIONS, perms);

        }
    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();

        if (backPressed + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();

    }
}
