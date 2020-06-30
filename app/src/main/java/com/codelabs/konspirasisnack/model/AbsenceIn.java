package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbsenceIn {
    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAAbsence DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAAbsence getDATA() {
        return DATA;
    }


    public static class DATAAbsence{
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

        public void setU_id(int u_id) {
            this.u_id = u_id;
        }

        public int getU_merchant_id() {
            return u_merchant_id;
        }

        public void setU_merchant_id(int u_merchant_id) {
            this.u_merchant_id = u_merchant_id;
        }

        public int getU_outlet_id() {
            return u_outlet_id;
        }

        public void setU_outlet_id(int u_outlet_id) {
            this.u_outlet_id = u_outlet_id;
        }

        public String getU_firstname() {
            return u_firstname;
        }

        public void setU_firstname(String u_firstname) {
            this.u_firstname = u_firstname;
        }

        public String getU_lastname() {
            return u_lastname;
        }

        public void setU_lastname(String u_lastname) {
            this.u_lastname = u_lastname;
        }

        public String getU_email() {
            return u_email;
        }

        public void setU_email(String u_email) {
            this.u_email = u_email;
        }

        public String getU_dob() {
            return u_dob;
        }

        public void setU_dob(String u_dob) {
            this.u_dob = u_dob;
        }

        public String getU_address() {
            return u_address;
        }

        public void setU_address(String u_address) {
            this.u_address = u_address;
        }

        public String getU_address_alt() {
            return u_address_alt;
        }

        public void setU_address_alt(String u_address_alt) {
            this.u_address_alt = u_address_alt;
        }

        public String getU_phone_no() {
            return u_phone_no;
        }

        public void setU_phone_no(String u_phone_no) {
            this.u_phone_no = u_phone_no;
        }

        public String getU_phone_no_alt() {
            return u_phone_no_alt;
        }

        public void setU_phone_no_alt(String u_phone_no_alt) {
            this.u_phone_no_alt = u_phone_no_alt;
        }

        public String getU_mobile_no() {
            return u_mobile_no;
        }

        public void setU_mobile_no(String u_mobile_no) {
            this.u_mobile_no = u_mobile_no;
        }

        public String getU_mobile_no_alt() {
            return u_mobile_no_alt;
        }

        public void setU_mobile_no_alt(String u_mobile_no_alt) {
            this.u_mobile_no_alt = u_mobile_no_alt;
        }

        public int getU_type() {
            return u_type;
        }

        public void setU_type(int u_type) {
            this.u_type = u_type;
        }

        public String getU_otp_code() {
            return u_otp_code;
        }

        public void setU_otp_code(String u_otp_code) {
            this.u_otp_code = u_otp_code;
        }

        public String getU_otp_date() {
            return u_otp_date;
        }

        public void setU_otp_date(String u_otp_date) {
            this.u_otp_date = u_otp_date;
        }

        public int getIs_otp_verified() {
            return is_otp_verified;
        }

        public void setIs_otp_verified(int is_otp_verified) {
            this.is_otp_verified = is_otp_verified;
        }

        public int getIs_email_verified() {
            return is_email_verified;
        }

        public void setIs_email_verified(int is_email_verified) {
            this.is_email_verified = is_email_verified;
        }

        public int getU_is_active() {
            return u_is_active;
        }

        public void setU_is_active(int u_is_active) {
            this.u_is_active = u_is_active;
        }

        public String getU_image() {
            return u_image;
        }

        public void setU_image(String u_image) {
            this.u_image = u_image;
        }

        public String getU_position() {
            return u_position;
        }

        public void setU_position(String u_position) {
            this.u_position = u_position;
        }

        public String getU_nik() {
            return u_nik;
        }

        public void setU_nik(String u_nik) {
            this.u_nik = u_nik;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
