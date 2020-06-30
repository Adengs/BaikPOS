package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.PaymentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentItemAdapter extends RecyclerView.Adapter<PaymentItemAdapter.ViewHolder> {
    private List<PaymentModel.DATA.TransactionItems> data;
    private Context context;

    public PaymentItemAdapter(Context context) {

        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_payment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PaymentModel.DATA.TransactionItems data = this.data.get(position);
        holder.txtNama.setText(data.getTr_item_name());
        holder.txtHarga.setText(Utils.toCurrency(data.getTrItemActualPrice().replace(".00",""))+" x "+data.getTrItemQty().replace(".00",""));
        int harga = Integer.parseInt(data.getTrItemActualPrice().replace(".00",""));
        int qty =  Integer.parseInt(data.getTrItemQty().replace(".00",""));
        int totalVariant = 0;
        for (PaymentModel.DATA.TransactionItems.Variants var : data.getVariants())
            totalVariant += Integer.parseInt(var.getTrVariantActualPrice().replace(".00","")) * qty;
        int subTotal = (harga * qty) + totalVariant;
        holder.txtSubtotalItem.setText(Utils.toCurrency(String.valueOf(subTotal)));
        holder.txtPaymentPromo.setText("-"+Utils.toCurrency(data.getTrItemDiscountValue().replace(".00","")));
        if (data.getTrItemDiscountValue().replace(".00","").equals("0"))
            holder.llPromo.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<PaymentModel.DATA.TransactionItems> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_harga)
        TextView txtHarga;
        @BindView(R.id.txt_subtotal_item)
        TextView txtSubtotalItem;
        @BindView(R.id.txt_payment_promo)
        TextView txtPaymentPromo;
        @BindView(R.id.ll_promo)
        LinearLayout llPromo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
