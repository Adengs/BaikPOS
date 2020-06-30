package com.codelabs.konspirasisnack.activity.ui.home;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetProducts;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {
//    private List<GetProducts.DATA> data;

    private List<GetProducts.DATABean> mData = new ArrayList<>();

    private Context context;

    public ProdukAdapter(Context context) {
        this.context = context;

    }

    public List<GetProducts.DATABean> getItems() {
        return mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produk, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetProducts.DATABean selectedData = mData.get(position);
        Picasso.get().load(selectedData.getItemImage()).into(holder.ivProduk);

        if (selectedData.getIs_promo_available() == 1){
            holder.relaPromo.setVisibility(View.VISIBLE);
            holder.promoLabel.setVisibility(View.VISIBLE);
            holder.tvHargaDiskon.setText(Utils.toCurrency(selectedData.getItemHargaJual()));
            holder.tvHargaNormal.setText(selectedData.getItem_harga_jual_actual().replace(".00",""));
            holder.tvHargaNormal.setPaintFlags(holder.tvHargaNormal.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvHarga.setVisibility(View.GONE);
        }else {
            holder.relaPromo.setVisibility(View.GONE);
            holder.promoLabel.setVisibility(View.GONE);
            holder.tvHarga.setVisibility(View.VISIBLE);
            holder.tvHarga.setText(Utils.toCurrency(selectedData.getItemHargaJual()));

        }


        holder.tvNamaProduk.setText(selectedData.getItemName());
        holder.tvStok.setText(context.getString(R.string.stok) + " " + selectedData.getActualStock());
        holder.llStok.setVisibility(selectedData.getActualStock() > 0 ? View.VISIBLE : View.GONE);
        holder.llStokHabis.setVisibility(selectedData.getActualStock() == 0 ? View.VISIBLE : View.GONE);

//        Log.e("productsingo", (selectedData.getItemName()) + (selectedData.getItem_harga_jual_actual()));
    }

    public void setData(List<GetProducts.DATABean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_produk)
        ImageView ivProduk;
        @BindView(R.id.tv_stok)
        TextView tvStok;
        @BindView(R.id.ll_stok)
        RelativeLayout llStok;
        @BindView(R.id.ll_stok_habis)
        RelativeLayout llStokHabis;
        @BindView(R.id.tv_nama_produk)
        TextView tvNamaProduk;
        @BindView(R.id.tv_harga)
        TextView tvHarga;
        @BindView(R.id.liner_product)
        LinearLayout linerProduct;
        @BindView(R.id.tv_promo_label)
        TextView promoLabel;
        @BindView(R.id.tv_harga_normal)
        TextView tvHargaNormal;
        @BindView(R.id.tv_harga_diskon)
        TextView tvHargaDiskon;
        @BindView(R.id.rela_promo)
        RelativeLayout relaPromo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.liner_product:
                            if (mData.get(getAdapterPosition()).getActualStock() == 0){

                                Toast.makeText(context, "Stok produk habis",
                                        Toast.LENGTH_SHORT).show();
                            }else {
                                EventBus.getDefault().post(mData.get(getAdapterPosition()));
                            }
                            default:
                            break;
                    }

                }
            });
        }
    }
}
