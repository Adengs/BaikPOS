package com.codelabs.konspirasisnack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.model.GetOrderType;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapterOrderType extends ArrayAdapter<GetOrderType.DATA> {
    private List<GetOrderType.DATA> mItems = new ArrayList<>();
    private Context context;

    public SpinnerAdapterOrderType(Context context, List<GetOrderType.DATA> mItems) {
        super(context, 0, mItems);
        this.mItems = mItems;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = initView(position, convertView, parent, false);
        TextView tvName = v.findViewById(android.R.id.text1);
        tvName.setTextColor(context.getResources().getColor(R.color.black));
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent, true);
    }

    private View initView(int position, View convertView, ViewGroup parent, boolean isDropDown) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_spin, parent, false
            );
        }

        TextView tvName = convertView.findViewById(android.R.id.text1);
        tvName.setTextColor(context.getResources().getColor(R.color.green_dark));
        GetOrderType.DATA currentItem = getItem(position);

        if (currentItem != null) {

            tvName.setText(currentItem.getTypeName());
            if (!isDropDown)
                tvName.setPadding(0, tvName.getPaddingTop(), tvName.getPaddingRight(), tvName.getPaddingBottom());
        }

        return convertView;
    }

    @Override
    public GetOrderType.DATA getItem(int position) {
        return super.getItem(position);
    }
}
