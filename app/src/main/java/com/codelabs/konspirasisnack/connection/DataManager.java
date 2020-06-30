package com.codelabs.konspirasisnack.connection;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.codelabs.konspirasisnack.AppController;
import com.codelabs.konspirasisnack.model.GetCustomer;
import com.codelabs.konspirasisnack.model.GetInvoiceNumber;
import com.codelabs.konspirasisnack.model.GetLogin;
import com.codelabs.konspirasisnack.model.GetLoginCashier;
import com.codelabs.konspirasisnack.model.GetOpenCashier;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetOrderType;
import com.codelabs.konspirasisnack.model.GetRegisterStep1;
import com.codelabs.konspirasisnack.model.GetTambahAlamatDelivery;
import com.codelabs.konspirasisnack.model.GetTokenClient;
import com.codelabs.konspirasisnack.model.ParamCreateReservation;
import com.codelabs.konspirasisnack.model.SavedTable;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private final static DataManager instance;

    static {
        instance = new DataManager();
    }

    public static DataManager getInstance() {
        return instance;
    }

    private static SharedPreferences appPreference;

    public DataManager() {
        //FOR CHECK PREFERENCES
        appPreference = AppController.getInstance().getApplicationContext().getSharedPreferences("poscodelabs", Context.MODE_PRIVATE);
    }


    public static void setTempJson(String key, String json) {
        SharedPreferences.Editor editor = appPreference.edit();
        editor.putString(key, json);
        editor.apply();
    }

    public static String getTempJson(String key) {
        String jso = appPreference.getString(key, "");
        if (TextUtils.isEmpty(jso)) {
            return "";
        }
        return jso;
    }

    public static void setTempJSONNumber(String key, int json) {
        SharedPreferences.Editor editor = appPreference.edit();
        editor.putInt(key, json);
        editor.apply();
    }

    public static int getTempsJSONNumber(String key) {
        return appPreference.getInt(key, 0);
    }


    public void setLogin(boolean stat) {
        SharedPreferences.Editor editor = appPreference.edit();
        editor.putBoolean("IS_LOGIN", stat);
        editor.apply();
    }


    public boolean isLogin() {
        return appPreference.getBoolean("IS_LOGIN", false);
    }


    public void setFirstInstall(boolean stat) {
        SharedPreferences.Editor editor = appPreference.edit();
        editor.putBoolean("IS_FIRST_INSTALL", stat);
        editor.apply();
    }


    public boolean isFirstInstall() {
        return appPreference.getBoolean("IS_FIRST_INSTALL", true);
    }


    public void setTempBoolean(String title, boolean val) {
        SharedPreferences.Editor editor = appPreference.edit();
        editor.putBoolean(title, val);
        editor.apply();
    }

    public boolean getTempBoolean(String val) {
        return appPreference.getBoolean(val, false);
    }

    public void setTokenData(GetTokenClient.DATATokenClient data) {
        setTokenClient(data.getToken());
    }

    public void clearTokenCashier() {
        setTokenClient("");
    }

    public String getTokenClient() {
        return getTempJson("token");
    }

    public void setTokenClient(String tokenClient) {
        setTempJson("token", tokenClient);
    }


    public void setTambahAlamat(GetTambahAlamatDelivery.DATAShipping dataShipping) {
        setAddressTambah(dataShipping.getAddress());
        setLatitudeTambah(dataShipping.getLatitude());
        setLongitudeTambah(dataShipping.getLongitude());
        setDateTimeTambah(dataShipping.getDatetime());
    }

    public void clearTambahAlamat() {
        setAddressTambah("");
        setLatitudeTambah("");
        setLongitudeTambah("");
        setDateTimeTambah("");
    }

    public void setAddressTambah(String addressTambah) {
        setTempJson("address", addressTambah);
    }

    public String getAddressTambah() {
        return getTempJson("address");
    }

    public void setLatitudeTambah(String latitudeTambah) {
        setTempJson("latitude", latitudeTambah);
    }

    public String getLatitudeTambah() {
        return getTempJson("latitude");
    }

    public void setLongitudeTambah(String longitudeTambah) {
        setTempJson("longitude", longitudeTambah);
    }

    public String getLongitudeTambah() {
        return getTempJson("longitude");
    }

    public void setDateTimeTambah(String dateTimeTambah) {
        setTempJson("datetime", dateTimeTambah);
    }

    public String getDateTimeTambah() {
        return getTempJson("datetime");
    }


    public void setLoginData(GetLogin.UserData data) {
        setLogin(true);
        setOutletData(data.getOutlet());
        setMerchantData(data.getMerchant());
        setU_id(data.getU_id());
        setU_merchant_id(data.getU_merchant_id());
        setU_outlet_id(data.getU_outlet_id());
        setU_firstname(data.getU_firstname());
        setU_lastname(data.getU_lastname());
        setU_email(data.getU_email());
        setU_dob(data.getU_dob());
        setU_address(data.getU_address());
        setU_address_alt(data.getU_address_alt());
        setU_phone_no(data.getU_phone_no());
        setU_phone_alt(data.getU_phone_no_alt());
        setU_mobile_no(data.getU_mobile_no());
        setU_mobile_no_alt(data.getU_mobile_no_alt());
        setU_type(data.getU_type());
        setU_otp_code(data.getU_otp_code());
        setU_otp_date(data.getU_otp_date());
        setIs_otp_verified(data.getIs_otp_verified());
        setIs_email_verified(data.getIs_email_verified());
        setU_is_active(data.getU_is_active());
        setU_image(data.getU_image());
        setU_position(data.getU_position());
        setU_nik(data.getU_nik());
        setCreated_at(data.getCreated_at());
        setUpdated_at(data.getUpdated_at());
    }


    public void doLogout() {
        setLogin(false);
        setOutletData(new GetLogin.OutletData());
        setMerchantData(new GetLogin.MerchantData());
        setU_id(0);
        setU_merchant_id(0);
        setU_outlet_id(0);
        setU_firstname("");
        setU_lastname("");
        setU_email("");
        setU_dob("");
        setU_address("");
        setU_address_alt("");
        setU_phone_no("");
        setU_phone_alt("");
        setU_mobile_no("");
        setU_mobile_no_alt("");
        setU_type(0);
        setU_otp_code("");
        setU_otp_date("");
        setIs_otp_verified(0);
        setIs_email_verified(0);
        setU_is_active(0);
        setU_image("");
        setU_position("");
        setU_nik("");
        setCreated_at("");
        setUpdated_at("");
    }


    public OutletData getOutlet() {
        return new OutletData();
    }

    public void setOutletData(GetLogin.OutletData outlet) {
        new OutletData(outlet);
    }

    public MerchantData getMerchant() {
        return new MerchantData();
    }

    public void setMerchantData(GetLogin.MerchantData merchant) {
        new MerchantData(merchant);
    }

    public int getU_id() {
        return getTempsJSONNumber("u_id");
    }

    public void setU_id(int u_id) {
        setTempJSONNumber("u_id", u_id);
    }

    public int getU_merchant_id() {
        return getTempsJSONNumber("u_merchant_id");
    }

    public void setU_merchant_id(int u_merchant_id) {
        setTempJSONNumber("u_merchant_id", u_merchant_id);
    }

    public int getU_outlet_id() {
        return getTempsJSONNumber("u_outlet_id");
    }

    public void setU_outlet_id(int u_outlet_id) {
        setTempJSONNumber("u_outlet_id", u_outlet_id);
    }

    public String getU_firstname() {
        return getTempJson("u_firstname");
    }

    public void setU_firstname(String u_firstname) {
        setTempJson("u_firstname", u_firstname);
    }

    public String getU_lastname() {
        return getTempJson("u_lastname");
    }

    public void setU_lastname(String u_lastname) {
        setTempJson("u_lastname", u_lastname);
    }

    public String getU_email() {
        return getTempJson("u_email");
    }

    public void setU_email(String u_email) {
        setTempJson("u_email", u_email);
    }

    public String getU_dob() {
        return getTempJson("u_dob");
    }

    public void setU_dob(String u_dob) {
        setTempJson("u_dob", u_dob);
    }

    public String getU_address() {
        return getTempJson("u_address");
    }

    public void setU_address(String u_address) {
        setTempJson("u_address", u_address);
    }

    public String getU_address_alt() {
        return getTempJson("u_address_alt");
    }

    public void setU_address_alt(String u_address_alt) {
        setTempJson("u_address_alt", u_address_alt);
    }

    public String getU_phone_no() {
        return getTempJson("u_phone_no");
    }

    public void setU_phone_no(String u_phone_no) {
        setTempJson("u_phone_no", u_phone_no);
    }

    public String getU_phone_alt() {
        return getTempJson("u_phone_alt");
    }

    public void setU_phone_alt(String u_phone_alt) {
        setTempJson("u_phone_alt", u_phone_alt);
    }

    public String getU_mobile_no() {
        return getTempJson("u_mobile_no");
    }

    public void setU_mobile_no(String u_mobile_no) {
        setTempJson("u_mobile_no", u_mobile_no);
    }

    public String getU_mobile_no_alt() {
        return getTempJson("u_mobile_no_alt");
    }

    public void setU_mobile_no_alt(String u_mobile_no_alt) {
        setTempJson("u_mobile_no_alt", u_mobile_no_alt);
    }

    public int getU_type() {
        return getTempsJSONNumber("u_type");
    }

    public void setU_type(int u_type) {
        setTempJSONNumber("u_type", u_type);
    }

    public String getU_otp_code() {
        return getTempJson("u_otp_code");
    }

    public void setU_otp_code(String u_otp_code) {
        setTempJson("u_otp_code", u_otp_code);
    }

    public String getU_otp_date() {
        return getTempJson("u_otp_date");
    }

    public void setU_otp_date(String u_otp_date) {
        setTempJson("u_otp_date", u_otp_date);
    }

    public int getIs_otp_verified() {
        return getTempsJSONNumber("is_otp_verified");
    }

    public void setIs_otp_verified(int is_otp_verified) {
        setTempJSONNumber("u_type", is_otp_verified);
    }

    public int getIs_email_verified() {
        return getTempsJSONNumber("is_email_verified");
    }

    public void setIs_email_verified(int is_email_verified) {
        setTempJSONNumber("is_email_verified", is_email_verified);
    }

    public int getU_is_active() {
        return getTempsJSONNumber("u_is_active");
    }

    public void setU_is_active(int u_is_active) {
        setTempJSONNumber("u_is_active", u_is_active);
    }

    public String getU_image() {
        return getTempJson("u_image");
    }

    public void setU_image(String u_image) {
        setTempJson("u_image", u_image);
    }

    public String getU_position() {
        return getTempJson("u_position");
    }

    public void setU_position(String u_position) {
        setTempJson("u_position", u_position);
    }

    public String getU_nik() {
        return getTempJson("u_nik");
    }

    public void setU_nik(String u_nik) {
        setTempJson("u_nik", u_nik);
    }

    public String getCreated_at() {
        return getTempJson("created_at");
    }

    public void setCreated_at(String created_at) {
        setTempJson("created_at", created_at);
    }

    public String getUpdated_at() {
        return getTempJson("updated_at");
    }

    public void setUpdated_at(String updated_at) {
        setTempJson("updated_at", updated_at);
    }

    public String getPassword() {
        return getTempJson("password");
    }

    public void setPassword(String val) {
        setTempJson("password", val);
    }

    public String getToken() {
        return getTempJson("token");
    }

    public void setToken(String val) {
        setTempJson("token", val);
    }


    public static class OutletData {

        OutletData(GetLogin.OutletData outlet) {
//            setSocialMediaData(outlet.getSocialMedia());
            setOt_id(outlet.getOt_id());
            setOt_merchant_id(outlet.getOt_merchant_id());
            setOt_name(outlet.getOt_name());
            setOt_address(outlet.getOt_address());
            setOt_address_alt(outlet.getOt_address_alt());
            setOutlet_country_id(outlet.getOutlet_country_id());
            setOutlet_province_id(outlet.getOutlet_province_id());
            setOutlet_city_id(outlet.getOutlet_city_id());
            setOutlet_zip_code(outlet.getOutlet_zip_code());
            setOt_phone_no(outlet.getOt_phone_no());
            setOt_phone_no_alt(outlet.getOt_phone_no_alt());
            setOt_mobile_no(outlet.getOt_mobile_no());
            setOt_mobile_no_alt(outlet.getOt_mobile_no_alt());
            setOt_fax_no(outlet.getOt_fax_no());
            setOt_fax_no_alt(outlet.getOt_fax_no_alt());
            setOt_image_url(outlet.getOt_image_url());
            setOt_is_active(outlet.getOt_is_active());
            setOt_expired_at(outlet.getOt_expired_at());
            setCreated_at(outlet.getCreated_at());
            setUpdated_at(outlet.getUpdated_at());

        }


        public OutletData() {

        }

//        public SocialMediaData getSocialMedia() {
//            return new SocialMediaData();
//        }
//
//        public void setSocialMediaData(GetLogin.SocialMedia socialMediaData) {
//            new SocialMediaData(socialMediaData);
//        }

        public int getOt_id() {
            return getTempsJSONNumber("ot_id");
        }

        public void setOt_id(int ot_id) {
            setTempJSONNumber("ot_id", ot_id);
        }

        public int getOt_merchant_id() {
            return getTempsJSONNumber("ot_merchant_id");
        }

        public void setOt_merchant_id(int ot_merchant_id) {
            setTempJSONNumber("ot_merchant_id", ot_merchant_id);
        }

        public String getOt_name() {
            return getTempJson("ot_name");
        }

        public void setOt_name(String ot_name) {
            setTempJson("ot_name", ot_name);
        }

        public String getOt_address() {
            return getTempJson("ot_address");
        }

        public void setOt_address(String ot_address) {
            setTempJson("ot_address", ot_address);
        }

        public String getOt_address_alt() {
            return getTempJson("ot_address_alt");
        }

        public void setOt_address_alt(String ot_address_alt) {
            setTempJson("ot_address_alt", ot_address_alt);
        }

        public int getOutlet_country_id() {
            return getTempsJSONNumber("outlet_country_id");
        }

        public void setOutlet_country_id(int outlet_country_id) {
            setTempJSONNumber("outlet_country_id", outlet_country_id);
        }

        public int getOutlet_province_id() {
            return getTempsJSONNumber("outlet_province_id");
        }

        public void setOutlet_province_id(int outlet_province_id) {
            setTempJSONNumber("outlet_province_id", outlet_province_id);
        }

        public int getOutlet_city_id() {
            return getTempsJSONNumber("outlet_city_id");
        }

        public void setOutlet_city_id(int outlet_city_id) {
            setTempJSONNumber("outlet_city_id", outlet_city_id);
        }

        public String get0utlet_zip_code() {
            return getTempJson("outlet_zip_code");
        }

        public void setOutlet_zip_code(String outlet_zip_code) {
            setTempJson("outlet_zip_code", outlet_zip_code);
        }

        public String getOt_phone_no() {
            return getTempJson("ot_phone_no");
        }

        public void setOt_phone_no(String ot_phone_no) {
            setTempJson("ot_phone_no", ot_phone_no);
        }

        public String getOt_phone_no_alt() {
            return getTempJson("ot_phone_no_alt");
        }

        public void setOt_phone_no_alt(String ot_phone_no_alt) {
            setTempJson("ot_phone_no_alt", ot_phone_no_alt);
        }

        public String getOt_mobile_no() {
            return getTempJson("ot_mobile_no");
        }

        public void setOt_mobile_no(String ot_mobile_no) {
            setTempJson("ot_mobile_no", ot_mobile_no);
        }

        public String getOt_mobile_no_alt() {
            return getTempJson("ot_mobile_no_alt");
        }

        public void setOt_mobile_no_alt(String ot_mobile_no_alt) {
            setTempJson("ot_mobile_no_alt", ot_mobile_no_alt);
        }

        public String getOt_fax_no() {
            return getTempJson("ot_fax_no");
        }

        public void setOt_fax_no(String ot_fax_no) {
            setTempJson("ot_fax_no", ot_fax_no);
        }

        public String getOt_fax_no_alt() {
            return getTempJson("ot_fax_no_alt");
        }

        public void setOt_fax_no_alt(String ot_fax_no_alt) {
            setTempJson("ot_fax_no_alt", ot_fax_no_alt);
        }


        public String getOt_image_url() {
            return getTempJson("ot_image_url");
        }

        public void setOt_image_url(String ot_image_url) {
            setTempJson("ot_image_url", ot_image_url);
        }

        public int getOt_is_active() {
            return getTempsJSONNumber("ot_is_active");
        }

        public void setOt_is_active(int ot_is_active) {
            setTempJSONNumber("ot_is_active", ot_is_active);
        }

        public String getOt_expired_at() {
            return getTempJson("ot_expired_at");
        }

        public void setOt_expired_at(String ot_expired_at) {
            setTempJson("ot_expired_at", ot_expired_at);
        }

        public String getCreated_at() {
            return getTempJson("created_at");
        }

        public void setCreated_at(String created_at) {
            setTempJson("created_at", created_at);
        }

        public String getUpdated_at() {
            return getTempJson("updated_at");
        }

        public void setUpdated_at(String updated_at) {
            setTempJson("updated_at", updated_at);
        }


        public static class SocialMediaData {
            SocialMediaData(GetLogin.SocialMedia socialMedia) {
                setFacebookData(socialMedia.getFacebook());
                setInstagramData(socialMedia.getInstagram());
                setTwitterData(socialMedia.getTwitter());
                setYoutubeData(socialMedia.getYoutube());

            }

            public SocialMediaData() {

            }

            public String getFacebookData() {
                return getTempJson("facebook");
            }

            public void setFacebookData(String facebookData) {
                setTempJson("facebook", facebookData);
            }

            public String getInstagramData() {
                return getTempJson("instagram");
            }

            public void setInstagramData(String instagramData) {
                setTempJson("instagram", instagramData);
            }

            public String getTwitterData() {
                return getTempJson("twitter");
            }

            public void setTwitterData(String twitterData) {
                setTempJson("twitter", twitterData);
            }

            public String getYoutubeData() {
                return getTempJson("youtube");
            }

            public void setYoutubeData(String youtubeData) {
                setTempJson("youtube", youtubeData);
            }

        }

    }


    public static class MerchantData {

        MerchantData(GetLogin.MerchantData merchant) {
            setMc_id(merchant.getMc_id());
            setMc_mcat_id(merchant.getMc_mcat_id());
            setMc_name(merchant.getMc_name());
            setMc_address(merchant.getMc_address());
            setMc_address_alt(merchant.getMc_address_alt());
            setMc_phone_no(merchant.getMc_phone_no());
            setMc_phone_alt(merchant.getMc_phone_no_alt());
            setMc_fax_no(merchant.getMc_fax_no());
            setMc_fax_no_alt(merchant.getMc_fax_no_alt());
            setMc_trial_expired(merchant.getMc_trial_expired());
            setMc_is_trial(merchant.getMc_is_trial());
            setMc_is_active(merchant.getMc_is_active());
            setCreated_at(merchant.getCreated_at());
            setUpdated_at(merchant.getUpdated_at());

        }

        public MerchantData() {

        }

        public int getMc_id() {
            return getTempsJSONNumber("mc_id");
        }

        public void setMc_id(int mc_id) {
            setTempJSONNumber("mc_id", mc_id);
        }

        public int getMc_mcat_id() {
            return getTempsJSONNumber("mc_mcat_id");
        }

        public void setMc_mcat_id(int mc_mcat_id) {
            setTempJSONNumber("mc_mcat_id", mc_mcat_id);
        }

        public String getMc_name() {
            return getTempJson("mc_name");
        }

        public void setMc_name(String mc_name) {
            setTempJson("mc_name", mc_name);
        }

        public String getMc_address() {
            return getTempJson("mc_address");
        }

        public void setMc_address(String mc_address) {
            setTempJson("mc_address", mc_address);
        }

        public String getMc_address_alt() {
            return getTempJson("mc_address_alt");
        }

        public void setMc_address_alt(String mc_address_alt) {
            setTempJson("mc_address_alt", mc_address_alt);
        }

        public String getMc_phone_no() {
            return getTempJson("mc_phone_no");
        }

        public void setMc_phone_no(String mc_phone_no) {
            setTempJson("mc_phone_no", mc_phone_no);
        }

        public String getMc_phone_alt() {
            return getTempJson("mc_phone_alt");
        }

        public void setMc_phone_alt(String mc_phone_alt) {
            setTempJson("mc_phone_alt", mc_phone_alt);
        }

        public String getMc_fax_no() {
            return getTempJson("mc_fax_no");
        }

        public void setMc_fax_no(String mc_fax_no) {
            setTempJson("mc_fax_no", mc_fax_no);
        }

        public String getMc_fax_no_alt() {
            return getTempJson("mc_fax_no_alt");
        }

        public void setMc_fax_no_alt(String mc_fax_no_alt) {
            setTempJson("mc_fax_no_alt", mc_fax_no_alt);
        }

        public String getMc_trial_expired() {
            return getTempJson("mc_trial_expired");
        }

        public void setMc_trial_expired(String mc_trial_expired) {
            setTempJson("mc_trial_expired", mc_trial_expired);
        }

        public int getMc_is_trial() {
            return getTempsJSONNumber("mc_is_trial");
        }

        public void setMc_is_trial(int mc_is_trial) {
            setTempJSONNumber("mc_is_trial", mc_is_trial);
        }

        public int getMc_is_active() {
            return getTempsJSONNumber("mc_is_active");
        }

        public void setMc_is_active(int mc_is_active) {
            setTempJSONNumber("mc_is_active", mc_is_active);
        }

        public String getCreated_at() {
            return getTempJson("created_at");
        }

        public void setCreated_at(String created_at) {
            setTempJson("created_at", created_at);
        }

        public String getUpdated_at() {
            return getTempJson("updated_at");
        }

        public void setUpdated_at(String updated_at) {
            setTempJson("updated_at", updated_at);
        }
    }

    public String getLastLogin() {
        return getTempJson("LAST_LOGIN_DATE");
    }

    public void setLastLogin(String val) {
        setTempJson("LAST_LOGIN_DATE", val);
    }

    public String getLogoutDuration() {
        return getTempJson("LOGOUT_DURATION");
    }

    public void setLogoutDuration(String val) {
        setTempJson("LOGOUT_DURATION", val);
    }


    public void setLoginDataCashier(GetLoginCashier.UserData data) {
        setLogin(true);
        setOutletDataCashier(data.getOutlet());
        setMerchantDataCashier(data.getMerchant());
        setU_id_cashier(data.getU_id());
        setU_merchant_id_cashier(data.getU_merchant_id());
        setU_outlet_id_cashier(data.getU_outlet_id());
        setU_firstname_cashier(data.getU_firstname());
        setU_lastname_cashier(data.getU_lastname());
//        setU_email_cashier(data.getU_email());
        setU_dob_cashier(data.getU_dob());
        setU_address_cashier(data.getU_address());
        setU_address_alt_cashier(data.getU_address_alt());
        setU_phone_no_cashier(data.getU_phone_no());
        setU_phone_alt_cashier(data.getU_phone_no_alt());
        setU_mobile_no_cashier(data.getU_mobile_no());
        setU_mobile_no_alt_cashier(data.getU_mobile_no_alt());
        setU_type_cashier(data.getU_type());
        setU_otp_code_cashier(data.getU_otp_code());
        setU_otp_date_cashier(data.getU_otp_date());
        setIs_otp_verified_cashier(data.getIs_otp_verified());
        setIs_email_verified_cashier(data.getIs_email_verified());
        setU_is_active_cashier(data.getU_is_active());
        setU_image_cashier(data.getU_image());
        setU_position_cashier(data.getU_position());
        setU_nik_cashier(data.getU_nik());
        setCreated_at_cashier(data.getCreated_at());
        setUpdated_at_cashier(data.getUpdated_at());
        setIsCashierOpen(data.getIs_cashier_open());

    }


    public void doLogoutCashier() {
        setLogin(false);
        setOutletDataCashier(new GetLoginCashier.OutletData());
//        setSocmed(new GetLoginCashier.SocialMedia());
        setMerchantDataCashier(new GetLoginCashier.MerchantData());
        setU_id_cashier(0);
        setU_merchant_id_cashier(0);
        setU_outlet_id_cashier(0);
        setU_firstname_cashier("");
        setU_lastname_cashier("");
        setU_email_cashier("");
        setU_dob_cashier("");
        setU_address_cashier("");
        setU_address_alt_cashier("");
        setU_phone_no_cashier("");
        setU_phone_alt_cashier("");
        setU_mobile_no_cashier("");
        setU_mobile_no_alt_cashier("");
        setU_type_cashier(0);
        setU_otp_code_cashier("");
        setU_otp_date_cashier("");
        setIs_otp_verified_cashier(0);
        setIs_email_verified_cashier(0);
        setU_is_active_cashier(0);
        setU_image_cashier("");
        setU_position_cashier("");
        setU_nik_cashier("");
        setCreated_at_cashier("");
        setUpdated_at_cashier("");
        setIsCashierOpen(0);
    }


    public OutletDataCashier getOutletCashier() {
        return new OutletDataCashier();
    }

    public void setOutletDataCashier(GetLoginCashier.OutletData outletCashier) {
        new OutletDataCashier(outletCashier);
    }

    public MerchantDataCashier getMerchantDataCashier() {
        return new MerchantDataCashier();
    }

    public void setMerchantDataCashier(GetLoginCashier.MerchantData merchantCashier) {
        new MerchantDataCashier(merchantCashier);
    }

    public int getU_id_cashier() {
        return getTempsJSONNumber("u_id_cashier");
    }

    public void setU_id_cashier(int u_id_cashier) {
        setTempJSONNumber("u_id_cashier", u_id_cashier);
    }

    public int getU_merchant_id_cashier() {
        return getTempsJSONNumber("u_merchant_id_cashier");
    }

    public void setU_merchant_id_cashier(int u_merchant_id_cashier) {
        setTempJSONNumber("u_merchant_id_cashier", u_merchant_id_cashier);
    }

    public int getU_outlet_id_cashier() {
        return getTempsJSONNumber("u_outlet_id_cashier");
    }

    public void setU_outlet_id_cashier(int u_outlet_id_cashier) {
        setTempJSONNumber("u_outlet_id_cashier", u_outlet_id_cashier);
    }

    public String getU_firstname_cashier() {
        return getTempJson("u_firstname_cashier");
    }

    public void setU_firstname_cashier(String u_firstname_cashier) {
        setTempJson("u_firstname_cashier", u_firstname_cashier);
    }

    public String getU_lastname_cashier() {
        return getTempJson("u_lastname_cashier");
    }

    public void setU_lastname_cashier(String u_lastname_cashier) {
        setTempJson("u_lastname_cashier", u_lastname_cashier);
    }

    public String getU_email_cashier() {
        return getTempJson("u_email_cashier");
    }

    public void setU_email_cashier(String u_email_cashier) {
        setTempJson("u_email_cashier", u_email_cashier);
    }

    public String getU_dob_cashier() {
        return getTempJson("u_dob_cashier");
    }

    public void setU_dob_cashier(String u_dob_cashier) {
        setTempJson("u_dob_cashier", u_dob_cashier);
    }

    public String getU_address_cashier() {
        return getTempJson("u_address_cashier");
    }

    public void setU_address_cashier(String u_address_cashier) {
        setTempJson("u_address_cashier", u_address_cashier);
    }

    public String getU_address_alt_cashier() {
        return getTempJson("u_address_alt_cashier");
    }

    public void setU_address_alt_cashier(String u_address_alt_cashier) {
        setTempJson("u_address_alt_cashier", u_address_alt_cashier);
    }

    public String getU_phone_no_cashier() {
        return getTempJson("u_phone_no_cashier");
    }

    public void setU_phone_no_cashier(String u_address_alt_cashier) {
        setTempJson("u_phone_no_cashier", u_address_alt_cashier);
    }

    public String getU_phone_alt_cashier() {
        return getTempJson("u_phone_alt_cashier");
    }

    public void setU_phone_alt_cashier(String u_phone_alt_cashier) {
        setTempJson("u_phone_alt_cashier", u_phone_alt_cashier);
    }

    public String getU_mobile_no_cashier() {
        return getTempJson("u_mobile_no_cashier");
    }

    public void setU_mobile_no_cashier(String u_mobile_no_cashier) {
        setTempJson("u_mobile_no_cashier", u_mobile_no_cashier);
    }

    public String getU_mobile_no_alt_cashier() {
        return getTempJson("u_mobile_alt_cashier");
    }

    public void setU_mobile_no_alt_cashier(String u_mobile_alt_cashier) {
        setTempJson("u_mobile_alt_cashier", u_mobile_alt_cashier);
    }

    public int getU_type_cashier() {
        return getTempsJSONNumber("u_type_cashier");
    }

    public void setU_type_cashier(int u_type_cashier) {
        setTempJSONNumber("u_type_cashier", u_type_cashier);
    }

    public String getU_otp_code_cashier() {
        return getTempJson("u_otp_code_cashier");
    }

    public void setU_otp_code_cashier(String u_otp_code_cashier) {
        setTempJson("u_otp_code_cashier", u_otp_code_cashier);
    }

    public String getU_otp_date_cashier() {
        return getTempJson("u_otp_date_cashier");
    }

    public void setU_otp_date_cashier(String u_otp_date_cashier) {
        setTempJson("u_otp_date_cashier", u_otp_date_cashier);
    }

    public int getIs_otp_verified_cashier() {
        return getTempsJSONNumber("is_otp_verified_cashier");
    }

    public void setIs_otp_verified_cashier(int is_otp_verified_cashier) {
        setTempJSONNumber("is_otp_verified_cashier", is_otp_verified_cashier);
    }

    public int getIs_email_verified_cashier() {
        return getTempsJSONNumber("is_email_verified_cashier");
    }

    public void setIs_email_verified_cashier(int is_email_verified_cashier) {
        setTempJSONNumber("is_email_verified_cashier", is_email_verified_cashier);
    }

    public int getU_is_active_cashier() {
        return getTempsJSONNumber("u_is_active_cashier");
    }

    public void setU_is_active_cashier(int u_is_active_cashier) {
        setTempJSONNumber("u_is_active_cashier", u_is_active_cashier);
    }

    public String getU_image_cashier() {
        return getTempJson("u_image_cashier");
    }

    public void setU_image_cashier(String u_image_cashier) {
        setTempJson("u_image_cashier", u_image_cashier);
    }

    public String getU_position_cashier() {
        return getTempJson("u_position_cashier");
    }

    public void setU_position_cashier(String u_position_cashier) {
        setTempJson("u_position_cashier", u_position_cashier);
    }

    public String getU_nik_cashier() {
        return getTempJson("u_nik_cashier");
    }

    public void setU_nik_cashier(String u_nik_cashier) {
        setTempJson("u_nik_cashier", u_nik_cashier);
    }

    public String getCreated_at_cashier() {
        return getTempJson("created_at_cashier");
    }

    public void setCreated_at_cashier(String created_at_cashier) {
        setTempJson("created_at_cashier", created_at_cashier);
    }

    public String getUpdated_at_cashier() {
        return getTempJson("updated_at_cashier");
    }

    public void setUpdated_at_cashier(String updated_at_cashier) {
        setTempJson("updated_at_cashier", updated_at_cashier);
    }


    public int getIsCashierOpen() {
        return getTempsJSONNumber("is_cashier_open");
    }

    public void setIsCashierOpen(int isCashierOpen) {
        setTempJSONNumber("is_cashier_open", isCashierOpen);
    }

