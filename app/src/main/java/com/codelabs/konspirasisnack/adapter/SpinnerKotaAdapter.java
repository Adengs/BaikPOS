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
import com.codelabs.konspirasisnack.model.GetCities;

import java.util.ArrayList;
import java.util.List;

public class SpinnerKotaAdapter extends ArrayAdapter<GetCities.DATACities> {

    private List<GetCities.DATACities> mItems = new ArrayList<>();
    private Context mContext;

    public SpinnerKotaAdapter(Context context, List<GetCities.DATACities> mItems) {
        super(context, 0, mItems);
        this.mItems = mItems;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView (position, convertView, parent);
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
        GetCities.DATACities currentItem = getItem(position);

        if (currentItem != null) {
            tvName.setText(currentItem.getRegency_name());
        }

        return convertView;
    }

    @Override
    public GetCities.DATACities getItem(int position) {
        return super.getItem(position);
    }
}
