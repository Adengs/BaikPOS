package com.codelabs.konspirasisnack.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.text.TextUtils;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.codelabs.konspirasisnack.EventBus.RefreshKasKasir;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;

public class TambahKasFragment extends DialogFragment {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.txt_nama_transaksi)
    TextInputEditText tvNamaTransaksi;
    @BindView(R.id.txt_nominal)
    TextInputEditText tvNominal;
    @BindView(R.id.txt_catatan)
    TextInputEditText tvCatatan;
    @BindView(R.id.btn_select_image)
    LinearLayout btnSelectImage;
    @BindView(R.id.iv_produk)
    ImageView ivProduk;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.radio_grup)
    RadioGroup radioGroup;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;

    private String typeKas;
    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private FilePickUtils filePickUtils;
    private String selectedImage = "";
    private int cashierId;
    private int cashierUserId;
    private Unbinder unbinder;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_kas, container, false);
        unbinder = ButterKnife.bind(this,view);
        cashierId = DataManager.getInstance().getCashierId();
        cashierUserId = DataManager.getInstance().getCashierUserId();
        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb1.isChecked()) {
                    typeKas = "in";
//                    typeKas = rb1.getText().toString();

                }else {
                    typeKas = "out";
//                    typeKas = rb2.getText().toString();
                }

            }
        });


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
            File image = new File(fileUri);

            Picasso.get()
                    .load(image)
                    .resize(RecentUtils.ConvertDpToPx(getActivity(), 100)
                            , RecentUtils.ConvertDpToPx(getActivity(), 100)).into(ivProduk);

            Bitmap bitmap = BitmapFactory.decodeFile(image.getPath());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            selectedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
    };


    @OnClick(R.id.btn_submit)
    public void onSubmitClicked() {
        if (!valid())
            return;
        Utils.changeVisibility(pbLoading);
        Utils.changeVisibility(btnSubmit);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken_cashier();
        Map<String, String> param = new HashMap<>();
        param.put("cashier_id", String.valueOf(cashierId));
        param.put("user_id", String.valueOf(cashierUserId));
        param.put("info", tvCatatan.getText().toString().trim());
        param.put("amount", tvNominal.getText().toString().trim());
        param.put("name", tvNamaTransaksi.getText().toString().trim());
        param.put("type", typeKas);
        Call<DoPost> call = apiService.doAddTransaksiKas(auth, param);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(new RefreshKasKasir());
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            dismiss();
                        }else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<DoPost> call, Throwable t) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                t.printStackTrace();
            }
        });
    }

    private boolean valid() {
        if (TextUtils.isEmpty(tvNamaTransaksi.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Tuliskan nama transaksi", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(tvNominal.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Tuliskan jumlah nominal", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(tvCatatan.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Tuliskan catatan", Toast.LENGTH_SHORT).show();
            return false;
        }

//        if (TextUtils.isEmpty(selectedImage)) {
//            Toast.makeText(getActivity(), "Masukkan foto bukti", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }


    @OnClick(R.id.btn_close)
    public void onViewClicked() {
        dismiss();
    }


}
