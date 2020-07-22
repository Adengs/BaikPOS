package com.codelabs.konspirasisnack.activity.ui.pengaturan;


import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.codelabs.konspirasisnack.EventBus.RefreshToolbar;
import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.karyawan.KaryawanFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.kategori.KategoriFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.outlet.OutletFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.passwordpin.PasswordPinFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.pembayarannontunai.PembayaranNonTunaiFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.perangkat.PerangkatFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.produk.ProdukFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.promo.PromoFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.stok.StokFragment;
import com.codelabs.konspirasisnack.activity.ui.pengaturan.strukbiaya.StrukBiayaFragment;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogLoginOwner;
import com.codelabs.konspirasisnack.fragment.MpinDialogFragment;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PengaturanFragment extends Fragment {


    @BindView(R.id.v_produk_kategori)
    View vProdukKategori;
    @BindView(R.id.txt_produk_kategori)
    TextView txtProdukKategori;
    @BindView(R.id.btn_produk_kategori)
    LinearLayout btnProdukKategori;
    @BindView(R.id.v_struk_biaya)
    View vStrukBiaya;
    @BindView(R.id.txt_struk_biaya)
    TextView txtStrukBiaya;
    @BindView(R.id.btn_struk_biaya)
    LinearLayout btnStrukBiaya;
    @BindView(R.id.v_perangkat)
    View vPerangkat;
    @BindView(R.id.txt_perangkat)
    TextView txtPerangkat;
    @BindView(R.id.btn_perangkat)
    LinearLayout btnPerangkat;
    @BindView(R.id.v_pembayaran_nontunai)
    View vPembayaranNontunai;
    @BindView(R.id.txt_pembayaran_nontunai)
    TextView txtPembayaranNontunai;
    @BindView(R.id.btn_pembayaran_nontunai)
    LinearLayout btnPembayaranNontunai;
    @BindView(R.id.v_karyawan)
    View vKaryawan;
    @BindView(R.id.txt_karyawan)
    TextView txtKaryawan;
    @BindView(R.id.btn_karyawan)
    LinearLayout btnKaryawan;
    @BindView(R.id.v_outlet)
    View vOutlet;
    @BindView(R.id.txt_outlet)
    TextView txtOutlet;
    @BindView(R.id.btn_outlet)
    LinearLayout btnOutlet;
    @BindView(R.id.v_password_pin)
    View vPasswordPin;
    @BindView(R.id.txt_password_pin)
    TextView txtPasswordPin;
    @BindView(R.id.btn_password_pin)
    LinearLayout btnPasswordPin;
    @BindView(R.id.v_promo)
    View vPromo;
    @BindView(R.id.txt_promo)
    TextView txtPromo;
    @BindView(R.id.btn_promo)
    LinearLayout btnPromo;
    @BindView(R.id.txt_produk)
    TextView txtProduk;
    @BindView(R.id.btn_produk)
    LinearLayout btnProduk;
    @BindView(R.id.txt_kategori)
    TextView txtKategori;
    @BindView(R.id.btn_kategori)
    LinearLayout btnKategori;
    @BindView(R.id.btn_logout_aplikasi)
    LinearLayout btnLogoutAplikasi;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.txt_stok)
    TextView txtStok;
    @BindView(R.id.btn_stok)
    LinearLayout btnStok;
    @BindView(R.id.layout_menu)
    RelativeLayout layoutMenu;
    @BindView(R.id.btn_setting)
    FloatingActionButton btnSetting;

    public PengaturanFragment() {
        // Required empty public constructor
    }


    public PengaturanFragment newInstance() {
        PengaturanFragment fragment = new PengaturanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pengaturan, container, false);
        ButterKnife.bind(this, v);

