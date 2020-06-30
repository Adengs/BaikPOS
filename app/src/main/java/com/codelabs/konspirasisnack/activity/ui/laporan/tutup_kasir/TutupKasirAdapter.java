package com.codelabs.konspirasisnack.activity.ui.laporan.tutup_kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetReportTutupKasir;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TutupKasirAdapter extends RecyclerView.Adapter<TutupKasirAdapter.ViewHolder> {

    private List<GetReportTutupKasir.DATA> data;
    private Context context;

    public TutupKasirAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tutup_kasir, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetReportTutupKasir.DATA data = this.data.get(position);
        holder.tvTanggal.setText(data.getCashier_start_date());
        holder.tvKasir.setText(data.getKasir_name());
        holder.tvKasAwal.setText(data.getCashier_modal_awal().replace(".00",""));
        holder.tvKasAkhir.setText(data.getGrand_total().replace(".00",""));
        holder.tvSelesai.setText(data.getCashier_status_txt());

    }

    public void setData(List<GetReportTutupKasir.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tanggal)
        TextView tvTanggal;
//        @BindView(R.id.tv_waktu)
//        TextView tvWaktu;
        @BindView(R.id.tv_kasir)
        TextView tvKasir;
        @BindView(R.id.tv_kas_awal)
        TextView tvKasAwal;
        @BindView(R.id.tv_kas_akhir)
        TextView tvKasAkhir;
        @BindView(R.id.tv_selesai)
        TextView tvSelesai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
