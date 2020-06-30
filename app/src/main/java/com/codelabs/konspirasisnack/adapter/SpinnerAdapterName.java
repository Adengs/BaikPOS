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
import com.codelabs.konspirasisnack.model.GetEmployee_list;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapterName extends ArrayAdapter<GetEmployee_list.DATAEmployee> {

    private List<GetEmployee_list.DATAEmployee> mItems = new ArrayList<>();
    private Context context;

    public SpinnerAdapterName(Context context, List<GetEmployee_list.DATAEmployee> mItems) {
        super(context, 0, mItems);
        this.mItems = mItems;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent,false);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent,true);
    }

    private View initView(int position, View convertView, ViewGroup parent,boolean isDropDown) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_spinner_name, parent, false
            );
        }

        TextView tvName = convertView.findViewById(R.id.tv_name_kasir);

        GetEmployee_list.DATAEmployee currentItem = getItem(position);

        if (currentItem != null) {

            tvName.setText(currentItem.getU_firstname());
            if (!isDropDown){
                tvName.setPadding(0, tvName.getPaddingTop(), tvName.getPaddingRight(), tvName.getPaddingBottom());

            }else{
                tvName.setPadding(tvName.getPaddingLeft(), tvName.getPaddingTop(), tvName.getPaddingRight(), tvName.getPaddingBottom());
            }
        }


        return convertView;
    }

    @Override
    public GetEmployee_list.DATAEmployee getItem(int position) {
        return super.getItem(position);
    }
}
