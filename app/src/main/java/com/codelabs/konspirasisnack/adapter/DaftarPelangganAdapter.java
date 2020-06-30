package com.codelabs.konspirasisnack.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.model.GetCustomer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaftarPelangganAdapter extends RecyclerView.Adapter<DaftarPelangganAdapter.ViewHolder> {

    private List<GetCustomer.DATA> data;
    private Context context;

    public DaftarPelangganAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context)
                .inflate(R.layout.item_daftar_pelanggan, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetCustomer.DATA selectedData = data.get(position);
        holder.tvNama.setText(selectedData.getCustFullname());
        holder.tvAlamat.setText(selectedData.getCustAddress());
        holder.tvPoin.setText(selectedData.getCustTotalPoint()+"");
        holder.tvNohp.setText(selectedData.getCustPhone());
        holder.tvKelamin.setText(selectedData.getCustGender().equals("female")? "P" : "L");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetCustomer.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama)
        TextView tvNama;
        @BindView(R.id.tv_alamat)
        TextView tvAlamat;
        @BindView(R.id.tv_poin)
        TextView tvPoin;
        @BindView(R.id.tv_kelamin)
        TextView tvKelamin;
        @BindView(R.id.tv_nohp)
        TextView tvNohp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataManager.getInstance().setCustomerId(data.get(getAdapterPosition()).getCustId());


                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(AppConstant.DATA_CUSTOMER, data.get(getAdapterPosition()));

                    ((Activity)context).setResult(Activity.RESULT_OK,returnIntent);
                    ((Activity)context).finish();

                }
            });
        }
    }
}
