package com.codelabs.konspirasisnack.activity.ui.pengaturan.stok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.fragment.UbahStokDialogFragment;
import com.codelabs.konspirasisnack.model.GetStock;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StokAdapter extends RecyclerView.Adapter<StokAdapter.ViewHolder> {
    private List<GetStock.DATA> data;
    private Context context;

    public StokAdapter(Context context) {

        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pengaturan_stok, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetStock.DATA data = this.data.get(position);
        holder.txtNama.setText(data.getItemName());
        holder.txtAwal.setText(data.getStockAwal());
        holder.txtMasuk.setText(data.getStockMasuk());
        holder.txtTerjual.setText(data.getStockTerjual());
        holder.txtAkhir.setText(data.getStockAkhir());
        holder.txtSatuan.setText(data.getUnitName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetStock.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_awal)
        TextView txtAwal;
        @BindView(R.id.txt_masuk)
        TextView txtMasuk;
        @BindView(R.id.txt_terjual)
        TextView txtTerjual;
        @BindView(R.id.txt_akhir)
        TextView txtAkhir;
        @BindView(R.id.txt_satuan)
        TextView txtSatuan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
                    UbahStokDialogFragment newFragment=  UbahStokDialogFragment.newInstance(data.get(getAdapterPosition()));
                    newFragment.show(fm, "title");

                }
            });
        }
    }
}
