package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKecamatan {
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private List<DATA> DATA;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public List<DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATA> DATA) {
        this.DATA = DATA;
    }

    public static class DATA {
        @SerializedName("subdistrict_id")
        private int subdistrictId;
        @SerializedName("province_id")
        private int provinceId;
        @SerializedName("subdistrict_name")
        private String subdistrictName;

        public int getSubdistrictId() {
            return subdistrictId;
        }

        public void setSubdistrictId(int subdistrictId) {
            this.subdistrictId = subdistrictId;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getSubdistrictName() {
            return subdistrictName;
        }

        public void setSubdistrictName(String subdistrictName) {
            this.subdistrictName = subdistrictName;
        }
    }
}