//    public String getPassword_cashier(){
//        return getTempJson("password");
//    }
//
//    public void setPassword_cashier(String val) {
//        setTempJson("password", val);
//    }

    public String getToken_cashier() {
        return getTempJson("token_cashier");
    }

    public void setToken_cashier(String val) {
        setTempJson("token_cashier", val);
    }


    public static class OutletDataCashier {

        OutletDataCashier(GetLoginCashier.OutletData outletCashier) {
//            setSocialMediaCashier(outletCashier.getSocialMedia());
            setOt_id_cashier(outletCashier.getOt_id());
            setOt_merchant_id_cashier(outletCashier.getOt_merchant_id());
            setOt_name_cashier(outletCashier.getOt_name());
            setOt_address_cashier(outletCashier.getOt_address());
            setOt_address_alt_cashier(outletCashier.getOt_address_alt());
            setOutlet_country_id_cashier(outletCashier.getOutlet_country_id());
            setOutlet_province_id_cashier(outletCashier.getOutlet_province_id());
            setOutlet_city_id_cashier(outletCashier.getOutlet_city_id());
            setOutlet_zip_code_cashier(outletCashier.getOutlet_zip_code());
            setOt_phone_no_cashier(outletCashier.getOt_phone_no());
            setOt_phone_no_alt_cashier(outletCashier.getOt_phone_no_alt());
            setOt_mobile_no_cashier(outletCashier.getOt_mobile_no());
            setOt_mobile_no_alt_cashier(outletCashier.getOt_mobile_no_alt());
            setOt_fax_no_cashier(outletCashier.getOt_fax_no());
            setOt_fax_no_alt_cashier(outletCashier.getOt_fax_no_alt());
            setOt_image_url_cashier(outletCashier.getOt_image_url());
            setOt_is_active_cashier(outletCashier.getOt_is_active());
            setOt_expired_at_cashier(outletCashier.getOt_expired_at());
            setCreated_at_cashier(outletCashier.getCreated_at());
            setUpdated_at_cashier(outletCashier.getUpdated_at());
        }

        public OutletDataCashier() {

        }

//        public SocialMediaCashier getSocialMediaCashier() {
//            return new SocialMediaCashier();
//        }
//
//        public void setSocialMediaCashier(GetLoginCashier.SocialMedia socialMediaCashier){
//            new SocialMediaCashier(socialMediaCashier);
//        }

        public int getOt_id_cashier() {
            return getTempsJSONNumber("ot_id_cashier");
        }

        public void setOt_id_cashier(int ot_id_cashier) {
            setTempJSONNumber("ot_id_cashier", ot_id_cashier);
        }

        public int getOt_merchant_id_cashier() {
            return getTempsJSONNumber("ot_merchant_id_cashier");
        }

        public void setOt_merchant_id_cashier(int ot_merchant_id_cashier) {
            setTempJSONNumber("ot_merchant_id_cashier", ot_merchant_id_cashier);
        }

        public String getOt_name_cashier() {
            return getTempJson("ot_name_cashier");
        }

        public void setOt_name_cashier(String ot_name_cashier) {
            setTempJson("ot_name_cashier", ot_name_cashier);
        }

        public String getOt_address_cashier() {
            return getTempJson("ot_address_cashier");
        }

        public void setOt_address_cashier(String ot_address_cashier) {
            setTempJson("ot_address_cashier", ot_address_cashier);
        }

        public String getOt_address_alt_cashier() {
            return getTempJson("ot_address_alt_cashier");
        }

        public void setOt_address_alt_cashier(String ot_address_alt_cashier) {
            setTempJson("ot_address_alt_cashier", ot_address_alt_cashier);
        }

        public int getOutlet_country_id_cashier() {
            return getTempsJSONNumber("outlet_country_id_cashier");
        }

        public void setOutlet_country_id_cashier(int outlet_country_id_cashier) {
            setTempJSONNumber("outlet_country_id_cashier", outlet_country_id_cashier);
        }

        public int getOutlet_province_id_cashier() {
            return getTempsJSONNumber("outlet_province_id_cashier");
        }

        public void setOutlet_province_id_cashier(int outlet_province_id_cashier) {
            setTempJSONNumber("outlet_province_id_cashier", outlet_province_id_cashier);
        }

        public int getOutlet_city_id_cashier() {
            return getTempsJSONNumber("outlet_city_id_cashier");
        }

        public void setOutlet_city_id_cashier(int outlet_city_id_cashier) {
            setTempJSONNumber("outlet_city_id_cashier", outlet_city_id_cashier);
        }

        public String get0utlet_zip_code_cashier() {
            return getTempJson("outlet_zip_code_cashier");
        }

        public void setOutlet_zip_code_cashier(String outlet_zip_code_cashier) {
            setTempJson("outlet_zip_code_cashier", outlet_zip_code_cashier);
        }

        public String getOt_phone_no_cashier() {
            return getTempJson("ot_phone_no_cashier");
        }

        public void setOt_phone_no_cashier(String ot_phone_no_cashier) {
            setTempJson("ot_phone_no_cashier", ot_phone_no_cashier);
        }

        public String getOt_phone_no_alt_cashier() {
            return getTempJson("ot_phone_no_alt_cashier");
        }

        public void setOt_phone_no_alt_cashier(String ot_phone_no_alt_cashier) {
            setTempJson("ot_phone_no_alt_cashier", ot_phone_no_alt_cashier);
        }

        public String getOt_mobile_no_cashier() {
            return getTempJson("ot_mobile_no_cashier");
        }

        public void setOt_mobile_no_cashier(String ot_mobile_no_cashier) {
            setTempJson("ot_mobile_no_cashier", ot_mobile_no_cashier);
        }

        public String getOt_mobile_no_alt_cashier() {
            return getTempJson("ot_mobile_no_alt_cashier");
        }

        public void setOt_mobile_no_alt_cashier(String ot_mobile_no_alt_cashier) {
            setTempJson("ot_mobile_no_alt_cashier", ot_mobile_no_alt_cashier);
        }

        public String getOt_fax_no_cashier() {
            return getTempJson("ot_fax_no_cashier");
        }

        public void setOt_fax_no_cashier(String ot_fax_no_cashier) {
            setTempJson("ot_fax_no_cashier", ot_fax_no_cashier);
        }

        public String getOt_fax_no_alt_cashier() {
            return getTempJson("ot_fax_no_alt_cashier");
        }

        public void setOt_fax_no_alt_cashier(String ot_fax_no_alt_cashier) {
            setTempJson("ot_fax_no_alt_cashier", ot_fax_no_alt_cashier);
        }


        public String getOt_image_url_cashier() {
            return getTempJson("ot_image_url_cashier");
        }

        public void setOt_image_url_cashier(String ot_image_url_cashier) {
            setTempJson("ot_image_url_cashier", ot_image_url_cashier);
        }

        public int getOt_is_active_cashire() {
            return getTempsJSONNumber("ot_is_active_cashier");
        }

        public void setOt_is_active_cashier(int ot_is_active_cashier) {
            setTempJSONNumber("ot_is_active_cashier", ot_is_active_cashier);
        }

        public String getOt_expired_at_cashire() {
            return getTempJson("ot_expired_at_cashier");
        }

        public void setOt_expired_at_cashier(String ot_expired_at_cashier) {
            setTempJson("ot_expired_at_cashier", ot_expired_at_cashier);
        }

        public String getCreated_at_cashier() {
            return getTempJson("created_at_cashier");
        }

        public void setCreated_at_cashier(String created_at_cashier) {
            setTempJson("created_at_cashier", created_at_cashier);
        }

        public String getUpdated_at_cashier() {
            return getTempJson("updated_at_cashier");
        }

        public void setUpdated_at_cashier(String updated_at_cashier) {
            setTempJson("updated_at_cashier", updated_at_cashier);
        }

    }

    public static class SocialMediaCashier {
        SocialMediaCashier(GetLoginCashier.SocialMedia socialMediaCashier) {
            setFacebookCashier(socialMediaCashier.getFacebook());
            setInstagramCashier(socialMediaCashier.getInstagram());
            setTwitterCashier(socialMediaCashier.getTwitter());
            setYoutubeCashier(socialMediaCashier.getYoutube());
        }

        public SocialMediaCashier() {

        }

        public String getFacebookCashier() {
            return getTempJson("facebook");
        }

        public void setFacebookCashier(String facebookCashier) {
            setTempJson("facebook", facebookCashier);
        }

        public String getInstagramCashier() {
            return getTempJson("instagram");
        }

        public void setInstagramCashier(String instagramCashier) {
            setTempJson("instagram", instagramCashier);
        }

        public String getTwitterCashier() {
            return getTempJson("twitter");
        }

        public void setTwitterCashier(String twitterCashier) {
            setTempJson("twitter", twitterCashier);
        }

        public String getYoutubeCashier() {
            return getTempJson("youtube");
        }

        public void setYoutubeCashier(String youtubeCashier) {
            setTempJson("youtube", youtubeCashier);
        }

    }

    public static class MerchantDataCashier {
        MerchantDataCashier(GetLoginCashier.MerchantData merchantCashier) {
            setMc_id_cashier(merchantCashier.getMc_id());
            setMc_mcat_id_cashier(merchantCashier.getMc_mcat_id());
            setMc_name_cashier(merchantCashier.getMc_name());
            setMc_address_cashier(merchantCashier.getMc_address());
            setMc_address_cashier_alt(merchantCashier.getMc_address_alt());
            setMc_phone_no_cashier(merchantCashier.getMc_phone_no());
            setMc_phone_alt_cashier(merchantCashier.getMc_phone_no_alt());
            setMc_fax_no_cashier(merchantCashier.getMc_fax_no());
            setMc_fax_no_alt_cashier(merchantCashier.getMc_fax_no_alt());
            setMc_trial_expired_cashier(merchantCashier.getMc_trial_expired());
            setMc_is_trial_cashier(merchantCashier.getMc_is_trial());
            setMc_is_active_cashier(merchantCashier.getMc_is_active());
            setCreated_at_cashier(merchantCashier.getCreated_at());
            setUpdated_at_cashier(merchantCashier.getUpdated_at());

        }

        public MerchantDataCashier() {

        }

        public int getMc_id_cashier() {
            return getTempsJSONNumber("mc_id_cashier");
        }

        public void setMc_id_cashier(int mc_id_cashier) {
            setTempJSONNumber("mc_id_cashier", mc_id_cashier);
        }

        public int getMc_mcat_id_cashier() {
            return getTempsJSONNumber("mc_mcat_id_cashier");
        }

        public void setMc_mcat_id_cashier(int mc_mcat_id_cashier) {
            setTempJSONNumber("mc_mcat_id_cashier", mc_mcat_id_cashier);
        }

        public String getMc_name_cashier() {
            return getTempJson("mc_name_cashier");
        }

        public void setMc_name_cashier(String mc_name_cashier) {
            setTempJson("mc_name_cashier", mc_name_cashier);
        }

        public String getMc_address_cashier() {
            return getTempJson("mc_address_cashier");
        }

        public void setMc_address_cashier(String mc_address_cashier) {
            setTempJson("mc_address_cashier", mc_address_cashier);
        }

        public String getMc_address_alt_cashier() {
            return getTempJson("mc_address_alt_cashier");
        }

        public void setMc_address_cashier_alt(String mc_address_alt_cashier) {
            setTempJson("mc_address_alt_cashier", mc_address_alt_cashier);
        }

        public String getMc_phone_no_cashier() {
            return getTempJson("mc_phone_no_cashier");
        }

        public void setMc_phone_no_cashier(String mc_phone_no_cashier) {
            setTempJson("mc_phone_no_cashier", mc_phone_no_cashier);
        }

        public String getMc_phone_alt_cashier() {
            return getTempJson("mc_phone_alt_cashier");
        }

        public void setMc_phone_alt_cashier(String mc_phone_alt_cashier) {
            setTempJson("mc_phone_alt_cashier", mc_phone_alt_cashier);
        }

        public String getMc_fax_no_cashier() {
            return getTempJson("mc_fax_no_cashier");
        }

        public void setMc_fax_no_cashier(String mc_fax_no_cashier) {
            setTempJson("mc_fax_no_cashier", mc_fax_no_cashier);
        }

        public String getMc_fax_no_alt_cashier() {
            return getTempJson("mc_fax_no_alt_cashier");
        }

        public void setMc_fax_no_alt_cashier(String mc_fax_no_alt_cashier) {
            setTempJson("mc_fax_no_alt_cashier", mc_fax_no_alt_cashier);
        }

        public String getMc_trial_expired_cashier() {
            return getTempJson("mc_trial_expired_cashier");
        }

        public void setMc_trial_expired_cashier(String mc_trial_expired_cashier) {
            setTempJson("mc_trial_expired_cashier", mc_trial_expired_cashier);
        }

        public int getMc_is_trial_cashier() {
            return getTempsJSONNumber("mc_is_trial_cashier");
        }

        public void setMc_is_trial_cashier(int mc_is_trial_cashier) {
            setTempJSONNumber("mc_is_trial_cashier", mc_is_trial_cashier);
        }

        public int getMc_is_active_cashier() {
            return getTempsJSONNumber("mc_is_active_cashier");
        }

        public void setMc_is_active_cashier(int mc_is_active_cashier) {
            setTempJSONNumber("mc_is_active_cashier", mc_is_active_cashier);
        }

        public String getCreated_at_cashier() {
            return getTempJson("created_at_cashier");
        }

        public void setCreated_at_cashier(String created_at_cashier) {
            setTempJson("created_at_cashier", created_at_cashier);
        }

        public String getUpdated_at_cashier() {
            return getTempJson("updated_at_cashier");
        }

        public void setUpdated_at_cashier(String updated_at_cashier) {
            setTempJson("updated_at_cashier", updated_at_cashier);
        }
    }

    public String getLastLoginCashire() {
        return getTempJson("LAST_LOGIN_DATE_CASHIER");
    }

    public void setLastLoginCashire(String val) {
        setTempJson("LAST_LOGIN_DATE_CASHIER", val);
    }

    public String getLogoutDurationCashier() {
        return getTempJson("LOGOUT_DURATION_CASHIER");
    }

    public void setLogoutDurationCashier(String val) {
        setTempJson("LOGOUT_DURATION_CASHIER", val);
    }

    public void setOpenCashier(GetOpenCashier.DATAGetOpenCashier dataOpenCashier) {
//        setUserData(dataOpenCashier.getUser());
        setCashierId(dataOpenCashier.getCashier_id());
        setCashierUserId(dataOpenCashier.getCashier_user_id());
        setCashierMerchantId(dataOpenCashier.getCashier_merchant_id());
        setCashierOutletId(dataOpenCashier.getCashier_outlet_id());
        setCashierStartDate(dataOpenCashier.getCashier_start_date());
        setCashierEndDate(dataOpenCashier.getCashier_end_date());
        setCashierModalAwal(dataOpenCashier.getCashier_modal_awal());
        setCashierStatus(dataOpenCashier.getCashier_status());
        setCashierCreatedAt(dataOpenCashier.getCreated_at());
        setCashierUpdatedAt(dataOpenCashier.getUpdated_at());
    }

    public void clearOpenCashier() {
//        setUserData(new GetOpenCashier.UserData());
        setCashierId(0);
        setCashierUserId(0);
        setCashierMerchantId(0);
        setCashierOutletId(0);
        setCashierStartDate("");
        setCashierEndDate("");
        setCashierModalAwal("");
        setCashierStatus(0);
        setCashierCreatedAt("");
        setCashierUpdatedAt("");


    }

