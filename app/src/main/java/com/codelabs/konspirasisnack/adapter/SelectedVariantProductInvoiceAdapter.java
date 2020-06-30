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

public class SelectedVariantProductInvoiceAdapter extends RecyclerView.Adapter<SelectedVariantProductInvoiceAdapter.ViewHolder> {
    private List<GetOrderDetail.DATA.TransactionItems.Variants> data;

    public SelectedVariantProductInvoiceAdapter(Context mContext) {
        this.mContext = mContext;
        data = new ArrayList<>();
    }

    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_detail_selected_produk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetOrderDetail.DATA.TransactionItems.Variants data = this.data.get(position);
//        holder.tvAdditional.setText(data.getItem().getDetailNameTxt());
        holder.tvAdditional.setText(data.getTr_variant_item_name());
//        holder.tvAdditionalPrice.setText(Utils.toCurrency(data.getItem().getVariantDetailHargaJual().replace(".00","")));
        holder.tvAdditionalPrice.setText(Utils.toCurrency(data.getTrVariantActualPrice().replace(".00","")));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetOrderDetail.DATA.TransactionItems.Variants> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_additional)
        TextView tvAdditional;
        @BindView(R.id.tv_additional_price)
        TextView tvAdditionalPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
