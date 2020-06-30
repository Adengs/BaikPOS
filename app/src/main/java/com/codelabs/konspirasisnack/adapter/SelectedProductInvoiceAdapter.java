package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetOrderDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedProductInvoiceAdapter extends RecyclerView.Adapter<SelectedProductInvoiceAdapter.ViewHolder> {
    private List<GetOrderDetail.DATA.TransactionItems> data;
    private Context mContext;

    public SelectedProductInvoiceAdapter(Context mContext) {
        this.mContext = mContext;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_selected_produk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        GetOrderDetail.DATA.TransactionItems data = this.data.get(position);
//        holder.tvCatatan.setText(data.getTrItemInfo());
//        holder.tvProduct.setText(data.getDetailItem().getItemName());
//        holder.tvProductPrice.setText(data.getDetailItem().getItemHargaJual().replace(".00",""));
//        holder.txtQty.setText(data.getTrItemQty().replace(".00",""));
//        holder.rela3.setVisibility(data.getTrItemInfo().length() > 0 ? View.VISIBLE : View.GONE);
//
//        holder.rvDetail.setLayoutManager(new LinearLayoutManager(mContext));
//        SelectedVariantProductInvoiceAdapter adapter = new SelectedVariantProductInvoiceAdapter(mContext);
//        adapter.setData(data.getVariants());
//        holder.rvDetail.setAdapter(adapter);



        GetOrderDetail.DATA.TransactionItems data = this.data.get(position);

        if (data.getTrItemDiscountValue().equals("0.00")){
            holder.relaPromo.setVisibility(View.GONE);
            holder.tvPromoPrice.setText(String.valueOf(data.getTr_item_harga_jual_actual()));
            holder.tvPromoPrice.setPaintFlags(holder.tvPromoPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            holder.relaPromo.setVisibility(View.VISIBLE);
            holder.tvPromoPrice.setText(String.valueOf(data.getTr_item_harga_jual_actual()));
            holder.tvPromoPrice.setPaintFlags(holder.tvPromoPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }



        holder.tvCatatan.setText(data.getTrItemInfo());
//        holder.tvProduct.setText(data.getDetailItem().getItemName());
        holder.tvProduct.setText(data.getTr_item_name());
        holder.tvProductPrice.setText(data.getTrItemTotalPrice().replace(".00",""));
        holder.txtQty.setText(data.getTrItemQty().replace(".00",""));
        holder.rela3.setVisibility(data.getTrItemInfo().length() > 0 ? View.VISIBLE : View.GONE);

        holder.rvDetail.setLayoutManager(new LinearLayoutManager(mContext));
        SelectedVariantProductInvoiceAdapter adapter = new SelectedVariantProductInvoiceAdapter(mContext);
        adapter.setData(data.getVariants());
        holder.rvDetail.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setData(List<GetOrderDetail.DATA.TransactionItems> data) {
        this.data = data;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_qty)
        TextView txtQty;
        @BindView(R.id.tv_product)
        TextView tvProduct;
        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;
        @BindView(R.id.rv_detail)
        RecyclerView rvDetail;
        @BindView(R.id.tv_nama_catatan)
        TextView tvCatatan;
        @BindView(R.id.rela_3)
        RelativeLayout rela3;
        @BindView(R.id.rela_promo)
        RelativeLayout relaPromo;
        @BindView(R.id.tv_promo_price)
        TextView tvPromoPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
