package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.helper.DummyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogVoucher2 extends Dialog {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.spin_voucher)
    Spinner spinVoucher;
    @BindView(R.id.txt_detail)
    TextView txtDetail;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    public DialogVoucher2(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_promo_2);
        ButterKnife.bind(this);
        initView();
        setCancelable(false);
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        show();

    }
    private void initView() {


        String detail = "<ul>\n" +
                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
                "   <li>Vestibulum auctor dapibus neque.</li>\n" +
                "</ul>";
        txtDetail.setText(Html.fromHtml(detail));


        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, DummyUtils.getDummy()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinVoucher.setAdapter(adapter);

    }



    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

}
