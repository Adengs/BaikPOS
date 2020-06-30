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
import com.codelabs.konspirasisnack.model.GetJenisUsaha;

import java.util.ArrayList;
import java.util.List;

public class SpinnerJenisUsahaAdapter extends ArrayAdapter<GetJenisUsaha.DATAUsaha> {

   private List<GetJenisUsaha.DATAUsaha> mItems = new ArrayList<>();
   private Context mContext;

    public SpinnerJenisUsahaAdapter(Context context, List<GetJenisUsaha.DATAUsaha> mItems) {
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
        GetJenisUsaha.DATAUsaha currentItem = getItem(position);

        if (currentItem != null) {
            tvName.setText(currentItem.getMcat_name());
        }

        return convertView;
    }

    @Override
    public GetJenisUsaha.DATAUsaha getItem(int position) {
        return super.getItem(position);
    }
}
