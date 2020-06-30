package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListPesananAdapter extends RecyclerView.Adapter<OrderListPesananAdapter.ViewHolder> {

    private Context mContext;



    @NonNull
    @Override
    public OrderListPesananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_order_list_pesanan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_invoice_numb)
        TextView tvInvoiceNumb;
        @BindView(R.id.tv_date_invoice)
        TextView tvDateInvoice;
        @BindView(R.id.tv_no_pesanan)
        TextView tvNoPesanan;
        @BindView(R.id.tv_pelanggan)
        TextView tvPelanggan;
        @BindView(R.id.tv_total_harga)
        TextView tvTotalHaga;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
