package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRegisterStep1 {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAGetRegisterStep1 DATA;


    public String getMESSAGE() {
        return MESSAGE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public DATAGetRegisterStep1 getDATA() {
        return DATA;
    }

    public static class DATAGetRegisterStep1{
        @Expose
        @SerializedName("u_email")
        private String u_email;
        @Expose
        @SerializedName("u_firstname")
        private String u_firstname;
        @Expose
        @SerializedName("u_is_active")
        private int u_is_active;
        @Expose
        @SerializedName("u_otp_code")
        private String u_otp_code;
        @Expose
        @SerializedName("u_otp_date")
        private String u_otp_date;
        @Expose
        @SerializedName("u_pin")
        private String u_pin;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("u_id")
        private int u_id;


        public String getU_email() {
            return u_email;
        }

        public String getU_firstname() {
            return u_firstname;
        }

        public int getU_is_active() {
            return u_is_active;
        }

        public String getU_otp_code() {
            return u_otp_code;
        }

        public String getU_otp_date() {
            return u_otp_date;
        }

        public String getU_pin() {
            return u_pin;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public int getU_id() {
            return u_id;
        }
    }
}
