package com.codelabs.konspirasisnack.activity.ui.pengaturan.produk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetProducts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {
    private List<GetProducts.DATABean> data;
    private Context context;

    public ProdukAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pengaturan_produk, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetProducts.DATABean data = this.data.get(position);
        Picasso.get().load(data.getItemImage()).into(holder.ivProduk);
        holder.txtNama.setText(data.getItemName());
        holder.txtKategori.setText(data.getCategoryNameTxt());
        holder.txtStok.setText(data.getActualStock()+"");
        holder.txtPrice.setText(Utils.toCurrency(data.getItemHargaJual().replace(".00","")));
    }

    public void setData(List<GetProducts.DATABean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_produk)
        ImageView ivProduk;
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_kategori)
        TextView txtKategori;
        @BindView(R.id.txt_stok)
        TextView txtStok;
        @BindView(R.id.txt_price)
        TextView txtPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
