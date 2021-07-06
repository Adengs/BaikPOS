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
import com.codelabs.konspirasisnack.model.GetKecamatan;

import java.util.ArrayList;
import java.util.List;

public class SpinnerKecamatanAdapter extends ArrayAdapter<GetKecamatan.DATA> {
    private List<GetKecamatan.DATA> mItems = new ArrayList<>();
    private Context mContext;


    public SpinnerKecamatanAdapter(Context context, List<GetKecamatan.DATA> mItems) {
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
        GetKecamatan.DATA currentItem = getItem(position);

        if (currentItem != null) {
            tvName.setText(currentItem.getSubdistrictName());
        }

        return convertView;
    }

    @Override
    public GetKecamatan.DATA getItem(int position) {
        return super.getItem(position);
    }

}
