package com.codelabs.konspirasisnack.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.codelabs.konspirasisnack.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DeleteListOrderFragment extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.tv_invoice_nomor)
    TextView tvInvoiceNomor;
    @BindView(R.id.tv_hapus)
    TextView tvHapus;



    Unbinder unbinder;



    public DeleteListOrderFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_delete_list_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();


        return view;
    }

    private void initView() {

    }

    private void initVar() {

    }

    private void initEvent() {
        btnClose.setOnClickListener(this);
        tvHapus.setOnClickListener(this);

    }

    private void initSetup() {

    }

    private void fetchData() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {
        if (view == btnClose) {
            dismiss();
        }

    }



}
