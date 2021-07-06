package com.codelabs.konspirasisnack.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.codelabs.konspirasisnack.EventBus.RefreshOutlet;
import com.codelabs.konspirasisnack.EventBus.RefreshToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.activity.SignInActivity;
import com.codelabs.konspirasisnack.adapter.SpinnerAdapterName;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.dialog.DialogKasAwal;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetEmployee_list;
import com.codelabs.konspirasisnack.model.GetLoginCashier;
import com.codelabs.konspirasisnack.utils.CheckDevice;
import com.codelabs.konspirasisnack.utils.RecentUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.codelabs.konspirasisnack.helper.MpinUtils.getClearAllText;
import static com.codelabs.konspirasisnack.helper.MpinUtils.getClearText;
import static com.codelabs.konspirasisnack.helper.MpinUtils.getOnClickText;


public class MpinDialogFragment extends DialogFragment {


    @BindView(R.id.spinner_cashier_name)
    Spinner spinnerCashier;
    @BindView(R.id.code_1)
    EditText code1;
    @BindView(R.id.code_2)
    EditText code2;
    @BindView(R.id.code_3)
    EditText code3;
    @BindView(R.id.code_4)
    EditText code4;
    @BindView(R.id.code_5)
    EditText code5;
    @BindView(R.id.code_6)
    EditText code6;
    @BindView(R.id.text_1)
    TextView text1;
    @BindView(R.id.text_2)
    TextView text2;
    @BindView(R.id.text_3)
    TextView text3;
    @BindView(R.id.text_4)
    TextView text4;
    @BindView(R.id.text_5)
    TextView text5;
    @BindView(R.id.text_6)
    TextView text6;
    @BindView(R.id.text_7)
    TextView text7;
    @BindView(R.id.text_8)
    TextView text8;
    @BindView(R.id.text_9)
    TextView text9;
    @BindView(R.id.text_c)
    TextView textC;
    @BindView(R.id.text_0)
    TextView text0;
    @BindView(R.id.text_hapus)
    TextView textHapus;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_logout)
    TextView tvLogout;


    private Call<GetEmployee_list> callCashier;
    private SpinnerAdapterName mAdapter;
    private List<GetEmployee_list.DATAEmployee> responseData = new ArrayList<>();
    Unbinder unbinder;
    private int selectedId;

    public MpinDialogFragment() {
        setCancelable(false);
    }


    public static MpinDialogFragment newInstance(String param1, String param2) {
        MpinDialogFragment fragment = new MpinDialogFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mpin_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        CheckDevice.setScreenOrientation(getActivity(), CheckDevice.isTablet());

        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();
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

    private void initView() {

        mAdapter = new SpinnerAdapterName(getContext(), responseData);
        spinnerCashier.setAdapter(mAdapter);



        List<EditText> listET = new ArrayList<>();
        listET.add(code1);
        listET.add(code2);
        listET.add(code3);
        listET.add(code4);
        listET.add(code5);
        listET.add(code6);
        text0.setOnClickListener(getOnClickText(listET, text0.getText().toString()));
        text1.setOnClickListener(getOnClickText(listET, text1.getText().toString()));
        text2.setOnClickListener(getOnClickText(listET, text2.getText().toString()));
        text3.setOnClickListener(getOnClickText(listET, text3.getText().toString()));
        text4.setOnClickListener(getOnClickText(listET, text4.getText().toString()));
        text5.setOnClickListener(getOnClickText(listET, text5.getText().toString()));
        text6.setOnClickListener(getOnClickText(listET, text6.getText().toString()));
        text7.setOnClickListener(getOnClickText(listET, text7.getText().toString()));
        text8.setOnClickListener(getOnClickText(listET, text8.getText().toString()));
        text9.setOnClickListener(getOnClickText(listET, text9.getText().toString()));
        textC.setOnClickListener(getClearAllText(listET));
        textHapus.setOnClickListener(getClearText(listET));
        code6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 0)
                    doLoginCashier();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogout();
            }
        });
    }

    private void initVar() {
    }

    private void initEvent() {
        spinnerCashier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textC.performClick();
                GetEmployee_list.DATAEmployee item = mAdapter.getItem(position);
                selectedId = item.getU_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initSetup() {
    }

    private void fetchData() {
        loadDataCashier();
    }

    private void dialogLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        builder.setMessage("Logout admin?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doLogout();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    private void doLogout() {
        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        Call<DoPost> call = apiService.doLogout(auth);
        call.enqueue(new Callback<DoPost>() {
            @Override
            public void onResponse(@NonNull Call<DoPost> call, @NonNull Response<DoPost> data) {
                if (data.isSuccessful()) {
                    DoPost response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {

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

                processLogout();
                DataManager.getInstance().doLogout();
            }

            @Override
            public void onFailure(@NonNull Call<DoPost> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void processLogout() {
        Intent intent = new Intent(getContext(), SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



    private void loadDataCashier() {

        RetrofitInterface apiService = ApiUtils.getAPIService();
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();
        callCashier = apiService.getEmployeeList(auth);
        callCashier.enqueue(new Callback<GetEmployee_list>() {
            @Override
            public void onResponse(@NonNull Call<GetEmployee_list> call, @NonNull Response<GetEmployee_list> data) {
                if (data.isSuccessful()) {
                    GetEmployee_list response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            responseData = response.getDATA();
                            mAdapter.clear();
                            mAdapter.addAll(data.body().getDATA());
                            mAdapter.notifyDataSetChanged();
                        } else {

                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetEmployee_list> call, @NonNull Throwable t) {

            }
        });
    }


    void doLoginCashier() {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", selectedId + "");
        String pin = code1.getText().toString() + code2.getText().toString() + code3.getText().toString() + code4.getText().toString() + code5.getText().toString() + code6.getText().toString();
        params.put("pin", pin);
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();

        RetrofitInterface apiService = ApiUtils.getAPIService();

        Call<GetLoginCashier> call = apiService.doLoginCashier(auth, params);
        call.enqueue(new Callback<GetLoginCashier>() {
            @Override
            public void onResponse(Call<GetLoginCashier> call, Response<GetLoginCashier> data) {
                if (data.isSuccessful()) {
                    GetLoginCashier response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                            String currentDateandTime = sdf.format(new Date());
                            DataManager.getInstance().setLastLoginCashire(currentDateandTime);
                            DataManager.getInstance().setLoginDataCashier(response.getDATA().getUser());
                            DataManager.getInstance().setToken_cashier(response.getDATA().getTokenCashier());
                            DataManager.getInstance().setLogoutDurationCashier(response.getDATA().getLogout_duration_cashier());
                            EventBus.getDefault().post(new RefreshToolbar());
                            EventBus.getDefault().post(new RefreshOutlet());
                            if (response.getDATA().getUser().getIs_cashier_open() == 0) {
                                new DialogKasAwal(getActivity());
                            } else {
//                                new DialogKasAwal(getActivity());
//                                Toast.makeText(getActivity(),"Sudah login", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                            dismiss();
                        } else {
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetLoginCashier> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        textC.performClick();
        super.onDismiss(dialog);
    }
}
