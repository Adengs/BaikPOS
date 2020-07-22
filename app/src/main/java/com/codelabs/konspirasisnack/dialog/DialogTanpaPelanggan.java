package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.R;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogTanpaPelanggan extends Dialog {

    @BindView(R.id.txt_nama)
    TextInputEditText txtNama;
    @BindView(R.id.txt_nohp)
    TextInputEditText txtNoHp;
    @BindView(R.id.btn_close)
    ImageView btnClose;





    public DialogTanpaPelanggan(@NonNull Context context) {
        super(context);

        setContentView(R.layout.dialog_tanpa_pelanggan);
        ButterKnife.bind(this);
        setCancelable(false);
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        show();
    }

    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }
}
