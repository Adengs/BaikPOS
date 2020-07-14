package com.codelabs.konspirasisnack.fragment;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.SetDataAlamat;
import com.codelabs.konspirasisnack.EventBus.ShowTambahAlamat;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.OrderMejaTambahanAdapter;
import com.codelabs.konspirasisnack.adapter.OrderProdukAdapter;
import com.codelabs.konspirasisnack.adapter.OrderTambahanAdapter;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetProductDetail;
import com.google.android.gms.location.FusedLocationProviderClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PesananFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.rv_order_pesanan)
    RecyclerView rvOrderPesanan;
    @BindView(R.id.rv_order_pesanan_tambahan)
    RecyclerView rvOrderTambahan;
    @BindView(R.id.rv_order_pesanan_meja)
    RecyclerView rvOrderanMeja;
    @BindView(R.id.liner_lokasi)
    LinearLayout linerLokasi;
    @BindView(R.id.tv_tambah_lokasi)
    TextView tvTambahLokasi;
    @BindView(R.id.liner_tampil_lokasi)
    LinearLayout linerTampilLokasi;
    @BindView(R.id.tv_tampil_lokasi)
    TextView tvTampilLokasi;


    OrderProdukAdapter adapter;
    OrderTambahanAdapter adapterTambahan;
    OrderMejaTambahanAdapter adapterOrderMeja;

    private String address;
    private String latitude;
    private String longitude;
    private String datetime;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private Boolean mLocationPermissionsGranted = false;
    private FusedLocationProviderClient mfusedLocationProviderClient;

    public PesananFragment() {
        // Required empty public constructor
    }


    public static PesananFragment newInstance() {
        PesananFragment fragment = new PesananFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pesanan, container, false);
        ButterKnife.bind(this, view);
        linerLokasi.setOnClickListener(this);
        tvTampilLokasi.setText(DataManager.getInstance().getAddressTambah());

        return view;

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
    public void setData(List<GetProductDetail.DATAProduct> data) {
        rvOrderPesanan.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new OrderProdukAdapter(getActivity());
        rvOrderPesanan.setAdapter(adapter);
        adapter.setData(data);
    }

    public void setDataOrder(List<GetOrderDetail.DATA.TransactionItems> order) {
        rvOrderTambahan.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterTambahan = new OrderTambahanAdapter(getActivity());
        rvOrderTambahan.setAdapter(adapterTambahan);
        adapterTambahan.setDataOrder(order);
    }

    public void setDataOrderMeja(List<GetOrderDetail.DATA.TransactionItems> orderMeja) {
        rvOrderanMeja.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterOrderMeja = new OrderMejaTambahanAdapter(getActivity());
        rvOrderanMeja.setAdapter(adapterOrderMeja);
        adapterOrderMeja.setDataOrderMeja(orderMeja);
    }

    public void setDataAlamatSave(GetOrderDetail.DATA.DataTransactionShipping dataAlamat) {
        if (dataAlamat.getTs_to_address().equals("")) {
            linerTampilLokasi.setVisibility(View.GONE);
        }else {
            linerTampilLokasi.setVisibility(View.VISIBLE);
        }
        linerLokasi.setVisibility(View.GONE);
        tvTampilLokasi.setText(dataAlamat.getTs_to_address());

    }

    @Subscribe
    public void showTambahAlamat(ShowTambahAlamat alamat) {
        if (alamat.isShowing()) {
//            getLocationPermission();
            linerLokasi.setVisibility(View.VISIBLE);
            tvTambahLokasi.setText("Tambah alamat");
            linerTampilLokasi.setVisibility(View.GONE);
        }else {
            linerLokasi.setVisibility(View.GONE);
        }
    }



    @Subscribe
    public void setDataAlamat(SetDataAlamat dataAlamat) {
        this.address = dataAlamat.getAddress();
        this.latitude = dataAlamat.getLatitude();
        this.longitude = dataAlamat.getLongitude();
        this.datetime = dataAlamat.getDatetime();
        tvTambahLokasi.setText(address);
        if (address.equals("-")){
            linerLokasi.setVisibility(View.GONE);
        }else {
            linerLokasi.setVisibility(View.VISIBLE);
        }
        DataManager.getInstance().setAddressTambah(address);
        DataManager.getInstance().setDateTimeTambah(datetime);
        DataManager.getInstance().setLatitudeTambah(latitude);
        DataManager.getInstance().setLongitudeTambah(longitude);

    }

    @Override
    public void onClick(View view) {
        if (view == linerLokasi){
            TambahLokasiDialogFragment tambahLokasiDialogFragment = new TambahLokasiDialogFragment();
            tambahLokasiDialogFragment.show(getChildFragmentManager(), tambahLokasiDialogFragment.getTag());

        }

    }

}
