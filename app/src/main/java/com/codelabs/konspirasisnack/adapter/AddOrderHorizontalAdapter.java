package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetProductDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddOrderHorizontalAdapter extends RecyclerView.Adapter<AddOrderHorizontalAdapter.Holder> implements AddOrderVerticalAdapter.AddOrderVerticalAdapterOnListClick {

    private Context context;
    private List<GetProductDetail.VariantsData> mItems = new ArrayList<>();
    public AddOrderHorizontalAdapter(Context context) {
        this.context = context;
    }

    public List<GetProductDetail.VariantsData> getItems(){
        return mItems;
    }

    public void setData(List<GetProductDetail.VariantsData> items) {
        mItems = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AddOrderHorizontalAdapter.Holder onCreateViewHolder(@NonNull final ViewGroup parent, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_add_order_horizontal,parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddOrderHorizontalAdapter.Holder holder, int position) {


        holder.tvVariant.setText(mItems.get(position).getVariant_name());
        AddOrderVerticalAdapter addOrderVerticalAdapter = new AddOrderVerticalAdapter(context, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL, false);
        holder.rvListVariant.setLayoutManager(linearLayoutManager);
        holder.rvListVariant.setAdapter(addOrderVerticalAdapter);
        addOrderVerticalAdapter.setData(getItems().get(position).getDetailData(), getItems().get(position).getVariant_choose_type());



    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 :mItems.size();

    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

       @BindView(R.id.tv_variant)
       TextView tvVariant;
       @BindView(R.id.rv_list_variant)
       RecyclerView rvListVariant;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }


}
