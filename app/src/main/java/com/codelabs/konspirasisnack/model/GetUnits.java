package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUnits {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private List<DATAUnits> DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public List<DATAUnits> getDATA() {
        return DATA;
    }


    public static class DATAUnits {
        @Expose
        @SerializedName("unit_id")
        private int unit_id;
        @Expose
        @SerializedName("unit_name")
        private String unit_name;
        @Expose
        @SerializedName("unit_code")
        private String unit_code;
        @Expose
        @SerializedName("unit_is_active")
        private int unit_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        public int getUnit_id() {
            return unit_id;
        }

        public String getUnit_name() {
            return unit_name;
        }

        public String getUnit_code() {
            return unit_code;
        }

        public int getUnit_is_active() {
            return unit_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
