package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderDetail {
    /**
     * DATA : {"trans_id":54,"trans_code":"IN74563693130","trans_merchant_id":5,"trans_outlet_id":8,"trans_customer_id":4,"trans_table_id":0,"trans_reservation_id":23,"trans_subtotal":"72000.00","trans_tax_type":"v","trans_tax_value":"0.00","trans_discount_type":"v","trans_discount_value":"0.00","trans_total":"72000.00","trans_service_charge":"0.00","trans_additional_fee":"0.00","trans_total_guest":1,"trans_payment_method_id":1,"trans_sessid":"","trans_cashier_id":17,"trans_created_by":8,"trans_updated_by":8,"trans_date":"2020-02-26 12:21:16","trans_paid_date":"","trans_info":"","trans_order_type":1,"trans_status":1,"created_at":"2020-02-26 12:21:17","updated_at":"2020-02-26 12:21:17","status_txt":"Proses","customer":{"cust_id":4,"cust_merchant_id":5,"cust_outlet_id":0,"cust_group_id":2,"cust_code":"KJV100220EX1EL","cust_fullname":"Lolita","cust_gender":"female","cust_dob":"2003-09-27","cust_email":"lolita@ll.com","cust_phone":"0821314123","cust_address":"Jl. Jalan aja","cust_city":1171,"cust_total_point":0,"cust_info":"","cust_created_by":5,"cust_updated_by":5,"cust_is_active":1,"created_at":"","updated_at":""},"table":{"table_id":0},"transaction_items":[{"tr_item_transaction_id":54,"tr_item_id":20,"tr_item_variant_id":0,"tr_item_actual_price":"16000.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_total_price":"16000.00","tr_item_harga_modal":"10000.00","tr_item_harga_modal_total":"10000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","detail_item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"},"variants":[{"tr_variant_transaction_id":54,"tr_variant_item_id":20,"tr_variant_variant_id":12,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":12,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Regular","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Regular"}}]},{"tr_item_transaction_id":54,"tr_item_id":21,"tr_item_variant_id":0,"tr_item_actual_price":"22000.00","tr_item_qty":"2.00","tr_item_additional_price":"0.00","tr_item_total_price":"44000.00","tr_item_harga_modal":"14000.00","tr_item_harga_modal_total":"28000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","detail_item":{"item_id":21,"item_merchant_id":5,"item_category_id":6,"item_unit_id":10,"item_name":"Es Kopi Pandan","item_description":"","item_sku":"EKP012341","item_image":"b58f4224012845d2c75f82cdea2eb151.jpg","item_is_favorite":1,"item_harga_modal":"14000.00","item_harga_jual":"22000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"10.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 13:32:19","updated_at":"2020-02-18 12:08:36"},"variants":[{"tr_variant_transaction_id":54,"tr_variant_item_id":21,"tr_variant_variant_id":13,"tr_variant_actual_price":"6000.00","tr_variant_qty":"2.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"12000.00","tr_variant_harga_modal":"4000.00","tr_variant_harga_modal_total":"8000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":13,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Large","variant_detail_harga_modal":"4000.00","variant_detail_harga_jual":"6000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Large"}}]}]}
     * MESSAGE : SUCCESS
     * STATUS : 200
     */

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
         * trans_id : 54
         * trans_code : IN74563693130
         * trans_merchant_id : 5
         * trans_outlet_id : 8
         * trans_customer_id : 4
         * trans_table_id : 0
         * trans_reservation_id : 23
         * trans_subtotal : 72000.00
         * trans_tax_type : v
         * trans_tax_value : 0.00
         * trans_discount_type : v
         * trans_discount_value : 0.00
         * trans_total : 72000.00
         * trans_service_charge : 0.00
         * trans_additional_fee : 0.00
         * trans_total_guest : 1
         * trans_payment_method_id : 1
         * trans_sessid :
         * trans_cashier_id : 17
         * trans_created_by : 8
         * trans_updated_by : 8
         * trans_date : 2020-02-26 12:21:16
         * trans_paid_date :
         * trans_info :
         * trans_order_type : 1
         * trans_status : 1
         * created_at : 2020-02-26 12:21:17
         * updated_at : 2020-02-26 12:21:17
         * status_txt : Proses
         * customer : {"cust_id":4,"cust_merchant_id":5,"cust_outlet_id":0,"cust_group_id":2,"cust_code":"KJV100220EX1EL","cust_fullname":"Lolita","cust_gender":"female","cust_dob":"2003-09-27","cust_email":"lolita@ll.com","cust_phone":"0821314123","cust_address":"Jl. Jalan aja","cust_city":1171,"cust_total_point":0,"cust_info":"","cust_created_by":5,"cust_updated_by":5,"cust_is_active":1,"created_at":"","updated_at":""}
         * table : {"table_id":0}
         * transaction_items : [{"tr_item_transaction_id":54,"tr_item_id":20,"tr_item_variant_id":0,"tr_item_actual_price":"16000.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_total_price":"16000.00","tr_item_harga_modal":"10000.00","tr_item_harga_modal_total":"10000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","detail_item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"},"variants":[{"tr_variant_transaction_id":54,"tr_variant_item_id":20,"tr_variant_variant_id":12,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":12,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Regular","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Regular"}}]},{"tr_item_transaction_id":54,"tr_item_id":21,"tr_item_variant_id":0,"tr_item_actual_price":"22000.00","tr_item_qty":"2.00","tr_item_additional_price":"0.00","tr_item_total_price":"44000.00","tr_item_harga_modal":"14000.00","tr_item_harga_modal_total":"28000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","detail_item":{"item_id":21,"item_merchant_id":5,"item_category_id":6,"item_unit_id":10,"item_name":"Es Kopi Pandan","item_description":"","item_sku":"EKP012341","item_image":"b58f4224012845d2c75f82cdea2eb151.jpg","item_is_favorite":1,"item_harga_modal":"14000.00","item_harga_jual":"22000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"10.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 13:32:19","updated_at":"2020-02-18 12:08:36"},"variants":[{"tr_variant_transaction_id":54,"tr_variant_item_id":21,"tr_variant_variant_id":13,"tr_variant_actual_price":"6000.00","tr_variant_qty":"2.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"12000.00","tr_variant_harga_modal":"4000.00","tr_variant_harga_modal_total":"8000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":13,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Large","variant_detail_harga_modal":"4000.00","variant_detail_harga_jual":"6000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Large"}}]}]
         */

        @SerializedName("trans_id")
        private int transId;
        @SerializedName("trans_code")
        private String transCode;
        @SerializedName("trans_merchant_id")
        private int transMerchantId;
        @SerializedName("trans_merchant_name")
        private String trans_merchant_name;
        @SerializedName("trans_outlet_id")
        private int transOutletId;
        @SerializedName("trans_outlet_name")
        private String trans_outlet_name;
        @SerializedName("trans_customer_id")
        private int transCustomerId;
        @SerializedName("trans_customer_name")
        private String trans_customer_name;
        @SerializedName("trans_table_id")
        private int transTableId;
        @SerializedName("trans_reservation_id")
        private int transReservationId;
        @SerializedName("trans_subtotal")
        private String transSubtotal;
        @SerializedName("trans_tax_type")
        private String transTaxType;
        @SerializedName("trans_tax_value")
        private String transTaxValue;
        @SerializedName("trans_tax_percentage")
        private String trans_tax_percentage;
        @SerializedName("trans_discount_type")
        private String transDiscountType;
        @SerializedName("trans_discount_value")
        private String transDiscountValue;
        @SerializedName("trans_total")
        private String transTotal;
        @SerializedName("trans_total_pay")
        private String trans_total_pay;
        @SerializedName("trans_exchange")
        private String trans_exchange;
        @SerializedName("trans_service_charge")
        private String transServiceCharge;
        @SerializedName("trans_additional_fee")
        private String transAdditionalFee;
        @SerializedName("trans_total_guest")
        private int transTotalGuest;
        @SerializedName("trans_payment_method_id")
        private int transPaymentMethodId;
        @SerializedName("trans_payment_method_code")
        private String trans_payment_method_code;
        @SerializedName("trans_payment_method_image")
        private String trans_payment_method_image;
        @SerializedName("trans_payment_method_name")
        private String trans_payment_method_name;
        @SerializedName("trans_sessid")
        private String transSessid;
        @SerializedName("trans_cashier_id")
        private int transCashierId;
        @SerializedName("trans_shipping_cost")
        private String trans_shipping_cost;
        @SerializedName("trans_cashier_name")
        private String trans_cashier_name;
        @SerializedName("trans_created_by")
        private int transCreatedBy;
        @SerializedName("trans_updated_by")
        private int transUpdatedBy;
        @SerializedName("trans_date")
        private String transDate;
        @SerializedName("trans_paid_date")
        private String transPaidDate;
        @SerializedName("trans_info")
        private String transInfo;
        @SerializedName("trans_order_type")
        private int transOrderType;
        @SerializedName("trans_order_type_name")
        private String trans_order_type_name;
        @SerializedName("trans_status")
        private int transStatus;
        @SerializedName("trans_platform")
        private String trans_platform;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("service_charge_value")
        private String service_charge_value;
        @SerializedName("status_txt")
        private String statusTxt;
        @SerializedName("cashier_name")
        private String cashier_name;
        @SerializedName("order_type_name")
        private String orderTypeName;
        @SerializedName("payment_method_name")
        private String payment_method_name;
        @SerializedName("customer_name")
        private String customer_name;
        @SerializedName("customer")
        private Customer customer;
        @SerializedName("transaction_items")
        private List<TransactionItems> transactionItems;
        @SerializedName("trans_shipping_status")
        private int transShippingStatus;

        public int getTransId() {
            return transId;
        }

        public void setTransId(int transId) {
            this.transId = transId;
        }

        public String getTransCode() {
            return transCode;
        }

        public void setTransCode(String transCode) {
            this.transCode = transCode;
        }

        public int getTransMerchantId() {
            return transMerchantId;
        }

        public void setTransMerchantId(int transMerchantId) {
            this.transMerchantId = transMerchantId;
        }

        public String getTrans_merchant_name() {
            return trans_merchant_name;
        }

        public void setTrans_merchant_name(String trans_merchant_name) {
            this.trans_merchant_name = trans_merchant_name;
        }

        public int getTransOutletId() {
            return transOutletId;
        }

        public void setTransOutletId(int transOutletId) {
            this.transOutletId = transOutletId;
        }

        public String getTrans_outlet_name() {
            return trans_outlet_name;
        }

        public void setTrans_outlet_name(String trans_outlet_name) {
            this.trans_outlet_name = trans_outlet_name;
        }

        public int getTransCustomerId() {
            return transCustomerId;
        }

        public void setTransCustomerId(int transCustomerId) {
            this.transCustomerId = transCustomerId;
        }

        public int getTransTableId() {
            return transTableId;
        }

        public void setTransTableId(int transTableId) {
            this.transTableId = transTableId;
        }

        public int getTransReservationId() {
            return transReservationId;
        }

        public void setTransReservationId(int transReservationId) {
            this.transReservationId = transReservationId;
        }

        public String getTransSubtotal() {
            return transSubtotal;
        }

        public void setTransSubtotal(String transSubtotal) {
            this.transSubtotal = transSubtotal;
        }

        public String getTransTaxType() {
            return transTaxType;
        }

        public void setTransTaxType(String transTaxType) {
            this.transTaxType = transTaxType;
        }

        public String getTransTaxValue() {
            return transTaxValue;
        }

        public void setTransTaxValue(String transTaxValue) {
            this.transTaxValue = transTaxValue;
        }

        public String getTrans_customer_name() {
            return trans_customer_name;
        }

        public void setTrans_customer_name(String trans_customer_name) {
            this.trans_customer_name = trans_customer_name;
        }

        public String getTrans_tax_percentage() {
            return trans_tax_percentage;
        }

        public void setTrans_tax_percentage(String trans_tax_percentage) {
            this.trans_tax_percentage = trans_tax_percentage;
        }

        public String getTransDiscountType() {
            return transDiscountType;
        }

        public void setTransDiscountType(String transDiscountType) {
            this.transDiscountType = transDiscountType;
        }

        public String getTransDiscountValue() {
            return transDiscountValue;
        }

        public void setTransDiscountValue(String transDiscountValue) {
            this.transDiscountValue = transDiscountValue;
        }

        public String getTransTotal() {
            return transTotal;
        }

        public void setTransTotal(String transTotal) {
            this.transTotal = transTotal;
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

        public String getTransServiceCharge() {
            return transServiceCharge;
        }

        public void setTransServiceCharge(String transServiceCharge) {
            this.transServiceCharge = transServiceCharge;
        }

        public String getTransAdditionalFee() {
            return transAdditionalFee;
        }

        public void setTransAdditionalFee(String transAdditionalFee) {
            this.transAdditionalFee = transAdditionalFee;
        }

        public int getTransTotalGuest() {
            return transTotalGuest;
        }

        public void setTransTotalGuest(int transTotalGuest) {
            this.transTotalGuest = transTotalGuest;
        }

        public int getTransPaymentMethodId() {
            return transPaymentMethodId;
        }

        public void setTransPaymentMethodId(int transPaymentMethodId) {
            this.transPaymentMethodId = transPaymentMethodId;
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

        public String getTransSessid() {
            return transSessid;
        }

        public void setTransSessid(String transSessid) {
            this.transSessid = transSessid;
        }

        public int getTransCashierId() {
            return transCashierId;
        }

        public void setTransCashierId(int transCashierId) {
            this.transCashierId = transCashierId;
        }

        public String getTrans_cashier_name() {
            return trans_cashier_name;
        }

        public void setTrans_cashier_name(String trans_cashier_name) {
            this.trans_cashier_name = trans_cashier_name;
        }

        public String getTrans_shipping_cost() {
            return trans_shipping_cost;
        }

        public void setTrans_shipping_cost(String trans_shipping_cost) {
            this.trans_shipping_cost = trans_shipping_cost;
        }

        public int getTransCreatedBy() {
            return transCreatedBy;
        }

        public void setTransCreatedBy(int transCreatedBy) {
            this.transCreatedBy = transCreatedBy;
        }

        public int getTransUpdatedBy() {
            return transUpdatedBy;
        }

        public void setTransUpdatedBy(int transUpdatedBy) {
            this.transUpdatedBy = transUpdatedBy;
        }

        public String getTransDate() {
            return transDate;
        }

        public void setTransDate(String transDate) {
            this.transDate = transDate;
        }

        public String getTransPaidDate() {
            return transPaidDate;
        }

        public void setTransPaidDate(String transPaidDate) {
            this.transPaidDate = transPaidDate;
        }

        public String getTransInfo() {
            return transInfo;
        }

        public void setTransInfo(String transInfo) {
            this.transInfo = transInfo;
        }

        public int getTransOrderType() {
            return transOrderType;
        }

        public String getTrans_order_type_name() {
            return trans_order_type_name;
        }

        public void setTrans_order_type_name(String trans_order_type_name) {
            this.trans_order_type_name = trans_order_type_name;
        }

        public void setTransOrderType(int transOrderType) {
            this.transOrderType = transOrderType;
        }

        public int getTransStatus() {
            return transStatus;
        }


        public String getTrans_platform() {
            return trans_platform;
        }

        public void setTrans_platform(String trans_platform) {
            this.trans_platform = trans_platform;
        }

        public void setTransStatus(int transStatus) {
            this.transStatus = transStatus;
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

        public String getService_charge_value() {
            return service_charge_value;
        }

        public void setService_charge_value(String service_charge_value) {
            this.service_charge_value = service_charge_value;
        }

        public String getStatusTxt() {
            return statusTxt;
        }

        public void setStatusTxt(String statusTxt) {
            this.statusTxt = statusTxt;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public String getPayment_method_name() {
            return payment_method_name;
        }

        public void setPayment_method_name(String payment_method_name) {
            this.payment_method_name = payment_method_name;
        }

        public String getOrderTypeName() {
            return orderTypeName;
        }

        public void setOrderTypeName(String orderTypeName) {
            this.orderTypeName = orderTypeName;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }


        public List<TransactionItems> getTransactionItems() {
            return transactionItems;
        }

        public void setTransactionItems(List<TransactionItems> transactionItems) {
            this.transactionItems = transactionItems;
        }

        public int getTransShippingStatus() {
            return transShippingStatus;
        }

        public void setTransShippingStatus(int transShippingStatus) {
            this.transShippingStatus = transShippingStatus;
        }

        public static class Customer {
            /**
             * cust_id : 4
             * cust_merchant_id : 5
             * cust_outlet_id : 0
             * cust_group_id : 2
             * cust_code : KJV100220EX1EL
             * cust_fullname : Lolita
             * cust_gender : female
             * cust_dob : 2003-09-27
             * cust_email : lolita@ll.com
             * cust_phone : 0821314123
             * cust_address : Jl. Jalan aja
             * cust_city : 1171
             * cust_total_point : 0
             * cust_info :
             * cust_created_by : 5
             * cust_updated_by : 5
             * cust_is_active : 1
             * created_at :
             * updated_at :
             */

            @SerializedName("cust_id")
            private int custId;
            @SerializedName("cust_merchant_id")
            private int custMerchantId;
            @SerializedName("cust_outlet_id")
            private int custOutletId;
            @SerializedName("cust_group_id")
            private int custGroupId;
            @SerializedName("cust_code")
            private String custCode;
            @SerializedName("cust_fullname")
            private String custFullname;
            @SerializedName("cust_gender")
            private String custGender;
            @SerializedName("cust_dob")
            private String custDob;
            @SerializedName("cust_email")
            private String custEmail;
            @SerializedName("cust_phone")
            private String custPhone;
            @SerializedName("cust_address")
            private String custAddress;
            @SerializedName("cust_city")
            private int custCity;
            @SerializedName("cust_total_point")
            private int custTotalPoint;
            @SerializedName("cust_info")
            private String custInfo;
            @SerializedName("cust_created_by")
            private int custCreatedBy;
            @SerializedName("cust_updated_by")
            private int custUpdatedBy;
            @SerializedName("cust_is_active")
            private int custIsActive;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getCustId() {
                return custId;
            }

            public void setCustId(int custId) {
                this.custId = custId;
            }

            public int getCustMerchantId() {
                return custMerchantId;
            }

            public void setCustMerchantId(int custMerchantId) {
                this.custMerchantId = custMerchantId;
            }

            public int getCustOutletId() {
                return custOutletId;
            }

            public void setCustOutletId(int custOutletId) {
                this.custOutletId = custOutletId;
            }

            public int getCustGroupId() {
                return custGroupId;
            }

            public void setCustGroupId(int custGroupId) {
                this.custGroupId = custGroupId;
            }

            public String getCustCode() {
                return custCode;
            }

            public void setCustCode(String custCode) {
                this.custCode = custCode;
            }

            public String getCustFullname() {
                return custFullname;
            }

            public void setCustFullname(String custFullname) {
                this.custFullname = custFullname;
            }

            public String getCustGender() {
                return custGender;
            }

            public void setCustGender(String custGender) {
                this.custGender = custGender;
            }

            public String getCustDob() {
                return custDob;
            }

            public void setCustDob(String custDob) {
                this.custDob = custDob;
            }

            public String getCustEmail() {
                return custEmail;
            }

            public void setCustEmail(String custEmail) {
                this.custEmail = custEmail;
            }

            public String getCustPhone() {
                return custPhone;
            }

            public void setCustPhone(String custPhone) {
                this.custPhone = custPhone;
            }

            public String getCustAddress() {
                return custAddress;
            }

            public void setCustAddress(String custAddress) {
                this.custAddress = custAddress;
            }

            public int getCustCity() {
                return custCity;
            }

            public void setCustCity(int custCity) {
                this.custCity = custCity;
            }

            public int getCustTotalPoint() {
                return custTotalPoint;
            }

            public void setCustTotalPoint(int custTotalPoint) {
                this.custTotalPoint = custTotalPoint;
            }

            public String getCustInfo() {
                return custInfo;
            }

            public void setCustInfo(String custInfo) {
                this.custInfo = custInfo;
            }

            public int getCustCreatedBy() {
                return custCreatedBy;
            }

            public void setCustCreatedBy(int custCreatedBy) {
                this.custCreatedBy = custCreatedBy;
            }

            public int getCustUpdatedBy() {
                return custUpdatedBy;
            }

            public void setCustUpdatedBy(int custUpdatedBy) {
                this.custUpdatedBy = custUpdatedBy;
            }

            public int getCustIsActive() {
                return custIsActive;
            }

            public void setCustIsActive(int custIsActive) {
                this.custIsActive = custIsActive;
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
        }


        public static class TransactionItems {
            /**
             * tr_item_transaction_id : 54
             * tr_item_id : 20
             * tr_item_variant_id : 0
             * tr_item_actual_price : 16000.00
             * tr_item_qty : 1.00
             * tr_item_additional_price : 0.00
             * tr_item_total_price : 16000.00
             * tr_item_harga_modal : 10000.00
             * tr_item_harga_modal_total : 10000.00
             * tr_item_tax_type : p
             * tr_item_tax_value : 0.00
             * tr_item_discount_type : p
             * tr_item_discount_value : 0.00
             * tr_item_info :
             * detail_item : {"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}
             * variants : [{"tr_variant_transaction_id":54,"tr_variant_item_id":20,"tr_variant_variant_id":12,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":12,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Regular","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Regular"}}]
             */

            @SerializedName("tr_item_transaction_id")
            private int trItemTransactionId;
            @SerializedName("tr_item_id")
            private int trItemId;
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
            private int trItemVariantId;
            @SerializedName("tr_item_actual_price")
            private String trItemActualPrice;
            @SerializedName("tr_item_qty")
            private String trItemQty;
            @SerializedName("tr_item_additional_price")
            private String trItemAdditionalPrice;
            @SerializedName("tr_item_service_charge")
            private String tr_item_service_charge;
            @SerializedName("tr_item_total_price")
            private String trItemTotalPrice;
            @SerializedName("tr_item_harga_modal")
            private String trItemHargaModal;
            @SerializedName("tr_item_harga_modal_total")
            private String trItemHargaModalTotal;
            @SerializedName("tr_item_tax_type")
            private String trItemTaxType;
            @SerializedName("tr_item_tax_value")
            private String trItemTaxValue;
            @SerializedName("tr_item_discount_type")
            private String trItemDiscountType;
            @SerializedName("tr_item_discount_value")
            private String trItemDiscountValue;
            @SerializedName("tr_item_info")
            private String trItemInfo;
            @SerializedName("tr_item_harga_jual_actual")
            private String tr_item_harga_jual_actual;
            @SerializedName("variants")
            private List<Variants> variants;

            public int getSubtotal(){
                int subtotal = 0;
                subtotal+= Integer.parseInt(trItemTotalPrice.replace(".00",""));
                for (Variants p : variants)
                    subtotal += Integer.parseInt(p.trVariantTotalPrice.replace(".00",""));

                return subtotal;
            }

            public int getTrItemTransactionId() {
                return trItemTransactionId;
            }

            public void setTrItemTransactionId(int trItemTransactionId) {
                this.trItemTransactionId = trItemTransactionId;
            }

            public int getTrItemId() {
                return trItemId;
            }

            public void setTrItemId(int trItemId) {
                this.trItemId = trItemId;
            }

            public int getTr_item_merchant_id() {
                return tr_item_merchant_id;
            }

            public void setTr_item_merchant_id(int tr_item_merchant_id) {
                this.tr_item_merchant_id = tr_item_merchant_id;
            }

            public String getTr_item_merchant_name() {
                return tr_item_merchant_name;
            }

            public void setTr_item_merchant_name(String tr_item_merchant_name) {
                this.tr_item_merchant_name = tr_item_merchant_name;
            }

            public int getTr_item_outlet_id() {
                return tr_item_outlet_id;
            }

            public void setTr_item_outlet_id(int tr_item_outlet_id) {
                this.tr_item_outlet_id = tr_item_outlet_id;
            }

            public String getTr_item_outlet_name() {
                return tr_item_outlet_name;
            }

            public void setTr_item_outlet_name(String tr_item_outlet_name) {
                this.tr_item_outlet_name = tr_item_outlet_name;
            }

            public String getTr_item_name() {
                return tr_item_name;
            }

            public void setTr_item_name(String tr_item_name) {
                this.tr_item_name = tr_item_name;
            }


            public String getTr_item_unit_name() {
                return tr_item_unit_name;
            }

            public void setTr_item_unit_name(String tr_item_unit_name) {
                this.tr_item_unit_name = tr_item_unit_name;
            }

            public int getTrItemVariantId() {
                return trItemVariantId;
            }

            public void setTrItemVariantId(int trItemVariantId) {
                this.trItemVariantId = trItemVariantId;
            }

            public String getTrItemActualPrice() {
                return trItemActualPrice;
            }

            public void setTrItemActualPrice(String trItemActualPrice) {
                this.trItemActualPrice = trItemActualPrice;
            }

            public String getTr_item_service_charge() {
                return tr_item_service_charge;
            }

            public void setTr_item_service_charge(String tr_item_service_charge) {
                this.tr_item_service_charge = tr_item_service_charge;
            }

            public String getTrItemQty() {
                return trItemQty;
            }

            public void setTrItemQty(String trItemQty) {
                this.trItemQty = trItemQty;
            }

            public String getTrItemAdditionalPrice() {
                return trItemAdditionalPrice;
            }

            public void setTrItemAdditionalPrice(String trItemAdditionalPrice) {
                this.trItemAdditionalPrice = trItemAdditionalPrice;
            }

            public String getTrItemTotalPrice() {
                return trItemTotalPrice;
            }

            public void setTrItemTotalPrice(String trItemTotalPrice) {
                this.trItemTotalPrice = trItemTotalPrice;
            }

            public String getTrItemHargaModal() {
                return trItemHargaModal;
            }

            public void setTrItemHargaModal(String trItemHargaModal) {
                this.trItemHargaModal = trItemHargaModal;
            }

            public String getTrItemHargaModalTotal() {
                return trItemHargaModalTotal;
            }

            public void setTrItemHargaModalTotal(String trItemHargaModalTotal) {
                this.trItemHargaModalTotal = trItemHargaModalTotal;
            }

            public String getTrItemTaxType() {
                return trItemTaxType;
            }

            public void setTrItemTaxType(String trItemTaxType) {
                this.trItemTaxType = trItemTaxType;
            }

            public String getTrItemTaxValue() {
                return trItemTaxValue;
            }

            public void setTrItemTaxValue(String trItemTaxValue) {
                this.trItemTaxValue = trItemTaxValue;
            }

            public String getTrItemDiscountType() {
                return trItemDiscountType;
            }

            public void setTrItemDiscountType(String trItemDiscountType) {
                this.trItemDiscountType = trItemDiscountType;
            }

            public String getTrItemDiscountValue() {
                return trItemDiscountValue;
            }

            public void setTrItemDiscountValue(String trItemDiscountValue) {
                this.trItemDiscountValue = trItemDiscountValue;
            }

            public String getTrItemInfo() {
                return trItemInfo;
            }

            public void setTrItemInfo(String trItemInfo) {
                this.trItemInfo = trItemInfo;
            }


            public String getTr_item_harga_jual_actual() {
                return tr_item_harga_jual_actual;
            }

            public void setTr_item_harga_jual_actual(String tr_item_harga_jual_actual) {
                this.tr_item_harga_jual_actual = tr_item_harga_jual_actual;
            }


            public List<Variants> getVariants() {
                return variants;
            }

            public void setVariants(List<Variants> variants) {
                this.variants = variants;
            }

            public String getTrItemImage() {
                return tr_item_image;
            }

            public void setTr_item_image(String tr_item_image) {
                this.tr_item_image = tr_item_image;
            }

//            public static class DetailItem {
//                /**
//                 * item_id : 20
//                 * item_merchant_id : 5
//                 * item_category_id : 6
//                 * item_unit_id : 0
//                 * item_name : Es Kopi Kekinian
//                 * item_description :
//                 * item_sku : ES0101012
//                 * item_image : d5217495884602661d8aed69a644cc10.jpg
//                 * item_is_favorite : 1
//                 * item_harga_modal : 10000.00
//                 * item_harga_jual : 16000.00
//                 * item_minimum_price : 0.00
//                 * item_is_parent : 0
//                 * item_parent_id : 0
//                 * item_is_cashier_on : 1
//                 * item_is_changeable_price : 0
//                 * item_stock_alert_at : 40.00
//                 * item_type : 1
//                 * item_is_disposable : 0
//                 * item_created_by : 9
//                 * item_updated_by : 9
//                 * item_is_active : 0
//                 * created_at : 2020-02-07 11:05:29
//                 * updated_at : 2020-02-18 12:08:14
//                 */
//
//                @SerializedName("item_id")
//                private int itemId;
//                @SerializedName("item_merchant_id")
//                private int itemMerchantId;
//                @SerializedName("item_category_id")
//                private int itemCategoryId;
//                @SerializedName("item_unit_id")
//                private int itemUnitId;
//                @SerializedName("item_name")
//                private String itemName;
//                @SerializedName("item_description")
//                private String itemDescription;
//                @SerializedName("item_sku")
//                private String itemSku;
//                @SerializedName("item_image")
//                private String itemImage;
//                @SerializedName("item_is_favorite")
//                private int itemIsFavorite;
//                @SerializedName("item_harga_modal")
//                private String itemHargaModal;
//                @SerializedName("item_harga_jual")
//                private String itemHargaJual;
//                @SerializedName("item_minimum_price")
//                private String itemMinimumPrice;
//                @SerializedName("item_is_parent")
//                private int itemIsParent;
//                @SerializedName("item_parent_id")
//                private int itemParentId;
//                @SerializedName("item_is_cashier_on")
//                private int itemIsCashierOn;
//                @SerializedName("item_is_changeable_price")
//                private int itemIsChangeablePrice;
//                @SerializedName("item_stock_alert_at")
//                private String itemStockAlertAt;
//                @SerializedName("item_type")
//                private int itemType;
//                @SerializedName("item_is_disposable")
//                private int itemIsDisposable;
//                @SerializedName("item_created_by")
//                private int itemCreatedBy;
//                @SerializedName("item_updated_by")
//                private int itemUpdatedBy;
//                @SerializedName("item_is_active")
//                private int itemIsActive;
//                @SerializedName("created_at")
//                private String createdAt;
//                @SerializedName("updated_at")
//                private String updatedAt;
//
//                public int getItemId() {
//                    return itemId;
//                }
//
//                public void setItemId(int itemId) {
//                    this.itemId = itemId;
//                }
//
//                public int getItemMerchantId() {
//                    return itemMerchantId;
//                }
//
//                public void setItemMerchantId(int itemMerchantId) {
//                    this.itemMerchantId = itemMerchantId;
//                }
//
//                public int getItemCategoryId() {
//                    return itemCategoryId;
//                }
//
//                public void setItemCategoryId(int itemCategoryId) {
//                    this.itemCategoryId = itemCategoryId;
//                }
//
//                public int getItemUnitId() {
//                    return itemUnitId;
//                }
//
//                public void setItemUnitId(int itemUnitId) {
//                    this.itemUnitId = itemUnitId;
//                }
//
//                public String getItemName() {
//                    return itemName;
//                }
//
//                public void setItemName(String itemName) {
//                    this.itemName = itemName;
//                }
//
//                public String getItemDescription() {
//                    return itemDescription;
//                }
//
//                public void setItemDescription(String itemDescription) {
//                    this.itemDescription = itemDescription;
//                }
//
//                public String getItemSku() {
//                    return itemSku;
//                }
//
//                public void setItemSku(String itemSku) {
//                    this.itemSku = itemSku;
//                }
//
//                public String getItemImage() {
//                    return itemImage;
//                }
//
//                public void setItemImage(String itemImage) {
//                    this.itemImage = itemImage;
//                }
//
//                public int getItemIsFavorite() {
//                    return itemIsFavorite;
//                }
//
//                public void setItemIsFavorite(int itemIsFavorite) {
//                    this.itemIsFavorite = itemIsFavorite;
//                }
//
//                public String getItemHargaModal() {
//                    return itemHargaModal;
//                }
//
//                public void setItemHargaModal(String itemHargaModal) {
//                    this.itemHargaModal = itemHargaModal;
//                }
//
//                public String getItemHargaJual() {
//                    return itemHargaJual;
//                }
//
//                public void setItemHargaJual(String itemHargaJual) {
//                    this.itemHargaJual = itemHargaJual;
//                }
//
//                public String getItemMinimumPrice() {
//                    return itemMinimumPrice;
//                }
//
//                public void setItemMinimumPrice(String itemMinimumPrice) {
//                    this.itemMinimumPrice = itemMinimumPrice;
//                }
//
//                public int getItemIsParent() {
//                    return itemIsParent;
//                }
//
//                public void setItemIsParent(int itemIsParent) {
//                    this.itemIsParent = itemIsParent;
//                }
//
//                public int getItemParentId() {
//                    return itemParentId;
//                }
//
//                public void setItemParentId(int itemParentId) {
//                    this.itemParentId = itemParentId;
//                }
//
//                public int getItemIsCashierOn() {
//                    return itemIsCashierOn;
//                }
//
//                public void setItemIsCashierOn(int itemIsCashierOn) {
//                    this.itemIsCashierOn = itemIsCashierOn;
//                }
//
//                public int getItemIsChangeablePrice() {
//                    return itemIsChangeablePrice;
//                }
//
//                public void setItemIsChangeablePrice(int itemIsChangeablePrice) {
//                    this.itemIsChangeablePrice = itemIsChangeablePrice;
//                }
//
//                public String getItemStockAlertAt() {
//                    return itemStockAlertAt;
//                }
//
//                public void setItemStockAlertAt(String itemStockAlertAt) {
//                    this.itemStockAlertAt = itemStockAlertAt;
//                }
//
//                public int getItemType() {
//                    return itemType;
//                }
//
//                public void setItemType(int itemType) {
//                    this.itemType = itemType;
//                }
//
//                public int getItemIsDisposable() {
//                    return itemIsDisposable;
//                }
//
//                public void setItemIsDisposable(int itemIsDisposable) {
//                    this.itemIsDisposable = itemIsDisposable;
//                }
//
//                public int getItemCreatedBy() {
//                    return itemCreatedBy;
//                }
//
//                public void setItemCreatedBy(int itemCreatedBy) {
//                    this.itemCreatedBy = itemCreatedBy;
//                }
//
//                public int getItemUpdatedBy() {
//                    return itemUpdatedBy;
//                }
//
//                public void setItemUpdatedBy(int itemUpdatedBy) {
//                    this.itemUpdatedBy = itemUpdatedBy;
//                }
//
//                public int getItemIsActive() {
//                    return itemIsActive;
//                }
//
//                public void setItemIsActive(int itemIsActive) {
//                    this.itemIsActive = itemIsActive;
//                }
//
//                public String getCreatedAt() {
//                    return createdAt;
//                }
//
//                public void setCreatedAt(String createdAt) {
//                    this.createdAt = createdAt;
//                }
//
//                public String getUpdatedAt() {
//                    return updatedAt;
//                }
//
//                public void setUpdatedAt(String updatedAt) {
//                    this.updatedAt = updatedAt;
//                }
//            }

            public static class Variants {
                /**
                 * tr_variant_transaction_id : 54
                 * tr_variant_item_id : 20
                 * tr_variant_variant_id : 12
                 * tr_variant_actual_price : 0.00
                 * tr_variant_qty : 1.00
                 * tr_variant_additional_price : 0.00
                 * tr_variant_total_price : 0.00
                 * tr_variant_harga_modal : 0.00
                 * tr_variant_harga_modal_total : 0.00
                 * tr_variant_tax_type : p
                 * tr_variant_tax_value : 0.00
                 * tr_variant_discount_type : p
                 * tr_variant_discount_value : 0.00
                 * tr_variant_info :
                 * item : {"variant_detail_id":12,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Regular","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Regular"}
                 */

                @SerializedName("tr_variant_transaction_id")
                private int trVariantTransactionId;
                @SerializedName("tr_variant_name")
                private String tr_variant_name;
                @SerializedName("tr_variant_item_id")
                private int trVariantItemId;
                @SerializedName("tr_variant_item_merchant_id")
                private String tr_variant_item_merchant_id;
                @SerializedName("tr_variant_item_merchant_name")
                private String tr_variant_item_merchant_name;
                @SerializedName("tr_variant_item_outlet_id")
                private int tr_variant_item_outlet_id;
                @SerializedName("tr_variant_item_outlet_name")
                private String tr_variant_item_outlet_name;
                @SerializedName("tr_variant_item_name")
                private String tr_variant_item_name;
                @SerializedName("tr_variant_item_image")
                private String tr_variant_item_image;
                @SerializedName("tr_variant_item_unit_name")
                private String tr_variant_item_unit_name;
                @SerializedName("tr_variant_variant_id")
                private int trVariantVariantId;
                @SerializedName("tr_variant_actual_price")
                private String trVariantActualPrice;
                @SerializedName("tr_variant_qty")
                private String trVariantQty;
                @SerializedName("tr_variant_additional_price")
                private String trVariantAdditionalPrice;
                @SerializedName("tr_variant_total_price")
                private String trVariantTotalPrice;
                @SerializedName("tr_variant_harga_modal")
                private String trVariantHargaModal;
                @SerializedName("tr_variant_harga_modal_total")
                private String trVariantHargaModalTotal;
                @SerializedName("tr_variant_tax_type")
                private String trVariantTaxType;
                @SerializedName("tr_variant_tax_value")
                private String trVariantTaxValue;
                @SerializedName("tr_variant_discount_type")
                private String trVariantDiscountType;
                @SerializedName("tr_variant_discount_value")
                private String trVariantDiscountValue;
                @SerializedName("tr_variant_info")
                private String trVariantInfo;
                @SerializedName("tr_variant_is_inventory")
                private int tr_variant_is_inventory;
                @SerializedName("item")
                private Item item;

                public int getTrVariantTransactionId() {
                    return trVariantTransactionId;
                }

                public void setTrVariantTransactionId(int trVariantTransactionId) {
                    this.trVariantTransactionId = trVariantTransactionId;
                }

                public String getTr_variant_name() {
                    return tr_variant_name;
                }

                public void setTr_variant_name(String tr_variant_name) {
                    this.tr_variant_name = tr_variant_name;
                }

                public int getTrVariantItemId() {
                    return trVariantItemId;
                }

                public void setTrVariantItemId(int trVariantItemId) {
                    this.trVariantItemId = trVariantItemId;
                }

                public String getTr_variant_item_merchant_id() {
                    return tr_variant_item_merchant_id;
                }

                public void setTr_variant_item_merchant_id(String tr_variant_item_merchant_id) {
                    this.tr_variant_item_merchant_id = tr_variant_item_merchant_id;
                }

                public String getTr_variant_item_merchant_name() {
                    return tr_variant_item_merchant_name;
                }

                public void setTr_variant_item_merchant_name(String tr_variant_item_merchant_name) {
                    this.tr_variant_item_merchant_name = tr_variant_item_merchant_name;
                }

                public int getTr_variant_item_outlet_id() {
                    return tr_variant_item_outlet_id;
                }

                public void setTr_variant_item_outlet_id(int tr_variant_item_outlet_id) {
                    this.tr_variant_item_outlet_id = tr_variant_item_outlet_id;
                }

                public String getTr_variant_item_outlet_name() {
                    return tr_variant_item_outlet_name;
                }

                public void setTr_variant_item_outlet_name(String tr_variant_item_outlet_name) {
                    this.tr_variant_item_outlet_name = tr_variant_item_outlet_name;
                }

                public String getTr_variant_item_name() {
                    return tr_variant_item_name;
                }

                public void setTr_variant_item_name(String tr_variant_item_name) {
                    this.tr_variant_item_name = tr_variant_item_name;
                }

                public String getTr_variant_item_image() {
                    return tr_variant_item_image;
                }

                public void setTr_variant_item_image(String tr_variant_item_image) {
                    this.tr_variant_item_image = tr_variant_item_image;
                }

                public String getTr_variant_item_unit_name() {
                    return tr_variant_item_unit_name;
                }

                public void setTr_variant_item_unit_name(String tr_variant_item_unit_name) {
                    this.tr_variant_item_unit_name = tr_variant_item_unit_name;
                }

                public int getTrVariantVariantId() {
                    return trVariantVariantId;
                }

                public void setTrVariantVariantId(int trVariantVariantId) {
                    this.trVariantVariantId = trVariantVariantId;
                }

                public String getTrVariantActualPrice() {
                    return trVariantActualPrice;
                }

                public void setTrVariantActualPrice(String trVariantActualPrice) {
                    this.trVariantActualPrice = trVariantActualPrice;
                }

                public String getTrVariantQty() {
                    return trVariantQty;
                }

                public void setTrVariantQty(String trVariantQty) {
                    this.trVariantQty = trVariantQty;
                }

                public String getTrVariantAdditionalPrice() {
                    return trVariantAdditionalPrice;
                }

                public void setTrVariantAdditionalPrice(String trVariantAdditionalPrice) {
                    this.trVariantAdditionalPrice = trVariantAdditionalPrice;
                }

                public String getTrVariantTotalPrice() {
                    return trVariantTotalPrice;
                }

                public void setTrVariantTotalPrice(String trVariantTotalPrice) {
                    this.trVariantTotalPrice = trVariantTotalPrice;
                }

                public String getTrVariantHargaModal() {
                    return trVariantHargaModal;
                }

                public void setTrVariantHargaModal(String trVariantHargaModal) {
                    this.trVariantHargaModal = trVariantHargaModal;
                }

                public String getTrVariantHargaModalTotal() {
                    return trVariantHargaModalTotal;
                }

                public void setTrVariantHargaModalTotal(String trVariantHargaModalTotal) {
                    this.trVariantHargaModalTotal = trVariantHargaModalTotal;
                }

                public String getTrVariantTaxType() {
                    return trVariantTaxType;
                }

                public void setTrVariantTaxType(String trVariantTaxType) {
                    this.trVariantTaxType = trVariantTaxType;
                }

                public String getTrVariantTaxValue() {
                    return trVariantTaxValue;
                }

                public void setTrVariantTaxValue(String trVariantTaxValue) {
                    this.trVariantTaxValue = trVariantTaxValue;
                }

                public String getTrVariantDiscountType() {
                    return trVariantDiscountType;
                }

                public void setTrVariantDiscountType(String trVariantDiscountType) {
                    this.trVariantDiscountType = trVariantDiscountType;
                }

                public String getTrVariantDiscountValue() {
                    return trVariantDiscountValue;
                }

                public void setTrVariantDiscountValue(String trVariantDiscountValue) {
                    this.trVariantDiscountValue = trVariantDiscountValue;
                }

                public String getTrVariantInfo() {
                    return trVariantInfo;
                }

                public void setTrVariantInfo(String trVariantInfo) {
                    this.trVariantInfo = trVariantInfo;
                }

                public int getTr_variant_is_inventory() {
                    return tr_variant_is_inventory;
                }

                public void setTr_variant_is_inventory(int tr_variant_is_inventory) {
                    this.tr_variant_is_inventory = tr_variant_is_inventory;
                }

                public Item getItem() {
                    return item;
                }

                public void setItem(Item item) {
                    this.item = item;
                }

                public static class Item {
                    /**
                     * variant_detail_id : 12
                     * variant_detail_variant_id : 5
                     * variant_detail_item_id : 0
                     * variant_detail_name : Regular
                     * variant_detail_harga_modal : 0.00
                     * variant_detail_harga_jual : 0.00
                     * variant_detail_amount : 0.00
                     * variant_detail_is_inventory : 0
                     * detail_name_txt : Regular
                     */

                    @SerializedName("variant_detail_id")
                    private int variantDetailId;
                    @SerializedName("variant_detail_variant_id")
                    private int variantDetailVariantId;
                    @SerializedName("variant_detail_item_id")
                    private int variantDetailItemId;
                    @SerializedName("variant_detail_name")
                    private String variantDetailName;
                    @SerializedName("variant_detail_harga_modal")
                    private String variantDetailHargaModal;
                    @SerializedName("variant_detail_harga_jual")
                    private String variantDetailHargaJual;
                    @SerializedName("variant_detail_amount")
                    private String variantDetailAmount;
                    @SerializedName("variant_detail_is_inventory")
                    private int variantDetailIsInventory;
                    @SerializedName("detail_name_txt")
                    private String detailNameTxt;

                    public int getVariantDetailId() {
                        return variantDetailId;
                    }

                    public void setVariantDetailId(int variantDetailId) {
                        this.variantDetailId = variantDetailId;
                    }

                    public int getVariantDetailVariantId() {
                        return variantDetailVariantId;
                    }

                    public void setVariantDetailVariantId(int variantDetailVariantId) {
                        this.variantDetailVariantId = variantDetailVariantId;
                    }

                    public int getVariantDetailItemId() {
                        return variantDetailItemId;
                    }

                    public void setVariantDetailItemId(int variantDetailItemId) {
                        this.variantDetailItemId = variantDetailItemId;
                    }

                    public String getVariantDetailName() {
                        return variantDetailName;
                    }

                    public void setVariantDetailName(String variantDetailName) {
                        this.variantDetailName = variantDetailName;
                    }

                    public String getVariantDetailHargaModal() {
                        return variantDetailHargaModal;
                    }

                    public void setVariantDetailHargaModal(String variantDetailHargaModal) {
                        this.variantDetailHargaModal = variantDetailHargaModal;
                    }

                    public String getVariantDetailHargaJual() {
                        return variantDetailHargaJual;
                    }

                    public void setVariantDetailHargaJual(String variantDetailHargaJual) {
                        this.variantDetailHargaJual = variantDetailHargaJual;
                    }

                    public String getVariantDetailAmount() {
                        return variantDetailAmount;
                    }

                    public void setVariantDetailAmount(String variantDetailAmount) {
                        this.variantDetailAmount = variantDetailAmount;
                    }

                    public int getVariantDetailIsInventory() {
                        return variantDetailIsInventory;
                    }

                    public void setVariantDetailIsInventory(int variantDetailIsInventory) {
                        this.variantDetailIsInventory = variantDetailIsInventory;
                    }

                    public String getDetailNameTxt() {
                        return detailNameTxt;
                    }

                    public void setDetailNameTxt(String detailNameTxt) {
                        this.detailNameTxt = detailNameTxt;
                    }
                }
            }
        }
    }
}
