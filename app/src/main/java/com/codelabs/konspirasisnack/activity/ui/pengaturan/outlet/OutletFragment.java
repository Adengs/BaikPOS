package com.codelabs.konspirasisnack.activity.ui.pengaturan.outlet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.SpinnerKecamatanAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerKotaAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerProvinsiAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.Utils;
import com.codelabs.konspirasisnack.imagepicker.FilePickUtils;
import com.codelabs.konspirasisnack.imagepicker.LifeCycleCallBackManager;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetCities;
import com.codelabs.konspirasisnack.model.GetKecamatan;
import com.codelabs.konspirasisnack.model.GetLogin;
import com.codelabs.konspirasisnack.model.GetProfil;
import com.codelabs.konspirasisnack.model.GetProvince;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;

public class OutletFragment extends Fragment {


    @BindView(R.id.btn_edit)
    Button btnEdit;
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.txt_profil_usaha)
    EditText txtProfilUsaha;
    @BindView(R.id.txt_nama_outlet)
    EditText txtNamaOutlet;
    @BindView(R.id.txt_alamat)
    EditText txtAlamat;
    @BindView(R.id.txt_kota)
    Spinner txtKota;
    @BindView(R.id.txt_email)
    EditText txtEmail;
    @BindView(R.id.txt_provinsi)
    Spinner txtProvinsi;
    @BindView(R.id.txt_nohp)
    EditText txtNohp;
    @BindView(R.id.txt_negara)
    EditText txtNegara;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.rl_progress)
    RelativeLayout rlProgress;
    @BindView(R.id.rl_main)
    ScrollView rlMain;
    @BindView(R.id.txt_kecamatan)
    Spinner txtKecamatan;
    @BindView(R.id.txtPostalCode)
    EditText txtPostalCode;
    private String provinceId;
    private String citiesId;
    private static final int CAMERA_PERMISSION = 11;
    private static final int STORAGE_PERMISSION_IMAGE = 22;
    private FilePickUtils filePickUtils;
    private String selectedImage = "";
    private LifeCycleCallBackManager lifeCycleCallBackManager;
    private int kecamatanId;
    private File imageFoto;

    public OutletFragment() {
        // Required empty public constructor
    }

    public static OutletFragment newInstance() {
        OutletFragment fragment = new OutletFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_outlet, container, false);
        ButterKnife.bind(this, v);
