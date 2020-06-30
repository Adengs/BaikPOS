package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderListDate {

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
        @SerializedName("transaction_date")
        private String transactionDate;
        @SerializedName("total_transaction")
        private int totalTransaction;

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

        public int getTotalTransaction() {
            return totalTransaction;
        }

        public void setTotalTransaction(int totalTransaction) {
            this.totalTransaction = totalTransaction;
        }
    }
}
