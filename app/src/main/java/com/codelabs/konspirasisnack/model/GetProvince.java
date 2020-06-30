package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProvince {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private List<DATAProvince> DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public List<DATAProvince> getDATA() {
        return DATA;
    }

    public static class DATAProvince {
        @Expose
        @SerializedName("province_id")
        private String province_id;
        @Expose
        @SerializedName("province_name")
        private String province_name;

        public String getProvince_id() {
            return province_id;
        }

        public String getProvince_name() {
            return province_name;
        }
    }
}
