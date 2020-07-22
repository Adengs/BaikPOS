package com.codelabs.konspirasisnack.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.codelabs.konspirasisnack.EventBus.RefreshMeja;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.SelectedMejaAdapter;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.model.GetCustomer;
import com.codelabs.konspirasisnack.model.GetTable;
import com.codelabs.konspirasisnack.model.ParamCreateReservation;
import com.codelabs.konspirasisnack.utils.CheckDevice;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogSelectMeja extends Dialog {
    private final GetCustomer.DATA customer;
    @BindView(R.id.txt_namameja)
    TextView txtNamameja;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.btn_decrease)
    Button btnDecrease;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.btn_increase)
    Button btnIncrease;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.radio_grup)
    RadioGroup radioGrup;
    @BindView(R.id.rv_meja)
    RecyclerView rvMeja;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    private List<GetTable.DATA.Meja> data;
    private GetTable.DATA.Meja meja;
    onUpdateSelectedMeja onUpdateSelectedMeja;

    public DialogSelectMeja(Context context, List<GetTable.DATA.Meja> data, GetTable.DATA.Meja meja, GetCustomer.DATA customer) {
        super(context);
        this.customer = customer;
        this.data = data;
        this.meja = meja;

        onUpdateSelectedMeja = new onUpdateSelectedMeja() {
            @Override
            public void onUpdateMeja() {
                DialogSelectMeja.this.onUpdateMeja();
            }
        };

        setContentView(R.layout.dialog_select_table);
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

        for (GetTable.DATA.Meja selecMeja : data)
            if (selecMeja.equals(meja)) {
                selecMeja.setSelected(true);
                selecMeja.setPermSelected(true);
            }
        txtNamameja.setText(meja.getTableName());
        rvMeja.setLayoutManager(new GridLayoutManager(getContext(), CheckDevice.isTablet() ? 5 : 4));
        SelectedMejaAdapter adapter = new SelectedMejaAdapter(getContext(), onUpdateSelectedMeja);
        adapter.setData(data);
        rvMeja.setAdapter(adapter);
    }


    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        for (GetTable.DATA.Meja selecMeja : data) {
            selecMeja.setSelected(false);
            selecMeja.setPermSelected(false);
        }
        dismiss();
    }

    public void onUpdateMeja() {
        int count = 0;
        for (GetTable.DATA.Meja meja : data)
            if (meja.isSelected())
                count++;
        if (count > 1)
            rb2.setChecked(true);
        else
            rb1.setChecked(true);
    }

    @OnClick({R.id.btn_decrease, R.id.btn_increase})
    public void onClickAddMin(View view) {
        switch (view.getId()) {
            case R.id.btn_decrease:
                if (!tvTotal.getText().toString().equals("1"))
                    tvTotal.setText(Integer.valueOf(tvTotal.getText().toString()) - 1 + "");
                break;
            case R.id.btn_increase:
                tvTotal.setText(Integer.valueOf(tvTotal.getText().toString()) + 1 + "");

                break;
        }
    }

    public interface onUpdateSelectedMeja {
        void onUpdateMeja();
    }


//    @OnClick(R.id.btn_submit)
//    void createReservation() {
//
//        Utils.changeVisibility(pbLoading);
//        Utils.changeVisibility(btnSubmit);
//        String date = DateUtils.getTodayDate();
//        ParamCreateReservation param = new ParamCreateReservation();
//        param.setMergeTables(rb1.isChecked() ? 1 : 0);
//        param.setNumberOfPeople(Integer.parseInt(tvTotal.getText().toString()));
//        param.setStatus(1);
//        param.setIsReservation(0);
//        param.setNote("");
//        param.setArrivalDate(DateUtils.changeDateFormat(date,DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.WEB_DATE_FORMAT));
//        param.setArrivalTime(DateUtils.changeDateFormat(date,DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.TIME_FORMAT_STANDARD_2));
//        List<ParamCreateReservation.Table> tables = new ArrayList<>();
//        for (GetTable.DATA.Meja tbl : data)
//            if (tbl.isSelected())
//                tables.add(new ParamCreateReservation.Table(tbl.getTableId()));
//        param.setTables(tables);
//        if (customer != null)
//            param.setCustomerId(customer.getCustId());
//
//        RetrofitInterface apiService = ApiUtils.getAPIService();
//        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
//        Call<GetCreateReservation> call = apiService.createReservation(auth, param);
//        call.enqueue(new Callback<GetCreateReservation>() {
//            @Override
//            public void onResponse(Call<GetCreateReservation> call, Response<GetCreateReservation> data) {
//                Utils.changeVisibility(pbLoading);
//                Utils.changeVisibility(btnSubmit);
//                if (data.isSuccessful()) {
//                    GetCreateReservation response = data.body();
//                    if (response != null) {
//                        if (response.getSTATUS() == 200) {
//                            EventBus.getDefault().post(response.getDATA());
//                            dismiss();
//                        } else {
//                            Toast.makeText(getContext(), data.message(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<GetCreateReservation> call, Throwable t) {
//                Utils.changeVisibility(pbLoading);
//                Utils.changeVisibility(btnSubmit);
//                t.printStackTrace();
//            }
//        });
//    }

    //
    @OnClick(R.id.btn_submit)
    void createReservationMeja() {


        String date = DateUtils.getTodayDate();
        DataManager dataManager = new DataManager();

        dataManager.setResMergeTables(rb1.isChecked() ? 1 : 0);
        dataManager.setResNumberPeople(Integer.parseInt(tvTotal.getText().toString()));
        dataManager.setStatus(1);
        dataManager.setResIsReservation(0);
        dataManager.setResNote("");
        dataManager.setResArrivalDate(DateUtils.changeDateFormat(date,DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.WEB_DATE_FORMAT));
        dataManager.setResArrivalTime(DateUtils.changeDateFormat(date,DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.TIME_FORMAT_STANDARD_2));

        List<ParamCreateReservation.Table> tables = new ArrayList<>();
        for (GetTable.DATA.Meja tbl : data)
            if (tbl.isSelected())
                tables.add(new ParamCreateReservation.Table(tbl.getTableId()));
        dataManager.setTableReservation(tables);
        if (customer != null)
            dataManager.setResCustomerId(customer.getCustId());
        EventBus.getDefault().post(new RefreshMeja());

        dismiss();

    }
}

