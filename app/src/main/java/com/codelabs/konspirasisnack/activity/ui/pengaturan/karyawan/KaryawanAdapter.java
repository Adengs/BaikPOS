package com.codelabs.konspirasisnack.activity.ui.pengaturan.karyawan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetKaryawan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.ViewHolder> {
    private List<GetKaryawan.DATA> datas;
    private Context context;

    public KaryawanAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_karyawan, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetKaryawan.DATA data = datas.get(position);
        holder.txtNama.setText(data.generateFullname());
        holder.txtEmail.setText(data.getUEmail());
        holder.txtPosisi.setText(data.getUPosition());
        holder.txtOutlet.setText(data.getOutlet().getOtName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<GetKaryawan.DATA> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_email)
        TextView txtEmail;
        @BindView(R.id.txt_posisi)
        TextView txtPosisi;
        @BindView(R.id.txt_outlet)
        TextView txtOutlet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
