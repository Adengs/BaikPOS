package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLoginCashier {
    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAGetLoginCashier DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAGetLoginCashier getDATA() {
        return DATA;
    }


    public static class DATAGetLoginCashier{
        @Expose
        @SerializedName("user")
        private UserData user;
        @Expose
        @SerializedName("token")
        private String token;
        @Expose
        @SerializedName("logout_duration")
        private String logout_duration;

        public UserData getUser() {
            return user;
        }

        public String getTokenCashier() {
            return token;
        }

        public String getLogout_duration_cashier() {
            return logout_duration;
        }
    }

    public static class UserData {
        @Expose
        @SerializedName("outlet")
        private OutletData outlet;
        @Expose
        @SerializedName("merchant")
        private MerchantData merchant;
        @Expose
        @SerializedName("u_id")
        private int u_id;
        @Expose
        @SerializedName("u_merchant_id")
        private int u_merchant_id;
        @Expose
        @SerializedName("u_outlet_id")
        private int u_outlet_id;
        @Expose
        @SerializedName("u_firstname")
        private String u_firstname;
        @Expose
        @SerializedName("u_lastname")
        private String u_lastname;
        @Expose
        @SerializedName("u_email")
        private String u_email;
        @Expose
        @SerializedName("u_dob")
        private String u_dob;
        @Expose
        @SerializedName("u_address")
        private String u_address;
        @Expose
        @SerializedName("u_address_alt")
        private String u_address_alt;
        @Expose
        @SerializedName("u_phone_no")
        private String u_phone_no;
        @Expose
        @SerializedName("u_phone_no_alt")
        private String u_phone_no_alt;
        @Expose
        @SerializedName("u_mobile_no")
        private String u_mobile_no;
        @Expose
        @SerializedName("u_mobile_no_alt")
        private String u_mobile_no_alt;
        @Expose
        @SerializedName("u_type")
        private int u_type;
        @Expose
        @SerializedName("u_otp_code")
        private String u_otp_code;
        @Expose
        @SerializedName("u_otp_date")
        private String u_otp_date;
        @Expose
        @SerializedName("is_otp_verified")
        private int is_otp_verified;
        @Expose
        @SerializedName("is_email_verified")
        private int is_email_verified;
        @Expose
        @SerializedName("u_is_active")
        private int u_is_active;
        @Expose
        @SerializedName("u_image")
        private String u_image;
        @Expose
        @SerializedName("u_position")
        private String u_position;
        @Expose
        @SerializedName("u_nik")
        private String u_nik;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("is_cashier_open")
        private int is_cashier_open;



        public OutletData getOutlet() {
            return outlet;
        }

        public MerchantData getMerchant() {
            return merchant;
        }

        public int getU_id() {
            return u_id;
        }

        public int getU_merchant_id() {
            return u_merchant_id;
        }

        public int getU_outlet_id() {
            return u_outlet_id;
        }

        public String getU_firstname() {
            return u_firstname;
        }

        public String getU_lastname() {
            return u_lastname;
        }

        public String getU_email() {
            return u_email;
        }

        public String getU_dob() {
            return u_dob;
        }

        public String getU_address() {
            return u_address;
        }

        public String getU_address_alt() {
            return u_address_alt;
        }

        public String getU_phone_no() {
            return u_phone_no;
        }

        public String getU_phone_no_alt() {
            return u_phone_no_alt;
        }

        public String getU_mobile_no() {
            return u_mobile_no;
        }

        public String getU_mobile_no_alt() {
            return u_mobile_no_alt;
        }

        public int getU_type() {
            return u_type;
        }

        public String getU_otp_code() {
            return u_otp_code;
        }

        public String getU_otp_date() {
            return u_otp_date;
        }

        public int getIs_otp_verified() {
            return is_otp_verified;
        }

        public int getIs_email_verified() {
            return is_email_verified;
        }

        public int getU_is_active() {
            return u_is_active;
        }

        public String getU_image() {
            return u_image;
        }

        public String getU_position() {
            return u_position;
        }

        public String getU_nik() {
            return u_nik;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public int getIs_cashier_open() {
            return is_cashier_open;
        }
    }

    public static class OutletData {
        @Expose
        @SerializedName("ot_social_media")
        private SocialMedia socialMedia;
        @Expose
        @SerializedName("ot_id")
        private int ot_id;
        @Expose
        @SerializedName("ot_merchant_id")
        private int ot_merchant_id;
        @Expose
        @SerializedName("ot_name")
        private String ot_name;
        @Expose
        @SerializedName("ot_address")
        private String ot_address;
        @Expose
        @SerializedName("ot_address_alt")
        private String ot_address_alt;
        @Expose
        @SerializedName("outlet_country_id")
        private int outlet_country_id;
        @Expose
        @SerializedName("outlet_province_id")
        private int outlet_province_id;
        @Expose
        @SerializedName("outlet_city_id")
        private int outlet_city_id;
        @Expose
        @SerializedName("outlet_zip_code")
        private String outlet_zip_code;
        @Expose
        @SerializedName("ot_phone_no")
        private String ot_phone_no;
        @Expose
        @SerializedName("ot_phone_no_alt")
        private String ot_phone_no_alt;
        @Expose
        @SerializedName("ot_mobile_no")
        private String ot_mobile_no;
        @Expose
        @SerializedName("ot_mobile_no_alt")
        private String ot_mobile_no_alt;
        @Expose
        @SerializedName("ot_fax_no")
        private String ot_fax_no;
        @Expose
        @SerializedName("ot_fax_no_alt")
        private String ot_fax_no_alt;
        @Expose
        @SerializedName("ot_image_url")
        private String ot_image_url;
        @Expose
        @SerializedName("ot_is_active")
        private int ot_is_active;
        @Expose
        @SerializedName("ot_expired_at")
        private String ot_expired_at;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;


        public SocialMedia getSocialMedia() {
            return socialMedia;
        }

        public int getOt_id() {
            return ot_id;
        }

        public int getOt_merchant_id() {
            return ot_merchant_id;
        }

        public String getOt_name() {
            return ot_name;
        }

        public String getOt_address() {
            return ot_address;
        }

        public String getOt_address_alt() {
            return ot_address_alt;
        }

        public int getOutlet_country_id() {
            return outlet_country_id;
        }

        public int getOutlet_province_id() {
            return outlet_province_id;
        }

        public int getOutlet_city_id() {
            return outlet_city_id;
        }

        public String getOutlet_zip_code() {
            return outlet_zip_code;
        }

        public String getOt_phone_no() {
            return ot_phone_no;
        }

        public String getOt_phone_no_alt() {
            return ot_phone_no_alt;
        }

        public String getOt_mobile_no() {
            return ot_mobile_no;
        }

        public String getOt_mobile_no_alt() {
            return ot_mobile_no_alt;
        }

        public String getOt_fax_no() {
            return ot_fax_no;
        }

        public String getOt_fax_no_alt() {
            return ot_fax_no_alt;
        }


        public String getOt_image_url() {
            return ot_image_url;
        }

        public int getOt_is_active() {
            return ot_is_active;
        }

        public String getOt_expired_at() {
            return ot_expired_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

    }

    public static class SocialMedia {
        @Expose
        @SerializedName("facebook")
        private String facebook;
        @Expose
        @SerializedName("instagram")
        private String instagram;
        @Expose
        @SerializedName("twitter")
        private String twitter;
        @Expose
        @SerializedName("youtube")
        private String youtube;

        public String getFacebook() {
            return facebook;
        }

        public String getInstagram() {
            return instagram;
        }

        public String getTwitter() {
            return twitter;
        }

        public String getYoutube() {
            return youtube;
        }
    }

    public static class MerchantData {
        @Expose
        @SerializedName("mc_id")
        private int mc_id;
        @Expose
        @SerializedName("mc_mcat_id")
        private int mc_mcat_id;
        @Expose
        @SerializedName("mc_name")
        private String mc_name;
        @Expose
        @SerializedName("mc_address")
        private String mc_address;
        @Expose
        @SerializedName("mc_address_alt")
        private String mc_address_alt;
        @Expose
        @SerializedName("mc_phone_no")
        private String mc_phone_no;
        @Expose
        @SerializedName("mc_phone_no_alt")
        private String mc_phone_no_alt;
        @Expose
        @SerializedName("mc_fax_no")
        private String mc_fax_no;
        @Expose
        @SerializedName("mc_fax_no_alt")
        private String mc_fax_no_alt;
        @Expose
        @SerializedName("mc_trial_expired")
        private String mc_trial_expired;
        @Expose
        @SerializedName("mc_is_trial")
        private int mc_is_trial;
        @Expose
        @SerializedName("mc_is_active")
        private int mc_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;


        public int getMc_id() {
            return mc_id;
        }

        public int getMc_mcat_id() {
            return mc_mcat_id;
        }

        public String getMc_name() {
            return mc_name;
        }

        public String getMc_address() {
            return mc_address;
        }

        public String getMc_address_alt() {
            return mc_address_alt;
        }

        public String getMc_phone_no() {
            return mc_phone_no;
        }

        public String getMc_phone_no_alt() {
            return mc_phone_no_alt;
        }

        public String getMc_fax_no() {
            return mc_fax_no;
        }

        public String getMc_fax_no_alt() {
            return mc_fax_no_alt;
        }

        public String getMc_trial_expired() {
            return mc_trial_expired;
        }

        public int getMc_is_trial() {
            return mc_is_trial;
        }

        public int getMc_is_active() {
            return mc_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
