package com.codelabs.konspirasisnack.activity.ui.pengaturan.pembayarannontunai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetPaymentMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPembayaranNonTunai extends RecyclerView.Adapter<AdapterPembayaranNonTunai.ViewHolder> {
    private final Context context;

    private List<GetPaymentMethod.DATA> data;

    public AdapterPembayaranNonTunai(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pembayaran_non_tunai, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetPaymentMethod.DATA data = this.data.get(position);
        holder.txtNamaPembayaran.setText(data.getPmName());
        holder.txtJenis.setText(data.getPmTypeTxt());
        holder.txtProvider.setText(data.getPmProvider());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetPaymentMethod.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama_pembayaran)
        TextView txtNamaPembayaran;
        @BindView(R.id.txt_jenis)
        TextView txtJenis;
        @BindView(R.id.txt_provider)
        TextView txtProvider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
