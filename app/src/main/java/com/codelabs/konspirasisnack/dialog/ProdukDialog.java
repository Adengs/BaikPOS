package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codelabs.konspirasisnack.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProdukDialog extends Dialog implements View.OnClickListener{
    @BindView(R.id.iv_produk)
    ImageView ivProduk;
    @BindView(R.id.tv_nama_produk)
    TextView tvNamaProduk;
    @BindView(R.id.lay1)
    LinearLayout lay1;
//    @BindView(R.id.lay_2)
//    RelativeLayout lay2;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.lay_3)
    RelativeLayout lay3;



    public ProdukDialog(Context context) {
        super(context);
        getWindow().setGravity(Gravity.TOP);

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        View v = View.inflate(context, R.layout.dialog_produk, null);
        setContentView(v);

        ButterKnife.bind(this, v);
        initView();
        show();



        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void initView() {
        ViewTreeObserver vto = lay1.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    lay1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    lay1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width = lay1.getMeasuredWidth();
                int height = lay1.getMeasuredHeight();

//                lay2.getLayoutParams().height = height;
//                lay2.requestLayout();
                lay3.getLayoutParams().height = height;
                lay3.requestLayout();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
