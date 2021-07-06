package com.codelabs.konspirasisnack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.SpinnerJenisUsahaAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerKecamatanAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerKotaAdapter;
import com.codelabs.konspirasisnack.adapter.SpinnerProvinsiAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetCities;
import com.codelabs.konspirasisnack.model.GetJenisUsaha;
import com.codelabs.konspirasisnack.model.GetKecamatan;
import com.codelabs.konspirasisnack.model.GetProvince;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInformasiUsahaActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ed_nama)
    TextInputEditText edNama;
    @BindView(R.id.ed_no_telp)
    TextInputEditText edNoTelp;
    @BindView(R.id.ed_nama_usaha)
    TextInputEditText edNamaUsaha;
    @BindView(R.id.ed_alamat)
    TextInputEditText edAlamat;
    @BindView(R.id.btn_lanjut)
    Button btnLanjut;
    @BindView(R.id.spinner_usaha)
    Spinner spinnerUsaha;
    @BindView(R.id.spinner_prov)
    Spinner spinnerProv;
    @BindView(R.id.spinner_cities)
    Spinner spinnerCities;


//    @BindView(R.id.ed_jenis_usaha)
//    TextInputEditText edJenisUsaha;
//    @BindView(R.id.ed_provinsi)
//    TextInputEditText edProvinsi;
//    @BindView(R.id.ed_kota)
//    TextInputEditText edKota;

    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.spinner_kecamatan)
    Spinner spinnerKecamatan;
    @BindView(R.id.ed_postal_code)
    TextInputEditText edPostalCode;


    private SpinnerJenisUsahaAdapter mAdapterUsaha;
    private SpinnerProvinsiAdapter mAdapterProv;
    private SpinnerKotaAdapter mAdapterCities;
    private Call<GetJenisUsaha> callJenisUsaha;
    private Call<GetProvince> callProvince;
    private Call<GetCities> callCities;
    private List<GetJenisUsaha.DATAUsaha> responseJenisUsaha = new ArrayList<>();
    private List<GetProvince.DATAProvince> responseProvince = new ArrayList<>();
    private List<GetKecamatan.DATA> responseKecamatan = new ArrayList<>();
    private List<GetCities.DATACities> responseCities = new ArrayList<>();
    private int selectedIdUser;
    private String provinceId;
    private int usahaId;
    private String cityId;
    private SpinnerKecamatanAdapter mAdapterKecamatan;
    private int kecamatanId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_informasi_usaha);
        ButterKnife.bind(this);
        CheckDevice.setScreenOrientation(this, CheckDevice.isTablet());

        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();


    }

    private void initView() {
        mAdapterUsaha = new SpinnerJenisUsahaAdapter(this, responseJenisUsaha);
        spinnerUsaha.setAdapter(mAdapterUsaha);

        mAdapterProv = new SpinnerProvinsiAdapter(this, responseProvince);
        spinnerProv.setAdapter(mAdapterProv);

        mAdapterCities = new SpinnerKotaAdapter(this, responseCities);
        spinnerCities.setAdapter(mAdapterCities);

        mAdapterKecamatan = new SpinnerKecamatanAdapter(this, responseKecamatan);
        spinnerKecamatan.setAdapter(mAdapterKecamatan);


//        Utils.setNoStatusBar(getWindow());

    }

    private void initVar() {
        selectedIdUser = DataManager.getInstance().getU_id_reg();

    }

    private void initEvent() {
        btnLanjut.setOnClickListener(this);

        spinnerUsaha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetJenisUsaha.DATAUsaha item = mAdapterUsaha.getItem(position);
                usahaId = item.getMcat_id();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetProvince.DATAProvince item = mAdapterProv.getItem(position);
                provinceId = item.getProvince_id();
                loadDataCities();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetCities.DATACities item = mAdapterCities.getItem(position);
                cityId = item.getRegency_id();
                loadKecamatan();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerKecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetKecamatan.DATA item = mAdapterKecamatan.getItem(position);
                kecamatanId = item.getSubdistrictId();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void loadKecamatan() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetKecamatan> call = apiService.getKecamatan(auth,cityId);
        call.enqueue(new Callback<GetKecamatan>() {
            @Override
            public void onResponse(Call<GetKecamatan> call, Response<GetKecamatan> data) {
                if (data.isSuccessful()) {
                    GetKecamatan response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseKecamatan = response.getDATA();
                            mAdapterKecamatan.clear();
                            mAdapterKecamatan.addAll(data.body().getDATA());
                            mAdapterKecamatan.notifyDataSetChanged();
                            kecamatanId = response.getDATA().get(0).getSubdistrictId();

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<GetKecamatan> call, Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();

            }
        });

    }

    private void initSetup() {

    }

    private void fetchData() {
        loadDataUsaha();
        loadDataProv();
//        loadDataCities();

    }


    private void loadDataUsaha() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetJenisUsaha> call = apiService.getJenisUsaha(auth);
        call.enqueue(new Callback<GetJenisUsaha>() {
            @Override
            public void onResponse(@NonNull Call<GetJenisUsaha> call, @NonNull Response<GetJenisUsaha> data) {
                if (data.isSuccessful()) {
                    GetJenisUsaha response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseJenisUsaha = response.getDATA();
                            mAdapterUsaha.clear();
                            mAdapterUsaha.addAll(data.body().getDATA());
                            mAdapterUsaha.notifyDataSetChanged();

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetJenisUsaha> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }

    private void loadDataProv() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AcceptTitle + AppConstant.AcceptValue;
        Call<GetProvince> call = apiService.getProvince(auth);
        call.enqueue(new Callback<GetProvince>() {
            @Override
            public void onResponse(@NonNull Call<GetProvince> call, @NonNull Response<GetProvince> data) {
                if (data.isSuccessful()) {
                    GetProvince response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseProvince = response.getDATA();
                            mAdapterProv.clear();
                            mAdapterProv.addAll(data.body().getDATA());
                            mAdapterProv.notifyDataSetChanged();
                            provinceId = response.getDATA().get(0).getProvince_id();
                            loadDataCities();

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetProvince> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }

    void loadDataCities() {


        Map<String, String> param = new HashMap<>();
        param.put("province_id", provinceId + "");
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<GetCities> call = apiService.getCities(param);
        call.enqueue(new Callback<GetCities>() {
            @Override
            public void onResponse(@NonNull Call<GetCities> call, @NonNull Response<GetCities> data) {
                if (data.isSuccessful()) {
                    GetCities response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseCities = response.getDATA();
                            mAdapterCities.clear();
                            mAdapterCities.addAll(data.body().getDATA());
                            mAdapterCities.notifyDataSetChanged();
                            spinnerCities.setSelection(0);
                            cityId = response.getDATA().get(0).getRegency_id();
                            loadKecamatan();


                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetCities> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    hideDialogProgress();
                    showToast("Network Failure :( please try again later");
                }
                t.printStackTrace();
            }
        });
    }


    private void doSignUpCompany() {
        String nama = edNama.getText().toString();
        String noTelp = edNoTelp.getText().toString();
        String namaUsaha = edNamaUsaha.getText().toString();
        String alamat = edAlamat.getText().toString();
        String postalCode = edPostalCode.getText().toString();

        if (TextUtils.isEmpty(nama)) {
            showToast("Mohon masukkan nama");
            return;
        }

        if (TextUtils.isEmpty(noTelp)) {
            showToast("Mohon masukkan no telepon");
            return;
        }

        if (TextUtils.isEmpty(namaUsaha)) {
            showToast("Mohon masukkan nama usaha");
            return;
        }

        if (TextUtils.isEmpty(alamat)) {
            showToast("Mohon masukkan alamat");
            return;
        }

        if (responseKecamatan.size() == 0) {
            showToast("Anda belum memilih kecamatan");
            return;
        }

        if (TextUtils.isEmpty(postalCode)) {
            showToast("Mohon masukkan kode POS");
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("user_id", selectedIdUser + "");
        params.put("fullname", nama);
        params.put("phone_no", noTelp);
        params.put("company_name", namaUsaha);
        params.put("company_address", alamat);
        params.put("company_type_id", usahaId + "");
        params.put("province_id", provinceId + "");
        params.put("city_id", cityId + "");
        params.put("kecamatan_id", kecamatanId + "");
        params.put("postal_code", postalCode + "");

        showDialogProgress("Proses data register");

        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getTokenClient();
        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<DoPost> call = apiService.doRegisterCompany(auth, params);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                hideDialogProgress();
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            showToast(response.getMESSAGE());
                            Intent intent = new Intent(RegisterInformasiUsahaActivity.this, SignInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        } else {
                            showToast(response.getMESSAGE());
                        }
                    } else {
                        showToast("Response data kosong");
                    }
                } else {
                    StringBuilder error = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = null;
                        if (data.errorBody() != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(
                                    data.errorBody().byteStream()));

                            String eLine = null;
                            while ((eLine = bufferedReader.readLine()) != null) {
                                error.append(eLine);
                            }
                            bufferedReader.close();
                        }

                    } catch (Exception e) {
                        error.append(e.getMessage());
                    }

                    Log.e("Error", error.toString());
                    try {
                        JSONObject objek = new JSONObject(error.toString());
                        RecentUtils.handleRetrofitError(data.code(),objek.getString("MESSAGE"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
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
            doSignUpCompany();
//            startActivity(new Intent(this,RegisterMasukanProdukActivity.class));
        }

    }

}
