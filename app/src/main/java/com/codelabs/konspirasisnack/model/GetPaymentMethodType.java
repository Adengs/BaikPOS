package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPaymentMethodType {


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
        /**
         * pm_type_id : 1
         * pm_type_name : EDC
         */

        @SerializedName("pm_type_id")
        private int pmTypeId;
        @SerializedName("pm_type_name")
        private String pmTypeName;

        public int getPmTypeId() {
            return pmTypeId;
        }

        public void setPmTypeId(int pmTypeId) {
            this.pmTypeId = pmTypeId;
        }

        public String getPmTypeName() {
            return pmTypeName;
        }

        public void setPmTypeName(String pmTypeName) {
            this.pmTypeName = pmTypeName;
        }
    }
}
