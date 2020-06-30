package com.codelabs.konspirasisnack.activity.ui.laporan;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.activity.ui.laporan.detail_penjualan.DetailPenjualanFragment;
import com.codelabs.konspirasisnack.activity.ui.laporan.kas_kasir.KasKasirFragment;
import com.codelabs.konspirasisnack.activity.ui.laporan.komisi.KomisiKasirFragment;
import com.codelabs.konspirasisnack.activity.ui.laporan.ringkasan_penjualan.RingkasanPenjualanFragment;
import com.codelabs.konspirasisnack.activity.ui.laporan.tutup_kasir.TutupKasirFragment;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaporanFragment extends Fragment {


    @BindView(R.id.v_ringkas_jual)
    View vRingkasJual;
    @BindView(R.id.txt_ringkas_jual)
    TextView txtRingkasJual;
    @BindView(R.id.btn_ringkas_jual)
    LinearLayout btnRingkasJual;
    @BindView(R.id.v_penjualan)
    View vPenjualan;
    @BindView(R.id.txt_penjualan)
    TextView txtPenjualan;
    @BindView(R.id.btn_penjualan)
    LinearLayout btnPenjualan;
    @BindView(R.id.v_komisi)
    View vKomisi;
    @BindView(R.id.txt_komisi)
    TextView txtKomisi;
    @BindView(R.id.btn_komisi)
    LinearLayout btnKomisi;
    @BindView(R.id.v_tutup_kasir)
    View vTutupKasir;
    @BindView(R.id.txt_tutup_kasir)
    TextView txtTutupKasir;
    @BindView(R.id.btn_tutup_kasir)
    LinearLayout btnTutupKasir;
    @BindView(R.id.v_kas_kasir)
    View vKasKasir;
    @BindView(R.id.txt_kas_kasir)
    TextView txtKasKasir;
    @BindView(R.id.btn_kas_kasir)
    LinearLayout btnKasKasir;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.layout_menu)
    RelativeLayout layoutMenu;
    @BindView(R.id.btn_laporan)
    FloatingActionButton btnLaporan;

    public LaporanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_laporan, container, false);
        ButterKnife.bind(this, v);


        initView();


        return v;
    }

    private void initView() {
        txtRingkasJual.setOnClickListener(getOnClick(btnRingkasJual, vRingkasJual, txtRingkasJual));
        txtKomisi.setOnClickListener(getOnClick(btnKomisi, vKomisi, txtKomisi));
        txtTutupKasir.setOnClickListener(getOnClick(btnTutupKasir, vTutupKasir, txtTutupKasir));
        txtKasKasir.setOnClickListener(getOnClick(btnKasKasir, vKasKasir, txtKasKasir));
        txtPenjualan.setOnClickListener(getOnClick(btnPenjualan, vPenjualan, txtPenjualan));
        onSubClicked(txtRingkasJual);
        toRingkasan();



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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_LAPORAN);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

    }


    private OnClickListener getOnClick(LinearLayout l, View v, TextView tv) {

        return new OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                UnclickAll();
                cliked(l, v, tv);

                if (tv.equals(txtKomisi))
                    toKomisi();
                if (tv.equals(txtTutupKasir))
                    toTutupKasir();
                if (tv.equals(txtKasKasir))
                    toKasKasir();
                if (tv.equals(txtPenjualan))
                    toDetailPenjualan();
                if (tv.equals(txtRingkasJual))
                    toRingkasan();
                if (!CheckDevice.isTablet()){
                    btnLaporan.setVisibility(VISIBLE);
                    llContent.setVisibility(VISIBLE);
                    layoutMenu.setVisibility(GONE);
                }

            }
        };
    }

    private OnClickListener getonSubClick(TextView tv) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (tv.equals(txtKomisi))
////                    toKomisi();
////                onSubClicked(tv);
            }
        };
    }


    void toKomisi() {
        //Memulai transaksi

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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_LAPORAN_KOMISI);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, KomisiKasirFragment.newInstance());
        ft.commit();
    }

    void toRingkasan() {

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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_LAPORAN);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, RingkasanPenjualanFragment.newInstance());
        ft.commit();

    }

    void toTutupKasir() {
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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_LAPORAN_TUTUP_KASIR);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, TutupKasirFragment.newInstance());
        ft.commit();
    }

    private void toKasKasir() {
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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_LAPORAN_KAS_KASIR);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);

            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, KasKasirFragment.newInstance());
        ft.commit();
    }

    void toDetailPenjualan() {
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
                ShowHideToolbar showHideToolbar = new ShowHideToolbar(ShowHideToolbar.POSITION_DETAIL);
                showHideToolbar.setContentWidth(width);
                EventBus.getDefault().post(showHideToolbar);
            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, DetailPenjualanFragment.newInstance());
        ft.commit();
    }

    void cliked(LinearLayout l, View v, TextView tv) {
        l.setBackgroundColor(getActivity().getResources().getColor(R.color.gray_light));
        tv.setTextColor(getActivity().getResources().getColor(R.color.black));
        v.setVisibility(VISIBLE);
    }

    void unCliked(LinearLayout l, View v, TextView tv) {
        l.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
        tv.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
        v.setVisibility(GONE);
    }

    private void UnclickAll() {
        unCliked(btnRingkasJual, vRingkasJual, txtRingkasJual);
        unCliked(btnKomisi, vKomisi, txtKomisi);
        unCliked(btnTutupKasir, vTutupKasir, txtTutupKasir);
        unCliked(btnKasKasir, vKasKasir, txtKasKasir);
        unCliked(btnPenjualan, vPenjualan, txtPenjualan);

    }

    void onSubClicked(TextView tv) {
        UnclickAll();
        unClickSub();
        cliked(btnRingkasJual, vRingkasJual, txtRingkasJual);
        tv.setTextColor(getActivity().getResources().getColor(R.color.black));
    }

    void unClickSub() {
//        txtKomisi.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
//        txtTutupKasir.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
//        txtKasKasir.setTextColor(getActivity().getResources().getColor(android.R.color.tab_indicator_text));
    }

    @SuppressLint("RestrictedApi")
    @OnClick(R.id.btn_laporan)
    void onLaporanClicked(){
        btnLaporan.setVisibility(GONE);
        llContent.setVisibility(GONE);
        layoutMenu.setVisibility(VISIBLE);
    }


}
