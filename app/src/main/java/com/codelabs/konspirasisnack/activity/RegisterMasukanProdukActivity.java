package com.codelabs.konspirasisnack.activity;

import androidx.annotation.NonNull;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import com.codelabs.konspirasisnack.adapter.SpinnerUnitsAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetUnits;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterMasukanProdukActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ed_nama_produk)
    TextInputEditText edNamaProduk;
    @BindView(R.id.spinner_satuan)
    Spinner spinnerSatuan;
    @BindView(R.id.ed_kategori_produk)
    TextInputEditText edKategoriProduk;
    @BindView(R.id.ed_stok)
    TextInputEditText edStok;
    @BindView(R.id.ed_harga_modal)
    TextInputEditText edHargaModal;
    @BindView(R.id.ed_harga_jual)
    TextInputEditText edHargaJual;
    @BindView(R.id.btn_lanjut)
    Button btnLanjut;
    @BindView(R.id.img_add_product)
    ImageView imgAddProduct;


    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private FilePickUtils filePickUtils;
    private SpinnerUnitsAdapter mAdapterUnits;
    private List<GetUnits.DATAUnits> responseUnits = new ArrayList<>();
    private int unitId;
    private int selectedIdUser;
    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private String selectedImage;
    MultipartBody.Part imageFile = null;
    File imageFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_masukan_produk);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());

        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();


        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();
    }




    private FilePickUtils.OnFileChoose onFileChoose = new FilePickUtils.OnFileChoose() {
        @Override
        public void onFileChoose(String fileUri, int requestCode) {

            imageFoto = new File(fileUri);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFoto);
            imageFile = MultipartBody.Part.createFormData("product_image", imageFoto.getName(), requestFile);

            Picasso.get()
                    .load(imageFoto)
                    .resize(RecentUtils.ConvertDpToPx(RegisterMasukanProdukActivity.this, 20)
                        ,RecentUtils.ConvertDpToPx(RegisterMasukanProdukActivity.this, 20)).into(imgAddProduct);

            Bitmap bitmap = BitmapFactory.decodeFile(imageFoto.getPath());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,20, byteArrayOutputStream);
//            byte[] byteArray = byteArrayOutputStream.toByteArray();
//            selectedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
    };

    public void openAddImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mohon pilih gambar");
        builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                filePickUtils.requestImageCamera(CAMERA_PERMISSION, true, true, true );

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED){
            if (lifeCycleCallBackManager != null) {
                lifeCycleCallBackManager.onActivityResult(requestCode, resultCode, data);
            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (lifeCycleCallBackManager != null) {
            lifeCycleCallBackManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void initView() {
        mAdapterUnits = new SpinnerUnitsAdapter(this, responseUnits);
        spinnerSatuan.setAdapter(mAdapterUnits);

        Picasso.get().load(selectedImage)
                .placeholder(R.drawable.ic_menu_camera)
                .placeholder(R.drawable.ic_menu_camera)
                .into(imgAddProduct);


    }

    private void initVar() {
        selectedIdUser = DataManager.getInstance().getU_id_reg();


    }

    private void initEvent() {
        btnLanjut.setOnClickListener(this);
        imgAddProduct.setOnClickListener(this);

        spinnerSatuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    GetUnits.DATAUnits item = mAdapterUnits.getItem(position);
                    unitId = item.getUnit_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initSetup() {

    }

    private void fetchData() {
        loadDataUnits();

    }


    private void loadDataUnits() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetUnits> call = apiService.getUnits(auth);
        call.enqueue(new Callback<GetUnits>() {
            @Override
            public void onResponse(@NonNull Call<GetUnits> call, @NonNull Response<GetUnits> data) {
                if (data.isSuccessful()) {
                    GetUnits response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseUnits = response.getDATA();
                            mAdapterUnits.clear();
                            mAdapterUnits.addAll(data.body().getDATA());
                            mAdapterUnits.notifyDataSetChanged();
                        }else {
                            showToast(response.getMESSAGE());
                        }
                    }else {
                        showToast("Response data kosong");
                    }
                }else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetUnits> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }

    private void doSignUpProduk() {
        String namaProduk = edNamaProduk.getText().toString();
        String kategoriProduk = edKategoriProduk.getText().toString();
        String stok = edStok.getText().toString();
        String hargaModal = edHargaModal.getText().toString();
        String hargaJual = edHargaJual.getText().toString();



        if (TextUtils.isEmpty(namaProduk)) {
            showToast("Mohon masukkan nama produk");
            return;
        }

        if (TextUtils.isEmpty(kategoriProduk)) {
            showToast("Mohon masukkan kategori produk");
            return;
        }

        if (TextUtils.isEmpty(stok)) {
            showToast("Mohon masukkan jumlah stok");
            return;
        }

        if (TextUtils.isEmpty(hargaModal)) {
            showToast("Mohon masukkan harga modal");
            return;
        }

        if (TextUtils.isEmpty(hargaJual)) {
            showToast("Mohon masukkan harga jual");
            return;
        }


        Map<String, RequestBody> params = new HashMap<>();
        params.put("user_id", AppConstant.createRequestBody(String.valueOf(selectedIdUser)));
        params.put("product_name", AppConstant.createRequestBody(namaProduk));
        params.put("unit_id", AppConstant.createRequestBody(String.valueOf(unitId)));
        params.put("category_name", AppConstant.createRequestBody(kategoriProduk));
        params.put("harga_modal", AppConstant.createRequestBody(hargaModal));
        params.put("harga_jual", AppConstant.createRequestBody(hargaJual));
        params.put("stock", AppConstant.createRequestBody(stok));

        imageFoto = new File(imageFoto.getPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"),imageFoto);
        MultipartBody.Part body = MultipartBody.Part.createFormData("product_image", imageFoto.getName(), requestFile);

        showDialogProgress("Proses data register");

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenClient();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<DoPost> call = apiService.doRegisterProduct(auth, params, body);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            showToast(response.getMESSAGE());
                            Intent intent = new Intent(RegisterMasukanProdukActivity.this, SignInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }else {
                            showToast(response.getMESSAGE());
                        }
                    }else {
                        showToast("Response data kosong");
                    }
                }else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                if (!call.isCanceled()){
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == btnLanjut) {
            doSignUpProduk();
        }

        if (view == imgAddProduct){
            openAddImage();
        }

    }
}
