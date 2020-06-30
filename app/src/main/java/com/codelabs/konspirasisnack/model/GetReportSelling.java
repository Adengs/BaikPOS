package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReportSelling {

    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private DATAReportSelling DATA;

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

    public DATAReportSelling getDATA() {
        return DATA;
    }

    public void setDATA(DATAReportSelling DATA) {
        this.DATA = DATA;
    }

    public static class DATAReportSelling {
        @SerializedName("data")
        private DataTotal dataTotal;
        @SerializedName("chart")
        private List<DATAChart> dataChart;


        public DataTotal getDataTotal() {
            return dataTotal;
        }

        public void setDataTotal(DataTotal dataTotal) {
            this.dataTotal = dataTotal;
        }

        public List<DATAChart> getDataChart() {
            return dataChart;
        }

        public void setDataChart(List<DATAChart> dataChart) {
            this.dataChart = dataChart;
        }
    }

    public static class DataTotal {
        @SerializedName("am_omset")
        private String am_omset;
        @SerializedName("am_gross")
        private String am_gross;
        @SerializedName("am_payment")
        private String am_payment;
        @SerializedName("am_transaction")
        private int am_transaction;
        @SerializedName("am_product")
        private String am_product;

        public String getAm_omset() {
            return am_omset;
        }

        public void setAm_omset(String am_omset) {
            this.am_omset = am_omset;
        }

        public String getAm_gross() {
            return am_gross;
        }

        public void setAm_gross(String am_gross) {
            this.am_gross = am_gross;
        }

        public String getAm_payment() {
            return am_payment;
        }

        public void setAm_payment(String am_payment) {
            this.am_payment = am_payment;
        }

        public String getAm_product() {
            return am_product;
        }

        public void setAm_product(String am_product) {
            this.am_product = am_product;
        }

        public int getAm_transaction() {
            return am_transaction;
        }

        public void setAm_transaction(int am_transaction) {
            this.am_transaction = am_transaction;
        }
    }

    public static class DATAChart{
        @SerializedName("date")
        private String date;
        @SerializedName("omset")
        private String omset;
        @SerializedName("total_trans")
        private String total_trans;
        @SerializedName("total_product")
        private String total_product;
        @SerializedName("total_gross")
        private String total_gross;

        public String getDate() {
            return date;
        }

        public String getOmset() {
            return omset;
        }

        public String getTotal_trans() {
            return total_trans;
        }

        public String getTotal_product() {
            return total_product;
        }

        public String getTotal_gross() {
            return total_gross;
        }
    }

}
