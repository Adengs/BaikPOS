package com.codelabs.konspirasisnack.activity.ui.pengaturan.perangkat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPerangkat extends RecyclerView.Adapter<AdapterPerangkat.ViewHolder> {
    private final Context context;
    @BindView(R.id.txt_kriteria)
    TextView txtKriteria;
    @BindView(R.id.txt_nama_perangkat)
    TextView txtNamaPerangkat;
    @BindView(R.id.txt_tipe)
    TextView txtTipe;
    @BindView(R.id.txt_koneksi)
    TextView txtKoneksi;
    private List<String> data;

    public AdapterPerangkat(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_perangkat, parent, false);

        return new ViewHolder(itemView);
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_kriteria)
        TextView txtKriteria;
        @BindView(R.id.txt_nama_perangkat)
        TextView txtNamaPerangkat;
        @BindView(R.id.txt_tipe)
        TextView txtTipe;
        @BindView(R.id.txt_koneksi)
        TextView txtKoneksi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
