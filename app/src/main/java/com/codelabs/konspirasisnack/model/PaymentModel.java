package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentModel {
    /**
     * DATA : {"trans_id":930,"trans_code":"IN34722831410","trans_merchant_id":5,"trans_outlet_id":8,"trans_customer_id":14,"trans_table_id":0,"trans_reservation_id":0,"trans_subtotal":"46400.00","trans_tax_type":"v","trans_tax_value":"4640.00","trans_tax_percentage":"10.00","trans_discount_type":"v","trans_discount_value":"0.00","trans_total":"51040.00","trans_total_pay":"55000.00","trans_exchange":"3960.00","trans_service_charge":"0.00","trans_service_percentage":"0.00","trans_additional_fee":"0.00","trans_total_guest":1,"trans_payment_method_id":1,"trans_sessid":"","trans_cashier_id":248,"trans_created_by":8,"trans_updated_by":8,"trans_date":"2020-05-05 12:39:10","trans_paid_date":"2020-05-05 12:40:35","trans_info":"","trans_order_type":2,"trans_status":3,"created_at":"2020-05-05 12:39:10","updated_at":"2020-05-05 12:40:35","outlet":{"ot_id":8,"ot_merchant_id":5,"ot_manager_u_id":9,"ot_name":"Warung ucok 1","ot_address":"Jl. in aja dulu kalo cocok lanjut","ot_address_alt":"","outlet_country_id":1,"outlet_province_id":36,"outlet_city_id":3671,"outlet_zip_code":"","ot_phone_no":"08123456","ot_email":"warungucok@mail.co","ot_phone_no_alt":"","ot_mobile_no":"0832422153242","ot_mobile_no_alt":"","ot_fax_no":"","ot_fax_no_alt":"","ot_social_media":{"facebook":"https://facebook.com","instagram":"https://instagram.com","twitter":"https://twitter.com","youtube":"https://youtube.coms"},"ot_image_url":"http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/logo/8/c65531e6b445e989fde6ec71fec34e37.jpg","ot_logo_struk":"http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/struk/8/93e256bef189374c7b0f60f689a20786.png","ot_is_active":1,"ot_expired_at":"","created_at":"2020-02-07 10:55:44","updated_at":"2020-04-21 13:12:55"},"status_txt":"Selesai","cashier_name":"Lastri","order_type_name":"Bungkus","payment_method_name":"Tunai","customer_name":"Ricky Mania","customer":{"cust_id":14,"cust_merchant_id":5,"cust_outlet_id":8,"cust_group_id":2,"cust_code":"ITM090320V50EI","cust_fullname":"Ricky Mania","cust_gender":"female","cust_dob":"","cust_email":"","cust_phone":"08422555","cust_address":"Malioboro","cust_city":0,"cust_total_point":1000,"cust_info":"","cust_created_by":8,"cust_updated_by":0,"cust_is_active":1,"created_at":"2020-03-09 14:02:25","updated_at":"2020-03-09 14:02:25"},"table":{"table_id":0},"transaction_items":[{"tr_item_transaction_id":930,"tr_item_id":20,"tr_item_variant_id":0,"tr_item_actual_price":"12800.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_service_charge":"0.00","tr_item_total_price":"12800.00","tr_item_harga_modal":"10000.00","tr_item_harga_modal_total":"10000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","tr_item_harga_jual_actual":"12800","detail_item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-03-03 15:51:36","deleted_at":""},"variants":[{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":14,"tr_variant_actual_price":"10000.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"10000.00","tr_variant_harga_modal":"6000.00","tr_variant_harga_modal_total":"6000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":14,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Jumbo","variant_detail_harga_modal":"6000.00","variant_detail_harga_jual":"10000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Jumbo"}},{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":15,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":15,"variant_detail_variant_id":4,"variant_detail_item_id":0,"variant_detail_name":"Gula Setengah","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Gula Setengah"}}]},{"tr_item_transaction_id":930,"tr_item_id":21,"tr_item_variant_id":0,"tr_item_actual_price":"17600.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_service_charge":"0.00","tr_item_total_price":"17600.00","tr_item_harga_modal":"14000.00","tr_item_harga_modal_total":"14000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","tr_item_harga_jual_actual":"17600","detail_item":{"item_id":21,"item_merchant_id":5,"item_category_id":6,"item_unit_id":10,"item_name":"Es Kopi Pandan","item_description":"","item_sku":"EKP012341","item_image":"b58f4224012845d2c75f82cdea2eb151.jpg","item_is_favorite":1,"item_harga_modal":"14000.00","item_harga_jual":"22000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"10.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 13:32:19","updated_at":"2020-02-18 12:08:36","deleted_at":""},"variants":[{"tr_variant_transaction_id":930,"tr_variant_item_id":21,"tr_variant_variant_id":13,"tr_variant_actual_price":"6000.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"6000.00","tr_variant_harga_modal":"4000.00","tr_variant_harga_modal_total":"4000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":13,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Large","variant_detail_harga_modal":"4000.00","variant_detail_harga_jual":"6000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Large"}}]}]}
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
         * trans_id : 930
         * trans_code : IN34722831410
         * trans_merchant_id : 5
         * trans_outlet_id : 8
         * trans_customer_id : 14
         * trans_table_id : 0
         * trans_reservation_id : 0
         * trans_subtotal : 46400.00
         * trans_tax_type : v
         * trans_tax_value : 4640.00
         * trans_tax_percentage : 10.00
         * trans_discount_type : v
         * trans_discount_value : 0.00
         * trans_total : 51040.00
         * trans_total_pay : 55000.00
         * trans_exchange : 3960.00
         * trans_service_charge : 0.00
         * trans_service_percentage : 0.00
         * trans_additional_fee : 0.00
         * trans_total_guest : 1
         * trans_payment_method_id : 1
         * trans_sessid :
         * trans_cashier_id : 248
         * trans_created_by : 8
         * trans_updated_by : 8
         * trans_date : 2020-05-05 12:39:10
         * trans_paid_date : 2020-05-05 12:40:35
         * trans_info :
         * trans_order_type : 2
         * trans_status : 3
         * created_at : 2020-05-05 12:39:10
         * updated_at : 2020-05-05 12:40:35
         * outlet : {"ot_id":8,"ot_merchant_id":5,"ot_manager_u_id":9,"ot_name":"Warung ucok 1","ot_address":"Jl. in aja dulu kalo cocok lanjut","ot_address_alt":"","outlet_country_id":1,"outlet_province_id":36,"outlet_city_id":3671,"outlet_zip_code":"","ot_phone_no":"08123456","ot_email":"warungucok@mail.co","ot_phone_no_alt":"","ot_mobile_no":"0832422153242","ot_mobile_no_alt":"","ot_fax_no":"","ot_fax_no_alt":"","ot_social_media":{"facebook":"https://facebook.com","instagram":"https://instagram.com","twitter":"https://twitter.com","youtube":"https://youtube.coms"},"ot_image_url":"http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/logo/8/c65531e6b445e989fde6ec71fec34e37.jpg","ot_logo_struk":"http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/struk/8/93e256bef189374c7b0f60f689a20786.png","ot_is_active":1,"ot_expired_at":"","created_at":"2020-02-07 10:55:44","updated_at":"2020-04-21 13:12:55"}
         * status_txt : Selesai
         * cashier_name : Lastri
         * order_type_name : Bungkus
         * payment_method_name : Tunai
         * customer_name : Ricky Mania
         * customer : {"cust_id":14,"cust_merchant_id":5,"cust_outlet_id":8,"cust_group_id":2,"cust_code":"ITM090320V50EI","cust_fullname":"Ricky Mania","cust_gender":"female","cust_dob":"","cust_email":"","cust_phone":"08422555","cust_address":"Malioboro","cust_city":0,"cust_total_point":1000,"cust_info":"","cust_created_by":8,"cust_updated_by":0,"cust_is_active":1,"created_at":"2020-03-09 14:02:25","updated_at":"2020-03-09 14:02:25"}
         * table : {"table_id":0}
         * transaction_items : [{"tr_item_transaction_id":930,"tr_item_id":20,"tr_item_variant_id":0,"tr_item_actual_price":"12800.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_service_charge":"0.00","tr_item_total_price":"12800.00","tr_item_harga_modal":"10000.00","tr_item_harga_modal_total":"10000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","tr_item_harga_jual_actual":"12800","detail_item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-03-03 15:51:36","deleted_at":""},"variants":[{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":14,"tr_variant_actual_price":"10000.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"10000.00","tr_variant_harga_modal":"6000.00","tr_variant_harga_modal_total":"6000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":14,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Jumbo","variant_detail_harga_modal":"6000.00","variant_detail_harga_jual":"10000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Jumbo"}},{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":15,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":15,"variant_detail_variant_id":4,"variant_detail_item_id":0,"variant_detail_name":"Gula Setengah","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Gula Setengah"}}]},{"tr_item_transaction_id":930,"tr_item_id":21,"tr_item_variant_id":0,"tr_item_actual_price":"17600.00","tr_item_qty":"1.00","tr_item_additional_price":"0.00","tr_item_service_charge":"0.00","tr_item_total_price":"17600.00","tr_item_harga_modal":"14000.00","tr_item_harga_modal_total":"14000.00","tr_item_tax_type":"p","tr_item_tax_value":"0.00","tr_item_discount_type":"p","tr_item_discount_value":"0.00","tr_item_info":"","tr_item_harga_jual_actual":"17600","detail_item":{"item_id":21,"item_merchant_id":5,"item_category_id":6,"item_unit_id":10,"item_name":"Es Kopi Pandan","item_description":"","item_sku":"EKP012341","item_image":"b58f4224012845d2c75f82cdea2eb151.jpg","item_is_favorite":1,"item_harga_modal":"14000.00","item_harga_jual":"22000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"10.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 13:32:19","updated_at":"2020-02-18 12:08:36","deleted_at":""},"variants":[{"tr_variant_transaction_id":930,"tr_variant_item_id":21,"tr_variant_variant_id":13,"tr_variant_actual_price":"6000.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"6000.00","tr_variant_harga_modal":"4000.00","tr_variant_harga_modal_total":"4000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":13,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Large","variant_detail_harga_modal":"4000.00","variant_detail_harga_jual":"6000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Large"}}]}]
         */

        @SerializedName("trans_id")
        private int transId;
        @SerializedName("trans_code")
        private String transCode;
        @SerializedName("trans_merchant_id")
        private int transMerchantId;
        @SerializedName("trans_outlet_id")
        private int transOutletId;
        @SerializedName("trans_customer_id")
        private int transCustomerId;
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
        private String transTaxPercentage;
        @SerializedName("trans_discount_type")
        private String transDiscountType;
        @SerializedName("trans_discount_value")
        private String transDiscountValue;
        @SerializedName("trans_total")
        private String transTotal;
        @SerializedName("trans_total_pay")
        private String transTotalPay;
        @SerializedName("trans_exchange")
        private String transExchange;
        @SerializedName("trans_service_charge")
        private String transServiceCharge;
        @SerializedName("trans_service_percentage")
        private String transServicePercentage;
        @SerializedName("trans_additional_fee")
        private String transAdditionalFee;
        @SerializedName("trans_total_guest")
        private int transTotalGuest;
        @SerializedName("trans_payment_method_id")
        private int transPaymentMethodId;
        @SerializedName("trans_sessid")
        private String transSessid;
        @SerializedName("trans_cashier_id")
        private int transCashierId;
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
        @SerializedName("trans_status")
        private int transStatus;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("outlet")
        private Outlet outlet;
        @SerializedName("status_txt")
        private String statusTxt;
        @SerializedName("cashier_name")
        private String cashierName;
        @SerializedName("order_type_name")
        private String orderTypeName;
        @SerializedName("payment_method_name")
        private String paymentMethodName;
        @SerializedName("customer_name")
        private String customerName;
        @SerializedName("customer")
        private Customer customer;
        @SerializedName("table")
        private Table table;
        @SerializedName("transaction_items")
        private List<TransactionItems> transactionItems;

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

        public int getTransOutletId() {
            return transOutletId;
        }

        public void setTransOutletId(int transOutletId) {
            this.transOutletId = transOutletId;
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

        public String getTransTaxPercentage() {
            return transTaxPercentage;
        }

        public void setTransTaxPercentage(String transTaxPercentage) {
            this.transTaxPercentage = transTaxPercentage;
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

        public String getTransTotalPay() {
            return transTotalPay;
        }

        public void setTransTotalPay(String transTotalPay) {
            this.transTotalPay = transTotalPay;
        }

        public String getTransExchange() {
            return transExchange;
        }

        public void setTransExchange(String transExchange) {
            this.transExchange = transExchange;
        }

        public String getTransServiceCharge() {
            return transServiceCharge;
        }

        public void setTransServiceCharge(String transServiceCharge) {
            this.transServiceCharge = transServiceCharge;
        }

        public String getTransServicePercentage() {
            return transServicePercentage;
        }

        public void setTransServicePercentage(String transServicePercentage) {
            this.transServicePercentage = transServicePercentage;
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

        public void setTransOrderType(int transOrderType) {
            this.transOrderType = transOrderType;
        }

        public int getTransStatus() {
            return transStatus;
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

        public Outlet getOutlet() {
            return outlet;
        }

        public void setOutlet(Outlet outlet) {
            this.outlet = outlet;
        }

        public String getStatusTxt() {
            return statusTxt;
        }

        public void setStatusTxt(String statusTxt) {
            this.statusTxt = statusTxt;
        }

        public String getCashierName() {
            return cashierName;
        }

        public void setCashierName(String cashierName) {
            this.cashierName = cashierName;
        }

        public String getOrderTypeName() {
            return orderTypeName;
        }

        public void setOrderTypeName(String orderTypeName) {
            this.orderTypeName = orderTypeName;
        }

        public String getPaymentMethodName() {
            return paymentMethodName;
        }

        public void setPaymentMethodName(String paymentMethodName) {
            this.paymentMethodName = paymentMethodName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Table getTable() {
            return table;
        }

        public void setTable(Table table) {
            this.table = table;
        }

        public List<TransactionItems> getTransactionItems() {
            return transactionItems;
        }

        public void setTransactionItems(List<TransactionItems> transactionItems) {
            this.transactionItems = transactionItems;
        }

        public static class Outlet {
            /**
             * ot_id : 8
             * ot_merchant_id : 5
             * ot_manager_u_id : 9
             * ot_name : Warung ucok 1
             * ot_address : Jl. in aja dulu kalo cocok lanjut
             * ot_address_alt :
             * outlet_country_id : 1
             * outlet_province_id : 36
             * outlet_city_id : 3671
             * outlet_zip_code :
             * ot_phone_no : 08123456
             * ot_email : warungucok@mail.co
             * ot_phone_no_alt :
             * ot_mobile_no : 0832422153242
             * ot_mobile_no_alt :
             * ot_fax_no :
             * ot_fax_no_alt :
             * ot_social_media : {"facebook":"https://facebook.com","instagram":"https://instagram.com","twitter":"https://twitter.com","youtube":"https://youtube.coms"}
             * ot_image_url : http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/logo/8/c65531e6b445e989fde6ec71fec34e37.jpg
             * ot_logo_struk : http://159.65.14.50/pos-cl/pos-cl-backoffice/public/media/uploads/image/5/struk/8/93e256bef189374c7b0f60f689a20786.png
             * ot_is_active : 1
             * ot_expired_at :
             * created_at : 2020-02-07 10:55:44
             * updated_at : 2020-04-21 13:12:55
             */

            @SerializedName("ot_id")
            private int otId;
            @SerializedName("ot_merchant_id")
            private int otMerchantId;
            @SerializedName("ot_manager_u_id")
            private int otManagerUId;
            @SerializedName("ot_name")
            private String otName;
            @SerializedName("ot_address")
            private String otAddress;
            @SerializedName("ot_address_alt")
            private String otAddressAlt;
            @SerializedName("outlet_country_id")
            private int outletCountryId;
            @SerializedName("outlet_province_id")
            private int outletProvinceId;
            @SerializedName("outlet_city_id")
            private int outletCityId;
            @SerializedName("outlet_zip_code")
            private String outletZipCode;
            @SerializedName("ot_phone_no")
            private String otPhoneNo;
            @SerializedName("ot_email")
            private String otEmail;
            @SerializedName("ot_phone_no_alt")
            private String otPhoneNoAlt;
            @SerializedName("ot_mobile_no")
            private String otMobileNo;
            @SerializedName("ot_mobile_no_alt")
            private String otMobileNoAlt;
            @SerializedName("ot_fax_no")
            private String otFaxNo;
            @SerializedName("ot_fax_no_alt")
            private String otFaxNoAlt;
            @SerializedName("ot_social_media")
            private OtSocialMedia otSocialMedia;
            @SerializedName("ot_image_url")
            private String otImageUrl;
            @SerializedName("ot_logo_struk")
            private String otLogoStruk;
            @SerializedName("ot_is_active")
            private int otIsActive;
            @SerializedName("ot_expired_at")
            private String otExpiredAt;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getOtId() {
                return otId;
            }

            public void setOtId(int otId) {
                this.otId = otId;
            }

            public int getOtMerchantId() {
                return otMerchantId;
            }

            public void setOtMerchantId(int otMerchantId) {
                this.otMerchantId = otMerchantId;
            }

            public int getOtManagerUId() {
                return otManagerUId;
            }

            public void setOtManagerUId(int otManagerUId) {
                this.otManagerUId = otManagerUId;
            }

            public String getOtName() {
                return otName;
            }

            public void setOtName(String otName) {
                this.otName = otName;
            }

            public String getOtAddress() {
                return otAddress;
            }

            public void setOtAddress(String otAddress) {
                this.otAddress = otAddress;
            }

            public String getOtAddressAlt() {
                return otAddressAlt;
            }

            public void setOtAddressAlt(String otAddressAlt) {
                this.otAddressAlt = otAddressAlt;
            }

            public int getOutletCountryId() {
                return outletCountryId;
            }

            public void setOutletCountryId(int outletCountryId) {
                this.outletCountryId = outletCountryId;
            }

            public int getOutletProvinceId() {
                return outletProvinceId;
            }

            public void setOutletProvinceId(int outletProvinceId) {
                this.outletProvinceId = outletProvinceId;
            }

            public int getOutletCityId() {
                return outletCityId;
            }

            public void setOutletCityId(int outletCityId) {
                this.outletCityId = outletCityId;
            }

            public String getOutletZipCode() {
                return outletZipCode;
            }

            public void setOutletZipCode(String outletZipCode) {
                this.outletZipCode = outletZipCode;
            }

            public String getOtPhoneNo() {
                return otPhoneNo;
            }

            public void setOtPhoneNo(String otPhoneNo) {
                this.otPhoneNo = otPhoneNo;
            }

            public String getOtEmail() {
                return otEmail;
            }

            public void setOtEmail(String otEmail) {
                this.otEmail = otEmail;
            }

            public String getOtPhoneNoAlt() {
                return otPhoneNoAlt;
            }

            public void setOtPhoneNoAlt(String otPhoneNoAlt) {
                this.otPhoneNoAlt = otPhoneNoAlt;
            }

            public String getOtMobileNo() {
                return otMobileNo;
            }

            public void setOtMobileNo(String otMobileNo) {
                this.otMobileNo = otMobileNo;
            }

            public String getOtMobileNoAlt() {
                return otMobileNoAlt;
            }

            public void setOtMobileNoAlt(String otMobileNoAlt) {
                this.otMobileNoAlt = otMobileNoAlt;
            }

            public String getOtFaxNo() {
                return otFaxNo;
            }

            public void setOtFaxNo(String otFaxNo) {
                this.otFaxNo = otFaxNo;
            }

            public String getOtFaxNoAlt() {
                return otFaxNoAlt;
            }

            public void setOtFaxNoAlt(String otFaxNoAlt) {
                this.otFaxNoAlt = otFaxNoAlt;
            }

            public OtSocialMedia getOtSocialMedia() {
                return otSocialMedia;
            }

            public void setOtSocialMedia(OtSocialMedia otSocialMedia) {
                this.otSocialMedia = otSocialMedia;
            }

            public String getOtImageUrl() {
                return otImageUrl;
            }

            public void setOtImageUrl(String otImageUrl) {
                this.otImageUrl = otImageUrl;
            }

            public String getOtLogoStruk() {
                return otLogoStruk;
            }

            public void setOtLogoStruk(String otLogoStruk) {
                this.otLogoStruk = otLogoStruk;
            }

            public int getOtIsActive() {
                return otIsActive;
            }

            public void setOtIsActive(int otIsActive) {
                this.otIsActive = otIsActive;
            }

            public String getOtExpiredAt() {
                return otExpiredAt;
            }

            public void setOtExpiredAt(String otExpiredAt) {
                this.otExpiredAt = otExpiredAt;
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

            public static class OtSocialMedia {
                /**
                 * facebook : https://facebook.com
                 * instagram : https://instagram.com
                 * twitter : https://twitter.com
                 * youtube : https://youtube.coms
                 */

                @SerializedName("facebook")
                private String facebook;
                @SerializedName("instagram")
                private String instagram;
                @SerializedName("twitter")
                private String twitter;
                @SerializedName("youtube")
                private String youtube;

                public String getFacebook() {
                    return facebook;
                }

                public void setFacebook(String facebook) {
                    this.facebook = facebook;
                }

                public String getInstagram() {
                    return instagram;
                }

                public void setInstagram(String instagram) {
                    this.instagram = instagram;
                }

                public String getTwitter() {
                    return twitter;
                }

                public void setTwitter(String twitter) {
                    this.twitter = twitter;
                }

                public String getYoutube() {
                    return youtube;
                }

                public void setYoutube(String youtube) {
                    this.youtube = youtube;
                }
            }
        }

        public static class Customer {
            /**
             * cust_id : 14
             * cust_merchant_id : 5
             * cust_outlet_id : 8
             * cust_group_id : 2
             * cust_code : ITM090320V50EI
             * cust_fullname : Ricky Mania
             * cust_gender : female
             * cust_dob :
             * cust_email :
             * cust_phone : 08422555
             * cust_address : Malioboro
             * cust_city : 0
             * cust_total_point : 1000
             * cust_info :
             * cust_created_by : 8
             * cust_updated_by : 0
             * cust_is_active : 1
             * created_at : 2020-03-09 14:02:25
             * updated_at : 2020-03-09 14:02:25
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

        public static class Table {
            /**
             * table_id : 0
             */

            @SerializedName("table_id")
            private int tableId;

            public int getTableId() {
                return tableId;
            }

            public void setTableId(int tableId) {
                this.tableId = tableId;
            }
        }

        public static class TransactionItems {
            /**
             * tr_item_transaction_id : 930
             * tr_item_id : 20
             * tr_item_variant_id : 0
             * tr_item_actual_price : 12800.00
             * tr_item_qty : 1.00
             * tr_item_additional_price : 0.00
             * tr_item_service_charge : 0.00
             * tr_item_total_price : 12800.00
             * tr_item_harga_modal : 10000.00
             * tr_item_harga_modal_total : 10000.00
             * tr_item_tax_type : p
             * tr_item_tax_value : 0.00
             * tr_item_discount_type : p
             * tr_item_discount_value : 0.00
             * tr_item_info :
             * tr_item_harga_jual_actual : 12800
             * detail_item : {"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-03-03 15:51:36","deleted_at":""}
             * variants : [{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":14,"tr_variant_actual_price":"10000.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"10000.00","tr_variant_harga_modal":"6000.00","tr_variant_harga_modal_total":"6000.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":14,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Jumbo","variant_detail_harga_modal":"6000.00","variant_detail_harga_jual":"10000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Jumbo"}},{"tr_variant_transaction_id":930,"tr_variant_item_id":20,"tr_variant_variant_id":15,"tr_variant_actual_price":"0.00","tr_variant_qty":"1.00","tr_variant_additional_price":"0.00","tr_variant_total_price":"0.00","tr_variant_harga_modal":"0.00","tr_variant_harga_modal_total":"0.00","tr_variant_tax_type":"p","tr_variant_tax_value":"0.00","tr_variant_discount_type":"p","tr_variant_discount_value":"0.00","tr_variant_info":"","item":{"variant_detail_id":15,"variant_detail_variant_id":4,"variant_detail_item_id":0,"variant_detail_name":"Gula Setengah","variant_detail_harga_modal":"0.00","variant_detail_harga_jual":"0.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Gula Setengah"}}]
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
            private String tr_item_outlet_id;
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
            private String trItemServiceCharge;
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
            private String trItemHargaJualActual;
            @SerializedName("detail_item")
            private DetailItem detailItem;
            @SerializedName("variants")
            private List<Variants> variants;

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

            public String getTr_item_outlet_id() {
                return tr_item_outlet_id;
            }

            public void setTr_item_outlet_id(String tr_item_outlet_id) {
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

            public String getTr_item_image() {
                return tr_item_image;
            }

            public void setTr_item_image(String tr_item_image) {
                this.tr_item_image = tr_item_image;
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

            public String getTrItemServiceCharge() {
                return trItemServiceCharge;
            }

            public void setTrItemServiceCharge(String trItemServiceCharge) {
                this.trItemServiceCharge = trItemServiceCharge;
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

            public String getTrItemHargaJualActual() {
                return trItemHargaJualActual;
            }

            public void setTrItemHargaJualActual(String trItemHargaJualActual) {
                this.trItemHargaJualActual = trItemHargaJualActual;
            }

            public DetailItem getDetailItem() {
                return detailItem;
            }

            public void setDetailItem(DetailItem detailItem) {
                this.detailItem = detailItem;
            }

            public List<Variants> getVariants() {
                return variants;
            }

            public void setVariants(List<Variants> variants) {
                this.variants = variants;
            }

            public static class DetailItem {
                /**
                 * item_id : 20
                 * item_merchant_id : 5
                 * item_category_id : 6
                 * item_unit_id : 0
                 * item_name : Es Kopi Kekinian
                 * item_description :
                 * item_sku : ES0101012
                 * item_image : d5217495884602661d8aed69a644cc10.jpg
                 * item_is_favorite : 1
                 * item_harga_modal : 10000.00
                 * item_harga_jual : 16000.00
                 * item_minimum_price : 0.00
                 * item_is_parent : 0
                 * item_parent_id : 0
                 * item_is_cashier_on : 1
                 * item_is_changeable_price : 0
                 * item_stock_alert_at : 40.00
                 * item_type : 1
                 * item_is_disposable : 0
                 * item_created_by : 9
                 * item_updated_by : 9
                 * item_is_active : 0
                 * created_at : 2020-02-07 11:05:29
                 * updated_at : 2020-03-03 15:51:36
                 * deleted_at :
                 */

                @SerializedName("item_id")
                private int itemId;
                @SerializedName("item_merchant_id")
                private int itemMerchantId;
                @SerializedName("item_category_id")
                private int itemCategoryId;
                @SerializedName("item_unit_id")
                private int itemUnitId;
                @SerializedName("item_name")
                private String itemName;
                @SerializedName("item_description")
                private String itemDescription;
                @SerializedName("item_sku")
                private String itemSku;
                @SerializedName("item_image")
                private String itemImage;
                @SerializedName("item_is_favorite")
                private int itemIsFavorite;
                @SerializedName("item_harga_modal")
                private String itemHargaModal;
                @SerializedName("item_harga_jual")
                private String itemHargaJual;
                @SerializedName("item_minimum_price")
                private String itemMinimumPrice;
                @SerializedName("item_is_parent")
                private int itemIsParent;
                @SerializedName("item_parent_id")
                private int itemParentId;
                @SerializedName("item_is_cashier_on")
                private int itemIsCashierOn;
                @SerializedName("item_is_changeable_price")
                private int itemIsChangeablePrice;
                @SerializedName("item_stock_alert_at")
                private String itemStockAlertAt;
                @SerializedName("item_type")
                private int itemType;
                @SerializedName("item_is_disposable")
                private int itemIsDisposable;
                @SerializedName("item_created_by")
                private int itemCreatedBy;
                @SerializedName("item_updated_by")
                private int itemUpdatedBy;
                @SerializedName("item_is_active")
                private int itemIsActive;
                @SerializedName("created_at")
                private String createdAt;
                @SerializedName("updated_at")
                private String updatedAt;
                @SerializedName("deleted_at")
                private String deletedAt;

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public int getItemMerchantId() {
                    return itemMerchantId;
                }

                public void setItemMerchantId(int itemMerchantId) {
                    this.itemMerchantId = itemMerchantId;
                }

                public int getItemCategoryId() {
                    return itemCategoryId;
                }

                public void setItemCategoryId(int itemCategoryId) {
                    this.itemCategoryId = itemCategoryId;
                }

                public int getItemUnitId() {
                    return itemUnitId;
                }

                public void setItemUnitId(int itemUnitId) {
                    this.itemUnitId = itemUnitId;
                }

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public String getItemDescription() {
                    return itemDescription;
                }

                public void setItemDescription(String itemDescription) {
                    this.itemDescription = itemDescription;
                }

                public String getItemSku() {
                    return itemSku;
                }

                public void setItemSku(String itemSku) {
                    this.itemSku = itemSku;
                }

                public String getItemImage() {
                    return itemImage;
                }

                public void setItemImage(String itemImage) {
                    this.itemImage = itemImage;
                }

                public int getItemIsFavorite() {
                    return itemIsFavorite;
                }

                public void setItemIsFavorite(int itemIsFavorite) {
                    this.itemIsFavorite = itemIsFavorite;
                }

                public String getItemHargaModal() {
                    return itemHargaModal;
                }

                public void setItemHargaModal(String itemHargaModal) {
                    this.itemHargaModal = itemHargaModal;
                }

                public String getItemHargaJual() {
                    return itemHargaJual;
                }

                public void setItemHargaJual(String itemHargaJual) {
                    this.itemHargaJual = itemHargaJual;
                }

                public String getItemMinimumPrice() {
                    return itemMinimumPrice;
                }

                public void setItemMinimumPrice(String itemMinimumPrice) {
                    this.itemMinimumPrice = itemMinimumPrice;
                }

                public int getItemIsParent() {
                    return itemIsParent;
                }

                public void setItemIsParent(int itemIsParent) {
                    this.itemIsParent = itemIsParent;
                }

                public int getItemParentId() {
                    return itemParentId;
                }

                public void setItemParentId(int itemParentId) {
                    this.itemParentId = itemParentId;
                }

                public int getItemIsCashierOn() {
                    return itemIsCashierOn;
                }

                public void setItemIsCashierOn(int itemIsCashierOn) {
                    this.itemIsCashierOn = itemIsCashierOn;
                }

                public int getItemIsChangeablePrice() {
                    return itemIsChangeablePrice;
                }

                public void setItemIsChangeablePrice(int itemIsChangeablePrice) {
                    this.itemIsChangeablePrice = itemIsChangeablePrice;
                }

                public String getItemStockAlertAt() {
                    return itemStockAlertAt;
                }

                public void setItemStockAlertAt(String itemStockAlertAt) {
                    this.itemStockAlertAt = itemStockAlertAt;
                }

                public int getItemType() {
                    return itemType;
                }

                public void setItemType(int itemType) {
                    this.itemType = itemType;
                }

                public int getItemIsDisposable() {
                    return itemIsDisposable;
                }

                public void setItemIsDisposable(int itemIsDisposable) {
                    this.itemIsDisposable = itemIsDisposable;
                }

                public int getItemCreatedBy() {
                    return itemCreatedBy;
                }

                public void setItemCreatedBy(int itemCreatedBy) {
                    this.itemCreatedBy = itemCreatedBy;
                }

                public int getItemUpdatedBy() {
                    return itemUpdatedBy;
                }

                public void setItemUpdatedBy(int itemUpdatedBy) {
                    this.itemUpdatedBy = itemUpdatedBy;
                }

                public int getItemIsActive() {
                    return itemIsActive;
                }

                public void setItemIsActive(int itemIsActive) {
                    this.itemIsActive = itemIsActive;
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
            }

            public static class Variants {
                /**
                 * tr_variant_transaction_id : 930
                 * tr_variant_item_id : 20
                 * tr_variant_variant_id : 14
                 * tr_variant_actual_price : 10000.00
                 * tr_variant_qty : 1.00
                 * tr_variant_additional_price : 0.00
                 * tr_variant_total_price : 10000.00
                 * tr_variant_harga_modal : 6000.00
                 * tr_variant_harga_modal_total : 6000.00
                 * tr_variant_tax_type : p
                 * tr_variant_tax_value : 0.00
                 * tr_variant_discount_type : p
                 * tr_variant_discount_value : 0.00
                 * tr_variant_info :
                 * item : {"variant_detail_id":14,"variant_detail_variant_id":5,"variant_detail_item_id":0,"variant_detail_name":"Jumbo","variant_detail_harga_modal":"6000.00","variant_detail_harga_jual":"10000.00","variant_detail_amount":"0.00","variant_detail_is_inventory":0,"detail_name_txt":"Jumbo"}
                 */

                @SerializedName("tr_variant_transaction_id")
                private int trVariantTransactionId;
                @SerializedName("tr_variant_item_id")
                private int trVariantItemId;
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
                @SerializedName("item")
                private Item item;

                public int getTrVariantTransactionId() {
                    return trVariantTransactionId;
                }

                public void setTrVariantTransactionId(int trVariantTransactionId) {
                    this.trVariantTransactionId = trVariantTransactionId;
                }

                public int getTrVariantItemId() {
                    return trVariantItemId;
                }

                public void setTrVariantItemId(int trVariantItemId) {
                    this.trVariantItemId = trVariantItemId;
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

                public Item getItem() {
                    return item;
                }

                public void setItem(Item item) {
                    this.item = item;
                }

                public static class Item {
                    /**
                     * variant_detail_id : 14
                     * variant_detail_variant_id : 5
                     * variant_detail_item_id : 0
                     * variant_detail_name : Jumbo
                     * variant_detail_harga_modal : 6000.00
                     * variant_detail_harga_jual : 10000.00
                     * variant_detail_amount : 0.00
                     * variant_detail_is_inventory : 0
                     * detail_name_txt : Jumbo
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
