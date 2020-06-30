package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.ProductBus;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetProductDetail;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderProdukAdapter extends RecyclerView.Adapter<OrderProdukAdapter.ViewHolder> {


    private List<GetProductDetail.DATAProduct> data;
    private Context mContext;
    private int totalHarga;
    private int totalQty;
    private int totalSemua;
    private int totalHargaActual;
    private int totalQtyActual;
    private int totalSemuaActual;

    public OrderProdukAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_order_produk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetProductDetail.DATAProduct data = this.data.get(position);

        totalHarga = Integer.parseInt(data.getItem_harga_jual().replace(".00", ""));
        totalQty = data.getQty();
        totalSemua = totalHarga * totalQty;

        totalHargaActual = Integer.parseInt(data.getItem_harga_jual_actual().replace(".00",""));
        totalQtyActual = data.getQty();
        totalSemuaActual = totalHargaActual * totalQtyActual;

        if (data.getIs_promo_available() == 1){
            holder.rela2.setVisibility(View.VISIBLE);
            holder.tvHargaAsli.setText(Utils.toCurrency(String.valueOf(totalSemuaActual)));
            holder.tvHargaAsli.setPaintFlags(holder.tvHargaAsli.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            holder.rela2.setVisibility(View.GONE);
        }


        holder.tvNamaMakanan.setText(data.getItem_name());
        holder.tvJumlahOrder.setText(data.getQty() + "");
        holder.tvHarga.setText(Utils.toCurrency(String.valueOf(totalSemua)));
        holder.tvCatatan.setText(data.getNote());
        holder.rela3.setVisibility(data.getNote().length() > 0 ? View.VISIBLE : View.GONE);

        List<GetProductDetail.DetailData> selectedVariants = new ArrayList<>();
        for (GetProductDetail.VariantsData variant : data.getVariantsData())
            for (GetProductDetail.DetailData detailVariant : variant.getDetailData())
                if (detailVariant.isChecked())
                    selectedVariants.add(detailVariant);
        holder.rv_additional.setLayoutManager(new LinearLayoutManager(mContext));
        SelectedProductAdditionalItemAdapter adapter = new SelectedProductAdditionalItemAdapter(mContext);
        adapter.setData(selectedVariants);
        holder.rv_additional.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetProductDetail.DATAProduct> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.liner)
        LinearLayout liner;
        @BindView(R.id.rela_1)
        RelativeLayout rela1;
        @BindView(R.id.rela_3)
        RelativeLayout rela3;
        @BindView(R.id.tv_jumlah_order)
        TextView tvJumlahOrder;
        @BindView(R.id.tv_nama_makanan)
        TextView tvNamaMakanan;
        @BindView(R.id.tv_nama_catatan)
        TextView tvCatatan;
        @BindView(R.id.tv_harga)
        TextView tvHarga;
        @BindView(R.id.img_del)
        ImageView imgDel;
        @BindView(R.id.rv_additional)
        RecyclerView rv_additional;
        @BindView(R.id.rela_2)
        RelativeLayout rela2;
        @BindView(R.id.tv_harga1)
        TextView tvHargaAsli;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            imgDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new ProductBus(data.get(getAdapterPosition())));
//                    switch (v.getId()) {
//                        case R.id.liner:
//
////                            Toast.makeText(mContext, "Stok produk habis",
////                                    Toast.LENGTH_SHORT).show();
//                            DeleteListOrderFragment deleteListOrderFragment = new DeleteListOrderFragment();
//                            deleteListOrderFragment.show(((FragmentActivity) mContext).getSupportFragmentManager(), deleteListOrderFragment.getTag());
//
//                        default:
//                            break;
//                    }

                }
            });
        }
    }
}
