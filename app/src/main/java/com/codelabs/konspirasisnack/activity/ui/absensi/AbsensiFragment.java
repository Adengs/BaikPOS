package com.codelabs.konspirasisnack.activity.ui.absensi;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.codelabs.konspirasisnack.EventBus.PermissionCameraBus;
import com.codelabs.konspirasisnack.EventBus.ShowHideToolbar;
import com.codelabs.konspirasisnack.R;
import com.codelabs.konspirasisnack.adapter.SpinnerAbsensiAdapter;
import com.codelabs.konspirasisnack.connection.ApiUtils;
import com.codelabs.konspirasisnack.connection.AppConstant;
import com.codelabs.konspirasisnack.connection.DataManager;
import com.codelabs.konspirasisnack.connection.RetrofitInterface;
import com.codelabs.konspirasisnack.helper.CameraPreview;
import com.codelabs.konspirasisnack.helper.DateUtils;
import com.codelabs.konspirasisnack.model.AbsenceIn;
import com.codelabs.konspirasisnack.model.AbsenceOut;
import com.codelabs.konspirasisnack.model.GetEmployee_list;
import com.codelabs.konspirasisnack.utils.CheckDevice;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import static com.codelabs.konspirasisnack.helper.MpinUtils.getClearAllText;
import static com.codelabs.konspirasisnack.helper.MpinUtils.getClearText;
import static com.codelabs.konspirasisnack.helper.MpinUtils.getOnClickText;

public class AbsensiFragment extends Fragment implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUESTS = 102;
    @BindView(R.id.spinner_kasir)
    Spinner spinnerKasir;
    @BindView(R.id.txt_time)
    TextView txtTime;
    @BindView(R.id.ll_kasir)
    LinearLayout llKasir;
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
    @BindView(R.id.ll_masuk_keluar)
    LinearLayout llMasukKeluar;
    @BindView(R.id.iv_gambar)
    LinearLayout ivGambar;
    @BindView(R.id.btn_masuk)
    Button btnMasuk;
    @BindView(R.id.btn_keluar)
    Button btnKeluar;
    @BindView(R.id.flip_camera)
    ImageView flipCamera;
    @BindView(R.id.take_pic)
    ImageView takePic;
    boolean isLoading = false;
    //    @BindView(R.id.tv_loading)
