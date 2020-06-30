package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedVariantsTambahanAdapter extends RecyclerView.Adapter<SelectedVariantsTambahanAdapter.ViewHolder> {

    private List<GetOrderDetail.DATA.TransactionItems.Variants> dataVariant;
    private Context context;

    public SelectedVariantsTambahanAdapter(Context context) {
        this.context = context;
        dataVariant = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_selected_additional_produk, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetOrderDetail.DATA.TransactionItems.Variants data = this.dataVariant.get(position);
//        holder.tvNamaVariant.setText(dataVariant.get(position).getItem().getDetailNameTxt());
        holder.tvNamaVariant.setText(dataVariant.get(position).getTr_variant_item_name());
//        holder.tvHargaVariant.setText(Utils.toCurrency(dataVariant.get(position).getItem().getVariantDetailHargaJual().replace(".00","")));
        holder.tvHargaVariant.setText(Utils.toCurrency(dataVariant.get(position).getTrVariantActualPrice().replace(".00","")));

    }

    @Override
    public int getItemCount() {
        return dataVariant.size();
    }


    public void setData(List<GetOrderDetail.DATA.TransactionItems.Variants> data){
        this.dataVariant = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_variant)
        TextView tvNamaVariant;
        @BindView(R.id.tv_harga_variant)
        TextView tvHargaVariant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
