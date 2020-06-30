package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.dialog.DialogSelectMeja;
import com.codelabs.konspirasisnack.model.GetTable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedMejaAdapter extends RecyclerView.Adapter<SelectedMejaAdapter.ViewHolder> {
    private List<GetTable.DATA.Meja> data;
    private Context mContext;
    private DialogSelectMeja.onUpdateSelectedMeja onUpdateSelectedMeja;

    public SelectedMejaAdapter(Context mContext, DialogSelectMeja.onUpdateSelectedMeja onUpdateSelectedMeja) {
        this.mContext = mContext;
        this.onUpdateSelectedMeja = onUpdateSelectedMeja;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_select_meja, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetTable.DATA.Meja meja = data.get(position);
        holder.tvNamaMeja.setText(meja.getTableName().replace("Meja ", ""));

        if (meja.getIs_reserved() == 1) {
            holder.layMain.setBackgroundColor(mContext.getResources().getColor(R.color.gray_darker));
            holder.tvNamaMeja.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            if (meja.isSelected()) {
                holder.layMain.setBackgroundColor(mContext.getResources().getColor(R.color.black));
                holder.tvNamaMeja.setTextColor(mContext.getResources().getColor(R.color.white));
            } else {
                holder.layMain.setBackground(mContext.getResources().getDrawable(R.drawable.border_gray));
                holder.tvNamaMeja.setTextColor(mContext.getResources().getColor(R.color.black));
            }
        }
    }

    public void setData(List<GetTable.DATA.Meja> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_meja)
        TextView tvNamaMeja;
        @BindView(R.id.lay_main)
        RelativeLayout layMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GetTable.DATA.Meja meja = data.get(getAdapterPosition());
                    if (meja.getIs_reserved() == 0){
                        if (meja.isSelected()){
                            if (!meja.isPermSelected()){
                                meja.setSelected(false);
                            }
                        }else{
                            meja.setSelected(true);
                        }
                        onUpdateSelectedMeja.onUpdateMeja();
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
