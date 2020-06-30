package com.codelabs.konspirasisnack.activity.ui.laporan.ringkasan_penjualan;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codelabs.konspirasisnack.EventBus.SetDate;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetReportSelling;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RingkasanPenjualanFragment extends Fragment {

    @BindView(R.id.tv_value_pendapatan)
    TextView tvValuePendapatan;
    @BindView(R.id.tv_value_laba_kotor)
    TextView tvValueLabaKotor;
    @BindView(R.id.tv_pembayaran)
    TextView tvPembayaran;
    @BindView(R.id.tv_total_produk)
    TextView tvTotalProduk;
    @BindView(R.id.tv_total_transaksi)
    TextView tvTotalTransaksi;
    @BindView(R.id.chart)
    LineChartView lineChartView;

    private int outletId;
    private String date = DateUtils.getTodayDate(DateUtils.WEB_DATE_FORMAT);
    private GetReportSelling.DATAReportSelling dataReportSelling;
    private List<GetReportSelling.DATAChart> responseDataChart;
    private List yAxisValues = new ArrayList();
    private List axisValues = new ArrayList();
    private List<GetReportSelling.DATAChart> axisData = new ArrayList<>();
    private List<GetReportSelling.DATAChart> yAxisData = new ArrayList<>();
    Line line = new Line(yAxisValues).setColor(Color.parseColor("#80BF44"));




    public RingkasanPenjualanFragment() {
        // Required empty public constructor
    }


   public static RingkasanPenjualanFragment newInstance() {
        RingkasanPenjualanFragment fragment = new RingkasanPenjualanFragment();
        return fragment;
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ringkasan_penjualan, container, false);
        ButterKnife.bind(this, v);
        outletId = DataManager.getInstance().getOutlet().getOt_id();
        initView();


        return v;
    }

    private void initView() {
        getData();
    }


    public void getData() {

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("start_date", date);
        param.put("end_date", date);
        param.put("outlet_id", String.valueOf(outletId));

        Call<GetReportSelling> call = apiService.getReportSelling(auth, param);
        call.enqueue(new Callback<GetReportSelling>() {
            @Override
            public void onResponse(Call<GetReportSelling> call, Response<GetReportSelling> data) {
                if (data.isSuccessful()) {
                    GetReportSelling response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            dataReportSelling = response.getDATA();
                            getTextValue();

                            responseDataChart= response.getDATA().getDataChart();
                            axisData = responseDataChart;
                            yAxisData = responseDataChart;

                            for (int i = 0; i < axisData.size();i++) {
                                axisValues.add(i, new AxisValue(i).setLabel(String.valueOf(axisData.get(i).getDate())));
                            }

                            for (int i = 0; i < yAxisData.size();i++) {
                                yAxisValues.add(new PointValue(i, Integer.parseInt((yAxisData.get(i).getTotal_product().replace(".00", "")))));
                            }

                            List lines = new ArrayList();
                            lines.add(line);

                            LineChartData data1 = new LineChartData();
                            data1.setLines(lines);

                            Axis axis = new Axis();
                            axis.setValues(axisValues);
                            axis.setTextSize(16);
                            axis.setTextColor(Color.parseColor("#8D8D8D"));
                            data1.setAxisXBottom(axis);

                            Axis yAxis = new Axis();
                            yAxis.setTextColor(Color.parseColor("#8D8D8D"));
                            yAxis.setTextSize(16);
                            data1.setAxisYLeft(yAxis);

                            lineChartView.setLineChartData(data1);
//                            Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
//                            viewport.top = 110;
//                            lineChartView.setMaximumViewport(viewport);
//                            lineChartView.setCurrentViewport(viewport);

                        }else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetReportSelling> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getTextValue() {
        tvValuePendapatan.setText("Rp " + Utils.toCurrency(dataReportSelling.getDataTotal().getAm_omset().replace(".00", "")));
        tvValueLabaKotor.setText("Rp " + Utils.toCurrency(dataReportSelling.getDataTotal().getAm_gross().replace(".00", "")));
        tvPembayaran.setText("Rp " + Utils.toCurrency(dataReportSelling.getDataTotal().getAm_payment().replace(".00", "")));
        tvTotalTransaksi.setText(String.valueOf(dataReportSelling.getDataTotal().getAm_transaction()));
        tvTotalProduk.setText(dataReportSelling.getDataTotal().getAm_product().replace(".00", ""));
    }



    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void setDate(SetDate date) {
        if (date.getDate() != null)
            this.date = date.getDate();
//        this.outlet = date.getOutlet();
        getData();
    }



}
