package com.codelabs.konspirasisnack.model;

import com.codelabs.konspirasisnack.helper.DateUtils;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPengaturanPromo {

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

        @SerializedName("promo_id")
        private int promoId;
        @SerializedName("promo_merchant_id")
        private int promoMerchantId;
        @SerializedName("promo_name")
        private String promoName;
        @SerializedName("promo_start_date")
        private String promoStartDate;
        @SerializedName("promo_end_date")
        private String promoEndDate;
        @SerializedName("promo_type")
        private int promoType;
        @SerializedName("promo_bonus_type")
        private int promoBonusType;
        @SerializedName("promo_value")
        private String promoValue;
        @SerializedName("promo_base_type")
        private int promoBaseType;
        @SerializedName("promo_min_value")
        private String promoMinValue;
        @SerializedName("promo_is_multiple")
        private int promoIsMultiple;
        @SerializedName("promo_activation")
        private int promoActivation;
        @SerializedName("promo_info")
        private String promoInfo;
        @SerializedName("promo_days")
        private String promoDays;
        @SerializedName("promo_created_by")
        private int promoCreatedBy;
        @SerializedName("promo_updated_by")
        private int promoUpdatedBy;
        @SerializedName("promo_is_active")
        private int promoIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("deleted_at")
        private String deletedAt;
        @SerializedName("kriteria_txt")
        private String kriteriaTxt;
        @SerializedName("activation_txt")
        private String activationTxt;
        @SerializedName("type_txt")
        private String typeTxt;

        public int getPromoId() {
            return promoId;
        }

        public void setPromoId(int promoId) {
            this.promoId = promoId;
        }

        public int getPromoMerchantId() {
            return promoMerchantId;
        }

        public void setPromoMerchantId(int promoMerchantId) {
            this.promoMerchantId = promoMerchantId;
        }

        public String getPromoName() {
            return promoName;
        }

        public void setPromoName(String promoName) {
            this.promoName = promoName;
        }

        public String getPromoStartDate() {
            return promoStartDate;
        }

        public void setPromoStartDate(String promoStartDate) {
            this.promoStartDate = promoStartDate;
        }

        public String getPromoEndDate() {
            return promoEndDate;
        }

        public void setPromoEndDate(String promoEndDate) {
            this.promoEndDate = promoEndDate;
        }

        public int getPromoType() {
            return promoType;
        }

        public void setPromoType(int promoType) {
            this.promoType = promoType;
        }

        public int getPromoBonusType() {
            return promoBonusType;
        }

        public void setPromoBonusType(int promoBonusType) {
            this.promoBonusType = promoBonusType;
        }

        public String getPromoValue() {
            return promoValue;
        }

        public void setPromoValue(String promoValue) {
            this.promoValue = promoValue;
        }

        public int getPromoBaseType() {
            return promoBaseType;
        }

        public void setPromoBaseType(int promoBaseType) {
            this.promoBaseType = promoBaseType;
        }

        public String getPromoMinValue() {
            return promoMinValue;
        }

        public void setPromoMinValue(String promoMinValue) {
            this.promoMinValue = promoMinValue;
        }

        public int getPromoIsMultiple() {
            return promoIsMultiple;
        }

        public void setPromoIsMultiple(int promoIsMultiple) {
            this.promoIsMultiple = promoIsMultiple;
        }

        public int getPromoActivation() {
            return promoActivation;
        }

        public void setPromoActivation(int promoActivation) {
            this.promoActivation = promoActivation;
        }

        public String getPromoInfo() {
            return promoInfo;
        }

        public void setPromoInfo(String promoInfo) {
            this.promoInfo = promoInfo;
        }

        public String getPromoDays() {
            return promoDays;
        }

        public void setPromoDays(String promoDays) {
            this.promoDays = promoDays;
        }

        public int getPromoCreatedBy() {
            return promoCreatedBy;
        }

        public void setPromoCreatedBy(int promoCreatedBy) {
            this.promoCreatedBy = promoCreatedBy;
        }

        public int getPromoUpdatedBy() {
            return promoUpdatedBy;
        }

        public void setPromoUpdatedBy(int promoUpdatedBy) {
            this.promoUpdatedBy = promoUpdatedBy;
        }

        public int getPromoIsActive() {
            return promoIsActive;
        }

        public void setPromoIsActive(int promoIsActive) {
            this.promoIsActive = promoIsActive;
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

        public String getKriteriaTxt() {
            return kriteriaTxt;
        }

        public void setKriteriaTxt(String kriteriaTxt) {
            this.kriteriaTxt = kriteriaTxt;
        }

        public String getActivationTxt() {
            return activationTxt;
        }

        public String getDurasi(){
            StringBuilder s = new StringBuilder();
            s.append(DateUtils.changeDateFormat(getPromoStartDate(),DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.DATE_FORMAT_MONTH_NAME));
            s.append(" - ");
            s.append(DateUtils.changeDateFormat(getPromoEndDate(),DateUtils.WEB_DATE_TIME_FORMAT,DateUtils.DATE_FORMAT_MONTH_NAME));
            return s.toString();
        }
        public void setActivationTxt(String activationTxt) {
            this.activationTxt = activationTxt;
        }

        public String getTypeTxt() {
            return typeTxt;
        }

        public void setTypeTxt(String typeTxt) {
            this.typeTxt = typeTxt;
        }
    }
}
