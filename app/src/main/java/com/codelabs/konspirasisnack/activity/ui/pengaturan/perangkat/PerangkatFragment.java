package com.codelabs.konspirasisnack.activity.ui.pengaturan.perangkat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.DummyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerangkatFragment extends Fragment {

    @BindView(R.id.txt_search)
    EditText txtSearch;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    private AdapterPerangkat adapter;

    public PerangkatFragment() {
        // Required empty public constructor
    }

    public static PerangkatFragment newInstance() {
        PerangkatFragment fragment = new PerangkatFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perangkat, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        adapter = new AdapterPerangkat(getActivity());
        rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvData.setAdapter(adapter);
        adapter.setData(DummyUtils.getJenisKelamin());
        getData();

    }

    private void getData() {

    }
}