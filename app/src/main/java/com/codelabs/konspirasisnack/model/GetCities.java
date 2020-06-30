package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCities {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private List<DATACities> DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public List<DATACities> getDATA() {
        return DATA;
    }


    public static class DATACities{
        @Expose
        @SerializedName("regency_id")
        private String regency_id;
        @Expose
        @SerializedName("regency_province_id")
        private String regency_province_id;
        @Expose
        @SerializedName("regency_name")
        private String regency_name;

        public String getRegency_id() {
            return regency_id;
        }

        public String getRegency_province_id() {
            return regency_province_id;
        }

        public String getRegency_name() {
            return regency_name;
        }
    }
}
