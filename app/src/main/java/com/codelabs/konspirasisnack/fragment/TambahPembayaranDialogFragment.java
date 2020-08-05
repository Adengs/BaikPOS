package com.codelabs.konspirasisnack.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
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

import com.codelabs.konspirasisnack.EventBus.RefreshPaymentMethod;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetPaymentMethodType;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;

public class TambahPembayaranDialogFragment extends DialogFragment {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.iv_produk)
    ImageView ivProduk;
    @BindView(R.id.btn_select_image)
    LinearLayout btnSelectImage;
    @BindView(R.id.txt_nama_pembayaran)
    TextInputEditText txtNamaPembayaran;
    @BindView(R.id.spin_jenis)
    Spinner spinJenis;
    @BindView(R.id.txt_provider)
    TextInputEditText txtProvider;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private FilePickUtils filePickUtils;
    private String selectedImage = "";
    private List<GetPaymentMethodType.DATA> paymentMethodType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.dialog_tambah_pembayaran, null);
        ButterKnife.bind(this, v);
        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();

        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);

        getPaymentMethodType();
        return v;
    }

    private void getPaymentMethodType() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<GetPaymentMethodType> call = apiService.getPaymentMethodType(auth);
        call.enqueue(new Callback<GetPaymentMethodType>() {
            @Override
            public void onResponse(Call<GetPaymentMethodType> call, Response<GetPaymentMethodType> data) {
                if (data.isSuccessful()) {
                    GetPaymentMethodType response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initSpinnerPaymentMethodType(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetPaymentMethodType> call, Throwable t) {
                Utils.showToast(getContext(), t.getMessage());
                t.printStackTrace();
            }
        });

    }

    private void initSpinnerPaymentMethodType(GetPaymentMethodType response) {
        paymentMethodType = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetPaymentMethodType.DATA cat : paymentMethodType)
            sCategory.add(cat.getPmTypeName());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinJenis.setAdapter(adapterUnit);
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
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();

        Map<String, String> param = new HashMap<>();
        param.put("name", txtNamaPembayaran.getText().toString().trim());
        param.put("type", paymentMethodType.get(spinJenis.getSelectedItemPosition()).getPmTypeId() + "");
        param.put("provider", txtProvider.getText().toString().trim());
        param.put("image", "data:image/jpeg;base64," + selectedImage);
        Call<DoPost> call = apiService.addPaymentMethod(auth, param);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(new RefreshPaymentMethod());
                            dismiss();
                        }else{
                            Utils.showToast(getContext(),data.message());
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
        if (TextUtils.isEmpty(selectedImage)) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_foto_pembayaran), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNamaPembayaran.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_nama_pembayaran), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (paymentMethodType == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_type), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtProvider.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_provider), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
