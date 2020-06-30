package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReportTutupKasir {

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
        @SerializedName("cashier_id")
        private int cashier_id;
        @SerializedName("cashier_user_id")
        private int cashier_user_id;
        @SerializedName("cashier_merchant_id")
        private int cashier_merchant_id;
        @SerializedName("cashier_outlet_id")
        private int cashier_outlet_id;
        @SerializedName("cashier_start_date")
        private String cashier_start_date;
        @SerializedName("cashier_end_date")
        private String cashier_end_date;
        @SerializedName("cashier_modal_awal")
        private String cashier_modal_awal;
        @SerializedName("cashier_status")
        private int cashier_status;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("kasir_name")
        private String kasir_name;
        @SerializedName("total_income")
        private String total_income;
        @SerializedName("total_refund")
        private String total_refund;
        @SerializedName("grand_total")
        private String grand_total;
        @SerializedName("cashier_status_txt")
        private String cashier_status_txt;

        public int getCashier_id() {
            return cashier_id;
        }

        public void setCashier_id(int cashier_id) {
            this.cashier_id = cashier_id;
        }

        public int getCashier_user_id() {
            return cashier_user_id;
        }

        public void setCashier_user_id(int cashier_user_id) {
            this.cashier_user_id = cashier_user_id;
        }

        public int getCashier_merchant_id() {
            return cashier_merchant_id;
        }

        public void setCashier_merchant_id(int cashier_merchant_id) {
            this.cashier_merchant_id = cashier_merchant_id;
        }

        public int getCashier_outlet_id() {
            return cashier_outlet_id;
        }

        public void setCashier_outlet_id(int cashier_outlet_id) {
            this.cashier_outlet_id = cashier_outlet_id;
        }

        public String getCashier_start_date() {
            return cashier_start_date;
        }

        public void setCashier_start_date(String cashier_start_date) {
            this.cashier_start_date = cashier_start_date;
        }

        public String getCashier_end_date() {
            return cashier_end_date;
        }

        public void setCashier_end_date(String cashier_end_date) {
            this.cashier_end_date = cashier_end_date;
        }

        public String getCashier_modal_awal() {
            return cashier_modal_awal;
        }

        public void setCashier_modal_awal(String cashier_modal_awal) {
            this.cashier_modal_awal = cashier_modal_awal;
        }

        public int getCashier_status() {
            return cashier_status;
        }

        public void setCashier_status(int cashier_status) {
            this.cashier_status = cashier_status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getKasir_name() {
            return kasir_name;
        }

        public void setKasir_name(String kasir_name) {
            this.kasir_name = kasir_name;
        }

        public String getTotal_income() {
            return total_income;
        }

        public void setTotal_income(String total_income) {
            this.total_income = total_income;
        }

        public String getTotal_refund() {
            return total_refund;
        }

        public void setTotal_refund(String total_refund) {
            this.total_refund = total_refund;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public String getCashier_status_txt() {
            return cashier_status_txt;
        }

        public void setCashier_status_txt(String cashier_status_txt) {
            this.cashier_status_txt = cashier_status_txt;
        }
    }
}
