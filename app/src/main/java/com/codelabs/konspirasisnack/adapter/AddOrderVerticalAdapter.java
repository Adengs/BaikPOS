package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshProduct;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetProductDetail;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddOrderVerticalAdapter extends RecyclerView.Adapter<AddOrderVerticalAdapter.Holder> {

    private Context context;
    private List<GetProductDetail.DetailData> mItems = new ArrayList<>();
    private int variantChooseType;
    //    private RadioButton lastCheckedRB = null;
    int selectedRadio = -1;
    AddOrderVerticalAdapterOnListClick addOrderVerticalAdapterOnListClick;

    public AddOrderVerticalAdapter(Context context, AddOrderVerticalAdapterOnListClick addOrderVerticalAdapterOnListClick) {
        this.context = context;
        this.addOrderVerticalAdapterOnListClick = addOrderVerticalAdapterOnListClick;
    }

    public List<GetProductDetail.DetailData> getItems() {
        return mItems;
    }

    public void setData(List<GetProductDetail.DetailData> items, int variantChooseType) {
        mItems = items;
        this.variantChooseType = variantChooseType;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AddOrderVerticalAdapter.Holder onCreateViewHolder(@NonNull final ViewGroup parent, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_add_order_vertical, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddOrderVerticalAdapter.Holder holder, int position) {

        if (variantChooseType == 1) {
            holder.radioButton.setText(getItems().get(position).getDetail_name_txt());
//            holder.tvHargaRadio.setText("+" + RecentUtils.toRupiah("", getItems().get(position).getVariant_detail_harga_jual()).replace(".",""));
            holder.tvHargaRadio.setText("+" + Utils.toCurrency(getItems().get(position).getVariant_detail_harga_jual()));
            holder.linerCheckBox.setVisibility(View.GONE);
            holder.linerRadio.setVisibility(View.VISIBLE);
            holder.radioButton.setChecked(selectedRadio == position);
            mItems.get(position).setChecked(selectedRadio == position);
            if (position  == mItems.size() -1)
                EventBus.getDefault().post(new RefreshProduct());

        } else if (variantChooseType == 2) {
            holder.checkBox.setText(getItems().get(position).getDetail_name_txt());
//            holder.tvHargaCheckbox.setText("+" + RecentUtils.toRupiah("", getItems().get(position).getVariant_detail_harga_jual()).replace(".",""));
            holder.tvHargaCheckbox.setText("+" + Utils.toCurrency(getItems().get(position).getVariant_detail_harga_jual()));
            holder.linerCheckBox.setVisibility(View.VISIBLE);
            holder.linerRadio.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.tv_variant_detail)
//        TextView tvVariantDetail;
        @BindView(R.id.radio_name)
        RadioButton radioButton;
        //        @BindView(R.id.radio_group)
//        RadioGroup radioGroup;
        @BindView(R.id.checkbox_variant)
        CheckBox checkBox;
        @BindView(R.id.liner_radiobutton)
        RelativeLayout linerRadio;
        @BindView(R.id.liner_checkbox)
        RelativeLayout linerCheckBox;
        @BindView(R.id.tv_harga_radio)
        TextView tvHargaRadio;
        @BindView(R.id.tv_harga_checkbox)
        TextView tvHargaCheckbox;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedRadio = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    mItems.get(getAdapterPosition()).setChecked(b);
                    EventBus.getDefault().post(new RefreshProduct());
                }
            });
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    RadioButton checked_rb = (RadioButton) group.findViewById(checkedId);
//                    if (lastCheckedRB != null) {
//                        lastCheckedRB.setChecked(false);
//                        mItems.get(getAdapterPosition()).setChecked(false);
//                    }
//                    //store the clicked radiobutton
//                    lastCheckedRB = checked_rb;
//                    mItems.get(getAdapterPosition()).setChecked(true);
//
//                    Toast.makeText(context, "checked change " + mItems.get(getAdapterPosition()).getDetail_name_txt(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
        }
    }

    public interface AddOrderVerticalAdapterOnListClick {

    }
}
