package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPengaturanVoucher {

    @SerializedName("DATA")
    private List<DATA> data;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("STATUS")
    private Integer status;

    public List<DATA> getData() {
        return data;
    }

    public void setData(List<DATA> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public class DATA {
        @SerializedName("voucher_id")
        private Integer voucherId;
        @SerializedName("voucher_merchant_id")
        private Integer voucherMerchantId;
        @SerializedName("voucher_name")
        private String voucherName;
        @SerializedName("voucher_code")
        private String voucherCode;
        @SerializedName("voucher_value_type")
        private String voucherValueType;
        @SerializedName("voucher_value")
        private String voucherValue;
        @SerializedName("voucher_is_max_value")
        private Integer voucherIsMaxValue;
        @SerializedName("voucher_max_value")
        private String voucherMaxValue;
        @SerializedName("voucher_is_acc")
        private Integer voucherIsAcc;
        @SerializedName("voucher_qty")
        private Integer voucherQty;
        @SerializedName("voucher_total_used")
        private Integer voucherTotalUsed;
        @SerializedName("voucher_is_generated")
        private Integer voucherIsGenerated;
        @SerializedName("voucher_is_unique")
        private Integer voucherIsUnique;
        @SerializedName("voucher_is_unlimited")
        private Integer voucherIsUnlimited;
        @SerializedName("voucher_start_date")
        private String voucherStartDate;
        @SerializedName("voucher_end_date")
        private String voucherEndDate;
        @SerializedName("voucher_description")
        private String voucherDescription;
        @SerializedName("voucher_image")
        private String voucherImage;
        @SerializedName("voucher_created_by")
        private Integer voucherCreatedBy;
        @SerializedName("voucher_updated_by")
        private Integer voucherUpdatedBy;
        @SerializedName("voucher_status")
        private Integer voucherStatus;
        @SerializedName("voucher_is_active")
        private Integer voucherIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("deleted_at")
        private String deletedAt;
        @SerializedName("voucher_codes")
        private VoucherCodes voucherCodes;

        public Integer getVoucherId() {
            return voucherId;
        }

        public void setVoucherId(Integer voucherId) {
            this.voucherId = voucherId;
        }

        public Integer getVoucherMerchantId() {
            return voucherMerchantId;
        }

        public void setVoucherMerchantId(Integer voucherMerchantId) {
            this.voucherMerchantId = voucherMerchantId;
        }

        public String getVoucherName() {
            return voucherName;
        }

        public void setVoucherName(String voucherName) {
            this.voucherName = voucherName;
        }

        public String getVoucherCode() {
            return voucherCode;
        }

        public void setVoucherCode(String voucherCode) {
            this.voucherCode = voucherCode;
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

        public Integer getVoucherIsMaxValue() {
            return voucherIsMaxValue;
        }

        public void setVoucherIsMaxValue(Integer voucherIsMaxValue) {
            this.voucherIsMaxValue = voucherIsMaxValue;
        }

        public String getVoucherMaxValue() {
            return voucherMaxValue;
        }

        public void setVoucherMaxValue(String voucherMaxValue) {
            this.voucherMaxValue = voucherMaxValue;
        }

        public Integer getVoucherIsAcc() {
            return voucherIsAcc;
        }

        public void setVoucherIsAcc(Integer voucherIsAcc) {
            this.voucherIsAcc = voucherIsAcc;
        }

        public Integer getVoucherQty() {
            return voucherQty;
        }

        public void setVoucherQty(Integer voucherQty) {
            this.voucherQty = voucherQty;
        }

        public Integer getVoucherTotalUsed() {
            return voucherTotalUsed;
        }

        public void setVoucherTotalUsed(Integer voucherTotalUsed) {
            this.voucherTotalUsed = voucherTotalUsed;
        }

        public Integer getVoucherIsGenerated() {
            return voucherIsGenerated;
        }

        public void setVoucherIsGenerated(Integer voucherIsGenerated) {
            this.voucherIsGenerated = voucherIsGenerated;
        }

        public Integer getVoucherIsUnique() {
            return voucherIsUnique;
        }

        public void setVoucherIsUnique(Integer voucherIsUnique) {
            this.voucherIsUnique = voucherIsUnique;
        }

        public Integer getVoucherIsUnlimited() {
            return voucherIsUnlimited;
        }

        public void setVoucherIsUnlimited(Integer voucherIsUnlimited) {
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

        public String getVoucherImage() {
            return voucherImage;
        }

        public void setVoucherImage(String voucherImage) {
            this.voucherImage = voucherImage;
        }

        public Integer getVoucherCreatedBy() {
            return voucherCreatedBy;
        }

        public void setVoucherCreatedBy(Integer voucherCreatedBy) {
            this.voucherCreatedBy = voucherCreatedBy;
        }

        public Integer getVoucherUpdatedBy() {
            return voucherUpdatedBy;
        }

        public void setVoucherUpdatedBy(Integer voucherUpdatedBy) {
            this.voucherUpdatedBy = voucherUpdatedBy;
        }

        public Integer getVoucherStatus() {
            return voucherStatus;
        }

        public void setVoucherStatus(Integer voucherStatus) {
            this.voucherStatus = voucherStatus;
        }

        public Integer getVoucherIsActive() {
            return voucherIsActive;
        }

        public void setVoucherIsActive(Integer voucherIsActive) {
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
    }


    public class VoucherCodes {
        @SerializedName("vc_voucher_id")
        private Integer vcVoucherId;
        @SerializedName("vc_code")
        private String vcCode;

        public Integer getVcVoucherId() {
            return vcVoucherId;
        }

        public void setVcVoucherId(Integer vcVoucherId) {
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
