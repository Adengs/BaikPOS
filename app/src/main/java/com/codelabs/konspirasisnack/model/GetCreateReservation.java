package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class GetCreateReservation {

    @SerializedName("DATA")
    private DATA DATA;
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;

    public DATA getDATA() {
        return DATA;
    }

    public void setDATA(DATA DATA) {
        this.DATA = DATA;
    }

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

    public static class DATA {
        /**
         * res_code : RES163938878969041
         * res_merchant_id : 5
         * res_outlet_id : 8
         * res_customer_id : 1
         * res_table_merge : 1
         * res_number_of_people : 4
         * res_date : 2020-02-18 11:33:07
         * res_arrival_date : 2020-02-12 08:00
         * res_arrival_time : 08:00
         * res_cashier_id : 9
         * res_created_by : 9
         * res_updated_by : 9
         * res_is_reservation : 0
         * updated_at : 2020-02-18 11:33:07
         * created_at : 2020-02-18 11:33:07
         * res_id : 2
         */

        @SerializedName("res_code")
        private String resCode;
        @SerializedName("res_merchant_id")
        private int resMerchantId;
        @SerializedName("res_outlet_id")
        private int resOutletId;
        @SerializedName("res_customer_id")
        private String resCustomerId;
        @SerializedName("res_table_merge")
        private String resTableMerge;
        @SerializedName("res_number_of_people")
        private String resNumberOfPeople;
        @SerializedName("res_date")
        private String resDate;
        @SerializedName("res_arrival_date")
        private String resArrivalDate;
        @SerializedName("res_arrival_time")
        private String resArrivalTime;
        @SerializedName("res_cashier_id")
        private int resCashierId;
        @SerializedName("res_created_by")
        private int resCreatedBy;
        @SerializedName("res_updated_by")
        private int resUpdatedBy;
        @SerializedName("res_is_reservation")
        private String resIsReservation;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("res_id")
        private int resId;

        public String getResCode() {
            return resCode;
        }

        public void setResCode(String resCode) {
            this.resCode = resCode;
        }

        public int getResMerchantId() {
            return resMerchantId;
        }

        public void setResMerchantId(int resMerchantId) {
            this.resMerchantId = resMerchantId;
        }

        public int getResOutletId() {
            return resOutletId;
        }

        public void setResOutletId(int resOutletId) {
            this.resOutletId = resOutletId;
        }

        public String getResCustomerId() {
            return resCustomerId;
        }

        public void setResCustomerId(String resCustomerId) {
            this.resCustomerId = resCustomerId;
        }

        public String getResTableMerge() {
            return resTableMerge;
        }

        public void setResTableMerge(String resTableMerge) {
            this.resTableMerge = resTableMerge;
        }

        public String getResNumberOfPeople() {
            return resNumberOfPeople;
        }

        public void setResNumberOfPeople(String resNumberOfPeople) {
            this.resNumberOfPeople = resNumberOfPeople;
        }

        public String getResDate() {
            return resDate;
        }

        public void setResDate(String resDate) {
            this.resDate = resDate;
        }

        public String getResArrivalDate() {
            return resArrivalDate;
        }

        public void setResArrivalDate(String resArrivalDate) {
            this.resArrivalDate = resArrivalDate;
        }

        public String getResArrivalTime() {
            return resArrivalTime;
        }

        public void setResArrivalTime(String resArrivalTime) {
            this.resArrivalTime = resArrivalTime;
        }

        public int getResCashierId() {
            return resCashierId;
        }

        public void setResCashierId(int resCashierId) {
            this.resCashierId = resCashierId;
        }

        public int getResCreatedBy() {
            return resCreatedBy;
        }

        public void setResCreatedBy(int resCreatedBy) {
            this.resCreatedBy = resCreatedBy;
        }

        public int getResUpdatedBy() {
            return resUpdatedBy;
        }

        public void setResUpdatedBy(int resUpdatedBy) {
            this.resUpdatedBy = resUpdatedBy;
        }

        public String getResIsReservation() {
            return resIsReservation;
        }

        public void setResIsReservation(String resIsReservation) {
            this.resIsReservation = resIsReservation;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }
    }
}
