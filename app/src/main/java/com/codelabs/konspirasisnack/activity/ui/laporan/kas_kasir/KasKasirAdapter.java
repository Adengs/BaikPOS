package com.codelabs.konspirasisnack.activity.ui.laporan.kas_kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetReportKasKasir;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KasKasirAdapter extends RecyclerView.Adapter<KasKasirAdapter.ViewHolder> {

    private List<GetReportKasKasir.DataKasir> data;
    private Context context;

    public KasKasirAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kas_kasir, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetReportKasKasir.DataKasir data = this.data.get(position);
        holder.tvNamaTransaksi.setText(data.getTc_name());
        holder.tvMasuk.setText("Rp " + Utils.toCurrency(data.getCash_in()));
        holder.tvKeluar.setText("Rp " + Utils.toCurrency(data.getCash_out()));
        holder.tvCatatan.setText(data.getTc_info());

    }

    public void setData(List<GetReportKasKasir.DataKasir> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_transaksi)
        TextView tvNamaTransaksi;
        @BindView(R.id.tv_masuk)
        TextView tvMasuk;
        @BindView(R.id.tv_keluar)
        TextView tvKeluar;
        @BindView(R.id.tv_catatan)
        TextView tvCatatan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
