package com.codelabs.konspirasisnack.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codelabs.konspirasisnack.EventBus.RefreshOrderByMeja;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.model.GetOrderByReservation;
import com.codelabs.konspirasisnack.model.GetTable;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MejaAdapter extends RecyclerView.Adapter<MejaAdapter.ViewHolder> {
    private List<GetTable.DATA.Meja> data;
    private Context mContext;

    public MejaAdapter(Context mContext) {
        this.mContext = mContext;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_meja, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GetTable.DATA.Meja meja = data.get(position);
        holder.tvNamaMeja.setText(meja.getTableName());
        if (meja.getIs_reserved() == 1) {
            holder.layMain.setBackgroundColor(mContext.getResources().getColor(R.color.green_dark));
            holder.tvNamaMeja.setTextColor(mContext.getResources().getColor(R.color.white));
//
        } else {
            holder.layMain.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            holder.tvNamaMeja.setTextColor(mContext.getResources().getColor(R.color.black));
        }
    }

    public void setData(List<GetTable.DATA.Meja> data) {
        this.data = data;
        notifyDataSetChanged();

    }

    public List<GetTable.DATA.Meja> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_meja)
        TextView tvNamaMeja;
        @BindView(R.id.lay_main)
        RelativeLayout layMain;

        private int transaction_id;
        private int reservationId;
        private GetOrderByReservation.DATAReservation detailReservationOrder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (data.get(getAdapterPosition()).getIs_reserved() == 0) {
                        EventBus.getDefault().post(data.get(getAdapterPosition()));
                    } else {
//                        EventBus.getDefault().post(data.get(getAdapterPosition()));
//                        Toast.makeText(mContext, "Meja sudah terisi" + "" + data.get(getAdapterPosition()).getReservationDetail().getRes_id(), Toast.LENGTH_SHORT).show();
                        reservationId = data.get(getAdapterPosition()).getReservationDetail().getRes_id();
                        getReservationDetail();
                    }

                }
            });
        }

        private void getReservationDetail() {
            RetrofitInterface apiService = ApiUtils.getAPIService();
            String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
            Call<GetOrderByReservation> call = apiService.getOrderByReservation(auth, reservationId);
            call.enqueue(new Callback<GetOrderByReservation>() {
                @Override
                public void onResponse(Call<GetOrderByReservation> call, Response<GetOrderByReservation> data) {
                    if (data.isSuccessful()) {
                        GetOrderByReservation response = data.body();
                        if (response != null) {
                            if (response.getSTATUS() == 200) {
                                EventBus.getDefault().post(new RefreshOrderByMeja());
                                detailReservationOrder = response.getDATAReservation();
                                transaction_id = detailReservationOrder.getTrans_id();
//                                getDetailOrder();
                                DataManager.getInstance().setTransId(transaction_id);
                            }else {
                                Toast.makeText(mContext, response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GetOrderByReservation> call, Throwable t) {
                        t.printStackTrace();
                }
            });
        }


    }

}
