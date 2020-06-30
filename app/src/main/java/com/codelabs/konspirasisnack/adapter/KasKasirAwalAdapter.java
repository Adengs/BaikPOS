package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.codelabs.konspirasisnack.R;

public class KasKasirAwalAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;


    public KasKasirAwalAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        view = inflater.inflate(R.layout.dialog_kas_kasir_awal, null);
        View v =(LayoutInflater.from(context).inflate(R.layout.dialog_kas_kasir_awal, viewGroup, false));
        return v;
    }
}
