package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenjualanAdapter extends RecyclerView.Adapter<PenjualanAdapter.ViewHolder> {
    private List<GetOrderListData.DATA> data;
    private Context context;

    public PenjualanAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_penjualan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetOrderListData.DATA data = this.data.get(position);
        holder.txtInvoiceNo.setText(data.getTransCode());

        holder.txtPelanggan.setText(data.getTransCustomerId() == 0 ? context.getString(R.string.tanpa_pelanggan) : data.getTransCustomerName());
        holder.txtTanggal.setText(DateUtils.changeDateFormat(data.getTransDate(),DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.DATE_FORMAT_MONTH_TIME_STANDARD2));
        holder.txtKasir.setText(data.getCashierName());
        holder.txtJenis.setText(data.getOrderTypeName());
        holder.txtPaymentMethod.setText(Utils.toCurrency(data.getTransTotal().replace(".00",""))+" "+data.getPaymentMethodName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetOrderListData.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_invoice_no)
        TextView txtInvoiceNo;
        @BindView(R.id.txt_pelanggan)
        TextView txtPelanggan;
        @BindView(R.id.txt_tanggal)
        TextView txtTanggal;
        @BindView(R.id.txt_kasir)
        TextView txtKasir;
        @BindView(R.id.txt_jenis)
        TextView txtJenis;
        @BindView(R.id.txt_payment_method)
        TextView txtPaymentMethod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
