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
import com.codelabs.konspirasisnack.model.GetProducts;
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

public class TambahStockDialogFragment extends DialogFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.spin_produk)
    Spinner spinProduk;
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
    private List<GetProducts.DATABean> products;
    private Call<GetProducts> callGetProduct;
    private Call<DoPost> callTambahStock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.dialog_tambah_stock, null);
        ButterKnife.bind(this, v);
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);

        getProduct();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

    private void getProduct() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Map<String, String> params = new HashMap<>();
        callGetProduct = apiService.getProduct(auth, params);
        callGetProduct.enqueue(new Callback<GetProducts>() {
            @Override
            public void onResponse(Call<GetProducts> call, Response<GetProducts> data) {
                if (data.isSuccessful()) {
                    GetProducts response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initSpinnerProduct(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetProducts> call, Throwable t) {
                Utils.showToast(getActivity(), t.getMessage());
                t.printStackTrace();
            }
        });

    }

    private void initSpinnerProduct(GetProducts response) {
        products = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetProducts.DATABean cat : products)
            sCategory.add(cat.getItemName());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinProduk.setAdapter(adapterUnit);

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
        param.put("product_id", products.get(spinProduk.getSelectedItemPosition()).getItemId() + "");
        param.put("stock", txtJumlah.getText().toString().trim());
        param.put("info", txtNote.getText().toString().trim());

        callTambahStock = apiService.addStock(auth, param);
        callTambahStock.enqueue(new Callback<DoPost>() {
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
                        } else {
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
        if (products == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_tipe_stok), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(txtJumlah.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_jumlah_produk), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (callGetProduct != null)
            callGetProduct.cancel();
        if (callTambahStock != null)
            callTambahStock.cancel();
    }
}
