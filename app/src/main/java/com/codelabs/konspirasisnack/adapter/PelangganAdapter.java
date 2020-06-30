package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class PelangganAdapter extends RecyclerView.Adapter<PelangganAdapter.ViewHolder> {


    private List<String> data;
    private Context mContext;


    public PelangganAdapter(Context context){
       this.mContext = context;
       data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_pelanggan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<String> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);



        }
    }
}
