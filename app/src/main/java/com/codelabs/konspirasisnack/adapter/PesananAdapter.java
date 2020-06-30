package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.DetailPesanan;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.model.GetOrderListDate;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {
    private List<GetOrderListDate.DATA> data;
    private Context mContext;
    private int position;

    public PesananAdapter(Context mContext) {
        this.mContext = mContext;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_pesanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetOrderListDate.DATA data = this.data.get(position);
        if (position == this.position)
            holder.vSelected.setVisibility(View.VISIBLE);
        else
            holder.vSelected.setVisibility(View.GONE);

        holder.txtTanggal.setText(DateUtils.changeDateFormat(data.getTransactionDate(),DateUtils.WEB_DATE_FORMAT,DateUtils.DATENAME_DATE_MONTH_YEAR));
        holder.txtJumlahPesanan.setText(data.getTotalTransaction()+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetOrderListDate.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setSelectedPosition(int position) {

        this.position = position;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.v_selected)
        View vSelected;
        @BindView(R.id.txt_tanggal)
        TextView txtTanggal;
        @BindView(R.id.txt_jumlah_pesanan)
        TextView txtJumlahPesanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().post(new DetailPesanan(data.get(getAdapterPosition()),getAdapterPosition()));
                }
            });
        }
    }
}