//    public UserCashier getUserCashier() {
//        return new UserCashier();
//    }

//    public void setUserData(GetOpenCashier.UserData userData) {
//        new UserCashier(userData);
//    }

    public int getCashierId() {
        return getTempsJSONNumber("cashier_id");
    }

    public void setCashierId(int cashierId) {
        setTempJSONNumber("cashier_id", cashierId);
    }

    public int getCashierUserId() {
        return getTempsJSONNumber("cashier_user_id");
    }

    public void setCashierUserId(int cashierUserId) {
        setTempJSONNumber("cashier_user_id", cashierUserId);
    }

    public int getCashierMerchantId() {
        return getTempsJSONNumber("cashier_merchant_id");
    }

    public void setCashierMerchantId(int cashierMerchantId) {
        setTempJSONNumber("cashier_merchant_id", cashierMerchantId);
    }

    public int getCashierOutletID() {
        return getTempsJSONNumber("cashier_outlet_id");
    }

    public void setCashierOutletId(int cashierOutletId) {
        setTempJSONNumber("cashier_outlet_id", cashierOutletId);
    }

    public String getCashierStartDate() {
        return getTempJson("cashier_start_date");
    }

    public void setCashierStartDate(String cashierStartDate) {
        setTempJson("cashier_start_date", cashierStartDate);
    }

    public String getCashierEndDate() {
        return getTempJson("cashier_end_date");
    }

    public void setCashierEndDate(String cashierEndDate) {
        setTempJson("cashier_end_date", cashierEndDate);
    }

    public String getCashierModalAwal() {
        return getTempJson("cashier_modal_awal");
    }

    public void setCashierModalAwal(String cashierModalAwal) {
        setTempJson("cashier_modal_awal", cashierModalAwal);
    }

    public int getCashierStatus() {
        return getTempsJSONNumber("cashier_status");
    }

    public void setCashierStatus(int cashierStatus) {
        setTempJSONNumber("cashier_status", cashierStatus);
    }

    public String getCreatedAt() {
        return getTempJson("created_at");
    }

    public void setCashierCreatedAt(String cashierCreatedAt) {
        setTempJson("created_at", cashierCreatedAt);
    }

    public String getUpdatedAt() {
        return getTempJson("updated_at");
    }

    public void setCashierUpdatedAt(String updatedAt) {
        setTempJson("updated_at", updatedAt);
    }


    public static class UserCashier {

//        UserCashier(GetOpenCashier.UserData userData) {
//            setUIdOpen(userData.getU_id());
//            setUMerchantId(userData.getU_merchant_id());
//            setUOutletId(userData.getU_outlet_id());
//            setUFirstName(userData.getU_firstname());
//            setULastName(userData.getU_lastname());
//            setUEmail(userData.getU_email());
//            setUPin(userData.getU_pin());
//            setUDob(userData.getU_dob());
//            setUAddress(userData.getU_address());
//            setUAddressAlt(userData.getU_address_alt());
//            setUPhoneNo(userData.getU_phone_no());
//            setUPhoneNoAlt(userData.getU_phone_no_alt());
//            setUMobileNO(userData.getU_mobile_no());
//            setUMobileNoAlt(userData.getU_mobile_no_alt());
//            setUtype(userData.getU_type());
//            setUOtpCode(userData.getU_otp_code());
//            setUOtpDate(userData.getU_otp_date());
//            setUOtpVerified(userData.getIs_otp_verified());
//            setUEmailVerified(userData.getIs_email_verified());
//            setUIsActive(userData.getU_is_active());
//            setUImage(userData.getU_image());
//            setUPosition(userData.getU_position());
//            setUNik(userData.getU_nik());
//            setUCreatedAt(userData.getCreated_at());
//            setUUpdatedAt(userData.getUpdated_at());
//
//        }

        public UserCashier() {

        }

//        public int getUId() {
//            return getTempsJSONNumber("u_id_cashier_open");
//        }
//
//        public void setUIdOpen(int uIdOpen) {
//            setTempJSONNumber("u_id_cashier_open", uIdOpen);
//        }
//
//        public int getUMerchantId() {
//            return getTempsJSONNumber("u_merchant_id_cashier_open");
//        }
//
//        public void setUMerchantId(int uMerchantId) {
//            setTempJSONNumber("u_merchant_id_cashier_open", uMerchantId);
//        }
//
//        public int getUOutletId() {
//            return getTempsJSONNumber("u_outlet_id_cashier_open");
//        }
//
//        public void setUOutletId(int uOutletId) {
//            setTempJSONNumber("u_outlet_id_cashier_open", uOutletId);
//        }
//
//        public String getUFirstname() {
//            return getTempJson("u_firstname_cashier_open");
//        }
//
//        public void setUFirstName(String uFirstName) {
//            setTempJson("u_firstname_cashier_open", uFirstName);
//        }
//
//        public String getULastname() {
//            return getTempJson("u_lastname_cashier");
//        }
//
//        public void setULastName(String uLastName) {
//            setTempJson("u_lastname_cashier", uLastName);
//        }
//
//        public String getUEmail() {
//            return getTempJson("u_email_cashier");
//        }
//
//        public void setUEmail(String u_email) {
//            setTempJson("u_email_cashier", u_email);
//        }
//
//        public int getUPin() {
//            return getTempsJSONNumber("u_pin_cashier_open");
//        }
//
//        public void setUPin(String uPin) {
//            setTempJson("u_pin_cashier_open", uPin);
//        }
//
//        public String getUDob() {
//            return getTempJson("u_dob_cashier_open");
//        }
//
//        public void setUDob(String uDob) {
//            setTempJson("u_dob_cashier_open", uDob);
//        }
//
//        public String getUAddress() {
//            return getTempJson("u_address_cashier_open");
//        }
//
//        public void setUAddress(String uAddress) {
//            setTempJson("u_address_cashier_open", uAddress);
//        }
//
//        public String getUAddressAlt() {
//            return getTempJson("u_address_alt_cashier_open");
//        }
//
//        public void setUAddressAlt(String uAddressAlt) {
//            setTempJson("u_address_alt_cashier_open", uAddressAlt);
//        }
//
//        public String getUPhoneNo() {
//            return getTempJson("u_phone_no_cashier_open");
//        }
//
//        public void setUPhoneNo(String uPhoneNo) {
//            setTempJson("u_phone_no_cashier_open", uPhoneNo);
//        }
//
//        public String getUPhoneNoAlt() {
//            return getTempJson("u_phone_no_alt_cashier_open");
//        }
//
//        public void setUPhoneNoAlt(String phoneNoAlt) {
//            setTempJson("u_phone_no_alt_cashier_open", phoneNoAlt);
//        }
//
//        public String getMobileNo() {
//            return getTempJson("u_mobile_no_cashier_open");
//        }
//
//        public void setUMobileNO(String uMobileNO) {
//            setTempJson("u_mobile_no_cashier_open", uMobileNO);
//        }
//
//        public String getMobileNoAlt() {
//            return getTempJson("u_mobile_no_alt_cashier_open");
//        }
//
//        public void setUMobileNoAlt(String mobileNoAlt) {
//            setTempJson("u_mobile_no_alt_cashier_open", mobileNoAlt);
//        }
//
//        public int getUType() {
//            return getTempsJSONNumber("u_type_cashier_open");
//        }
//
//        public void setUtype(int utype) {
//            setTempJSONNumber("u_type_cashier_open", utype);
//        }
//
//        public String getUOtpCode() {
//            return getTempJson("u_otp_code_cashier_open");
//        }
//
//        public void setUOtpCode(String uOtpCode) {
//            setTempJson("u_otp_code_cashier_open", uOtpCode);
//        }
//
//        public String getUOtpDate() {
//            return getTempJson("u_otp_date_cashier_open");
//        }
//
//        public void setUOtpDate(String uOtpDate) {
//            setTempJson("u_otp_date_cashier_open", uOtpDate);
//        }
//
//        public int getIsOtpVerified() {
//            return getTempsJSONNumber("is_otp_verified_cashier_open");
//        }
//
//        public void setUOtpVerified(int uOtpVerified) {
//            setTempJSONNumber("is_otp_verified_cashier_open", uOtpVerified);
//        }
//
//        public int getIsEmailVerified() {
//            return getTempsJSONNumber("is_email_verified_cashier_open");
//        }
//
//        public void setUEmailVerified(int uEmailVerified) {
//            setTempJSONNumber("is_email_verified_cashier_open", uEmailVerified);
//        }
//
//        public int getUIsActive() {
//            return getTempsJSONNumber("u_is_active_cashier_open");
//        }
//
//        public void setUIsActive(int uIsActive) {
//            setTempJSONNumber("u_is_active_cashier_open", uIsActive);
//        }
//
//        public String getUImage() {
//            return getTempJson("u_image_cashier_open");
//        }
//
//        public void setUImage(String uImage) {
//            setTempJson("u_image_cashier_open", uImage);
//        }
//
//        public String getUPosition() {
//            return getTempJson("u_position_cashier_open");
//        }
//
//        public void setUPosition(String uPosition) {
//            setTempJson("u_position_cashier_open", uPosition);
//        }
//
//        public String getUNik() {
//            return getTempJson("u_nik_cashier_open");
//        }
//
//        public void setUNik(String uNik) {
//            setTempJson("u_nik_cashier_open", uNik);
//        }
//
//        public String getCreatedAt() {
//            return getTempJson("created_at_cashier_open");
//        }
//
//        public void setUCreatedAt(String createdAt) {
//            setTempJson("created_at_cashier_open", createdAt);
//        }
//
//        public String getUpdatedAt() {
//            return getTempJson("created_at_cashier_open");
//        }
//
//        public void setUUpdatedAt(String uUpdatedAt) {
//            setTempJson("created_at_cashier_open", uUpdatedAt);
//        }
//
    }

    public void setRegisterData(GetRegisterStep1.DATAGetRegisterStep1 datareg) {
        setU_email_reg(datareg.getU_email());
        setU_firstname_reg(datareg.getU_firstname());
        setU_is_active_reg(datareg.getU_is_active());
        setU_otp_code_reg(datareg.getU_otp_code());
        setU_otp_date_reg(datareg.getU_otp_date());
        setU_pin_reg(datareg.getU_pin());
        setUpdated_at_reg(datareg.getUpdated_at());
        setCreated_at_reg(datareg.getCreated_at());
        setU_id_reg(datareg.getU_id());
    }

    public String getU_email_reg() {
        return getTempJson("u_email_register");
    }

    public void setU_email_reg(String emailreg) {
        setTempJson("u_email_register", emailreg);
    }

    public String getU_firstname_reg() {
        return getTempJson("u_firstname_register");
    }

    public void setU_firstname_reg(String firstnamereg) {
        setTempJson("u_firstname_register", firstnamereg);
    }

    public int getU_is_active_reg() {
        return getTempsJSONNumber("u_is_active_register");
    }

    public void setU_is_active_reg(int is_active_reg) {
        setTempJSONNumber("u_is_active_register", is_active_reg);
    }

    public String getU_otp_code_reg() {
        return getTempJson("u_otp_code_register");
    }

    public void setU_otp_code_reg(String otpcodereg) {
        setTempJson("u_otp_code_register", otpcodereg);
    }

    public String getU_otp_date_reg() {
        return getTempJson("u_otp_date_register");
    }

    public void setU_otp_date_reg(String otpdatereg) {
        setTempJson("u_otp_date_register", otpdatereg);
    }

    public String getU_pin_reg() {
        return getTempJson("u_pin_register");
    }

    public void setU_pin_reg(String pinreg) {
        setTempJson("u_pin_register", pinreg);
    }

    public String getUpdate_reg() {
        return getTempJson("updated_at_register");
    }

    public void setUpdated_at_reg(String updatedreg) {
        setTempJson("updated_at_register", updatedreg);
    }

    public String getCreated_reg() {
        return getTempJson("created_at_register");
    }

    public void setCreated_at_reg(String createdreg) {
        setTempJson("created_at_register", createdreg);
    }

    public int getU_id_reg() {
        return getTempsJSONNumber("u_id_register");
    }

    public void setU_id_reg(int uidreg) {
        setTempJSONNumber("u_id_register", uidreg);
    }


    public void setInvoiceNumber(GetInvoiceNumber.DATA data) {
        setPromoListData(data.getPromoList());
        setSettingsData(data.getSettings());
        setInvoiceNo(data.getInvoiceNo());
    }

    public void doClearInvoiceNumber() {
        setPromoListData(new GetInvoiceNumber.DATA.PromoItem());
        setSettingsData(new GetInvoiceNumber.DATA.Settings());
        setInvoiceNo("");
    }


    public PromoListData getPromoList() {
        return new PromoListData();
    }

    public void setPromoListData(GetInvoiceNumber.DATA.PromoItem promoListData) {
        new PromoListData(promoListData);
    }

    public SettingsData getSettingData() {
        return new SettingsData();
    }

    public void setSettingsData(GetInvoiceNumber.DATA.Settings settingsData) {
        new SettingsData(settingsData);
    }

    public String getInvoiceNo() {
        return getTempJson("invoice_no");
    }

    public void setInvoiceNo(String invoiceNo) {
        setTempJson("invoice_no", invoiceNo);
    }


    public static class PromoListData {
        PromoListData(GetInvoiceNumber.DATA.PromoItem promoItem) {
            setBasic(promoItem.getBasic());
            setProduct(promoItem.getProduct());
            setPembelian(promoItem.getPembelian());

        }

        public PromoListData() {

        }


        public BasicData getBasicData() {
            return new BasicData();
        }

        public void setBasic(GetInvoiceNumber.DATA.PromoItem.Basic basic) {
            new BasicData(basic);
        }

        public ProductData getProductData() {
            return new ProductData();
        }

        public void setProduct(List<GetInvoiceNumber.DATA.PromoItem.ProductItem> product) {
            new ProductData(product);
        }

        public PembelianData getPembelianData() {
            return new PembelianData();
        }

        public void setPembelian(List<GetInvoiceNumber.DATA.PromoItem.Pembelian> pembelian) {
            new PembelianData(pembelian);
        }

        public static class BasicData {
            BasicData(GetInvoiceNumber.DATA.PromoItem.Basic basic) {
                setPromo_Id(basic.getPromoId());
                setPromo_merchant_id(basic.getPromoMerchantId());
                setPromo_name(basic.getPromoName());
                setPromo_start_date(basic.getPromoStartDate());
                setPromo_end_date(basic.getPromoEndDate());
                setPromo_type(basic.getPromoType());
                setPromo_bonus_type(basic.getPromoBonusType());
                setPromo_value(basic.getPromoValue());
                setPromo_base_type(basic.getPromoBaseType());
                setPromo_min_value(basic.getPromoMinValue());
                setPromo_is_multiple(basic.getPromoIsMultiple());
                setPromo_is_activation(basic.getPromoIsActive());
                setPromo_info(basic.getPromoInfo());
                setPromo_days(basic.getPromoDays());
                setPromo_created_by(basic.getPromoCreatedBy());
                setPromo_updated_by(basic.getPromoUpdatedBy());
                setPromoIsActive(basic.getPromoIsActive());
                setPromoCreated_at(basic.getCreatedAt());
                setPromoUpdated_at(basic.getUpdatedAt());
//                setPromoItems(basic.getPromoItems());
//                setPromoBonus(basic.getPromoBonus());

            }

            public BasicData() {

            }

            public int getPromo_id() {
                return getTempsJSONNumber("promo_id");
            }

            public void setPromo_Id(int promo_id) {
                setTempJSONNumber("promo_id", promo_id);
            }

            public int getPromo_merchant_id() {
                return getTempsJSONNumber("promo_merchant_id");
            }

            public void setPromo_merchant_id(int merchant_id) {
                setTempJSONNumber("promo_merchant_id", merchant_id);
            }

            public String getPromo_name() {
                return getTempJson("promo_name");
            }

            public void setPromo_name(String promo_name) {
                setTempJson("promo_name", promo_name);
            }

            public String getPromo_start_date() {
                return getTempJson("promo_start_date");
            }

            public void setPromo_start_date(String start_date) {
                setTempJson("promo_start_date", start_date);
            }

            public String getPromo_end_date() {
                return getTempJson("promo_end_date");
            }

            public void setPromo_end_date(String end_date) {
                setTempJson("promo_end_date", end_date);
            }

            public int getPromo_type() {
                return getTempsJSONNumber("promo_type");
            }

            public void setPromo_type(int promo_type) {
                setTempJSONNumber("promo_type", promo_type);
            }

            public int getBonus_type() {
                return getTempsJSONNumber("promo_bonus_type");
            }

            public void setPromo_bonus_type(int bonus_type) {
                setTempJSONNumber("promo_bonus_type", bonus_type);
            }

            public String getPromo_value() {
                return getTempJson("promo_value");
            }

            public void setPromo_value(String promo_value) {
                setTempJson("promo_value", promo_value);
            }

            public int getPromo_base_type() {
                return getTempsJSONNumber("promo_base_type");
            }

            public void setPromo_base_type(int promo_base_type) {
                setTempJSONNumber("promo_base_type", promo_base_type);
            }

            public String getPromo_min_value() {
                return getTempJson("promo_min_value");
            }

            public void setPromo_min_value(String min_value) {
                setTempJson("promo_min_value", min_value);
            }

            public int getPromo_is_multiple() {
                return getTempsJSONNumber("promo_is_multiple");
            }

            public void setPromo_is_multiple(int is_multiple) {
                setTempJSONNumber("promo_is_multiple", is_multiple);
            }

            public int getPromo_activation() {
                return getTempsJSONNumber("promo_activation");
            }

            public void setPromo_is_activation(int promo_is_activation) {
                setTempJSONNumber("promo_activation", promo_is_activation);
            }

            public String getPromo_info() {
                return getTempJson("promo_info");
            }

            public void setPromo_info(String promo_info) {
                setTempJson("promo_info", promo_info);
            }

            public String getPromo_days() {
                return getTempJson("promo_days");
            }

            public void setPromo_days(String promo_days) {
                setTempJson("promo_days", promo_days);
            }

            public int getPromo_created_by() {
                return getTempsJSONNumber("promo_created_by");
            }

            public void setPromo_created_by(int promoCreatedBy) {
                setTempJSONNumber("promo_created_by", promoCreatedBy);
            }

            public int getPromo_updated_by() {
                return getTempsJSONNumber("promo_updated_by");
            }

            public void setPromo_updated_by(int promoUpdatedBy) {
                setTempJSONNumber("promo_updated_by", promoUpdatedBy);
            }

            public int getPromo_is_active() {
                return getTempsJSONNumber("promo_is_active");
            }

            public void setPromoIsActive(int promoIsActive) {
                setTempJSONNumber("promo_is_active", promoIsActive);
            }

            public String getCreated_at() {
                return getTempJson("created_at");
            }

            public void setPromoCreated_at(String promoCreatedAt) {
                setTempJson("updated_at", promoCreatedAt);
            }

            public String getUpdated_at() {
                return getTempJson("updated_at");
            }

            public void setPromoUpdated_at(String updated_at) {
                setTempJson("updated_at", updated_at);
            }

        }

        public static class ProductData {
            ProductData(List<GetInvoiceNumber.DATA.PromoItem.ProductItem> productItem) {


            }


            public ProductData() {

            }

        }

        public static class PembelianData {
            PembelianData(List<GetInvoiceNumber.DATA.PromoItem.Pembelian> pembelian) {


            }

            public PembelianData() {

            }
        }
    }

    public static class SettingsData {
        SettingsData(GetInvoiceNumber.DATA.Settings settings) {


        }

        public SettingsData() {

        }
    }


    public void setParamReservation(ParamCreateReservation reservation) {
        setTableReservation(reservation.getTables());
        setResCustomerId(reservation.getCustomerId());
        setResArrivalDate(reservation.getArrivalDate());
        setResArrivalTime(reservation.getArrivalTime());
        setResMergeTables(reservation.getMergeTables());
        setResNumberPeople(reservation.getNumberOfPeople());
        setResNote(reservation.getNote());
        setStatus(reservation.getStatus());
        setResIsReservation(reservation.getIsReservation());
    }

    public void doClearParamReservation() {
        setTableReservation(new ParamCreateReservation().getTables());
        setResCustomerId(0);
        setResArrivalDate("");
        setResArrivalTime("");
        setResMergeTables(0);
        setResNumberPeople(0);
        setResNote("");
        setStatus(0);
        setResIsReservation(0);

    }

    public List<ParamCreateReservation.Table> getTableData() {
        String json = getTempJson("table_id");
        if (json.equals("")) {
            return new ArrayList<>();
        }
        SavedTable savedTable = new Gson().fromJson(json, SavedTable.class);
        return savedTable.getTables();
    }

    public void setTableReservation(List<ParamCreateReservation.Table> table) {
        SavedTable savedTable = new SavedTable();
        savedTable.setTables(table);
        setTempJson("table_id", new Gson().toJson(savedTable));
    }

    public int getCustomerId() {
        return getTempsJSONNumber("customer_id_res");
    }

    public void setResCustomerId(int resCustomerId) {
        setTempJSONNumber("customer_id_res", resCustomerId);
    }

    public String getArrivalDate() {
        return getTempJson("arrival_date_res");
    }

    public void setResArrivalDate(String resArrivalDate) {
        setTempJson("arrival_date_res", resArrivalDate);
    }

    public String getArrivalTime() {
        return getTempJson("arrival_time_res");
    }

    public void setResArrivalTime(String resArrivalTime) {
        setTempJson("arrival_time_res", resArrivalTime);
    }

    public int getMergeTables() {
        return getTempsJSONNumber("merge_tables_res");
    }

    public void setResMergeTables(int resMergeTables) {
        setTempJSONNumber("merge_tables_res", resMergeTables);
    }

    public int getNumberOfPeople() {
        return getTempsJSONNumber("number_of_people_res");
    }

    public void setResNumberPeople(int resNumberPeople) {
        setTempJSONNumber("number_of_people_res", resNumberPeople);
    }

    public String getNote() {
        return getTempJson("note_res");
    }

    public void setResNote(String resNote) {
        setTempJson("note_res", resNote);
    }

    public int getStatusRes() {
        return getTempsJSONNumber("status_res");
    }

    public void setStatus(int status) {
        setTempJSONNumber("status_res", status);
    }

    public int getIsReservation() {
        return getTempsJSONNumber("is_reservation");
    }

    public void setResIsReservation(int isReservation) {
        setTempJSONNumber("is_reservation", isReservation);
    }



  public void setOrderType(GetOrderType.DATA orderType){
        setType_id(orderType.getTypeId());
  }

  public void doClearOrderType() {
        setType_id(0);
  }

  public int getTypeId() {
        return getTempsJSONNumber("type_id");
  }

  public void setType_id(int type_id) {
        setTempJSONNumber("type_id", type_id);
  }

  public void setCustomer(GetCustomer.DATA data){
        setCustomerId(data.getCustId());
  }

  public void clearCustomerId(){
        setCustomerId(0);
  }

  public int getCustomerIdProduct() {
        return getTempsJSONNumber("customer_id");
  }

  public void setCustomerId(int customerId) {
        setTempJSONNumber("customer_id", customerId);
  }


  public void setOrderDetail(GetOrderDetail.DATA dataOrder) {
        setTransId(dataOrder.getTransId());
        setTransCode(dataOrder.getTransCode());
        setTransMerchantId(dataOrder.getTransMerchantId());
        setTransOutletId(dataOrder.getTransOutletId());
        setTransCustomerId(dataOrder.getTransCustomerId());
        setTransTableId(dataOrder.getTransTableId());
        setTransReservationId(dataOrder.getTransReservationId());
        setTransSubtotal(dataOrder.getTransSubtotal());
        setTransTaxType(dataOrder.getTransTaxType());
        setTransTaxValue(dataOrder.getTransTaxValue());
        setTransDiscountType(dataOrder.getTransDiscountType());
        setTransDiscountValue(dataOrder.getTransDiscountValue());
        setTransTotal(dataOrder.getTransTotal());
        setTransServiceCharge(dataOrder.getTransServiceCharge());
        setTransAdditionalFee(dataOrder.getTransAdditionalFee());
        setTransTotalGuest(dataOrder.getTransTotalGuest());
        setTransPaymentMethodId(dataOrder.getTransPaymentMethodId());
        setTransSessid(dataOrder.getTransSessid());
        setTransCashierId(dataOrder.getTransCashierId());
        setTransCreatedBy(dataOrder.getTransCreatedBy());
        setTransUpdatedBy(dataOrder.getTransUpdatedBy());
        setTransDate(dataOrder.getTransDate());
        setTransPaidDate(dataOrder.getTransPaidDate());
        setTransInfo(dataOrder.getTransInfo());
        setTransOrderType(dataOrder.getTransOrderType());
        setTransStatus(dataOrder.getTransStatus());
        setCreatedAt(dataOrder.getCreatedAt());
        setUpdatedAt(dataOrder.getUpdatedAt());
        setServiceChargeValue(dataOrder.getService_charge_value());
        setStatusTxt(dataOrder.getStatusTxt());
        setCashierName(dataOrder.getCashier_name());
        setOrderTypeName(dataOrder.getOrderTypeName());
        setPaymentMethodName(dataOrder.getPayment_method_name());
        setCustomerName(dataOrder.getCustomer_name());
//        setCustomer(dataOrder.getCustomer());
//        setTable(dataOrder.getTable());
//        setTransactionItems(dataOrder.getTransactionItems());

  }

  public void clearOrderDetail() {
        setTransId(0);
        setTransCode("");
        setTransMerchantId(0);
        setTransOutletId(0);
        setTransCustomerId(0);
        setTransTableId(0);
        setTransReservationId(0);
        setTransSubtotal("");
        setTransTaxType("");
        setTransTaxValue("");
        setTransDiscountType("");
        setTransDiscountValue("");
        setTransTotal("");
        setTransServiceCharge("");
        setTransAdditionalFee("");
        setTransTotalGuest(0);
        setTransPaymentMethodId(0);
        setTransSessid("");
        setTransCashierId(0);
        setTransCreatedBy(0);
        setTransUpdatedBy(0);
        setTransDate("");
        setTransPaidDate("");
        setTransInfo("");
        setTransOrderType(0);
        setTransStatus(0);
        setCreatedAt("");
        setUpdatedAt("");
        setServiceChargeValue("");
        setStatusTxt("");
        setCashierName("");
        setOrderTypeName("");
        setPaymentMethodName("");
        setCustomerName("");




  }

  public int getTransId() {
        return getTempsJSONNumber("trans_id");
  }

  public void setTransId(int transId) {
        setTempJSONNumber("trans_id", transId);
  }

  public String getTransCode() {
        return getTempJson("trans_code");
  }

  public void setTransCode(String transCode) {
        setTempJson("trans_code", transCode);
  }

  public int getTransMerchantID() {
        return getTempsJSONNumber("trans_merchant_id");
  }

  public void setTransMerchantId(int transMerchantId) {
        setTempJSONNumber("trans_merchant_id", transMerchantId);
  }

  public int getTransOutletId() {
        return getTempsJSONNumber("trans_outlet_id");
  }

  public void setTransOutletId(int transOutletId) {
        setTempJSONNumber("trans_outlet_id",transOutletId);
  }

  public int getTransCustomerId() {
        return getTempsJSONNumber("trans_customer_id");
  }

  public void setTransCustomerId(int transCustomerId) {
        setTempJSONNumber("trans_customer_id", transCustomerId);
  }

  public int getTransTableId() {
        return getTempsJSONNumber("trans_table_id");
  }

  public void setTransTableId(int transTableId) {
        setTempJSONNumber("trans_table_id", transTableId);
  }

  public int getTransReservationId() {
        return getTempsJSONNumber("trans_reservation_id");
  }

  public void setTransReservationId(int reservationId) {
        setTempJSONNumber("trans_reservation_id", reservationId);
  }

  public String getTransSubTotal() {
        return getTempJson("trans_subtotal");
  }

  public void setTransSubtotal(String transSubTotal) {
        setTempJson("trans_subtotal", transSubTotal);
  }

  public String getTransTaxType() {
        return getTempJson("trans_tax_type");
  }

  public void setTransTaxType(String transTaxType) {
        setTempJson("trans_tax_type", transTaxType);
  }

  public String getTransTaxValue() {
        return getTempJson("trans_tax_value");
  }

  public void setTransTaxValue(String transTaxValue) {
        setTempJson("trans_tax_value", transTaxValue);
  }

  public String getTransDiscountType() {
        return getTempJson("trans_discount_type");
  }

  public void setTransDiscountType(String transDiscountType) {
        setTempJson("trans_discount_type", transDiscountType);
  }

  public String getTransDiscountValue() {
        return getTempJson("trans_discount_value");
  }

  public void setTransDiscountValue(String transDiscountValue) {
        setTempJson("trans_discount_value", transDiscountValue);
  }

  public String getTransTotal() {
        return getTempJson("trans_total");
  }

  public void setTransTotal(String transTotal) {
        setTempJson("trans_total", transTotal);
  }

  public String getTransServiceCharge() {
        return getTempJson("trans_service_charge");
  }

  public void setTransServiceCharge(String serviceCharge) {
        setTempJson("trans_service_charge", serviceCharge);
  }

  public String getTransAdditionalFee() {
        return getTempJson("trans_additional_fee");
  }

  public void setTransAdditionalFee(String transAdditionalFee) {
        setTempJson("trans_additional_fee", transAdditionalFee);
  }

  public int getTransTotalGuest() {
        return getTempsJSONNumber("trans_total_guest");
  }

  public void setTransTotalGuest(int transTotalGuest) {
        setTempJSONNumber("trans_total_guest", transTotalGuest);
  }

  public int getTransPaymentMethodId(){
        return getTempsJSONNumber("trans_payment_method_id");
  }

  public void setTransPaymentMethodId(int paymentMethodId) {
        setTempJSONNumber("trans_payment_method_id", paymentMethodId);
  }

  public String getTransSessid() {
        return getTempJson("trans_sessid");
  }

  public void setTransSessid(String transSessid) {
        setTempJson("setTransSessid", transSessid);
  }

  public int getTransCashierId() {
        return getTempsJSONNumber("trans_cashier_id");
  }

  public void setTransCashierId(int transCashierId) {
        setTempJSONNumber("trans_cashier_id", transCashierId);
  }

  public int getTransCreatedBy() {
        return getTempsJSONNumber("trans_created_by");
  }

  public void setTransCreatedBy(int transCreatedBy) {
        setTempJSONNumber("trans_created_by", transCreatedBy);
  }

  public int getTransUpdatedBy() {
        return getTempsJSONNumber("trans_updated_by");
  }

  public void setTransUpdatedBy(int transUpdatedBy) {
        setTempJSONNumber("trans_updated_by", transUpdatedBy);
  }

  public String getTransDate() {
        return getTempJson("trans_date");
  }

  public void setTransDate(String transDate) {
        setTempJson("trans_date",transDate);
  }

  public String getTransPaidDate() {
        return getTempJson("trans_paid_date");
  }

  public void setTransPaidDate(String transPaidDate) {
        setTempJson("trans_paid_date", transPaidDate);
  }

  public String getTransInfo() {
        return getTempJson("trans_info");
  }

  public void setTransInfo(String transInfo) {
        setTempJson("trans_info", transInfo);
  }

  public int getTransOrderType() {
        return getTempsJSONNumber("trans_order_type");
  }

  public void setTransOrderType(int transOrderType) {
        setTempJSONNumber("trans_order_type", transOrderType);
  }

  public int getTransStatus() {
        return getTempsJSONNumber("trans_status");
  }

  public void setTransStatus(int transStatus) {
        setTempJSONNumber("trans_status", transStatus);
  }

  public String getCreatedAtMeja() {
        return getTempJson("created_at");
  }

  public void setCreatedAt(String createdAt) {
        setTempJson("created_at", createdAt);
  }

  public String getUpdatedAtMeja() {
        return getTempJson("updated_at");
  }

  public void setUpdatedAt(String updatedAt) {
        setTempJson("updated_at", updatedAt);
  }

  public String getServiceChargeValue() {
        return getTempJson("service_charge_value");
  }

  public void setServiceChargeValue(String serviceChargeValue) {
        setTempJson("service_charge_value", serviceChargeValue);
  }

  public String getStatusTxt() {
        return getTempJson("status_txt");
  }

  public void setStatusTxt(String statusTxt) {
        setTempJson("status_txt", statusTxt);
  }

  public String getCashierName() {
        return getTempJson("cashier_name");
  }

  public void setCashierName(String cashierName) {
        setTempJson("cashier_name", cashierName);
  }

  public String getOrderTypeName() {
        return getTempJson("order_type_name");
  }

  public void setOrderTypeName(String orderTypeName) {
        setTempJson("order_type_name", orderTypeName);
  }

  public String getPaymentMethodName() {
        return getTempJson("payment_method_name");
  }

  public void setPaymentMethodName(String paymentMethodName) {
        setTempJson("payment_method_name", paymentMethodName);
  }

  public String getCustomerName() {
        return getTempJson("customer_name");
  }

  public void setCustomerName(String customerName) {
        setTempJson("customer_name", customerName);
  }

//  public TransactionItems getTransactionItems() {
//        return new TransactionItems();
//  }
//
//  public void setTransactionItems()
//



}