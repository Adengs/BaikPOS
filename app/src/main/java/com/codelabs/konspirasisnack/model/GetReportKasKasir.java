package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReportKasKasir {

    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private DATAReportKas DATA;


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

    public DATAReportKas getDATA() {
        return DATA;
    }

    public void setDATA(DATAReportKas DATA) {
        this.DATA = DATA;
    }

    public static class DATAReportKas{

        @SerializedName("data")
        private List<DataKasir> dataKasir;
        @SerializedName("total")
        private String total;
        @SerializedName("total_in")
        private String total_in;
        @SerializedName("total_out")
        private String total_out;

        public List<DataKasir> getDataKasir() {
            return dataKasir;
        }

        public void setDataKasir(List<DataKasir> dataKasir) {
            this.dataKasir = dataKasir;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotal_in() {
            return total_in;
        }

        public void setTotal_in(String total_in) {
            this.total_in = total_in;
        }

        public String getTotal_out() {
            return total_out;
        }

        public void setTotal_out(String total_out) {
            this.total_out = total_out;
        }
    }

    public static class DataKasir {
        @SerializedName("tc_id")
        private int tc_id;
        @SerializedName("tc_op_cashier_id")
        private int tc_op_cashier_id;
        @SerializedName("tc_user_id")
        private int tc_user_id;
        @SerializedName("tc_name")
        private String tc_name;
        @SerializedName("tc_amount")
        private String tc_amount;
        @SerializedName("tc_type")
        private int tc_type;
        @SerializedName("tc_cash_type")
        private int tc_cash_type;
        @SerializedName("tc_info")
        private String tc_info;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("cash_in")
        private String cash_in;
        @SerializedName("cash_out")
        private String cash_out;

        public int getTc_id() {
            return tc_id;
        }

        public void setTc_id(int tc_id) {
            this.tc_id = tc_id;
        }

        public int getTc_op_cashier_id() {
            return tc_op_cashier_id;
        }

        public void setTc_op_cashier_id(int tc_op_cashier_id) {
            this.tc_op_cashier_id = tc_op_cashier_id;
        }

        public int getTc_user_id() {
            return tc_user_id;
        }

        public void setTc_user_id(int tc_user_id) {
            this.tc_user_id = tc_user_id;
        }

        public String getTc_name() {
            return tc_name;
        }

        public void setTc_name(String tc_name) {
            this.tc_name = tc_name;
        }

        public String getTc_amount() {
            return tc_amount;
        }

        public void setTc_amount(String tc_amount) {
            this.tc_amount = tc_amount;
        }

        public int getTc_type() {
            return tc_type;
        }

        public void setTc_type(int tc_type) {
            this.tc_type = tc_type;
        }

        public int getTc_cash_type() {
            return tc_cash_type;
        }

        public void setTc_cash_type(int tc_cash_type) {
            this.tc_cash_type = tc_cash_type;
        }

        public String getTc_info() {
            return tc_info;
        }

        public void setTc_info(String tc_info) {
            this.tc_info = tc_info;
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

        public String getCash_in() {
            return cash_in;
        }

        public void setCash_in(String cash_in) {
            this.cash_in = cash_in;
        }

        public String getCash_out() {
            return cash_out;
        }

        public void setCash_out(String cash_out) {
            this.cash_out = cash_out;
        }
    }

}
