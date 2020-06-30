package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPaymentMethod {

    /**
     * DATA : [{"pm_id":1,"pm_merchant_id":0,"pm_outlet_id":0,"pm_name":"Tunai","pm_provider":"","pm_base_type":1,"pm_type":1,"pm_created_by":0,"pm_updated_by":0,"pm_is_active":1,"created_at":"2019-12-18 12:03:33","updated_at":"2020-02-24 11:00:42","pm_type_txt":"Tunai"},{"pm_id":3,"pm_merchant_id":0,"pm_outlet_id":0,"pm_name":"BCA","pm_provider":"BCA","pm_base_type":1,"pm_type":2,"pm_created_by":0,"pm_updated_by":0,"pm_is_active":1,"created_at":"2020-04-15 14:41:26","updated_at":"2020-04-15 14:41:26","pm_type_txt":"Mesin EDC"}]
     * MESSAGE : SUCCESS
     * STATUS : 200
     */

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
         * pm_id : 1
         * pm_merchant_id : 0
         * pm_outlet_id : 0
         * pm_name : Tunai
         * pm_provider :
         * pm_base_type : 1
         * pm_type : 1
         * pm_created_by : 0
         * pm_updated_by : 0
         * pm_is_active : 1
         * created_at : 2019-12-18 12:03:33
         * updated_at : 2020-02-24 11:00:42
         * pm_type_txt : Tunai
         */

        @SerializedName("pm_id")
        private int pmId;
        @SerializedName("pm_merchant_id")
        private int pmMerchantId;
        @SerializedName("pm_outlet_id")
        private int pmOutletId;
        @SerializedName("pm_name")
        private String pmName;
        @SerializedName("pm_code")
        private String pmCode;
        @SerializedName("pm_image")
        private String pmImage;
        @SerializedName("pm_service_charge")
        private String pmServiceCharge;
        @SerializedName("pm_provider")
        private String pmProvider;
        @SerializedName("pm_base_type")
        private int pmBaseType;
        @SerializedName("pm_type")
        private int pmType;
        @SerializedName("pm_created_by")
        private int pmCreatedBy;
        @SerializedName("pm_updated_by")
        private int pmUpdatedBy;
        @SerializedName("pm_is_active")
        private int pmIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("pm_type_txt")
        private String pmTypeTxt;

        public int getPmId() {
            return pmId;
        }

        public void setPmId(int pmId) {
            this.pmId = pmId;
        }

        public int getPmMerchantId() {
            return pmMerchantId;
        }

        public void setPmMerchantId(int pmMerchantId) {
            this.pmMerchantId = pmMerchantId;
        }

        public int getPmOutletId() {
            return pmOutletId;
        }

        public void setPmOutletId(int pmOutletId) {
            this.pmOutletId = pmOutletId;
        }

        public String getPmName() {
            return pmName;
        }

        public void setPmName(String pmName) {
            this.pmName = pmName;
        }

        public String getPmProvider() {
            return pmProvider;
        }

        public void setPmProvider(String pmProvider) {
            this.pmProvider = pmProvider;
        }

        public int getPmBaseType() {
            return pmBaseType;
        }

        public void setPmBaseType(int pmBaseType) {
            this.pmBaseType = pmBaseType;
        }

        public int getPmType() {
            return pmType;
        }

        public void setPmType(int pmType) {
            this.pmType = pmType;
        }

        public int getPmCreatedBy() {
            return pmCreatedBy;
        }

        public void setPmCreatedBy(int pmCreatedBy) {
            this.pmCreatedBy = pmCreatedBy;
        }

        public int getPmUpdatedBy() {
            return pmUpdatedBy;
        }

        public void setPmUpdatedBy(int pmUpdatedBy) {
            this.pmUpdatedBy = pmUpdatedBy;
        }

        public int getPmIsActive() {
            return pmIsActive;
        }

        public void setPmIsActive(int pmIsActive) {
            this.pmIsActive = pmIsActive;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getPmTypeTxt() {
            return pmTypeTxt;
        }

        public void setPmTypeTxt(String pmTypeTxt) {
            this.pmTypeTxt = pmTypeTxt;
        }

        public String getPmCode() {
            return pmCode;
        }

        public void setPmCode(String pmCode) {
            this.pmCode = pmCode;
        }

        public String getPmImage() {
            return pmImage;
        }

        public void setPmImage(String pmImage) {
            this.pmImage = pmImage;
        }

        public String getPmServiceCharge() {
            return pmServiceCharge;
        }

        public void setPmServiceCharge(String pmServiceCharge) {
            this.pmServiceCharge = pmServiceCharge;
        }
    }
}
