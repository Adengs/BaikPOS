package com.codelabs.konspirasisnack.activity.ui.pengaturan.promo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetPengaturanPromo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPromo extends RecyclerView.Adapter<AdapterPromo.ViewHolder> {
    private final Context context;
    private List<GetPengaturanPromo.DATA> data;


    public AdapterPromo(Context context){
        this.context = context;
        data = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pengaturan_promo, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetPengaturanPromo.DATA data = this.data.get(position);
        holder.txtNama.setText(data.getPromoName());
        holder.txtKriteria.setText(data.getKriteriaTxt());
        holder.txtJenisBonus.setText(data.getTypeTxt());
        holder.txtTipe.setText(data.getActivationTxt());
        holder.txtDurasi.setText(data.getDurasi());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetPengaturanPromo.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_kriteria)
        TextView txtKriteria;
        @BindView(R.id.txt_jenis_bonus)
        TextView txtJenisBonus;
        @BindView(R.id.txt_tipe)
        TextView txtTipe;
        @BindView(R.id.txt_durasi)
        TextView txtDurasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
