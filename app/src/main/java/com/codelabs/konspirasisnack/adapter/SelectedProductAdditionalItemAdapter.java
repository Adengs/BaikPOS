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
import com.codelabs.konspirasisnack.model.GetProductDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedProductAdditionalItemAdapter extends RecyclerView.Adapter<SelectedProductAdditionalItemAdapter.ViewHolder> {
    private List<GetProductDetail.DetailData> data;
    private Context context;

    public SelectedProductAdditionalItemAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_selected_additional_produk, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetProductDetail.DetailData data = this.data.get(position);

        holder.tvNamaVariant.setText(data.getDetail_name_txt());
        holder.tvHargaVariant.setText(Utils.toCurrency(data.getVariant_detail_harga_jual().replace(".00","")));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetProductDetail.DetailData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_variant)
        TextView tvNamaVariant;
        @BindView(R.id.tv_harga_variant)
        TextView tvHargaVariant;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
