package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCreateOrder {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAGetOrder DATA;


    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAGetOrder getDATA() {
        return DATA;
    }


    public static class DATAGetOrder{
        @Expose
        @SerializedName("trans_code")
        private String trans_code;
        @Expose
        @SerializedName("trans_merchant_id")
        private int trans_merchant_id;
        @Expose
        @SerializedName("trans_outlet_id")
        private int trans_outlet_id;
        @Expose
        @SerializedName("trans_customer_id")
        private String trans_customer_id;
        @Expose
        @SerializedName("trans_table_id")
        private String trans_table_id;
        @Expose
        @SerializedName("trans_tax_type")
        private String trans_tax_type;
        @Expose
        @SerializedName("trans_tax_value")
        private String trans_tax_value;
        @Expose
        @SerializedName("trans_discount_type")
        private String trans_discount_type;
        @Expose
        @SerializedName("trans_discount_value")
        private String trans_discount_value;
        @Expose
        @SerializedName("trans_service_charge")
        private String trans_service_charge;
        @Expose
        @SerializedName("trans_total")
        private String trans_total;
        @Expose
        @SerializedName("trans_subtotal")
        private int trans_subtotal;
        @Expose
        @SerializedName("trans_payment_method_id")
        private int trans_payment_method_id;
        @Expose
        @SerializedName("trans_cashier_id")
        private String trans_cashier_id;
        @Expose
        @SerializedName("trans_created_by")
        private int trans_created_by;
        @Expose
        @SerializedName("trans_updated_by")
        private int trans_updated_by;
        @Expose
        @SerializedName("trans_date")
        private String trans_date;
        @Expose
        @SerializedName("trans_info")
        private String trans_info;
        @Expose
        @SerializedName("trans_status")
        private String trans_status;
        @Expose
        @SerializedName("trans_order_type")
        private String trans_order_type;
        @Expose
        @SerializedName("trans_reservation_id")
        private String trans_reservation_id;
        @Expose
        @SerializedName("trans_total_guest")
        private String trans_total_guest;
        @Expose
        @SerializedName("trans_paid_date")
        private String trans_paid_date;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("trans_id")
        private int trans_id;
        @Expose
        @SerializedName("status_txt")
        private String status_txt;



        public String getTrans_code() {
            return trans_code;
        }

        public int getTrans_merchant_id() {
            return trans_merchant_id;
        }

        public int getTrans_outlet_id() {
            return trans_outlet_id;
        }

        public String getTrans_customer_id() {
            return trans_customer_id;
        }

        public String getTrans_table_id() {
            return trans_table_id;
        }

        public String getTrans_tax_type() {
            return trans_tax_type;
        }

        public String getTrans_tax_value() {
            return trans_tax_value;
        }

        public String getTrans_discount_type() {
            return trans_discount_type;
        }

        public String getTrans_discount_value() {
            return trans_discount_value;
        }

        public String getTrans_service_charge() {
            return trans_service_charge;
        }

        public String getTrans_total() {
            return trans_total;
        }

        public int getTrans_subtotal() {
            return trans_subtotal;
        }

        public int getTrans_payment_method_id() {
            return trans_payment_method_id;
        }

        public String getTrans_cashier_id() {
            return trans_cashier_id;
        }

        public int getTrans_created_by() {
            return trans_created_by;
        }

        public int getTrans_updated_by() {
            return trans_updated_by;
        }

        public String getTrans_date() {
            return trans_date;
        }

        public String getTrans_info() {
            return trans_info;
        }

        public String getTrans_status() {
            return trans_status;
        }

        public String getTrans_order_type() {
            return trans_order_type;
        }

        public String getTrans_reservation_id() {
            return trans_reservation_id;
        }

        public String getTrans_total_guest() {
            return trans_total_guest;
        }

        public String getTrans_paid_date() {
            return trans_paid_date;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public int getTrans_id() {
            return trans_id;
        }

        public String getStatus_txt() {
            return status_txt;
        }
    }
}
