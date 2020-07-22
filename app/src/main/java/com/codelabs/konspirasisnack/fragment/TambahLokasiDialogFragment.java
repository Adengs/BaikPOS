package com.codelabs.konspirasisnack.fragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.codelabs.konspirasisnack.EventBus.SetDataAlamat;
import com.codelabs.konspirasisnack.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TambahLokasiDialogFragment extends DialogFragment implements OnMapReadyCallback, View.OnClickListener {

    @BindView(R.id.ed_lokasi)
    TextView edLokasi;
    @BindView(R.id.ed_waktu)
    TextView edWaktu;
    @BindView(R.id.ed_tanggal)
    TextView edTanggal;
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    Unbinder unbinder;
    private GoogleMap gMap;
    MapView mMapView;
    Geocoder geocoder;
    List<Address> addresses;
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private Boolean mLocationPermissionsGranted = false;
    private LocationCallback mLocationCallBack;
    private static final int REQUEST_CHECK_SETTINGS = 0x1;
    private FusedLocationProviderClient mfusedLocationProviderClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private Boolean mRequestingLocationUpdates;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 700;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
            UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    private static Location currentLocation;
    private String address, city, country, stringLat, stringLong, datetime, selectedTanggal, selectedTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_lokasi_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initVar();
        initEvent();
        initSetup();
        fetchData();


        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                gMap = mMap;
                gMap.setMyLocationEnabled(true);
                if (mLocationPermissionsGranted) {
                    createLocationCallBack();
                    createLocationRequest();
                    buildLocationSettingsRequest();
                    getDeviceLocation();

                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                        return;
                }


                gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {


                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title("lokasi delivery");

                        gMap.clear();
                        gMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                        gMap.addMarker(markerOptions);

                        geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        try {
                            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        address = addresses.get(0).getAddressLine(0);
                        city = addresses.get(0).getLocality();
                        country = addresses.get(0).getCountryName();
                        stringLat = Double.toString(addresses.get(0).getLatitude());
                        stringLong = Double.toString(addresses.get(0).getLongitude());

                    }

                });

                gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        edLokasi.setText(address + " " + city + " " + country);
                    }
                });

            }
        });

        return view;
    }

    private void initView() {
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP);
        setCancelable(false);
    }

    private void initVar() {

    }

    private void initMap() {
        createLocationCallBack();
        createLocationRequest();
        buildLocationSettingsRequest();
        checkLocationEnabled();


    }



    private void initEvent() {
        btnClose.setOnClickListener(this);
        edWaktu.setOnClickListener(this);
        edTanggal.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

    }

    private void initSetup() {

    }

    private void fetchData() {
        getLocationPermission();
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }





    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        mLocationSettingsRequest = builder.build();
    }

    private void checkLocationEnabled() {// check if location is enabled
        LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                && !manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            getDeviceLocation();
        }

    }


    private void createLocationCallBack() {
        mLocationCallBack = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                currentLocation = locationResult.getLastLocation();
                stringLat = Double.toString(currentLocation.getLatitude());
                stringLong = Double.toString(currentLocation.getLongitude());
                myLocation();

            }
        };
    }

    private void myLocation() {
        if (currentLocation != null) {
            stringLat = String.valueOf(currentLocation.getLatitude());
            stringLong = String.valueOf(currentLocation.getLongitude());
            Log.d(TAG, "myLocation: " + stringLat + " " + stringLong);

            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM);
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionsGranted = false;

        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if (grantResults.length > 0){
                    for (int i = 0; i < grantResults.length; i++){
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionsGranted = true;
                    initMap();

                }
            }
        }
    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
            }else {
                ActivityCompat.requestPermissions(getActivity(), permissions, LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else {
            ActivityCompat.requestPermissions(getActivity(), permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    private void getDeviceLocation(){
        mfusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        try {
            if (mLocationPermissionsGranted){
                final Task location = mfusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()){
                            currentLocation = (Location) task.getResult();

                            if (currentLocation != null) {
                                stringLat = Double.toString(currentLocation.getLatitude());
                                stringLong = Double.toString(currentLocation.getLongitude());

                                moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),DEFAULT_ZOOM);

                            }
                            else {
                                startLocationUpdates();
                            }
                        }else {
                            Toast.makeText(getActivity(), "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){

        }
    }

    private void startLocationUpdates() {

        mSettingsClient.checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(getActivity(), new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                        //noinspection MissingPermission
                        if (ActivityCompat.checkSelfPermission(getActivity() ,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

                            return;
                        }
                        mfusedLocationProviderClient.requestLocationUpdates(mLocationRequest, mLocationCallBack, null);
                        getDeviceLocation();
                    }
                })
                .addOnFailureListener(getActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " +
                                        "location settings ");
                                try {
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(getActivity(), REQUEST_CHECK_SETTINGS);
                                    Toast.makeText(getActivity(), "Anda harus mengaktifkan GPS perangkat", Toast.LENGTH_SHORT).show();
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);
                                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                                mRequestingLocationUpdates = false;
                        }
                    }
                });

    }

    private void moveCamera(LatLng latLng, float zoom) {
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude);
//        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

    }



    @Override
    public void onClick(View view) {
        if (view == btnClose){
            dismiss();
        }

        if (view == edTanggal) {
            //get current date
            final Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat toFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            String dt = edTanggal.getText().toString();
            if (!TextUtils.isEmpty(dt)){
                try {
                    c.setTime(toFormat.parse(dt));
                } catch (ParseException e){
                    e.printStackTrace();
                }
            }

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            //Create new instance of DatePickerDialog and return it
            DatePickerDialog datePicker = new DatePickerDialog(getContext(), R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    String dd;
                    if (day < 10) {
                        dd = "0" + day;
                    } else {
                        dd = "" + day;
                    }
                    String mm;
                    month = month + 1;
                    if (month < 10) {
                        mm = "0" + month;
                    } else {
                        mm = "" + month;
                    }

                    String fullDate = year + "-" + mm + "-" + dd;
                    try {
                        Date dt = simpleDateFormat.parse(fullDate);
                        edTanggal.setText(toFormat.format(dt));
                        selectedTanggal = simpleDateFormat.format(dt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }, year, month, day);
            datePicker.getDatePicker().setMinDate(new Date().getTime());
            datePicker.show();
        }

        if (view == edWaktu) {
            //get current time
            final Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            SimpleDateFormat toFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String dt = edWaktu.getText().toString();
            if (!TextUtils.isEmpty(dt)) {
                try {
                    c.setTime(toFormat.parse(dt));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),R.style.datepicker,  new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                    String hour;
                    if(hourOfDay<10){
                        hour="0"+hourOfDay;
                    }else{
                        hour=hourOfDay+"";
                    }

                    String min;
                    if(minute<10){
                        min="0"+minute;
                    }else{
                        min=minute+"";
                    }

                    String time = hour+":"+min;
                    try {
                        Date dt = simpleDateFormat.parse(time);
                        edWaktu.setText(toFormat.format(dt));
                        selectedTime = simpleDateFormat.format(dt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }, hour, minute, DateFormat.is24HourFormat(getContext()));
            timePickerDialog.show();
        }

        if (view == btnSubmit) {
            if (!valid())
                return;
            datetime = selectedTanggal +"  " + selectedTime;
            EventBus.getDefault().post(new SetDataAlamat(address + "-", stringLat +"-", stringLong +"-", datetime + "-"));
            dismiss();
        }

    }

    private boolean valid() {
        if (TextUtils.isEmpty(edLokasi.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Pilih lokasi", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(edTanggal.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Pilih tanggal", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edWaktu.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Pilih waktu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

    }
}
