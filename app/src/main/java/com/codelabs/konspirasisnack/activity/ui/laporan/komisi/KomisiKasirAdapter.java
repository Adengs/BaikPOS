package com.codelabs.konspirasisnack.activity.ui.laporan.komisi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetReportKomisi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KomisiKasirAdapter extends RecyclerView.Adapter<KomisiKasirAdapter.ViewHolder> {

    private List<GetReportKomisi.DATA> data;
    private Context context;

    public KomisiKasirAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_komisi_kasir, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetReportKomisi.DATA data = this.data.get(position);
        holder.tvNamaKasir.setText(data.getEmployee_name());
        holder.tvProduk.setText(data.getKomisi_type());
        holder.tvJumlah.setText(data.getTr_served_total_comm().replace(".00",""));
        holder.tvNominal.setText(data.getTotal_commission().replace(".00",""));

    }

    public void setData(List<GetReportKomisi.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_kasir)
        TextView tvNamaKasir;
        @BindView(R.id.tv_produk)
        TextView tvProduk;
        @BindView(R.id.tv_jumlah)
        TextView tvJumlah;
        @BindView(R.id.tv_nominal)
        TextView tvNominal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
