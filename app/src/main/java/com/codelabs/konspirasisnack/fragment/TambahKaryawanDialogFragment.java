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

import com.codelabs.konspirasisnack.EventBus.RefreshKaryawan;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetEmployeePosition;
import com.codelabs.konspirasisnack.model.GetOutlet;
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

public class TambahKaryawanDialogFragment extends DialogFragment {

    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.iv_produk)
    ImageView ivProduk;
    @BindView(R.id.btn_select_image)
    LinearLayout btnSelectImage;
    @BindView(R.id.txt_nama)
    TextInputEditText txtNama;
    @BindView(R.id.txt_email)
    TextInputEditText txtEmail;
    @BindView(R.id.txt_nohp)
    TextInputEditText txtNohp;
    @BindView(R.id.spin_posisi)
    Spinner spinPosisi;
    @BindView(R.id.spin_outlet)
    Spinner spinOutlet;
    @BindView(R.id.txt_pin)
    TextInputEditText txtPin;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private FilePickUtils filePickUtils;
    private String selectedImage = "";
    private List<GetEmployeePosition.DATA> employeePosition;
    private List<GetOutlet.DATA> listOutlet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.dialog_tambah_karyawan, null);
        ButterKnife.bind(this, v);

        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();

        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);

        getEmployeePosition();
        getOutletList();
        return v;
    }

    private void getOutletList() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Call<GetOutlet> call = apiService.getOutlet(auth);
        call.enqueue(new Callback<GetOutlet>() {
            @Override
            public void onResponse(Call<GetOutlet> call, Response<GetOutlet> data) {
                if (data.isSuccessful()) {
                    GetOutlet response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initSpinnerOutlet(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetOutlet> call, Throwable t) {
                Utils.showToast(getContext(), t.getMessage());
                t.printStackTrace();

            }
        });

    }

    private void initSpinnerOutlet(GetOutlet response) {
        listOutlet = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetOutlet.DATA cat : listOutlet)
            sCategory.add(cat.getOtName());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinOutlet.setAdapter(adapterUnit);

    }

    private void getEmployeePosition() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Call<GetEmployeePosition> call = apiService.getEmployeePosition(auth);
        call.enqueue(new Callback<GetEmployeePosition>() {
            @Override
            public void onResponse(Call<GetEmployeePosition> call, Response<GetEmployeePosition> data) {
                if (data.isSuccessful()) {
                    GetEmployeePosition response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initSpinnerEmployeePosition(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetEmployeePosition> call, Throwable t) {
                Utils.showToast(getContext(), t.getMessage());
                t.printStackTrace();
            }
        });

    }

    private void initSpinnerEmployeePosition(GetEmployeePosition response) {
        employeePosition = response.getDATA();
        List<String> sCategory = new ArrayList<>();
        for (GetEmployeePosition.DATA cat : employeePosition)
            sCategory.add(cat.getPosition());
        ArrayAdapter adapterUnit = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, sCategory){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                v.setPadding(0, v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());

                return v;
            }
        };
        spinPosisi.setAdapter(adapterUnit);

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
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Map<String, String> param = new HashMap<>();
        param.put("u_firstname", txtNama.getText().toString().trim());
        param.put("u_type", employeePosition.get(spinPosisi.getSelectedItemPosition()).getId());
        param.put("u_email", txtEmail.getText().toString().trim());
        param.put("u_pin", txtPin.getText().toString().trim());
        param.put("u_image", "data:image/jpeg;base64," + selectedImage);
        param.put("u_mobile_no", txtNohp.getText().toString().trim());
        param.put("u_outlet_id", listOutlet.get(spinOutlet.getSelectedItemPosition()).getOtId() + "");
        Call<DoPost> call = apiService.addEmployee(auth, param);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                Utils.changeVisibility(pbLoading);
                Utils.changeVisibility(btnSubmit);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            EventBus.getDefault().post(new RefreshKaryawan());
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

    private boolean  valid() {
        if (TextUtils.isEmpty(selectedImage)) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_foto_karyawan), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNama.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_nama_karyawan), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtEmail.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_email_karyawan), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNohp.getText().toString().trim())) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_nohp_karyawan), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (employeePosition == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_posisi), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (listOutlet == null) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_outlet), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtPin.getText().toString().trim()) || txtPin.getText().toString().trim().length() != 6) {
            Toast.makeText(getActivity(), getString(R.string.message_dialog_PIN_karyawan), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
