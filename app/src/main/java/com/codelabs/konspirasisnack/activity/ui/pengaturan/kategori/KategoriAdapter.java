package com.codelabs.konspirasisnack.activity.ui.pengaturan.kategori;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.dialog.DialogUpdateCategori;
import com.codelabs.konspirasisnack.model.GetProductCategory;
import com.codelabs.konspirasisnack.model.GetRefreshToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {
    public GetRefreshToken user;
    private List<GetProductCategory.DATA> data;
    private Context context;

    public KategoriAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pengaturan_kategori, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetProductCategory.DATA data = this.data.get(position);
        holder.txtCategoryNo.setText(data.getItemCatSort()+"");
        holder.txtCategoryName.setText(data.getItemCatName());
        holder.txtCategoryItem.setText(data.getTotalItemRegistered()+"");
    }

    public void setData(List<GetProductCategory.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_category_no)
        TextView txtCategoryNo;
        @BindView(R.id.txt_category_name)
        TextView txtCategoryName;
        @BindView(R.id.txt_category_item)
        TextView txtCategoryItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (user.data.user.uOutletId == 1) {
                        new DialogUpdateCategori(context, data.get(getAdapterPosition()));
                    }else{
                        Toast.makeText(context, "Hanya user pusat yang dapat mengubah kategori", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
