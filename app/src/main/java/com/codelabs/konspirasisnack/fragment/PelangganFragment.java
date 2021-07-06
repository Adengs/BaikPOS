package com.codelabs.konspirasisnack.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PelangganFragment extends Fragment {

    @BindView(R.id.rv_daftar_pelanggan)
    RecyclerView rvDaftarPelanggan;



    public static final String IS_PELANGGAN="IS_PELANGGAN";

    public PelangganFragment() {
        // Required empty public constructor
    }

    public static PelangganFragment newInstance() {
        PelangganFragment fragment = new PelangganFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pelanggan, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {

//        rvDaftarPelanggan.setLayoutManager(new LinearLayoutManager(getActivity()));
//        PelangganAdapter adapter = new PelangganAdapter(getActivity());
//        adapter.setData(DummyUtils.getDummy());
//        rvDaftarPelanggan.setAdapter(adapter);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
