package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetEmployee_list {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private List<DATAEmployee> DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public List<DATAEmployee> getDATA() {
        return DATA;
    }

    public static class DATAEmployee {


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
    }
}
