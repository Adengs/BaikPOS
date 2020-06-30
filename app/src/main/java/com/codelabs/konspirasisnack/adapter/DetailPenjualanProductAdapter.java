package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetDetailPenjualan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPenjualanProductAdapter extends RecyclerView.Adapter<DetailPenjualanProductAdapter.ViewHolder>{

    private List<GetDetailPenjualan.TransactionItems> data;
    private Context mContext;

    public DetailPenjualanProductAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail_penjualan_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailPenjualanProductAdapter.ViewHolder holder, int position) {
//       holder.tvProduct.setText(data.get(position).getDetailItem().getItem_name());
       holder.tvProduct.setText(data.get(position).getTr_item_name());
    }
    public void setData(List<GetDetailPenjualan.TransactionItems> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_product)
        TextView tvProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
