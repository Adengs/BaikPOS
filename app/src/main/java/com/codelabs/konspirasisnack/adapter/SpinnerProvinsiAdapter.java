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
import com.codelabs.konspirasisnack.model.GetProvince;

import java.util.ArrayList;
import java.util.List;

public class SpinnerProvinsiAdapter extends ArrayAdapter<GetProvince.DATAProvince> {

    private List<GetProvince.DATAProvince> mItems = new ArrayList<>();
    private Context mContext;


    public SpinnerProvinsiAdapter(Context context, List<GetProvince.DATAProvince> mItems) {
        super(context, 0, mItems);
        this.mItems = mItems;
        this.mContext = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_spinner_kota, parent, false
            );
        }

        TextView tvName = convertView.findViewById(R.id.tv_name_kota);
        GetProvince.DATAProvince currentItem = getItem(position);

        if (currentItem != null) {
            tvName.setText(currentItem.getProvince_name());
        }

        return convertView;
    }

    @Override
    public GetProvince.DATAProvince getItem(int position) {
        return super.getItem(position);
    }
}
