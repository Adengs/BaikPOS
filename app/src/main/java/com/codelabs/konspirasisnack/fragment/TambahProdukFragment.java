package com.codelabs.konspirasisnack.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.AddProduct;
import com.codelabs.konspirasisnack.model.GetProductCategory;
import com.codelabs.konspirasisnack.model.GetUnits;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;

public class TambahProdukFragment extends DialogFragment {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.iv_produk)
    ImageView ivProduk;
    @BindView(R.id.txt_nama_produk)
    TextInputEditText txtNamaProduk;
    @BindView(R.id.spin_kategori)
    Spinner spinKategori;
    @BindView(R.id.txt_harga_modal)
    TextInputEditText txtHargaModal;
    @BindView(R.id.spin_unit)
    Spinner spinUnit;
    @BindView(R.id.txt_stok)
    TextInputEditText txtStok;
    @BindView(R.id.txt_harga_jual)
    TextInputEditText txtHargaJual;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.btn_select_image)
    LinearLayout btnSelectImage;
    private Unbinder unbinder;
    List<GetProductCategory.DATA> categoryList;
    private List<GetUnits.DATAUnits> unitList;
    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private FilePickUtils filePickUtils;
    MultipartBody.Part imageFile = null;
    File imageFoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_tambah_produk, container, false);
        unbinder = ButterKnife.bind(this, view);
        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getCategory();
        getUnit();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    private void getUnit() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetUnits> call = apiService.getUnits(auth);
        call.enqueue(new Callback<GetUnits>() {
            @Override
            public void onResponse(Call<GetUnits> call, Response<GetUnits> data) {
                if (data.isSuccessful()) {
                    GetUnits response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initAdapterUnits(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }


            }


            @Override
            public void onFailure(Call<GetUnits> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void initAdapterUnits(GetUnits response) {
        unitList = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetUnits.DATAUnits cat : unitList)
            sCategory.add(cat.getUnit_name());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinUnit.setAdapter(adapterUnit);
    }

    private void getCategory() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetProductCategory> call = apiService.getProductCategory(auth, "");
        call.enqueue(new Callback<GetProductCategory>() {
            @Override
            public void onResponse(Call<GetProductCategory> call, Response<GetProductCategory> data) {

                if (data.isSuccessful()) {
                    GetProductCategory response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initAdapterCategory(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }


            }



            @Override
            public void onFailure(Call<GetProductCategory> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void initAdapterCategory(GetProductCategory response) {
        categoryList = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetProductCategory.DATA cat : categoryList)
            sCategory.add(cat.getItemCatName());
        ArrayAdapter adapterCategory = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinKategori.setAdapter(adapterCategory);
    }
    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }

    @OnClick(R.id.btn_select_image)
    public void onClickSelectImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Mohon pilih gambar");
        builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                filePickUtils.requestImageCamera(CAMERA_PERMISSION, true, true, true);

            }
        });
        builder.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                filePickUtils.requestImageGallery(STORAGE_PERMISSION_IMAGE, true, true, true);
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (lifeCycleCallBackManager != null) {
                lifeCycleCallBackManager.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    private FilePickUtils.OnFileChoose onFileChoose = new FilePickUtils.OnFileChoose() {
        @Override
        public void onFileChoose(String fileUri, int requestCode) {

            imageFoto = new File(fileUri);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),imageFoto);
            imageFile = MultipartBody.Part.createFormData("product_image", imageFoto.getName(), requestFile);

            Picasso.get()
                    .load(imageFoto)
                    .resize(RecentUtils.ConvertDpToPx(getActivity(), 20)
                            , RecentUtils.ConvertDpToPx(getActivity(), 20)).into(ivProduk);

            Bitmap bitmap = BitmapFactory.decodeFile(imageFoto.getPath());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
//            byte[] byteArray = byteArrayOutputStream.toByteArray();
//            selectedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
    };


    @OnClick(R.id.btn_submit)
    public void onSubmitClicked() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Map<String, RequestBody> param = new HashMap<>();
        param.put("product_name", AppConstant.createRequestBody(txtNamaProduk.getText().toString().trim()));
        param.put("category_id", AppConstant.createRequestBody(categoryList.get(spinKategori.getSelectedItemPosition()).getItemCatId() + ""));
        param.put("unit_id", AppConstant.createRequestBody(unitList.get(spinUnit.getSelectedItemPosition()).getUnit_id() + ""));
        param.put("harga_modal", AppConstant.createRequestBody(txtHargaModal.getText().toString().trim()));
        param.put("harga_jual", AppConstant.createRequestBody(txtHargaJual.getText().toString().trim()));
        param.put("stock", AppConstant.createRequestBody(txtStok.getText().toString().trim()));

        imageFoto = new File(imageFoto.getPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),imageFoto);
        MultipartBody.Part body = MultipartBody.Part.createFormData("product_image", imageFoto.getName(), requestFile);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<AddProduct> call = apiService.addProduct(auth, param, body);
        call.enqueue(new Callback<AddProduct>() {
            @Override
            public void onResponse(Call<AddProduct> call, Response<AddProduct> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    AddProduct response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(response.getDATA());
                            dismiss();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<AddProduct> call, Throwable t) {
                Utils.showToast(getContext(), t.getMessage());
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                t.printStackTrace();
            }
        });
    }


    private boolean valid() {
        if (TextUtils.isEmpty(txtNamaProduk.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_nama_produk), Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (TextUtils.isEmpty(selectedImage)) {
//            Toast.makeText(getActivity(), getString(R.string.message_dialog_foto_produk), Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (categoryList == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_kategori_produk), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (unitList == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_unit_produk), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(txtStok.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_stok_produk), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(txtHargaModal.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_modal_produk), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtHargaJual.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_jual_produk), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
