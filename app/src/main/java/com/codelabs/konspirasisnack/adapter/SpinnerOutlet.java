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
import com.codelabs.konspirasisnack.model.GetOutlet;

import java.util.ArrayList;
import java.util.List;

public class SpinnerOutlet extends ArrayAdapter<GetOutlet.DATA> {
    private List<GetOutlet.DATA> mItems = new ArrayList<>();
    private Context context;

    public SpinnerOutlet(Context context, List<GetOutlet.DATA> mItems) {
        super(context, 0, mItems);
        this.mItems = mItems;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = initView(position, convertView, parent);
        TextView tvName = v.findViewById(android.R.id.text1);
        tvName.setTextColor(context.getResources().getColor(R.color.black));
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_spin, parent, false
            );
        }

        TextView tvName = convertView.findViewById(android.R.id.text1);
        tvName.setTextColor(context.getResources().getColor(R.color.black));
        GetOutlet.DATA currentItem = getItem(position);

        if (currentItem != null) {

            tvName.setText(currentItem.getOtName());
        }

        return convertView;
    }


    @Override
    public GetOutlet.DATA getItem(int position) {
        return super.getItem(position);
    }
}