//        initDialogLoginOwner();
        initView();

        btnLogoutAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogout();
            }
        });
        return v;
    }

    @OnClick(R.id.btn_setting)
    void onSettingClicked(){
        btnSetting.setVisibility(View.GONE);
        llContent.setVisibility(View.GONE);
        layoutMenu.setVisibility(View.VISIBLE);
    }

    private void initDialogLoginOwner() {
        DialogLoginOwner dialog = new DialogLoginOwner(getActivity());

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());

        double width_parent = CheckDevice.isTablet() ? 0.50 : 0.95;
        int width = (int)  (getResources().getDisplayMetrics().widthPixels * width_parent);
        lp.width = width;
        dialog.show();
        dialog.getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);

    }

    private void initView() {
//        txtProdukKategori.setOnClickListener(getOnClickText(btnProdukKategori, vProdukKategori, txtProdukKategori));
        txtStrukBiaya.setOnClickListener(getOnClick(btnStrukBiaya, vStrukBiaya, txtStrukBiaya));
        txtPerangkat.setOnClickListener(getOnClick(btnPerangkat, vPerangkat, txtPerangkat));
        txtPembayaranNontunai.setOnClickListener(getOnClick(btnPembayaranNontunai, vPembayaranNontunai, txtPembayaranNontunai));
        txtKaryawan.setOnClickListener(getOnClick(btnKaryawan, vKaryawan, txtKaryawan));
        txtOutlet.setOnClickListener(getOnClick(btnOutlet, vOutlet, txtOutlet));
        txtPasswordPin.setOnClickListener(getOnClick(btnPasswordPin, vPasswordPin, txtPasswordPin));
        txtPromo.setOnClickListener(getOnClick(btnPromo, vPromo, txtPromo));

        txtProduk.setOnClickListener(getOnSubClick(txtProduk));
        txtKategori.setOnClickListener(getOnSubClick(txtKategori));
        txtStok.setOnClickListener(getOnSubClick(txtStok));
        onSubClicked(txtProduk);
        toProduk();


    }

    @OnClick(R.id.btn_logout_aplikasi)
    void onClickLogoutAplikasi() {

    }

    private View.OnClickListener getOnClick(LinearLayout l, View v, TextView tv) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnclickAll();
                cliked(l, v, tv);

                if (tv.equals(txtKaryawan))
                    toKaryawan();
                if (tv.equals(txtPromo))
                    toPromo();
                if (tv.equals(txtPembayaranNontunai))
                    toPembayaranNonTunai();
                if (tv.equals(txtPasswordPin))
                    toPasswordPin();
                if (tv.equals(txtOutlet))
                    toOutlet();
                if (tv.equals(txtPerangkat))
                    toPerangkat();
                if (tv.equals(txtStrukBiaya))
                    toStrukBiaya();

                if (!CheckDevice.isTablet()){
                    btnSetting.setVisibility(View.VISIBLE);
                    llContent.setVisibility(View.VISIBLE);
                    layoutMenu.setVisibility(View.GONE);
                }
            }
        };
    }


    private View.OnClickListener getOnSubClick(TextView tv) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv.equals(txtProduk))
                    toProduk();
                if (tv.equals(txtKategori))
                    toKategori();
                if (tv.equals(txtStok))
                    toStok();
                if (!CheckDevice.isTablet()){
                    btnSetting.setVisibility(View.VISIBLE);
                    llContent.setVisibility(View.VISIBLE);
                    layoutMenu.setVisibility(View.GONE);
                }

                onSubClicked(tv);
            }
        };
    }

    private void toStok() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                int height = llContent.getMeasuredHeight();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_STOK);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        ft.replace(R.id.frame_layout, StokFragment.newInstance());
        ft.commit();
    }

    private void toKategori() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                int height = llContent.getMeasuredHeight();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_KATEGORI);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        ft.replace(R.id.frame_layout, KategoriFragment.newInstance());
        ft.commit();

    }


    void toProduk() {
        // Memulai transaksi

        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_PRODUK);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, ProdukFragment.newInstance());
        ft.commit();

    }

    private void toKaryawan() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_KARYAWAN);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, KaryawanFragment.newInstance());
        ft.commit();
    }

    private void toPromo() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_PROMO);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, PromoFragment.newInstance());
        ft.commit();

    }

    private void toPembayaranNonTunai() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_PEMBAYARAN_NON_TUNAI);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, PembayaranNonTunaiFragment.newInstance());
        ft.commit();

    }

    private void toPasswordPin() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_PASSWORD_PIN);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, PasswordPinFragment.newInstance());
        ft.commit();

    }

    private void toOutlet() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_OUTLET);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, OutletFragment.newInstance());
        ft.commit();

    }

    private void toPerangkat() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_PERANGKAT);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, PerangkatFragment.newInstance());
        ft.commit();
    }

    private void toStrukBiaya() {
        ViewTreeObserver vto = llContent.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    llContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    llContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = llContent.getMeasuredWidth();
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_PENGATURAN_STRUK_BIAYA);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, StrukBiayaFragment.newInstance());
        ft.commit();
    }

    private void UnclickAll() {
        unCliked(btnProdukKategori, vProdukKategori, txtProdukKategori);
        unCliked(btnStrukBiaya, vStrukBiaya, txtStrukBiaya);
        unCliked(btnPerangkat, vPerangkat, txtPerangkat);
        unCliked(btnPembayaranNontunai, vPembayaranNontunai, txtPembayaranNontunai);
        unCliked(btnKaryawan, vKaryawan, txtKaryawan);
        unCliked(btnOutlet, vOutlet, txtOutlet);
        unCliked(btnPasswordPin, vPasswordPin, txtPasswordPin);
        unCliked(btnPromo, vPromo, txtPromo);
    }

    void onSubClicked(TextView tv) {
        UnclickAll();
        unClickSub();
        cliked(btnProdukKategori, vProdukKategori, txtProdukKategori);
        tv.setTextColor(getActivity().getResources().getColor(R.color.black));
    }

    void unClickSub() {
        txtProduk.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
        txtKategori.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
        txtStok.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));

    }

    void cliked(LinearLayout l, View v, TextView tv) {
        unClickSub();
        l.setBackgroundColor(getActivity().getResources().getColor(R.color.gray_light));
        tv.setTextColor(getActivity().getResources().getColor(R.color.black));
        v.setVisibility(View.VISIBLE);
    }

    void unCliked(LinearLayout l, View v, TextView tv) {
        l.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tv.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
        v.setVisibility(View.GONE);
    }

    private void dialogLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AlertDialogTheme);
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
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
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
        FragmentManager fm = getFragmentManager();
        DialogFragment newFragment = new MpinDialogFragment();
        newFragment.show(fm, "title");
        EventBus.getDefault().post(new RefreshToolbar());
    }
}