//        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        filePickUtils = new FilePickUtils(this, onFileChoose);
        lifeCycleCallBackManager = filePickUtils.getCallBackManager();
        getData();
        return v;
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
                            , RecentUtils.ConvertDpToPx(getActivity(), 100)).into(ivPic);

            Bitmap bitmap = BitmapFactory.decodeFile(image.getPath());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 70, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            selectedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
            imageFoto = new File(fileUri);
        }
    };

    private void getData() {
        rlMain.setVisibility(View.GONE);
        rlProgress.setVisibility(View.VISIBLE);
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();

        Call<GetProfil> call = apiService.getProfil(auth);
        call.enqueue(new Callback<GetProfil>() {
            @Override
            public void onResponse(Call<GetProfil> call, Response<GetProfil> data) {
                Utils.changeVisibility(rlMain);
                Utils.changeVisibility(rlProgress);
                if (data.isSuccessful()) {
                    GetProfil response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initView(response.getDATA());
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                } else {
                }

            }

            @Override
            public void onFailure(Call<GetProfil> call, Throwable t) {
                Utils.changeVisibility(rlMain);
                Utils.changeVisibility(rlProgress);
                t.printStackTrace();
            }
        });

    }

    private void initView(GetLogin.UserData data) {
        txtProfilUsaha.setText(data.getMerchant().getMc_name());
        txtAlamat.setText(data.getOutlet().getOt_address());
        txtNamaOutlet.setText(data.getOutlet().getOt_name());
//        txtKota.setText(data.getOutlet().getCity().getRegencyName());
//        txtProvinsi.setText(data.getOutlet().getProvince().getProvinceName());
        txtNegara.setText(data.getOutlet().getCountry().getCountryName());
        txtNohp.setText(data.getOutlet().getOt_phone_no());
        txtEmail.setText(data.getOutlet().getOt_email());
        txtPostalCode.setText(data.getOutlet().getOutlet_zip_code());
        if (!data.getOutlet().getOt_image_url().equals(""))
            Picasso.get().load(data.getOutlet().getOt_image_url()).into(ivPic);

        provinceId = data.getOutlet().getProvince().getProvinceId();
        citiesId = data.getOutlet().getCity().getRegencyId();
        kecamatanId = data.getOutlet().getOutlet_kecamatan_id();
        initDataCities();
        initDataProvinsi();
        iniDataKecamatan();
    }

    private void iniDataKecamatan() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetKecamatan> call = apiService.getKecamatan(auth, citiesId);
        call.enqueue(new Callback<GetKecamatan>() {
            @Override
            public void onResponse(Call<GetKecamatan> call, Response<GetKecamatan> data) {
                if (data.isSuccessful()) {
                    GetKecamatan response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initKecamatan(response.getDATA());

                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getActivity(), "Response data kosong", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(Call<GetKecamatan> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void initKecamatan(List<GetKecamatan.DATA> data) {
        SpinnerKecamatanAdapter mAdapterProv = new SpinnerKecamatanAdapter(getActivity(), data);
        txtKecamatan.setAdapter(mAdapterProv);

        int selection = 0;
        for (GetKecamatan.DATA cities : data) {
            if (cities.getSubdistrictId() == kecamatanId)
                txtKecamatan.setSelection(selection);
            selection++;

        }

        txtKecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetKecamatan.DATA item = mAdapterProv.getItem(position);
                kecamatanId = item.getSubdistrictId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initDataProvinsi() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetProvince> call = apiService.getProvince(auth);
        call.enqueue(new Callback<GetProvince>() {
            @Override
            public void onResponse(Call<GetProvince> call, Response<GetProvince> data) {
                if (data.isSuccessful()) {
                    GetProvince response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initProvinsi(response.getDATA());

                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getActivity(), "Response data kosong", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }

            }

            @Override
            public void onFailure(Call<GetProvince> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initProvinsi(List<GetProvince.DATAProvince> data) {
        SpinnerProvinsiAdapter mAdapterProv = new SpinnerProvinsiAdapter(getActivity(), data);
        txtProvinsi.setAdapter(mAdapterProv);

        int selection = 0;
        for (GetProvince.DATAProvince cities : data) {
            if (cities.getProvince_id().equals(provinceId))
                txtProvinsi.setSelection(selection);
            selection++;

        }

        txtProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetProvince.DATAProvince item = mAdapterProv.getItem(position);
                provinceId = item.getProvince_id();
                initDataCities();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initDataCities() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Map<String, String> param = new HashMap<>();
        param.put("province_id", provinceId + "");

        Call<GetCities> call = apiService.getCities(param);
        call.enqueue(new Callback<GetCities>() {
            @Override
            public void onResponse(Call<GetCities> call, Response<GetCities> data) {
                if (data.isSuccessful()) {
                    GetCities response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            initCities(response);
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getActivity(), "Response data kosong", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(Call<GetCities> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initCities(GetCities response) {
        SpinnerKotaAdapter mAdapterCities = new SpinnerKotaAdapter(getContext(), response.getDATA());
        txtKota.setAdapter(mAdapterCities);

        int selection = 0;
        for (GetCities.DATACities cities : response.getDATA()) {
            if (cities.getRegency_id().equals(citiesId))
                txtKota.setSelection(selection);
            selection++;

        }


        txtKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetCities.DATACities item = mAdapterCities.getItem(position);
                citiesId = item.getRegency_id();
                iniDataKecamatan();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.btn_edit)
    public void onClickBtnEdit() {
        if (!validEditOutlet())
            return;
        rlMain.setVisibility(View.GONE);
        rlProgress.setVisibility(View.VISIBLE);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenSetting();
        Map<String, RequestBody> param = new HashMap<>();
        param.put("outlet_name", AppConstant.createRequestBody(txtNamaOutlet.getText().toString().trim()));
        param.put("outlet_address", AppConstant.createRequestBody(txtAlamat.getText().toString().trim()));
        param.put("outlet_phone_no", AppConstant.createRequestBody(txtNohp.getText().toString().trim()));
        param.put("outlet_email", AppConstant.createRequestBody(txtEmail.getText().toString().trim()));
        param.put("outlet_province_id", AppConstant.createRequestBody(provinceId));
        param.put("outlet_city_id", AppConstant.createRequestBody(citiesId));
        param.put("outlet_kecamatan_id", AppConstant.createRequestBody(kecamatanId + ""));
        param.put("postal_code", AppConstant.createRequestBody(txtPostalCode.getText().toString().trim()));
        MultipartBody.Part body = null;
        if (imageFoto != null) {
            imageFoto = new File(imageFoto.getPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFoto);
            body = MultipartBody.Part.createFormData("outlet_image", imageFoto.getName(), requestFile);

        }

        Call<DoPost> call = apiService.editOutlet(auth, param, body);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(Call<DoPost> call, Response<DoPost> data) {
                rlMain.setVisibility(View.VISIBLE);
                rlProgress.setVisibility(View.GONE);
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            getData();
                        } else {
                            Toast.makeText(getActivity(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Response data kosong", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    RecentUtils.handleRetrofitError(data.code());
                }
            }

            @Override
            public void onFailure(Call<DoPost> call, Throwable t) {
                rlMain.setVisibility(View.VISIBLE);
                rlProgress.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });

    }

    private boolean validEditOutlet() {
        if (TextUtils.isEmpty(txtNamaOutlet.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Nama outlet tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtAlamat.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtEmail.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNohp.getText().toString().trim())) {
            Toast.makeText(getActivity(), "No Telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtPostalCode.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Kode POS tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @OnClick(R.id.iv_pic)
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


}