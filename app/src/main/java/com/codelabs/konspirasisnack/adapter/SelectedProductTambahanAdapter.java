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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SelectedProductTambahanAdapter extends RecyclerView.Adapter<SelectedProductTambahanAdapter.ViewHolder> {


    private List<GetOrderDetail.DATA.TransactionItems> data;
    private Context mContext;

    public SelectedProductTambahanAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_selected_product_tambahan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedProductTambahanAdapter.ViewHolder holder, int position) {

        GetOrderDetail.DATA.TransactionItems data = this.data.get(position);

        holder.tvHarga.setText(data.getTrItemQty().replace(".00",""));
        holder.tvNamaMakanan.setText(data.getTr_item_name());
        holder.tvHarga.setText(Utils.toCurrency(data.getTrItemActualPrice().replace(".00", "")));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetOrderDetail.DATA.TransactionItems> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_jumlah_order)
        TextView tvJumlahOrder;
        @BindView(R.id.tv_nama_makanan)
        TextView tvNamaMakanan;
        @BindView(R.id.tv_harga)
        TextView tvHarga;
        @BindView(R.id.img_del)
        ImageView imgDel;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
