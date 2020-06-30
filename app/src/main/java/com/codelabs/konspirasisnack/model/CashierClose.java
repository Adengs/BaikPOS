package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CashierClose {
    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAClose DATA;


    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAClose getDATA() {
        return DATA;
    }


    public static class DATAClose{
        @Expose
        @SerializedName("cashier_id")
        private int cashier_id;
        @Expose
        @SerializedName("cashier_user_id")
        private int cashier_user_id;
        @Expose
        @SerializedName("cashier_merchant_id")
        private int cashier_merchant_id;
        @Expose
        @SerializedName("cashier_outlet_id")
        private int cashier_outlet_id;
        @Expose
        @SerializedName("cashier_start_date")
        private String cashier_start_date;
        @Expose
        @SerializedName("cashier_end_date")
        private String cashier_end_date;
        @Expose
        @SerializedName("cashier_modal_awal")
        private String cashier_modal_awal;
        @Expose
        @SerializedName("cashier_status")
        private int cashier_status;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        public int getCashier_id() {
            return cashier_id;
        }

        public int getCashier_user_id() {
            return cashier_user_id;
        }

        public int getCashier_merchant_id() {
            return cashier_merchant_id;
        }

        public int getCashier_outlet_id() {
            return cashier_outlet_id;
        }

        public String getCashier_start_date() {
            return cashier_start_date;
        }

        public String getCashier_end_date() {
            return cashier_end_date;
        }

        public String getCashier_modal_awal() {
            return cashier_modal_awal;
        }

        public int getCashier_status() {
            return cashier_status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
