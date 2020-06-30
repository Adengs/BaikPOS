package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetPaymentMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {
    private List<GetPaymentMethod.DATA> data;
    private Context mContext;
    int position = -1;

    public PaymentMethodAdapter(Context context) {
        this.mContext = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_payment_method, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetPaymentMethod.DATA data = this.data.get(position);
        holder.txtPaymentName.setText(data.getPmName());
//        holder.txtPaymentName.setText(String.valueOf(data.getPmId()));
        holder.v.setVisibility(position == this.position ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetPaymentMethod.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
    }

    public int getPosition() {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.v)
        View v;
        @BindView(R.id.txt_payment_name)
        TextView txtPaymentName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setPosition(getAdapterPosition());
                }
            });
        }
    }
}
