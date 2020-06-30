package com.codelabs.konspirasisnack.activity.ui.laporan.detail_penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.DetailPenjualanProductAdapter;
import com.codelabs.konspirasisnack.model.GetDetailPenjualan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPenjualanAdapter extends RecyclerView.Adapter<DetailPenjualanAdapter.ViewHolder> {

    private List<GetDetailPenjualan.DataTransaction> data;
    private Context mContext;

    public DetailPenjualanAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail_penjualan, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetDetailPenjualan.DataTransaction data = this.data.get(position);
        holder.tvNoNota.setText(data.getTrans_code());
        holder.tvOutlet.setText(data.getOutlet_name());
        holder.tvNamaKasir.setText(data.getCashier_name());
        holder.tvJenisOrder.setText(data.getOrder_type_name());

        holder.rvProduct.setLayoutManager(new LinearLayoutManager(mContext));
        DetailPenjualanProductAdapter adapter = new DetailPenjualanProductAdapter(mContext);
        adapter.setData(data.getTransactionItems());
        holder.rvProduct.setAdapter(adapter);


    }

    public void setData(List<GetDetailPenjualan.DataTransaction> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_no_nota)
        TextView tvNoNota;
        @BindView(R.id.tv_outlet)
        TextView tvOutlet;
        @BindView(R.id.tv_nama_kasir)
        TextView tvNamaKasir;
        @BindView(R.id.rv_product)
        RecyclerView rvProduct;
        @BindView(R.id.tv_jenis_order)
        TextView tvJenisOrder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
