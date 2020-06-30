package com.codelabs.konspirasisnack.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshMeja;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.fragment.DetailPesananDialogFragment;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetOrderListData;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPesananAdapter extends RecyclerView.Adapter<DaftarPesananAdapter.ViewHolder> {
    private List<GetOrderListData.DATA> data;
    private Context mContext;


    public DaftarPesananAdapter(Context mContext) {
        this.mContext = mContext;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_daftar_pesanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSelesai.setVisibility(View.GONE);
        holder.tvProses.setVisibility(View.GONE);
        holder.tvReservasi.setVisibility(View.GONE);
        holder.tvNewOrder.setVisibility(View.GONE);
        holder.tvReadyPickup.setVisibility(View.GONE);
        holder.tvPreparing.setVisibility(View.GONE);
        holder.tvReject.setVisibility(View.GONE);

        GetOrderListData.DATA data = this.data.get(position);
        holder.tvNoNota.setText(data.getTransCode());
//        holder.tvPelanggan.setText(data.getCustomer().getCustId() == 0 ? mContext.getString(R.string.tanpa_pelanggan) : data.getCustomer().getCustFullname());
        holder.tvPelanggan.setText(data.getTransCustomerName());
        holder.tvTanggal.setText(DateUtils.changeDateFormat(data.getTransDate(), DateUtils.WEB_DATE_TIME_FORMAT, DateUtils.DATE_FORMAT_MONTH_TIME_STANDARD2));
        holder.tvTotal.setText(Utils.toCurrency(data.getTransTotal().replace(".00", "")));
        if (data.getStatusTxt().equalsIgnoreCase("Selesai"))
            holder.tvSelesai.setVisibility(View.VISIBLE);
        if (data.getStatusTxt().equalsIgnoreCase("Proses"))
            holder.tvProses.setVisibility(View.VISIBLE);
        if (data.isFromWeb()){
            if (data.getStatusTxt().equalsIgnoreCase("Reservasi"))
                holder.tvReservasi.setVisibility(View.VISIBLE);
            if (data.getTransStatus() == 3 && data.getTransShippingStatus() == 1)
                holder.tvNewOrder.setVisibility(View.VISIBLE);
            if (data.getTransStatus() == 3 && data.getTransShippingStatus() == 2)
                holder.tvPreparing.setVisibility(View.VISIBLE);
            if (data.getTransStatus() == 4 && data.getTransShippingStatus() == 5)
                holder.tvReject.setVisibility(View.VISIBLE);
            if (data.getTransStatus() == 3 && data.getTransShippingStatus() == 3)
                holder.tvReadyPickup.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<GetOrderListData.DATA> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_no_nota)
        TextView tvNoNota;
        @BindView(R.id.tv_pelanggan)
        TextView tvPelanggan;
        @BindView(R.id.tv_tanggal)
        TextView tvTanggal;
        @BindView(R.id.tv_proses)
        TextView tvProses;
        @BindView(R.id.tv_selesai)
        TextView tvSelesai;
        @BindView(R.id.tv_reservasi)
        TextView tvReservasi;
        @BindView(R.id.txt_total)
        TextView tvTotal;
        @BindView(R.id.tv_new_order)
        TextView tvNewOrder;
        @BindView(R.id.tv_preparing)
        TextView tvPreparing;
        @BindView(R.id.tv_reject)
        TextView tvReject;
        @BindView(R.id.tv_ready_pickup)
        TextView tvReadyPickup;

        private int transaction_id;
        private GetOrderDetail.DATA detailTransaction;
        private List<GetOrderDetail.DATA.TransactionItems> detailItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    if (data.get(getAdapterPosition()).getStatusTxt().equals("Proses")){
//                        Intent returntIntent = new Intent();
//                        returntIntent.putExtra(AppConstant.TRANSACTION_ID, data.get(getAdapterPosition()).getTransId());
//                        ((Activity)mContext).setResult(Activity.RESULT_OK, returntIntent);
//                        ((Activity)mContext).finish();
//                    }


//                    if (data.get(getAdapterPosition()).getStatusTxt().equals("Proses")){
//                        Intent intent = new Intent(mContext, PembayaranActivity.class);
//                        intent.putExtra(AppConstant.TRANSACTION_ID, data.get(getAdapterPosition()).getTransId());
//                        mContext.startActivity(intent);

                    if (data.get(getAdapterPosition()).getStatusTxt().equals("Proses")) {
                        transaction_id = data.get(getAdapterPosition()).getTransId();
                        getDetailOrder();
//                        Toast.makeText(mContext, data.get(getAdapterPosition()).getTransCode(), Toast.LENGTH_LONG).show();
                    } else if (data.get(getAdapterPosition()).isFromWeb()) {
                        transaction_id = data.get(getAdapterPosition()).getTransId();
                        DetailPesananDialogFragment dialog = DetailPesananDialogFragment.newInstance(transaction_id);
                        dialog.show(((FragmentActivity) mContext).getSupportFragmentManager(), "");

                    }
                }
            });
        }

        private void getDetailOrder() {
            RetrofitInterface apiService = ApiUtils.getAPIService();
            String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
            Call<GetOrderDetail> call = apiService.getOrderDetail(auth, transaction_id);
            call.enqueue(new Callback<GetOrderDetail>() {
                @Override
                public void onResponse(Call<GetOrderDetail> call, Response<GetOrderDetail> data) {
                    if (data.isSuccessful()) {
                        GetOrderDetail response = data.body();
                        if (response != null) {
                            if (response.getSTATUS() == 200) {
                                detailTransaction = response.getDATA();
                                Intent returnIntent = new Intent();
                                EventBus.getDefault().post(new RefreshMeja());
//                                returnIntent.putExtra("order",new Gson().toJson(detailTransaction));
                                returnIntent.putExtra(AppConstant.ORDER_DETAIL, new Gson().toJson(detailTransaction));
                                ((Activity) mContext).setResult(Activity.RESULT_OK, returnIntent);
                                ((Activity) mContext).finish();


                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GetOrderDetail> call, Throwable t) {
                    t.printStackTrace();

                }
            });

        }
    }

}
