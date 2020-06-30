package com.codelabs.konspirasisnack.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDetailPenjualan {


    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private DATAPenjualan DATA;

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

    public DATAPenjualan getDATA() {
        return DATA;
    }

    public void setDATA(DATAPenjualan DATA) {
        this.DATA = DATA;
    }

    public static class DATAPenjualan{
        @SerializedName("transaction")
        private List<DataTransaction>  dataTransaction;
        @SerializedName("summary")
        private Summary summary;

        public List<DataTransaction> getDataTransaction() {
            return dataTransaction;
        }

        public void setDataTransaction(List<DataTransaction> dataTransaction) {
            this.dataTransaction = dataTransaction;
        }

        public Summary getSummary() {
            return summary;
        }

        public void setSummary(Summary summary) {
            this.summary = summary;
        }
    }

    public static class DataTransaction {
        @SerializedName("trans_id")
        private int trans_id;
        @SerializedName("trans_code")
        private String trans_code;
        @SerializedName("trans_merchant_id")
        private int trans_merchant_id;
        @SerializedName("trans_merchant_name")
        private String trans_merchant_name;
        @SerializedName("trans_outlet_id")
        private int trans_outlet_id;
        @SerializedName("trans_outlet_name")
        private String trans_outlet_name;
        @SerializedName("trans_customer_id")
        private int trans_customer_id;
        @SerializedName("trans_customer_name")
        private String trans_customer_name;
        @SerializedName("trans_table_id")
        private int trans_table_id;
        @SerializedName("trans_reservation_id")
        private int trans_reservation_id;
        @SerializedName("trans_subtotal")
        private String trans_subtotal;
        @SerializedName("trans_tax_type")
        private String trans_tax_type;
        @SerializedName("trans_tax_value")
        private String trans_tax_value;
        @SerializedName("trans_tax_percentage")
        private String trans_tax_percentage;
        @SerializedName("trans_discount_type")
        private String trans_discount_type;
        @SerializedName("trans_discount_value")
        private String trans_discount_value;
        @SerializedName("trans_total")
        private String trans_total;
        @SerializedName("trans_total_pay")
        private String trans_total_pay;
        @SerializedName("trans_exchange")
        private String trans_exchange;
        @SerializedName("trans_service_charge")
        private String trans_service_charge;
        @SerializedName("trans_service_percentage")
        private String trans_service_percentage;
        @SerializedName("trans_additional_fee")
        private String trans_additional_fee;
        @SerializedName("trans_total_guest")
        private int trans_total_guest;
        @SerializedName("trans_payment_method_id")
        private int trans_payment_method_id;
        @SerializedName("trans_payment_method_code")
        private String trans_payment_method_code;
        @SerializedName("trans_payment_method_image")
        private String trans_payment_method_image;
        @SerializedName("trans_payment_method_name")
        private String trans_payment_method_name;
        @SerializedName("trans_sessid")
        private String trans_sessid;
        @SerializedName("trans_cashier_id")
        private int trans_cashier_id;
        @SerializedName("trans_shipping_cost")
        private String trans_shipping_cost;
        @SerializedName("trans_cashier_name")
        private String trans_cashier_name;
        @SerializedName("trans_created_by")
        private int trans_created_by;
        @SerializedName("trans_updated_by")
        private int trans_updated_by;
        @SerializedName("trans_date")
        private String trans_date;
        @SerializedName("trans_paid_date")
        private String trans_paid_date;
        @SerializedName("trans_info")
        private String trans_info;
        @SerializedName("trans_order_type")
        private int trans_order_type;
        @SerializedName("trans_order_type_name")
        private String trans_order_type_name;
        @SerializedName("trans_status")
        private int trans_status;
        @SerializedName("trans_shipping_status")
        private int trans_shipping_status;
        @SerializedName("trans_platform")
        private String trans_platform;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("outlet_name")
        private String outlet_name;
        @SerializedName("status_txt")
        private String status_txt;
        @SerializedName("cashier_name")
        private String cashier_name;
        @SerializedName("order_type_name")
        private String order_type_name;
        @SerializedName("payment_method_name")
        private String payment_method_name;
        @SerializedName("transaction_items")
        private List<TransactionItems> transactionItems;

        public int getTrans_id() {
            return trans_id;
        }

        public void setTrans_id(int trans_id) {
            this.trans_id = trans_id;
        }

        public String getTrans_code() {
            return trans_code;
        }

        public void setTrans_code(String trans_code) {
            this.trans_code = trans_code;
        }

        public int getTrans_merchant_id() {
            return trans_merchant_id;
        }

        public void setTrans_merchant_id(int trans_merchant_id) {
            this.trans_merchant_id = trans_merchant_id;
        }

        public String getTrans_merchant_name() {
            return trans_merchant_name;
        }

        public void setTrans_merchant_name(String trans_merchant_name) {
            this.trans_merchant_name = trans_merchant_name;
        }

        public int getTrans_outlet_id() {
            return trans_outlet_id;
        }

        public void setTrans_outlet_id(int trans_outlet_id) {
            this.trans_outlet_id = trans_outlet_id;
        }

        public String getTrans_outlet_name() {
            return trans_outlet_name;
        }

        public void setTrans_outlet_name(String trans_outlet_name) {
            this.trans_outlet_name = trans_outlet_name;
        }

        public int getTrans_customer_id() {
            return trans_customer_id;
        }

        public void setTrans_customer_id(int trans_customer_id) {
            this.trans_customer_id = trans_customer_id;
        }

        public String getTrans_customer_name() {
            return trans_customer_name;
        }

        public void setTrans_customer_name(String trans_customer_name) {
            this.trans_customer_name = trans_customer_name;
        }

        public int getTrans_table_id() {
            return trans_table_id;
        }

        public void setTrans_table_id(int trans_table_id) {
            this.trans_table_id = trans_table_id;
        }

        public int getTrans_reservation_id() {
            return trans_reservation_id;
        }

        public void setTrans_reservation_id(int trans_reservation_id) {
            this.trans_reservation_id = trans_reservation_id;
        }

        public String getTrans_subtotal() {
            return trans_subtotal;
        }

        public void setTrans_subtotal(String trans_subtotal) {
            this.trans_subtotal = trans_subtotal;
        }

        public String getTrans_tax_type() {
            return trans_tax_type;
        }

        public void setTrans_tax_type(String trans_tax_type) {
            this.trans_tax_type = trans_tax_type;
        }

        public String getTrans_tax_value() {
            return trans_tax_value;
        }

        public void setTrans_tax_value(String trans_tax_value) {
            this.trans_tax_value = trans_tax_value;
        }

        public String getTrans_tax_percentage() {
            return trans_tax_percentage;
        }

        public void setTrans_tax_percentage(String trans_tax_percentage) {
            this.trans_tax_percentage = trans_tax_percentage;
        }

        public String getTrans_discount_type() {
            return trans_discount_type;
        }

        public void setTrans_discount_type(String trans_discount_type) {
            this.trans_discount_type = trans_discount_type;
        }

        public String getTrans_discount_value() {
            return trans_discount_value;
        }

        public void setTrans_discount_value(String trans_discount_value) {
            this.trans_discount_value = trans_discount_value;
        }

        public String getTrans_total() {
            return trans_total;
        }

        public void setTrans_total(String trans_total) {
            this.trans_total = trans_total;
        }

        public String getTrans_total_pay() {
            return trans_total_pay;
        }

        public void setTrans_total_pay(String trans_total_pay) {
            this.trans_total_pay = trans_total_pay;
        }

        public String getTrans_exchange() {
            return trans_exchange;
        }

        public void setTrans_exchange(String trans_exchange) {
            this.trans_exchange = trans_exchange;
        }

        public String getTrans_service_charge() {
            return trans_service_charge;
        }

        public void setTrans_service_charge(String trans_service_charge) {
            this.trans_service_charge = trans_service_charge;
        }

        public String getTrans_service_percentage() {
            return trans_service_percentage;
        }

        public void setTrans_service_percentage(String trans_service_percentage) {
            this.trans_service_percentage = trans_service_percentage;
        }

        public String getTrans_additional_fee() {
            return trans_additional_fee;
        }

        public void setTrans_additional_fee(String trans_additional_fee) {
            this.trans_additional_fee = trans_additional_fee;
        }

        public int getTrans_total_guest() {
            return trans_total_guest;
        }

        public void setTrans_total_guest(int trans_total_guest) {
            this.trans_total_guest = trans_total_guest;
        }

        public int getTrans_payment_method_id() {
            return trans_payment_method_id;
        }

        public void setTrans_payment_method_id(int trans_payment_method_id) {
            this.trans_payment_method_id = trans_payment_method_id;
        }

        public String getTrans_payment_method_code() {
            return trans_payment_method_code;
        }

        public void setTrans_payment_method_code(String trans_payment_method_code) {
            this.trans_payment_method_code = trans_payment_method_code;
        }

        public String getTrans_payment_method_image() {
            return trans_payment_method_image;
        }

        public void setTrans_payment_method_image(String trans_payment_method_image) {
            this.trans_payment_method_image = trans_payment_method_image;
        }

        public String getTrans_payment_method_name() {
            return trans_payment_method_name;
        }

        public void setTrans_payment_method_name(String trans_payment_method_name) {
            this.trans_payment_method_name = trans_payment_method_name;
        }

        public String getTrans_sessid() {
            return trans_sessid;
        }

        public void setTrans_sessid(String trans_sessid) {
            this.trans_sessid = trans_sessid;
        }

        public int getTrans_cashier_id() {
            return trans_cashier_id;
        }

        public void setTrans_cashier_id(int trans_cashier_id) {
            this.trans_cashier_id = trans_cashier_id;
        }

        public String getTrans_shipping_cost() {
            return trans_shipping_cost;
        }

        public void setTrans_shipping_cost(String trans_shipping_cost) {
            this.trans_shipping_cost = trans_shipping_cost;
        }

        public String getTrans_cashier_name() {
            return trans_cashier_name;
        }

        public void setTrans_cashier_name(String trans_cashier_name) {
            this.trans_cashier_name = trans_cashier_name;
        }

        public int getTrans_created_by() {
            return trans_created_by;
        }

        public void setTrans_created_by(int trans_created_by) {
            this.trans_created_by = trans_created_by;
        }

        public int getTrans_updated_by() {
            return trans_updated_by;
        }

        public void setTrans_updated_by(int trans_updated_by) {
            this.trans_updated_by = trans_updated_by;
        }

        public String getTrans_date() {
            return trans_date;
        }

        public void setTrans_date(String trans_date) {
            this.trans_date = trans_date;
        }

        public String getTrans_paid_date() {
            return trans_paid_date;
        }

        public void setTrans_paid_date(String trans_paid_date) {
            this.trans_paid_date = trans_paid_date;
        }

        public String getTrans_info() {
            return trans_info;
        }

        public void setTrans_info(String trans_info) {
            this.trans_info = trans_info;
        }

        public int getTrans_order_type() {
            return trans_order_type;
        }

        public void setTrans_order_type(int trans_order_type) {
            this.trans_order_type = trans_order_type;
        }

        public int getTrans_status() {
            return trans_status;
        }

        public void setTrans_status(int trans_status) {
            this.trans_status = trans_status;
        }

        public int getTrans_shipping_status() {
            return trans_shipping_status;
        }

        public void setTrans_shipping_status(int trans_shipping_status) {
            this.trans_shipping_status = trans_shipping_status;
        }

        public String getTrans_platform() {
            return trans_platform;
        }

        public void setTrans_platform(String trans_platform) {
            this.trans_platform = trans_platform;
        }

        public String getTrans_order_type_name() {
            return trans_order_type_name;
        }

        public void setTrans_order_type_name(String trans_order_type_name) {
            this.trans_order_type_name = trans_order_type_name;
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

        public String getOutlet_name() {
            return outlet_name;
        }

        public void setOutlet_name(String outlet_name) {
            this.outlet_name = outlet_name;
        }

        public String getStatus_txt() {
            return status_txt;
        }

        public void setStatus_txt(String status_txt) {
            this.status_txt = status_txt;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public String getOrder_type_name() {
            return order_type_name;
        }

        public void setOrder_type_name(String order_type_name) {
            this.order_type_name = order_type_name;
        }

        public String getPayment_method_name() {
            return payment_method_name;
        }

        public void setPayment_method_name(String payment_method_name) {
            this.payment_method_name = payment_method_name;
        }

        public List<TransactionItems> getTransactionItems() {
            return transactionItems;
        }

        public void setTransactionItems(List<TransactionItems> transactionItems) {
            this.transactionItems = transactionItems;
        }
    }

    public static class TransactionItems {
        @SerializedName("tr_item_transaction_id")
        private int tr_item_transaction_id;
        @SerializedName("tr_item_id")
        private int tr_item_id;
        @SerializedName("tr_item_merchant_id")
        private int tr_item_merchant_id;
        @SerializedName("tr_item_merchant_name")
        private String tr_item_merchant_name;
        @SerializedName("tr_item_outlet_id")
        private int tr_item_outlet_id;
        @SerializedName("tr_item_outlet_name")
        private String tr_item_outlet_name;
        @SerializedName("tr_item_name")
        private String tr_item_name;
        @SerializedName("tr_item_image")
        private String tr_item_image;
        @SerializedName("tr_item_unit_name")
        private String tr_item_unit_name;
        @SerializedName("tr_item_variant_id")
        private int tr_item_variant_id;
        @SerializedName("tr_item_actual_price")
        private String tr_item_actual_price;
        @SerializedName("tr_item_qty")
        private String tr_item_qty;
        @SerializedName("tr_item_additional_price")
        private String tr_item_additional_price;
        @SerializedName("tr_item_service_charge")
        private String tr_item_service_charge;
        @SerializedName("tr_item_total_price")
        private String tr_item_total_price;
        @SerializedName("tr_item_harga_modal")
        private String tr_item_harga_modal;
        @SerializedName("tr_item_harga_modal_total")
        private String tr_item_harga_modal_total;
        @SerializedName("tr_item_tax_type")
        private String tr_item_tax_type;
        @SerializedName("tr_item_tax_value")
        private String tr_item_tax_value;
        @SerializedName("tr_item_discount_type")
        private String tr_item_discount_type;
        @SerializedName("tr_item_discount_value")
        private String tr_item_discount_value;
        @SerializedName("tr_item_info")
        private String tr_item_info;
        @SerializedName("tr_item_harga_jual_actual")
        private String tr_item_harga_jual_actual;
        @SerializedName("detail_item")
        private DetailItem detailItem;

        public int getTr_item_transaction_id() {
            return tr_item_transaction_id;
        }

        public int getTr_item_id() {
            return tr_item_id;
        }

        public int getTr_item_merchant_id() {
            return tr_item_merchant_id;
        }

        public String getTr_item_merchant_name() {
            return tr_item_merchant_name;
        }

        public int getTr_item_outlet_id() {
            return tr_item_outlet_id;
        }

        public String getTr_item_outlet_name() {
            return tr_item_outlet_name;
        }

        public String getTr_item_name() {
            return tr_item_name;
        }

        public String getTr_item_image() {
            return tr_item_image;
        }

        public String getTr_item_unit_name() {
            return tr_item_unit_name;
        }

        public int getTr_item_variant_id() {
            return tr_item_variant_id;
        }

        public String getTr_item_actual_price() {
            return tr_item_actual_price;
        }

        public String getTr_item_qty() {
            return tr_item_qty;
        }

        public String getTr_item_additional_price() {
            return tr_item_additional_price;
        }

        public String getTr_item_service_charge() {
            return tr_item_service_charge;
        }

        public String getTr_item_total_price() {
            return tr_item_total_price;
        }

        public String getTr_item_harga_modal() {
            return tr_item_harga_modal;
        }

        public String getTr_item_harga_modal_total() {
            return tr_item_harga_modal_total;
        }

        public String getTr_item_tax_type() {
            return tr_item_tax_type;
        }

        public String getTr_item_tax_value() {
            return tr_item_tax_value;
        }

        public String getTr_item_discount_type() {
            return tr_item_discount_type;
        }

        public String getTr_item_discount_value() {
            return tr_item_discount_value;
        }

        public String getTr_item_info() {
            return tr_item_info;
        }

        public String getTr_item_harga_jual_actual() {
            return tr_item_harga_jual_actual;
        }

        public DetailItem getDetailItem() {
            return detailItem;
        }
    }

    public static class DetailItem {
        @SerializedName("item_id")
        private int item_id;
        @SerializedName("item_merchant_id")
        private int item_merchant_id;
        @SerializedName("item_category_id")
        private int item_category_id;
        @SerializedName("item_unit_id")
        private int item_unit_id;
        @SerializedName("item_name")
        private String item_name;
        @SerializedName("item_description")
        private String item_description;
        @SerializedName("item_sku")
        private String item_sku;
        @SerializedName("item_image")
        private String item_image;
        @SerializedName("item_is_favorite")
        private int item_is_favorite;
        @SerializedName("item_harga_modal")
        private String item_harga_modal;
        @SerializedName("item_harga_jual")
        private String item_harga_jual;
        @SerializedName("item_minimum_price")
        private String item_minimum_price;
        @SerializedName("item_is_parent")
        private int item_is_parent;
        @SerializedName("item_parent_id")
        private int item_parent_id;
        @SerializedName("item_is_cashier_on")
        private int item_is_cashier_on;
        @SerializedName("item_is_changeable_price")
        private int item_is_changeable_price;
        @SerializedName("item_stock_alert_at")
        private String item_stock_alert_at;
        @SerializedName("item_type")
        private int item_type;
        @SerializedName("item_is_disposable")
        private int item_is_disposable;
        @SerializedName("item_created_by")
        private int item_created_by;
        @SerializedName("item_updated_by")
        private int item_updated_by;
        @SerializedName("item_is_active")
        private int item_is_active;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("deleted_at")
        private String deleted_at;

        public int getItem_id() {
            return item_id;
        }

        public int getItem_merchant_id() {
            return item_merchant_id;
        }

        public int getItem_category_id() {
            return item_category_id;
        }

        public int getItem_unit_id() {
            return item_unit_id;
        }

        public String getItem_name() {
            return item_name;
        }

        public String getItem_description() {
            return item_description;
        }

        public String getItem_sku() {
            return item_sku;
        }

        public String getItem_image() {
            return item_image;
        }

        public int getItem_is_favorite() {
            return item_is_favorite;
        }

        public String getItem_harga_modal() {
            return item_harga_modal;
        }

        public String getItem_harga_jual() {
            return item_harga_jual;
        }

        public String getItem_minimum_price() {
            return item_minimum_price;
        }

        public int getItem_is_parent() {
            return item_is_parent;
        }

        public int getItem_parent_id() {
            return item_parent_id;
        }

        public int getItem_is_cashier_on() {
            return item_is_cashier_on;
        }

        public int getItem_is_changeable_price() {
            return item_is_changeable_price;
        }

        public String getItem_stock_alert_at() {
            return item_stock_alert_at;
        }

        public int getItem_type() {
            return item_type;
        }

        public int getItem_is_disposable() {
            return item_is_disposable;
        }

        public int getItem_created_by() {
            return item_created_by;
        }

        public int getItem_updated_by() {
            return item_updated_by;
        }

        public int getItem_is_active() {
            return item_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getDeleted_at() {
            return deleted_at;
        }
    }


    public static class Summary {
        @SerializedName("total_payment")
        private String total_payment;
        @SerializedName("trx_omset")
        private String trx_omset;
        @SerializedName("total_trx")
        private int total_trx;
        @SerializedName("trx_gross")
        private String trx_gross;


        public String getTotal_payment() {
            return total_payment;
        }

        public void setTotal_payment(String total_payment) {
            this.total_payment = total_payment;
        }

        public int getTotal_trx() {
            return total_trx;
        }

        public void setTotal_trx(int total_trx) {
            this.total_trx = total_trx;
        }

        public String getTrx_omset() {
            return trx_omset;
        }

        public void setTrx_omset(String trx_omset) {
            this.trx_omset = trx_omset;
        }

        public String getTrx_gross() {
            return trx_gross;
        }

        public void setTrx_gross(String trx_gross) {
            this.trx_gross = trx_gross;
        }
    }

}