//    TextView tvLoading;
//    @BindView(R.id.tv_loading_desc)
//    TextView tvLoadingDesc;
//    @BindView(R.id.container_loading)
//    View containerLoading;
//    @BindView(R.id.tv_error)
//    TextView tvError;
//    @BindView(R.id.tv_error_desc)
//    TextView tvErrorDesc;
//    @BindView(R.id.container_error)
//    View containerError;
//    @BindView(R.id.container_content)
//    View containerContent;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.lay_pic)
    RelativeLayout layPic;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.lay_absen)
    RelativeLayout layAbsen;


    private Call<GetEmployee_list> callCashier;
    private SpinnerAbsensiAdapter mAdapter;
    private List<GetEmployee_list.DATAEmployee> responseData = new ArrayList<>();
    Unbinder unbinder;
    private int selectedId;
    private boolean cameraFront = false;

    Thread myThread = null;

    private Camera mCamera;
    private CameraPreview mPreview;
    private static Bitmap bitmap;
    private String selectedImage = "";
    MultipartBody.Part imageFile = null;
    File imageFoto;

    public static AbsensiFragment newInstance() {
        AbsensiFragment fragment = new AbsensiFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absensi, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().post(new ShowHideToolbar(ShowHideToolbar.POSITION_ABSENSI));

        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();


        return view;
    }

    private void initView() {
        mAdapter = new SpinnerAbsensiAdapter(getContext(), responseData);
        spinnerKasir.setAdapter(mAdapter);

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
            public void onTextChanged(CharSequence charSequence, int i, int il, int i2) {
                if (charSequence.toString().length() > 0) ;
//                doAbsenceIn();
//                doAbsenceOut();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Runnable runnable = new CountDownRunner();
        myThread = new Thread(runnable);
        myThread.start();

        if (checkPermissionCamera()) {
            initCamera(new PermissionCameraBus());
        }
    }

    @Subscribe
    public void initCamera(PermissionCameraBus permissionCameraBus) {
        mCamera = Camera.open();
        if (!CheckDevice.isTablet())
            mCamera.setDisplayOrientation(90);
        mPreview = new CameraPreview(getActivity(), mCamera);
        ivGambar.addView(mPreview);
        flipCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the number of cameras
                if (isLoading) {
                    Toast.makeText(getActivity(), "Please wait...", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (bitmap == null) {
                    int camerasNumber = Camera.getNumberOfCameras();
                    if (camerasNumber > 1) {
                        //release the old camera instance
                        //switch camera, from the front and the back and vice versa

                        releaseCamera();
                        chooseCamera();
                        setFocusCamera();
                    }
                } else {
                    bitmap = null;
                    mCamera.startPreview();
                }
            }
        });


        setFocusCamera();
        mCamera.startPreview();
    }

    private void setFocusCamera() {
        if (!cameraFront) {
            Camera.Parameters params = mCamera.getParameters();
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            mCamera.setParameters(params);
        }
    }

    boolean checkPermissionCamera() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getActivity(), Manifest.permission.CAMERA)) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
                alertBuilder.setCancelable(false);
                alertBuilder.setTitle("Permission necessary");
                alertBuilder.setMessage("CAMERA is necessary");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions((Activity) getActivity(),
                                new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
            }
            return false;
        } else {
            return true;
        }
    }


    private int findFrontFacingCamera() {

        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                cameraId = i;
                cameraFront = true;
                break;
            }
        }
        return cameraId;

    }

    private int findBackFacingCamera() {
        int cameraId = -1;
        //Search for the back facing camera
        //get the number of cameras
        int numberOfCameras = Camera.getNumberOfCameras();
        //for every camera check
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                cameraId = i;
                cameraFront = false;
                break;

            }

        }
        return cameraId;
    }


    @Override
    public void onResume() {
        super.onResume();
//        if (mCamera == null) {

//            if (checkPermissionCamera()) {
//
//                mCamera = Camera.open();
//                mPreview.refreshCamera(mCamera);
//                mCamera.startPreview();
//            }
//            Log.d("nu", "null");
//        } else {
//            chooseCamera();
//
//            Log.d("nu", "no null");
//        }

    }

    public void chooseCamera() {
        //if the camera preview is the front
        if (cameraFront) {
            int cameraId = findBackFacingCamera();
            if (cameraId >= 0) {
                //open the backFacingCamera
                //set a picture callback
                //refresh the preview

                mCamera = Camera.open(cameraId);

                if (!CheckDevice.isTablet())
                    mCamera.setDisplayOrientation(90);
                mPreview.refreshCamera(mCamera);
            }
        } else {
            int cameraId = findFrontFacingCamera();
            if (cameraId >= 0) {
                //open the backFacingCamera
                //set a picture callback
                //refresh the preview
                mCamera = Camera.open(cameraId);
                if (!CheckDevice.isTablet())
                    mCamera.setDisplayOrientation(90);
                mPreview.refreshCamera(mCamera);

            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        releaseCamera();
    }


    private void releaseCamera() {
        // stop and release camera
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    class CountDownRunner implements Runnable {
        // @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                }
            }
        }
    }

    public void doWork() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Date dt = new Date();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    String curTime = hours + ":" + minutes;
                    txtTime.setText(DateUtils.changeDateFormat(curTime, DateUtils.TIME_FORMAT_STANDARD_2, DateUtils.TIME_FORMAT_STANDARD_2));
                } catch (Exception e) {
                }
            }
        });
    }


    private void initVar() {
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);

    }

    private void initEvent() {
        spinnerKasir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textC.performClick();
                GetEmployee_list.DATAEmployee item = mAdapter.getItem(position);
                selectedId = item.getU_id();
                ivGambar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnMasuk.setOnClickListener(this);
        btnKeluar.setOnClickListener(this);
        takePic.setOnClickListener(this);
    }

    private void initSetup() {
    }

    private void fetchData() {
        loadDataKasir();
    }

    private void loadDataKasir() {

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
            public void onFailure(Call<GetEmployee_list> call, Throwable t) {

            }
        });
    }

    public void doAbsenceIn() {

        isLoading = true;
        pbLoading.setVisibility(View.VISIBLE);
        btnKeluar.setVisibility(View.GONE);
        btnMasuk.setVisibility(View.GONE);

        Map<String, RequestBody> params = new HashMap<>();
        params.put("u_id", AppConstant.createRequestBody(selectedId + ""));
        String pin = code1.getText().toString() + code2.getText().toString() + code3.getText().toString() + code4.getText().toString() + code5.getText().toString() + code6.getText().toString();
        params.put("u_pin", AppConstant.createRequestBody(pin));
//        params.put("ab_image", selectedImage);
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();

        imageFoto = new File(imageFoto.getPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFoto);
        MultipartBody.Part body = MultipartBody.Part.createFormData("ab_image", imageFoto.getName(), requestFile);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<AbsenceIn> call = apiService.absenceIn(auth, params, body);
        call.enqueue(new Callback<AbsenceIn>() {
            @Override
            public void onResponse(@NonNull Call<AbsenceIn> call, @NonNull Response<AbsenceIn> data) {
//                containerLoading.setVisibility(View.GONE);
                textC.performClick();
                isLoading = false;
                if (!CheckDevice.isTablet()) {
                    layAbsen.setVisibility(View.GONE);
                    layPic.setVisibility(View.VISIBLE);
                }
                bitmap = null;

                mCamera.startPreview();
                if (data.isSuccessful()) {
                    AbsenceIn response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            pbLoading.setVisibility(View.GONE);
                            btnMasuk.setVisibility(View.VISIBLE);
                            btnKeluar.setVisibility(View.VISIBLE);
                            ivGambar.setVisibility(View.VISIBLE);
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        } else {
                            pbLoading.setVisibility(View.GONE);
                            btnMasuk.setVisibility(View.VISIBLE);
                            btnKeluar.setVisibility(View.VISIBLE);
                            ivGambar.setVisibility(View.VISIBLE);
//                            tvError.setText(response.getMESSAGE());
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        pbLoading.setVisibility(View.GONE);
                        btnMasuk.setVisibility(View.VISIBLE);
                        btnKeluar.setVisibility(View.VISIBLE);
                        ivGambar.setVisibility(View.GONE);
//                        containerError.setVisibility(View.VISIBLE);
//                        tvError.setText("Response data kosong");
                    }
                } else {
                    pbLoading.setVisibility(View.GONE);
                    btnMasuk.setVisibility(View.VISIBLE);
                    btnKeluar.setVisibility(View.VISIBLE);
                    ivGambar.setVisibility(View.GONE);
//                    containerError.setVisibility(View.VISIBLE);
//                    RecentUtils.handleRetrofitError(data.code(), tvError);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AbsenceIn> call, @NonNull Throwable t) {
                textC.performClick();
                isLoading = false;
                if (!call.isCanceled()) {
                    pbLoading.setVisibility(View.GONE);
                    btnMasuk.setVisibility(View.VISIBLE);
                    btnKeluar.setVisibility(View.VISIBLE);

                    mCamera.startPreview();
                    t.printStackTrace();
                }


            }
        });
    }

    public void doAbsenceOut() {
        pbLoading.setVisibility(View.VISIBLE);
        btnKeluar.setVisibility(View.GONE);
        btnMasuk.setVisibility(View.GONE);
        isLoading = true;

        Map<String, RequestBody> params = new HashMap<>();
        params.put("u_id", AppConstant.createRequestBody(selectedId + " "));
        String pin = code1.getText().toString() + code2.getText().toString() + code3.getText().toString() + code4.getText().toString() + code5.getText().toString() + code6.getText().toString();
        params.put("u_pin", AppConstant.createRequestBody(pin));
//        params.put("ab_image", selectedImage);
        String auth = AppConstant.AuthValue + " " + DataManager.getInstance().getToken();


        imageFoto = new File(imageFoto.getPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFoto);
        MultipartBody.Part body = MultipartBody.Part.createFormData("ab_image", imageFoto.getName(), requestFile);

        RetrofitInterface apiService = ApiUtils.getAPIService();
        Call<AbsenceOut> call = apiService.absenceOut(auth, params, body);
        call.enqueue(new Callback<AbsenceOut>() {
            @Override
            public void onResponse(Call<AbsenceOut> call, Response<AbsenceOut> data) {
                textC.performClick();
                isLoading = false;
                if (!CheckDevice.isTablet()) {
                    layAbsen.setVisibility(View.GONE);
                    layPic.setVisibility(View.VISIBLE);
                }
                bitmap = null;

                mCamera.startPreview();
                if (data.isSuccessful()) {
                    AbsenceOut response = data.body();
                    if (response != null) {
                        if (response.getSTATUS() == 200) {
                            pbLoading.setVisibility(View.GONE);
                            btnMasuk.setVisibility(View.VISIBLE);
                            btnKeluar.setVisibility(View.VISIBLE);
                            ivGambar.setVisibility(View.VISIBLE);
                            Toast.makeText(getContext(), "sukses keluar", Toast.LENGTH_LONG).show();
                        } else {
                            pbLoading.setVisibility(View.GONE);
                            btnMasuk.setVisibility(View.VISIBLE);
                            btnKeluar.setVisibility(View.VISIBLE);
                            ivGambar.setVisibility(View.VISIBLE);
//                            tvError.setText(response.getMESSAGE());
                            Toast.makeText(getContext(), response.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        pbLoading.setVisibility(View.GONE);
                        btnMasuk.setVisibility(View.VISIBLE);
                        btnKeluar.setVisibility(View.VISIBLE);
                    }
                } else {
                    pbLoading.setVisibility(View.GONE);
                    btnMasuk.setVisibility(View.VISIBLE);
                    btnKeluar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AbsenceOut> call, @NonNull Throwable t) {
                isLoading = false;
                textC.performClick();
                if (!call.isCanceled()) {
                    pbLoading.setVisibility(View.GONE);
                    btnMasuk.setVisibility(View.VISIBLE);
                    btnKeluar.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "Network Failure : { please try again later", Toast.LENGTH_SHORT).show();

                    mCamera.startPreview();
                    t.printStackTrace();
                }
            }
        });
    }

    private void dialogCashierKeluar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        builder.setMessage("Keluar kasir?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                doAbsenceOut();

            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    @OnClick(R.id.iv_back)
    void onClickBtnBack() {
        if (!CheckDevice.isTablet()) {
            layAbsen.setVisibility(View.GONE);
            layPic.setVisibility(View.VISIBLE);
            bitmap = null;

            mCamera.startPreview();
        }
    }


    @Override
    public void onClick(View view) {

        if (view == takePic) {
            if (isLoading) {
                Toast.makeText(getActivity(), "Please wait...", Toast.LENGTH_SHORT).show();
                return;
            }
            if (bitmap == null)
                mCamera.takePicture(null, null, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
//                        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
//                        selectedImage = "data:image/jpeg;base64," + convert(bitmap);
//                        bitmap = BitmapFactory.decodeFile(imageFoto.getPath());
//                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                        bitmap.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
//                        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), imageFoto);
//                        imageFile = MultipartBody.Part.createFormData("ab_image", imageFoto.getName(), requestFile);

                        try {
                            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                            String fileName = "Konspirasi_Snack_" + timeStamp ;

                            File f = new File(getActivity().getCacheDir(), fileName);
                            f.createNewFile();

                            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 20 /*ignored for PNG*/, bos);
                            byte[] bitmapdata = bos.toByteArray();
                            FileOutputStream fos = null;
                            fos = new FileOutputStream(f);

                            fos.write(bitmapdata);
                            fos.flush();
                            fos.close();

                            imageFoto = f;
//                            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), f);
//                            imageFile = MultipartBody.Part.createFormData("ab_image", f.getName(), requestFile);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (!CheckDevice.isTablet()) {
                            layAbsen.setVisibility(View.VISIBLE);
                            layPic.setVisibility(View.GONE);
                        }
                    }
                });
            else {
                bitmap = null;

                mCamera.startPreview();
            }
        }
        if (view == btnMasuk) {
            if (bitmap != null) {
                if (isLoading) {
                    Toast.makeText(getActivity(), "Please wait...", Toast.LENGTH_SHORT).show();
                    return;
                }
                doAbsenceIn();
            } else {
                Toast.makeText(getActivity(), "Silahkan ambil foto terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == btnKeluar) {
            if (bitmap != null) {
                if (isLoading) {
                    Toast.makeText(getActivity(), "Please wait...", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialogCashierKeluar();
            } else {
                Toast.makeText(getActivity(), "Silahkan ambil foto terlebih dahulu", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
