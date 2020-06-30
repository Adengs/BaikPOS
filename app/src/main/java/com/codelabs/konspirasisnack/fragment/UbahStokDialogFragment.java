package com.codelabs.konspirasisnack.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.codelabs.konspirasisnack.EventBus.RefreshStock;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetStock;
import com.codelabs.konspirasisnack.model.GetStokType;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahStokDialogFragment extends DialogFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.txt_produk)
    TextView txtProduk;
    @BindView(R.id.txt_jenis)
    TextView txtJenis;
    @BindView(R.id.txt_satuan)
    TextView txtSatuan;
    @BindView(R.id.spin_stok)
    Spinner spinStok;
    @BindView(R.id.txt_jumlah)
    TextInputEditText txtJumlah;
    @BindView(R.id.tv_catatan)
    TextView tvCatatan;
    @BindView(R.id.txt_note)
    EditText txtNote;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private List<GetStokType.DATA> stockTypes;

    private GetStock.DATA data;
    public static UbahStokDialogFragment newInstance(GetStock.DATA data) {


        UbahStokDialogFragment fragment = new UbahStokDialogFragment();
        fragment.data = data;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.dialog_ubah_stok, null);
        ButterKnife.bind(this, v);
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);

        initView();
        initJenisStok();
        return v;
    }

    private void initView() {
        txtProduk.setText(data.getItemName());
        txtJenis.setText(data.getItemTypeTxt());
        txtSatuan.setText(data.getUnitName());
    }
    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    private void initJenisStok() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetStokType> call = apiService.getStockType(auth);
        call.enqueue(new Callback<GetStokType>() {
            @Override
            public void onResponse(Call<GetStokType> call, Response<GetStokType> data) {
                if (data.isSuccessful()) {
                    GetStokType response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initSpinnerStokType(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetStokType> call, Throwable t) {
                Utils.showToast(getActivity(), t.getMessage());
                t.printStackTrace();

            }
        });

    }

    private void initSpinnerStokType(GetStokType response) {
        stockTypes = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetStokType.DATA cat : stockTypes)
            sCategory.add(cat.getType());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinStok.setAdapter(adapterUnit);
    }

    @OnClick(R.id.btn_submit)
    public void onSubmitClicked() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Map<String, String> param = new HashMap<>();
        param.put("product_id", data.getItemId()+"");
        param.put("stock", txtJumlah.getText().toString().trim());
        param.put("info", txtNote.getText().toString().trim());
        param.put("type", stockTypes.get(spinStok.getSelectedItemPosition()).getId()+"");
        param.put("stock_akhir", data.getStockAkhir());

        Call<DoPost> call = apiService.updateStock(auth, param);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(new RefreshStock());
                            dismiss();
                        }else{
                            Utils.showToast(getContext(), response.getMESSAGE());

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<DoPost> call, Throwable t) {
                Utils.showToast(getContext(), t.getMessage());
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                t.printStackTrace();

            }
        });
    }

    private boolean valid() {
        if (stockTypes == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_produk), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(txtJumlah.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_jumlah_produk), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
