package com.codelabs.konspirasisnack.adapter;

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
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPesananAdapter extends RecyclerView.Adapter<DetailPesananAdapter.ViewHolder> {
    private Context context;
    private List<GetOrderDetail.DATA.TransactionItems> data;

    public DetailPesananAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_pesanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetOrderDetail.DATA.TransactionItems data = this.data.get(position);
        holder.txtMenu.setText(data.getTr_item_name());
        holder.txtQty.setText("x " + data.getTrItemQty().replace(".00", ""));
        StringBuilder extra = new StringBuilder();
        for (GetOrderDetail.DATA.TransactionItems.Variants var : data.getVariants()) {
//            extra.append(var.getItem().getDetailNameTxt()+", ");
            extra.append(var.getTr_variant_item_name()+", ");
        }
        if (extra.length() > 0) {
            extra.trimToSize();
            extra.deleteCharAt(extra.length() -1);
        }else{
            extra = new StringBuilder();
            extra.append("-");
        }
        holder.txtExtra.setText("Extra : " + extra);
        holder.txtSubtotal.setText(Utils.toCurrency(data.getTrItemTotalPrice().replace(".00", "")));
        if (!data.getTrItemImage().equalsIgnoreCase(""))
            Picasso.get().load(data.getTrItemImage()).into(holder.ivPic);

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
        @BindView(R.id.iv_pic)
        ImageView ivPic;
        @BindView(R.id.txt_menu)
        TextView txtMenu;
        @BindView(R.id.txt_extra)
        TextView txtExtra;
        @BindView(R.id.txt_subtotal)
        TextView txtSubtotal;
        @BindView(R.id.txt_qty)
        TextView txtQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
