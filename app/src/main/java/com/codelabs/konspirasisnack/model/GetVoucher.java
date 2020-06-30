package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVoucher {

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

        @SerializedName("voucher_id")
        private int voucherId;
        @SerializedName("voucher_merchant_id")
        private int voucherMerchantId;
        @SerializedName("voucher_name")
        private String voucherName;
        @SerializedName("voucher_value_type")
        private String voucherValueType;
        @SerializedName("voucher_value")
        private String voucherValue;
        @SerializedName("voucher_is_max_value")
        private int voucherIsMaxValue;
        @SerializedName("voucher_max_value")
        private String voucherMaxValue;
        @SerializedName("voucher_is_acc")
        private int voucherIsAcc;
        @SerializedName("voucher_qty")
        private int voucherQty;
        @SerializedName("voucher_total_used")
        private int voucherTotalUsed;
        @SerializedName("voucher_is_generated")
        private int voucherIsGenerated;
        @SerializedName("voucher_is_unique")
        private int voucherIsUnique;
        @SerializedName("voucher_is_unlimited")
        private int voucherIsUnlimited;
        @SerializedName("voucher_start_date")
        private String voucherStartDate;
        @SerializedName("voucher_end_date")
        private String voucherEndDate;
        @SerializedName("voucher_description")
        private String voucherDescription;
        @SerializedName("voucher_created_by")
        private int voucherCreatedBy;
        @SerializedName("voucher_updated_by")
        private int voucherUpdatedBy;
        @SerializedName("voucher_status")
        private int voucherStatus;
        @SerializedName("voucher_is_active")
        private int voucherIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("deleted_at")
        private String deletedAt;
        @SerializedName("voucher_codes")
        private VoucherCodes voucherCodes;

        public int getVoucherId() {
            return voucherId;
        }

        public void setVoucherId(int voucherId) {
            this.voucherId = voucherId;
        }

        public int getVoucherMerchantId() {
            return voucherMerchantId;
        }

        public void setVoucherMerchantId(int voucherMerchantId) {
            this.voucherMerchantId = voucherMerchantId;
        }

        public String getVoucherName() {
            return voucherName;
        }

        public void setVoucherName(String voucherName) {
            this.voucherName = voucherName;
        }

        public String getVoucherValueType() {
            return voucherValueType;
        }

        public void setVoucherValueType(String voucherValueType) {
            this.voucherValueType = voucherValueType;
        }

        public String getVoucherValue() {
            return voucherValue;
        }

        public void setVoucherValue(String voucherValue) {
            this.voucherValue = voucherValue;
        }

        public int getVoucherIsMaxValue() {
            return voucherIsMaxValue;
        }

        public void setVoucherIsMaxValue(int voucherIsMaxValue) {
            this.voucherIsMaxValue = voucherIsMaxValue;
        }

        public String getVoucherMaxValue() {
            return voucherMaxValue;
        }

        public void setVoucherMaxValue(String voucherMaxValue) {
            this.voucherMaxValue = voucherMaxValue;
        }

        public int getVoucherIsAcc() {
            return voucherIsAcc;
        }

        public void setVoucherIsAcc(int voucherIsAcc) {
            this.voucherIsAcc = voucherIsAcc;
        }

        public int getVoucherQty() {
            return voucherQty;
        }

        public void setVoucherQty(int voucherQty) {
            this.voucherQty = voucherQty;
        }

        public int getVoucherTotalUsed() {
            return voucherTotalUsed;
        }

        public void setVoucherTotalUsed(int voucherTotalUsed) {
            this.voucherTotalUsed = voucherTotalUsed;
        }

        public int getVoucherIsGenerated() {
            return voucherIsGenerated;
        }

        public void setVoucherIsGenerated(int voucherIsGenerated) {
            this.voucherIsGenerated = voucherIsGenerated;
        }

        public int getVoucherIsUnique() {
            return voucherIsUnique;
        }

        public void setVoucherIsUnique(int voucherIsUnique) {
            this.voucherIsUnique = voucherIsUnique;
        }

        public int getVoucherIsUnlimited() {
            return voucherIsUnlimited;
        }

        public void setVoucherIsUnlimited(int voucherIsUnlimited) {
            this.voucherIsUnlimited = voucherIsUnlimited;
        }

        public String getVoucherStartDate() {
            return voucherStartDate;
        }

        public void setVoucherStartDate(String voucherStartDate) {
            this.voucherStartDate = voucherStartDate;
        }

        public String getVoucherEndDate() {
            return voucherEndDate;
        }

        public void setVoucherEndDate(String voucherEndDate) {
            this.voucherEndDate = voucherEndDate;
        }

        public String getVoucherDescription() {
            return voucherDescription;
        }

        public void setVoucherDescription(String voucherDescription) {
            this.voucherDescription = voucherDescription;
        }

        public int getVoucherCreatedBy() {
            return voucherCreatedBy;
        }

        public void setVoucherCreatedBy(int voucherCreatedBy) {
            this.voucherCreatedBy = voucherCreatedBy;
        }

        public int getVoucherUpdatedBy() {
            return voucherUpdatedBy;
        }

        public void setVoucherUpdatedBy(int voucherUpdatedBy) {
            this.voucherUpdatedBy = voucherUpdatedBy;
        }

        public int getVoucherStatus() {
            return voucherStatus;
        }

        public void setVoucherStatus(int voucherStatus) {
            this.voucherStatus = voucherStatus;
        }

        public int getVoucherIsActive() {
            return voucherIsActive;
        }

        public void setVoucherIsActive(int voucherIsActive) {
            this.voucherIsActive = voucherIsActive;
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

        public String getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
        }

        public VoucherCodes getVoucherCodes() {
            return voucherCodes;
        }

        public void setVoucherCodes(VoucherCodes voucherCodes) {
            this.voucherCodes = voucherCodes;
        }

        public static class VoucherCodes {


            @SerializedName("vc_voucher_id")
            private int vcVoucherId;
            @SerializedName("vc_code")
            private String vcCode;

            public int getVcVoucherId() {
                return vcVoucherId;
            }

            public void setVcVoucherId(int vcVoucherId) {
                this.vcVoucherId = vcVoucherId;
            }

            public String getVcCode() {
                return vcCode;
            }

            public void setVcCode(String vcCode) {
                this.vcCode = vcCode;
            }
        }
    }
}
