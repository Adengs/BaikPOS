package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderDetail;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderMejaTambahanAdapter extends RecyclerView.Adapter<OrderMejaTambahanAdapter.ViewHolder> {

    private List<GetOrderDetail.DATA.TransactionItems> dataOrder;
    private Context mContext;

    public OrderMejaTambahanAdapter(Context context) {
        this.mContext = context;
        dataOrder = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_tambahan_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetOrderDetail.DATA.TransactionItems data = this.dataOrder.get(position);
        holder.tvCatatan.setText(data.getTrItemInfo());
//        holder.tvNamaMakanan.setText(data.getDetailItem().getItemName());
        holder.tvNamaMakanan.setText(data.getTr_item_name());
        holder.tvHarga.setText(Utils.toCurrency(data.getTrItemTotalPrice().replace(".00","")));
        holder.tvJumlahOrder.setText(data.getTrItemQty().replace(".00",""));
        holder.rela3.setVisibility(data.getTrItemInfo().length() > 0 ? View.VISIBLE : View.GONE);

        holder.rvVariants.setLayoutManager(new LinearLayoutManager(mContext));
        SelectedVariantsMejaTambahanAdapter adapter = new SelectedVariantsMejaTambahanAdapter(mContext);
        adapter.setData(data.getVariants());
        holder.rvVariants.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return dataOrder.size();
    }

    public void setDataOrderMeja(List<GetOrderDetail.DATA.TransactionItems> data){
        this.dataOrder = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_variants)
        RecyclerView rvVariants;

        @BindView(R.id.rv_product)
        RecyclerView rvProduct;
        @BindView(R.id.tv_jumlah_order)
        TextView tvJumlahOrder;
        @BindView(R.id.tv_nama_makanan)
        TextView tvNamaMakanan;
        @BindView(R.id.tv_harga)
        TextView tvHarga;
        @BindView(R.id.tv_tv_plus_gone)
        TextView tvPlus;
        @BindView(R.id.tv_nama_catatan)
        TextView tvCatatan;
        @BindView(R.id.rela_1)
        RelativeLayout rela1;
        @BindView(R.id.rela_3)
        RelativeLayout rela3;

        @BindView(R.id.img_del)
        ImageView liner;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            liner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(dataOrder.get(getAdapterPosition()));
                }
            });
        }
    }
}
