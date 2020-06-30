package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderListData {

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
        @SerializedName("trans_customer_name")
        private String transCustomerName;
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
        @SerializedName("trans_discount_type")
        private String transDiscountType;
        @SerializedName("trans_discount_value")
        private String transDiscountValue;
        @SerializedName("trans_total")
        private String transTotal;
        @SerializedName("trans_service_charge")
        private String transServiceCharge;
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
        @SerializedName("status_txt")
        private String statusTxt;
        @SerializedName("trans_platform")
        private String transPlatform;
        @SerializedName("cashier_name")
        private String cashierName;
        @SerializedName("order_type_name")
        private String orderTypeName;
        @SerializedName("payment_method_name")
        private String paymentMethodName;
        @SerializedName("trans_shipping_status")
        private int transShippingStatus;
        @SerializedName("customer_name")
        private String customer_name;


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

        public String getTransCustomerName() {
            return transCustomerName;
        }

        public boolean isFromWeb() {
            return transPlatform.equalsIgnoreCase("web");
        }

        public void setTransCustomerName(String transCustomerName) {
            this.transCustomerName = transCustomerName;
        }

        public int getTransShippingStatus() {
            return transShippingStatus;
        }


        public String getTransPlatform() {
            return transPlatform;
        }

        public String getCustomer_name() {
            return customer_name;


        }
    }
}
