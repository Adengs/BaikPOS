package com.codelabs.konspirasisnack.dialog;

import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialog;

import com.codelabs.konspirasisnack.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogProgress extends AppCompatDialog {

    @BindView(R.id.tv_loading)
    TextView tvLoading;
    @BindView(R.id.tv_loading_desc)
    TextView tvLoadingDesc;



    public DialogProgress(Context context, String title, boolean stat) {
        super(context, R.style.TransparentDialogTheme);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);

        tvLoading.setText(title);
        String desc;
        if (stat)
            desc = "Please wait for " + title.toLowerCase();
        else
            desc = "Please wait a moment";

        tvLoadingDesc.setText(desc);

        setCanceledOnTouchOutside(false);
    }
}
